/*    */ package rien.bijl.Scoreboard.r.Board;
/*    */ 
/*    */ import java.util.Collection;
/*    */ import java.util.HashMap;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BoardPlayer
/*    */ {
/*    */   private final Player player;
/*    */   private ConfigBoard configBoard;
/*    */   private boolean enabled = true;
/*    */   public boolean worldLock = false;
/*    */   
/*    */   private BoardPlayer(Player player) {
/* 17 */     this.player = player;
/* 18 */     map.put(player, this);
/*    */   }
/*    */   
/*    */   public boolean isEnabled() {
/* 22 */     return this.enabled;
/*    */   }
/*    */   
/*    */   public void setEnabled(boolean enabled) {
/* 26 */     this.enabled = enabled;
/*    */     
/* 28 */     if (!this.enabled) {
/* 29 */       this.configBoard.unhookPlayer(this.player);
/*    */     } else {
/* 31 */       this.configBoard.hookPlayer(this.player);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void lock() {
/* 37 */     this.configBoard.unhookPlayer(this.player);
/* 38 */     this.worldLock = true;
/*    */   }
/*    */   
/*    */   public void unlock() {
/* 42 */     this.worldLock = false;
/*    */     
/* 44 */     if (isEnabled()) {
/* 45 */       this.configBoard.hookPlayer(this.player);
/*    */     }
/*    */   }
/*    */   
/*    */   public void attachConfigBoard(ConfigBoard board) {
/* 50 */     if (this.configBoard != null) {
/* 51 */       this.configBoard.unhookPlayer(this.player);
/*    */     }
/* 53 */     this.configBoard = board;
/* 54 */     this.configBoard.hookPlayer(this.player);
/*    */   }
/*    */   
/*    */   public void kill() {
/* 58 */     this.configBoard.unhookPlayer(this.player);
/* 59 */     map.remove(this.player);
/*    */   }
/*    */ 
/*    */   
/*    */   public static BoardPlayer getBoardPlayer(Player player) {
/* 64 */     if (map.containsKey(player)) {
/* 65 */       return map.get(player);
/*    */     }
/*    */     
/* 68 */     return new BoardPlayer(player);
/*    */   }
/*    */   
/*    */   public static Collection<BoardPlayer> allBoardPlayers() {
/* 72 */     return map.values();
/*    */   }
/*    */ 
/*    */   
/* 76 */   private static HashMap<Player, BoardPlayer> map = new HashMap<>();
/*    */ }


/* Location:              D:\Downloads\Scoreboard-revision (1).jar!\rien\bijl\Scoreboard\r\Board\BoardPlayer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */