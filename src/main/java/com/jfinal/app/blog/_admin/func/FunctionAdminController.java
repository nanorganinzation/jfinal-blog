/*    */ package com.jfinal.app.blog._admin.func;
/*    */ 
/*    */ import com.jfinal.aop.Inject;
/*    */ import com.jfinal.app.blog.common.BaseController;
/*    */ import com.jfinal.core.Path;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Path(value = "/admin/func", viewPath = "/func")
/*    */ public class FunctionAdminController
/*    */   extends BaseController
/*    */ {
/*    */   @Inject
/*    */   FunctionAdminService srv;
/*    */   
/*    */   public void index() {
/* 23 */     render("index.html");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void getTotalOrdersToday() {
/* 30 */     renderJson(this.srv.getTotalOrdersToday());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void clearExpiredSession() {
/* 37 */     renderJson(this.srv.clearExpiredSession());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void clearCache() {
/* 44 */     renderJson(this.srv.clearCache());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void passData() {
/* 51 */     renderJson(this.srv.passData(get("k1"), get("k2")));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void switchAccount() {
/* 58 */     renderJson(this.srv.switchAccount(getLoginAccount(), getInt("value").intValue()));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void restart() {
/* 65 */     renderJson(this.srv.restart());
/*    */   }
/*    */ }


/* Location:              /Users/nn/eclipse-workspace/jfinal-blog/jfinal-blog-5.0.0.jar!/com/jfinal/app/blog/_admin/func/FunctionAdminController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */