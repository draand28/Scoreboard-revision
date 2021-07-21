/*    */ package rien.bijl.Scoreboard.r.Plugin.Commands;
/*    */ 
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.entity.Player;
/*    */ import rien.bijl.Scoreboard.r.Plugin.Utility.i18n;
/*    */ 
/*    */ public class Manager
/*    */   implements CommandExecutor
/*    */ {
/*    */   public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
/* 13 */     if (!(commandSender instanceof Player)) {
/* 14 */       commandSender.sendMessage(i18n.get("commands.notaplayer"));
/* 15 */       return false;
/*    */     } 
/*    */     
/* 18 */     Player player = (Player)commandSender;
/*    */     
/* 20 */     if (args.length < 1)
/* 21 */     { new Help(player); }
/*    */     else
/* 23 */     { switch (args[0].toLowerCase())
/*    */       { case "on":
/* 25 */           new On(player);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */           
/* 42 */           return false;case "off": new Off(player); return false;case "toggle": new Toggle(player); return false;case "reload": new Reload(player); return false; }  player.sendMessage(i18n.get("commands.notfound")); }  return false;
/*    */   }
/*    */ }


/* Location:              D:\Downloads\Scoreboard-revision (1).jar!\rien\bijl\Scoreboard\r\Plugin\Commands\Manager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */