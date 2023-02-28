/*     */ package com.jfinal.app.blog.common.model.base;
/*     */ 
/*     */ import com.jfinal.plugin.activerecord.IBean;
/*     */ import com.jfinal.plugin.activerecord.Model;
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ public abstract class BaseType<M extends BaseType<M>>
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
/*     */   public void setAccountId(Integer accountId) {
/*  21 */     set("accountId", accountId);
/*     */   }
/*     */   
/*     */   public Integer getAccountId() {
/*  25 */     return getInt("accountId");
/*     */   }
/*     */   
/*     */   public void setTitle(String title) {
/*  29 */     set("title", title);
/*     */   }
/*     */   
/*     */   public String getTitle() {
/*  33 */     return getStr("title");
/*     */   }
/*     */   
/*     */   public void setContent(String content) {
/*  37 */     set("content", content);
/*     */   }
/*     */   
/*     */   public String getContent() {
/*  41 */     return getStr("content");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPic(String pic) {
/*  48 */     set("pic", pic);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPic() {
/*  55 */     return getStr("pic");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setState(Integer state) {
/*  62 */     set("state", state);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Integer getState() {
/*  69 */     return getInt("state");
/*     */   }
/*     */   
/*     */   public void setSeoKeywords(Integer seoKeywords) {
/*  73 */     set("seoKeywords", seoKeywords);
/*     */   }
/*     */   
/*     */   public Integer getSeoKeywords() {
/*  77 */     return getInt("seoKeywords");
/*     */   }
/*     */   
/*     */   public void setSeoDescription(Integer seoDescription) {
/*  81 */     set("seoDescription", seoDescription);
/*     */   }
/*     */   
/*     */   public Integer getSeoDescription() {
/*  85 */     return getInt("seoDescription");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setViewCount(Integer viewCount) {
/*  92 */     set("viewCount", viewCount);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Integer getViewCount() {
/*  99 */     return getInt("viewCount");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreated(Date created) {
/* 106 */     set("created", created);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreated() {
/* 113 */     return getDate("created");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdated(Date updated) {
/* 120 */     set("updated", updated);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdated() {
/* 127 */     return getDate("updated");
/*     */   }
/*     */ }


/* Location:              /Users/nn/eclipse-workspace/jfinal-blog/jfinal-blog-5.0.0.jar!/com/jfinal/app/blog/common/model/base/BaseType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */