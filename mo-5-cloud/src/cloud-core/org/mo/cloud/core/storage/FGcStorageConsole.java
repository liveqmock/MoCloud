package org.mo.cloud.core.storage;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import org.mo.com.io.FByteFile;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.RString;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.core.aop.face.AProperty;

//============================================================
// <T>存储控制台。</T>
//============================================================
public class FGcStorageConsole
      implements
         IGcStorageConsole
{
   // 日志输出接口
   private final static ILogger _logger = RLogger.find(FGcStorageConsole.class);

   // 允许标志
   @AProperty
   protected boolean _enable;

   // 存储主机
   @AProperty
   protected String _storageHost;

   // 存储端口
   @AProperty
   protected int _storagePort;

   // 存储名称
   @AProperty
   protected String _storageName;

   // 数据库链接
   protected Mongo _connection;

   // 数据库
   protected DB _database;

   //============================================================
   // <T>保存一个存储信息。</T>
   //
   // @param storage 存储信息
   // @return 处理结果
   //============================================================
   @Override
   public SGcStorage find(String catalog,
                          String guid){
      // 获得集合
      DBCollection collection = _database.getCollection(catalog);
      // 查找内容
      DBObject search = new BasicDBObject("guid", guid);
      // 更新处理
      DBObject item = collection.findOne(search);
      byte[] data = (byte[])item.get("data");
      // 返回内容
      SGcStorage resource = new SGcStorage();
      resource.setData(data);
      return resource;
   }

   //============================================================
   // <T>保存一个存储信息。</T>
   //
   // @param storage 存储信息
   // @return 处理结果
   //============================================================
   @Override
   public boolean store(SGcStorage storage){
      // 检查分类
      String catalog = storage.catalog();
      if(RString.isEmpty(catalog)){
         throw new FFatalError("Store catalog is empty.");
      }
      // 检查唯一编号
      String guid = storage.guid();
      if(RString.isEmpty(guid)){
         throw new FFatalError("Store code is empty.");
      }
      // 检查日期
      String date = storage.date();
      if(RString.isEmpty(date)){
         throw new FFatalError("Store date is empty.");
      }
      // 检查类型
      String type = RString.nvl(storage.type(), "bin");
      //............................................................
      // 获得数据
      byte[] data = null;
      String dataSource = storage.dataSource();
      if(!RString.isEmpty(dataSource)){
         try(FByteFile file = new FByteFile(dataSource)){
            int size = file.length();
            if(size <= 0){
               _logger.warn(this, "store", "File size is invalid. (source={1})", dataSource);
               return false;
            }else{
               data = file.toArray();
            }
         }catch(Exception e){
            _logger.error(this, "store", e);
         }
      }
      if(data == null){
         data = storage.data();
      }
      if(data == null){
         throw new FFatalError("Resource data is empty.");
      }
      //............................................................
      // 获得集合
      DBCollection collection = _database.getCollection(catalog);
      // 新建数据
      DBObject item = new BasicDBObject();
      item.put("guid", guid);
      item.put("date", date);
      item.put("type", type);
      item.put("data", data);
      // 查找内容
      DBObject search = new BasicDBObject("guid", guid);
      // 更新处理
      collection.update(search, item, true, false);
      return true;
   }

   //============================================================
   // <T>生成存储文件名称。</T>
   //
   // @param catalog 目录
   // @param date 日期
   // @param code 代码
   // @param version 版本
   // @param type 类型
   // @return 文件名称
   //============================================================
   public void initialize(){
      try{
         _connection = new Mongo(_storageHost, _storagePort);
         _database = _connection.getDB(_storageName);
      }catch(Exception e){
         throw new FFatalError(e);
      }
   }
}
