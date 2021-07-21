package rien.bijl.Scoreboard.r.Board.Implementations;

import org.bukkit.entity.Player;

public interface IBoard {
  void setPlayer(Player paramPlayer);
  
  void setTitle(String paramString);
  
  void setLine(int paramInt, String paramString);
  
  void setLineCount(int paramInt);
  
  Player getPlayer();
}


/* Location:              D:\Downloads\Scoreboard-revision (1).jar!\rien\bijl\Scoreboard\r\Board\Implementations\IBoard.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */