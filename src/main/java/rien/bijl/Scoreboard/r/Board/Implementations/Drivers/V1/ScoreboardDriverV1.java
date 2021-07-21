/*     */ package rien.bijl.Scoreboard.r.Board.Implementations.Drivers.V1;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Objects;
/*     */ import org.bukkit.ChatColor;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.scoreboard.DisplaySlot;
/*     */ import org.bukkit.scoreboard.Objective;
/*     */ import org.bukkit.scoreboard.Scoreboard;
/*     */ import org.bukkit.scoreboard.ScoreboardManager;
/*     */ import org.bukkit.scoreboard.Team;
/*     */ import rien.bijl.Scoreboard.r.Board.Implementations.IBoard;
/*     */ import rien.bijl.Scoreboard.r.Plugin.Session;
/*     */ import rien.bijl.Scoreboard.r.Plugin.Utility.LineLimits;
/*     */ import rien.bijl.Scoreboard.r.Plugin.Utility.ScoreboardStrings;
/*     */ 
/*     */ public class ScoreboardDriverV1
/*     */   implements IBoard {
/*     */   private Player player;
/*     */   private Scoreboard board;
/*     */   private Objective objective;
/*     */   private int lines;
/*  23 */   private HashMap<Integer, String> cache = new HashMap<>();
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPlayer(Player player) {
/*  28 */     this.player = player;
/*     */     
/*  30 */     this.board = ((ScoreboardManager)Objects.<ScoreboardManager>requireNonNull((Session.getSession()).plugin.getServer().getScoreboardManager())).getNewScoreboard();
/*  31 */     this.objective = this.board.registerNewObjective("sb1", "sb2");
/*  32 */     this.objective.setDisplaySlot(DisplaySlot.SIDEBAR);
/*  33 */     this.objective.setDisplayName("");
/*     */     
/*  35 */     createTeams();
/*  36 */     setBoard();
/*     */     
/*  38 */     LineLimits.getLineLimit();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTitle(String title) {
/*  44 */     if (title == null) {
/*  45 */       title = "";
/*     */     }
/*     */     
/*  48 */     if (title.length() > LineLimits.getLineLimit() * 2) {
/*  49 */       title = title.substring(0, LineLimits.getLineLimit() * 2);
/*     */     }
/*     */     
/*  52 */     this.objective.setDisplayName(title);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLine(int line, String content) {
/*  58 */     if (content == null) {
/*  59 */       content = "";
/*     */     }
/*  61 */     if (!shouldUpdate(line, content)) {
/*     */       return;
/*     */     }
/*     */     
/*  65 */     Team team = this.board.getTeam(line + "");
/*  66 */     String[] split = split(content);
/*     */     
/*  68 */     assert team != null;
/*     */     
/*  70 */     team.setPrefix(split[0]);
/*  71 */     team.setSuffix(split[1]);
/*     */   }
/*     */ 
/*     */   
/*     */   private String[] split(String line) {
/*  76 */     if (line.length() < LineLimits.getLineLimit()) {
/*  77 */       return new String[] { line, "" };
/*     */     }
/*     */     
/*  80 */     String prefix = line.substring(0, LineLimits.getLineLimit());
/*  81 */     String suffix = line.substring(LineLimits.getLineLimit());
/*     */     
/*  83 */     if (prefix.endsWith("§")) {
/*  84 */       prefix = ScoreboardStrings.removeLastCharacter(prefix);
/*  85 */       suffix = "§" + suffix;
/*  86 */     } else if (prefix.contains("§")) {
/*  87 */       suffix = ChatColor.getLastColors(prefix) + suffix;
/*     */     } else {
/*  89 */       suffix = "§f" + suffix;
/*     */     } 
/*     */     
/*  92 */     if (suffix.length() > LineLimits.getLineLimit()) {
/*  93 */       suffix = suffix.substring(0, LineLimits.getLineLimit());
/*     */     }
/*     */     
/*  96 */     return new String[] { prefix, suffix };
/*     */   }
/*     */   
/*     */   private boolean shouldUpdate(int line, String content) {
/* 100 */     if (!this.cache.containsKey(Integer.valueOf(line))) {
/* 101 */       this.cache.put(Integer.valueOf(line), content);
/* 102 */       return true;
/*     */     } 
/*     */     
/* 105 */     if (((String)this.cache.get(Integer.valueOf(line))).equals(content)) {
/* 106 */       return false;
/*     */     }
/*     */     
/* 109 */     this.cache.put(Integer.valueOf(line), content);
/* 110 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLineCount(int lines) {
/* 116 */     this.lines = lines;
/*     */   }
/*     */ 
/*     */   
/*     */   public Player getPlayer() {
/* 121 */     return getPlayer();
/*     */   }
/*     */ 
/*     */   
/*     */   private void createTeams() {
/* 126 */     int score = this.lines;
/*     */     
/* 128 */     for (int i = 0; i < this.lines; i++) {
/* 129 */       Team t = this.board.registerNewTeam(i + "");
/* 130 */       t.addEntry(ChatColor.values()[i] + "");
/* 131 */       this.objective.getScore(ChatColor.values()[i] + "").setScore(score);
/* 132 */       score--;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void setBoard() {
/* 138 */     this.player.setScoreboard(this.board);
/*     */   }
/*     */ }


/* Location:              D:\Downloads\Scoreboard-revision (1).jar!\rien\bijl\Scoreboard\r\Board\Implementations\Drivers\V1\ScoreboardDriverV1.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */