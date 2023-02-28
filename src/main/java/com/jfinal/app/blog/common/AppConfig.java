/*     */ package com.jfinal.app.blog.common;
/*     */ 
/*     */ import com.jfinal.aop.Interceptor;
/*     */ import com.jfinal.app.blog._admin.auth.AdminAuthInterceptor;
/*     */ import com.jfinal.app.blog._admin.common.AdminInterceptor;
/*     */ import com.jfinal.app.blog._admin.common.RunningTime;
/*     */ import com.jfinal.app.blog._admin.login.LoginSessionInterceptor;
/*     */ import com.jfinal.app.blog.common.kit.SharedMethodLib;
/*     */ import com.jfinal.app.blog.common.model._MappingKit;
/*     */ import com.jfinal.config.Constants;
/*     */ import com.jfinal.config.Handlers;
/*     */ import com.jfinal.config.Interceptors;
/*     */ import com.jfinal.config.JFinalConfig;
/*     */ import com.jfinal.config.Plugins;
/*     */ import com.jfinal.config.Routes;
/*     */ import com.jfinal.kit.Prop;
/*     */ import com.jfinal.kit.PropKit;
/*     */ import com.jfinal.kit.StrKit;
/*     */ import com.jfinal.plugin.IPlugin;
/*     */ import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
/*     */ import com.jfinal.plugin.activerecord.IDataSourceProvider;
/*     */ import com.jfinal.plugin.druid.DruidPlugin;
/*     */ import com.jfinal.template.Engine;
/*     */ 
/*     */ public class AppConfig
/*     */   extends JFinalConfig
/*     */ {
/*     */   static Prop p;
/*     */   
/*     */   static void loadConfig() {
/*  31 */     if (p == null)
/*     */     {
/*  33 */       p = PropKit.useFirstFound(new String[] { "app-config-pro.txt", "app-config-dev.txt" });
/*     */     }
/*     */   }
/*     */   
/*     */   public void configConstant(Constants me) {
/*  38 */     loadConfig();
/*  39 */     me.setDevMode(p.getBoolean("devMode", Boolean.valueOf(false)).booleanValue());
/*     */ 
/*     */     
/*  42 */     me.setInjectDependency(true);
/*     */     
/*  44 */     me.setInjectSuperClass(false);
/*     */   }
/*     */ 
/*     */   
/*     */   public void configRoute(Routes me) {
/*  49 */     me.add(new Routes()
/*     */         {
/*     */           public void config() {
/*  52 */             addInterceptor((Interceptor)new AdminAuthInterceptor());
/*  53 */             addInterceptor((Interceptor)new AdminInterceptor());
/*     */ 
/*     */             
/*  56 */             setBaseViewPath("/_view/_admin");
/*     */ 
/*     */             
/*  59 */             scan("com.jfinal.app.blog._admin.");
/*     */           }
/*     */         });
/*     */ 
/*     */     
/*  64 */     me.add(new Routes()
/*     */         {
/*     */           public void config() {
/*  67 */             setBaseViewPath("/_view");
/*     */ 
/*     */             
/*  70 */             scan("com.jfinal.app.blog.", className -> className.startsWith("com.jfinal.app.blog._admin."));
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void configEngine(Engine me) {
/*  80 */     me.setDevMode(p.getBoolean("engineDevMode", Boolean.valueOf(false)).booleanValue());
/*     */ 
/*     */     
/*  83 */     me.addSharedMethod(new SharedMethodLib());
/*     */ 
/*     */     
/*  86 */     me.addSharedObject("StrKit", new StrKit());
/*  87 */     me.addSharedObject("RunningTime", new RunningTime());
/*     */ 
/*     */     
/*  90 */     me.addSharedFunction("/_view/_admin/common/_paginate.html");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static DruidPlugin getDruidPlugin() {
/*  97 */     loadConfig();
/*  98 */     return new DruidPlugin(p.get("jdbcUrl"), p.get("user"), p.get("password").trim());
/*     */   }
/*     */ 
/*     */   
/*     */   public void configPlugin(Plugins me) {
/* 103 */     DruidPlugin druidPlugin = getDruidPlugin();
/* 104 */     me.add((IPlugin)druidPlugin);
/*     */ 
/*     */     
/* 107 */     ActiveRecordPlugin arp = new ActiveRecordPlugin((IDataSourceProvider)druidPlugin);
/* 108 */     arp.setShowSql(p.getBoolean("devMode", Boolean.valueOf(false)).booleanValue());
/* 109 */     _MappingKit.mapping(arp);
/* 110 */     me.add((IPlugin)arp);
/*     */   }
/*     */ 
/*     */   
/*     */   public void configInterceptor(Interceptors me) {
/* 115 */     me.add((Interceptor)new LoginSessionInterceptor());
/*     */   }
/*     */   
/*     */   public void configHandler(Handlers me) {}
/*     */   
/*     */   public void onStart() {}
/*     */   
/*     */   public void onStop() {}
/*     */ }


/* Location:              /Users/nn/eclipse-workspace/jfinal-blog/jfinal-blog-5.0.0.jar!/com/jfinal/app/blog/common/AppConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */