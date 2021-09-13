package package04;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import package01.Constants;
import package01.Player;
import package01.UI;
import package01.game;

public class InputHandler implements ActionListener{
	
	game m_game;
	UI m_ui;
	Constants m_constants = new Constants(m_ui);
	Player m_player = new Player(m_ui, m_constants);
	
	public InputHandler(game g, UI userInterface) {
		m_game = g;
		m_ui = userInterface;
	}
	
	public void actionPerformed(ActionEvent event) {
		m_constants.inputcount++;
		m_player.playerName = m_ui.jtf.getText();
		m_ui.textLabel.setText("Hello " + m_player.playerName + ", lets begin our adventure!!!");
		if(m_constants.inputcount == 2) m_ui.createGameScreen();
	}
}
