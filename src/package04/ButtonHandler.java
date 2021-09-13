package package04;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import package01.Constants;
import package01.SoundEffect;
import package01.UI;
import package01.game;

public class ButtonHandler implements ActionListener {
	
	game m_game;
	UI m_ui;
	Constants m_constants = new Constants(m_ui);
	SoundEffect m_se = new SoundEffect();
	
	public ButtonHandler(game g, UI userInterface) {
		m_game = g;
		m_ui = userInterface;
	}
	
	public void actionPerformed(ActionEvent event) {
		m_se.setURL(m_constants.clickSoundURL);
		m_se.play();
	}
}