/*    */ package com.jfinal.app.blog._admin.blog.type;
/*    */ 
/*    */ import com.jfinal.aop.Inject;
/*    */ import com.jfinal.app.blog.common.BaseController;
/*    */ import com.jfinal.app.blog.common.model.Blog;
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
/*    */ @Path(value = "/admin/blog/type", viewPath = "/blogtype")
/*    */ public class BlogTypeAdminController
/*    */   extends BaseController
/*    */ {
/*    */   @Inject
/*    */   BlogTypeAdminService srv;
/*    */   
/*    */   public void forBlog() {
/* 27 */     Integer blogId = getInt("blogId");
/* 28 */     blogId = Integer.valueOf(1);
/*    */     
/* 30 */     renderJson(this.srv.search(blogId.intValue()).getList());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void publish() {
/* 38 */     Ret ret = this.srv.publish(getInt("id").intValue(), getBoolean("checked").booleanValue());
/* 39 */     renderJson(ret);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void add() {
/* 46 */     render("add_edit.html");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void save() {
/* 53 */     Ret ret = this.srv.save(getLoginAccountId(), (Blog)getBean(Blog.class));
/* 54 */     renderJson(ret);
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
/*    */   public void update() {
/* 69 */     Ret ret = this.srv.update((Blog)getBean(Blog.class));
/* 70 */     renderJson(ret);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void delete() {
/* 77 */     Ret ret = this.srv.deleteById(getInt("id").intValue());
/* 78 */     renderJson(ret);
/*    */   }
/*    */ }


/* Location:              /Users/nn/eclipse-workspace/jfinal-blog/jfinal-blog-5.0.0.jar!/com/jfinal/app/blog/_admin/blog/type/BlogTypeAdminController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */