/*    */ package com.jfinal.app.blog._admin.index;
/*    */ 
/*    */ import com.jfinal.aop.Inject;
/*    */ import com.jfinal.app.blog._admin.account.AccountAdminService;
/*    */ import com.jfinal.app.blog.common.BaseController;
/*    */ import com.jfinal.app.blog.common.ImageUpload;
/*    */ import com.jfinal.app.blog.common.model.Files;
/*    */ import com.jfinal.core.Path;
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
/*    */ @Path(value = "/admin", viewPath = "/index")
/*    */ public class IndexAdminController
/*    */   extends BaseController
/*    */ {
/*    */   @Inject
/*    */   IndexAdminService srv;
/*    */   @Inject
/*    */   AccountAdminService accountAdminSrv;
/*    */   
/*    */   public void index() {
/* 31 */     set("isDefaultPassword", Boolean.valueOf(this.accountAdminSrv.isDefaultPassword(getLoginAccount())));
/* 32 */     render("index.html");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void overview() {
/* 39 */     int accountId = getLoginAccountId();
/* 40 */     set("totalBlog", Integer.valueOf(this.srv.getTotalBlog(accountId)));
/* 41 */     set("totalImage", Integer.valueOf(this.srv.getTotalImage(accountId)));
/* 42 */     set("totalAccount", Integer.valueOf(this.srv.getTotalAccount(accountId)));
/* 43 */     set("UploadPath", ImageUpload.UploadPath);
/* 44 */     set("UploadDema", ImageUpload.UploadDema);
/* 45 */     render("_overview.html");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void latestImage() {
/* 52 */     int accountId = getLoginAccountId();
/* 53 */     List<Files> list = this.srv.getLatestImage(accountId);
/* 54 */     if (list != null && list.size() > 0) {
/* 55 */       for (Files image : list) {
/* 56 */         image.setSrcImg();
/*    */       }
/*    */     }
/* 59 */     set("latestImage", list);
/* 60 */     set("UploadPath", ImageUpload.UploadPath);
/* 61 */     set("UploadDema", ImageUpload.UploadDema);
/* 62 */     render("_latest_image.html");
/*    */   }
/*    */ }


/* Location:              /Users/nn/eclipse-workspace/jfinal-blog/jfinal-blog-5.0.0.jar!/com/jfinal/app/blog/_admin/index/IndexAdminController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */