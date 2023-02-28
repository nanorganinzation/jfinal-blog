/*    */ package com.jfinal.app.blog.common.kit;
/*    */ 
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IpKit
/*    */ {
/*    */   public static String getRealIp(HttpServletRequest request, String defaultValue) {
/* 14 */     String ip = getRealIp(request);
/* 15 */     return isInvalid(ip) ? defaultValue : ip;
/*    */   }
/*    */   
/*    */   public static String getRealIp(HttpServletRequest request) {
/* 19 */     String ip = request.getHeader("x-forwarded-for");
/* 20 */     if (isInvalid(ip)) {
/* 21 */       ip = request.getHeader("Proxy-Client-IP");
/*    */     }
/* 23 */     if (isInvalid(ip)) {
/* 24 */       ip = request.getHeader("WL-Proxy-Client-IP");
/*    */     }
/* 26 */     if (isInvalid(ip)) {
/* 27 */       ip = request.getRemoteAddr();
/*    */     }
/* 29 */     return ip;
/*    */   }
/*    */   
/*    */   static boolean isInvalid(String ip) {
/* 33 */     return (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip));
/*    */   }
/*    */   
/*    */   public static String getRealIpV2(HttpServletRequest request) {
/* 37 */     String accessIP = request.getHeader("x-forwarded-for");
/* 38 */     if (null == accessIP)
/* 39 */       return request.getRemoteAddr(); 
/* 40 */     return accessIP;
/*    */   }
/*    */ }


/* Location:              /Users/nn/eclipse-workspace/jfinal-blog/jfinal-blog-5.0.0.jar!/com/jfinal/app/blog/common/kit/IpKit.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */