/*    */ package com.jfinal.app.blog._admin.type;
/*    */ 
/*    */ import com.jfinal.app.blog.common.model.Type;
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
/*    */ public class TypeAdminService
/*    */ {
/* 22 */   private static int pageSize = 25;
/* 23 */   private Type dao = (Type)(new Type()).dao();
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Page<Type> paginate(int pageNumber) {
/* 29 */     return this.dao.paginate(pageNumber, pageSize, "select *", "from type order by updated desc");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Page<Type> search(String key, int pageNumber) {
/* 36 */     String sql = "select * from type where title like concat('%', #para(0), '%') order by updated desc";
/* 37 */     return this.dao.templateByString(sql, new Object[] { key }).paginate(pageNumber, pageSize);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Ret save(int accountId, Type blog) {
/* 44 */     if (StrKit.isBlank(blog.getTitle())) {
/* 45 */       return Ret.fail("title 不能为空");
/*    */     }
/* 47 */     blog.setAccountId(Integer.valueOf(accountId));
/* 48 */     blog.setState(Integer.valueOf(0));
/* 49 */     blog.setCreated(new Date());
/* 50 */     blog.setUpdated(blog.getCreated());
/* 51 */     blog.setViewCount(Integer.valueOf(0));
/* 52 */     blog.save();
/* 53 */     return Ret.ok("msg", "创建成功");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Ret update(Type blogtype) {
/* 60 */     System.err.println(blogtype.toJson());
/* 61 */     blogtype.setUpdated(new Date());
/* 62 */     blogtype.update();
/* 63 */     return Ret.ok("msg", "更新成功");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Ret publish(int id, boolean checked) {
/* 70 */     int state = checked ? 1 : 0;
/* 71 */     String sql = "update type set state = ? where id = ?";
/* 72 */     Db.update(sql, new Object[] { Integer.valueOf(state), Integer.valueOf(id) });
/* 73 */     return Ret.ok();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Type getById(int id) {
/* 80 */     return (Type)this.dao.findById(Integer.valueOf(id));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Ret deleteById(int id) {
/* 87 */     this.dao.deleteById(Integer.valueOf(id));
/* 88 */     return Ret.ok("msg", "删除成功");
/*    */   }
/*    */ }


/* Location:              /Users/nn/eclipse-workspace/jfinal-blog/jfinal-blog-5.0.0.jar!/com/jfinal/app/blog/_admin/type/TypeAdminService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */