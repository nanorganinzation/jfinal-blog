/*    */ package com.jfinal.app.blog.author;
/*    */ 
/*    */ import com.jfinal.app.blog.common.model.Blog;
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
/*    */ public class BlogService
/*    */ {
/* 17 */   private Blog dao = (Blog)(new Blog()).dao();
/*    */   
/*    */   public List<Blog> getAllBlogs() {
/* 20 */     String sql = "select a.id, b.nickName as nickName,b.avatar, a.title, left(a.content, 200) as content, a.created, a.updated from blog a\r\nLEFT JOIN account b on a.accountId = b.id\r\nwhere a.state = ? and a.del=0 order by a.created desc";
/*    */ 
/*    */     
/* 23 */     return this.dao.find(sql, new Object[] { Integer.valueOf(1) });
/*    */   }
/*    */   
/*    */   public Blog getById(int id) {
/* 27 */     String sql = "select * from blog where id = ? and state = ? limit 1";
/* 28 */     return (Blog)this.dao.findFirst(sql, new Object[] { Integer.valueOf(id), Integer.valueOf(1) });
/*    */   }
/*    */   
/*    */   public List<Blog> getAllHomeBlogs() {
/* 32 */     String sql = "select a.id, b.nickName as nickName,b.avatar, a.title, left(a.content, 200) as content, a.created, a.updated from blog a\r\nLEFT JOIN account b on a.accountId = b.id\r\nwhere a.state = ? and a.status='02' and a.del=0 order by a.created desc";
/*    */ 
/*    */     
/* 35 */     return this.dao.find(sql, new Object[] { Integer.valueOf(1) });
/*    */   }
/*    */   
/*    */   public Object getAllHomeBlogsAccount(int accountId) {
/* 39 */     String sql = "select a.id, b.nickName as nickName,b.avatar, a.title, left(a.content, 200) as content, a.created, a.updated from blog a\r\nLEFT JOIN account b on a.accountId = b.id\r\nwhere a.state = ? and a.status='02' and  a.accountId=? and a.del=0 order by a.created desc";
/*    */ 
/*    */     
/* 42 */     return this.dao.find(sql, new Object[] { Integer.valueOf(1), Integer.valueOf(accountId) });
/*    */   }
/*    */   
/*    */   public Object getAllBlogsAccount(Integer accountId) {
/* 46 */     String sql = "select a.id, b.nickName as nickName,b.avatar, a.title, left(a.content, 200) as content, a.created, a.updated from blog a\r\nLEFT JOIN account b on a.accountId = b.id\r\nwhere a.state = ? and  a.accountId=? and a.del=0 order by a.created desc";
/*    */ 
/*    */     
/* 49 */     return this.dao.find(sql, new Object[] { Integer.valueOf(1), accountId });
/*    */   }
/*    */ }


/* Location:              /Users/nn/eclipse-workspace/jfinal-blog/jfinal-blog-5.0.0.jar!/com/jfinal/app/blog/author/BlogService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */