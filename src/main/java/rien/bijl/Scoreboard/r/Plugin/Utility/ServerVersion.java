/*    */ package rien.bijl.Scoreboard.r.Plugin.Utility;
/*    */ 
/*    */ import rien.bijl.Scoreboard.r.Plugin.Session;
/*    */ 
/*    */ public class ServerVersion
/*    */ {
/*  7 */   private static int major = -1;
/*  8 */   private static int minor = -1;
/*    */ 
/*    */   
/*    */   public static int major() {
/* 12 */     if (major != -1) {
/* 13 */       return major;
/*    */     }
/*    */     
/* 16 */     String pack = (Session.getSession()).plugin.getServer().getClass().getPackage().getName();
/* 17 */     String[] version = pack.substring(pack.lastIndexOf('.') + 1).substring(1).split("_");
/* 18 */     major = Integer.parseInt(version[0]);
/* 19 */     return major;
/*    */   }
/*    */ 
/*    */   
/*    */   public static int minor() {
/* 24 */     if (minor != -1) {
/* 25 */       return minor;
/*    */     }
/*    */     
/* 28 */     String pack = (Session.getSession()).plugin.getServer().getClass().getPackage().getName();
/* 29 */     String[] version = pack.substring(pack.lastIndexOf('.') + 1).substring(1).split("_");
/* 30 */     minor = Integer.parseInt(version[1]);
/* 31 */     return minor;
/*    */   }
/*    */ }


/* Location:              D:\Downloads\Scoreboard-revision (1).jar!\rien\bijl\Scoreboard\r\Plugin\Utility\ServerVersion.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */