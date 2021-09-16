package package01;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import package02.None;
import package02.Sword;
import package02.Wand;
import package03.Empty;
import package03.Fork;
import package03.Potion;
import package05.Guard;

public class Story {
	/*
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
	*/
	
	game m_game;
	
	public Story(game g) {
		m_game = g;
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
		if(m_game.m_constants.position.equals("gameover")) {
			m_game.m_ui.choice1.setText("Main Menu");
			m_game.m_ui.choice2.setText("Exit Game");
			m_game.m_ui.mainTextArea.setText("Seems like you died... Oh well. Lets go back");
			m_game.m_ui.choice1.setVisible(true);
			m_game.m_ui.choice2.setVisible(true);
			m_game.m_ui.choiceButtonPanel.remove(m_game.m_ui.choice3);
			m_game.m_ui.choiceButtonPanel.remove(m_game.m_ui.choice4);
			m_game.m_ui.choiceButtonPanel.remove(m_game.m_ui.specialattack);
			m_game.m_ui.inventoryButton.setVisible(false);
			m_game.m_ui.inGameOptionsButton.setVisible(false);
			m_game.m_ui.sidePanel.setVisible(false);
			m_game.m_ui.sidePanel.setVisible(false);
		}
		else {
			m_game.m_constants.position.equals("gameoverStart");
			m_game.m_ui.choice1.setText("Continue");
			m_game.m_ui.choice2.setText("------");
			m_game.m_ui.choice3.setText("------");
			m_game.m_ui.choice4.setText("------");
		}
	}
	
	public void statschange() {
		m_game.m_ui.hpLabelNumber.setText("" + m_game.m_player.playerHP);
		m_game.m_ui.goldLabelNumber.setText("" + m_game.m_player.gold);
		m_game.m_ui.xpLabelNumber.setText("" + m_game.m_player.xp);
		m_game.m_ui.weaponLabelName.setText(m_game.m_player.weapon.name);
		m_game.m_ui.attackLabelNumber.setText(""+ m_game.m_player.weapon.attackStat);
		m_game.m_ui.defenseLabelNumber.setText(""+ m_game.m_player.playerdefense);
		m_game.m_ui.capsuleLabelNumber.setText(""+ m_game.m_player.capsules);
	}
	
	public void playerSetup() {	
		m_game.m_player.playerHP = 100;
		m_game.m_player.weapon = new None();
		m_game.m_ui.hpLabelNumber.setText("" + m_game.m_player.playerHP);
		m_game.m_ui.weaponLabelName.setText(m_game.m_player.weapon.name);
		m_game.m_ui.goldLabelNumber.setText(""+m_game.m_player.gold);
		m_game.m_ui.xpLabelNumber.setText(""+m_game.m_player.xp);
		m_game.m_constants.InventoryStatus = "close";
		m_game.m_constants.OptionsStatus = "close";
		m_game.m_constants.BackpackStatus = "close";
		m_game.m_ui.attackLabelNumber.setText("" + m_game.m_player.weapon.attackStat);
		m_game.m_ui.defenseLabelNumber.setText("" + m_game.m_player.playerdefense);
		m_game.m_ui.capsuleLabelNumber.setText("" + m_game.m_player.capsules);
		m_game.m_constants.savedPosition = "";
		
		m_game.m_player.playerItem[0] = new Potion();
		
		for(int i = 1; i < 5; i++) {
			m_game.m_player.playerItem[i] = new Empty();
		}
		for(int i = 0; i < 15; i++) {
			m_game.m_player.backpackItem[i] = new Empty();
		}
		
		
		fork();

	}
	
	public void positionCheck() {
		
		m_game.m_constants.currentEnemy.name = "Empty Air";
		m_game.m_constants.currentEnemy.enemyHP = 100;
		/*
		itemButton1.setText(itemButton1Text);
		itemButton2.setText(itemButton2Text);
		itemButton3.setText(itemButton3Text);
		itemButton4.setText(itemButton4Text);
		itemButton5.setText(itemButton5Text);
		*/
		m_game.m_ui.playerPanel.setLayout(new GridLayout(8,2));
		if(m_game.m_constants.specialUnlocked == true) m_game.m_ui.specialattack.setVisible(true);
		switch(m_game.m_constants.savedPosition) {
			//case "save1": m_ui.playerPanel.setLayout(new GridLayout(7,2)); innskeepwife(); break;
			//case "save2": plateauFork(); break;
		}
	}
	
	public void setNextPosition(String a, String b, String c, String d) {
		m_game.nextPosition1 = a;
		m_game.nextPosition2 = b;
		m_game.nextPosition3 = c;
		m_game.nextPosition4 = d;
	}
	
	public void setChoices(String a, String b, String c, String d) {
		if(a.equals("")) a = "------";
		if(b.equals("")) b = "------";
		if(c.equals("")) c = "------";
		if(d.equals("")) d = "------";
		m_game.m_ui.choice1.setText(a);
		m_game.m_ui.choice2.setText(b);
		m_game.m_ui.choice3.setText(c);
		m_game.m_ui.choice4.setText(d);
	}
	
	public void selectPosition(String nextPosition) {
		switch(nextPosition) {
			case "battlewon":
				switch(m_game.m_constants.enemyPosition) {
					case "practice": inn(); break;
				}
			break;
			case "playerattack": m_game.m_battle.playerattack(); break;
			case "enemyattack": m_game.m_battle.enemyattack(); break;
			case "fork": playerSetup(); fork(); break;
			case "leftone": leftone(); break;
			case "rightone": rightone(); break;
			case "leftright": leftright(); break;
			case "leftleft": leftleft(); break;
			case "rightleft": rightleft(); break;
			case "rightright": rightright(); break;
			case "monster": monster(); break;
			case "monsteryes": monsteryes(); break;
			case "monsterno": monsterno(); break;
			case "town": town(); break;
			case "wizard": wizard(); break;
			case "blacksmith": blacksmith(); break;
			case "guard": m_game.m_constants.enemyPosition = "practice"; m_game.m_constants.currentEnemy = new Guard(); m_game.m_battle.enemyattack(); break;
			case "": break;
		}
	}
	
	public void input() {
		m_game.m_constants.position = "input";
		m_game.m_ui.titleNamePanel.setVisible(false);
		m_game.m_ui.startButtonPanel.setVisible(false);
		
		m_game.m_ui.textPanel = new JPanel();
		int tp_x = (int)Math.round(m_game.m_constants.currentScreenHeight * 0.4);
		int tp_y = (int)Math.round(m_game.m_constants.currentScreenHeight * 0.4213483146067416);
		int tp_w = (int)Math.round(m_game.m_constants.currentScreenWidth * 0.50);
		int tp_h = (int)Math.round(m_game.m_constants.currentScreenHeight * 0.0842696629213483);
		m_game.m_ui.textPanel.setBounds(tp_x, tp_y, tp_w, tp_h);
		//textPanel.setBounds(270, 300, 550, 100);
		m_game.m_ui.textPanel.setBackground(Color.blue);
		m_game.m_ui.textLabel = new JLabel("Please enter your name: ");
		m_game.m_ui.textLabel.setForeground(Color.white);
		m_game.m_ui.textLabel.setFont(m_game.m_ui.normalFont);
		m_game.m_ui.textPanel.add(m_game.m_ui.textLabel, BorderLayout.CENTER);
		m_game.m_ui.con.add(m_game.m_ui.textPanel);
			
		
		m_game.m_ui.inputPanel = new JPanel();
		int ip_x = (int)Math.round(m_game.m_constants.currentScreenHeight * 0.4);
		int ip_y = (int)Math.round(m_game.m_constants.currentScreenHeight * 0.5617977528089888);
		int ip_w = (int)Math.round(m_game.m_constants.currentScreenWidth * 0.50);
		int ip_h = (int)Math.round(m_game.m_constants.currentScreenHeight * 0.0842696629213483);
		m_game.m_ui.inputPanel.setBounds(ip_x, ip_y, ip_w, ip_h);
		//inputPanel.setBounds(270, 400, 550, 60);
		m_game.m_ui.inputPanel.setBackground(Color.black);
		m_game.m_ui.inputPanel.setLayout(new GridLayout(1,2));
		
		m_game.m_ui.jtf = new JTextField();
		m_game.m_ui.jtf.setFont(m_game.m_ui.normalFont);
		m_game.m_ui.inputPanel.add(m_game.m_ui.jtf);
		m_game.m_ui.enterButton = new JButton("ENTER");
		int eb_y = ip_y + ip_h;
		m_game.m_ui.enterButton.setBounds(ip_x, eb_y, ip_w, ip_h);
		m_game.m_ui.enterButton.setBackground(Color.white);
		m_game.m_ui.enterButton.setForeground(Color.black);
		m_game.m_ui.enterButton.setFocusable(false);
		m_game.m_ui.enterButton.setBorder(m_game.m_constants.blackline);
		m_game.m_ui.enterButton.setFocusPainted(false);
		m_game.m_ui.enterButton.setFont(m_game.m_ui.normalFont);
		m_game.m_ui.enterButton.addActionListener(m_game.m_inHandler);
		m_game.m_ui.inputPanel.add(m_game.m_ui.enterButton);
		m_game.m_ui.con.add(m_game.m_ui.inputPanel);
		
	}
	
	public void fork() {
		m_game.m_ui.setImage(m_game.m_constants.testImageURL);
		statschange();
		if(m_game.m_player.playerHP <= 0) {
			gameover();
		}
		else {
			m_game.m_ui.mainTextArea.setText("You start out on a bright sunny day and think to yourself, lets go on an adventure. \n\nYou get out of your house and reach a fork in the road. \n\nYou can go left or right, which do you choose?");
			m_game.m_constants.position = "fork";
			/*
			m_game.m_ui.choice1.setText("Left");
			m_game.m_ui.choice2.setText("Right");
			m_game.m_ui.choice3.setText("------");
			m_game.m_ui.choice4.setText("------");
			m_game.m_ui.specialattack.setText("------");
			*/
			
			setChoices("Left", "Right", "", "");
			setNextPosition("leftone", "rightone", "", "");
		}
	}
	
	public void leftone() {
		m_game.m_constants.position = "leftone";
		m_game.m_ui.mainTextArea.setText("You picked up the fork. Fork added to inventory! \n\nYou chose the left path, you can now go left or right \n\nWhat do you choose?");
		
		setChoices("Left", "Right", "", "");
		setNextPosition("leftleft", "leftright", "", "");
		
		m_game.m_inventory.addInventoryItem(new Fork());
	}
	
	public void rightone() {
		m_game.m_constants.position = "rightone";
		m_game.m_ui.mainTextArea.setText("You picked up the fork. Fork added to inventory! \n\nYou chose the right path, you can now go left or right \n\nWhat do you choose?");
		
		setChoices("Left", "Right", "", "");	
		setNextPosition("rightleft", "rightright", "", "");
		
		m_game.m_inventory.addInventoryItem(new Fork());
	}
	
	public void leftleft() {
		m_game.m_constants.position = "leftleft";
		m_game.m_ui.mainTextArea.setText("You chose the left then left path, lets continue!");
		
		setChoices("Continue", "", "", "");
		setNextPosition("town", "", "", "");
	}
	
	public void leftright() {
		m_game.m_constants.position = "leftright";
		m_game.m_ui.mainTextArea.setText("You chose the left then right path, lets continue!");
		m_game.m_ui.choice1.setText("Continue");
		m_game.m_ui.choice2.setText("------");
		m_game.m_ui.choice3.setText("------");
		m_game.m_ui.choice4.setText("------");
		
		setNextPosition("monster", "", "", "");
	}
	
	public void rightleft() {
		m_game.m_constants.position = "rightleft";
		m_game.m_ui.mainTextArea.setText("You chose the right then left path, lets continue!");
		m_game.m_ui.choice1.setText("Continue!");
		m_game.m_ui.choice2.setText("------");
		m_game.m_ui.choice3.setText("------");
		m_game.m_ui.choice4.setText("------");
		
		setNextPosition("town", "", "", "");
	}
	
	public void rightright() {
		m_game.m_constants.position = "rightright";
		m_game.m_ui.mainTextArea.setText("You chose the right then right path, lets continue!");
		m_game.m_ui.choice1.setText("Continue!");
		m_game.m_ui.choice2.setText("------");
		m_game.m_ui.choice3.setText("------");
		m_game.m_ui.choice4.setText("------");
		
		setNextPosition("town", "", "", "");
	}
	
	public void monster() {
		m_game.m_constants.position = "monster";
		m_game.m_ui.mainTextArea.setText("You see a monster in the middle of the road. Use the fork on him?");
		

		setChoices("Yes", "No", "", "");		
		setNextPosition("monsteryes", "monsterno", "", "");
	}
	
	public void monsteryes() {
		m_game.m_constants.position = "monsteryes";
		if(m_game.m_constants.forkUsed == true) {
			m_game.m_ui.mainTextArea.setText("You didn't have a fork to use on the monster. You go around the monster slowly.");
		}
		else if(m_game.m_constants.forkUsed == false) {
			m_game.m_ui.mainTextArea.setText("You give the fork to the monster, he is happy. He moves out of the way. \n\n You have gained 100 xp and 50 gold!!!");
			m_game.m_player.xp += 100;
			m_game.m_player.gold += 50;
			m_game.m_player.playerItem[1] = new Empty();
			statschange();
		}
		
		setChoices("Continue", "", "", "");
		setNextPosition("town", "", "", "");
	}
	
	public void monsterno() {
		m_game.m_constants.position = "monsterno";
		m_game.m_ui.mainTextArea.setText("You go around the monster slowly.");
		
		setChoices("Continue", "", "", "");
		setNextPosition("town", "", "", "");
	}
	
	public void town() {
		m_game.m_constants.position = "town";
		m_game.m_ui.mainTextArea.setText("You head into town. \n\nWhere do you want to go? \nBlacksmith or Wizard?");

		setChoices("Blacksmith", "Wizard", "", "");
		setNextPosition("blacksmith", "wizard", "", "");
	}
	
	public void blacksmith() {
		m_game.m_constants.position = "blacksmith";
		m_game.m_ui.mainTextArea.setText("You went to the Blacksmith and recieved a Sword!\n\nWeapon changed to Sword!\n\nLets have a practice battle!");
		m_game.m_player.weapon = new Sword();
		m_game.m_player.playerType = "Physical";
		statschange();
		
		setChoices("Continue", "", "", "");
		setNextPosition("guard", "", "", "");
	}
	
	public void wizard() {
		m_game.m_constants.position = "wizard";
		m_game.m_ui.mainTextArea.setText("You went to the Wizard and recieved a Wand!\n\nWeapon changed to Wand!\n\nLets have a practice battle!");
		m_game.m_player.weapon = new Wand();
		m_game.m_player.playerType = "Magical";
		statschange();
		
		setChoices("Continue", "", "", "");
		setNextPosition("guard", "", "", "");
	}

	public void inn() {
		m_game.m_constants.position = "inn";
		m_game.m_ui.mainTextArea.setText("You continue on past the village and reach a rest stop just as night falls. \n\nYou can restore health in an inn or out in the open.\n\nCosts 15 gold");
		
		setChoices("Inside", "Outside", "", "");
	}
}
