package package04;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import package01.game;

public class ButtonHandler implements ActionListener {
	
	game m_game;
	
	public ButtonHandler(game g) {
		m_game = g;
	}	
	
	public void actionPerformed(ActionEvent event) {
		m_game.m_se.setURL(m_game.m_constants.clickSoundURL);
		m_game.m_se.play();
	}
}