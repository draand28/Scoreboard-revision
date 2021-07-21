/*    */ package rien.bijl.Scoreboard.r.Plugin.Commands;
/*    */ 
/*    */ import org.bukkit.entity.Player;
/*    */ import rien.bijl.Scoreboard.r.Board.BoardPlayer;
/*    */ import rien.bijl.Scoreboard.r.Plugin.Utility.i18n;
/*    */ 
/*    */ 
/*    */ public class Toggle
/*    */ {
/*    */   public Toggle(Player player) {
/* 11 */     if (!player.hasPermission("scoreboard.toggle")) {
/* 12 */       player.sendMessage(i18n.get("commands.lackspermission"));
/*    */       
/*    */       return;
/*    */     } 
/* 16 */     if ((BoardPlayer.getBoardPlayer(player)).worldLock) {
/* 17 */       player.sendMessage(i18n.get("commands.worldlock"));
/*    */       
/*    */       return;
/*    */     } 
/* 21 */     BoardPlayer bp = BoardPlayer.getBoardPlayer(player);
/*    */     
/* 23 */     bp.setEnabled(!bp.isEnabled());
/*    */     
/* 25 */     if (bp.isEnabled()) {
/* 26 */       player.sendMessage(i18n.get("commands.toggleon"));
/*    */     } else {
/* 28 */       player.sendMessage(i18n.get("commands.toggleoff"));
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Downloads\Scoreboard-revision (1).jar!\rien\bijl\Scoreboard\r\Plugin\Commands\Toggle.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */