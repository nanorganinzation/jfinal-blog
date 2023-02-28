/*     */ package com.jfinal.app.blog.common;
/*     */ 
/*     */ import java.io.BufferedInputStream;
/*     */ import java.io.BufferedOutputStream;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.BufferedWriter;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.OutputStream;
/*     */ import java.io.OutputStreamWriter;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.zip.ZipEntry;
/*     */ import java.util.zip.ZipFile;
/*     */ import java.util.zip.ZipInputStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FileUtil
/*     */ {
/*     */   private static final String FILE_EXT = ".";
/*     */   private static final String FILE_DIR_SPIL_STR = "/";
/*     */   
/*     */   public static boolean mkdir(String folder) {
/*  31 */     File file = new File(folder);
/*  32 */     if (!file.exists() && !file.isDirectory()) {
/*  33 */       return file.mkdirs();
/*     */     }
/*  35 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void writeFile(File f, String content) {
/*  45 */     writeFile(f, content, "utf-8");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void writeFile(File f, String content, String encode) {
/*     */     try {
/*  57 */       if (!f.exists()) {
/*  58 */         f.createNewFile();
/*     */       }
/*  60 */       OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(f), encode);
/*  61 */       BufferedWriter utput = new BufferedWriter(osw);
/*  62 */       utput.write(content);
/*  63 */       utput.close();
/*  64 */     } catch (Exception e) {
/*  65 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void writeFile(String path, String content, String encode) {
/*  76 */     File f = new File(path);
/*  77 */     writeFile(f, content, encode);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void writeFile(String path, String content) {
/*  87 */     File f = new File(path);
/*  88 */     writeFile(f, content, "utf-8");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String readFile(File file) {
/*  98 */     return readFile(file, "UTF-8");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String readFile(File file, String encode) {
/* 109 */     String output = "";
/*     */     
/* 111 */     if (file.exists()) {
/* 112 */       if (file.isFile()) {
/*     */         try {
/* 114 */           InputStreamReader isr = new InputStreamReader(new FileInputStream(file), encode);
/* 115 */           BufferedReader input = new BufferedReader(isr);
/* 116 */           StringBuffer buffer = new StringBuffer();
/*     */           String text;
/* 118 */           while ((text = input.readLine()) != null) {
/* 119 */             buffer.append(text + "\n");
/*     */           }
/* 121 */           output = buffer.toString();
/* 122 */           input.close();
/* 123 */         } catch (IOException ioException) {
/* 124 */           System.err.println("File Error！");
/*     */         } 
/* 126 */       } else if (file.isDirectory()) {
/* 127 */         String[] dir = file.list();
/* 128 */         output = output + "Directory contents：\n";
/* 129 */         for (int i = 0; i < dir.length; i++) {
/* 130 */           output = output + dir[i] + "\n";
/*     */         }
/*     */       } 
/*     */     } else {
/*     */       
/* 135 */       System.err.println("Does not exist！");
/*     */     } 
/*     */     
/* 138 */     return output;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String readFile(String fileName, String encode) {
/* 148 */     File file = new File(fileName);
/* 149 */     return readFile(file, encode);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String readFile(String fileName) {
/* 159 */     return readFile(fileName, "utf-8");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static List<File> getFiles(String folder) {
/* 169 */     File file = new File(folder);
/* 170 */     List<File> files = new ArrayList<>();
/* 171 */     if (file.exists()) {
/* 172 */       File[] sonFiles = file.listFiles();
/* 173 */       if (sonFiles != null && sonFiles.length > 0) {
/* 174 */         for (int i = 0; i < sonFiles.length; i++) {
/* 175 */           if (!sonFiles[i].isDirectory()) {
/* 176 */             files.add(sonFiles[i]);
/*     */           }
/*     */         } 
/*     */       }
/*     */     } 
/* 181 */     return files;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static List<File> getFolders(String folder) {
/* 191 */     File file = new File(folder);
/* 192 */     List<File> files = new ArrayList<>();
/* 193 */     if (file.exists()) {
/* 194 */       File[] sonFiles = file.listFiles();
/* 195 */       if (sonFiles != null && sonFiles.length > 0) {
/* 196 */         for (int i = 0; i < sonFiles.length; i++) {
/* 197 */           if (sonFiles[i].isDirectory()) {
/* 198 */             files.add(sonFiles[i]);
/*     */           }
/*     */         } 
/*     */       }
/*     */     } 
/* 203 */     return files;
/*     */   }
/*     */   
/*     */   public static boolean hasFolder(String folder) {
/* 207 */     File file = new File(folder);
/* 208 */     return hasFolder(file);
/*     */   }
/*     */   
/*     */   public static boolean hasFolder(File folder) {
/* 212 */     return (folder.exists() || folder.isDirectory());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean hasSonFolder(String folder) {
/* 222 */     File file = new File(folder);
/* 223 */     return hasSonFolder(file);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean hasSonFolder(File file) {
/* 233 */     if (file.exists()) {
/* 234 */       File[] sonFiles = file.listFiles();
/* 235 */       if (sonFiles != null && sonFiles.length > 0) {
/* 236 */         for (int i = 0; i < sonFiles.length; i++) {
/* 237 */           if (sonFiles[i].isDirectory()) {
/* 238 */             return true;
/*     */           }
/*     */         } 
/*     */       }
/*     */     } 
/* 243 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void copy(File src, File dst) {
/*     */     try {
/* 254 */       int BUFFER_SIZE = 2048;
/* 255 */       BufferedInputStream inBuff = null;
/* 256 */       BufferedOutputStream outBuff = null;
/*     */       
/*     */       try {
/* 259 */         inBuff = new BufferedInputStream(new FileInputStream(src));
/*     */         
/* 261 */         outBuff = new BufferedOutputStream(new FileOutputStream(dst));
/* 262 */         byte[] buffer = new byte[BUFFER_SIZE];
/*     */         int count;
/* 264 */         while ((count = inBuff.read(buffer)) != -1) {
/* 265 */           outBuff.write(buffer, 0, count);
/*     */         }
/*     */         
/* 268 */         outBuff.flush();
/*     */       } finally {
/* 270 */         if (null != inBuff) {
/* 271 */           inBuff.close();
/*     */         }
/* 273 */         if (null != outBuff) {
/* 274 */           outBuff.close();
/*     */         }
/*     */       } 
/* 277 */     } catch (Exception e) {
/* 278 */       e.printStackTrace();
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
/*     */   public static void copyDirectiory(String sourceDir, String targetDir) throws IOException {
/* 290 */     if ((new File(sourceDir)).exists()) {
/*     */       
/* 292 */       File targetFolder = new File(targetDir);
/* 293 */       if (!targetFolder.exists()) {
/* 294 */         targetFolder.mkdirs();
/*     */       }
/*     */       
/* 297 */       File[] file = (new File(sourceDir)).listFiles();
/* 298 */       for (int i = 0; i < file.length; i++) {
/* 299 */         if (file[i].isFile()) {
/*     */           
/* 301 */           File sourceFile = file[i];
/*     */ 
/*     */           
/* 304 */           File targetFile = new File((new File(targetDir)).getAbsolutePath() + File.separator + file[i].getName());
/* 305 */           copy(sourceFile, targetFile);
/*     */         } 
/* 307 */         if (file[i].isDirectory()) {
/*     */           
/* 309 */           String dir1 = sourceDir + "/" + file[i].getName();
/*     */           
/* 311 */           String dir2 = targetDir + "/" + file[i].getName();
/* 312 */           copyDirectiory(dir1, dir2);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getName(File src) {
/* 322 */     if (src != null) {
/* 323 */       String name = src.getName();
/* 324 */       return name.substring(0, name.lastIndexOf("."));
/*     */     } 
/* 326 */     return "";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getName(String src) {
/* 333 */     if (src != null) {
/* 334 */       return src.substring(0, src.lastIndexOf("."));
/*     */     }
/* 336 */     return "";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getExt(File src) {
/* 343 */     if (src != null) {
/* 344 */       String name = src.getName();
/* 345 */       return name.substring(name.lastIndexOf("."), name.length());
/*     */     } 
/* 347 */     return "";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getExt(String src) {
/* 354 */     if (src != null && src.indexOf(".") > -1) {
/* 355 */       return src.substring(src.lastIndexOf("."), src.length());
/*     */     }
/* 357 */     return "";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void del(String path) {
/* 366 */     File file = new File(path);
/* 367 */     deleteFile(file);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void deleteFile(File file) {
/* 376 */     if (file.exists()) {
/* 377 */       if (file.isFile()) {
/* 378 */         file.delete();
/* 379 */       } else if (file.isDirectory()) {
/* 380 */         File[] files = file.listFiles();
/* 381 */         for (int i = 0; i < files.length; i++) {
/* 382 */           deleteFile(files[i]);
/*     */         }
/*     */       } 
/* 385 */       file.delete();
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void upzip() throws Exception {
/* 390 */     File file = new File("D:\\test.zip");
/* 391 */     ZipFile zipFile = new ZipFile(file);
/*     */     
/* 393 */     ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(file));
/* 394 */     ZipEntry zipEntry = null;
/* 395 */     while ((zipEntry = zipInputStream.getNextEntry()) != null) {
/* 396 */       String fileName = zipEntry.getName();
/* 397 */       File temp = new File("D:\\un\\" + fileName);
/* 398 */       temp.getParentFile().mkdirs();
/* 399 */       OutputStream os = new FileOutputStream(temp);
/*     */       
/* 401 */       InputStream is = zipFile.getInputStream(zipEntry);
/* 402 */       int len = 0;
/* 403 */       while ((len = is.read()) != -1) {
/* 404 */         os.write(len);
/*     */       }
/* 406 */       os.close();
/* 407 */       is.close();
/*     */     } 
/* 409 */     zipInputStream.close();
/* 410 */     zipFile.close();
/*     */   }
/*     */ 
/*     */   
/*     */   public static void ExcelDownload(String files, String tempcontent) {
/* 415 */     File file = new File(files);
/*     */     try {
/* 417 */       if (!file.exists()) {
/* 418 */         file.delete();
/* 419 */         file.createNewFile();
/* 420 */         FileOutputStream out = new FileOutputStream(file, false);
/*     */         
/* 422 */         out.write(tempcontent.getBytes("gbk"));
/* 423 */         out.close();
/*     */       } 
/* 425 */     } catch (IOException e) {
/*     */       
/* 427 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /Users/nn/eclipse-workspace/jfinal-blog/jfinal-blog-5.0.0.jar!/com/jfinal/app/blog/common/FileUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */