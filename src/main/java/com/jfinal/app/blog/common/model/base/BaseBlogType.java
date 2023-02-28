/*    */ package com.jfinal.app.blog.common.model.base;
/*    */ 
/*    */ import com.jfinal.plugin.activerecord.IBean;
/*    */ import com.jfinal.plugin.activerecord.Model;
/*    */ import java.util.Date;
/*    */ 
/*    */ 
/*    */ public abstract class BaseBlogType<M extends BaseBlogType<M>>
/*    */   extends Model<M>
/*    */   implements IBean
/*    */ {
/*    */   public void setId(Integer id) {
/* 13 */     set("id", id);
/*    */   }
/*    */   
/*    */   public Integer getId() {
/* 17 */     return getInt("id");
/*    */   }
/*    */   
/*    */   public void setAccountId(Integer accountId) {
/* 21 */     set("accountId", accountId);
/*    */   }
/*    */   
/*    */   public Integer getAccountId() {
/* 25 */     return getInt("accountId");
/*    */   }
/*    */   
/*    */   public void setBlogId(String blogId) {
/* 29 */     set("blogId", blogId);
/*    */   }
/*    */   
/*    */   public String getBlogId() {
/* 33 */     return getStr("blogId");
/*    */   }
/*    */   
/*    */   public void setTypeId(String typeId) {
/* 37 */     set("typeId", typeId);
/*    */   }
/*    */   
/*    */   public String getTypeId() {
/* 41 */     return getStr("typeId");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setState(Integer state) {
/* 48 */     set("state", state);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Integer getState() {
/* 55 */     return getInt("state");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setCreated(Date created) {
/* 62 */     set("created", created);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Date getCreated() {
/* 69 */     return getDate("created");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setUpdated(Date updated) {
/* 76 */     set("updated", updated);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Date getUpdated() {
/* 83 */     return getDate("updated");
/*    */   }
/*    */ }


/* Location:              /Users/nn/eclipse-workspace/jfinal-blog/jfinal-blog-5.0.0.jar!/com/jfinal/app/blog/common/model/base/BaseBlogType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */