/*    */ package com.jfinal.app.blog.author;
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
/*    */ @Path(value = "/author", viewPath = "/index")
/*    */ public class BlogAuthorController
/*    */   extends BaseController
/*    */ {
/*    */   @Inject
/*    */   AccountAdminService accountSrv;
/*    */   @Inject
/*    */   BlogService blogService;
/*    */   
/*    */   public void index() {
/* 29 */     Integer accountId = getInt();
/* 30 */     set("account", this.accountSrv.getById(accountId.intValue()));
/* 31 */     set("allBlogs", this.blogService.getAllHomeBlogsAccount(accountId.intValue()));
/* 32 */     set("UploadPath", ImageUpload.UploadPath);
/* 33 */     set("UploadDema", ImageUpload.UploadDema);
/* 34 */     render("userBlog.html");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void home() {
/* 41 */     Integer accountId = getInt();
/* 42 */     set("account", this.accountSrv.getById(accountId.intValue()));
/* 43 */     set("allBlogs", this.blogService.getAllHomeBlogsAccount(accountId.intValue()));
/* 44 */     set("UploadPath", ImageUpload.UploadPath);
/* 45 */     set("UploadDema", ImageUpload.UploadDema);
/* 46 */     render("userBlog.html");
/*    */   }
/*    */   
/*    */   public void directory() {
/* 50 */     Integer accountId = getInt();
/* 51 */     set("account", this.accountSrv.getById(accountId.intValue()));
/* 52 */     set("allBlogs", this.blogService.getAllBlogsAccount(accountId));
/* 53 */     set("UploadPath", ImageUpload.UploadPath);
/* 54 */     set("UploadDema", ImageUpload.UploadDema);
/* 55 */     render("userBlog.html");
/*    */   }
/*    */ }


/* Location:              /Users/nn/eclipse-workspace/jfinal-blog/jfinal-blog-5.0.0.jar!/com/jfinal/app/blog/author/BlogAuthorController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */