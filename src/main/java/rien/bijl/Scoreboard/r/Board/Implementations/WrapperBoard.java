/*    */ package rien.bijl.Scoreboard.r.Board.Implementations;
/*    */ 
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public class WrapperBoard
/*    */   implements IBoard
/*    */ {
/*    */   private static final String DEFAULT = "rien.bijl.Scoreboard.r.Board.Implementations.Drivers.V1.ScoreboardDriverV1";
/*  9 */   private static final String[][] DRIVERS = new String[][] { { "SCOREBOARD_DRIVER_V1", "rien.bijl.Scoreboard.r.Board.Implementations.Drivers.V1.ScoreboardDriverV1" } };
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private IBoard child;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public WrapperBoard(String driver) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
/* 23 */     for (String[] drivers : DRIVERS) {
/* 24 */       if (drivers[0].equals(driver)) {
/* 25 */         this.child = (IBoard)Class.forName(drivers[1]).newInstance();
/*    */       }
/*    */     } 
/* 28 */     if (this.child == null) {
/* 29 */       this.child = (IBoard)Class.forName("rien.bijl.Scoreboard.r.Board.Implementations.Drivers.V1.ScoreboardDriverV1").newInstance();
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void setPlayer(Player player) {
/* 35 */     this.child.setPlayer(player);
/*    */   }
/*    */ 
/*    */   
/*    */   public void setTitle(String title) {
/* 40 */     this.child.setTitle(title);
/*    */   }
/*    */ 
/*    */   
/*    */   public void setLine(int line, String content) {
/* 45 */     this.child.setLine(line, content);
/*    */   }
/*    */ 
/*    */   
/*    */   public void setLineCount(int lines) {
/* 50 */     this.child.setLineCount(lines);
/*    */   }
/*    */ 
/*    */   
/*    */   public Player getPlayer() {
/* 55 */     return this.child.getPlayer();
/*    */   }
/*    */ }


/* Location:              D:\Downloads\Scoreboard-revision (1).jar!\rien\bijl\Scoreboard\r\Board\Implementations\WrapperBoard.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */