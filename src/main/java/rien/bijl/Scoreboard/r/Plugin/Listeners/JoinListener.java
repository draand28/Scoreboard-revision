/*    */ package rien.bijl.Scoreboard.r.Plugin.Listeners;
/*    */ 
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
/*    */ import org.bukkit.event.player.PlayerJoinEvent;
/*    */ import rien.bijl.Scoreboard.r.Board.BoardPlayer;
/*    */ import rien.bijl.Scoreboard.r.Plugin.Session;
/*    */ import rien.bijl.Scoreboard.r.Plugin.Utility.i18n;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class JoinListener
/*    */   implements Listener
/*    */ {
/*    */   @EventHandler
/*    */   public void onJoin(PlayerJoinEvent event) {
	BoardPlayer.getBoardPlayer(event.getPlayer()).setEnabled(true);
	event.getPlayer().sendMessage("JoinListener");
/* 19 */     if (event.getPlayer().isOp() && (Session.getSession()).alertOutOfDate) {
/* 20 */       event.getPlayer().sendMessage(i18n.get("misc.outofdate"));
/*    */     }
/*    */     
/* 23 */     if (event.getPlayer().isOp() && (Session.getSession()).alertBrokenConfig) {
/* 24 */       event.getPlayer().sendMessage(i18n.get("misc.configUpdated"));
/*    */     }
/*    */     
/* 27 */     BoardPlayer.getBoardPlayer(event.getPlayer()).attachConfigBoard((Session.getSession()).defaultBoard);
			BoardPlayer.getBoardPlayer(event.getPlayer()).setEnabled(true);
			
			event.getPlayer().sendMessage("JoinListener");
/*    */   }
/*    */ }


/* Location:              D:\Downloads\Scoreboard-revision (1).jar!\rien\bijl\Scoreboard\r\Plugin\Listeners\JoinListener.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */