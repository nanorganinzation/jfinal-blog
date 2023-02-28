/*    */ package com.jfinal.app.blog.common.model;
/*    */ 
/*    */ import com.jfinal.app.blog.common.kit.JsoupFilter;
/*    */ import com.jfinal.app.blog.common.model.base.BaseAccount;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Account
/*    */   extends BaseAccount<Account>
/*    */ {
/*    */   public static final String AVATAR_NO_AVATAR = "x.jpg";
/*    */   public static final int STATE_LOCK = -1;
/*    */   public static final int STATE_REG = 0;
/*    */   public static final int STATE_OK = 1;
/*    */   
/*    */   public boolean isStateOk() {
/* 19 */     return (getState().intValue() == 1);
/*    */   }
/*    */   
/*    */   public boolean isStateReg() {
/* 23 */     return (getState().intValue() == 0);
/*    */   }
/*    */   
/*    */   public boolean isStateLock() {
/* 27 */     return (getState().intValue() == -1);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void filter(int filterBy) {
/* 34 */     JsoupFilter.filterAccountNickName(this);
/*    */   }
/*    */   
/*    */   public Account removeSensitiveInfo() {
/* 38 */     remove(new String[] { "password", "salt" });
/* 39 */     return this;
/*    */   }
/*    */ }


/* Location:              /Users/nn/eclipse-workspace/jfinal-blog/jfinal-blog-5.0.0.jar!/com/jfinal/app/blog/common/model/Account.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */