/*     */ package com.jfinal.app.blog._admin.blog;
/*     */ 
/*     */ import com.jfinal.app.blog.common.model.Blog;
/*     */ import com.jfinal.kit.Ret;
/*     */ import com.jfinal.kit.StrKit;
/*     */ import com.jfinal.plugin.activerecord.Db;
/*     */ import com.jfinal.plugin.activerecord.Page;
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlogAdminService
/*     */ {
/*  21 */   private static int pageSize = 25;
/*  22 */   private Blog dao = (Blog)(new Blog()).dao();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Page<Blog> paginate(int pageNumber, int accountId) {
/*  28 */     if (1 == accountId) {
/*  29 */       return this.dao.paginate(pageNumber, pageSize, "select *", "from blog where del=0 order by created desc");
/*     */     }
/*  31 */     return this.dao.paginate(pageNumber, pageSize, "select *", "from blog where accountId=? and del=0 order by created desc", new Object[] {
/*  32 */           Integer.valueOf(accountId)
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Page<Blog> search(String key, int pageNumber, int accountId) {
/*  39 */     if (1 == accountId) {
/*  40 */       String str = "select * from blog where title like concat('%', #para(0), '%') and  del=0 order by created desc";
/*  41 */       return this.dao.templateByString(str, new Object[] { key }).paginate(pageNumber, pageSize);
/*     */     } 
/*  43 */     String sql = "select * from blog where accountId=? and title like concat('%', #para(0), '%') and  del=0 order by created desc";
/*  44 */     return this.dao.templateByString(sql, new Object[] { Integer.valueOf(accountId), key }).paginate(pageNumber, pageSize);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Ret save(int accountId, Blog blog) {
/*  51 */     if (StrKit.isBlank(blog.getTitle())) {
/*  52 */       return Ret.fail("title 不能为空");
/*     */     }
/*  54 */     if (StrKit.isBlank(blog.getContent())) {
/*  55 */       return Ret.fail("content 不能为空");
/*     */     }
/*  57 */     blog.setAccountId(Integer.valueOf(accountId));
/*  58 */     blog.setState(Integer.valueOf(0));
/*  59 */     blog.setCreated(new Date());
/*  60 */     blog.setUpdated(blog.getCreated());
/*  61 */     blog.setViewCount(Integer.valueOf(0));
/*  62 */     blog.save();
/*  63 */     return Ret.ok("msg", "创建成功");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Ret update(Blog blog) {
/*  70 */     blog.setUpdated(new Date());
/*  71 */     blog.update();
/*  72 */     return Ret.ok("msg", "更新成功");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Ret publish(int id, boolean checked) {
/*  79 */     int state = checked ? 1 : 0;
/*  80 */     String sql = "update blog set state = ? where id = ?";
/*  81 */     Db.update(sql, new Object[] { Integer.valueOf(state), Integer.valueOf(id) });
/*  82 */     return Ret.ok();
/*     */   }
/*     */   
/*     */   public Ret status(int id, boolean checked) {
/*  86 */     String status = checked ? "02" : "01";
/*  87 */     String sql = "update blog set status = ? where id = ?";
/*  88 */     Db.update(sql, new Object[] { status, Integer.valueOf(id) });
/*  89 */     return Ret.ok();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Blog getById(int id) {
/*  96 */     Blog blog = (Blog)this.dao.findById(Integer.valueOf(id));
/*  97 */     return blog;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Ret deleteById(int id) {
/* 104 */     String sql = "update blog set del = 1 where id = ?";
/* 105 */     Db.update(sql, new Object[] { Integer.valueOf(id) });
/* 106 */     return Ret.ok("msg", "删除成功");
/*     */   }
/*     */ }


/* Location:              /Users/nn/eclipse-workspace/jfinal-blog/jfinal-blog-5.0.0.jar!/com/jfinal/app/blog/_admin/blog/BlogAdminService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */