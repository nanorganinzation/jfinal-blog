/*     */ package com.jfinal.app.blog._admin.Files;
/*     */ 
/*     */ import com.jfinal.app.blog.common.FileUtil;
/*     */ import com.jfinal.app.blog.common.ImageUpload;
/*     */ import com.jfinal.app.blog.common.kit.ImageKit;
/*     */ import com.jfinal.app.blog.common.model.Files;
/*     */ import com.jfinal.kit.Ret;
/*     */ import com.jfinal.kit.StrKit;
/*     */ import com.jfinal.kit.TimeKit;
/*     */ import com.jfinal.plugin.activerecord.Db;
/*     */ import com.jfinal.plugin.activerecord.Page;
/*     */ import com.jfinal.upload.UploadFile;
/*     */ import java.io.File;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.time.LocalDateTime;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ImageAdminService
/*     */ {
/*  32 */   int imageMaxSize = 20971520;
/*     */   
/*  34 */   String tempUploadPath = "/temp";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  41 */   String relativePath = "/Files/";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final String FILE_PATH_DATE_FORMAT = "yyyyMM";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Ret upload(int accountId, UploadFile uf) {
/*  59 */     Ret ret = checkUploadFile(uf);
/*  60 */     if (ret != null) {
/*  61 */       return ret;
/*     */     }
/*  63 */     String fileName = buildSaveFileName(accountId, uf);
/*  64 */     String fileType = "." + ImageKit.getExtName(uf.getFileName());
/*  65 */     int length = (int)uf.getFile().length();
/*     */     
/*  67 */     String filePath = "/" + (new SimpleDateFormat("yyyyMM")).format(new Date());
/*  68 */     String uploadPath = ImageUpload.baseUploadPath + filePath;
/*  69 */     FileUtil.mkdir(uploadPath);
/*  70 */     String fullFileName = uploadPath + "/" + fileName;
/*  71 */     saveOriginalFileToTargetFile(uf.getFile(), fullFileName);
/*  72 */     String showName = uf.getOriginalFileName();
/*     */     
/*  74 */     Files files = new Files();
/*  75 */     files.setAccountId(Integer.valueOf(accountId));
/*  76 */     files.setFileName(fileName);
/*  77 */     files.setShowName(showName);
/*  78 */     files.setPath(filePath);
/*  79 */     files.setCreated(new Date());
/*  80 */     files.setLength(Integer.valueOf(length));
/*  81 */     files.setFileType(fileType);
/*  82 */     files.save();
/*  83 */     String url = ImageUpload.UploadPath + fullFileName;
/*  84 */     return createUploadOkRet(fileName, url);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String buildSaveFileName(int accountId, UploadFile uf) {
/*  91 */     String time = TimeKit.format(LocalDateTime.now(), "yyyyMMddHHmmss");
/*  92 */     String extName = "." + ImageKit.getExtName(uf.getFileName());
/*  93 */     return accountId + "_" + time + extName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void saveOriginalFileToTargetFile(File originalFile, String targetFile) {
/* 101 */     originalFile.renameTo(new File(targetFile));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Ret checkUploadFile(UploadFile uf) {
/* 108 */     if (uf == null || uf.getFile() == null) {
/* 109 */       return createUploadFailRet("上传文件为 null");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 115 */     if (uf.getFile().length() > this.imageMaxSize) {
/* 116 */       uf.getFile().delete();
/* 117 */       return createUploadFailRet("图片尺寸超出范畴: " + (this.imageMaxSize / 1024) + "KB");
/*     */     } 
/* 119 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Ret createUploadOkRet(String fileName, String url) {
/* 127 */     return Ret.of("uploaded", Integer.valueOf(1)).set("fileName", fileName).set("url", url);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Ret createUploadFailRet(String msg) {
/* 135 */     Ret ret = Ret.of("uploaded", Integer.valueOf(0)).set("fileName", "foo.jpg");
/* 136 */     return ret.set("error", Ret.of("message", msg));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 141 */   private static int pageSize = 30;
/* 142 */   private Files dao = (Files)(new Files()).dao();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Page<Files> paginate(int pageNumber, int accountId, String fileType) {
/* 148 */     if (1 == accountId) {
/* 149 */       if (StrKit.isBlank(fileType)) {
/* 150 */         return this.dao.paginate(pageNumber, pageSize, "select *", "from files where del=0 order by created desc");
/*     */       }
/* 152 */       return this.dao.paginate(pageNumber, pageSize, "select *", "from files where del=0 and fileType in(select name from files_type WHERE fileType=? and del=0 ) order by created desc", new Object[] { fileType });
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 157 */     if (StrKit.isBlank(fileType))
/* 158 */       return this.dao.paginate(pageNumber, pageSize, "select *", "from files where del=0 and accountId=? order by created desc", new Object[] {
/* 159 */             Integer.valueOf(accountId)
/*     */           }); 
/* 161 */     return this.dao.paginate(pageNumber, pageSize, "select *", "from files where del=0 and accountId=? and fileType in( select name from files_type WHERE fileType=? and del=0 ) order by created desc", new Object[] {
/*     */           
/* 163 */           Integer.valueOf(accountId), fileType
/*     */         });
/*     */   }
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
/*     */ 
/*     */   
/*     */   public Ret deleteById(int id) {
/* 182 */     String sql = "update files set del = 1 where id = ?";
/* 183 */     Db.update(sql, new Object[] { Integer.valueOf(id) });
/* 184 */     return Ret.ok("msg", "删除成功");
/*     */   }
/*     */ }


/* Location:              /Users/nn/eclipse-workspace/jfinal-blog/jfinal-blog-5.0.0.jar!/com/jfinal/app/blog/_admin/Files/ImageAdminService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */