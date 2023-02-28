/*    */ package com.jfinal.app.blog._admin.blog;
/*    */ 
/*    */ import com.jfinal.aop.Inject;
/*    */ import com.jfinal.app.blog._admin.blog.type.BlogTypeAdminService;
/*    */ import com.jfinal.app.blog.common.BaseController;
/*    */ import com.jfinal.app.blog.common.model.Blog;
/*    */ import com.jfinal.core.Path;
/*    */ import com.jfinal.kit.Ret;
/*    */ import com.jfinal.kit.StrKit;
/*    */ import com.jfinal.plugin.activerecord.Page;
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
/*    */ @Path(value = "/admin/blog", viewPath = "/blog")
/*    */ public class BlogAdminController
/*    */   extends BaseController
/*    */ {
/*    */   @Inject
/*    */   BlogAdminService srv;
/*    */   @Inject
/*    */   BlogTypeAdminService srvType;
/*    */   
/*    */   public void index() {
/* 34 */     int accountId = getLoginAccountId();
/*    */     
/* 36 */     int pn = getInt("pn", Integer.valueOf(1)).intValue();
/* 37 */     String searchKey = get("searchKey");
/*    */     
/* 39 */     Page<Blog> page = StrKit.isBlank(searchKey) ? this.srv.paginate(pn, accountId) : this.srv.search(searchKey, pn, accountId);
/*    */     
/* 41 */     keepPara(new String[] { "searchKey" });
/* 42 */     set("page", page);
/* 43 */     render("index.html");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void publish() {
/* 50 */     Ret ret = this.srv.publish(getInt("id").intValue(), getBoolean("checked").booleanValue());
/* 51 */     renderJson(ret);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void status() {
/* 58 */     Ret ret = this.srv.status(getInt("id").intValue(), getBoolean("checked").booleanValue());
/* 59 */     renderJson(ret);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void add() {
/* 66 */     render("add_edit.html");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void save() {
/* 73 */     Ret ret = this.srv.save(getLoginAccountId(), (Blog)getBean(Blog.class));
/* 74 */     renderJson(ret);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void edit() {
/* 81 */     set("blog", this.srv.getById(getInt("id").intValue()));
/* 82 */     set("blogtype", this.srvType.search(getInt("id").intValue()).getList());
/* 83 */     render("add_edit.html");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void update() {
/* 90 */     Ret ret = this.srv.update((Blog)getBean(Blog.class));
/* 91 */     renderJson(ret);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void delete() {
/* 98 */     Ret ret = this.srv.deleteById(getInt("id").intValue());
/* 99 */     renderJson(ret);
/*    */   }
/*    */ }


/* Location:              /Users/nn/eclipse-workspace/jfinal-blog/jfinal-blog-5.0.0.jar!/com/jfinal/app/blog/_admin/blog/BlogAdminController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */