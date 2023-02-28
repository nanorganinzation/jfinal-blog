/*    */ package com.jfinal.app.blog._admin.login;
/*    */ 
/*    */ import com.jfinal.aop.Inject;
/*    */ import com.jfinal.aop.Interceptor;
/*    */ import com.jfinal.aop.Invocation;
/*    */ import com.jfinal.app.blog.common.model.Account;
/*    */ import com.jfinal.core.Controller;
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
/*    */ 
/*    */ public class LoginSessionInterceptor
/*    */   implements Interceptor
/*    */ {
/*    */   @Inject
/*    */   LoginService loginAdminService;
/*    */   
/*    */   public void intercept(Invocation inv) {
/* 29 */     Controller c = inv.getController();
/* 30 */     String sessionId = c.getCookie("sessionId");
/* 31 */     if (sessionId != null) {
/* 32 */       Account loginAccount = this.loginAdminService.getAccountBySessionId(sessionId);
/* 33 */       if (loginAccount != null) {
/*    */         
/* 35 */         c.setAttr("loginAccount", loginAccount);
/*    */       } else {
/*    */         
/* 38 */         c.removeCookie("sessionId");
/*    */       } 
/*    */     } 
/*    */     
/* 42 */     inv.invoke();
/*    */   }
/*    */ }


/* Location:              /Users/nn/eclipse-workspace/jfinal-blog/jfinal-blog-5.0.0.jar!/com/jfinal/app/blog/_admin/login/LoginSessionInterceptor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */