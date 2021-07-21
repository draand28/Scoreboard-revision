/*    */ package rien.bijl.Scoreboard.r.Plugin.Listeners;
/*    */ 
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.player.PlayerQuitEvent;
/*    */ import rien.bijl.Scoreboard.r.Board.BoardPlayer;
/*    */ 
/*    */ public class LeaveListener
/*    */   implements Listener
/*    */ {
/*    */   @EventHandler
/*    */   public void onLeave(PlayerQuitEvent event) {
/* 13 */     BoardPlayer.getBoardPlayer(event.getPlayer()).kill();
/*    */   }
/*    */ }


/* Location:              D:\Downloads\Scoreboard-revision (1).jar!\rien\bijl\Scoreboard\r\Plugin\Listeners\LeaveListener.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */