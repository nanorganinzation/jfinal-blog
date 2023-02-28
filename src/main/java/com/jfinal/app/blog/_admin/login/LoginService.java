/*     */ package com.jfinal.app.blog._admin.login;
/*     */ 
/*     */ import com.jfinal.app.blog.common.model.Account;
/*     */ import com.jfinal.app.blog.common.model.Session;
/*     */ import com.jfinal.kit.HashKit;
/*     */ import com.jfinal.kit.Ret;
/*     */ import com.jfinal.kit.StrKit;
/*     */ import com.jfinal.kit.TimeKit;
/*     */ import com.jfinal.plugin.activerecord.Db;
/*     */ import com.jfinal.plugin.activerecord.Record;
/*     */ import java.time.LocalDateTime;
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class LoginService
/*     */ {
/*     */   public static final String SESSION_ID = "sessionId";
/*     */   public static final String LOGIN_ACCOUNT = "loginAccount";
/*  28 */   private Account accountDao = (Account)(new Account()).dao();
/*  29 */   private Session sessionDao = (Session)(new Session()).dao();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Ret login(String userName, String password, String ip, int port) {
/*  35 */     if (StrKit.isBlank(userName)) {
/*  36 */       return Ret.fail("用户名不能为空");
/*     */     }
/*  38 */     if (StrKit.isBlank(password)) {
/*  39 */       return Ret.fail("密码不能为空");
/*     */     }
/*     */     
/*  42 */     Ret ret = doLogin(userName, password);
/*     */     
/*  44 */     createLoginLog(ret, userName, ip, port);
/*  45 */     return ret;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Ret doLogin(String userName, String password) {
/*  52 */     userName = userName.toLowerCase().trim();
/*  53 */     password = password.trim();
/*  54 */     Account account = (Account)this.accountDao.findFirst("select * from account where userName=? limit 1", new Object[] { userName });
/*  55 */     if (account == null) {
/*  56 */       return Ret.fail("用户名或密码不正确");
/*     */     }
/*  58 */     if (account.isStateLock()) {
/*  59 */       return Ret.fail("账号已被锁定");
/*     */     }
/*  61 */     if (account.isStateReg()) {
/*  62 */       return Ret.fail("账号未激活，请先激活账号");
/*     */     }
/*     */     
/*  65 */     String salt = account.getSalt();
/*  66 */     String hashedPass = HashKit.sha256(salt + password);
/*     */ 
/*     */     
/*  69 */     if (!account.getPassword().equals(hashedPass)) {
/*  70 */       return Ret.fail("用户名或密码不正确");
/*     */     }
/*     */ 
/*     */     
/*  74 */     long timeToLiveSeconds = 259200L;
/*     */     
/*  76 */     Date expires = TimeKit.toDate(LocalDateTime.now().plusSeconds(timeToLiveSeconds));
/*     */ 
/*     */     
/*  79 */     Session session = new Session();
/*  80 */     String sessionId = StrKit.getRandomUUID();
/*  81 */     session.setId(sessionId);
/*  82 */     session.setAccountId(account.getId());
/*  83 */     session.setCreated(new Date());
/*  84 */     session.setExpires(expires);
/*  85 */     session.save();
/*     */ 
/*     */     
/*  88 */     account.removeSensitiveInfo();
/*     */     
/*  90 */     return Ret.ok("sessionId", sessionId)
/*  91 */       .set("loginAccount", account)
/*  92 */       .set("timeToLiveSeconds", Long.valueOf(timeToLiveSeconds));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void createLoginLog(Ret loginRet, String userName, String ip, int port) {
/* 106 */     Record loginLog = new Record();
/*     */ 
/*     */     
/* 109 */     if (loginRet.isOk()) {
/* 110 */       Account loginAccount = (Account)loginRet.getAs("loginAccount");
/* 111 */       loginLog.set("state", Integer.valueOf(1));
/* 112 */       loginLog.set("accountId", loginAccount.getId());
/*     */     } else {
/* 114 */       loginLog.set("state", Integer.valueOf(0));
/*     */     } 
/*     */     
/* 117 */     loginLog.set("userName", userName)
/* 118 */       .set("created", new Date())
/* 119 */       .set("ip", StrKit.notBlank(ip) ? ip : "127.0.0.1")
/* 120 */       .set("port", Integer.valueOf(port));
/*     */     
/* 122 */     Db.save("login_log", loginLog);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Ret logout(String sessionId) {
/* 129 */     this.sessionDao.deleteById(sessionId);
/* 130 */     return Ret.ok();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Account getAccountBySessionId(String sessionId) {
/* 143 */     String sql = "select a.*, s.id as sessionId, s.created as sessionCreated, s.expires as sessionExpires from account a inner join session s on a.id = s.accountId where s.id = ? limit 1";
/*     */     
/* 145 */     Account loginAccount = (Account)this.accountDao.findFirst(sql, new Object[] { sessionId });
/* 146 */     if (loginAccount != null)
/*     */     {
/* 148 */       if (loginAccount.isStateOk())
/*     */       {
/* 150 */         if (loginAccount.getDate("sessionExpires").after(new Date())) {
/* 151 */           return loginAccount;
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/*     */     
/* 157 */     this.sessionDao.deleteById(sessionId);
/* 158 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void main(String[] args) {
/* 163 */     String salt = HashKit.generateSaltForSha256();
/* 164 */     String password = "111111";
/* 165 */     password = HashKit.sha256(salt + password);
/* 166 */     System.out.println(salt);
/* 167 */     System.out.println(password);
/*     */   }
/*     */ }


/* Location:              /Users/nn/eclipse-workspace/jfinal-blog/jfinal-blog-5.0.0.jar!/com/jfinal/app/blog/_admin/login/LoginService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */