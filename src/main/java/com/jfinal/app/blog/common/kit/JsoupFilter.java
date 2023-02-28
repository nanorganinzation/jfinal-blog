/*     */ package com.jfinal.app.blog.common.kit;
/*     */ 
/*     */ import com.jfinal.app.blog.common.model.Account;
/*     */ import com.jfinal.plugin.activerecord.Model;
/*     */ import java.util.List;
/*     */ import org.jsoup.Jsoup;
/*     */ import org.jsoup.nodes.Document;
/*     */ import org.jsoup.nodes.Element;
/*     */ import org.jsoup.safety.Whitelist;
/*     */ import org.jsoup.select.Elements;
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
/*     */ public class JsoupFilter
/*     */ {
/*  27 */   private static final Whitelist contentWhitelist = createContentWhitelist();
/*  28 */   private static final Document.OutputSettings notPrettyPrint = (new Document.OutputSettings()).prettyPrint(false);
/*     */   
/*     */   private static Whitelist createContentWhitelist() {
/*  31 */     return Whitelist.relaxed()
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  37 */       .removeProtocols("a", "href", new String[] { "ftp", "http", "https", "mailto"
/*  38 */         }).removeProtocols("img", "src", new String[] { "http", "https"
/*     */         
/*  40 */         }).addAttributes("a", new String[] {
/*     */           
/*     */           "href", "title", "target"
/*     */ 
/*     */         
/*  45 */         }).addAttributes("video", new String[] {
/*     */           
/*     */           "src", "controls", "width", "height", "poster", "preload", "muted", "loop", "autoplay"
/*     */ 
/*     */         
/*  50 */         }).addTags(new String[] { "div", "span", "embed", "object", "param"
/*  51 */         }).addAttributes(":all", new String[] { "style", "class", "id", "name"
/*  52 */         }).addAttributes("object", new String[] { "width", "height", "classid", "codebase"
/*  53 */         }).addAttributes("param", new String[] { "name", "value"
/*  54 */         }).addAttributes("embed", new String[] { "src", "quality", "width", "height", "allowFullScreen", "allowScriptAccess", "flashvars", "name", "type", "pluginspage" });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void filterTitleAndContent(Model m) {
/*  62 */     String title = m.getStr("title");
/*  63 */     if (title != null) {
/*  64 */       m.set("title", getText(title));
/*     */     }
/*  66 */     String content = m.getStr("content");
/*  67 */     if (content != null) {
/*  68 */       m.set("content", filterArticleContent(content));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void filterAccountNickName(Account account) {
/*  76 */     String nickName = account.getNickName();
/*  77 */     if (nickName != null) {
/*  78 */       account.setNickName(getText(nickName));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void filterArticleList(List<? extends Model> modelList, int titleLen, int contentLen) {
/*  86 */     for (Model m : modelList) {
/*  87 */       String title = getText(m.getStr("title"));
/*  88 */       if (title.length() > titleLen) {
/*  89 */         title = title.substring(0, titleLen - 1);
/*     */       }
/*     */       
/*  92 */       String content = getText(m.getStr("content")).replaceAll("&nbsp;", " ");
/*  93 */       if (content.length() > contentLen) {
/*  94 */         content = content.substring(0, contentLen - 1);
/*     */       }
/*  96 */       m.set("title", title);
/*  97 */       m.set("content", content);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String filterArticleContent(String content) {
/* 105 */     checkXssAndCsrf(content);
/*     */ 
/*     */ 
/*     */     
/* 109 */     return (content != null) ? Jsoup.clean(content, "", contentWhitelist, notPrettyPrint) : null;
/*     */   }
/*     */   
/*     */   public static void checkXssAndCsrf(String html) {
/* 113 */     Document doc = Jsoup.parseBodyFragment(html);
/* 114 */     if (linkHrefContainsJavascript(doc)) {
/* 115 */       throw new RuntimeException("链接包含 javascript 脚本，html 内容为: " + html);
/*     */     }
/*     */     
/* 118 */     if (srcPointToAction(doc)) {
/* 119 */       throw new RuntimeException("src 未指向静态资源，html 内容为: " + html);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean srcPointToAction(Document doc) {
/* 127 */     Elements elements = doc.select("[src]");
/* 128 */     for (Element e : elements) {
/* 129 */       String src = e.attr("src");
/* 130 */       if (src != null) {
/* 131 */         int questionCharIndex = src.indexOf('?');
/* 132 */         if (questionCharIndex != -1) {
/* 133 */           src = src.substring(0, questionCharIndex);
/*     */         }
/*     */         
/* 136 */         if (src.indexOf('.') == -1) {
/* 137 */           return true;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 142 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean linkHrefContainsJavascript(Document doc) {
/* 150 */     Elements elements = doc.select("a[href]");
/* 151 */     for (Element e : elements) {
/* 152 */       String href = e.attr("href");
/* 153 */       if (href != null && href.toLowerCase().indexOf("javascript") != -1) {
/* 154 */         return true;
/*     */       }
/*     */     } 
/*     */     
/* 158 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String filterArticleTitle(String title) {
/* 165 */     return getText(title);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String filterContentKeepNewline(String content) {
/* 172 */     return (content != null) ? Jsoup.clean(content, "", contentWhitelist, notPrettyPrint) : null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String filterNewlineToBrTag(String content) {
/* 182 */     return (content != null) ? content.replaceAll("\r\n", "<br>").replaceAll("\r", "<br>").replaceAll("\n", "<br>") : null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getText(String html) {
/* 189 */     return (html != null) ? Jsoup.clean(html, Whitelist.none()) : null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getSimpleHtml(String html) {
/* 197 */     return (html != null) ? Jsoup.clean(html, Whitelist.simpleText()) : null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getBasic(String html) {
/* 207 */     checkXssAndCsrf(html);
/*     */     
/* 209 */     return (html != null) ? Jsoup.clean(html, Whitelist.basic()) : null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getBasicWithImages(String html) {
/* 216 */     checkXssAndCsrf(html);
/*     */     
/* 218 */     return (html != null) ? Jsoup.clean(html, Whitelist.basicWithImages()) : null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getRelaxed(String html) {
/* 229 */     return (html != null) ? Jsoup.clean(html, Whitelist.relaxed()) : null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getWithWhitelist(String html, Whitelist whitelist) {
/* 236 */     return (html != null) ? Jsoup.clean(html, whitelist) : null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getWithTags(String html, String... tags) {
/* 243 */     return (html != null) ? Jsoup.clean(html, Whitelist.none().addTags(tags)) : null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getFirstImgSrc(String html) {
/* 250 */     if (html != null) {
/* 251 */       Document doc = Jsoup.parseBodyFragment(html);
/* 252 */       Element image = doc.select("img").first();
/* 253 */       return (image != null) ? image.attr("src") : null;
/*     */     } 
/* 255 */     return null;
/*     */   }
/*     */ }


/* Location:              /Users/nn/eclipse-workspace/jfinal-blog/jfinal-blog-5.0.0.jar!/com/jfinal/app/blog/common/kit/JsoupFilter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */