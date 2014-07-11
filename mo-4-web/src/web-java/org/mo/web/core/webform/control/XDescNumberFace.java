package org.mo.web.core.webform.control;

import org.mo.com.xml.IXmlObject;

//============================================================
// <T>数字控件接口对象的XML节点基类。</T>
//============================================================
public interface XDescNumberFace
      extends IXmlObject
{
   // 名称定义
   String NAME = "MDescNumber";

   // 是否分隔的名称定义
   String PTY_EDIT_SPLITTER = "edit_splitter";

   // 增减单位的名称定义
   String PTY_EDIT_INCREATE = "edit_increate";

   // 精度的名称定义
   String PTY_EDIT_PRECISION = "edit_precision";

   // 输入模板的名称定义
   String PTY_EDIT_PATTERN = "edit_pattern";

   // 四舍五入的名称定义
   String PTY_EDIT_ROUND = "edit_round";

   // 允许最小值的名称定义
   String PTY_VALID_EQLMIN = "valid_eqlmin";

   // 允许最大值的名称定义
   String PTY_VALID_EQLMAX = "valid_eqlmax";

   // 最小值的名称定义
   String PTY_VALID_VALMIN = "valid_valmin";

   // 最大值的名称定义
   String PTY_VALID_VALMAX = "valid_valmax";

   // 可输入长度的名称定义
   String PTY_EDIT_LENGTH = "edit_length";

   // 编辑格式的名称定义
   String PTY_EDIT_FORMAT = "edit_format";

   // 编辑对齐的名称定义
   String PTY_EDIT_ALIGN = "edit_align";

   //============================================================
   // <T>获得是否分隔的内容。</T>
   //
   // @return 是否分隔
   //============================================================
   Boolean getEditSplitter();

   //============================================================
   // <T>设置是否分隔的内容。</T>
   //
   // @param value 是否分隔
   //============================================================
   void setEditSplitter(Boolean value);

   //============================================================
   // <T>获得增减单位的内容。</T>
   //
   // @return 增减单位
   //============================================================
   String getEditIncreate();

   //============================================================
   // <T>设置增减单位的内容。</T>
   //
   // @param value 增减单位
   //============================================================
   void setEditIncreate(String value);

   //============================================================
   // <T>获得精度的内容。</T>
   //
   // @return 精度
   //============================================================
   String getEditPrecision();

   //============================================================
   // <T>设置精度的内容。</T>
   //
   // @param value 精度
   //============================================================
   void setEditPrecision(String value);

   //============================================================
   // <T>获得输入模板的内容。</T>
   //
   // @return 输入模板
   //============================================================
   String getEditPattern();

   //============================================================
   // <T>设置输入模板的内容。</T>
   //
   // @param value 输入模板
   //============================================================
   void setEditPattern(String value);

   //============================================================
   // <T>获得四舍五入的内容。</T>
   //
   // @return 四舍五入
   //============================================================
   String getEditRound();

   //============================================================
   // <T>设置四舍五入的内容。</T>
   //
   // @param value 四舍五入
   //============================================================
   void setEditRound(String value);

   //============================================================
   // <T>获得允许最小值的内容。</T>
   //
   // @return 允许最小值
   //============================================================
   Boolean getValidEqlmin();

   //============================================================
   // <T>设置允许最小值的内容。</T>
   //
   // @param value 允许最小值
   //============================================================
   void setValidEqlmin(Boolean value);

   //============================================================
   // <T>获得允许最大值的内容。</T>
   //
   // @return 允许最大值
   //============================================================
   Boolean getValidEqlmax();

   //============================================================
   // <T>设置允许最大值的内容。</T>
   //
   // @param value 允许最大值
   //============================================================
   void setValidEqlmax(Boolean value);

   //============================================================
   // <T>获得最小值的内容。</T>
   //
   // @return 最小值
   //============================================================
   String getValidValmin();

   //============================================================
   // <T>设置最小值的内容。</T>
   //
   // @param value 最小值
   //============================================================
   void setValidValmin(String value);

   //============================================================
   // <T>获得最大值的内容。</T>
   //
   // @return 最大值
   //============================================================
   String getValidValmax();

   //============================================================
   // <T>设置最大值的内容。</T>
   //
   // @param value 最大值
   //============================================================
   void setValidValmax(String value);

   //============================================================
   // <T>获得可输入长度的内容。</T>
   //
   // @return 可输入长度
   //============================================================
   String getEditLength();

   //============================================================
   // <T>设置可输入长度的内容。</T>
   //
   // @param value 可输入长度
   //============================================================
   void setEditLength(String value);

   //============================================================
   // <T>获得编辑格式的内容。</T>
   //
   // @return 编辑格式
   //============================================================
   String getEditFormat();

   //============================================================
   // <T>设置编辑格式的内容。</T>
   //
   // @param value 编辑格式
   //============================================================
   void setEditFormat(String value);

   //============================================================
   // <T>获得编辑对齐的内容。</T>
   //
   // @return 编辑对齐
   //============================================================
   String getEditAlign();

   //============================================================
   // <T>设置编辑对齐的内容。</T>
   //
   // @param value 编辑对齐
   //============================================================
   void setEditAlign(String value);
}