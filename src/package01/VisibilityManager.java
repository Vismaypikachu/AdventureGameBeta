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
		m_game.m_ui.titleScreenImagePanel.setVisible(true);
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
		m_game.m_ui.titleScreenImagePanel.setVisible(false);
	}
	
	public void showGameScreen() {
		
	}
	
	public void hideGameScreen() {
		m_game.m_ui.mainTextPanel.setVisible(false);
		m_game.m_ui.backpackPanel.setVisible(false);
		m_game.m_ui.backpackStatsPanel.setVisible(false);
		m_game.m_ui.backpackButtonPanel.setVisible(false);
		m_game.m_ui.choiceButtonPanel.setVisible(false);
		m_game.m_ui.sidePanel.setVisible(false);
		m_game.m_ui.imagePanel.setVisible(false);
		m_game.m_ui.playerPanel.setVisible(false);
		m_game.m_ui.counterPanel.setVisible(false);
	}
	
	public void showOptionsScreen() {
		m_game.m_ui.optionsPanel.setVisible(true);
		m_game.m_ui.optionsPanel2.setVisible(true);
		m_game.m_ui.optionsLabelPanel.setVisible(true);
		m_game.m_ui.backButtonPanel.setVisible(true);
	}
	
	public void hideOptionsScreen() {
		
		m_game.m_ui.optionsPanel.setVisible(false);
		m_game.m_ui.optionsPanel2.setVisible(false);
		m_game.m_ui.optionsLabelPanel.setVisible(false);
		m_game.m_ui.backButtonPanel.setVisible(false);
	}
	
	public void showCreditsScreen() {
		m_game.m_ui.creditsPanel.setVisible(true);
		m_game.m_ui.creditsPanel2.setVisible(true);
		m_game.m_ui.creditsTextAreaPanel.setVisible(true);
	}
	
	public void hideCreditsScreen() {
		m_game.m_ui.creditsPanel.setVisible(false);
		m_game.m_ui.creditsPanel2.setVisible(false);
		m_game.m_ui.creditsTextAreaPanel.setVisible(false);
	}
}