/*    */ package rien.bijl.Scoreboard.r.Plugin.Commands;
/*    */ 
/*    */ import java.util.Collection;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.plugin.Plugin;
/*    */ import rien.bijl.Scoreboard.r.Board.BoardPlayer;
/*    */ import rien.bijl.Scoreboard.r.Board.ConfigBoard;
/*    */ import rien.bijl.Scoreboard.r.Plugin.ConfigControl;
/*    */ import rien.bijl.Scoreboard.r.Plugin.Session;
/*    */ import rien.bijl.Scoreboard.r.Plugin.Utility.i18n;
/*    */ import rien.bijl.Scoreboard.r.Plugin.WorldManager;
/*    */ 
/*    */ 
/*    */ public class Reload
/*    */ {
/*    */   public Reload(Player player) {
/* 17 */     if (!player.hasPermission("scoreboard.reload")) {
/* 18 */       player.sendMessage(i18n.get("commands.lackspermission"));
/*    */       
/*    */       return;
/*    */     } 
/* 22 */     (Session.getSession()).defaultBoard.cancel();
/* 23 */     (Session.getSession()).worldManager.cancel();
/*    */     
/* 25 */     ConfigControl.get().reloadConfigs();
/* 26 */     Collection<BoardPlayer> boardPlayers = BoardPlayer.allBoardPlayers();
/* 27 */     ConfigBoard newBoard = new ConfigBoard("board");
/*    */     
/* 29 */     newBoard.enable();
/* 30 */     newBoard.runTaskTimerAsynchronously((Plugin)(Session.getSession()).plugin, 1L, 1L);
/*    */     
/* 32 */     (Session.getSession()).worldManager = new WorldManager();
/* 33 */     (Session.getSession()).worldManager.runTaskTimer((Plugin)(Session.getSession()).plugin, 1L, 20L);
/*    */     
/* 35 */     (Session.getSession()).defaultBoard = newBoard;
/*    */     
/* 37 */     for (BoardPlayer bp : boardPlayers) {
/* 38 */       bp.attachConfigBoard(newBoard);
/*    */     }
/*    */     
/* 41 */     player.sendMessage(i18n.get("commands.reload"));
/*    */   }
/*    */ }


/* Location:              D:\Downloads\Scoreboard-revision (1).jar!\rien\bijl\Scoreboard\r\Plugin\Commands\Reload.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */