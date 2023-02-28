/*    */ package com.jfinal.app.blog.common.model;
/*    */ 
/*    */ import com.jfinal.app.blog.common.AppConfig;
/*    */ import com.jfinal.plugin.activerecord.dialect.Dialect;
/*    */ import com.jfinal.plugin.activerecord.dialect.MysqlDialect;
/*    */ import com.jfinal.plugin.activerecord.generator.Generator;
/*    */ import com.jfinal.plugin.activerecord.generator.TypeMapping;
/*    */ import com.jfinal.plugin.druid.DruidPlugin;
/*    */ import java.time.LocalDate;
/*    */ import java.time.LocalDateTime;
/*    */ import java.util.Date;
/*    */ import javax.sql.DataSource;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class _Generator
/*    */ {
/* 24 */   private static final String[] blacklist = new String[] { "login_log", "account_blog" };
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static DataSource getDataSource() {
/* 30 */     DruidPlugin druidPlugin = AppConfig.getDruidPlugin();
/* 31 */     druidPlugin.start();
/* 32 */     return druidPlugin.getDataSource();
/*    */   }
/*    */ 
/*    */   
/*    */   public static void main(String[] args) {
/* 37 */     String modelPackageName = "com.jfinal.app.blog.common.model";
/*    */ 
/*    */     
/* 40 */     String baseModelPackageName = modelPackageName + ".base";
/*    */ 
/*    */ 
/*    */     
/* 44 */     String baseModelOutputDir = System.getProperty("user.dir") + "/src/main/java/" + baseModelPackageName.replace('.', '/');
/*    */     
/* 46 */     System.out.println("输出路径：" + baseModelOutputDir);
/*    */ 
/*    */     
/* 49 */     String modelOutputDir = baseModelOutputDir + "/..";
/*    */ 
/*    */     
/* 52 */     Generator gen = new Generator(getDataSource(), baseModelPackageName, baseModelOutputDir, modelPackageName, modelOutputDir);
/*    */ 
/*    */ 
/*    */     
/* 56 */     gen.setDialect((Dialect)new MysqlDialect());
/*    */ 
/*    */     
/* 59 */     gen.setGenerateRemarks(true);
/*    */ 
/*    */     
/* 62 */     gen.addBlacklist(blacklist);
/*    */ 
/*    */     
/* 65 */     gen.setGenerateDaoInModel(false);
/*    */ 
/*    */     
/* 68 */     gen.setGenerateDataDictionary(false);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 76 */     TypeMapping tm = new TypeMapping();
/* 77 */     tm.addMapping(LocalDateTime.class, Date.class);
/* 78 */     tm.addMapping(LocalDate.class, Date.class);
/*    */     
/* 80 */     gen.setTypeMapping(tm);
/*    */ 
/*    */     
/* 83 */     gen.generate();
/*    */   }
/*    */ }


/* Location:              /Users/nn/eclipse-workspace/jfinal-blog/jfinal-blog-5.0.0.jar!/com/jfinal/app/blog/common/model/_Generator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */