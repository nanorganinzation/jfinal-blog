/*    */ package com.jfinal.app.blog.index;
/*    */ 
/*    */ import com.jfinal.aop.Inject;
/*    */ import com.jfinal.app.blog._admin.account.AccountAdminService;
/*    */ import com.jfinal.app.blog.blog.BlogService;
/*    */ import com.jfinal.app.blog.common.BaseController;
/*    */ import com.jfinal.app.blog.common.ImageUpload;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Path(value = "/", viewPath = "/index")
/*    */ public class IndexController
/*    */   extends BaseController
/*    */ {
/*    */   @Inject
/*    */   BlogService blogService;
/*    */   @Inject
/*    */   AccountAdminService srv;
/*    */   
/*    */   public void index() {
/* 32 */     set("allBlogs", this.blogService.getAllHomeBlogs());
/* 33 */     set("UploadPath", ImageUpload.UploadPath);
/* 34 */     set("UploadDema", ImageUpload.UploadDema);
/* 35 */     render("index.html");
/*    */   }
/*    */   
/*    */   public void contact() {
/* 39 */     render("contact.html");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void directory() {
/* 46 */     set("allBlogs", this.blogService.getAllBlogs());
/* 47 */     set("UploadPath", ImageUpload.UploadPath);
/* 48 */     set("UploadDema", ImageUpload.UploadDema);
/* 49 */     render("index.html");
/*    */   }
/*    */   
/*    */   public void authors() {
/* 53 */     set("allAuthors", this.srv.getAllDisplay());
/* 54 */     set("UploadPath", ImageUpload.UploadPath);
/* 55 */     set("UploadDema", ImageUpload.UploadDema);
/* 56 */     render("authors.html");
/*    */   }
/*    */ }


/* Location:              /Users/nn/eclipse-workspace/jfinal-blog/jfinal-blog-5.0.0.jar!/com/jfinal/app/blog/index/IndexController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */