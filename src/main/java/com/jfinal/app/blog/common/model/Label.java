/*    */ package com.jfinal.app.blog.common.model;
/*    */ 
/*    */ import com.jfinal.app.blog.common.kit.JsoupFilter;
/*    */ import com.jfinal.app.blog.common.model.base.BlogLabel;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Label
/*    */   extends BlogLabel<Label>
/*    */ {
/*    */   public static final int STATE_PUBLISHED = 1;
/*    */   public static final int STATE_UNPUBLISHED = 0;
/*    */   
/*    */   public boolean isPublished() {
/* 18 */     return (getInt("state").intValue() == 1);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isUnpublished() {
/* 25 */     return (getInt("state").intValue() == 0);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getBrief() {
/* 32 */     String ret = getContent();
/* 33 */     ret = JsoupFilter.getText(ret);
/* 34 */     if (ret != null && ret.length() > 140) {
/* 35 */       ret = ret.substring(0, 140) + "...";
/*    */     }
/* 37 */     return ret;
/*    */   }
/*    */ }


/* Location:              /Users/nn/eclipse-workspace/jfinal-blog/jfinal-blog-5.0.0.jar!/com/jfinal/app/blog/common/model/Label.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */