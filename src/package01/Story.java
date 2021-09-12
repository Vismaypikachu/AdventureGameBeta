package package01;

import package02.None;
import package03.Empty;
import package03.Potion;

public class Story {
	
	game m_game;
	UI m_ui;
	Constants m_constants = new Constants();
	Images m_images = new Images(m_ui);
	VisibilityManager vm;
	Player m_player = new Player();
	
	public Story(game g, UI userInterface, VisibilityManager vManager) {
		m_game = g;
		m_ui = userInterface;
		vm = vManager;
	}
	
public void gameover() {
		
		/*
		mainTextPanel.setVisible(false);
		playerPanel.setVisible(false);
		inventoryPanel.setVisible(false);
		choiceButtonPanel.setVisible(false);

		gameOverPanel = new JPanel();
		int gop_x = (int)Math.round(currentScreenWidth * 0.2196261682242991);
		int gop_y = (int)Math.round(currentScreenHeight * 0.1404494382022472);
		int gop_w = (int)Math.round(currentScreenWidth * 0.5607476635514019);
		int gop_h = (int)Math.round(currentScreenHeight * 0.2106741573033708);
		gameOverPanel.setBounds(gop_x, gop_y, gop_w, gop_h);
		gameOverPanel.setBackground(Color.green);
		gameOverPanel.setVisible(true);
		con.add(gameOverPanel);
		*/
		m_ui.statschange();
		if(position.equals("gameover")) {
			m_ui.choice1.setText("Main Menu");
			m_ui.choice2.setText("Exit Game");
			m_ui.mainTextArea.setText("Seems like you died... Oh well. Lets go back");
			m_ui.choice1.setVisible(true);
			m_ui.choice2.setVisible(true);
			m_ui.choiceButtonPanel.remove(m_ui.choice3);
			m_ui.choiceButtonPanel.remove(m_ui.choice4);
			m_ui.choiceButtonPanel.remove(m_ui.specialattack);
			m_ui.inventoryButton.setVisible(false);
			m_ui.inGameOptionsButton.setVisible(false);
			m_ui.inventoryPanel.setVisible(false);
			m_ui.inGameOptionsPanel.setVisible(false);
		}
		else {
			position = "gameoverStart";
			m_ui.choice1.setText("Continue");
			m_ui.choice2.setText("------");
			m_ui.choice3.setText("------");
			m_ui.choice4.setText("------");
		}
	}
	
	public void playerSetup() {		
		m_player.playerHP = 100;
		m_player.weapon = new None();
		m_ui.hpLabelNumber.setText("" + m_player.playerHP);
		m_ui.weaponLabelName.setText(m_player.weapon.name);
		m_ui.goldLabelNumber.setText(""+m_player.gold);
		m_ui.xpLabelNumber.setText(""+m_player.xp);
		m_constants.InventoryStatus = "close";
		m_constants.OptionsStatus = "close";
		m_constants.BackpackStatus = "close";
		m_ui.attackLabelNumber.setText("" + m_player.weapon.attackStat);
		m_ui.defenseLabelNumber.setText("" + m_player.playerdefense);
		m_ui.capsuleLabelNumber.setText("" + m_player.capsules);
		savedPosition = "";
		
		m_player.playerItem[0] = new Potion();
		
		for(int i = 1; i < 5; i++) {
			m_player.playerItem[i] = new Empty();
		}
		for(int i = 0; i < 15; i++) {
			m_player.backpackItem[i] = new Empty();
		}
		
		
		fork();

	}
	
	public void selectPosition(String nextPosition) {
		switch(nextPosition) {
			case "fork": fork(); break;
		}
	}
	
	public void fork() {
		m_images.setImage(m_constants.testImageURL);
		updateBackpack(1);
		if(m_player.playerHP <= 0) {
			gameover();
		}
		else {
			m_ui.mainTextArea.setText("You start out on a bright sunny day and think to yourself, lets go on an adventure. \n\nYou get out of your house and reach a fork in the road. \n\nYou can go left or right, which do you choose?");
			position = "fork";
			m_ui.choice1.setText("Left");
			m_ui.choice2.setText("Right");
			m_ui.choice3.setText("------");
			m_ui.choice4.setText("------");
			m_ui.specialattack.setText("------");
		}
	}
}
