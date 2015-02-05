package org.mo.content.resource3d;

import org.mo.com.lang.FStrings;
import org.mo.com.logging.RLogger;
import org.mo.content.engine3d.core.texture.IRs3TextureConsole;
import org.mo.core.aop.RAop;
import org.mo.data.logic.FLogicContext;
import org.mo.data.logic.ILogicContext;
import org.mo.eng.data.IDatabaseConsole;

public class RRs3TextureImport
{
   //============================================================
   // <T>主函数。</T>
   //============================================================
   public static void main(String[] args) throws Exception{
      String configPath = RRs3Utility.RootPath + "/MoCloud";
      RAop.configConsole().defineCollection().attributes().set("application", configPath);
      RAop.initialize(configPath + "/mp-cloud-design/src/config/" + RRs3Utility.Config);

      FStrings filePaths = new FStrings();
      filePaths.push("pvw.show.001.01");
      filePaths.push("pvw.show.009.01");
      filePaths.push("pvw.sc.car.01.001.01");
      filePaths.push("pvw.sc.car.01.001.02");
      filePaths.push("pvw.sc.car.01.001.03");
      filePaths.push("pvw.show.013.01");
      filePaths.push("pvw.show.013.02");
      filePaths.push("pvw.show.013.03");

      IDatabaseConsole dbConsole = RAop.find(IDatabaseConsole.class);
      try(ILogicContext logicContext = new FLogicContext(dbConsole)){
         IRs3TextureConsole textureConsole = RAop.find(IRs3TextureConsole.class);
         for(String fileName : filePaths){
            String path = RRs3Utility.RootPath + "/MoScript/source/assets/texture/" + fileName;
            textureConsole.importTexture(logicContext, path);
         }
      }catch(Exception e){
         RLogger.find(RRs3TextureImport.class).error(null, "main", e);
      }

      RAop.release();
   }
}
