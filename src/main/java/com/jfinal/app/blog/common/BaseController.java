/*    */ package com.jfinal.app.blog.common;
/*    */ 
/*    */ import com.jfinal.app.blog.common.model.Account;
/*    */ import com.jfinal.core.Controller;
/*    */ import com.jfinal.core.NotAction;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BaseController
/*    */   extends Controller
/*    */ {
/*    */   private Account loginAccount;
/*    */   
/*    */   protected void _clear_() {
/* 30 */     this.loginAccount = null;
/* 31 */     super._clear_();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @NotAction
/*    */   public Account getLoginAccount() {
/* 39 */     if (this.loginAccount == null) {
/* 40 */       this.loginAccount = (Account)getAttr("loginAccount");
/* 41 */       if (this.loginAccount != null && !this.loginAccount.isStateOk()) {
/* 42 */         throw new IllegalStateException("当前用户状态不允许登录，state = " + this.loginAccount.getState());
/*    */       }
/*    */     } 
/* 45 */     return this.loginAccount;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @NotAction
/*    */   public boolean isLogin() {
/* 53 */     return (getLoginAccount() != null);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @NotAction
/*    */   public boolean notLogin() {
/* 61 */     return !isLogin();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @NotAction
/*    */   public int getLoginAccountId() {
/* 71 */     return getLoginAccount().getId().intValue();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @NotAction
/*    */   public boolean isAjaxRequest() {
/* 79 */     return "XMLHttpRequest".equalsIgnoreCase(getHeader("X-Requested-With"));
/*    */   }
/*    */ }


/* Location:              /Users/nn/eclipse-workspace/jfinal-blog/jfinal-blog-5.0.0.jar!/com/jfinal/app/blog/common/BaseController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */