package org.mo.content.resource3d.scene;

import org.mo.com.io.IDataInput;
import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FObjects;
import org.mo.com.xml.FXmlNode;
import org.mo.content.resource3d.common.FRs3Object;

//============================================================
// <T>场景层。</T>
//============================================================
public class FRs3SceneLayer
      extends FRs3Object
{
   protected String _typeCd;

   // 场景技术过程集合
   protected FObjects<FRs3SceneDisplay> _displays;

   //============================================================
   // <T>构造场景层。</T>
   //============================================================
   public FRs3SceneLayer(){
   }

   //============================================================
   // <T>获得显示集合。</T>
   //
   // @return 显示集合
   //============================================================
   public FObjects<FRs3SceneDisplay> displays(){
      return _displays;
   }

   //============================================================
   // <T>增加一个技术过程。</T>
   //
   // @param pass 技术过程
   //============================================================
   public void pushDisplay(FRs3SceneDisplay pass){
      if(_displays == null){
         _displays = new FObjects<FRs3SceneDisplay>(FRs3SceneDisplay.class);
      }
      _displays.push(pass);
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   @Override
   public void serialize(IDataOutput output){
      super.serialize(output);
      // 存储技术过程集合
      if(_displays != null){
         int count = _displays.count();
         output.writeInt16((short)count);
         for(FRs3SceneDisplay display : _displays){
            display.serialize(output);
         }
      }else{
         output.writeInt16((short)0);
      }
   }

   //============================================================
   // <T>从配置信息中加载配置。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   public void loadConfig(FXmlNode xconfig){
      // 读取属性
      _code = xconfig.get("code");
      // 处理所有节点
      for(FXmlNode xnode : xconfig){
         if(xnode.isName("DisplayCollection")){
            // 读取显示集合
            for(FXmlNode xdisplay : xnode){
               FRs3SceneDisplay display = new FRs3SceneDisplay();
               display.loadConfig(xdisplay);
               pushDisplay(display);
            }
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
   public void saveConfig(FXmlNode xconfig){
      // 存储属性
      xconfig.set("guid", makeGuid());
      xconfig.set("code", _code);
      xconfig.set("type_cd", _typeCd);
      // 存储层集合
      if(_displays != null){
         FXmlNode xdisplays = xconfig.createNode("DisplayCollection");
         for(FRs3SceneDisplay display : _displays){
            display.saveConfig(xdisplays.createNode("Display"));
         }
      }
   }

   //============================================================
   // <T>从输入流反序列化数据。</T>
   //
   // @param input 输入流
   //============================================================
   public void importData(IDataInput input){
      // 读取属性
      _code = input.readString();
      _typeCd = input.readString();
      // 读取显示集合
      int displayCount = input.readInt32();
      for(int n = 0; n < displayCount; n++){
         FRs3SceneDisplay display = new FRs3SceneDisplay();
         display.importData(input);
         pushDisplay(display);
      }
   }
}