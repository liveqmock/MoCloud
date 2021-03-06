package org.mo.web.core.service;

import java.sql.SQLException;
import org.mo.com.console.FConsole;
import org.mo.com.data.MSqlConnect;
import org.mo.com.data.RSql;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FError;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FMap;
import org.mo.com.lang.IRelease;
import org.mo.com.lang.RBoolean;
import org.mo.com.lang.RString;
import org.mo.com.lang.reflect.FClass;
import org.mo.com.lang.reflect.FMethod;
import org.mo.com.lang.reflect.RClass;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.com.message.FErrorMessage;
import org.mo.com.message.FFatalMessage;
import org.mo.com.message.FInfoMessage;
import org.mo.com.message.FMessages;
import org.mo.com.message.FValidMessage;
import org.mo.com.message.FWarnMessage;
import org.mo.com.message.IMessage;
import org.mo.com.message.IMessageContext;
import org.mo.com.message.RMessage;
import org.mo.com.resource.IResource;
import org.mo.com.resource.RResource;
import org.mo.com.xml.FXmlNode;
import org.mo.core.aop.RAop;
import org.mo.core.aop.face.ALink;
import org.mo.core.aop.face.AProperty;
import org.mo.core.bind.IBindConsole;
import org.mo.data.logic.FLogicContext;
import org.mo.data.logic.ILogicContext;
import org.mo.eng.data.IDatabaseConsole;
import org.mo.eng.data.common.ISqlContext;
import org.mo.logic.session.FSqlSessionContext;
import org.mo.logic.session.ISqlSessionContext;
import org.mo.web.core.container.AContainer;
import org.mo.web.core.container.IWebContainerConsole;
import org.mo.web.core.container.common.FWebContainerItem;
import org.mo.web.core.message.FWebErrorMessage;
import org.mo.web.core.message.FWebLogicError;
import org.mo.web.core.message.IWebMessageConsole;
import org.mo.web.core.service.common.FServiceDescriptor;
import org.mo.web.core.service.common.FServiceMethodDescriptor;
import org.mo.web.core.service.common.FWebService;
import org.mo.web.core.service.common.FWebServiceMap;
import org.mo.web.core.service.common.XAopService;
import org.mo.web.core.session.IWebSession;
import org.mo.web.protocol.context.IWebContext;
import org.mo.web.protocol.context.IWebInput;
import org.mo.web.protocol.context.IWebOutput;

//============================================================
// <T>服务命令处理控制台。</T>
// <P>根据访问的地址，对页面服务执行分发处理。</P>
//============================================================
public class FServiceConsole
      extends FConsole
      implements
         IServiceConsole
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FServiceConsole.class);

   // 资源输出接口
   private static IResource _resource = RResource.find(FServiceConsole.class);

   // 数据检查
   public static String PTY_CHECKED = "checked";

   // 传送数据时使用编码方式
   @AProperty
   protected String _encoding;

   // 数据环境类名称
   @AProperty(name = "logic_context")
   protected String _logicContextClassName;

   // 逻辑环境类对象
   protected Class<FLogicContext> _logicContextClass;

   // 绑定控制台接口
   @ALink
   protected IBindConsole _bindConsole;

   // 数据库管理接口
   @ALink
   protected IDatabaseConsole _databaseConsole;

   // 数据表单控制台接口
   @ALink
   protected IWebContainerConsole _formConsole;

   // 结果消息控制台
   @ALink
   protected IWebMessageConsole _messageConsole;

   // 页面服务哈希集合
   protected FWebServiceMap _services = new FWebServiceMap();

   // 服务类描述器哈希集合
   @SuppressWarnings("rawtypes")
   protected FMap<Class, FServiceDescriptor> _descriptors = new FMap<Class, FServiceDescriptor>(Class.class, FServiceDescriptor.class);

   //============================================================
   // <T>构造服务命令处理控制台。</T>
   //============================================================
   public FServiceConsole(){
   }

   //============================================================
   // <T>获得字符编码的类型。</T>
   //
   // @return 字符编码
   //============================================================
   @Override
   public String encoding(){
      return _encoding;
   }

   //============================================================
   // <T>产生逻辑错误。</T>
   //
   // @param context 数据环境
   // @param name 名称
   // @param params 参数集合
   //============================================================
   public void throwError(IMessageContext context,
                          String name,
                          Object... params){
      FXmlNode xconfig = _resource.findConfig(name);
      String code = xconfig.get("code");
      String text = _resource.findDisplay(name);
      FWebErrorMessage message = new FWebErrorMessage(code, text);
      message.setParams(params);
      context.messages().push(message);
      // 检查例外
      throw new FWebLogicError();
   }

   //============================================================
   // <T>查找函数。</T>
   //
   // @param clazz 类对象
   // @param name 名称
   // @return 函数描述器
   //============================================================
   public FServiceMethodDescriptor findMethod(FClass<?> clazz,
                                              String name){
      // 查找类描述器
      FServiceDescriptor descriptor = _descriptors.find(clazz.nativeObject());
      if(descriptor == null){
         descriptor = new FServiceDescriptor(clazz.nativeObject());
         _descriptors.set(clazz.nativeObject(), descriptor);
      }
      // 查找函数描述器
      name = (name != null) ? name.toLowerCase() : "process";
      FServiceMethodDescriptor methodDescriptor = descriptor.find(name);
      if(methodDescriptor == null){
         for(FMethod method : clazz.methods(false)){
            if(name.equalsIgnoreCase(method.name())){
               methodDescriptor = new FServiceMethodDescriptor();
               methodDescriptor.setServiceDescriptor(descriptor);
               methodDescriptor.build(method.nativeObject());
               break;
            }
         }
         if(methodDescriptor != null){
            descriptor.push(name, methodDescriptor);
         }
      }
      return methodDescriptor;
   }

   //============================================================
   // <T>查找服务对象。</T>
   //
   // @param name 名称
   // @return 服务对象
   //============================================================
   public FWebService findService(String name){
      FWebService service = null;
      name = RString.nvl(name).toLowerCase();
      service = _services.find(name);
      if(service == null){
         XAopService xservice = RAop.configConsole().findNode(XAopService.NAME, name);
         if(xservice != null){
            service = new FWebService();
            if(service.construct(xservice)){
               _services.set(name, service);
            }
         }
      }
      return service;
   }

   //============================================================
   // <T>根据输出信息建立消息输出节点信息。</T>
   //
   // @param context 网络环境
   // @param output 网络输出
   //============================================================
   protected void buildMessages(IWebContext context,
                                IWebOutput output){
      FMessages messages = context.messages();
      if(!messages.isEmpty()){
         FXmlNode xoutput = output.config();
         // 清空输出内容
         xoutput.nodes().clear();
         // 创建消息集合节点
         FXmlNode xmessages = xoutput.createNode(RMessage.TagMessages);
         if(messages.hasMessage(FFatalMessage.class)){
            // 如果存在严重错误的情况
            FFatalMessage msg = messages.message(FFatalMessage.class);
            msg.saveConfig(xmessages.createNode(RMessage.TagMessage));
         }else if(messages.hasMessage(FErrorMessage.class)){
            // 如果存在逻辑错误的情况
            FErrorMessage msg = messages.message(FErrorMessage.class);
            msg.saveConfig(xmessages.createNode(RMessage.TagMessage));
         }else{
            // 如果存在校验错误的情况
            if(messages.hasMessage(FValidMessage.class)){
               FMessages msgs = messages.messages(FValidMessage.class);
               for(IMessage msg : msgs){
                  msg.saveConfig(xmessages.createNode(RMessage.TagMessage));
               }
            }
            // 如果存在警告信息的情况
            if(messages.hasMessage(FWarnMessage.class)){
               FMessages msgs = messages.messages(FWarnMessage.class);
               for(IMessage msg : msgs){
                  msg.saveConfig(xmessages.createNode(RMessage.TagMessage));
               }
            }
            // 如果存在提示信息的情况
            if(messages.hasMessage(FInfoMessage.class)){
               FMessages msgs = messages.messages(FInfoMessage.class);
               for(IMessage msg : msgs){
                  msg.saveConfig(xmessages.createNode(RMessage.TagMessage));
               }
            }
         }
      }
   }

   //============================================================
   // <T>根据名称查找实例。</T>
   //
   // @param name 名称
   // @return 实例
   //============================================================
   @Override
   public Object findInstance(String name){
      Object instance = null;
      FWebService service = findService(name);
      if(service != null){
         String face = service.face();
         if(!RString.isBlank(face)){
            instance = RAop.find(face);
            if(instance == null){
               _logger.debug(this, "execute", "Can't find service. (face={1})", face);
            }
         }
      }
      if(_logger.debugAble()){
         _logger.debug(this, "execute", "Find service. (name={1}, instance={2})", name, instance);
      }
      return instance;
   }

   //============================================================
   // <T>检查会话是否有效。</T>
   //
   // @param context 页面环境
   // @param logicContext 逻辑环境
   // @param input 输入信息
   // @param output 输出信息
   // @return 处理结果
   //============================================================
   public EResult checkSession(IWebContext context,
                               ILogicContext logicContext,
                               IWebInput input,
                               IWebOutput output){
      return EResult.Success;
   }

   //============================================================
   // <T>检查会话是否登录。</T>
   //
   // @param context 页面环境
   // @param logicContext 逻辑环境
   // @param input 输入信息
   // @param output 输出信息
   // @return 处理结果
   //============================================================
   public EResult checkLogin(IWebContext context,
                             ILogicContext logicContext,
                             IWebInput input,
                             IWebOutput output){
      IWebSession session = context.session();
      if(!session.user().isLogin()){
         // 返回用户未登录画面
         FXmlNode msgsNode = output.config().createNode("Messages");
         FXmlNode fatalNode = msgsNode.createNode("Fatal");
         fatalNode.set("type", "session.timeout");
         fatalNode.set("redirect", _messageConsole.loginWithout());
         return null;
      }
      return EResult.Success;
   }

   //============================================================
   // <T>执行后处理。</T>
   //
   // @return 处理结果
   //============================================================
   public EResult executeBefore(){
      return EResult.Success;
   }

   //============================================================
   // <T>执行后处理。</T>
   //
   // @return 处理结果
   //============================================================
   public EResult executeAfter(Object result){
      return EResult.Success;
   }

   //============================================================
   // <T>根据服务名称执行一个服务处理过程。</T>
   //
   // @param name 服务名称
   // @param context 页面环境
   // @param input 输入信息
   // @param output 输出信息
   // @retrun 处理结果
   //============================================================
   @Override
   public Object execute(String name,
                         IWebContext context,
                         IWebInput input,
                         IWebOutput output){
      // 找到服务对象的定义
      FWebService service = findService(name);
      if(service == null){
         _logger.warn(this, "execute", "not find service. (name={1}, service={1})", name, service);
         throwError(context, "error.service.notexists", name);
      }
      // 找到服务对象的实例
      Object instance = findInstance(name);
      if(instance == null){
         _logger.warn(this, "execute", "not find service method (name={1}, instance={2})", name, instance);
         throwError(context, "error.service.notexists", name);
      }
      // 找到服务对象实例对应的默认处理函数
      String action = context.parameter("action");
      if(RString.isEmpty(action)){
         action = input.get("action");
      }
      if(RString.isEmpty(action)){
         action = "process";
      }
      FServiceMethodDescriptor methodDescriptor = findMethod(service.faceClass(), action);
      if(methodDescriptor == null){
         _logger.warn(this, "execute", "Can't find method in service. (instance={1}, action={2})", instance, action);
         throwError(context, "error.method.notexists", name);
      }
      _logger.debug(this, "execute", "Process service. (name={1}, instance={2}, action={3})", name, instance, action);
      //............................................................
      // 建立数据环境
      ILogicContext logicContext = null;
      if(_logicContextClass != null){
         try{
            FLogicContext newLogicContext = _logicContextClass.newInstance();
            newLogicContext.linkDatabaseConsole(_databaseConsole);
            logicContext = newLogicContext;
         }catch(Exception e){
            throw new FFatalError(e);
         }
      }else{
         logicContext = new FLogicContext(_databaseConsole);
      }
      // 检查当前处理是否需要会话
      if(methodDescriptor.sessionRequire()){
         EResult resultCd = checkSession(context, logicContext, input, output);
         if(resultCd != EResult.Success){
            buildMessages(context, output);
            return null;
         }
      }
      // 检查当前处理是否需要登录
      if(methodDescriptor.loginRequire()){
         EResult resultCd = checkLogin(context, logicContext, input, output);
         if(resultCd != EResult.Success){
            buildMessages(context, output);
            return null;
         }
      }
      //............................................................
      // 调用函数对象
      Object result = null;
      Class<?>[] types = methodDescriptor.types();
      AContainer[] aforms = methodDescriptor.forms();
      int count = types.length;
      FWebContainerItem[] forms = new FWebContainerItem[count];
      Object[] params = new Object[count];
      Throwable exception = null;
      ISqlSessionContext sqlSessionContext = null;
      try{
         for(int n = 0; n < count; n++){
            Class<?> type = types[n];
            Object value = null;
            if(type == IWebContext.class){
               // 参数对象为网络环境对象
               value = context;
            }else if(type == ISqlContext.class){
               // 参数对象为数据环境对象
               value = logicContext;
            }else if(type == ILogicContext.class){
               // 参数对象为逻辑环境对象
               value = logicContext;
            }else if(type == ISqlSessionContext.class){
               // 参数对象为会话数据环境对象，只允许存在一个线程数据对象
               if(sqlSessionContext != null){
                  throw new FFatalError("Sel session context is invalid.");
               }
               sqlSessionContext = new FSqlSessionContext(_databaseConsole);
               value = sqlSessionContext;
            }else if(type == IWebInput.class){
               // 参数对象为网络输入对象
               value = input;
            }else if(type == IWebOutput.class){
               // 参数对象为网络输出对象
               value = output;
            }else if(type.isInterface()){
               // 参数对象为接口对象
               String className = RClass.shortName(type);
               if(className.startsWith("I") && className.endsWith("Di")){
                  // 如果为数据库对象时
                  if(sqlSessionContext == null){
                     sqlSessionContext = new FSqlSessionContext(_databaseConsole);
                  }
                  className = className.substring(1, className.length() - 2);
                  className = RClass.packageName(type) + ".impl.F" + className + "Impl";
                  MSqlConnect impl = RClass.newInstance(className);
                  impl.linkConnect(sqlSessionContext);
                  value = impl;
               }else{
                  // 如果为配置的接口对象时
                  value = RAop.find(type);
               }
            }else if(aforms[n] != null){
               // 参数对象为数据容器
               forms[n] = _formConsole.findContainer(context, aforms[n], type);
               value = forms[n].container();
               context.define(aforms[n].name(), value);
            }else{
               // 未知参数时
               Object bindObject = _bindConsole.find(type);
               if(bindObject != null){
                  value = bindObject;
               }else{
                  throw new FFatalError("Unknown param type. (type={1})", type);
               }
            }
            // 设置参数
            params[n] = value;
         }
         // 连接数据会话
         if(sqlSessionContext != null){
            sqlSessionContext.link(context.session().connectId());
         }
         // 动态调用方法
         EResult beforeResultCd = executeBefore();
         if(beforeResultCd == EResult.Success){
            result = methodDescriptor.invoke(instance, params);
            executeAfter(result);
         }
      }catch(Throwable throwable){
         exception = throwable;
         // 产生例外时，处理例外内容
         boolean isCatch = true;
         boolean isSqlException = false;
         if(throwable instanceof FError){
            FError error = (FError)throwable;
            isCatch = error.isCatch();
            if(isCatch){
               Throwable root = ((FError)throwable).rootThrowable();
               if(root instanceof SQLException){
                  isSqlException = true;
                  RSql.parseSqlException(context.messages(), root);
               }
            }
         }
         if(isCatch && !isSqlException){
            context.messages().push(new FFatalMessage(throwable));
         }
      }finally{
         // 释放所有调用参数
         for(Object param : params){
            if((param != logicContext) && (param != sqlSessionContext)){
               if(param instanceof IRelease){
                  try{
                     ((IRelease)param).release();
                  }catch(Exception e){
                     exception = e;
                  }
               }
            }
         }
         // 处理不含有线程数据库访问的情况
         if(logicContext != null){
            if(exception == null){
               logicContext.release();
            }else{
               logicContext.rollback();
            }
         }
         // 处理含有线程数据库访问的情况
         if(sqlSessionContext != null){
            if(exception == null){
               // 断开线程连接
               sqlSessionContext.unlink();
               // 分析是否提交数据库数据
               String checked = input.config().get(PTY_CHECKED);
               if(RBoolean.parse(checked)){
                  // 用户确认的情况下，只要没有错误，就提交数据。
                  sqlSessionContext.release();
               }else{
                  // 将消息加入消息列表
                  context.messages().append(sqlSessionContext.messages());
                  // 判断消息内容
                  if(context.messages().hasMessage(FWarnMessage.class)){
                     // 当存在警告时，回滚数据。
                     sqlSessionContext.rollback();
                  }else{
                     // 当不存在警告时，提交数据。
                     sqlSessionContext.release();
                  }
               }
            }else{
               // 当存在例外时，回滚所有数据
               sqlSessionContext.rollback();
            }
         }
         // 建立所有例外消息
         buildMessages(context, output);
      }
      return result;
   }

   //============================================================
   // <T>初始化配置信息。</T>
   //============================================================
   public void initializeConfig(){
      if(!RString.isEmpty(_logicContextClassName)){
         _logicContextClass = RClass.findClass(_logicContextClassName);
      }
   }

   //============================================================
   // <T>初始化监视器。</T>
   //============================================================
   public void initializeMonitor(){
   }
}
