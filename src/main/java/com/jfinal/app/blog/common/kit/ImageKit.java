/*     */ package com.jfinal.app.blog.common.kit;
/*     */ 
/*     */ import com.jfinal.kit.StrKit;
/*     */ import java.awt.Color;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Image;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.File;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import javax.imageio.IIOImage;
/*     */ import javax.imageio.ImageIO;
/*     */ import javax.imageio.ImageWriteParam;
/*     */ import javax.imageio.ImageWriter;
/*     */ import javax.imageio.metadata.IIOMetadata;
/*     */ import javax.imageio.stream.ImageOutputStream;
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
/*     */ public class ImageKit
/*     */ {
/*  29 */   private static final String[] imgExts = new String[] { "jpg", "jpeg", "png", "bmp", "gif" };
/*     */   
/*     */   public static String getExtName(String fileName) {
/*  32 */     int index = fileName.lastIndexOf('.');
/*  33 */     if (index != -1 && index + 1 < fileName.length()) {
/*  34 */       return fileName.substring(index + 1);
/*     */     }
/*  36 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isImageExtName(String fileName) {
/*  44 */     if (StrKit.isBlank(fileName)) {
/*  45 */       return false;
/*     */     }
/*  47 */     fileName = fileName.trim().toLowerCase();
/*  48 */     String ext = getExtName(fileName);
/*  49 */     if (ext != null) {
/*  50 */       for (String s : imgExts) {
/*  51 */         if (s.equals(ext)) {
/*  52 */           return true;
/*     */         }
/*     */       } 
/*     */     }
/*  56 */     return false;
/*     */   }
/*     */   
/*     */   public static final boolean notImageExtName(String fileName) {
/*  60 */     return !isImageExtName(fileName);
/*     */   }
/*     */   
/*     */   public static BufferedImage loadImageFile(String sourceImageFileName) {
/*  64 */     if (notImageExtName(sourceImageFileName)) {
/*  65 */       throw new IllegalArgumentException("只支持如下几种类型的图像文件：jpg、jpeg、png、bmp");
/*     */     }
/*     */     
/*  68 */     File sourceImageFile = new File(sourceImageFileName);
/*  69 */     if (!sourceImageFile.exists() || !sourceImageFile.isFile()) {
/*  70 */       throw new IllegalArgumentException("文件不存在");
/*     */     }
/*     */     
/*     */     try {
/*  74 */       return ImageIO.read(sourceImageFile);
/*  75 */     } catch (Exception e) {
/*  76 */       throw new RuntimeException(e);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void zoom(int maxWidth, File srcFile, String saveFile) {
/*  86 */     float quality = 0.8F;
/*     */     
/*     */     try {
/*  89 */       BufferedImage srcImage = ImageIO.read(srcFile);
/*  90 */       int srcWidth = srcImage.getWidth();
/*  91 */       int srcHeight = srcImage.getHeight();
/*     */ 
/*     */       
/*  94 */       if (srcWidth <= maxWidth) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 102 */         saveWithQuality(srcImage, quality, saveFile);
/*     */       }
/*     */       else {
/*     */         
/* 106 */         float scalingRatio = maxWidth / srcWidth;
/* 107 */         float maxHeight = srcHeight * scalingRatio;
/* 108 */         BufferedImage ret = resize(srcImage, maxWidth, (int)maxHeight);
/* 109 */         saveWithQuality(ret, quality, saveFile);
/*     */       } 
/* 111 */     } catch (Exception e) {
/* 112 */       throw new RuntimeException(e);
/*     */     } 
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
/*     */   public static BufferedImage crop(String sourceImageFile, int left, int top, int width, int height) {
/* 125 */     if (notImageExtName(sourceImageFile)) {
/* 126 */       throw new IllegalArgumentException("只支持如下几种类型的图像文件：jpg、jpeg、png、bmp");
/*     */     }
/*     */     
/*     */     try {
/* 130 */       BufferedImage bi = ImageIO.read(new File(sourceImageFile));
/* 131 */       width = Math.min(width, bi.getWidth());
/* 132 */       height = Math.min(height, bi.getHeight());
/* 133 */       if (width <= 0) width = bi.getWidth(); 
/* 134 */       if (height <= 0) height = bi.getHeight();
/*     */       
/* 136 */       left = Math.min(Math.max(0, left), bi.getWidth() - width);
/* 137 */       top = Math.min(Math.max(0, top), bi.getHeight() - height);
/*     */       
/* 139 */       BufferedImage subImage = bi.getSubimage(left, top, width, height);
/* 140 */       return subImage;
/* 141 */     } catch (Exception e) {
/* 142 */       throw new RuntimeException(e);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void save(BufferedImage bi, String outputImageFile) {
/* 147 */     FileOutputStream newImage = null;
/*     */     
/*     */     try {
/* 150 */       ImageIO.write(bi, getExtName(outputImageFile), new File(outputImageFile));
/* 151 */     } catch (Exception e) {
/* 152 */       throw new RuntimeException(e);
/*     */     } finally {
/* 154 */       if (newImage != null) {
/*     */         try {
/* 156 */           newImage.close();
/* 157 */         } catch (IOException e) {
/* 158 */           throw new RuntimeException(e);
/*     */         } 
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static BufferedImage resize(BufferedImage bi, int toWidth, int toHeight) {
/* 168 */     Graphics g = null;
/*     */     
/*     */     try {
/* 171 */       Image scaledImage = bi.getScaledInstance(toWidth, toHeight, 4);
/*     */       
/* 173 */       BufferedImage ret = new BufferedImage(toWidth, toHeight, 1);
/* 174 */       g = ret.getGraphics();
/* 175 */       g.drawImage(scaledImage, 0, 0, null);
/*     */       
/* 177 */       return ret;
/* 178 */     } catch (Exception e) {
/* 179 */       throw new RuntimeException(e);
/*     */     } finally {
/* 181 */       if (g != null) {
/* 182 */         g.dispose();
/*     */       }
/*     */     } 
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
/*     */   
/*     */   public static void saveWithQuality(BufferedImage im, float quality, String outputImageFile) {
/* 203 */     ImageWriter writer = null;
/* 204 */     FileOutputStream newImage = null;
/*     */     try {
/* 206 */       BufferedImage newBufferedImage = new BufferedImage(im.getWidth(), im.getHeight(), 1);
/* 207 */       newBufferedImage.createGraphics().drawImage(im, 0, 0, Color.WHITE, null);
/*     */       
/* 209 */       newImage = new FileOutputStream(outputImageFile);
/*     */       
/* 211 */       writer = ImageIO.getImageWritersBySuffix("jpg").next();
/* 212 */       ImageWriteParam param = writer.getDefaultWriteParam();
/* 213 */       param.setCompressionMode(2);
/* 214 */       param.setCompressionQuality(quality);
/* 215 */       ImageOutputStream os = ImageIO.createImageOutputStream(newImage);
/* 216 */       writer.setOutput(os);
/* 217 */       writer.write((IIOMetadata)null, new IIOImage(newBufferedImage, null, null), param);
/* 218 */       os.flush();
/* 219 */       os.close();
/*     */     }
/* 221 */     catch (IOException e) {
/* 222 */       throw new RuntimeException(e);
/*     */     } finally {
/*     */       
/* 225 */       if (writer != null) {
/* 226 */         try { writer.dispose(); } catch (Throwable throwable) {}
/*     */       }
/* 228 */       if (newImage != null)
/* 229 */         try { newImage.close(); } catch (IOException e) { throw new RuntimeException(e); }
/*     */          
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /Users/nn/eclipse-workspace/jfinal-blog/jfinal-blog-5.0.0.jar!/com/jfinal/app/blog/common/kit/ImageKit.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */