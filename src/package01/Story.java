package package01;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

import package02.None;
import package02.SuperWeapon;
import package02.Sword;
import package02.Wand;
import package03.Apple;
import package03.ChocolateBar;
import package03.Empty;
import package03.Fork;
import package03.Potion;
import package05.Bandit;
import package05.EmptyAir;
import package05.Goblin;
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
	Random r = new Random();
	
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
		//if(m_game.m_constants.position.equals("gameover")) {
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
		//}
		//else {
			m_game.m_constants.position.equals("gameoverStart");
			setChoices("Continue", "", "", "");
			setNextPosition("gomenu", "", "", "");
		//}
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
		
		m_game.m_constants.currentEnemy = new EmptyAir();
		/*
		itemButton1.setText(itemButton1Text);
		itemButton2.setText(itemButton2Text);
		itemButton3.setText(itemButton3Text);
		itemButton4.setText(itemButton4Text);
		itemButton5.setText(itemButton5Text);
		*/
		m_game.m_ui.playerPanel.setLayout(new GridLayout(8,2));
		if(m_game.m_player.specialUnlocked == true) m_game.m_ui.specialattack.setVisible(true);
		switch(m_game.m_constants.savedPosition) {
			case "save1": m_game.m_ui.playerPanel.setLayout(new GridLayout(7,2)); innskeepwife(); break;
			case "save2": plateauFork(); break;
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
			case "gomenu": 
				if(m_game.m_constants.fullScreenOn == false) {
					m_game.m_ui.createUIComponent(); break;
				}
				else {
					m_game.m_ui.createUIComponent(); m_game.m_ui.setFullScreen(); break;
				}
			case "battlewon":
				switch(m_game.m_constants.enemyPosition) {
					case "practice": inn(); break;
					case "farmer": farmerweaponask(); break; 
					case "plateau": plateauFork(); break;
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
			case "insideinn": inninside(); break;
			case "outsideinn": innoutside(); break;
			case "innskeep": innskeep(); break;
			case "innskeepwife": innskeepwife(); break;
			case "outsideresult": outsideresult(); break;
			case "crosschoice": crosschoice(); break;
			case "bridge": bridge(); break;
			case "canyon": canyon(); break;
			case "store": store(); break;
			case "store1": checkgold(50, "Extra Health"); break;
			case "store2": checkgold(105, "Shield"); break;
			case "store3": checkgold(90, "XP Bottle"); break;
			case "farmer": farmer(); break;
			case "farmer2": farmer2(); break;
			case "farmerbattle": m_game.m_constants.enemyPosition = "farmer"; m_game.m_constants.currentEnemy = new Bandit(); m_game.m_battle.enemyattack(); break;
			case "farmerbetrayalno": farmerbetrayal(true); break;
			case "farmerbetrayalyes": farmerbetrayal(false); break;
			case "greatplains": greatplains(); break;
			case "theplateau": theplateau(); break;
			case "oldman": oldman(); break;
			case "oldman2": oldman2(); break;
			case "oldman3": oldman3(); break;
			case "oldman4": oldman4(); break;
			case "oldman5": oldman5(); break;
			case "oldman6": oldman6(); break;
			case "plateaufork": plateauFork(); break;
			case "plateaunorth": plateauNorth(); break;
			case "plateauwest": plateauWest(); break;
			case "plateaueast": plateauEast(); break;
			case "plateausouth": plateauSouth(); break;
			case "plateaubattle": m_game.m_constants.enemyPosition = "plateau"; m_game.m_constants.currentEnemy = new Goblin(); m_game.m_battle.enemyattack(); break; 
			case "bisonStampede": bisonStampede(); break;
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
	
	public void saveData() {
		m_game.m_ui.sidePanel.setVisible(false);
		m_game.m_constants.OptionsStatus = "close";
		m_game.m_constants.BackpackStatus = "close";
		m_game.m_constants.InventoryStatus = "close";
		//inventory
		/*
		inventoryPanel.setVisible(true);
		for(int i = 0; i < 5; i++) {
			inventoryButtons[i].setVisible(true);
		}
		*/
		String x = m_game.m_player.playerItem[0].name;
		String x2 = m_game.m_player.playerItem[1].name;
		String x3 = m_game.m_player.playerItem[2].name;
		String x4 = m_game.m_player.playerItem[3].name;
		String x5 = m_game.m_player.playerItem[4].name;
		
		String x6 = m_game.m_player.backpackItem[0].name;
		String x7 = m_game.m_player.backpackItem[1].name;
		String x8 = m_game.m_player.backpackItem[2].name;
		String x9 = m_game.m_player.backpackItem[3].name;
		String x10 = m_game.m_player.backpackItem[4].name;
		String x11 = m_game.m_player.backpackItem[5].name;
		String x12 = m_game.m_player.backpackItem[6].name;
		String x13 = m_game.m_player.backpackItem[7].name;
		String x14 = m_game.m_player.backpackItem[8].name;
		String x15 = m_game.m_player.backpackItem[9].name;
		String x16 = m_game.m_player.backpackItem[10].name;
		String x17 = m_game.m_player.backpackItem[11].name;
		String x18 = m_game.m_player.backpackItem[12].name;
		String x19 = m_game.m_player.backpackItem[13].name;
		String x20 = m_game.m_player.backpackItem[14].name;
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("saveFile.txt"));
			
			
			bw.write(""+m_game.m_constants.savedPosition);
			bw.newLine();
			bw.write(""+m_game.m_constants.musicOn);
			bw.newLine();
			bw.write(m_game.m_player.playerName);
			bw.newLine();
			bw.write(""+m_game.m_player.playerHP);
			bw.newLine();
			bw.write(m_game.m_player.weapon.name);
			bw.newLine();
			bw.write(m_game.m_player.playerType);
			bw.newLine();
			bw.write(""+m_game.m_player.gold);
			bw.newLine();
			bw.write(""+m_game.m_player.xp);
			bw.newLine();
			bw.write(""+m_game.m_player.capsules);
			bw.newLine();
			bw.write(""+m_game.m_player.playerdefense);	
			bw.newLine();
			bw.write(x);
			bw.newLine();
			bw.write(x2);
			bw.newLine();
			bw.write(x3);
			bw.newLine();
			bw.write(x4);
			bw.newLine();
			bw.write(x5);
			bw.newLine();
			bw.write(x6);
			bw.newLine();
			bw.write(x7);
			bw.newLine();
			bw.write(x8);
			bw.newLine();
			bw.write(x9);
			bw.newLine();
			bw.write(x10);
			bw.newLine();
			bw.write(x11);
			bw.newLine();
			bw.write(x12);
			bw.newLine();
			bw.write(x13);
			bw.newLine();
			bw.write(x14);
			bw.newLine();
			bw.write(x15);
			bw.newLine();
			bw.write(x16);
			bw.newLine();
			bw.write(x17);
			bw.newLine();
			bw.write(x18);
			bw.newLine();
			bw.write(x19);
			bw.newLine();
			bw.write(x20);
			/*
			for(int i = 0; i < 5; i++) {
				bw.write(""+playerItem[i].name);
				bw.newLine();
			}
			for(int j = 0; j < 14; j++) {
				bw.write(""+backpackItem[j].name);
				bw.newLine();
			}
			bw.write(""+backpackItem[15].name);
			*/
			bw.newLine();
			bw.write(""+m_game.m_player.specialUnlocked);
			
			
			bw.close();
			
		}
		catch(Exception e){
			
		}
	}
	
	public void loadData() {
		m_game.m_constants.position = "loadData";
		m_game.m_constants.InventoryStatus = "open";
		m_game.m_constants.OptionsStatus = "close";
		m_game.m_constants.BackpackStatus = "close";
		

		try {
			BufferedReader br = new BufferedReader(new FileReader("saveFile.txt"));
			
			m_game.m_constants.savedPosition = br.readLine();
			m_game.m_constants.musicOn = Boolean.parseBoolean(br.readLine());
			m_game.m_player.playerName = br.readLine();
			m_game.m_player.playerHP = Integer.parseInt(br.readLine());
			setWeapon(br.readLine());
			m_game.m_player.playerType = br.readLine();
			m_game.m_player.gold = Integer.parseInt(br.readLine());
			m_game.m_player.xp = Integer.parseInt(br.readLine());
			m_game.m_player.capsules = Integer.parseInt(br.readLine());
			m_game.m_player.playerdefense = Double.parseDouble(br.readLine());
			//------------------
		
			for(int j = 0; j < 5; j++) {
				setItem(br.readLine(), j, 1);
			}
			for(int i = 0; i < 15; i++) {
				setItem(br.readLine(), i, 2);
			}
			
			//-----------------------------------
			m_game.m_player.specialUnlocked = Boolean.parseBoolean(br.readLine());
			
			
			m_game.m_constants.currentEnemy = new EmptyAir();

			
			/*
			stringToClass(br.readLine(), 0);
			stringToClass(br.readLine(), 1);
			stringToClass(br.readLine(), 2);
			stringToClass(br.readLine(), 3);
			stringToClass(br.readLine(), 4);
			 */
			br.close();
			
		}
		catch(Exception e){
			
		}
		if(m_game.m_player.playerHP == 0) {
			m_game.m_constants.position = "noLoad";
		}
		/*
		for(int i = 0; i < 5; i++) {
			setItem(m_game.m_player.playerItem[i].name, i, 1);
		}
		for(int i = 0; i < 15; i++) {
			setItem(m_game.m_player.backpackItem[i].name, i, 2);
		}
		*/
		m_game.m_ui.createGameScreen();
	}
	
	public void setWeapon(String w) {
		switch(w) {
			case "None": m_game.m_player.weapon = new None(); break;
			case "Sword": m_game.m_player.weapon = new Sword(); break;
			case "Wand": m_game.m_player.weapon = new Wand(); break;
		}
	}
	
	public void setItem(String name, int i, int num) {
		if(num == 1) {
			switch(name) {
				case "[Empty]": m_game.m_player.playerItem[i] = new Empty(); break;
				case "Fork": m_game.m_player.playerItem[i] = new Fork(); break;
				case "Potion": m_game.m_player.playerItem[i] = new Potion(); break;
				case "C. Bar": m_game.m_player.playerItem[i] = new ChocolateBar(); break;
				case "Apple": m_game.m_player.playerItem[i] = new Apple(); break;
			}
		}
		else {
			switch(name) {
				case "[Empty]": m_game.m_player.backpackItem[i] = new Empty(); break;
				case "Fork": m_game.m_player.backpackItem[i] = new Fork(); break;
				case "Potion": m_game.m_player.backpackItem[i] = new Potion(); break;
				case "C. Bar": m_game.m_player.backpackItem[i] = new ChocolateBar(); break;
				case "Apple": m_game.m_player.backpackItem[i] = new Apple(); break;
			}
		}
		
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
		setNextPosition("insideinn", "outsideinn", "", "");
	}
	
	public void inninside() {
		if(m_game.m_constants.position.equals("innskeep") || m_game.m_constants.position.equals("innskeepwife")) {
			m_game.m_constants.position = "inninside";
			m_game.m_ui.mainTextArea.setText("You have decided to go get a room for the night.\n\n Health is restored.\n\nLooking forward for more adventure!");
			if(m_game.m_player.playerHP < 100) m_game.m_player.playerHP = 100;
			statschange();
			
			setChoices("Continue", "Talk to the Innskeep", "Talk to Innskeep's Wife", "");
			setNextPosition("crosschoice", "innskeep", "innskeepwife", "");
			
		}
		if(m_game.m_player.gold>=15 && m_game.m_constants.position.equals("inn")) {
			m_game.m_sound.setMusic(m_game.m_constants.innTrackURL);
			m_game.m_constants.position = "inninside";
			m_game.m_player.gold -= 15;
			m_game.m_ui.mainTextArea.setText("You have decided to go get a room for the night.\n\nYou wake up the next day. Health is restored.\n\nLooking forward for more adventure!");
			m_game.m_player.playerHP = 100;
			statschange();
			
			setChoices("Continue", "Talk to the Innskeep", "Talk to Innskeep's Wife", "");
			setNextPosition("crosschoice", "innskeep", "innskeepwife", "");
		}
		else if(m_game.m_player.gold < 15 && m_game.m_constants.position.equals("inn")){
			m_game.m_constants.position = "failedinn";
			innoutside();
		}		
	}
	
	public void innskeep() {
		m_game.m_sound.setMusic(m_game.m_constants.innTrackURL);
		m_game.m_constants.position = "innskeep";
		int slotNumber = 0;
		while(!m_game.m_player.playerItem[slotNumber].name.equals("[Empty]") && slotNumber < 4) slotNumber++;
		
			if(m_game.m_constants.timesGiven < 10) {
				m_game.m_ui.mainTextArea.setText("Innskeep: Hello! You seem very nice. Please, take a chocolate bar.\n\n(You recieved a Chocolate Bar)");
				m_game.m_inventory.addInventoryItem(new ChocolateBar());
				m_game.m_constants.timesGiven++;
			}
			else if(m_game.m_constants.timesGiven == 10){
				String currentText = m_game.m_ui.mainTextArea.getText();
				m_game.m_ui.mainTextArea.setText(currentText + "\nYou found an Easter Egg!\n\nYou recieved 50 Gold and 100 XP!");
				m_game.m_player.gold += 50;
				m_game.m_player.xp += 100;
				statschange();
				m_game.m_constants.timesGiven++;
			}	
			else if(m_game.m_constants.timesGiven >= 11) {
				m_game.m_ui.mainTextArea.setText("Innskeep: I am sorry... I am out of chocolate bars.");
			}

		setChoices("Continue", "", "", "");
		setNextPosition("insideinn", "", "", "");
	}
	
	public void innskeepwife() {
		m_game.m_sound.setMusic(m_game.m_constants.innTrackURL);
		m_game.m_ui.mainTextArea.setText("Innskeep's Wife: Hello, I am a save NPC. Don't talk to me. Just let me save the game for you.\n\n(Your progress has been saved)");
	

		setChoices("Continue", "", "", "");		
		setNextPosition("insideinn", "", "", "");
		
		if(m_game.m_constants.savedPosition.equals("save1")) {
			m_game.m_constants.position = "innskeepwife";
		}
		else {
			m_game.m_constants.position = "innskeepwife";
			m_game.m_constants.savedPosition = "save1";
			saveData();
		}
		
		statschange();
	}
	
	public void innoutside() {
		if(m_game.m_constants.position.equals("failedinn")) {
			m_game.m_ui.mainTextArea.setText("You didn't have enough gold!\nOkay, sleeping out in the open \nThis is not generally the best idea, bandits can rob you. \nBut you don't have to pay to restore health.\n\nYou go to sleep and wake up to find...");
			m_game.m_constants.position = "innoutside";
		}
		else {
			m_game.m_constants.position = "innoutside";
			m_game.m_ui.mainTextArea.setText("Okay, sleeping out in the open \nThis is not generally the best idea, bandits can rob you. \nBut you don't have to pay to restore health.\n\nYou go to sleep and wake up to find...");
		}
		if(m_game.m_player.playerHP < 100) {
			m_game.m_player.playerHP = 100;
		}
		statschange();
		
		setChoices("Continue", "", "", "");
		setNextPosition("outsideresult", "", "", "");
	}
	
	public void outsideresult() {
		m_game.m_constants.position = "outsideresult";
		int rob = r.nextInt((100 - 1) + 1) + 1;
		if (rob % 2 == 1) {
			int moneyrobbed = r.nextInt((40 - 10) + 1) + 3;
			m_game.m_ui.mainTextArea.setText("You got robbed of " + moneyrobbed + " gold! \n\nBetter have stayed in the inn...");
			m_game.m_player.gold -= moneyrobbed;
			statschange();
		}
		if (rob % 2 == 0) {
			int moneyrobbed = r.nextInt((40 - 10) + 1) + 10;
			m_game.m_ui.mainTextArea.setText("You were lucky this time, no one robbed you. In fact, you find " + moneyrobbed + " gold in a nearby well.");
			m_game.m_player.gold += moneyrobbed;
			statschange();
		}
		
		setChoices("Continue", "", "", "");
		setNextPosition("crosschoice", "", "", "");
	}
	
	public void crosschoice() {
		m_game.m_sound.stop();
		m_game.m_constants.position = "crosschoice";
		m_game.m_ui.mainTextArea.setText("Feeling refreshed, you continue onward through a craggy pass, you have two choices\n\nGo over a flimsy rope bridge or through a rocky canyon with a possibility of sudden avalanches\n\nWhat do you choose?");
		
		setChoices("Bridge", "Canyon", "", "");
		setNextPosition("bridge", "canyon", "", "");
	}
	
	public void bridge() {
		m_game.m_constants.position = "bridge";
		int bridgedeath = r.nextInt((10 - 1) + 1) + 1;
		m_game.m_ui.mainTextArea.setText("You continue to the bridge and then...");
		if (bridgedeath % 2 == 1) {
			m_game.m_player.playerHP -= 50;
			statschange();
			m_game.m_ui.mainTextArea.setText("You continue to the bridge and then...\n\nYou slip and fall, 50 HP is subtracted.\n\nLets continue");
		}
		if (bridgedeath % 2 == 0) {
			m_game.m_ui.mainTextArea.setText("You continue to the bridge and then...\n\nYou passed the bridge without falling, congrats.\n\nLets continue");
		}
		
		setChoices("Continue", "", "", "");
		setNextPosition("store", "", "", "");
	}
	
	public void canyon() {
		m_game.m_constants.position = "canyon";	
		int canyondeath = r.nextInt((10 - 1) + 1) + 1;
		m_game.m_ui.mainTextArea.setText("You continue to the canyon and then...");
		if (canyondeath % 2 == 1) {
			m_game.m_player.playerHP -= 50;
			statschange();
			m_game.m_ui.mainTextArea.setText("You continue to the canyon and then...\n\nRocks start falling. AVALANCHE!!!, 50 HP is subtracted.\n\nLets continue");
			
		}
		if (canyondeath % 2 == 0) {
			m_game.m_ui.mainTextArea.setText("You continue to the canyon and then...\n\nYou passed the canyon without an avalanche starting, congrats.\n\nLets continue");
		}
		
		setChoices("Continue", "", "", "");
		setNextPosition("store", "", "", "");
	}
	
	public void storeask() {
		m_game.m_constants.position = "storeask";
		m_game.m_ui.mainTextArea.setText("You reach a small store.\n\nWhat do you do?");
		
		setChoices("Go Inside", "Continue Onward", "", "");
		setNextPosition("store", "farmer", "", "");
	}
	
	public void store() {
		if(m_game.m_constants.position.equals("failbuy")) {
			m_game.m_ui.mainTextArea.setText("You do not have enough gold, please try again.\n\nYou reach a small store.\nThey have the following items to buy:\n100 Extra Health (50 Gold)\nShield (105 Gold)\n100 XP Bottle (115 Gold)");
			m_game.m_constants.position = "store";
			
			setChoices("Buy Extra Health", "Buy Shield", "Buy XP Bottle", "Exit Store");
			setNextPosition("store1", "store2", "store3", "farmer");
		}
		else {
			m_game.m_constants.position = "store";
			m_game.m_ui.mainTextArea.setText("You reach a small store.\nThey have the following items to buy:\n\n100 Extra Health (50 Gold)\nShield (105 Gold)\n100 XP Bottle (115 Gold)");
			
			setChoices("Buy Extra Health", "Buy Shield", "Buy XP Bottle", "Exit Store");
			setNextPosition("store1", "store2", "store3", "farmer");
		}
	}
	
	public void checkgold(int goldprice, String itembuy) {
		if(m_game.m_player.gold >= goldprice) {
			m_game.m_constants.position = "checkgold";
			m_game.m_player.gold -= goldprice;
			m_game.m_ui.mainTextArea.setText("You bought " + itembuy + ". What now?");
			
			setChoices("Go Back to Store", "Continue Onward", "", "");
			setNextPosition("store", "farmer", "", "");
			
			if(itembuy.equals("Extra Health")) {
				m_game.m_player.playerHP += 100;
				statschange();
			}
			if(itembuy.equals("Shield")) {
				m_game.m_player.playerdefense = 1.2;
				statschange();
			}
			if(itembuy.equals("XP Bottle")) {
				m_game.m_player.xp += 100;
				statschange();
			}
		}
		else {
			notenoughgold();
		}
	}
	
	public void notenoughgold() {
		if(m_game.m_constants.position.equals("store")) {
			m_game.m_constants.position = "failbuy";
			store();
		}
	}

	public void farmer() {
		m_game.m_constants.position = "farmer";
		m_game.m_ui.mainTextArea.setText("Having continued on your journey, you reach a small pasture. \nYou find a farm, with a farmer sitting on a chair. \nNoticing your " + m_game.m_player.weapon.name + " he asks you for help.");
		
		
		setChoices("Continue", "", "", "");
		setNextPosition("farmer2", "", "", "");
	}
	
	public void farmer2() {
		m_game.m_constants.position = "farmer2";
		m_game.m_constants.enemyPosition = "farmer";
		m_game.m_ui.mainTextArea.setText("Farmer: Could you please scare off the bandits attacking my farm, I will show you a secret treasure cave.\nFeeling confident in your abilities, you proceed to fight the bandits.");
		
		setChoices("Attack", "", "", "");
		setNextPosition("farmerbattle", "", "", "");
	}
	
	public void farmerweaponask() {
		m_game.m_constants.position = "farmerweaponask";
		m_game.m_ui.mainTextArea.setText("After finishing off the last bandit, you go back to the farmer.\n\nWhat do you do?");
		
		setChoices("Keep " + m_game.m_player.weapon.name + " Out", "Put " + m_game.m_player.weapon.name + " Away", "", "");
		setNextPosition("farmerbetrayalno", "farmerbetrayalyes", "", "");
	
	}
	
	public void farmerbetrayal(boolean weaponout) {
		if(weaponout == true) {
			m_game.m_constants.position = "nobetrayal";
			m_game.m_ui.mainTextArea.setText("You keep your " + m_game.m_player.weapon.name + " out.\nThe farmer notices your " + m_game.m_player.weapon.name + ", true to his word, he shows you to a treasure cave.\n\nYou find 20 Gold!!!");
			m_game.m_player.gold+=20;
			statschange();
			
			setChoices("Continue", "", "", "");
		}
		else {
			m_game.m_constants.position = "yesbetrayal";
			m_game.m_ui.mainTextArea.setText("You put your " + m_game.m_player.weapon.name + " away. \nThe farmer noticing you unarmed attacks you and deals 25 damage. \nYou attack him and deal 100 damage.");
			m_game.m_player.playerHP -= 25;
			statschange();
			
			setChoices("Continue", "", "", "");
		}
		setNextPosition("greatplains", "", "", "");
	}
	
	public void greatplains() {
		m_game.m_constants.position = "greatplains";
		m_game.m_ui.mainTextArea.setText("You have reached the great plains biome\nIn here is the The Plateaus.\nLets continue!");
		
		
		setChoices("Continue", "", "", "");
		setNextPosition("theplateau", "", "", "");
	}
	
	public void theplateau() {
		m_game.m_constants.position = "theplateau";
		m_game.m_ui.mainTextArea.setText("You trudge through The Plateaus. \nShall you talk to the weird old man?");
		
		setChoices("Yes", "No", "", ""); 
		setNextPosition("oldman", "", "", "");
	}
	
	public void oldman() {
		m_game.m_constants.position = "oldman";
		m_game.m_ui.mainTextArea.setText("Old Man: Ah Hello. Have you come to here my old tale?");
		
		setChoices("Yes", "No", "", ""); 
		setNextPosition("oldman2", "", "", "");
	}
	
	public void oldman2() {
		m_game.m_constants.position = "oldman2";
		m_game.m_ui.mainTextArea.setText("Old Man: This world was once a great colorful place.\n But then... THEY arrived. They took all our crops, plundered are lands, and destroyed our country. I was a young boy when this all happened. ");
		
		setChoices("Continue", "", "", ""); 
		setNextPosition("oldman3", "", "", "");
	}
	
	public void oldman3() {
		m_game.m_constants.position = "oldman3";
		m_game.m_ui.mainTextArea.setText("Old Man: The only hope now is to travel to the anchient shrines and collect each elemental crystal. But, you don't worry about that. You seem like a nice young child, here let me teach you something.");
		
		setChoices("Continue", "", "", ""); 
		setNextPosition("oldman4", "", "", "");
	}

	public void oldman4() {
		m_game.m_constants.position = "oldman4";
		if(m_game.m_player.playerType.equals("Magical")) m_game.m_ui.mainTextArea.setText("Old Man: I will teach you a special magical attack. \n\n (You have learned special attack)\nThis attack uses capsules to deal damage!");
		else m_game.m_ui.mainTextArea.setText("Old Man: I will teach you a special sword attack.\n\n (You have learned special attack)\nThis attack uses capsules to deal damage!");
		
		setChoices("Continue", "", "", ""); 
		setNextPosition("oldman5", "", "", "");
		m_game.m_player.specialUnlocked = true;
		m_game.m_ui.specialattack.setText("Special Attack");
		m_game.m_ui.choiceButtonPanel.remove(m_game.m_ui.inGameOptionsButton);
		m_game.m_ui.choiceButtonPanel.remove(m_game.m_ui.inventoryButton);
		m_game.m_ui.choiceButtonPanel.setLayout(new GridLayout(7,1));
		m_game.m_ui.choiceButtonPanel.add(m_game.m_ui.specialattack);
		m_game.m_ui.specialattack.setVisible(true);
		m_game.m_ui.choiceButtonPanel.add(m_game.m_ui.inGameOptionsButton);
		m_game.m_ui.choiceButtonPanel.add(m_game.m_ui.inventoryButton);
		m_game.m_ui.playerPanel.setLayout(new GridLayout(8,2));
		m_game.m_ui.playerPanel.add(m_game.m_ui.capsuleLabel);
		m_game.m_ui.playerPanel.add(m_game.m_ui.capsuleLabelNumber);
		m_game.m_ui.specialattack.addActionListener(m_game.m_cHandler);
		
		
		m_game.m_constants.currentEnemy = new EmptyAir();
	}
	
	public void oldman5() {
		m_game.m_constants.position = "oldman5";
		m_game.m_ui.mainTextArea.setText("Old Man: In order to use a special attack, you need energy capsules. Here, take some \n\n(You recieved 5 energy capsules)\n\nYou can convert XP into capsules when you find a wandering wizard.");
		m_game.m_player.capsules += 5;
		statschange();
		

		setChoices("Continue", "", "", ""); 
		setNextPosition("oldman6", "", "", "");
	}
	
	public void oldman6() {
		m_game.m_constants.position = "oldman6";
		m_game.m_ui.mainTextArea.setText("Old Man: You best be on your way now...by the way, that will be 20 gold please.");
		m_game.m_player.gold -= 20;
		statschange();
		
		setChoices("Continue", "", "", ""); 
		setNextPosition("plateaufork", "", "", "");
	}
	
	public void plateauFork() {
		m_game.m_constants.position = "plateauFork";
		m_game.m_ui.mainTextArea.setText("You have reached a fork. Which way shall you go?");
		
		setChoices("North", "West", "East - Leave", "South"); 
		setNextPosition("plateaunorth", "plateauwest", "plateaueast", "plateausouth");
		
	
		m_game.m_ui.playerPanel.add(m_game.m_ui.capsuleLabel);
		m_game.m_ui.playerPanel.add(m_game.m_ui.capsuleLabelNumber);
		
	}
	
	public void plateauNorth(){
		m_game.m_constants.Ncount++;
		if(m_game.m_constants.Ncount <= 3) {
			m_game.m_constants.position = "plateauNorth";
			m_game.m_constants.enemyPosition = "plateauNorth";
			
			m_game.m_ui.mainTextArea.setText("You went North. A wild Goblin attacks!");
			setChoices("Continue", "", "", "");
			setNextPosition("plateaubattle", "", "", "");
		}
		else {
			m_game.m_constants.position = "plateauNorthEasterEgg";
			m_game.m_ui.mainTextArea.setText("You went North. You see a dead Goblin corpse pile...\nI wonder who did that.");
			setChoices("Continue", "", "", "");
			setNextPosition("plateaufork", "", "", "");
		}
	}
	
	public void plateauWest() {
		m_game.m_constants.position = "plateauWest";
		
		if(m_game.m_constants.Ecount >= 10) m_game.m_ui.mainTextArea.setText("Fisherman: I am sorry... I am out of Apples...\nWould you care for a fish?");
		
		int slotNumber = 0;
		while(!m_game.m_player.playerItem[slotNumber].name.equals("[Empty]") && slotNumber < 4) slotNumber++;
		
		if(m_game.m_constants.Ecount < 10) {
			m_game.m_ui.mainTextArea.setText("Fisherman: Hello! You seem very nice. Please, take an Apple.\n\n(You recieved an Apple)");
			m_game.m_inventory.addInventoryItem(new Apple());
			m_game.m_constants.Ecount++;
		}
		setChoices("Continue", "", "", "");
		setNextPosition("plateaufork", "", "", "");
	}

	public void plateauSouth() {
		m_game.m_constants.position = "plateauSouth";
		m_game.m_ui.mainTextArea.setText("Fisherman's Son: Hello, I am a save NPC. Don't talk to me. Just let me save the game for you.\n\n(Your progress has been saved)");
		setChoices("Continue", "", "", "");
		setNextPosition("plateaufork", "", "", "");
		m_game.m_constants.savedPosition = "save2";
		saveData();
		statschange();
	}
	
	public void plateauEast() {
		m_game.m_constants.position = "plateauEast";
		m_game.m_ui.mainTextArea.setText("Continuing onwards you trudge through The Plateaus. \nYou see a sign warning you of Bison Stampedes, you really want to get out of here.");
		setChoices("Continue", "", "", "");
		setNextPosition("bisonStampede", "", "", "");
	}

	public void bisonStampede() {
		m_game.m_constants.position = "bison";
		m_game.m_ui.mainTextArea.setText("BISON STAMPEDE!!!!!!!!!! \nClick the Bison before the time runs out!");
		m_game.m_ui.imagePanel.addMouseListener(m_game.m_mHandler);
		
		setChoices("Continue", "", "", "");
		setNextPosition("", "", "", "");
		
		m_game.m_ui.choiceButtonPanel.setVisible(false);
	
		m_game.m_constants.second = 20;
		simpleTimer();
		m_game.m_constants.timer.start();
		
	}
	
	public void bisonLost() {
		m_game.m_constants.timer.stop();
		m_game.m_constants.position = "bisonLost";
		m_game.m_ui.choiceButtonPanel.setVisible(true);
		m_game.m_ui.mainTextArea.setText("You lost...\n50 HP halved, try again");
		if(m_game.m_player.playerHP > 20) m_game.m_player.playerHP/=2;
		else m_game.m_player.playerHP = 0;
		
		statschange();
	}
	
	public void simpleTimer() {
		m_game.m_constants.timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				m_game.m_ui.counterPanel.setVisible(true);
				m_game.m_ui.counterLabel.setText("Time Left: "+m_game.m_constants.second);
				if(m_game.m_constants.second <= 0 && m_game.m_constants.bisonCount < 20) {
					m_game.m_constants.second = 1;
					bisonLost();
				}
				m_game.m_constants.second--;
				
			}
		});	
	}
	
	
}
