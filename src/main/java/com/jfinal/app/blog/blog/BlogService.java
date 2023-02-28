/*    */ package com.jfinal.app.blog.blog;
/*    */ 
/*    */ import com.jfinal.app.blog.common.ImageUpload;
/*    */ import com.jfinal.app.blog.common.model.Blog;
/*    */ import com.jfinal.kit.StrKit;
/*    */ import java.util.List;
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
/*    */ public class BlogService
/*    */ {
/* 20 */   private Blog dao = (Blog)(new Blog()).dao();
/*    */   
/*    */   public List<Blog> getAllBlogs() {
/* 23 */     String sql = "select a.id, b.nickName as nickName,b.avatar, a.title, left(a.content, 200) as content, a.created, a.updated from blog a\r\nLEFT JOIN account b on a.accountId = b.id\r\nwhere a.state = ? and a.del=0 order by a.created desc";
/*    */ 
/*    */     
/* 26 */     return this.dao.find(sql, new Object[] { Integer.valueOf(1) });
/*    */   }
/*    */   
/*    */   public Blog getById(int id) {
/* 30 */     String sql = "select * from blog where id = ? and state = ? limit 1";
/* 31 */     Blog blog = (Blog)this.dao.findFirst(sql, new Object[] { Integer.valueOf(id), Integer.valueOf(1) });
/* 32 */     if (blog != null) {
/* 33 */       String content = blog.getContent();
/* 34 */       if (StrKit.notBlank(content)) {
/* 35 */         content = content.replaceAll("src=\"", "src=\"" + ImageUpload.UploadDema);
/* 36 */         blog.setContent(content);
/*    */       } 
/*    */     } 
/* 39 */     return blog;
/*    */   }
/*    */   
/*    */   public List<Blog> getAllHomeBlogs() {
/* 43 */     String sql = "select a.id, b.nickName as nickName,b.avatar, a.title, left(a.content, 200) as content, a.created, a.updated from blog a\r\nLEFT JOIN account b on a.accountId = b.id\r\nwhere a.state = ? and a.status='02' and a.del=0 order by a.created desc";
/*    */ 
/*    */     
/* 46 */     return this.dao.find(sql, new Object[] { Integer.valueOf(1) });
/*    */   }
/*    */   
/*    */   public Object getAllHomeBlogsAccount(int accountId) {
/* 50 */     String sql = "select a.id, b.nickName as nickName,b.avatar, a.title, left(a.content, 200) as content, a.created, a.updated from blog a\r\nLEFT JOIN account b on a.accountId = b.id\r\nwhere a.state = ? and a.status='02' and  a.accountId=? and a.del=0 order by a.created desc";
/*    */ 
/*    */     
/* 53 */     return this.dao.find(sql, new Object[] { Integer.valueOf(1), Integer.valueOf(accountId) });
/*    */   }
/*    */   
/*    */   public Object getAllBlogsAccount(Integer accountId) {
/* 57 */     String sql = "select a.id, b.nickName as nickName,b.avatar, a.title, left(a.content, 200) as content, a.created, a.updated from blog a\r\nLEFT JOIN account b on a.accountId = b.id\r\nwhere a.state = ? and  a.accountId=? and a.del=0 order by a.created desc";
/*    */ 
/*    */     
/* 60 */     return this.dao.find(sql, new Object[] { Integer.valueOf(1), accountId });
/*    */   }
/*    */ }


/* Location:              /Users/nn/eclipse-workspace/jfinal-blog/jfinal-blog-5.0.0.jar!/com/jfinal/app/blog/blog/BlogService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */