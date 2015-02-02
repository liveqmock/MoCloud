package org.mo.cloud.content.design.configuration;

import org.mo.com.lang.FObject;
import org.mo.com.lang.RBoolean;
import org.mo.com.lang.reflect.FField;

//============================================================
// <T>构造内容字段。</T>
//============================================================
public class FContentField
      extends FObject
{
   // 类名称
   protected String _name;

   // 数据类型
   protected EContentData _dataCd;

   // 类名称
   protected String _linkName;

   // 字段
   protected FField _field;

   //============================================================
   // <T>构造内容字段。</T>
   //============================================================
   public FContentField(){
   }

   //============================================================
   // <T>构造内容类对象。</T>
   //
   // @param name 名称
   //============================================================
   public FContentField(String name,
                        String linkName,
                        EContentData dataCd){
      _name = name;
      _linkName = linkName;
      _dataCd = dataCd;
   }

   //============================================================
   // <T>获得节点名称。</T>
   //
   // @return 节点名称
   //============================================================
   public String name(){
      return _name;
   }

   //============================================================
   // <T>设置节点名称。</T>
   //
   // @param name 节点名称
   //============================================================
   public void setName(String name){
      _name = name;
   }

   //============================================================
   // <T>获得数据类型。</T>
   //
   // @return 数据类型
   //============================================================
   public EContentData _dataCd(){
      return _dataCd;
   }

   //============================================================
   // <T>设置数据类型。</T>
   //
   // @param dataCd 数据类型
   //============================================================
   public void setDataCd(EContentData dataCd){
      _dataCd = dataCd;
   }

   //============================================================
   // <T>获得关联名称。</T>
   //
   // @return 关联名称
   //============================================================
   public String linkName(){
      return _linkName;
   }

   //============================================================
   // <T>加载字段信息。</T>
   //
   // @param field 字段信息
   //============================================================
   public void link(FField field){
      _field = field;
      _field.setAccessible(true);
   }

   //============================================================
   // <T>获得实例内容。</T>
   //
   // @param instance 实例
   // @return 内容
   //============================================================
   public Object get(Object instance){
      return _field.get(instance);
   }

   //============================================================
   // <T>设置实例内容。</T>
   //
   // @param instance 实例
   // @param value 内容
   //============================================================
   public void set(Object instance,
                   Object value){
      switch(_dataCd){
         case Boolean:
            _field.set(instance, RBoolean.parse(value));
            break;
         default:
            _field.set(instance, value);
      }
   }
}
