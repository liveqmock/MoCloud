package org.mo.web.core.webform.control;

import org.mo.com.xml.IXmlObject;

//============================================================
// <T>控件位置接口对象的XML节点基类。</T>
//============================================================
public interface XSizeFace
      extends
         IXmlObject
{
   // 名称定义
   String NAME = "MSize";

   // 左位置的名称定义
   String PTY_LEFT = "left";

   // 上位置的名称定义
   String PTY_TOP = "top";

   // 右位置的名称定义
   String PTY_RIGHT = "right";

   // 下位置的名称定义
   String PTY_BOTTOM = "bottom";

   // 宽度的名称定义
   String PTY_WIDTH = "width";

   // 高度的名称定义
   String PTY_HEIGHT = "height";

   //============================================================
   // <T>获得左位置的内容。</T>
   //
   // @return 左位置
   //============================================================
   String getLeft();

   //============================================================
   // <T>设置左位置的内容。</T>
   //
   // @param value 左位置
   //============================================================
   void setLeft(String value);

   //============================================================
   // <T>获得上位置的内容。</T>
   //
   // @return 上位置
   //============================================================
   String getTop();

   //============================================================
   // <T>设置上位置的内容。</T>
   //
   // @param value 上位置
   //============================================================
   void setTop(String value);

   //============================================================
   // <T>获得右位置的内容。</T>
   //
   // @return 右位置
   //============================================================
   String getRight();

   //============================================================
   // <T>设置右位置的内容。</T>
   //
   // @param value 右位置
   //============================================================
   void setRight(String value);

   //============================================================
   // <T>获得下位置的内容。</T>
   //
   // @return 下位置
   //============================================================
   String getBottom();

   //============================================================
   // <T>设置下位置的内容。</T>
   //
   // @param value 下位置
   //============================================================
   void setBottom(String value);

   //============================================================
   // <T>获得宽度的内容。</T>
   //
   // @return 宽度
   //============================================================
   String getWidth();

   //============================================================
   // <T>设置宽度的内容。</T>
   //
   // @param value 宽度
   //============================================================
   void setWidth(String value);

   //============================================================
   // <T>获得高度的内容。</T>
   //
   // @return 高度
   //============================================================
   String getHeight();

   //============================================================
   // <T>设置高度的内容。</T>
   //
   // @param value 高度
   //============================================================
   void setHeight(String value);
}
