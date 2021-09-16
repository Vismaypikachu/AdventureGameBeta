package package04;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import package01.game;

public class StatsHandler implements ActionListener{
	
	game m_game;
	
	public StatsHandler(game g) {
		m_game = g;
	}

	public void actionPerformed(ActionEvent event) {
		m_game.m_story.statschange();
	}
}