/*    */ package com.jfinal.app.blog.common.model.base;
/*    */ 
/*    */ import com.jfinal.plugin.activerecord.IBean;
/*    */ import com.jfinal.plugin.activerecord.Model;
/*    */ import java.util.Date;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class BaseSession<M extends BaseSession<M>>
/*    */   extends Model<M>
/*    */   implements IBean
/*    */ {
/*    */   public void setId(String id) {
/* 16 */     set("id", id);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getId() {
/* 23 */     return getStr("id");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setAccountId(Integer accountId) {
/* 30 */     set("accountId", accountId);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Integer getAccountId() {
/* 37 */     return getInt("accountId");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setCreated(Date created) {
/* 44 */     set("created", created);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Date getCreated() {
/* 51 */     return getDate("created");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setExpires(Date expires) {
/* 58 */     set("expires", expires);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Date getExpires() {
/* 65 */     return getDate("expires");
/*    */   }
/*    */ }


/* Location:              /Users/nn/eclipse-workspace/jfinal-blog/jfinal-blog-5.0.0.jar!/com/jfinal/app/blog/common/model/base/BaseSession.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */