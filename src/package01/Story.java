package package01;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import package02.None;
import package03.Empty;
import package03.Potion;

public class Story {
	
	game m_game;
	UI m_ui;
	Constants m_constants;;
	Images m_images = new Images(m_ui);
	VisibilityManager vm;
	Player m_player = new Player(m_ui, m_constants);
	Inventory m_inventory;
	Backpack m_backpack = new Backpack(m_game, m_constants, m_ui, m_inventory);
	Sound m_sound = new Sound(m_ui);
	
	public Story(game g, UI userInterface, VisibilityManager vManager, Constants c, Inventory i) {
		m_game = g;
		m_ui = userInterface;
		vm = vManager;
		m_constants = c;
		m_inventory = i;
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
		statschange();
		if(m_constants.position.equals("gameover")) {
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
			m_constants.position.equals("gameoverStart");
			m_ui.choice1.setText("Continue");
			m_ui.choice2.setText("------");
			m_ui.choice3.setText("------");
			m_ui.choice4.setText("------");
		}
	}
	
	public void statschange() {
		m_ui.hpLabelNumber.setText("" + m_player.playerHP);
		m_ui.goldLabelNumber.setText("" + m_player.gold);
		m_ui.xpLabelNumber.setText("" + m_player.xp);
		m_ui.weaponLabelName.setText(m_player.weapon.name);
		m_ui.attackLabelNumber.setText(""+ m_player.weapon.attackStat);
		m_ui.defenseLabelNumber.setText(""+ m_player.playerdefense);
		m_ui.capsuleLabelNumber.setText(""+ m_player.capsules);
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
		m_constants.savedPosition = "";
		
		m_player.playerItem[0] = new Potion();
		
		for(int i = 1; i < 5; i++) {
			m_player.playerItem[i] = new Empty();
		}
		for(int i = 0; i < 15; i++) {
			m_player.backpackItem[i] = new Empty();
		}
		
		
		fork();

	}
	
	public void positionCheck() {
		
		m_constants.currentEnemy.name = "Empty Air";
		m_constants.currentEnemy.enemyHP = 100;
		/*
		itemButton1.setText(itemButton1Text);
		itemButton2.setText(itemButton2Text);
		itemButton3.setText(itemButton3Text);
		itemButton4.setText(itemButton4Text);
		itemButton5.setText(itemButton5Text);
		*/
		m_ui.playerPanel.setLayout(new GridLayout(8,2));
		if(m_constants.specialUnlocked == true) m_ui.specialattack.setVisible(true);
		switch(m_constants.savedPosition) {
			//case "save1": m_ui.playerPanel.setLayout(new GridLayout(7,2)); innskeepwife(); break;
			//case "save2": plateauFork(); break;
		}
	}
	
	public void selectPosition(String nextPosition) {
		switch(nextPosition) {
			case "fork": playerSetup(); fork(); break;
		}
	}
	
	public void input() {
		m_constants.position = "input";
		m_ui.titleNamePanel.setVisible(false);
		m_ui.startButtonPanel.setVisible(false);
		
		m_ui.textPanel = new JPanel();
		int tp_x = (int)Math.round(m_constants.currentScreenHeight * 0.4);
		int tp_y = (int)Math.round(m_constants.currentScreenHeight * 0.4213483146067416);
		int tp_w = (int)Math.round(m_constants.currentScreenWidth * 0.50);
		int tp_h = (int)Math.round(m_constants.currentScreenHeight * 0.0842696629213483);
		m_ui.textPanel.setBounds(tp_x, tp_y, tp_w, tp_h);
		//textPanel.setBounds(270, 300, 550, 100);
		m_ui.textPanel.setBackground(Color.blue);
		m_ui.textLabel = new JLabel("Please enter your name: ");
		m_ui.textLabel.setForeground(Color.white);
		m_ui.textLabel.setFont(m_ui.normalFont);
		m_ui.textPanel.add(m_ui.textLabel, BorderLayout.CENTER);
		m_ui.con.add(m_ui.textPanel);
			
		
		m_ui.inputPanel = new JPanel();
		int ip_x = (int)Math.round(m_constants.currentScreenHeight * 0.4);
		int ip_y = (int)Math.round(m_constants.currentScreenHeight * 0.5617977528089888);
		int ip_w = (int)Math.round(m_constants.currentScreenWidth * 0.50);
		int ip_h = (int)Math.round(m_constants.currentScreenHeight * 0.0842696629213483);
		m_ui.inputPanel.setBounds(ip_x, ip_y, ip_w, ip_h);
		//inputPanel.setBounds(270, 400, 550, 60);
		m_ui.inputPanel.setBackground(Color.black);
		m_ui.inputPanel.setLayout(new GridLayout(1,2));
		
		m_ui.jtf = new JTextField();
		m_ui.jtf.setFont(m_ui.normalFont);
		m_ui.inputPanel.add(m_ui.jtf);
		m_ui.enterButton = new JButton("ENTER");
		int eb_y = ip_y + ip_h;
		m_ui.enterButton.setBounds(ip_x, eb_y, ip_w, ip_h);
		m_ui.enterButton.setBackground(Color.white);
		m_ui.enterButton.setForeground(Color.black);
		m_ui.enterButton.setFocusable(false);
		m_ui.enterButton.setBorder(m_constants.blackline);
		m_ui.enterButton.setFocusPainted(false);
		m_ui.enterButton.setFont(m_ui.normalFont);
		m_ui.enterButton.addActionListener(m_ui.inHandler);
		m_ui.inputPanel.add(m_ui.enterButton);
		m_ui.con.add(m_ui.inputPanel);
		
	}
	
	public void fork() {
		m_ui.setImage(m_constants.testImageURL);
		statschange();
		if(m_player.playerHP <= 0) {
			gameover();
		}
		else {
			m_ui.mainTextArea.setText("You start out on a bright sunny day and think to yourself, lets go on an adventure. \n\nYou get out of your house and reach a fork in the road. \n\nYou can go left or right, which do you choose?");
			m_constants.position = "fork";
			m_ui.choice1.setText("Left");
			m_ui.choice2.setText("Right");
			m_ui.choice3.setText("------");
			m_ui.choice4.setText("------");
			m_ui.specialattack.setText("------");
		}
	}
}
