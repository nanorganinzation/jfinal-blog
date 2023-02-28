/*    */ package com.jfinal.app.blog.common.model;
/*    */ 
/*    */ import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class _MappingKit
/*    */ {
/*    */   public static void mapping(ActiveRecordPlugin arp) {
/* 19 */     arp.addMapping("account", "id", Account.class);
/* 20 */     arp.addMapping("blog", "id", Blog.class);
/* 21 */     arp.addMapping("blog_type", "id", BlogType.class);
/* 22 */     arp.addMapping("files", "id", Files.class);
/* 23 */     arp.addMapping("label", "id", Label.class);
/* 24 */     arp.addMapping("session", "id", Session.class);
/* 25 */     arp.addMapping("type", "id", Type.class);
/*    */   }
/*    */ }


/* Location:              /Users/nn/eclipse-workspace/jfinal-blog/jfinal-blog-5.0.0.jar!/com/jfinal/app/blog/common/model/_MappingKit.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */