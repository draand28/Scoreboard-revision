/*    */ package rien.bijl.Scoreboard.r.Board;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Objects;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.configuration.ConfigurationSection;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.scheduler.BukkitRunnable;
/*    */ import org.bukkit.scoreboard.ScoreboardManager;
/*    */ import rien.bijl.Scoreboard.r.Board.Animations.Row;
/*    */ import rien.bijl.Scoreboard.r.Board.Implementations.WrapperBoard;
/*    */ import rien.bijl.Scoreboard.r.Plugin.ConfigControl;
/*    */ import rien.bijl.Scoreboard.r.Plugin.Utility.ScoreboardStrings;
/*    */ 
/*    */ public class ConfigBoard
/*    */   extends BukkitRunnable {
/*    */   public String board;
/*    */   private Row title;
/* 21 */   private ArrayList<Row> rows = new ArrayList<>();
/* 22 */   private ArrayList<Player> players = new ArrayList<>();
/* 23 */   private HashMap<Player, WrapperBoard> playerToBoard = new HashMap<>();
/*    */   
/*    */   private boolean enabled;
/*    */   
/*    */   public ConfigBoard(String board) {
/* 28 */     this.board = board;
/* 29 */     initTitle();
/* 30 */     initRows();
/*    */   }
/*    */ 
/*    */   
/*    */   private void initTitle() {
/* 35 */     List<String> lines = ((ConfigurationSection)Objects.<ConfigurationSection>requireNonNull(ConfigControl.get().gc("settings").getConfigurationSection(this.board + ".title"))).getStringList("lines");
/* 36 */     int interval = ConfigControl.get().gc("settings").getInt(this.board + ".title.interval");
/* 37 */     this.title = new Row(ScoreboardStrings.makeColoredStringList(lines), interval);
/*    */   }
/*    */ 
/*    */   
/*    */   private void initRows() {
/* 42 */     for (int i = 1; i < 200; i++) {
/* 43 */       ConfigurationSection section = ConfigControl.get().gc("settings").getConfigurationSection(this.board + ".rows." + i);
/* 44 */       if (section != null) {
/* 45 */         Row row = new Row(ScoreboardStrings.makeColoredStringList(section.getStringList("lines")), section.getInt("interval"));
/* 46 */         this.rows.add(row);
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   public void hookPlayer(Player player) {
/* 52 */     this.players.add(player);
/*    */     
/*    */     try {
/* 55 */       WrapperBoard wrapperBoard = new WrapperBoard("SCOREBOARD_DRIVER_V1");
/* 56 */       wrapperBoard.setLineCount(this.rows.size());
/* 57 */       wrapperBoard.setPlayer(player);
/* 58 */       this.playerToBoard.put(player, wrapperBoard);
/* 59 */     } catch (ClassNotFoundException|InstantiationException|IllegalAccessException e) {
/* 60 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */   
/*    */   public void unhookPlayer(Player player) {
/* 65 */     this.playerToBoard.remove(player);
/* 66 */     this.players.remove(player);
/* 67 */     player.setScoreboard(((ScoreboardManager)Objects.<ScoreboardManager>requireNonNull(Bukkit.getScoreboardManager())).getNewScoreboard());
/*    */   }
/*    */ 
/*    */   
/*    */   public void run() {
/* 72 */     if (!this.enabled)
/*    */       return; 
/* 74 */     this.title.update();
/*    */     
/* 76 */     for (Row row : this.rows) {
/* 77 */       row.update();
/*    */     }
/*    */     
/* 80 */     for (Player player : this.playerToBoard.keySet()) {
/* 81 */       WrapperBoard wrapperBoard = this.playerToBoard.get(player);
/* 82 */       wrapperBoard.setTitle(ScoreboardStrings.placeholders(player, this.title.getLine()));
/*    */       
/* 84 */       int count = 0;
/* 85 */       for (Row row : this.rows) {
/* 86 */         wrapperBoard.setLine(count, ScoreboardStrings.placeholders(player, row.getLine()));
/* 87 */         count++;
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   public void enable() {
/* 93 */     this.enabled = true;
/*    */   }
/*    */   
/*    */   public void disable() {
/* 97 */     this.enabled = false;
/*    */   }
/*    */ }


/* Location:              D:\Downloads\Scoreboard-revision (1).jar!\rien\bijl\Scoreboard\r\Board\ConfigBoard.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */