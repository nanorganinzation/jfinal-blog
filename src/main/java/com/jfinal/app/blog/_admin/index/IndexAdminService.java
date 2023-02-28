/*    */ package com.jfinal.app.blog._admin.index;
/*    */ 
/*    */ import com.jfinal.app.blog.common.model.Files;
/*    */ import com.jfinal.plugin.activerecord.Db;
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
/*    */ 
/*    */ 
/*    */ public class IndexAdminService
/*    */ {
/*    */   public int getTotalBlog(int accountId) {
/* 22 */     if (1 == accountId) {
/* 23 */       return Db.queryInt("select count(*) from blog where del=0").intValue();
/*    */     }
/* 25 */     return Db.queryInt("select count(*) from blog where del=0 and accountId=?", new Object[] { Integer.valueOf(accountId) }).intValue();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getTotalImage(int accountId) {
/* 32 */     if (1 == accountId) {
/* 33 */       return Db.queryInt("select count(*) from files where del=0").intValue();
/*    */     }
/* 35 */     return Db.queryInt("select count(*) from files where del=0 and accountId=?", new Object[] { Integer.valueOf(accountId) }).intValue();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getTotalAccount(int accountId) {
/* 42 */     if (1 == accountId) {
/* 43 */       return Db.queryInt("select count(*) from account where del=0").intValue();
/*    */     }
/* 45 */     return Db.queryInt("select count(*) from account where del=0 and id=?", new Object[] { Integer.valueOf(accountId) }).intValue();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public List<Files> getLatestImage(int accountId) {
/* 52 */     if (1 == accountId) {
/* 53 */       return (new Files()).find("select * from files where del=0 order by created desc limit 10");
/*    */     }
/* 55 */     return (new Files()).find("select * from files where del=0 and accountId=? order by created desc limit 10", new Object[] {
/* 56 */           Integer.valueOf(accountId)
/*    */         });
/*    */   }
/*    */ }


/* Location:              /Users/nn/eclipse-workspace/jfinal-blog/jfinal-blog-5.0.0.jar!/com/jfinal/app/blog/_admin/index/IndexAdminService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */