/*    */ package com.jfinal.app.blog._admin.login;
/*    */ 
/*    */ import com.jfinal.aop.Clear;
/*    */ import com.jfinal.aop.Inject;
/*    */ import com.jfinal.app.blog.common.BaseController;
/*    */ import com.jfinal.app.blog.common.kit.IpKit;
/*    */ import com.jfinal.core.ActionKey;
/*    */ import com.jfinal.core.Path;
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
/*    */ 
/*    */ @Path(value = "/admin/login", viewPath = "/login")
/*    */ public class LoginController
/*    */   extends BaseController
/*    */ {
/*    */   @Inject
/*    */   LoginService srv;
/*    */   
/*    */   @Clear
/*    */   public void index() {
/* 33 */     render("index.html");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @Clear
/*    */   public void doLogin() {
/* 41 */     String ip = IpKit.getRealIp(getRequest(), "127.0.0.1");
/* 42 */     int port = getRequest().getServerPort();
/* 43 */     Ret ret = this.srv.login(get("userName"), get("password"), ip, port);
/* 44 */     if (ret.isOk()) {
/*    */       
/* 46 */       setCookie("sessionId", ret.getStr("sessionId"), ret.getInt("timeToLiveSeconds").intValue(), true);
/*    */ 
/*    */       
/* 49 */       setAttr("loginAccount", ret.get("loginAccount"));
/*    */ 
/*    */       
/* 52 */       ret.set("returnUrl", getPara("returnUrl", "/admin"));
/*    */     } 
/* 54 */     renderJson(ret);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @Clear
/*    */   @ActionKey("/admin/logout")
/*    */   public void logout() {
/* 63 */     Ret ret = this.srv.logout(getCookie("sessionId"));
/* 64 */     removeCookie("sessionId");
/* 65 */     renderJson(ret);
/*    */   }
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
/*    */   @Clear
/*    */   public void captcha() {
/* 84 */     renderCaptcha();
/*    */   }
/*    */ }


/* Location:              /Users/nn/eclipse-workspace/jfinal-blog/jfinal-blog-5.0.0.jar!/com/jfinal/app/blog/_admin/login/LoginController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */