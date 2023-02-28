/*     */ package com.jfinal.app.blog.common.model.base;
/*     */ 
/*     */ import com.jfinal.plugin.activerecord.IBean;
/*     */ import com.jfinal.plugin.activerecord.Model;
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ public abstract class BaseAccount<M extends BaseAccount<M>>
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
/*     */   public void setDisplay(String display) {
/*  21 */     set("display", display);
/*     */   }
/*     */   
/*     */   public String getDisplay() {
/*  25 */     return getStr("display");
/*     */   }
/*     */   
/*     */   public void setNickName(String nickName) {
/*  29 */     set("nickName", nickName);
/*     */   }
/*     */   
/*     */   public String getNickName() {
/*  33 */     return getStr("nickName");
/*     */   }
/*     */   
/*     */   public void setUserName(String userName) {
/*  37 */     set("userName", userName);
/*     */   }
/*     */   
/*     */   public String getUserName() {
/*  41 */     return getStr("userName");
/*     */   }
/*     */   
/*     */   public void setPassword(String password) {
/*  45 */     set("password", password);
/*     */   }
/*     */   
/*     */   public String getPassword() {
/*  49 */     return getStr("password");
/*     */   }
/*     */   
/*     */   public void setSalt(String salt) {
/*  53 */     set("salt", salt);
/*     */   }
/*     */   
/*     */   public String getSalt() {
/*  57 */     return getStr("salt");
/*     */   }
/*     */   
/*     */   public void setState(Integer state) {
/*  61 */     set("state", state);
/*     */   }
/*     */   
/*     */   public Integer getState() {
/*  65 */     return getInt("state");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAvatar(String avatar) {
/*  72 */     set("avatar", avatar);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAvatar() {
/*  79 */     return getStr("avatar");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreated(Date created) {
/*  86 */     set("created", created);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreated() {
/*  93 */     return getDate("created");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdated(Date updated) {
/* 100 */     set("updated", updated);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdated() {
/* 107 */     return getDate("updated");
/*     */   }
/*     */ }


/* Location:              /Users/nn/eclipse-workspace/jfinal-blog/jfinal-blog-5.0.0.jar!/com/jfinal/app/blog/common/model/base/BaseAccount.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */