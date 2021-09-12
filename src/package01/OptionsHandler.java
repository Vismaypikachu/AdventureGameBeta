package package01;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class OptionsHandler implements ActionListener {
	
	UI m_ui = new UI();
	game m_game;
	Constants m_constants = new Constants();
	
	public OptionsHandler(game g) {
    // Constructor
		m_game = g;
	}
 
	public void actionPerformed(ActionEvent event) {
		String yourChoice = event.getActionCommand();
		m_constants.text = m_ui.mainTextArea.getText();
		m_constants.b1text = m_ui.choice1.getText();
		m_constants.b2text = m_ui.choice2.getText();
		m_constants.b3text = m_ui.choice3.getText();
		m_constants.b4text = m_ui.choice4.getText();
		m_constants.b5text = m_ui.specialattack.getText();
		
		switch(yourChoice) {
			case "inGameOptions":
				if(m_constants.OptionsStatus.equals("close")) {
					m_ui.choice1.setVisible(false);
					m_ui.choice2.setVisible(false);
					m_ui.choice3.setVisible(false);
					m_ui.choice4.setVisible(false);	
					m_ui.specialattack.setVisible(false);
					m_ui.inventoryButton.setVisible(false);
					m_ui.inGameOptionsPanel.setVisible(true);
					m_ui.inGameOptionsButtons[1].setText("Full Screen");
					m_ui.inGameOptionsButtons[2].setText("Small Screen");
					m_ui.inGameOptionsButtons[3].setText("Main Menu");
					m_ui.inGameOptionsButtons[4].setText("Exit Game");
					m_ui.inGameOptionsButtons[5].setText("Show Backpack");
					m_constants.OptionsStatus = "open";
				}
				else if(m_constants.OptionsStatus.equals("open")) {
					m_ui.choice1.setVisible(true);
					m_ui.choice2.setVisible(true);
					m_ui.choice3.setVisible(true);
					m_ui.choice4.setVisible(true);
					m_ui.specialattack.setVisible(true);
					m_ui.inventoryButton.setVisible(true);
					m_ui.inGameOptionsPanel.setVisible(false);
					m_constants.OptionsStatus = "close";
				}
			break;
			case "option1": m_ui.inGameOptionsPanel.setVisible(false); m_constants.OptionsStatus = "close"; m_ui.setFullScreen2(); break;
			case "option2": m_ui.inGameOptionsPanel.setVisible(false); m_constants.OptionsStatus = "close"; m_ui.endFullScreen2(); break;
			case "option3": 
				if(m_constants.fullScreenOn == true) { m_ui.endFullScreen2(); m_ui.window.remove(m_ui.inGameOptionsPanel); m_ui.createUIComponent();}
				else if(m_constants.fullScreenOn == false) { m_constants.reinitializeVars(); m_ui.createUIComponent();}
			break;
			case "option4": System.exit(0); break;
		}
	}
}
