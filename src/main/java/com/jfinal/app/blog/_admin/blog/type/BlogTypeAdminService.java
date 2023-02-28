/*    */ package com.jfinal.app.blog._admin.blog.type;
/*    */ 
/*    */ import com.jfinal.app.blog.common.model.Blog;
/*    */ import com.jfinal.app.blog.common.model.BlogType;
/*    */ import com.jfinal.kit.Ret;
/*    */ import com.jfinal.kit.StrKit;
/*    */ import com.jfinal.plugin.activerecord.Db;
/*    */ import com.jfinal.plugin.activerecord.Page;
/*    */ import java.util.Date;
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
/*    */ public class BlogTypeAdminService
/*    */ {
/* 23 */   private BlogType dao = (BlogType)(new BlogType()).dao();
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Page<BlogType> search(int blogId) {
/* 29 */     String sql = "select a.id,a.typeId,b.title,a.state from blog_type a INNER JOIN type b on a.typeId=b.id where a.blogId=#para(0) ";
/*    */     
/* 31 */     return this.dao.templateByString(sql, new Object[] { Integer.valueOf(blogId) }).paginate(1, 10);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Ret save(int accountId, Blog blog) {
/* 38 */     if (StrKit.isBlank(blog.getTitle())) {
/* 39 */       return Ret.fail("title 不能为空");
/*    */     }
/* 41 */     if (StrKit.isBlank(blog.getContent())) {
/* 42 */       return Ret.fail("content 不能为空");
/*    */     }
/*    */     
/* 45 */     blog.setAccountId(Integer.valueOf(accountId));
/* 46 */     blog.setState(Integer.valueOf(0));
/* 47 */     blog.setCreated(new Date());
/* 48 */     blog.setUpdated(blog.getCreated());
/* 49 */     blog.setViewCount(Integer.valueOf(0));
/* 50 */     blog.save();
/* 51 */     return Ret.ok("msg", "创建成功");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Ret update(Blog blog) {
/* 58 */     blog.setUpdated(new Date());
/* 59 */     blog.update();
/* 60 */     return Ret.ok("msg", "更新成功");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Ret publish(int id, boolean checked) {
/* 67 */     int state = checked ? 1 : 0;
/* 68 */     String sql = "update blog set state = ? where id = ?";
/* 69 */     Db.update(sql, new Object[] { Integer.valueOf(state), Integer.valueOf(id) });
/* 70 */     return Ret.ok();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Ret deleteById(int id) {
/* 77 */     this.dao.deleteById(Integer.valueOf(id));
/* 78 */     return Ret.ok("msg", "删除成功");
/*    */   }
/*    */ }


/* Location:              /Users/nn/eclipse-workspace/jfinal-blog/jfinal-blog-5.0.0.jar!/com/jfinal/app/blog/_admin/blog/type/BlogTypeAdminService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */