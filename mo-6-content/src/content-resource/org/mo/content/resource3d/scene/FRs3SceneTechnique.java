package org.mo.content.resource3d.scene;

import org.mo.com.io.IDataInput;
import org.mo.content.resource3d.common.FRs3Technique;

//============================================================
// <T>场景技术。</T>
//============================================================
public class FRs3SceneTechnique
      extends FRs3Technique
{
   //============================================================
   // <T>构造场景技术。</T>
   //============================================================
   public FRs3SceneTechnique(){
   }

   //============================================================
   // <T>从输入流反序列化数据。</T>
   //
   // @param input 输入流
   //============================================================
   public void importData(IDataInput input){
      // 读取属性
      _code = input.readString();
      // 读取网格集合
      int passCount = input.readInt32();
      for(int n = 0; n < passCount; n++){
         FRs3SceneTechniquePass pass = new FRs3SceneTechniquePass();
         pass.importData(input);
         pushPass(pass);
      }
   }
}
