/*     */ package com.jfinal.app.blog._admin.account;
/*     */ 
/*     */ import com.jfinal.app.blog.common.model.Account;
/*     */ import com.jfinal.kit.HashKit;
/*     */ import com.jfinal.kit.Ret;
/*     */ import com.jfinal.kit.StrKit;
/*     */ import com.jfinal.plugin.activerecord.Db;
/*     */ import com.jfinal.plugin.activerecord.Page;
/*     */ import java.util.Date;
/*     */ import java.util.List;
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
/*     */ public class AccountAdminService
/*     */ {
/*  24 */   private static int pageSize = 25;
/*  25 */   private Account dao = (Account)(new Account()).dao();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Page<Account> paginate(int pageNumber, int accountId) {
/*  31 */     if (1 == accountId) {
/*  32 */       return this.dao.paginate(pageNumber, pageSize, "select *", "from account order by updated desc");
/*     */     }
/*  34 */     return this.dao.paginate(pageNumber, pageSize, "select *", "from account where id=?", new Object[] { Integer.valueOf(accountId) });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Page<Account> search(String key, int pageNumber, int accountId) {
/*  41 */     if (1 == accountId) {
/*  42 */       String str = "select * from account where nickName like concat('%', #para(0), '%') or    userName like concat('%', #para(1), '%') order by updated desc";
/*     */       
/*  44 */       return this.dao.templateByString(str, new Object[] { key, key }).paginate(pageNumber, pageSize);
/*     */     } 
/*  46 */     String sql = "select * from account where id=? and (nickName like concat('%', #para(0), '%') or    userName like concat('%', #para(1), '%') )order by updated desc";
/*     */     
/*  48 */     return this.dao.templateByString(sql, new Object[] { Integer.valueOf(accountId), key, key }).paginate(pageNumber, pageSize);
/*     */   }
/*     */   
/*     */   public List<Account> getAllDisplay() {
/*  52 */     String sql = "select b.id,COUNT(b.id) as count,b.display,MAX(a.created) as created,b.avatar from blog a\r\nINNER JOIN account b on a.accountId=b.id and b.del=0  where a.del=0 and a.state=1  GROUP BY b.id ORDER BY count desc";
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  57 */     return this.dao.find(sql);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Ret save(Account acc) {
/*  64 */     preProccess(acc);
/*  65 */     Ret ret = validate(acc, true);
/*  66 */     if (ret != null) {
/*  67 */       return ret;
/*     */     }
/*     */ 
/*     */     
/*  71 */     acc.setUserName(acc.getUserName().trim().toLowerCase());
/*  72 */     passwordSaltAndHash(acc);
/*  73 */     acc.setState(Integer.valueOf(-1));
/*  74 */     acc.setCreated(new Date());
/*  75 */     acc.setUpdated(acc.getCreated());
/*  76 */     acc.setAvatar("x.jpg");
/*  77 */     String display = acc.getDisplay();
/*  78 */     if (StrKit.isBlank(display)) {
/*  79 */       display = acc.getNickName();
/*     */     }
/*  81 */     acc.setDisplay(display);
/*  82 */     acc.save();
/*     */     
/*  84 */     return Ret.ok("msg", "创建成功");
/*     */   }
/*     */ 
/*     */   
/*     */   public void passwordSaltAndHash(Account acc) {
/*  89 */     if (StrKit.isBlank(acc.getPassword())) {
/*  90 */       throw new RuntimeException("密码不能为空");
/*     */     }
/*     */     
/*  93 */     String salt = HashKit.generateSaltForSha256();
/*  94 */     String pwd = acc.getPassword();
/*  95 */     pwd = HashKit.sha256(salt + pwd);
/*     */     
/*  97 */     acc.setPassword(pwd);
/*  98 */     acc.setSalt(salt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void preProccess(Account a) {
/* 108 */     a.keep(new String[] { "id", "userName", "password", "nickName", "display", "avatar" });
/*     */     
/* 110 */     a.removeNullValueAttrs();
/*     */     
/* 112 */     if (a.getUserName() != null) {
/* 113 */       a.setUserName(a.getUserName().trim().toLowerCase());
/*     */     }
/*     */     
/* 116 */     if (a.getPassword() != null) {
/* 117 */       a.setPassword(a.getPassword().trim());
/*     */     }
/*     */     
/* 120 */     if (a.getNickName() != null) {
/* 121 */       a.setNickName(a.getNickName().trim());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Ret validate(Account account, boolean create) {
/* 131 */     String userName = account.getUserName();
/* 132 */     String password = account.getPassword();
/* 133 */     String nickName = account.getNickName();
/*     */     
/* 135 */     if (StrKit.isBlank(userName)) {
/* 136 */       return Ret.fail("用户名不能为空");
/*     */     }
/*     */ 
/*     */     
/* 140 */     if (create) {
/* 141 */       if (StrKit.isBlank(password)) {
/* 142 */         return Ret.fail("密码不能为空");
/*     */       }
/* 144 */       if (password.trim().length() < 6) {
/* 145 */         return Ret.fail("密码长度至少为 6");
/*     */       
/*     */       }
/*     */     
/*     */     }
/* 150 */     else if (StrKit.notBlank(password) && password.trim().length() < 6) {
/* 151 */       return Ret.fail("密码长度至少为 6");
/*     */     } 
/*     */ 
/*     */     
/* 155 */     if (StrKit.isBlank(nickName)) {
/* 156 */       return Ret.fail("昵称不能为空");
/*     */     }
/*     */     
/* 159 */     if (userName.contains(" ") || userName.contains("　")) {
/* 160 */       return Ret.fail("用户名不能包含空格");
/*     */     }
/* 162 */     if (nickName.contains(" ") || nickName.contains("　")) {
/* 163 */       return Ret.fail("昵称不能包含空格");
/*     */     }
/*     */ 
/*     */     
/* 167 */     int id = create ? -1 : account.getId().intValue();
/* 168 */     if (isUserNameExists(userName, id)) {
/* 169 */       return Ret.fail("用户名已被注册，请换一个用户名");
/*     */     }
/* 171 */     if (isNickNameExists(nickName, id)) {
/* 172 */       return Ret.fail("昵称已被注册，请换一个昵称");
/*     */     }
/*     */     
/* 175 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isUserNameExists(String userName, int selfId) {
/* 182 */     userName = userName.toLowerCase().trim(); return 
/* 183 */       (Db.queryInt("select id from account where userName = ? and id != ? limit 1", new Object[] { userName, Integer.valueOf(selfId) }) != null);
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
/*     */   private boolean isNickNameExists(String nickName, int selfId) {
/* 196 */     nickName = nickName.toLowerCase().trim(); return 
/* 197 */       (Db.queryInt("select id from account where lower(nickName) = ? and id != ? limit 1", new Object[] { nickName, 
/* 198 */           Integer.valueOf(selfId) }) != null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Ret update(int loginAccountId, Account acc) {
/* 205 */     if (loginAccountId != 1 && loginAccountId != acc.getId().intValue()) {
/* 206 */       return Ret.fail("只能修改自己的账户(ID 为 1 的管理员除外)");
/*     */     }
/*     */     
/* 209 */     preProccess(acc);
/*     */     
/* 211 */     Ret ret = validate(acc, false);
/* 212 */     if (ret != null) {
/* 213 */       return ret;
/*     */     }
/*     */ 
/*     */     
/* 217 */     if (StrKit.notBlank(acc.getPassword())) {
/* 218 */       passwordSaltAndHash(acc);
/*     */     }
/*     */     
/* 221 */     acc.setUpdated(new Date());
/* 222 */     acc.update();
/*     */     
/* 224 */     return Ret.ok("msg", "更新成功");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Ret switchState(int loginAccountId, int id, boolean checked) {
/* 231 */     if (loginAccountId == id) {
/* 232 */       return Ret.fail("不能锁定自己的账户");
/*     */     }
/* 234 */     if (id == 1) {
/* 235 */       return Ret.fail("id 值为 1 的账户不能锁定");
/*     */     }
/* 237 */     if (loginAccountId != 1) {
/* 238 */       return Ret.fail("只有账户 ID 值为 1 的管理员才有权操作");
/*     */     }
/*     */     
/* 241 */     int state = checked ? 1 : -1;
/* 242 */     String sql = "update account set state = ? where id = ?";
/* 243 */     Db.update(sql, new Object[] { Integer.valueOf(state), Integer.valueOf(id) });
/* 244 */     return Ret.ok();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Account getById(int id) {
/* 251 */     return (Account)this.dao.findById(Integer.valueOf(id));
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Ret deleteById(int loginAccountId, int id) {
/* 269 */     if (loginAccountId == id) {
/* 270 */       return Ret.fail("不能删除自己的账户");
/*     */     }
/* 272 */     String sql = "update account set del = 1 where id = ?";
/* 273 */     Db.update(sql, new Object[] { Integer.valueOf(id) });
/* 274 */     return Ret.ok("msg", "删除成功");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isDefaultPassword(Account acc) {
/* 281 */     String hashedPwd = HashKit.sha256(acc.getSalt() + "111111");
/* 282 */     return hashedPwd.equals(acc.getPassword());
/*     */   }
/*     */ }


/* Location:              /Users/nn/eclipse-workspace/jfinal-blog/jfinal-blog-5.0.0.jar!/com/jfinal/app/blog/_admin/account/AccountAdminService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */