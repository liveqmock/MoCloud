package org.mo.content.face.solution;

import org.mo.cloud.logic.system.FGcSessionInfo;

import org.mo.data.logic.ILogicContext;
import org.mo.web.core.container.AContainer;
import org.mo.web.core.face.AWebLogin;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>人员账号逻辑接口。</T>
//
// @author sunhr
// @version 150328
//============================================================
public interface IPrivateAction
{
   //============================================================
   // <T>列表页面</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   //============================================================
   @AWebLogin
   String construct(IWebContext context,
                    ILogicContext logicContext,
                    FGcSessionInfo sessionInfo,
                    @AContainer(name = "page") FProjectPage page);

   //============================================================
   // <T>详细页面</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   //============================================================
   @AWebLogin
   String detail(IWebContext context,
                 ILogicContext logicContext,
                 @AContainer(name = "page") FProjectPage page);
}
