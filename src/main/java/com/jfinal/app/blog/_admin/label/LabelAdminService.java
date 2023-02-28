/*    */ package com.jfinal.app.blog._admin.label;
/*    */ 
/*    */ import com.jfinal.app.blog.common.model.Label;
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
/*    */ public class LabelAdminService
/*    */ {
/* 22 */   private static int pageSize = 25;
/* 23 */   private Label dao = (Label)(new Label()).dao();
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Page<Label> paginate(int pageNumber) {
/* 29 */     return this.dao.paginate(pageNumber, pageSize, "select *", "from label order by state,created desc");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Page<Label> search(String key, int pageNumber) {
/* 36 */     String sql = "select * from label where title like concat('%', #para(0), '%') order by state,created desc";
/* 37 */     return this.dao.templateByString(sql, new Object[] { key }).paginate(pageNumber, pageSize);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Ret save(int accountId, Label blog) {
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
/*    */   public Ret update(Label blogtype) {
/* 60 */     blogtype.setUpdated(new Date());
/* 61 */     blogtype.update();
/* 62 */     return Ret.ok("msg", "更新成功");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Ret publish(int id, boolean checked) {
/* 69 */     int state = checked ? 1 : 0;
/* 70 */     String sql = "update label set state = ? where id = ?";
/* 71 */     Db.update(sql, new Object[] { Integer.valueOf(state), Integer.valueOf(id) });
/* 72 */     return Ret.ok();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Label getById(int id) {
/* 79 */     return (Label)this.dao.findById(Integer.valueOf(id));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Ret deleteById(int id) {
/* 86 */     this.dao.deleteById(Integer.valueOf(id));
/* 87 */     return Ret.ok("msg", "删除成功");
/*    */   }
/*    */ }


/* Location:              /Users/nn/eclipse-workspace/jfinal-blog/jfinal-blog-5.0.0.jar!/com/jfinal/app/blog/_admin/label/LabelAdminService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */