package org.mo.content.engine3d.core.stream;

import com.cyou.gccloud.data.data.FDataResource3dStreamUnit;
import org.mo.com.lang.EResult;
import org.mo.content.resource3d.common.FRs3Stream;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>资源数据流控制台接口。</T>
//============================================================
public interface IRs3StreamConsole
{
   //============================================================
   // <T>新建一个数据流。</T>
   //
   // @param logicContext 逻辑环境
   // @param stream 数据流
   // @return 数据流单元
   //============================================================
   FDataResource3dStreamUnit insert(ILogicContext logicContext,
                                    FRs3Stream stream);

   //============================================================
   // <T>更新一个数据流。</T>
   //
   // @param logicContext 逻辑环境
   // @param stream 数据流
   // @return 处理结果
   //============================================================
   EResult update(ILogicContext logicContext,
                  FRs3Stream stream);

   //============================================================
   // <T>构建一个数据流。</T>
   //
   // @param logicContext 逻辑环境
   // @param streamId 数据流编号
   // @return 数据流
   //============================================================
   FRs3Stream makeStream(ILogicContext logicContext,
                         long streamId);
}
