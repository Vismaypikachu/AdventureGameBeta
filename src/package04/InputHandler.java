package package04;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import package01.game;

public class InputHandler implements ActionListener{
	
	game m_game;

	public InputHandler(game g) {
		m_game = g;
	}

	public void actionPerformed(ActionEvent event) {
		m_game.m_constants.inputcount++;
		m_game.m_player.playerName = m_game.m_ui.jtf.getText();
		m_game.m_ui.textLabel.setText("Hello " + m_game.m_player.playerName + ", lets begin our adventure!!!");
		if(m_game.m_constants.inputcount == 2) m_game.m_ui.createGameScreen();
	}
}
