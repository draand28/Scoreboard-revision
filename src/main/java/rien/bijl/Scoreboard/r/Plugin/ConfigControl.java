/*     */ package rien.bijl.Scoreboard.r.Plugin;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.PrintWriter;
/*     */ import java.io.Reader;
/*     */ import java.util.HashMap;
/*     */ import org.bukkit.configuration.file.FileConfiguration;
/*     */ import org.bukkit.configuration.file.YamlConfiguration;
/*     */ 
/*     */ 
/*     */ public class ConfigControl
/*     */ {
/*  15 */   private static ConfigControl instance = null;
/*     */ 
/*     */   
/*     */   public static ConfigControl get() {
/*  19 */     if (instance != null) {
/*  20 */       return instance;
/*     */     }
/*  22 */     return new ConfigControl();
/*     */   }
/*     */   
/*  25 */   HashMap<String, FileConfiguration> designations = new HashMap<>();
/*     */ 
/*     */   
/*     */   private ConfigControl() {
/*  29 */     instance = this;
/*  30 */     createDataFiles();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void createDataFiles() {
/*  36 */     if (!(Session.getSession()).plugin.getDataFolder().exists()) {
/*  37 */       (Session.getSession()).plugin.getDataFolder().mkdirs();
/*     */     }
/*     */     
/*  40 */     createConfigFile("settings");
/*  41 */     createConfigFile("language");
/*     */   }
/*     */ 
/*     */   
/*     */   public void purge() {
/*  46 */     this.designations.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public void createConfigFile(String name) {
/*  51 */     File f = new File((Session.getSession()).plugin.getDataFolder(), name + ".yml");
/*     */     
/*  53 */     boolean needCopyDefaults = false;
/*     */     
/*     */     try {
/*  56 */       if (!f.exists()) {
/*     */         
/*  58 */         f.createNewFile();
/*  59 */         needCopyDefaults = true;
/*     */       } 
/*  61 */     } catch (IOException ex) {
/*     */       
/*  63 */       ex.printStackTrace();
/*     */     } 
/*     */     
/*  66 */     if (needCopyDefaults) {
/*     */       
/*     */       try {
/*  69 */         Reader defConfigStream = new InputStreamReader(ConfigControl.class.getResourceAsStream("/" + name + ".yml"), "UTF-8");
/*  70 */         PrintWriter writer = new PrintWriter(f, "UTF-8");
/*  71 */         writer.print(read(defConfigStream));
/*  72 */         writer.close();
/*  73 */       } catch (Exception ex) {
/*     */         
/*  75 */         ex.printStackTrace();
/*     */       } 
/*     */     }
/*     */     
/*  79 */     YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(f);
/*  80 */     this.designations.put(name, yamlConfiguration);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void reloadConfigs() {
/*  88 */     purge();
/*  89 */     createDataFiles();
/*     */   }
/*     */ 
/*     */   
/*     */   public FileConfiguration gc(String fc) {
/*  94 */     return this.designations.get(fc);
/*     */   }
/*     */ 
/*     */   
/*     */   public String read(Reader r) throws IOException {
/*  99 */     char[] arr = new char[8192];
/* 100 */     StringBuilder buffer = new StringBuilder();
/*     */     int numCharsRead;
/* 102 */     while ((numCharsRead = r.read(arr, 0, arr.length)) != -1) {
/* 103 */       buffer.append(arr, 0, numCharsRead);
/*     */     }
/* 105 */     r.close();
/* 106 */     return buffer.toString();
/*     */   }
/*     */ }


/* Location:              D:\Downloads\Scoreboard-revision (1).jar!\rien\bijl\Scoreboard\r\Plugin\ConfigControl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */