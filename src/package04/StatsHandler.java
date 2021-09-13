package package04;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import package01.UI;
import package01.game;

public class StatsHandler implements ActionListener{
	
	game m_game;
	UI m_ui;
	
	public StatsHandler(game g, UI userInterface) {
		m_game = g;
		m_ui = userInterface;
	}
	
	public void actionPerformed(ActionEvent event) {
		m_ui.statschange();
	}
}