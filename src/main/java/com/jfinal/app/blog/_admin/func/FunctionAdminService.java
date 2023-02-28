/*    */ package com.jfinal.app.blog._admin.func;
/*    */ 
/*    */ import com.jfinal.app.blog.common.model.Account;
/*    */ import com.jfinal.kit.Ret;
/*    */ import com.jfinal.plugin.activerecord.Db;
/*    */ import java.util.Date;
/*    */ import java.util.concurrent.ThreadLocalRandom;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FunctionAdminService
/*    */ {
/*    */   public Ret getTotalOrdersToday() {
/* 27 */     int n = ThreadLocalRandom.current().nextInt(1900, 2500);
/* 28 */     return Ret.ok("msg", "今天订单总数为 : " + n);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Ret clearExpiredSession() {
/* 35 */     int n = Db.update("delete from session where expires < ?", new Object[] { new Date() });
/*    */     
/* 37 */     String state = (n > 0) ? "ok" : "fail";
/* 38 */     String msg = (n > 0) ? (n + " 个过期 session 已被清除") : "没有过期 session 需要被清除";
/* 39 */     return Ret.create().set("state", state).set("msg", msg);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Ret clearCache() {
/* 46 */     return Ret.ok("msg", "缓存清除成功");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Ret passData(String k1, String k2) {
/* 53 */     return Ret.ok("msg", "服务端接收到参数 ： k1 = " + k1 + " k2 = " + k2);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Ret switchAccount(Account loginAccount, int newAccountId) {
/* 60 */     if (loginAccount.getId().intValue() == newAccountId) {
/* 61 */       return Ret.fail("当前账户 ID 已经是 ：" + newAccountId);
/*    */     }
/* 63 */     if (loginAccount.getId().intValue() != 1) {
/* 64 */       return Ret.fail("只有 ID 为 1 的账户才有权切换");
/*    */     }
/* 66 */     if (Db.queryInt("select id from account where id = ?", new Object[] { Integer.valueOf(newAccountId) }) == null) {
/* 67 */       return Ret.fail("切换的账户不存在 : " + newAccountId);
/*    */     }
/*    */     
/* 70 */     String sessionId = loginAccount.getStr("sessionId");
/* 71 */     String sql = "update session set accountId = ? where id = ?";
/* 72 */     Db.update(sql, new Object[] { Integer.valueOf(newAccountId), sessionId });
/* 73 */     return Ret.ok("msg", "账户切换成功");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Ret restart() {
/* 80 */     return Ret.fail("演示环境不支持重启 ^_^");
/*    */   }
/*    */ }


/* Location:              /Users/nn/eclipse-workspace/jfinal-blog/jfinal-blog-5.0.0.jar!/com/jfinal/app/blog/_admin/func/FunctionAdminService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */