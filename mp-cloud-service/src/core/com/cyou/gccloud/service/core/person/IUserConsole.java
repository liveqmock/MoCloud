package com.cyou.gccloud.service.core.person;

//============================================================
// <T>游戏实例控制台接口。</T>
//============================================================
public interface IUserConsole
{
   //============================================================
   // <T>用户注册处理。</T>
   //============================================================
   void register();

   //============================================================
   // <T>用户登录处理。</T>
   //============================================================
   void login();

   //============================================================
   // <T>用户登出处理。</T>
   //============================================================
   void logout();
}