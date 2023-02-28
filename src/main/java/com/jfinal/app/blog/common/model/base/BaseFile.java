/*     */ package com.jfinal.app.blog.common.model.base;
/*     */ 
/*     */ import com.jfinal.plugin.activerecord.IBean;
/*     */ import com.jfinal.plugin.activerecord.Model;
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ public abstract class BaseFile<M extends BaseFile<M>>
/*     */   extends Model<M>
/*     */   implements IBean
/*     */ {
/*     */   public void setId(Integer id) {
/*  13 */     set("id", id);
/*     */   }
/*     */   
/*     */   public Integer getId() {
/*  17 */     return getInt("id");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAccountId(Integer accountId) {
/*  24 */     set("accountId", accountId);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Integer getAccountId() {
/*  31 */     return getInt("accountId");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPath(String path) {
/*  38 */     set("path", path);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPath() {
/*  45 */     return getStr("path");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFileName(String fileName) {
/*  52 */     set("fileName", fileName);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getFileName() {
/*  59 */     return getStr("fileName");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setShowName(String showName) {
/*  66 */     set("showName", showName);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getShowName() {
/*  73 */     return getStr("showName");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFileType(String fileType) {
/*  80 */     set("fileType", fileType);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getFileType() {
/*  87 */     return getStr("fileType");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLength(Integer length) {
/*  94 */     set("length", length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Integer getLength() {
/* 101 */     return getInt("length");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreated(Date created) {
/* 108 */     set("created", created);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreated() {
/* 115 */     return getDate("created");
/*     */   }
/*     */ }


/* Location:              /Users/nn/eclipse-workspace/jfinal-blog/jfinal-blog-5.0.0.jar!/com/jfinal/app/blog/common/model/base/BaseFile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */