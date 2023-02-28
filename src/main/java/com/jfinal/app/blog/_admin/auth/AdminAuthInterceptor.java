/*    */ package com.jfinal.app.blog._admin.auth;
/*    */ 
/*    */ import com.jfinal.aop.Interceptor;
/*    */ import com.jfinal.aop.Invocation;
/*    */ import com.jfinal.app.blog.common.model.Account;
/*    */ import com.jfinal.core.Controller;
/*    */ import com.jfinal.kit.Ret;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AdminAuthInterceptor
/*    */   implements Interceptor
/*    */ {
/*    */   public void intercept(Invocation inv) {
/* 25 */     Controller c = inv.getController();
/*    */ 
/*    */     
/* 28 */     Account loginAccount = (Account)c.getAttr("loginAccount");
/* 29 */     if (loginAccount != null) {
/* 30 */       inv.invoke();
/*    */       
/*    */       return;
/*    */     } 
/*    */     
/* 35 */     if (isAjaxRequest(c)) {
/* 36 */       c.renderJson(Ret.fail("当前账户已退出登录，请刷新页面并重新登录"));
/*    */     } else {
/* 38 */       c.forwardAction("/admin/login");
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   boolean isAjaxRequest(Controller c) {
/* 46 */     return "XMLHttpRequest".equalsIgnoreCase(c.getRequest().getHeader("X-Requested-With"));
/*    */   }
/*    */ }


/* Location:              /Users/nn/eclipse-workspace/jfinal-blog/jfinal-blog-5.0.0.jar!/com/jfinal/app/blog/_admin/auth/AdminAuthInterceptor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */