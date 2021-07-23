package rien.bijl.Scoreboard.r;

import org.bukkit.plugin.java.JavaPlugin;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.player.PlayerJoinEvent;
/*    */ import rien.bijl.Scoreboard.r.Board.BoardPlayer;
/*    */ import rien.bijl.Scoreboard.r.Plugin.Session;
/*    */ import rien.bijl.Scoreboard.r.Plugin.Utility.i18n;

public class Main extends JavaPlugin {

    public void onEnable()
    {
        new ScoreboardRevision(this, "board")
            .enable();
    }
	public void onJoin(PlayerJoinEvent event) {
		BoardPlayer.getBoardPlayer(event.getPlayer()).setEnabled(true);
		
		event.getPlayer().sendMessage("Main");
	}


}
