/*     */ package com.jfinal.app.blog._admin.Files;
/*     */ 
/*     */ import com.jfinal.aop.Clear;
/*     */ import com.jfinal.aop.Inject;
/*     */ import com.jfinal.app.blog._admin.common.AdminInterceptor;
/*     */ import com.jfinal.app.blog.common.BaseController;
/*     */ import com.jfinal.app.blog.common.ImageUpload;
/*     */ import com.jfinal.app.blog.common.model.Files;
/*     */ import com.jfinal.core.Path;
/*     */ import com.jfinal.kit.Ret;
/*     */ import com.jfinal.log.Log;
/*     */ import com.jfinal.plugin.activerecord.Page;
/*     */ import com.jfinal.upload.ExceededSizeException;
/*     */ import com.jfinal.upload.UploadFile;
/*     */ import java.util.List;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ @Path(value = "/admin/file", viewPath = "/files")
/*     */ public class FileAdminController
/*     */   extends BaseController
/*     */ {
/*     */   @Inject
/*     */   ImageAdminService srv;
/*     */   
/*     */   public void index() {
/*  37 */     int accountId = getLoginAccountId();
/*  38 */     Page<Files> page = this.srv.paginate(getInt("pn", Integer.valueOf(1)).intValue(), accountId, "");
/*  39 */     if (page != null) {
/*  40 */       List<Files> list = page.getList();
/*  41 */       if (list != null && list.size() > 0) {
/*  42 */         for (Files image : list) {
/*  43 */           image.setSrcImg();
/*     */         }
/*     */       }
/*     */     } 
/*  47 */     set("page", page);
/*  48 */     set("UploadPath", ImageUpload.UploadPath);
/*  49 */     set("UploadDema", ImageUpload.UploadDema);
/*  50 */     render("index2.html");
/*     */   }
/*     */   
/*     */   public void img() {
/*  54 */     String fileType = get("fileType");
/*  55 */     fileType = "1";
/*  56 */     int accountId = getLoginAccountId();
/*  57 */     Page<Files> page = this.srv.paginate(getInt("pn", Integer.valueOf(1)).intValue(), accountId, fileType);
/*  58 */     if (page != null) {
/*  59 */       List<Files> list = page.getList();
/*  60 */       if (list != null && list.size() > 0) {
/*  61 */         for (Files image : list) {
/*  62 */           image.setSrcImg();
/*     */         }
/*     */       }
/*     */     } 
/*  66 */     set("page", page);
/*  67 */     set("UploadPath", ImageUpload.UploadPath);
/*  68 */     set("UploadDema", ImageUpload.UploadDema);
/*  69 */     render("img.html");
/*     */   }
/*     */   
/*     */   public void files() {
/*  73 */     String fileType = get("fileType");
/*  74 */     fileType = "2";
/*  75 */     int accountId = getLoginAccountId();
/*  76 */     Page<Files> page = this.srv.paginate(getInt("pn", Integer.valueOf(1)).intValue(), accountId, fileType);
/*  77 */     if (page != null) {
/*  78 */       List<Files> list = page.getList();
/*  79 */       if (list != null && list.size() > 0) {
/*  80 */         for (Files image : list) {
/*  81 */           image.setSrcImg();
/*     */         }
/*     */       }
/*     */     } 
/*  85 */     set("page", page);
/*  86 */     set("UploadPath", ImageUpload.UploadPath);
/*  87 */     set("UploadDema", ImageUpload.UploadDema);
/*  88 */     render("files.html");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void add() {
/*  95 */     render("add.html");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void delete() {
/* 102 */     renderJson(this.srv.deleteById(getInt("id").intValue()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Clear({AdminInterceptor.class})
/*     */   public void upload() {
/* 113 */     String encoding = "utf-8";
/* 114 */     Integer maxPostSize = Integer.valueOf(20971520);
/* 115 */     UploadFile uf = null;
/*     */     try {
/* 117 */       getFiles(this.srv.tempUploadPath, maxPostSize.intValue(), encoding);
/* 118 */       uf = getFile();
/* 119 */       Ret ret = this.srv.upload(getLoginAccountId(), uf);
/* 120 */       renderJson(ret);
/* 121 */     } catch (ExceededSizeException ex) {
/*     */       
/* 123 */       renderJson(this.srv.createUploadFailRet("文件大小超出限制，最大允许长度为 : " + (this.srv.imageMaxSize / 1024) + "KB"));
/* 124 */     } catch (Exception e) {
/* 125 */       Log.getLog(getClass()).error(e.getMessage(), e);
/* 126 */       if (uf != null)
/*     */       {
/* 128 */         uf.getFile().delete();
/*     */       }
/* 130 */       renderJson(this.srv.createUploadFailRet("上传异常，请告知管理员：" + e.getMessage()));
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /Users/nn/eclipse-workspace/jfinal-blog/jfinal-blog-5.0.0.jar!/com/jfinal/app/blog/_admin/Files/FileAdminController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */