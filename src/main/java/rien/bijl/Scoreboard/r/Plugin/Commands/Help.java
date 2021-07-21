/*    */ package rien.bijl.Scoreboard.r.Plugin.Commands;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Objects;
/*    */ import org.bukkit.configuration.ConfigurationSection;
/*    */ import org.bukkit.entity.Player;
/*    */ import rien.bijl.Scoreboard.r.Plugin.ConfigControl;
/*    */ import rien.bijl.Scoreboard.r.Plugin.Utility.i18n;
/*    */ 
/*    */ 
/*    */ public class Help
/*    */ {
/*    */   public Help(Player player) {
/* 14 */     List<String> lines = ((ConfigurationSection)Objects.<ConfigurationSection>requireNonNull(ConfigControl.get().gc("language").getConfigurationSection("commands"))).getStringList("help");
/*    */     
/* 16 */     for (String line : lines)
/* 17 */       player.sendMessage(i18n.parse(line)); 
/*    */   }
/*    */ }


/* Location:              D:\Downloads\Scoreboard-revision (1).jar!\rien\bijl\Scoreboard\r\Plugin\Commands\Help.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */