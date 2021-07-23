/*    */ package rien.bijl.Scoreboard.r.Plugin.Utility;
/*    */ 
/*    */ import java.util.ArrayList;
import org.bukkit.plugin.java.JavaPlugin;
/*    */ import java.util.List;
/*    */ import java.util.regex.Matcher;
/*    */ import java.util.regex.Pattern;
/*    */ import me.clip.placeholderapi.PlaceholderAPI;
/*    */ import net.md_5.bungee.api.ChatColor;
/*    */ import org.bukkit.Bukkit;
/*    */ //import org.bukkit.ChatColor;
/*    */ import org.bukkit.entity.Player;
/*    */ import rien.bijl.Scoreboard.r.Plugin.Session;
/*    */ 
/*    */ public class ScoreboardStrings {
/* 15 */   private static final Pattern pattern = Pattern.compile("\\{#[a-fA-F0-9]{6}}");
/*    */   
/*    */   public static String make(Player player, String content) {
/* 18 */     return colors(placeholders(player, content));
/*    */   }
/*    */   
/*    */   public static String removeLastCharacter(String str) {
/* 22 */     String result = null;
/* 23 */     if (str != null && str.length() > 0) {
/* 24 */       result = str.substring(0, str.length() - 1);
/*    */     }
/* 26 */     return result;
/*    */   }
/*    */   
/*    */   public static List<String> makeColoredStringList(List<String> list) {
/* 30 */     List<String> newList = new ArrayList<>();
/*    */     
/* 32 */     for (String str : list) {
/* 33 */       newList.add(colors(str));
/*    */     }
/*    */     
/* 36 */     return newList;
/*    */   }
/*    */   
/*    */   public static String colors(String content) {
/* 40 */     if (ServerVersion.minor() >= 16) {
/* 41 */       Matcher match = pattern.matcher(content);
/* 42 */       while (match.find()) {
/* 43 */         String color = content.substring(match.start(), match.end());
/* 44 */         content = content.replace(color, ChatColor.of(color.replaceAll("\\{|}", "")) + "");
/* 45 */         match = pattern.matcher(content);
/*    */       } 
/* 47 */       return ChatColor.translateAlternateColorCodes('&', content);
/*    */     } 
/* 49 */     return ChatColor.translateAlternateColorCodes('&', content);
/*    */   }
/*    */ 
/*    */   
/*    */   public static String placeholders(Player player, String content) {
/* 54 */     if ((Session.getSession()).enabled_dependencies.contains((Session.getSession()).dependencies[0]) && Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI") && 
/* 55 */       PlaceholderAPI.containsPlaceholders(content)) {
/* 56 */       return PlaceholderAPI.setPlaceholders(player, content);
/*    */     }
/*    */     
/* 59 */     return content;
/*    */   }
/*    */ }


/* Location:              D:\Downloads\Scoreboard-revision (1).jar!\rien\bijl\Scoreboard\r\Plugin\Utility\ScoreboardStrings.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */