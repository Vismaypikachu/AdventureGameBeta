package package04;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import package01.game;

public class GameoverHandler implements ActionListener{
	
	game m_game;
	
	public GameoverHandler(game g) {
		m_game = g;
	}

	public void actionPerformed(ActionEvent event) {
		if(m_game.m_player.playerHP <= 0 && !m_game.m_constants.position.equals("noLoad")) {
			m_game.m_constants.position = "gameover";
			m_game.m_story.gameover();
		}
	}
}
