package package01;

public class VisibilityManager {
	
	game m_game;
	
	public VisibilityManager(game g) {
		m_game = g;
	}	
	
	public void showTitleScreen() {
		//show title screen
		m_game.m_ui.titleNamePanel.setVisible(true);
		m_game.m_ui.startButtonPanel.setVisible(true);
		//hide game screen
		/*
		m_ui.mainTextPanel.setVisible(false);
		m_ui.choiceButtonPanel.setVisible(false);
		m_ui.playerPanel.setVisible(false);
		m_ui.imagePanel.setVisible(false);
		m_ui.backButtonPanel.setVisible(false);
		*/
	}
	
	public void hideTitleScreen() {
		m_game.m_ui.titleNamePanel.setVisible(false);
		m_game.m_ui.startButtonPanel.setVisible(false);
	}
	
	public void showGameScreen() {
		//hide title screen
		m_game.m_ui.titleNamePanel.setVisible(false);
		m_game.m_ui.startButtonPanel.setVisible(false);
		//show game screen
		/*
		m_ui.mainTextPanel.setVisible(true);
		m_ui.choiceButtonPanel.setVisible(true);
		m_ui.playerPanel.setVisible(true);
		m_ui.imagePanel.setVisible(true);
		m_ui.backButtonPanel.setVisible(true);
		*/
	}
}