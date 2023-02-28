/*    */ package com.jfinal.app.blog._admin.common;
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
/*    */ public class RunningTime
/*    */ {
/* 14 */   static long start = System.currentTimeMillis() / 1000L;
/*    */   
/*    */   static final int secondsInMinute = 60;
/*    */   
/*    */   static final int secondsInHour = 3600;
/*    */   
/*    */   static final int secondsInDay = 86400;
/*    */ 
/*    */   
/*    */   public static String getRunningTime() {
/* 24 */     long end = System.currentTimeMillis() / 1000L;
/* 25 */     int duration = (int)(end - start);
/*    */     
/* 27 */     int day = duration / 86400;
/* 28 */     int r = duration % 86400;
/*    */     
/* 30 */     int hour = r / 3600;
/* 31 */     r %= 3600;
/*    */     
/* 33 */     int minute = r / 60;
/* 34 */     int seconds = r % 60;
/*    */     
/* 36 */     StringBuilder ret = new StringBuilder();
/*    */     
/* 38 */     if (day > 0) {
/* 39 */       ret.append(day).append("天");
/*    */     }
/* 41 */     if (hour > 0 || ret.length() > 0) {
/* 42 */       ret.append(hour).append("小时");
/*    */     }
/* 44 */     if (minute > 0 || ret.length() > 0) {
/* 45 */       ret.append(minute).append("分");
/*    */     }
/* 47 */     if (seconds > 0 || ret.length() > 0) {
/* 48 */       ret.append(seconds).append("秒");
/*    */     }
/*    */     
/* 51 */     return ret.toString();
/*    */   }
/*    */   
/*    */   public static void main(String[] args) {
/* 55 */     start = start - 480L - 0L - 86400L;
/* 56 */     System.out.println(getRunningTime());
/*    */   }
/*    */ }


/* Location:              /Users/nn/eclipse-workspace/jfinal-blog/jfinal-blog-5.0.0.jar!/com/jfinal/app/blog/_admin/common/RunningTime.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */