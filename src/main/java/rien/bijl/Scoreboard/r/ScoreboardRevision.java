/*    */ package rien.bijl.Scoreboard.r;
/*    */ 
/*    */ 
/*    */ import java.util.Objects;
/*    */ import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.PluginCommand;
/*    */ import org.bukkit.configuration.ConfigurationSection;
/*    */ import org.bukkit.entity.Player;

import org.bukkit.event.player.PlayerJoinEvent;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.plugin.Plugin;
/*    */ import org.bukkit.plugin.java.JavaPlugin;
/*    */ import rien.bijl.Scoreboard.r.Board.BoardPlayer;
/*    */ import rien.bijl.Scoreboard.r.Board.ConfigBoard;
/*    */ import rien.bijl.Scoreboard.r.Plugin.Commands.Manager;
/*    */ import rien.bijl.Scoreboard.r.Plugin.ConfigChecker;
/*    */ import rien.bijl.Scoreboard.r.Plugin.ConfigControl;
/*    */ import rien.bijl.Scoreboard.r.Plugin.Listeners.JoinListener;
/*    */ import rien.bijl.Scoreboard.r.Plugin.Listeners.LeaveListener;
/*    */ import rien.bijl.Scoreboard.r.Plugin.Session;
/*    */ import rien.bijl.Scoreboard.r.Plugin.Utility.UpdateChecker;
/*    */ import rien.bijl.Scoreboard.r.Plugin.WorldManager;
import rien.bijl.Scoreboard.r.Plugin.Utility.i18n;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ScoreboardRevision
/*    */ {
/*    */   private final JavaPlugin plugin;
/*    */   private final String defaultBoard;
/*    */   
/*    */   public ScoreboardRevision(JavaPlugin plugin, String defaultBoard) {
/* 32 */     this.plugin = plugin;
/* 33 */     this.defaultBoard = defaultBoard;
/*    */   }
/*    */ 
/*    */   
/*    */   public void enable() {
/* 38 */     Session.makeSession(this.plugin);
/*    */     
/* 40 */     setupBasics();
/* 41 */     registerEvents();
/* 42 */     checkForUpdates();
/*    */   }
/*    */ 
/*    */   
/*    */   private void checkForUpdates() {
/* 47 */     if (!((ConfigurationSection)Objects.<ConfigurationSection>requireNonNull(ConfigControl.get().gc("settings").getConfigurationSection("settings"))).getBoolean("check-updates")) {
/*    */       return;
/*    */     }
/*    */     
/* 51 */     String version = (new UpdateChecker(this.plugin, 14754)).getVersion();
/*    */     
/* 53 */     if (!this.plugin.getDescription().getVersion().replaceAll("\\s", "").equalsIgnoreCase(version)) {
/*    */       
/* 55 */       (Session.getSession()).alertOutOfDate = true;
/* 56 */       (Session.getSession()).plugin.getLogger().warning("Scoreboard-revision is out of date! Check the Spigot page for new updates");
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   private void setupBasics() {
/* 62 */     ConfigControl.get().createDataFiles();
/* 63 */     ConfigChecker.check("settings", 1);
/* 64 */     ConfigChecker.check("language", 1);
/*    */     
/* 66 */     (Session.getSession()).defaultBoard = new ConfigBoard(this.defaultBoard);
/* 67 */     for (Player player : Bukkit.getOnlinePlayers()) {
/* 68 */       BoardPlayer.getBoardPlayer(player).attachConfigBoard((Session.getSession()).defaultBoard);
/*    */     }
/* 70 */     (Session.getSession()).defaultBoard.enable();
/* 71 */     (Session.getSession()).defaultBoard.runTaskTimerAsynchronously((Plugin)this.plugin, 1L, 1L);
/*    */     
/* 73 */     (Session.getSession()).worldManager = new WorldManager();
/* 74 */     (Session.getSession()).worldManager.runTaskTimer((Plugin)this.plugin, 1L, 20L);
/*    */     
/* 76 */     
/* 77 */     ((PluginCommand)Objects.<PluginCommand>requireNonNull(this.plugin.getCommand("sb"))).setExecutor((CommandExecutor)new Manager());
/*    */   }
/*    */ 	public void onJoin(PlayerJoinEvent event) {
		BoardPlayer.getBoardPlayer(event.getPlayer()).setEnabled(true);
		
		event.getPlayer().sendMessage("ScoreboardRevision");
	}
/*    */   
/*    */   private void registerEvents() {
/* 82 */     Bukkit.getPluginManager().registerEvents((Listener)new JoinListener(), (Plugin)this.plugin);
/* 83 */     Bukkit.getPluginManager().registerEvents((Listener)new LeaveListener(), (Plugin)this.plugin);
/*    */   }
/*    */ }


/* Location:              D:\Downloads\Scoreboard-revision (1).jar!\rien\bijl\Scoreboard\r\ScoreboardRevision.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */