/*    */ package com.jfinal.app.blog.common.model;
/*    */ 
/*    */ import com.jfinal.app.blog.common.ImageUpload;
/*    */ import com.jfinal.app.blog.common.model.base.BaseFile;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Files
/*    */   extends BaseFile<Files>
/*    */ {
/*    */   private String srcImg;
/* 14 */   String path = ImageUpload.UploadDema + ImageUpload.UploadPath;
/*    */   
/*    */   public String getSrcImg() {
/* 17 */     return this.srcImg;
/*    */   }
/*    */   
/*    */   public void setSrcImg() {
/* 21 */     String imageS = getFileName();
/* 22 */     if (imageS.contains(".pdf")) {
/*    */ 
/*    */       
/* 25 */       this.path += "/pdf.jpeg";
/* 26 */     } else if (imageS.contains(".xls")) {
/* 27 */       this.path += "/excel.jpeg";
/*    */     } else {
/* 29 */       this.path += getPath() + "/" + getFileName();
/*    */     } 
/* 31 */     String srcImg = "<img style='width:50px;' src=" + this.path + ">";
/* 32 */     this.srcImg = srcImg;
/*    */   }
/*    */ }


/* Location:              /Users/nn/eclipse-workspace/jfinal-blog/jfinal-blog-5.0.0.jar!/com/jfinal/app/blog/common/model/Files.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */