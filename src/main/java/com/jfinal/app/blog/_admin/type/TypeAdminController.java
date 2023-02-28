/*    */ package com.jfinal.app.blog._admin.type;
/*    */ 
/*    */ import com.jfinal.aop.Inject;
/*    */ import com.jfinal.app.blog.common.BaseController;
/*    */ import com.jfinal.app.blog.common.model.Type;
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
/*    */ @Path(value = "/admin/type", viewPath = "/type")
/*    */ public class TypeAdminController
/*    */   extends BaseController
/*    */ {
/*    */   @Inject
/*    */   TypeAdminService srv;
/*    */   
/*    */   public void index() {
/* 31 */     int pn = getInt("pn", Integer.valueOf(1)).intValue();
/* 32 */     String searchKey = get("searchKey");
/*    */     
/* 34 */     Page<Type> page = StrKit.isBlank(searchKey) ? this.srv.paginate(pn) : this.srv.search(searchKey, pn);
/*    */ 
/*    */     
/* 37 */     keepPara(new String[] { "searchKey" });
/* 38 */     set("page", page);
/* 39 */     render("index.html");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void publish() {
/* 46 */     Ret ret = this.srv.publish(getInt("id").intValue(), getBoolean("checked").booleanValue());
/* 47 */     renderJson(ret);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void add() {
/* 54 */     render("add_edit.html");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void save() {
/* 61 */     Ret ret = this.srv.save(getLoginAccountId(), (Type)getBean(Type.class, "type"));
/* 62 */     renderJson(ret);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void edit() {
/* 69 */     set("type", this.srv.getById(getInt("id").intValue()));
/* 70 */     render("add_edit.html");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void update() {
/* 77 */     Ret ret = this.srv.update((Type)getBean(Type.class, "type"));
/* 78 */     renderJson(ret);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void delete() {
/* 85 */     Ret ret = this.srv.deleteById(getInt("id").intValue());
/* 86 */     renderJson(ret);
/*    */   }
/*    */ }


/* Location:              /Users/nn/eclipse-workspace/jfinal-blog/jfinal-blog-5.0.0.jar!/com/jfinal/app/blog/_admin/type/TypeAdminController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */