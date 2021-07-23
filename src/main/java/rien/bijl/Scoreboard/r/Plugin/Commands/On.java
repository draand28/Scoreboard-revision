/*    */ package rien.bijl.Scoreboard.r.Plugin.Commands;
/*    */ 
/*    */ import org.bukkit.entity.Player;
/*    */ import rien.bijl.Scoreboard.r.Board.BoardPlayer;
/*    */ import rien.bijl.Scoreboard.r.Plugin.Utility.i18n;
import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
/*    */ import org.bukkit.event.player.PlayerJoinEvent;
/*    */ import rien.bijl.Scoreboard.r.Plugin.Session;
/*    */ 
/*    */ 
/*    */ public class On
/*    */ {
/*    */   public On(Player player) {
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
/* 21 */     BoardPlayer.getBoardPlayer(player).setEnabled(true);
/* 22 */     player.sendMessage(i18n.get("commands.toggleon"));
             player.getPlayer().sendMessage("ON");

/*    */   }
/*    */ }


/* Location:              D:\Downloads\Scoreboard-revision (1).jar!\rien\bijl\Scoreboard\r\Plugin\Commands\On.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */