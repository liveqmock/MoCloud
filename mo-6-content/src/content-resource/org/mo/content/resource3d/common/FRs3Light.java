package org.mo.content.resource3d.common;

import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FFatalError;
import org.mo.com.xml.FXmlNode;

//============================================================
// <T>场景光源显示。</T>
//============================================================
public class FRs3Light
      extends FRs3Object
{
   // 类型
   protected String _typeCd;

   // 材质
   protected FRs3Material _material = new FRs3Material();

   // 相机
   protected FRs3Camera _camera = new FRs3Camera();

   //============================================================
   // <T>构造场景层。</T>
   //============================================================
   public FRs3Light(){
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   @Override
   public void serialize(IDataOutput output){
      super.serialize(output);
      // 存储属性
      output.writeString(_typeCd);
      _material.serialize(output);
      _camera.serialize(output);
   }

   //============================================================
   // <T>从配置信息中加载配置。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   @Override
   public void loadConfig(FXmlNode xconfig){
      // 读取属性
      _guid = xconfig.get("guid");
      _typeCd = xconfig.get("type_cd");
      // 处理所有节点
      for(FXmlNode xnode : xconfig){
         if(xnode.isName("Material")){
            _material.loadConfig(xnode);
         }else if(xnode.isName("Camera")){
            _camera.loadConfig(xnode);
         }else{
            throw new FFatalError("Invalid config node.");
         }
      }
   }

   //============================================================
   // <T>存储数据信息到配置节点中。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   @Override
   public void saveConfig(FXmlNode xconfig){
      // 存储属性
      xconfig.set("guid", makeGuid());
      xconfig.set("type_cd", _typeCd);
      _material.saveConfig(xconfig.createNode("Material"));
      _camera.saveConfig(xconfig.createNode("Camera"));
   }

   //============================================================
   // <T>从配置信息中加载配置。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   @Override
   public void mergeConfig(FXmlNode xconfig){
      super.mergeConfig(xconfig);
   }
}
