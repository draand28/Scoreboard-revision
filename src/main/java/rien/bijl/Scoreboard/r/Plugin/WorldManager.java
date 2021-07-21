/*    */ package rien.bijl.Scoreboard.r.Plugin;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.scheduler.BukkitRunnable;
/*    */ import rien.bijl.Scoreboard.r.Board.BoardPlayer;
/*    */ 
/*    */ public class WorldManager
/*    */   extends BukkitRunnable
/*    */ {
/*    */   public static ArrayList<String> disabled_worlds;
/*    */   
/*    */   public WorldManager() {
/* 15 */     disabled_worlds = new ArrayList<>();
/* 16 */     for (String world : ConfigControl.get().gc("settings").getStringList("disabled-worlds"))
/*    */     {
/* 18 */       disabled_worlds.add(world.toLowerCase().trim());
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void run() {
/* 24 */     for (Player p : Bukkit.getOnlinePlayers()) {
/* 25 */       BoardPlayer player = BoardPlayer.getBoardPlayer(p);
/*    */       
/* 27 */       if (disabled_worlds.contains(p.getWorld().getName().toLowerCase().trim())) {
/* 28 */         player.lock(); continue;
/*    */       } 
/* 30 */       if (player.worldLock)
/* 31 */         player.unlock(); 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Downloads\Scoreboard-revision (1).jar!\rien\bijl\Scoreboard\r\Plugin\WorldManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */