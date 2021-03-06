package org.mo.cloud.editor.core.entity.base;

import org.mo.cloud.editor.core.entity.common.XObjectFace;
import org.mo.cloud.editor.core.entity.common.XObjectSource;
import org.mo.com.lang.FMultiString;
import org.mo.com.lang.RBoolean;
import org.mo.com.lang.RString;
import org.mo.com.lang.face.AName;
import org.mo.com.xml.EXmlConfig;
import org.mo.com.xml.FXmlNode;
import org.mo.com.xml.FXmlObject;
import org.mo.com.xml.IXmlObject;

//============================================================
// <T>数据项对象的XML节点基类。</T>
//============================================================
public abstract class XBaseEntityItem
      extends FXmlObject
      implements
         XObjectFace,
         XObjectSource
{
   // 名称定义
   public static final String NAME = "Item";

   //============================================================
   // <T>获得名称定义。</T>
   //
   // @return 名称定义
   //============================================================
   public String name(){
      return NAME;
   }

   //============================================================
   // <T>判断是否指定名称。</T>
   //
   // @param name 名称
   // @return 是否指定
   //============================================================
   public static boolean isName(String name){
      return NAME.equals(name);
   }

   //============================================================
   // <T>判断是否指定实例。</T>
   //
   // @param xobject 对象
   // @return 是否指定
   //============================================================
   public static boolean isInstance(IXmlObject xobject){
      return NAME.equals(xobject.name());
   }

   // 名称的名称定义
   public static final String PTY_NAME = "name";

   // 标签的名称定义
   public static final String PTY_LABEL = "label";

   // 有效性的名称定义
   public static final String PTY_IS_VALID = "is_valid";

   // 注释的名称定义
   public static final String PTY_NOTE = "note";

   // 服务器的名称定义
   public static final String PTY_IS_SERVER = "is_server";

   // 服务器CPP代码的名称定义
   public static final String PTY_IS_SERVER_CPP = "is_server_cpp";

   // 服务器JAVA代码的名称定义
   public static final String PTY_IS_SERVER_JAVA = "is_server_java";

   // 客户端的名称定义
   public static final String PTY_IS_CLIENT = "is_client";

   // 客户端CPP代码的名称定义
   public static final String PTY_IS_CLIENT_CPP = "is_client_cpp";

   // 客户端AS代码的名称定义
   public static final String PTY_IS_CLIENT_AS = "is_client_as";

   // 客户端CS代码的名称定义
   public static final String PTY_IS_CLIENT_CS = "is_client_cs";

   // 客户端JAVA代码的名称定义
   public static final String PTY_IS_CLIENT_JAVA = "is_client_java";

   // 类型的名称定义
   public static final String PTY_TYPE = "type";

   // 内容的名称定义
   public static final String PTY_VALUE = "value";

   // 热键的名称定义
   public static final String PTY_HOTKEY = "hotkey";

   // 类型的名称定义
   public static final String PTY_TYPE_CD = "type_cd";

   // 类型名称的名称定义
   public static final String PTY_TYPE_NAME = "type_name";

   // 集合的名称定义
   public static final String PTY_IS_COLLECTION = "is_collection";

   // 数据大小的名称定义
   public static final String PTY_DATA_SIZE = "data_size";

   // 默认值的名称定义
   public static final String PTY_DATE_DEFAULT = "date_default";

   // 属性编号的名称定义
   public static final String PTY_PROPERTY_ID = "property_id";

   // 属性分组的名称定义
   public static final String PTY_PROPERTY_GROUP = "property_group";

   // 属性名称的名称定义
   public static final String PTY_PROPERTY_NAME = "property_name";

   // 属性别称的名称定义
   public static final String PTY_PROPERTY_ALIAS = "property_alias";

   // 持久化的名称定义
   public static final String PTY_IS_PERSISTENCE = "is_persistence";

   // 系统化的名称定义
   public static final String PTY_IS_SYSTEM = "is_system";

   // 锁定的名称定义
   public static final String PTY_IS_LOCK = "is_lock";

   // 获取可的名称定义
   public static final String PTY_IS_GET = "is_get";

   // 设置可的名称定义
   public static final String PTY_IS_SET = "is_set";

   // 最小值的名称定义
   public static final String PTY_MIN_VALUE = "min_value";

   // 最大值的名称定义
   public static final String PTY_MAX_VALUE = "max_value";

   // 名称的定义
   @AName("name")
   protected String _name;

   // 标签的定义
   @AName("label")
   protected String _label;

   // 有效性的定义
   @AName("is_valid")
   protected Boolean _isValid = Boolean.FALSE;

   // 注释的定义
   @AName("note")
   protected FMultiString _note = new FMultiString();

   // 服务器的定义
   @AName("is_server")
   protected String _isServer;

   // 服务器CPP代码的定义
   @AName("is_server_cpp")
   protected String _isServerCpp;

   // 服务器JAVA代码的定义
   @AName("is_server_java")
   protected String _isServerJava;

   // 客户端的定义
   @AName("is_client")
   protected String _isClient;

   // 客户端CPP代码的定义
   @AName("is_client_cpp")
   protected String _isClientCpp;

   // 客户端AS代码的定义
   @AName("is_client_as")
   protected String _isClientAs;

   // 客户端CS代码的定义
   @AName("is_client_cs")
   protected String _isClientCs;

   // 客户端JAVA代码的定义
   @AName("is_client_java")
   protected String _isClientJava;

   // 类型的定义
   @AName("type")
   protected String _type;

   // 内容的定义
   @AName("value")
   protected String _value;

   // 热键的定义
   @AName("hotkey")
   protected String _hotkey;

   // 类型的定义
   @AName("type_cd")
   protected String _typeCd;

   // 类型名称的定义
   @AName("type_name")
   protected String _typeName;

   // 集合的定义
   @AName("is_collection")
   protected String _isCollection;

   // 数据大小的定义
   @AName("data_size")
   protected String _dataSize;

   // 默认值的定义
   @AName("date_default")
   protected String _dateDefault;

   // 属性编号的定义
   @AName("property_id")
   protected String _propertyId;

   // 属性分组的定义
   @AName("property_group")
   protected String _propertyGroup;

   // 属性名称的定义
   @AName("property_name")
   protected String _propertyName;

   // 属性别称的定义
   @AName("property_alias")
   protected String _propertyAlias;

   // 持久化的定义
   @AName("is_persistence")
   protected String _isPersistence;

   // 系统化的定义
   @AName("is_system")
   protected String _isSystem;

   // 锁定的定义
   @AName("is_lock")
   protected String _isLock;

   // 获取可的定义
   @AName("is_get")
   protected String _isGet;

   // 设置可的定义
   @AName("is_set")
   protected String _isSet;

   // 最小值的定义
   @AName("min_value")
   protected String _minValue;

   // 最大值的定义
   @AName("max_value")
   protected String _maxValue;

   //============================================================
   // <T>获得名称的内容。</T>
   //
   // @return 名称
   //============================================================
   public String getName(){
      return _name;
   }

   //============================================================
   // <T>设置名称的内容。</T>
   //
   // @param value 名称
   //============================================================
   public void setName(String value){
      _name = value;
   }

   //============================================================
   // <T>获得标签的内容。</T>
   //
   // @return 标签
   //============================================================
   public String getLabel(){
      return _label;
   }

   //============================================================
   // <T>设置标签的内容。</T>
   //
   // @param value 标签
   //============================================================
   public void setLabel(String value){
      _label = value;
   }

   //============================================================
   // <T>获得有效性的内容。</T>
   //
   // @return 有效性
   //============================================================
   public Boolean getIsValid(){
      return _isValid;
   }

   //============================================================
   // <T>设置有效性的内容。</T>
   //
   // @param value 有效性
   //============================================================
   public void setIsValid(Boolean value){
      _isValid = value;
   }

   //============================================================
   // <T>获得注释的内容。</T>
   //
   // @return 注释
   //============================================================
   public String getNote(){
      return _note.get();
   }

   //============================================================
   // <T>设置注释的内容。</T>
   //
   // @param value 注释
   //============================================================
   public void setNote(String value){
      _note.set(value);
   }

   //============================================================
   // <T>获得服务器的内容。</T>
   //
   // @return 服务器
   //============================================================
   public String getIsServer(){
      return _isServer;
   }

   //============================================================
   // <T>设置服务器的内容。</T>
   //
   // @param value 服务器
   //============================================================
   public void setIsServer(String value){
      _isServer = value;
   }

   //============================================================
   // <T>获得服务器CPP代码的内容。</T>
   //
   // @return 服务器CPP代码
   //============================================================
   public String getIsServerCpp(){
      return _isServerCpp;
   }

   //============================================================
   // <T>设置服务器CPP代码的内容。</T>
   //
   // @param value 服务器CPP代码
   //============================================================
   public void setIsServerCpp(String value){
      _isServerCpp = value;
   }

   //============================================================
   // <T>获得服务器JAVA代码的内容。</T>
   //
   // @return 服务器JAVA代码
   //============================================================
   public String getIsServerJava(){
      return _isServerJava;
   }

   //============================================================
   // <T>设置服务器JAVA代码的内容。</T>
   //
   // @param value 服务器JAVA代码
   //============================================================
   public void setIsServerJava(String value){
      _isServerJava = value;
   }

   //============================================================
   // <T>获得客户端的内容。</T>
   //
   // @return 客户端
   //============================================================
   public String getIsClient(){
      return _isClient;
   }

   //============================================================
   // <T>设置客户端的内容。</T>
   //
   // @param value 客户端
   //============================================================
   public void setIsClient(String value){
      _isClient = value;
   }

   //============================================================
   // <T>获得客户端CPP代码的内容。</T>
   //
   // @return 客户端CPP代码
   //============================================================
   public String getIsClientCpp(){
      return _isClientCpp;
   }

   //============================================================
   // <T>设置客户端CPP代码的内容。</T>
   //
   // @param value 客户端CPP代码
   //============================================================
   public void setIsClientCpp(String value){
      _isClientCpp = value;
   }

   //============================================================
   // <T>获得客户端AS代码的内容。</T>
   //
   // @return 客户端AS代码
   //============================================================
   public String getIsClientAs(){
      return _isClientAs;
   }

   //============================================================
   // <T>设置客户端AS代码的内容。</T>
   //
   // @param value 客户端AS代码
   //============================================================
   public void setIsClientAs(String value){
      _isClientAs = value;
   }

   //============================================================
   // <T>获得客户端CS代码的内容。</T>
   //
   // @return 客户端CS代码
   //============================================================
   public String getIsClientCs(){
      return _isClientCs;
   }

   //============================================================
   // <T>设置客户端CS代码的内容。</T>
   //
   // @param value 客户端CS代码
   //============================================================
   public void setIsClientCs(String value){
      _isClientCs = value;
   }

   //============================================================
   // <T>获得客户端JAVA代码的内容。</T>
   //
   // @return 客户端JAVA代码
   //============================================================
   public String getIsClientJava(){
      return _isClientJava;
   }

   //============================================================
   // <T>设置客户端JAVA代码的内容。</T>
   //
   // @param value 客户端JAVA代码
   //============================================================
   public void setIsClientJava(String value){
      _isClientJava = value;
   }

   //============================================================
   // <T>获得类型的内容。</T>
   //
   // @return 类型
   //============================================================
   public String getType(){
      return _type;
   }

   //============================================================
   // <T>设置类型的内容。</T>
   //
   // @param value 类型
   //============================================================
   public void setType(String value){
      _type = value;
   }

   //============================================================
   // <T>获得内容的内容。</T>
   //
   // @return 内容
   //============================================================
   public String getValue(){
      return _value;
   }

   //============================================================
   // <T>设置内容的内容。</T>
   //
   // @param value 内容
   //============================================================
   public void setValue(String value){
      _value = value;
   }

   //============================================================
   // <T>获得热键的内容。</T>
   //
   // @return 热键
   //============================================================
   public String getHotkey(){
      return _hotkey;
   }

   //============================================================
   // <T>设置热键的内容。</T>
   //
   // @param value 热键
   //============================================================
   public void setHotkey(String value){
      _hotkey = value;
   }

   //============================================================
   // <T>获得类型的内容。</T>
   //
   // @return 类型
   //============================================================
   public String getTypeCd(){
      return _typeCd;
   }

   //============================================================
   // <T>设置类型的内容。</T>
   //
   // @param value 类型
   //============================================================
   public void setTypeCd(String value){
      _typeCd = value;
   }

   //============================================================
   // <T>获得类型名称的内容。</T>
   //
   // @return 类型名称
   //============================================================
   public String getTypeName(){
      return _typeName;
   }

   //============================================================
   // <T>设置类型名称的内容。</T>
   //
   // @param value 类型名称
   //============================================================
   public void setTypeName(String value){
      _typeName = value;
   }

   //============================================================
   // <T>获得集合的内容。</T>
   //
   // @return 集合
   //============================================================
   public String getIsCollection(){
      return _isCollection;
   }

   //============================================================
   // <T>设置集合的内容。</T>
   //
   // @param value 集合
   //============================================================
   public void setIsCollection(String value){
      _isCollection = value;
   }

   //============================================================
   // <T>获得数据大小的内容。</T>
   //
   // @return 数据大小
   //============================================================
   public String getDataSize(){
      return _dataSize;
   }

   //============================================================
   // <T>设置数据大小的内容。</T>
   //
   // @param value 数据大小
   //============================================================
   public void setDataSize(String value){
      _dataSize = value;
   }

   //============================================================
   // <T>获得默认值的内容。</T>
   //
   // @return 默认值
   //============================================================
   public String getDateDefault(){
      return _dateDefault;
   }

   //============================================================
   // <T>设置默认值的内容。</T>
   //
   // @param value 默认值
   //============================================================
   public void setDateDefault(String value){
      _dateDefault = value;
   }

   //============================================================
   // <T>获得属性编号的内容。</T>
   //
   // @return 属性编号
   //============================================================
   public String getPropertyId(){
      return _propertyId;
   }

   //============================================================
   // <T>设置属性编号的内容。</T>
   //
   // @param value 属性编号
   //============================================================
   public void setPropertyId(String value){
      _propertyId = value;
   }

   //============================================================
   // <T>获得属性分组的内容。</T>
   //
   // @return 属性分组
   //============================================================
   public String getPropertyGroup(){
      return _propertyGroup;
   }

   //============================================================
   // <T>设置属性分组的内容。</T>
   //
   // @param value 属性分组
   //============================================================
   public void setPropertyGroup(String value){
      _propertyGroup = value;
   }

   //============================================================
   // <T>获得属性名称的内容。</T>
   //
   // @return 属性名称
   //============================================================
   public String getPropertyName(){
      return _propertyName;
   }

   //============================================================
   // <T>设置属性名称的内容。</T>
   //
   // @param value 属性名称
   //============================================================
   public void setPropertyName(String value){
      _propertyName = value;
   }

   //============================================================
   // <T>获得属性别称的内容。</T>
   //
   // @return 属性别称
   //============================================================
   public String getPropertyAlias(){
      return _propertyAlias;
   }

   //============================================================
   // <T>设置属性别称的内容。</T>
   //
   // @param value 属性别称
   //============================================================
   public void setPropertyAlias(String value){
      _propertyAlias = value;
   }

   //============================================================
   // <T>获得持久化的内容。</T>
   //
   // @return 持久化
   //============================================================
   public String getIsPersistence(){
      return _isPersistence;
   }

   //============================================================
   // <T>设置持久化的内容。</T>
   //
   // @param value 持久化
   //============================================================
   public void setIsPersistence(String value){
      _isPersistence = value;
   }

   //============================================================
   // <T>获得系统化的内容。</T>
   //
   // @return 系统化
   //============================================================
   public String getIsSystem(){
      return _isSystem;
   }

   //============================================================
   // <T>设置系统化的内容。</T>
   //
   // @param value 系统化
   //============================================================
   public void setIsSystem(String value){
      _isSystem = value;
   }

   //============================================================
   // <T>获得锁定的内容。</T>
   //
   // @return 锁定
   //============================================================
   public String getIsLock(){
      return _isLock;
   }

   //============================================================
   // <T>设置锁定的内容。</T>
   //
   // @param value 锁定
   //============================================================
   public void setIsLock(String value){
      _isLock = value;
   }

   //============================================================
   // <T>获得获取可的内容。</T>
   //
   // @return 获取可
   //============================================================
   public String getIsGet(){
      return _isGet;
   }

   //============================================================
   // <T>设置获取可的内容。</T>
   //
   // @param value 获取可
   //============================================================
   public void setIsGet(String value){
      _isGet = value;
   }

   //============================================================
   // <T>获得设置可的内容。</T>
   //
   // @return 设置可
   //============================================================
   public String getIsSet(){
      return _isSet;
   }

   //============================================================
   // <T>设置设置可的内容。</T>
   //
   // @param value 设置可
   //============================================================
   public void setIsSet(String value){
      _isSet = value;
   }

   //============================================================
   // <T>获得最小值的内容。</T>
   //
   // @return 最小值
   //============================================================
   public String getMinValue(){
      return _minValue;
   }

   //============================================================
   // <T>设置最小值的内容。</T>
   //
   // @param value 最小值
   //============================================================
   public void setMinValue(String value){
      _minValue = value;
   }

   //============================================================
   // <T>获得最大值的内容。</T>
   //
   // @return 最大值
   //============================================================
   public String getMaxValue(){
      return _maxValue;
   }

   //============================================================
   // <T>设置最大值的内容。</T>
   //
   // @param value 最大值
   //============================================================
   public void setMaxValue(String value){
      _maxValue = value;
   }

   //============================================================
   // <T>内部获得内容置信息。</T>
   //
   // @param name 名称
   // @return 内容
   //============================================================
   public String innerGet(String name){
      if(RString.isEmpty(name)){
         return null;
      }else if(PTY_NAME.equalsIgnoreCase(name)){
         return getName();
      }else if(PTY_LABEL.equalsIgnoreCase(name)){
         return getLabel();
      }else if(PTY_IS_VALID.equalsIgnoreCase(name)){
         return RBoolean.toString(getIsValid());
      }else if(PTY_NOTE.equalsIgnoreCase(name)){
         return getNote();
      }else if(PTY_IS_SERVER.equalsIgnoreCase(name)){
         return getIsServer();
      }else if(PTY_IS_SERVER_CPP.equalsIgnoreCase(name)){
         return getIsServerCpp();
      }else if(PTY_IS_SERVER_JAVA.equalsIgnoreCase(name)){
         return getIsServerJava();
      }else if(PTY_IS_CLIENT.equalsIgnoreCase(name)){
         return getIsClient();
      }else if(PTY_IS_CLIENT_CPP.equalsIgnoreCase(name)){
         return getIsClientCpp();
      }else if(PTY_IS_CLIENT_AS.equalsIgnoreCase(name)){
         return getIsClientAs();
      }else if(PTY_IS_CLIENT_CS.equalsIgnoreCase(name)){
         return getIsClientCs();
      }else if(PTY_IS_CLIENT_JAVA.equalsIgnoreCase(name)){
         return getIsClientJava();
      }else if(PTY_TYPE.equalsIgnoreCase(name)){
         return getType();
      }else if(PTY_VALUE.equalsIgnoreCase(name)){
         return getValue();
      }else if(PTY_HOTKEY.equalsIgnoreCase(name)){
         return getHotkey();
      }else if(PTY_TYPE_CD.equalsIgnoreCase(name)){
         return getTypeCd();
      }else if(PTY_TYPE_NAME.equalsIgnoreCase(name)){
         return getTypeName();
      }else if(PTY_IS_COLLECTION.equalsIgnoreCase(name)){
         return getIsCollection();
      }else if(PTY_DATA_SIZE.equalsIgnoreCase(name)){
         return getDataSize();
      }else if(PTY_DATE_DEFAULT.equalsIgnoreCase(name)){
         return getDateDefault();
      }else if(PTY_PROPERTY_ID.equalsIgnoreCase(name)){
         return getPropertyId();
      }else if(PTY_PROPERTY_GROUP.equalsIgnoreCase(name)){
         return getPropertyGroup();
      }else if(PTY_PROPERTY_NAME.equalsIgnoreCase(name)){
         return getPropertyName();
      }else if(PTY_PROPERTY_ALIAS.equalsIgnoreCase(name)){
         return getPropertyAlias();
      }else if(PTY_IS_PERSISTENCE.equalsIgnoreCase(name)){
         return getIsPersistence();
      }else if(PTY_IS_SYSTEM.equalsIgnoreCase(name)){
         return getIsSystem();
      }else if(PTY_IS_LOCK.equalsIgnoreCase(name)){
         return getIsLock();
      }else if(PTY_IS_GET.equalsIgnoreCase(name)){
         return getIsGet();
      }else if(PTY_IS_SET.equalsIgnoreCase(name)){
         return getIsSet();
      }else if(PTY_MIN_VALUE.equalsIgnoreCase(name)){
         return getMinValue();
      }else if(PTY_MAX_VALUE.equalsIgnoreCase(name)){
         return getMaxValue();
      }
      return null;
   }

   //============================================================
   // <T>内部设置内容置信息。</T>
   //
   // @param name 名称
   // @param value 内容
   //============================================================
   public void innerSet(String name,
                        String value){
      if(RString.isEmpty(name)){
         return;
      }else if(PTY_NAME.equalsIgnoreCase(name)){
         setName(value);
      }else if(PTY_LABEL.equalsIgnoreCase(name)){
         setLabel(value);
      }else if(PTY_IS_VALID.equalsIgnoreCase(name)){
         setIsValid(RBoolean.parse(value));
      }else if(PTY_NOTE.equalsIgnoreCase(name)){
         setNote(value);
      }else if(PTY_IS_SERVER.equalsIgnoreCase(name)){
         setIsServer(value);
      }else if(PTY_IS_SERVER_CPP.equalsIgnoreCase(name)){
         setIsServerCpp(value);
      }else if(PTY_IS_SERVER_JAVA.equalsIgnoreCase(name)){
         setIsServerJava(value);
      }else if(PTY_IS_CLIENT.equalsIgnoreCase(name)){
         setIsClient(value);
      }else if(PTY_IS_CLIENT_CPP.equalsIgnoreCase(name)){
         setIsClientCpp(value);
      }else if(PTY_IS_CLIENT_AS.equalsIgnoreCase(name)){
         setIsClientAs(value);
      }else if(PTY_IS_CLIENT_CS.equalsIgnoreCase(name)){
         setIsClientCs(value);
      }else if(PTY_IS_CLIENT_JAVA.equalsIgnoreCase(name)){
         setIsClientJava(value);
      }else if(PTY_TYPE.equalsIgnoreCase(name)){
         setType(value);
      }else if(PTY_VALUE.equalsIgnoreCase(name)){
         setValue(value);
      }else if(PTY_HOTKEY.equalsIgnoreCase(name)){
         setHotkey(value);
      }else if(PTY_TYPE_CD.equalsIgnoreCase(name)){
         setTypeCd(value);
      }else if(PTY_TYPE_NAME.equalsIgnoreCase(name)){
         setTypeName(value);
      }else if(PTY_IS_COLLECTION.equalsIgnoreCase(name)){
         setIsCollection(value);
      }else if(PTY_DATA_SIZE.equalsIgnoreCase(name)){
         setDataSize(value);
      }else if(PTY_DATE_DEFAULT.equalsIgnoreCase(name)){
         setDateDefault(value);
      }else if(PTY_PROPERTY_ID.equalsIgnoreCase(name)){
         setPropertyId(value);
      }else if(PTY_PROPERTY_GROUP.equalsIgnoreCase(name)){
         setPropertyGroup(value);
      }else if(PTY_PROPERTY_NAME.equalsIgnoreCase(name)){
         setPropertyName(value);
      }else if(PTY_PROPERTY_ALIAS.equalsIgnoreCase(name)){
         setPropertyAlias(value);
      }else if(PTY_IS_PERSISTENCE.equalsIgnoreCase(name)){
         setIsPersistence(value);
      }else if(PTY_IS_SYSTEM.equalsIgnoreCase(name)){
         setIsSystem(value);
      }else if(PTY_IS_LOCK.equalsIgnoreCase(name)){
         setIsLock(value);
      }else if(PTY_IS_GET.equalsIgnoreCase(name)){
         setIsGet(value);
      }else if(PTY_IS_SET.equalsIgnoreCase(name)){
         setIsSet(value);
      }else if(PTY_MIN_VALUE.equalsIgnoreCase(name)){
         setMinValue(value);
      }else if(PTY_MAX_VALUE.equalsIgnoreCase(name)){
         setMaxValue(value);
      }
   }

   //============================================================
   // <T>加载设置信息。</T>
   //
   // @param config 设置信息
   // @param type 类型
   //============================================================
   public void loadConfig(FXmlNode config,
                          EXmlConfig type){
      super.loadConfig(config, type);
      if(EXmlConfig.Full == type){
         if(config.contains("name")){
            setName(config.get(PTY_NAME));
         }
         if(config.contains("label")){
            setLabel(config.get(PTY_LABEL));
         }
         if(config.contains("is_valid")){
            setIsValid(RBoolean.parse(config.get(PTY_IS_VALID)));
         }
         if(config.contains("note")){
            _note.unpack(config.get(PTY_NOTE));
         }
         if(config.contains("is_server")){
            setIsServer(config.get(PTY_IS_SERVER));
         }
         if(config.contains("is_server_cpp")){
            setIsServerCpp(config.get(PTY_IS_SERVER_CPP));
         }
         if(config.contains("is_server_java")){
            setIsServerJava(config.get(PTY_IS_SERVER_JAVA));
         }
         if(config.contains("is_client")){
            setIsClient(config.get(PTY_IS_CLIENT));
         }
         if(config.contains("is_client_cpp")){
            setIsClientCpp(config.get(PTY_IS_CLIENT_CPP));
         }
         if(config.contains("is_client_as")){
            setIsClientAs(config.get(PTY_IS_CLIENT_AS));
         }
         if(config.contains("is_client_cs")){
            setIsClientCs(config.get(PTY_IS_CLIENT_CS));
         }
         if(config.contains("is_client_java")){
            setIsClientJava(config.get(PTY_IS_CLIENT_JAVA));
         }
         if(config.contains("type")){
            setType(config.get(PTY_TYPE));
         }
         if(config.contains("value")){
            setValue(config.get(PTY_VALUE));
         }
         if(config.contains("hotkey")){
            setHotkey(config.get(PTY_HOTKEY));
         }
         if(config.contains("type_cd")){
            setTypeCd(config.get(PTY_TYPE_CD));
         }
         if(config.contains("type_name")){
            setTypeName(config.get(PTY_TYPE_NAME));
         }
         if(config.contains("is_collection")){
            setIsCollection(config.get(PTY_IS_COLLECTION));
         }
         if(config.contains("data_size")){
            setDataSize(config.get(PTY_DATA_SIZE));
         }
         if(config.contains("date_default")){
            setDateDefault(config.get(PTY_DATE_DEFAULT));
         }
         if(config.contains("property_id")){
            setPropertyId(config.get(PTY_PROPERTY_ID));
         }
         if(config.contains("property_group")){
            setPropertyGroup(config.get(PTY_PROPERTY_GROUP));
         }
         if(config.contains("property_name")){
            setPropertyName(config.get(PTY_PROPERTY_NAME));
         }
         if(config.contains("property_alias")){
            setPropertyAlias(config.get(PTY_PROPERTY_ALIAS));
         }
         if(config.contains("is_persistence")){
            setIsPersistence(config.get(PTY_IS_PERSISTENCE));
         }
         if(config.contains("is_system")){
            setIsSystem(config.get(PTY_IS_SYSTEM));
         }
         if(config.contains("is_lock")){
            setIsLock(config.get(PTY_IS_LOCK));
         }
         if(config.contains("is_get")){
            setIsGet(config.get(PTY_IS_GET));
         }
         if(config.contains("is_set")){
            setIsSet(config.get(PTY_IS_SET));
         }
         if(config.contains("min_value")){
            setMinValue(config.get(PTY_MIN_VALUE));
         }
         if(config.contains("max_value")){
            setMaxValue(config.get(PTY_MAX_VALUE));
         }
      }else if(EXmlConfig.Simple == type){
         if(config.contains("name")){
            setName(config.get(PTY_NAME));
         }
         if(config.contains("label")){
            setLabel(config.get(PTY_LABEL));
         }
         if(config.contains("is_valid")){
            setIsValid(RBoolean.parse(config.get(PTY_IS_VALID)));
         }
         if(config.contains("note")){
            setNote(config.get(PTY_NOTE));
         }
         if(config.contains("is_server")){
            setIsServer(config.get(PTY_IS_SERVER));
         }
         if(config.contains("is_server_cpp")){
            setIsServerCpp(config.get(PTY_IS_SERVER_CPP));
         }
         if(config.contains("is_server_java")){
            setIsServerJava(config.get(PTY_IS_SERVER_JAVA));
         }
         if(config.contains("is_client")){
            setIsClient(config.get(PTY_IS_CLIENT));
         }
         if(config.contains("is_client_cpp")){
            setIsClientCpp(config.get(PTY_IS_CLIENT_CPP));
         }
         if(config.contains("is_client_as")){
            setIsClientAs(config.get(PTY_IS_CLIENT_AS));
         }
         if(config.contains("is_client_cs")){
            setIsClientCs(config.get(PTY_IS_CLIENT_CS));
         }
         if(config.contains("is_client_java")){
            setIsClientJava(config.get(PTY_IS_CLIENT_JAVA));
         }
         if(config.contains("type")){
            setType(config.get(PTY_TYPE));
         }
         if(config.contains("value")){
            setValue(config.get(PTY_VALUE));
         }
         if(config.contains("hotkey")){
            setHotkey(config.get(PTY_HOTKEY));
         }
         if(config.contains("type_cd")){
            setTypeCd(config.get(PTY_TYPE_CD));
         }
         if(config.contains("type_name")){
            setTypeName(config.get(PTY_TYPE_NAME));
         }
         if(config.contains("is_collection")){
            setIsCollection(config.get(PTY_IS_COLLECTION));
         }
         if(config.contains("data_size")){
            setDataSize(config.get(PTY_DATA_SIZE));
         }
         if(config.contains("date_default")){
            setDateDefault(config.get(PTY_DATE_DEFAULT));
         }
         if(config.contains("property_id")){
            setPropertyId(config.get(PTY_PROPERTY_ID));
         }
         if(config.contains("property_group")){
            setPropertyGroup(config.get(PTY_PROPERTY_GROUP));
         }
         if(config.contains("property_name")){
            setPropertyName(config.get(PTY_PROPERTY_NAME));
         }
         if(config.contains("property_alias")){
            setPropertyAlias(config.get(PTY_PROPERTY_ALIAS));
         }
         if(config.contains("is_persistence")){
            setIsPersistence(config.get(PTY_IS_PERSISTENCE));
         }
         if(config.contains("is_system")){
            setIsSystem(config.get(PTY_IS_SYSTEM));
         }
         if(config.contains("is_lock")){
            setIsLock(config.get(PTY_IS_LOCK));
         }
         if(config.contains("is_get")){
            setIsGet(config.get(PTY_IS_GET));
         }
         if(config.contains("is_set")){
            setIsSet(config.get(PTY_IS_SET));
         }
         if(config.contains("min_value")){
            setMinValue(config.get(PTY_MIN_VALUE));
         }
         if(config.contains("max_value")){
            setMaxValue(config.get(PTY_MAX_VALUE));
         }
      }else if(EXmlConfig.Value == type){
         if(config.contains("name")){
            setName(config.get(PTY_NAME));
         }
         if(config.contains("label")){
            setLabel(config.get(PTY_LABEL));
         }
         if(config.contains("is_valid")){
            setIsValid(RBoolean.parse(config.get(PTY_IS_VALID)));
         }
         if(config.contains("note")){
            setNote(config.get(PTY_NOTE));
         }
         if(config.contains("is_server")){
            setIsServer(config.get(PTY_IS_SERVER));
         }
         if(config.contains("is_server_cpp")){
            setIsServerCpp(config.get(PTY_IS_SERVER_CPP));
         }
         if(config.contains("is_server_java")){
            setIsServerJava(config.get(PTY_IS_SERVER_JAVA));
         }
         if(config.contains("is_client")){
            setIsClient(config.get(PTY_IS_CLIENT));
         }
         if(config.contains("is_client_cpp")){
            setIsClientCpp(config.get(PTY_IS_CLIENT_CPP));
         }
         if(config.contains("is_client_as")){
            setIsClientAs(config.get(PTY_IS_CLIENT_AS));
         }
         if(config.contains("is_client_cs")){
            setIsClientCs(config.get(PTY_IS_CLIENT_CS));
         }
         if(config.contains("is_client_java")){
            setIsClientJava(config.get(PTY_IS_CLIENT_JAVA));
         }
         if(config.contains("type")){
            setType(config.get(PTY_TYPE));
         }
         if(config.contains("value")){
            setValue(config.get(PTY_VALUE));
         }
         if(config.contains("hotkey")){
            setHotkey(config.get(PTY_HOTKEY));
         }
         if(config.contains("type_cd")){
            setTypeCd(config.get(PTY_TYPE_CD));
         }
         if(config.contains("type_name")){
            setTypeName(config.get(PTY_TYPE_NAME));
         }
         if(config.contains("is_collection")){
            setIsCollection(config.get(PTY_IS_COLLECTION));
         }
         if(config.contains("data_size")){
            setDataSize(config.get(PTY_DATA_SIZE));
         }
         if(config.contains("date_default")){
            setDateDefault(config.get(PTY_DATE_DEFAULT));
         }
         if(config.contains("property_id")){
            setPropertyId(config.get(PTY_PROPERTY_ID));
         }
         if(config.contains("property_group")){
            setPropertyGroup(config.get(PTY_PROPERTY_GROUP));
         }
         if(config.contains("property_name")){
            setPropertyName(config.get(PTY_PROPERTY_NAME));
         }
         if(config.contains("property_alias")){
            setPropertyAlias(config.get(PTY_PROPERTY_ALIAS));
         }
         if(config.contains("is_persistence")){
            setIsPersistence(config.get(PTY_IS_PERSISTENCE));
         }
         if(config.contains("is_system")){
            setIsSystem(config.get(PTY_IS_SYSTEM));
         }
         if(config.contains("is_lock")){
            setIsLock(config.get(PTY_IS_LOCK));
         }
         if(config.contains("is_get")){
            setIsGet(config.get(PTY_IS_GET));
         }
         if(config.contains("is_set")){
            setIsSet(config.get(PTY_IS_SET));
         }
         if(config.contains("min_value")){
            setMinValue(config.get(PTY_MIN_VALUE));
         }
         if(config.contains("max_value")){
            setMaxValue(config.get(PTY_MAX_VALUE));
         }
      }else if(EXmlConfig.Default == type){
         if(RString.isEmpty(getIsServer())){
            if(config.contains("is_server")){
               setIsServer(config.get(PTY_IS_SERVER));
            }
         }
         if(RString.isEmpty(getIsServerCpp())){
            if(config.contains("is_server_cpp")){
               setIsServerCpp(config.get(PTY_IS_SERVER_CPP));
            }
         }
         if(RString.isEmpty(getIsServerJava())){
            if(config.contains("is_server_java")){
               setIsServerJava(config.get(PTY_IS_SERVER_JAVA));
            }
         }
         if(RString.isEmpty(getIsClient())){
            if(config.contains("is_client")){
               setIsClient(config.get(PTY_IS_CLIENT));
            }
         }
         if(RString.isEmpty(getIsClientCpp())){
            if(config.contains("is_client_cpp")){
               setIsClientCpp(config.get(PTY_IS_CLIENT_CPP));
            }
         }
         if(RString.isEmpty(getIsClientAs())){
            if(config.contains("is_client_as")){
               setIsClientAs(config.get(PTY_IS_CLIENT_AS));
            }
         }
         if(RString.isEmpty(getIsClientCs())){
            if(config.contains("is_client_cs")){
               setIsClientCs(config.get(PTY_IS_CLIENT_CS));
            }
         }
         if(RString.isEmpty(getIsClientJava())){
            if(config.contains("is_client_java")){
               setIsClientJava(config.get(PTY_IS_CLIENT_JAVA));
            }
         }
         if(RString.isEmpty(getTypeCd())){
            if(config.contains("type_cd")){
               setTypeCd(config.get(PTY_TYPE_CD));
            }
         }
         if(RString.isEmpty(getTypeName())){
            if(config.contains("type_name")){
               setTypeName(config.get(PTY_TYPE_NAME));
            }
         }
         if(RString.isEmpty(getIsCollection())){
            if(config.contains("is_collection")){
               setIsCollection(config.get(PTY_IS_COLLECTION));
            }
         }
         if(RString.isEmpty(getDataSize())){
            if(config.contains("data_size")){
               setDataSize(config.get(PTY_DATA_SIZE));
            }
         }
         if(RString.isEmpty(getDateDefault())){
            if(config.contains("date_default")){
               setDateDefault(config.get(PTY_DATE_DEFAULT));
            }
         }
         if(RString.isEmpty(getPropertyId())){
            if(config.contains("property_id")){
               setPropertyId(config.get(PTY_PROPERTY_ID));
            }
         }
         if(RString.isEmpty(getPropertyGroup())){
            if(config.contains("property_group")){
               setPropertyGroup(config.get(PTY_PROPERTY_GROUP));
            }
         }
         if(RString.isEmpty(getPropertyName())){
            if(config.contains("property_name")){
               setPropertyName(config.get(PTY_PROPERTY_NAME));
            }
         }
         if(RString.isEmpty(getPropertyAlias())){
            if(config.contains("property_alias")){
               setPropertyAlias(config.get(PTY_PROPERTY_ALIAS));
            }
         }
         if(RString.isEmpty(getIsPersistence())){
            if(config.contains("is_persistence")){
               setIsPersistence(config.get(PTY_IS_PERSISTENCE));
            }
         }
         if(RString.isEmpty(getIsSystem())){
            if(config.contains("is_system")){
               setIsSystem(config.get(PTY_IS_SYSTEM));
            }
         }
         if(RString.isEmpty(getIsLock())){
            if(config.contains("is_lock")){
               setIsLock(config.get(PTY_IS_LOCK));
            }
         }
         if(RString.isEmpty(getIsGet())){
            if(config.contains("is_get")){
               setIsGet(config.get(PTY_IS_GET));
            }
         }
         if(RString.isEmpty(getIsSet())){
            if(config.contains("is_set")){
               setIsSet(config.get(PTY_IS_SET));
            }
         }
         if(RString.isEmpty(getMinValue())){
            if(config.contains("min_value")){
               setMinValue(config.get(PTY_MIN_VALUE));
            }
         }
         if(RString.isEmpty(getMaxValue())){
            if(config.contains("max_value")){
               setMaxValue(config.get(PTY_MAX_VALUE));
            }
         }
      }
   }

   //============================================================
   // <T>保存设置信息。</T>
   //
   // @param config 设置信息
   // @param type 类型
   //============================================================
   public void saveConfig(FXmlNode config,
                          EXmlConfig type){
      config.setName(NAME);
      super.saveConfig(config, type);
      if(EXmlConfig.Full == type){
         if(RString.isNotEmpty(getName())){
            config.set(PTY_NAME, getName());
         }
         if(RString.isNotEmpty(getLabel())){
            config.set(PTY_LABEL, getLabel());
         }
         if(RBoolean.parse(getIsValid())){
            config.set(PTY_IS_VALID, RBoolean.toString(getIsValid()));
         }
         String note = _note.pack().toString();
         if(RString.isNotEmpty(note)){
            config.set(PTY_NOTE, note);
         }
         if(RString.isNotEmpty(getIsServer())){
            config.set(PTY_IS_SERVER, getIsServer());
         }
         if(RString.isNotEmpty(getIsServerCpp())){
            config.set(PTY_IS_SERVER_CPP, getIsServerCpp());
         }
         if(RString.isNotEmpty(getIsServerJava())){
            config.set(PTY_IS_SERVER_JAVA, getIsServerJava());
         }
         if(RString.isNotEmpty(getIsClient())){
            config.set(PTY_IS_CLIENT, getIsClient());
         }
         if(RString.isNotEmpty(getIsClientCpp())){
            config.set(PTY_IS_CLIENT_CPP, getIsClientCpp());
         }
         if(RString.isNotEmpty(getIsClientAs())){
            config.set(PTY_IS_CLIENT_AS, getIsClientAs());
         }
         if(RString.isNotEmpty(getIsClientCs())){
            config.set(PTY_IS_CLIENT_CS, getIsClientCs());
         }
         if(RString.isNotEmpty(getIsClientJava())){
            config.set(PTY_IS_CLIENT_JAVA, getIsClientJava());
         }
         if(RString.isNotEmpty(getType())){
            config.set(PTY_TYPE, getType());
         }
         if(RString.isNotEmpty(getValue())){
            config.set(PTY_VALUE, getValue());
         }
         if(RString.isNotEmpty(getHotkey())){
            config.set(PTY_HOTKEY, getHotkey());
         }
         if(RString.isNotEmpty(getTypeCd())){
            config.set(PTY_TYPE_CD, getTypeCd());
         }
         if(RString.isNotEmpty(getTypeName())){
            config.set(PTY_TYPE_NAME, getTypeName());
         }
         if(RString.isNotEmpty(getIsCollection())){
            config.set(PTY_IS_COLLECTION, getIsCollection());
         }
         if(RString.isNotEmpty(getDataSize())){
            config.set(PTY_DATA_SIZE, getDataSize());
         }
         if(RString.isNotEmpty(getDateDefault())){
            config.set(PTY_DATE_DEFAULT, getDateDefault());
         }
         if(RString.isNotEmpty(getPropertyId())){
            config.set(PTY_PROPERTY_ID, getPropertyId());
         }
         if(RString.isNotEmpty(getPropertyGroup())){
            config.set(PTY_PROPERTY_GROUP, getPropertyGroup());
         }
         if(RString.isNotEmpty(getPropertyName())){
            config.set(PTY_PROPERTY_NAME, getPropertyName());
         }
         if(RString.isNotEmpty(getPropertyAlias())){
            config.set(PTY_PROPERTY_ALIAS, getPropertyAlias());
         }
         if(RString.isNotEmpty(getIsPersistence())){
            config.set(PTY_IS_PERSISTENCE, getIsPersistence());
         }
         if(RString.isNotEmpty(getIsSystem())){
            config.set(PTY_IS_SYSTEM, getIsSystem());
         }
         if(RString.isNotEmpty(getIsLock())){
            config.set(PTY_IS_LOCK, getIsLock());
         }
         if(RString.isNotEmpty(getIsGet())){
            config.set(PTY_IS_GET, getIsGet());
         }
         if(RString.isNotEmpty(getIsSet())){
            config.set(PTY_IS_SET, getIsSet());
         }
         if(RString.isNotEmpty(getMinValue())){
            config.set(PTY_MIN_VALUE, getMinValue());
         }
         if(RString.isNotEmpty(getMaxValue())){
            config.set(PTY_MAX_VALUE, getMaxValue());
         }
      }else if(EXmlConfig.Simple == type){
         if(RString.isNotEmpty(getName())){
            config.set(PTY_NAME, getName());
         }
         if(RString.isNotEmpty(getLabel())){
            config.set(PTY_LABEL, getLabel());
         }
         if(RBoolean.parse(getIsValid())){
            config.set(PTY_IS_VALID, RBoolean.toString(getIsValid()));
         }
         if(RString.isNotEmpty(getNote())){
            config.set(PTY_NOTE, getNote());
         }
         if(RString.isNotEmpty(getIsServer())){
            config.set(PTY_IS_SERVER, getIsServer());
         }
         if(RString.isNotEmpty(getIsServerCpp())){
            config.set(PTY_IS_SERVER_CPP, getIsServerCpp());
         }
         if(RString.isNotEmpty(getIsServerJava())){
            config.set(PTY_IS_SERVER_JAVA, getIsServerJava());
         }
         if(RString.isNotEmpty(getIsClient())){
            config.set(PTY_IS_CLIENT, getIsClient());
         }
         if(RString.isNotEmpty(getIsClientCpp())){
            config.set(PTY_IS_CLIENT_CPP, getIsClientCpp());
         }
         if(RString.isNotEmpty(getIsClientAs())){
            config.set(PTY_IS_CLIENT_AS, getIsClientAs());
         }
         if(RString.isNotEmpty(getIsClientCs())){
            config.set(PTY_IS_CLIENT_CS, getIsClientCs());
         }
         if(RString.isNotEmpty(getIsClientJava())){
            config.set(PTY_IS_CLIENT_JAVA, getIsClientJava());
         }
         if(RString.isNotEmpty(getType())){
            config.set(PTY_TYPE, getType());
         }
         if(RString.isNotEmpty(getValue())){
            config.set(PTY_VALUE, getValue());
         }
         if(RString.isNotEmpty(getHotkey())){
            config.set(PTY_HOTKEY, getHotkey());
         }
         if(RString.isNotEmpty(getTypeCd())){
            config.set(PTY_TYPE_CD, getTypeCd());
         }
         if(RString.isNotEmpty(getTypeName())){
            config.set(PTY_TYPE_NAME, getTypeName());
         }
         if(RString.isNotEmpty(getIsCollection())){
            config.set(PTY_IS_COLLECTION, getIsCollection());
         }
         if(RString.isNotEmpty(getDataSize())){
            config.set(PTY_DATA_SIZE, getDataSize());
         }
         if(RString.isNotEmpty(getDateDefault())){
            config.set(PTY_DATE_DEFAULT, getDateDefault());
         }
         if(RString.isNotEmpty(getPropertyId())){
            config.set(PTY_PROPERTY_ID, getPropertyId());
         }
         if(RString.isNotEmpty(getPropertyGroup())){
            config.set(PTY_PROPERTY_GROUP, getPropertyGroup());
         }
         if(RString.isNotEmpty(getPropertyName())){
            config.set(PTY_PROPERTY_NAME, getPropertyName());
         }
         if(RString.isNotEmpty(getPropertyAlias())){
            config.set(PTY_PROPERTY_ALIAS, getPropertyAlias());
         }
         if(RString.isNotEmpty(getIsPersistence())){
            config.set(PTY_IS_PERSISTENCE, getIsPersistence());
         }
         if(RString.isNotEmpty(getIsSystem())){
            config.set(PTY_IS_SYSTEM, getIsSystem());
         }
         if(RString.isNotEmpty(getIsLock())){
            config.set(PTY_IS_LOCK, getIsLock());
         }
         if(RString.isNotEmpty(getIsGet())){
            config.set(PTY_IS_GET, getIsGet());
         }
         if(RString.isNotEmpty(getIsSet())){
            config.set(PTY_IS_SET, getIsSet());
         }
         if(RString.isNotEmpty(getMinValue())){
            config.set(PTY_MIN_VALUE, getMinValue());
         }
         if(RString.isNotEmpty(getMaxValue())){
            config.set(PTY_MAX_VALUE, getMaxValue());
         }
      }else if(EXmlConfig.Value == type){
         String sName = getName();
         if(RString.isNotEmpty(sName)){
            config.set(PTY_NAME, sName);
         }
         String sLabel = getLabel();
         if(RString.isNotEmpty(sLabel)){
            config.set(PTY_LABEL, sLabel);
         }
         Boolean bIsValid = getIsValid();
         if(RBoolean.parse(bIsValid)){
            config.set(PTY_IS_VALID, RBoolean.toString(bIsValid));
         }
         String sNote = getNote();
         if(RString.isNotEmpty(sNote)){
            config.set(PTY_NOTE, sNote);
         }
         String sIsServer = getIsServer();
         if(RString.isNotEmpty(sIsServer)){
            config.set(PTY_IS_SERVER, sIsServer);
         }
         String sIsServerCpp = getIsServerCpp();
         if(RString.isNotEmpty(sIsServerCpp)){
            config.set(PTY_IS_SERVER_CPP, sIsServerCpp);
         }
         String sIsServerJava = getIsServerJava();
         if(RString.isNotEmpty(sIsServerJava)){
            config.set(PTY_IS_SERVER_JAVA, sIsServerJava);
         }
         String sIsClient = getIsClient();
         if(RString.isNotEmpty(sIsClient)){
            config.set(PTY_IS_CLIENT, sIsClient);
         }
         String sIsClientCpp = getIsClientCpp();
         if(RString.isNotEmpty(sIsClientCpp)){
            config.set(PTY_IS_CLIENT_CPP, sIsClientCpp);
         }
         String sIsClientAs = getIsClientAs();
         if(RString.isNotEmpty(sIsClientAs)){
            config.set(PTY_IS_CLIENT_AS, sIsClientAs);
         }
         String sIsClientCs = getIsClientCs();
         if(RString.isNotEmpty(sIsClientCs)){
            config.set(PTY_IS_CLIENT_CS, sIsClientCs);
         }
         String sIsClientJava = getIsClientJava();
         if(RString.isNotEmpty(sIsClientJava)){
            config.set(PTY_IS_CLIENT_JAVA, sIsClientJava);
         }
         String sType = getType();
         if(RString.isNotEmpty(sType)){
            config.set(PTY_TYPE, sType);
         }
         String sValue = getValue();
         if(RString.isNotEmpty(sValue)){
            config.set(PTY_VALUE, sValue);
         }
         String sHotkey = getHotkey();
         if(RString.isNotEmpty(sHotkey)){
            config.set(PTY_HOTKEY, sHotkey);
         }
         String sTypeCd = getTypeCd();
         if(RString.isNotEmpty(sTypeCd)){
            config.set(PTY_TYPE_CD, sTypeCd);
         }
         String sTypeName = getTypeName();
         if(RString.isNotEmpty(sTypeName)){
            config.set(PTY_TYPE_NAME, sTypeName);
         }
         String sIsCollection = getIsCollection();
         if(RString.isNotEmpty(sIsCollection)){
            config.set(PTY_IS_COLLECTION, sIsCollection);
         }
         String sDataSize = getDataSize();
         if(RString.isNotEmpty(sDataSize)){
            config.set(PTY_DATA_SIZE, sDataSize);
         }
         String sDateDefault = getDateDefault();
         if(RString.isNotEmpty(sDateDefault)){
            config.set(PTY_DATE_DEFAULT, sDateDefault);
         }
         String sPropertyId = getPropertyId();
         if(RString.isNotEmpty(sPropertyId)){
            config.set(PTY_PROPERTY_ID, sPropertyId);
         }
         String sPropertyGroup = getPropertyGroup();
         if(RString.isNotEmpty(sPropertyGroup)){
            config.set(PTY_PROPERTY_GROUP, sPropertyGroup);
         }
         String sPropertyName = getPropertyName();
         if(RString.isNotEmpty(sPropertyName)){
            config.set(PTY_PROPERTY_NAME, sPropertyName);
         }
         String sPropertyAlias = getPropertyAlias();
         if(RString.isNotEmpty(sPropertyAlias)){
            config.set(PTY_PROPERTY_ALIAS, sPropertyAlias);
         }
         String sIsPersistence = getIsPersistence();
         if(RString.isNotEmpty(sIsPersistence)){
            config.set(PTY_IS_PERSISTENCE, sIsPersistence);
         }
         String sIsSystem = getIsSystem();
         if(RString.isNotEmpty(sIsSystem)){
            config.set(PTY_IS_SYSTEM, sIsSystem);
         }
         String sIsLock = getIsLock();
         if(RString.isNotEmpty(sIsLock)){
            config.set(PTY_IS_LOCK, sIsLock);
         }
         String sIsGet = getIsGet();
         if(RString.isNotEmpty(sIsGet)){
            config.set(PTY_IS_GET, sIsGet);
         }
         String sIsSet = getIsSet();
         if(RString.isNotEmpty(sIsSet)){
            config.set(PTY_IS_SET, sIsSet);
         }
         String sMinValue = getMinValue();
         if(RString.isNotEmpty(sMinValue)){
            config.set(PTY_MIN_VALUE, sMinValue);
         }
         String sMaxValue = getMaxValue();
         if(RString.isNotEmpty(sMaxValue)){
            config.set(PTY_MAX_VALUE, sMaxValue);
         }
      }else if(EXmlConfig.Default == type){
         String sIsServer = getIsServer();
         if(RString.isNotEmpty(sIsServer)){
            config.set(PTY_IS_SERVER, sIsServer);
         }
         String sIsServerCpp = getIsServerCpp();
         if(RString.isNotEmpty(sIsServerCpp)){
            config.set(PTY_IS_SERVER_CPP, sIsServerCpp);
         }
         String sIsServerJava = getIsServerJava();
         if(RString.isNotEmpty(sIsServerJava)){
            config.set(PTY_IS_SERVER_JAVA, sIsServerJava);
         }
         String sIsClient = getIsClient();
         if(RString.isNotEmpty(sIsClient)){
            config.set(PTY_IS_CLIENT, sIsClient);
         }
         String sIsClientCpp = getIsClientCpp();
         if(RString.isNotEmpty(sIsClientCpp)){
            config.set(PTY_IS_CLIENT_CPP, sIsClientCpp);
         }
         String sIsClientAs = getIsClientAs();
         if(RString.isNotEmpty(sIsClientAs)){
            config.set(PTY_IS_CLIENT_AS, sIsClientAs);
         }
         String sIsClientCs = getIsClientCs();
         if(RString.isNotEmpty(sIsClientCs)){
            config.set(PTY_IS_CLIENT_CS, sIsClientCs);
         }
         String sIsClientJava = getIsClientJava();
         if(RString.isNotEmpty(sIsClientJava)){
            config.set(PTY_IS_CLIENT_JAVA, sIsClientJava);
         }
         String sTypeCd = getTypeCd();
         if(RString.isNotEmpty(sTypeCd)){
            config.set(PTY_TYPE_CD, sTypeCd);
         }
         String sTypeName = getTypeName();
         if(RString.isNotEmpty(sTypeName)){
            config.set(PTY_TYPE_NAME, sTypeName);
         }
         String sIsCollection = getIsCollection();
         if(RString.isNotEmpty(sIsCollection)){
            config.set(PTY_IS_COLLECTION, sIsCollection);
         }
         String sDataSize = getDataSize();
         if(RString.isNotEmpty(sDataSize)){
            config.set(PTY_DATA_SIZE, sDataSize);
         }
         String sDateDefault = getDateDefault();
         if(RString.isNotEmpty(sDateDefault)){
            config.set(PTY_DATE_DEFAULT, sDateDefault);
         }
         String sPropertyId = getPropertyId();
         if(RString.isNotEmpty(sPropertyId)){
            config.set(PTY_PROPERTY_ID, sPropertyId);
         }
         String sPropertyGroup = getPropertyGroup();
         if(RString.isNotEmpty(sPropertyGroup)){
            config.set(PTY_PROPERTY_GROUP, sPropertyGroup);
         }
         String sPropertyName = getPropertyName();
         if(RString.isNotEmpty(sPropertyName)){
            config.set(PTY_PROPERTY_NAME, sPropertyName);
         }
         String sPropertyAlias = getPropertyAlias();
         if(RString.isNotEmpty(sPropertyAlias)){
            config.set(PTY_PROPERTY_ALIAS, sPropertyAlias);
         }
         String sIsPersistence = getIsPersistence();
         if(RString.isNotEmpty(sIsPersistence)){
            config.set(PTY_IS_PERSISTENCE, sIsPersistence);
         }
         String sIsSystem = getIsSystem();
         if(RString.isNotEmpty(sIsSystem)){
            config.set(PTY_IS_SYSTEM, sIsSystem);
         }
         String sIsLock = getIsLock();
         if(RString.isNotEmpty(sIsLock)){
            config.set(PTY_IS_LOCK, sIsLock);
         }
         String sIsGet = getIsGet();
         if(RString.isNotEmpty(sIsGet)){
            config.set(PTY_IS_GET, sIsGet);
         }
         String sIsSet = getIsSet();
         if(RString.isNotEmpty(sIsSet)){
            config.set(PTY_IS_SET, sIsSet);
         }
         String sMinValue = getMinValue();
         if(RString.isNotEmpty(sMinValue)){
            config.set(PTY_MIN_VALUE, sMinValue);
         }
         String sMaxValue = getMaxValue();
         if(RString.isNotEmpty(sMaxValue)){
            config.set(PTY_MAX_VALUE, sMaxValue);
         }
      }
   }
}
