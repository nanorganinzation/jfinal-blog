/*    */ package com.jfinal.app.blog._admin.common;
/*    */ 
/*    */ import com.jfinal.aop.Interceptor;
/*    */ import com.jfinal.aop.Invocation;
/*    */ import com.jfinal.core.Controller;
/*    */ import javax.servlet.http.HttpServletRequest;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AdminInterceptor
/*    */   implements Interceptor
/*    */ {
/*    */   public void intercept(Invocation inv) {
/* 34 */     Controller c = inv.getController();
/* 35 */     if (isAjaxRequest(c.getRequest())) {
/* 36 */       inv.invoke();
/*    */     
/*    */     }
/*    */     else {
/*    */ 
/*    */       
/* 42 */       c.render("/_view/_admin/common/_admin_layout.html");
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   boolean isAjaxRequest(HttpServletRequest req) {
/* 50 */     return "XMLHttpRequest".equalsIgnoreCase(req.getHeader("X-Requested-With"));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   void setUrl(Controller c) {
/* 60 */     HttpServletRequest req = c.getRequest();
/* 61 */     String url = req.getRequestURI();
/* 62 */     if (req.getQueryString() != null) {
/* 63 */       url = url + '?' + req.getQueryString();
/*    */     }
/* 65 */     c.set("url", url);
/*    */   }
/*    */ }


/* Location:              /Users/nn/eclipse-workspace/jfinal-blog/jfinal-blog-5.0.0.jar!/com/jfinal/app/blog/_admin/common/AdminInterceptor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */