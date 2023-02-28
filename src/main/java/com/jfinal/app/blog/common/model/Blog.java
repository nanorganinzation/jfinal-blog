/*    */ package com.jfinal.app.blog.common.model;
/*    */ 
/*    */ import com.jfinal.app.blog.common.kit.JsoupFilter;
/*    */ import com.jfinal.app.blog.common.model.base.BaseBlog;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Blog
/*    */   extends BaseBlog<Blog>
/*    */ {
/*    */   public static final int STATE_PUBLISHED = 1;
/*    */   public static final int STATE_UNPUBLISHED = 0;
/*    */   public static final String STATUS_01 = "01";
/*    */   public static final String STATUS_02 = "02";
/*    */   
/*    */   public boolean isPublished() {
/* 22 */     return (getInt("state").intValue() == 1);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isUnpublished() {
/* 29 */     return (getInt("state").intValue() == 0);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getBrief() {
/* 36 */     String ret = getContent();
/* 37 */     ret = JsoupFilter.getText(ret);
/* 38 */     if (ret != null && ret.length() > 140) {
/* 39 */       ret = ret.substring(0, 140) + "...";
/*    */     }
/* 41 */     return ret;
/*    */   }
/*    */ }


/* Location:              /Users/nn/eclipse-workspace/jfinal-blog/jfinal-blog-5.0.0.jar!/com/jfinal/app/blog/common/model/Blog.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */