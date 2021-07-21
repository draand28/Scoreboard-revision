/*    */ package rien.bijl.Scoreboard.r.Plugin;
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import java.io.OutputStream;
/*    */ import java.util.Random;
/*    */ import org.bukkit.configuration.file.FileConfiguration;
/*    */ 
/*    */ public class ConfigChecker {
/*    */   public static void check(String config, int version) {
/* 11 */     FileConfiguration fc = ConfigControl.get().gc(config);
/*    */     
/* 13 */     if (fc.getInt("config_version") < version) {
/* 14 */       (Session.getSession()).alertBrokenConfig = true;
/* 15 */       replaceConfig(config);
/*    */     } 
/*    */   }
/*    */   
/*    */   public static void replaceConfig(String config) {
/* 20 */     File oldFile = new File((Session.getSession()).plugin.getDataFolder(), config + ".yml");
/* 21 */     File newFile = new File((Session.getSession()).plugin.getDataFolder(), config + "." + (new Random()).nextInt(999999999) + ".backup.yml");
/*    */     
/*    */     
/* 29 */     oldFile.delete();
/*    */     
/* 31 */     ConfigControl.get().reloadConfigs();
/*    */   }
/*    */   
/*    */ }


/* Location:              D:\Downloads\Scoreboard-revision (1).jar!\rien\bijl\Scoreboard\r\Plugin\ConfigChecker.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */