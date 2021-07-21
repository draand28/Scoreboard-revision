/*    */ package rien.bijl.Scoreboard.r.Plugin.Utility;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.net.URL;
/*    */ import java.util.Scanner;
/*    */ import org.bukkit.plugin.java.JavaPlugin;
/*    */ 
/*    */ 
/*    */ public class UpdateChecker
/*    */ {
/*    */   private final JavaPlugin plugin;
/*    */   private final int resourceId;
/*    */   
/*    */   public UpdateChecker(JavaPlugin plugin, int resourceId) {
/* 15 */     this.plugin = plugin;
/* 16 */     this.resourceId = resourceId;
/*    */   }
/*    */   
/*    */   public String getValueFromWebsite(String website) throws IOException {
/* 20 */     URL url = new URL(website);
/* 21 */     Scanner sc = new Scanner(url.openStream());
/* 22 */     StringBuffer sb = new StringBuffer();
/* 23 */     while (sc.hasNext()) {
/* 24 */       sb.append(sc.next());
/*    */     }
/*    */     
/* 27 */     return sb.toString();
/*    */   }
/*    */   
/*    */   public String getVersion() {
/*    */     try {
/* 32 */       return getValueFromWebsite("https://api.spigotmc.org/legacy/update.php?resource=" + this.resourceId);
/* 33 */     } catch (IOException exception) {
/* 34 */       this.plugin.getLogger().info("Cannot look for updates: " + exception.getMessage());
/*    */       
/* 36 */       return null;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Downloads\Scoreboard-revision (1).jar!\rien\bijl\Scoreboard\r\Plugin\Utility\UpdateChecker.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */