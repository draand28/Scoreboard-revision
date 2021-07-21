/*    */ package rien.bijl.Scoreboard.r.Plugin.Utility;
/*    */ 
/*    */ import java.util.Objects;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.configuration.ConfigurationSection;
/*    */ import org.bukkit.configuration.file.FileConfiguration;
/*    */ import rien.bijl.Scoreboard.r.Plugin.ConfigControl;
/*    */ 
/*    */ 
/*    */ public class i18n
/*    */ {
/*    */   public static String get(String key) {
/* 13 */     FileConfiguration fileConfiguration = ConfigControl.get().gc("language");
/*    */     
/* 15 */     String[] keys = key.split("\\.");
/*    */     
/* 17 */     for (int i = 0; i < keys.length; i++) {
/* 18 */       if (i == keys.length - 1) {
/* 19 */         String data = fileConfiguration.getString(keys[i]);
/* 20 */         if (data == null) {
/* 21 */           return parse("&cWeird, translation failed!");
/*    */         }
/* 23 */         return parse(data);
/*    */       } 
/* 25 */       ConfigurationSection configurationSection = fileConfiguration.getConfigurationSection(keys[i]);
/* 26 */       if (configurationSection == null) {
/* 27 */         return parse("&cWeird, translation failed!");
/*    */       }
/*    */     } 
/* 30 */     return parse("&cWeird, translation failed!");
/*    */   }
/*    */   
/*    */   public static String parse(String content) {
/* 34 */     return ChatColor.translateAlternateColorCodes('&', content).replaceAll("%prefix%", getPrefix());
/*    */   }
/*    */ 
/*    */   
/*    */   private static String getPrefix() {
/* 39 */     return ChatColor.translateAlternateColorCodes('&', Objects.<String>requireNonNull(ConfigControl.get().gc("language").getConfigurationSection("general").getString("prefix")));
/*    */   }
/*    */ }


/* Location:              D:\Downloads\Scoreboard-revision (1).jar!\rien\bijl\Scoreboard\r\Plugin\Utility\i18n.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */