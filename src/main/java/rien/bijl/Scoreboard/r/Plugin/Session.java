/*    */ package rien.bijl.Scoreboard.r.Plugin;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.plugin.java.JavaPlugin;
/*    */ import rien.bijl.Scoreboard.r.Board.ConfigBoard;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Session
/*    */ {
/*    */   public JavaPlugin plugin;
/*    */   private static Session session;
/* 15 */   public String[] dependencies = new String[] { "PlaceholderAPI" };
/* 16 */   public ArrayList<String> enabled_dependencies = new ArrayList<>();
/*    */   
/*    */   public boolean alertOutOfDate = false;
/*    */   
/*    */   public boolean alertBrokenConfig = false;
/*    */   
/*    */   public ConfigBoard defaultBoard;
/*    */   
/*    */   public WorldManager worldManager;
/*    */   
/*    */   public static void makeSession(JavaPlugin plugin) {
/* 27 */     session = new Session(plugin);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static Session getSession() {
/* 35 */     return session;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private Session(JavaPlugin plugin) {
/* 43 */     this.plugin = plugin;
/*    */     
/* 45 */     for (String dependency : this.dependencies) {
/* 46 */       if (Bukkit.getPluginManager().isPluginEnabled(dependency))
/* 47 */         this.enabled_dependencies.add(dependency); 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Downloads\Scoreboard-revision (1).jar!\rien\bijl\Scoreboard\r\Plugin\Session.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */