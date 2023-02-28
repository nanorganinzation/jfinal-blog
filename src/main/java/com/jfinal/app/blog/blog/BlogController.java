/*    */ package com.jfinal.app.blog.blog;
/*    */ 
/*    */ import com.jfinal.aop.Inject;
/*    */ import com.jfinal.app.blog.common.BaseController;
/*    */ import com.jfinal.app.blog.common.ImageUpload;
/*    */ import com.jfinal.app.blog.common.model.Blog;
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
/*    */ @Path("/blog")
/*    */ public class BlogController
/*    */   extends BaseController
/*    */ {
/*    */   @Inject
/*    */   BlogService srv;
/*    */   
/*    */   public void index() {
/* 25 */     Blog blog = this.srv.getById(getInt().intValue());
/* 26 */     if (blog != null) {
/* 27 */       set("blog", blog);
/* 28 */       set("UploadPath", ImageUpload.UploadPath);
/* 29 */       set("UploadDema", ImageUpload.UploadDema);
/* 30 */       render("index.html");
/*    */     } else {
/* 32 */       renderError(404);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /Users/nn/eclipse-workspace/jfinal-blog/jfinal-blog-5.0.0.jar!/com/jfinal/app/blog/blog/BlogController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */