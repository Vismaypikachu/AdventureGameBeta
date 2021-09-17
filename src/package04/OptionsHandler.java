package package04;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import package01.game;


public class OptionsHandler implements ActionListener {
	
	game m_game;
 
	public OptionsHandler(game g) {
		m_game = g;
	}

	public void actionPerformed(ActionEvent event) {
		String yourChoice = event.getActionCommand();
		m_game.m_constants.text = m_game.m_ui.mainTextArea.getText();
		m_game.m_constants.b1text = m_game.m_ui.choice1.getText();
		m_game.m_constants.b2text = m_game.m_ui.choice2.getText();
		m_game.m_constants.b3text = m_game.m_ui.choice3.getText();
		m_game.m_constants.b4text = m_game.m_ui.choice4.getText();
		m_game.m_constants.b5text = m_game.m_ui.specialattack.getText();
		
		switch(yourChoice) {
			case "inGameOptions":
				if(m_game.m_constants.OptionsStatus.equals("close")) {
					m_game.m_ui.choice1.setVisible(false);
					m_game.m_ui.choice2.setVisible(false);
					m_game.m_ui.choice3.setVisible(false);
					m_game.m_ui.choice4.setVisible(false);	
					m_game.m_ui.specialattack.setVisible(false);
					m_game.m_ui.inventoryButton.setVisible(false);
					try {
						for(int i = 0; i < m_game.m_ui.inventoryButtons.length; i++) {
							m_game.m_ui.sidePanel.remove(m_game.m_ui.inventoryButtons[i]);
						}
					}
					catch (Exception e) {
						
					}
					for(int i = 0; i < m_game.m_ui.inGameOptionsButtons.length; i++) {
						m_game.m_ui.sidePanel.add(m_game.m_ui.inGameOptionsButtons[i]);
					}
					m_game.m_ui.sidePanel.setLayout(new GridLayout(5,1));
					m_game.m_ui.sidePanel.setVisible(true);
					m_game.m_ui.inGameOptionsButtons[0].setText("Full Screen");
					m_game.m_ui.inGameOptionsButtons[1].setText("Small Screen");
					m_game.m_ui.inGameOptionsButtons[2].setText("Main Menu");
					m_game.m_ui.inGameOptionsButtons[3].setText("Exit Game");
					m_game.m_ui.inGameOptionsButtons[4].setText("Show Backpack");
					m_game.m_constants.OptionsStatus = "open";
				}
				else if(m_game.m_constants.OptionsStatus.equals("open")) {
					m_game.m_ui.choice1.setVisible(true);
					m_game.m_ui.choice2.setVisible(true);
					m_game.m_ui.choice3.setVisible(true);
					m_game.m_ui.choice4.setVisible(true);
					m_game.m_ui.specialattack.setVisible(true);
					m_game.m_ui.inventoryButton.setVisible(true);
					for(int i = 0; i < m_game.m_ui.inGameOptionsButtons.length; i++) {
						m_game.m_ui.sidePanel.remove(m_game.m_ui.inGameOptionsButtons[i]);
					}
					m_game.m_ui.sidePanel.setLayout(new GridLayout(5,1));
					m_game.m_ui.sidePanel.setVisible(false);
					m_game.m_constants.OptionsStatus = "close";
				}
			break;
			case "option1": m_game.m_ui.sidePanel.setVisible(false); m_game.m_constants.OptionsStatus = "close"; m_game.m_ui.setFullScreen2(); break;
			case "option2": m_game.m_ui.sidePanel.setVisible(false); m_game.m_constants.OptionsStatus = "close"; m_game.m_ui.endFullScreen2(); break;
			case "option3": 
				if(m_game.m_constants.fullScreenOn == true) { m_game.m_ui.endFullScreen2(); m_game.m_constants.reinitializeVars(); m_game.m_ui.createUIComponent();}
				else if(m_game.m_constants.fullScreenOn == false) { m_game.m_constants.reinitializeVars(); m_game.m_ui.createUIComponent();}
			break;
			case "option4": System.exit(0); break;
		}
	}
}
