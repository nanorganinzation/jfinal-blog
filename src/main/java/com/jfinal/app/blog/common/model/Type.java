/*    */ package com.jfinal.app.blog.common.model;
/*    */ 
/*    */ import com.jfinal.app.blog.common.kit.JsoupFilter;
/*    */ import com.jfinal.app.blog.common.model.base.BaseType;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Type
/*    */   extends BaseType<Type>
/*    */ {
/*    */   public static final int STATE_PUBLISHED = 1;
/*    */   public static final int STATE_UNPUBLISHED = 0;
/*    */   
/*    */   public boolean isPublished() {
/* 19 */     return (getInt("state").intValue() == 1);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isUnpublished() {
/* 26 */     return (getInt("state").intValue() == 0);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getBrief() {
/* 33 */     String ret = getContent();
/* 34 */     ret = JsoupFilter.getText(ret);
/* 35 */     if (ret != null && ret.length() > 140) {
/* 36 */       ret = ret.substring(0, 140) + "...";
/*    */     }
/* 38 */     return ret;
/*    */   }
/*    */ }


/* Location:              /Users/nn/eclipse-workspace/jfinal-blog/jfinal-blog-5.0.0.jar!/com/jfinal/app/blog/common/model/Type.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */