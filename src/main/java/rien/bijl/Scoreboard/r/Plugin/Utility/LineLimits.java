/*    */ package rien.bijl.Scoreboard.r.Plugin.Utility;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class LineLimits
/*    */ {
/*  7 */   private static int lineLimit = 0;
/*    */ 
/*    */   
/*    */   public static int getLineLimit() {
/* 11 */     if (lineLimit != 0) {
/* 12 */       return lineLimit;
/*    */     }
/*    */     
/* 15 */     int minor = ServerVersion.minor();
/*    */     
/* 17 */     if (minor >= 13) {
/* 18 */       lineLimit = 64;
/*    */     } else {
/* 20 */       lineLimit = 16;
/*    */     } 
/*    */     
/* 23 */     return lineLimit;
/*    */   }
/*    */ }


/* Location:              D:\Downloads\Scoreboard-revision (1).jar!\rien\bijl\Scoreboard\r\Plugin\Utility\LineLimits.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */