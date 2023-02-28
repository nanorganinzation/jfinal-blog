/*    */ package com.jfinal.app.blog._admin.account;
/*    */ 
/*    */ import com.jfinal.aop.Inject;
/*    */ import com.jfinal.app.blog.common.BaseController;
/*    */ import com.jfinal.app.blog.common.model.Account;
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
/*    */ @Path(value = "/admin/account", viewPath = "/account")
/*    */ public class AccountAdminController
/*    */   extends BaseController
/*    */ {
/*    */   @Inject
/*    */   AccountAdminService srv;
/*    */   
/*    */   public void index() {
/* 30 */     int accountId = getLoginAccountId();
/*    */     
/* 32 */     int pn = getInt("pn", Integer.valueOf(1)).intValue();
/* 33 */     String searchKey = get("searchKey");
/*    */ 
/*    */     
/* 36 */     Page<Account> page = StrKit.isBlank(searchKey) ? this.srv.paginate(pn, accountId) : this.srv.search(searchKey, pn, accountId);
/*    */ 
/*    */     
/* 39 */     keepPara(new String[] { "searchKey" });
/* 40 */     set("page", page);
/* 41 */     render("index.html");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void switchState() {
/* 48 */     Ret ret = this.srv.switchState(getLoginAccountId(), getInt("id").intValue(), getBoolean("checked").booleanValue());
/* 49 */     renderJson(ret);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void add() {
/* 56 */     render("add_edit.html");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void save() {
/* 63 */     Ret ret = this.srv.save((Account)getBean(Account.class));
/* 64 */     renderJson(ret);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void edit() {
/* 71 */     set("account", this.srv.getById(getInt("id").intValue()));
/* 72 */     render("add_edit.html");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void update() {
/* 79 */     Ret ret = this.srv.update(getLoginAccountId(), (Account)getBean(Account.class));
/* 80 */     renderJson(ret);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void delete() {
/* 87 */     Ret ret = this.srv.deleteById(getLoginAccountId(), getInt("id").intValue());
/* 88 */     renderJson(ret);
/*    */   }
/*    */ }


/* Location:              /Users/nn/eclipse-workspace/jfinal-blog/jfinal-blog-5.0.0.jar!/com/jfinal/app/blog/_admin/account/AccountAdminController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */