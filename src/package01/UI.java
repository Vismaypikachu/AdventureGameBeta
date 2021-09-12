package package01;

import java.util.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class UI {
	
	JFrame window;
	Container con;
	JPanel titleNamePanel, startButtonPanel, optionsPanel, optionsPanel2, optionsLabelPanel, backButtonPanel, creditsTextAreaPanel, creditsPanel, creditsPanel2;
	JPanel mainTextPanel, choiceButtonPanel, inventoryPanel, playerPanel, imagePanel, counterPanel, inGameOptionsPanel;
	JLabel titleNameLabel, imageLabel;
	JButton startButton, loadButton, creditsButton, optionsButton;
	//Game screen
	JTextArea mainTextArea, backpackTextArea;
	JLabel counterLabel, playerNameLabel, playerNameLabelString, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName, goldLabel, goldLabelNumber, xpLabel, xpLabelNumber, attackLabel, attackLabelNumber, defenseLabel, defenseLabelNumber, capsuleLabel, capsuleLabelNumber;
	JButton specialattack, inventoryButton, inGameOptionsButton, choice1, choice2, choice3, choice4;
	JPanel backpackPanel, backpackTextAreaPanel;
	//Input
	JPanel textPanel, inputPanel;
	JLabel textLabel;
	JButton enterButton;
	JTextField jtf;
	
	
	Font titleFont, normalFont, credits1Font, credits2Font, credits3Font, backpackFont;
	
	Random r = new Random();
	
	Enemy m_enemy = new Enemy();
	Constants m_constants = new Constants();
	Sound m_sound = new Sound();
	Images m_images = new Images(this);
	Player m_player = new Player();
	//Story m_story = new Story();
	ImageIcon image;
	
	GraphicsDevice gDevice;
	
	ChoiceHandler m_choiceHandler;
	ButtonHandler bHandler = new ButtonHandler();
	
	
	JButton [] backpackButtons = new JButton[15];
	JButton [] inGameOptionsButtons = new JButton[5];
	JButton [] inventoryButtons = new JButton[5];
	
	public void createUI(ChoiceHandler choiceHandler) {
		m_choiceHandler = choiceHandler;
		
		GraphicsEnvironment gEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
		gDevice = gEnvironment.getDefaultScreenDevice();
		//setup
		window = new JFrame();
		window.setSize(Constants.currentScreenWidth, Constants.currentScreenHeight);
		//window.setSize(1070, 712);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		window.setVisible(true);
		window.setResizable(false);
		con = window.getContentPane();
		
		m_enemy.initializeEnemy();
		m_images.initializeImages();
		
		
		createFont();
		createUIComponent();
				
	}
	
	public void createUIComponent() {
		m_sound.setMusic(m_constants.titleTrackURL);
		try {
			window.remove(optionsPanel);
			window.remove(optionsPanel2);
			window.remove(optionsLabelPanel);
			window.remove(backButtonPanel);
			window.dispose();
		}
		catch(Exception e) {
			
		}
		try {
			window.remove(mainTextPanel);
			window.remove(choiceButtonPanel);
			window.remove(inventoryPanel);
			window.remove(playerPanel);
			window.remove(imagePanel);
			window.remove(counterPanel);
			window.remove(inGameOptionsPanel);
			window.dispose();
		}
		catch (Exception e) {
			
		}
		try {
			window.remove(creditsTextAreaPanel);;
			window.remove(creditsPanel);
			window.remove(creditsPanel2);
			window.dispose();
		}
		catch(Exception e) {
			
		}
		
		
		titleNamePanel = new JPanel();
		int tnp_x = (int)Math.round(m_constants.currentScreenWidth * 0.2196261682242991);
		int tnp_y = (int)Math.round(m_constants.currentScreenHeight * 0.1404494382022472);
		int tnp_w = (int)Math.round(m_constants.currentScreenWidth * 0.5607476635514019);
		int tnp_h = (int)Math.round(m_constants.currentScreenHeight * 0.2106741573033708);
		titleNamePanel.setBounds(tnp_x, tnp_y, tnp_w, tnp_h);
		//titleNamePanel.setBounds(100, 100, 600, 150);
		titleNamePanel.setBackground(Color.red);
		int chance = r.nextInt(999);
		if(chance == 444) titleNameLabel = new JLabel("AVDNERUTE MEAG");
		else titleNameLabel = new JLabel("ADVENTURE GAME");
		titleNameLabel.setForeground(Color.white);
		titleNameLabel.setFont(titleFont);
		
		
		startButtonPanel = new JPanel();
		int sbp_x = (int)Math.round(m_constants.currentScreenWidth * 0.4065420560747664);
		int sbp_y = (int)Math.round(m_constants.currentScreenHeight * 0.5617977528089888);
		int sbp_w = (int)Math.round(m_constants.currentScreenWidth * 0.1869158878504673);
		int sbp_h = (int)Math.round(1.5 * m_constants.currentScreenHeight * 0.1804494382022472);
		startButtonPanel.setBounds(sbp_x, sbp_y, sbp_w, sbp_h);
		//startButtonPanel.setBounds(300, 400, 200, 100);
		startButtonPanel.setBackground(Color.blue);
		startButtonPanel.setLayout(new GridLayout(4,1));
		
		startButton = new JButton("START");
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.white);
		startButton.setFont(normalFont);
		startButton.setFocusPainted(false); //gets rid of small text box
		startButton.addActionListener(m_choiceHandler);
		startButton.addActionListener(bHandler);
		startButton.setActionCommand("c1");
		
		
		loadButton = new JButton("CONTINUE");
		loadButton.setBackground(Color.black);
		loadButton.setForeground(Color.white);
		loadButton.setFont(normalFont);
		loadButton.setFocusPainted(false); //gets rid of small text box
		loadButton.addActionListener(m_choiceHandler);
		loadButton.addActionListener(bHandler);
		loadButton.setActionCommand("c2");
		
		creditsButton = new JButton("CREDITS");
		creditsButton.setBackground(Color.black);
		creditsButton.setForeground(Color.white);
		creditsButton.setFont(normalFont);
		creditsButton.setFocusPainted(false); //gets rid of small text box
		creditsButton.addActionListener(m_choiceHandler);
		creditsButton.addActionListener(bHandler);
		creditsButton.setActionCommand("c3");
		
		optionsButton = new JButton("OPTIONS");
		optionsButton.setBackground(Color.black);
		optionsButton.setForeground(Color.white);
		optionsButton.setFont(normalFont);
		optionsButton.setFocusPainted(false); //gets rid of small text box
		optionsButton.addActionListener(m_choiceHandler);
		optionsButton.addActionListener(bHandler);
		optionsButton.setActionCommand("c4");
		
		titleNamePanel.add(titleNameLabel);
		startButtonPanel.add(startButton);
		startButtonPanel.add(loadButton);
		startButtonPanel.add(creditsButton);
		startButtonPanel.add(optionsButton);
		
		
		if(m_constants.buttonBorderOn == true) {
			startButton.setBorder(m_constants.blackline);
			loadButton.setBorder(m_constants.blackline);
			creditsButton.setBorder(m_constants.blackline);
			optionsButton.setBorder(m_constants.blackline);
		}
		else if(m_constants.buttonBorderOn == false) {
			startButton.setBorder(null);
			loadButton.setBorder(null);
			creditsButton.setBorder(null);
			optionsButton.setBorder(null);
		}
		
		
		con.add(titleNamePanel);
		con.add(startButtonPanel);
		
		window.setVisible(true);
	}
	
	public void createUIComponent2() {
		m_sound.setMusic(m_constants.titleTrackURL);
		try {
			window.remove(optionsPanel);
			window.remove(optionsPanel2);
			window.remove(backButtonPanel);
			window.dispose();
		}
		catch(Exception e) {
			
		}
		
		try {
			window.remove(creditsTextAreaPanel);
			window.remove(creditsPanel);
			window.remove(creditsPanel2);
			window.dispose();
		}
		catch(Exception e) {
			
		}
		
		
		titleNamePanel = new JPanel();
		int tnp_x = (int)Math.round(m_constants.currentScreenWidth * 0.2196261682242991);
		int tnp_y = (int)Math.round(m_constants.currentScreenHeight * 0.1404494382022472);
		int tnp_w = (int)Math.round(m_constants.currentScreenWidth * 0.5607476635514019);
		int tnp_h = (int)Math.round(m_constants.currentScreenHeight * 0.2106741573033708);
		titleNamePanel.setBounds(tnp_x, tnp_y, tnp_w, tnp_h);
		//titleNamePanel.setBounds(100, 100, 600, 150);
		titleNamePanel.setBackground(Color.red);
		int chance = r.nextInt(999);
		if(chance == 444) titleNameLabel = new JLabel("AVDNERUTE MEAG");
		else titleNameLabel = new JLabel("ADVENTURE GAME");
		titleNameLabel.setForeground(Color.white);
		titleNameLabel.setFont(titleFont);
		
		
		startButtonPanel = new JPanel();
		int sbp_x = (int)Math.round(m_constants.currentScreenWidth * 0.4065420560747664);
		int sbp_y = (int)Math.round(m_constants.currentScreenHeight * 0.5617977528089888);
		int sbp_w = (int)Math.round(m_constants.currentScreenWidth * 0.1869158878504673);
		int sbp_h = (int)Math.round(1.5 * m_constants.currentScreenHeight * 0.1804494382022472);
		startButtonPanel.setBounds(sbp_x, sbp_y, sbp_w, sbp_h);
		//startButtonPanel.setBounds(300, 400, 200, 100);
		startButtonPanel.setBackground(Color.blue);
		startButtonPanel.setLayout(new GridLayout(4,1));
		
		startButton = new JButton("START");
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.white);
		startButton.setFont(normalFont);
		startButton.setFocusPainted(false); //gets rid of small text box
		startButton.addActionListener(bHandler);
		startButton.setActionCommand("b1");
		
		
		loadButton = new JButton("CONTINUE");
		loadButton.setBackground(Color.black);
		loadButton.setForeground(Color.white);
		loadButton.setFont(normalFont);
		loadButton.setFocusPainted(false); //gets rid of small text box
		loadButton.addActionListener(bHandler);
		loadButton.setActionCommand("b2");
		
		creditsButton = new JButton("CREDITS");
		creditsButton.setBackground(Color.black);
		creditsButton.setForeground(Color.white);
		creditsButton.setFont(normalFont);
		creditsButton.setFocusPainted(false); //gets rid of small text box
		creditsButton.addActionListener(bHandler);
		creditsButton.setActionCommand("b3");
		
		optionsButton = new JButton("OPTIONS");
		optionsButton.setBackground(Color.black);
		optionsButton.setForeground(Color.white);
		optionsButton.setFont(normalFont);
		optionsButton.setFocusPainted(false); //gets rid of small text box
		optionsButton.addActionListener(bHandler);
		optionsButton.setActionCommand("b4");
		
		titleNamePanel.add(titleNameLabel);
		startButtonPanel.add(startButton);
		startButtonPanel.add(loadButton);
		startButtonPanel.add(creditsButton);
		startButtonPanel.add(optionsButton);
		
		
		if(m_constants.buttonBorderOn == true) {
			startButton.setBorder(m_constants.blackline);
			loadButton.setBorder(m_constants.blackline);
			creditsButton.setBorder(m_constants.blackline);
			optionsButton.setBorder(m_constants.blackline);
		}
		else if(m_constants.buttonBorderOn == false) {
			startButton.setBorder(null);
			loadButton.setBorder(null);
			creditsButton.setBorder(null);
			optionsButton.setBorder(null);
		}
		
		con.add(titleNamePanel);
		con.add(startButtonPanel);
		
		window.setVisible(true);
		
		
		setFullScreen();
	}
	
	public void createUIComponent3() {
		m_sound.setMusic(m_constants.titleTrackURL);
		try {
			window.remove(mainTextPanel);
			window.remove(choiceButtonPanel);
			window.remove(inventoryPanel);
			window.remove(imagePanel);
			window.remove(playerPanel);
			window.remove(counterPanel);
			window.dispose();
		}
		catch(Exception e) {
			
		}
		
		
		titleNamePanel = new JPanel();
		int tnp_x = (int)Math.round(m_constants.currentScreenWidth * 0.2196261682242991);
		int tnp_y = (int)Math.round(m_constants.currentScreenHeight * 0.1404494382022472);
		int tnp_w = (int)Math.round(m_constants.currentScreenWidth * 0.5607476635514019);
		int tnp_h = (int)Math.round(m_constants.currentScreenHeight * 0.2106741573033708);
		titleNamePanel.setBounds(tnp_x, tnp_y, tnp_w, tnp_h);
		//titleNamePanel.setBounds(100, 100, 600, 150);
		titleNamePanel.setBackground(Color.red);
		int chance = r.nextInt(999);
		if(chance == 444) titleNameLabel = new JLabel("AVDNERUTE MEAG");
		else titleNameLabel = new JLabel("ADVENTURE GAME");
		titleNameLabel.setForeground(Color.white);
		titleNameLabel.setFont(titleFont);
		
		
		startButtonPanel = new JPanel();
		int sbp_x = (int)Math.round(m_constants.currentScreenWidth * 0.4065420560747664);
		int sbp_y = (int)Math.round(m_constants.currentScreenHeight * 0.5617977528089888);
		int sbp_w = (int)Math.round(m_constants.currentScreenWidth * 0.1869158878504673);
		int sbp_h = (int)Math.round(1.5 * m_constants.currentScreenHeight * 0.1804494382022472);
		startButtonPanel.setBounds(sbp_x, sbp_y, sbp_w, sbp_h);
		//startButtonPanel.setBounds(300, 400, 200, 100);
		startButtonPanel.setBackground(Color.blue);
		startButtonPanel.setLayout(new GridLayout(4,1));
		
		startButton = new JButton("START");
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.white);
		startButton.setFont(normalFont);
		startButton.setFocusPainted(false); //gets rid of small text box
		startButton.addActionListener(bHandler);
		startButton.setActionCommand("b1");
		
		
		loadButton = new JButton("CONTINUE");
		loadButton.setBackground(Color.black);
		loadButton.setForeground(Color.white);
		loadButton.setFont(normalFont);
		loadButton.setFocusPainted(false); //gets rid of small text box
		loadButton.addActionListener(bHandler);
		loadButton.setActionCommand("b2");
		
		creditsButton = new JButton("CREDITS");
		creditsButton.setBackground(Color.black);
		creditsButton.setForeground(Color.white);
		creditsButton.setFont(normalFont);
		creditsButton.setFocusPainted(false); //gets rid of small text box
		creditsButton.addActionListener(bHandler);
		creditsButton.setActionCommand("b3");
		
		optionsButton = new JButton("OPTIONS");
		optionsButton.setBackground(Color.black);
		optionsButton.setForeground(Color.white);
		optionsButton.setFont(normalFont);
		optionsButton.setFocusPainted(false); //gets rid of small text box
		optionsButton.addActionListener(bHandler);
		optionsButton.setActionCommand("b4");
		
		titleNamePanel.add(titleNameLabel);
		startButtonPanel.add(startButton);
		startButtonPanel.add(loadButton);
		startButtonPanel.add(creditsButton);
		startButtonPanel.add(optionsButton);
		
		
		if(m_constants.buttonBorderOn == true) {
			startButton.setBorder(m_constants.blackline);
			loadButton.setBorder(m_constants.blackline);
			creditsButton.setBorder(m_constants.blackline);
			optionsButton.setBorder(m_constants.blackline);
		}
		else if(m_constants.buttonBorderOn == false) {
			startButton.setBorder(null);
			loadButton.setBorder(null);
			creditsButton.setBorder(null);
			optionsButton.setBorder(null);
		}
		
		con.add(titleNamePanel);
		con.add(startButtonPanel);
		
		window.setVisible(true);
	}

	public void endFullScreen() {
		try {
			window.remove(titleNamePanel);
			window.remove(startButtonPanel);
			window.dispose();
		}
		catch(Exception e) {
			
		}
	
		gDevice.setFullScreenWindow(null);
		
		m_constants.currentScreenWidth = 1070;
		m_constants.currentScreenHeight = 712;
		
		createFont();
		createUIComponent();
	}
	
	public void endFullScreen2() {
		try {
			window.remove(mainTextPanel);
			window.remove(choiceButtonPanel);
			window.remove(playerPanel);
			window.remove(inventoryPanel);
			window.remove(imagePanel);
			window.remove(backpackPanel);
			window.remove(backpackTextAreaPanel);
			window.dispose();
		}
		catch(Exception e) {
			
		}
	
		gDevice.setFullScreenWindow(null);
		
		m_constants.currentScreenWidth = 1070;
		m_constants.currentScreenHeight = 712;
		
		m_images.initializeImages();
		createFont();
		createGameScreen2();
	}
	
	public void setFullScreen() {
		//full screen from title page
		try {
			window.remove(optionsPanel);
			window.remove(optionsPanel2);
			window.remove(optionsLabelPanel);
			window.remove(backButtonPanel);
			window.dispose();
		}
		catch(Exception e) {
			
		}
		gDevice.setFullScreenWindow(window);
		m_constants.currentScreenWidth = window.getWidth();
		m_constants.currentScreenHeight = window.getHeight();
		
		
		createFont();
		createUIComponent3();
	}

	public void setFullScreen2() {
		//full screen from options menu
		try {
			window.remove(mainTextPanel);
			window.remove(playerPanel);
			window.remove(inGameOptionsPanel);
			window.remove(choiceButtonPanel);
			window.remove(imagePanel);
			window.remove(inventoryPanel);
			window.remove(backpackPanel);
			window.remove(backpackTextAreaPanel);
			window.dispose();
		}
		catch(Exception e) {
			
		}
		gDevice.setFullScreenWindow(window);
		m_constants.currentScreenWidth = window.getWidth();
		m_constants.currentScreenHeight = window.getHeight();
		
		m_images.initializeImages();
		createFont();
		createGameScreen2();
	}
	
	public void createGameScreen() {
		if(!position.equals("loadData") && !position.equals("noLoad")) {
			try {
				position = "newGame";
				textPanel.setVisible(false);
				textLabel.setVisible(false);
				inputPanel.setVisible(false);
				jtf.setVisible(false);
			}
			catch(Exception e) {
				
			}
		}
		
		titleNamePanel.setVisible(false);
		startButtonPanel.setVisible(false);
		startButton.setVisible(false);
		loadButton.setVisible(false);
		
		mainTextPanel = new JPanel();
		int mtp_x = 0;
		int mtp_y = (int)Math.round(m_constants.currentScreenHeight * 0.5617977528089888);
		int mtp_w = (int)Math.round(m_constants.currentScreenWidth * 0.5597014925373134);
		int mtp_h = (int)Math.round(m_constants.currentScreenHeight * 0.3792134831460674);
		mainTextPanel.setBounds(0, mtp_y, mtp_w, mtp_h);
		//mainTextPanel.setBounds(0, 400, 600, 270);
		mainTextPanel.setBackground(Color.blue);
		mainTextPanel.setVisible(true);
		con.add(mainTextPanel);
		
		mainTextArea = new JTextArea();
		int mta_x = (int)Math.round(m_constants.currentScreenHeight * 0.0934579439252336);
		int mta_y = (int)Math.round(m_constants.currentScreenHeight * 0.1404494382022472);
		int mta_w = (int)Math.round(m_constants.currentScreenWidth * 0.5607476635514019);
		int mta_h = (int)Math.round(m_constants.currentScreenHeight * 0.351123595505618);
		mainTextArea.setBounds(mta_x, mta_y, mta_w, mta_h);
		//mainTextArea.setBounds(100, 100, 600, 250);
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(normalFont);
		mainTextArea.setLineWrap(true); //word wrap on
		mainTextArea.setWrapStyleWord(true); //word wrap at end of word on
		mainTextArea.setEditable(false); //editable false
		mainTextPanel.add(mainTextArea);
		
		imagePanel = new JPanel();
		int ip_w = (int)Math.round(m_constants.currentScreenWidth * 0.5597014925373134);
		int ip_h = (int)Math.round(m_constants.currentScreenHeight * 0.5555555555555556);
		imagePanel.setBounds(0, 0, ip_w, ip_h);
		imagePanel.setBackground(Color.green);
		con.add(imagePanel);
		
		imageLabel = new JLabel();
		imagePanel.add(imageLabel);
		
		backpack();
		
		//---------------------------------------------------------------
		//timer
		
		int cp_x = (int)Math.round(mtp_x + mtp_w);
		int cp_h = (int)Math.round(m_constants.currentScreenHeight * 0.1039325842696629);
		int cp_y = (int)Math.round(m_constants.currentScreenHeight * 0.2674157303370787 - cp_h);
		int cp_w = (int)Math.round(m_constants.currentScreenWidth * 0.3327102803738318);
		
		
		counterPanel = new JPanel();
		counterPanel.setBounds(cp_x, cp_y, cp_w, cp_h);
		counterPanel.setBackground(Color.red);
		con.add(counterPanel);
		
		counterLabel = new JLabel("" + counterLabel.CENTER);
		counterLabel.setFont(normalFont);
		counterLabel.setForeground(Color.white);
		counterPanel.add(counterLabel);
		
		counterPanel.setVisible(false);
		
		//--------------------------------------------------------------------------------------------------------------------------------------------
		choiceButtonPanel = new JPanel();
		int cbp_x = (int)Math.round(mtp_x + mtp_w);
		int cbp_y = (int)Math.round(m_constants.currentScreenHeight * 0.6283707865168539);
		int cbp_w = (int)Math.round(m_constants.currentScreenWidth * 0.2803738317757009);
		int cbp_h = (int)Math.round(m_constants.currentScreenHeight * 0.3168539325842697);
		choiceButtonPanel.setBounds(cbp_x, cbp_y, cbp_w, cbp_h);
		//choiceButtonPanel.setBounds(600, 485, 300, 188);
		choiceButtonPanel.setBackground(Color.black);
		choiceButtonPanel.setLayout(new GridLayout(6,1)); //button layout stack, get rid of it to have it 2x2 grid, 4, 1 = 4 by 1 grid
		
		
		//create buttons
		
		choice1 = new JButton("Choice1");
		choice1.setBackground(Color.black);
		choice1.setForeground(Color.white);
		choice1.setFont(normalFont);
		choice1.setFocusPainted(false);
		choice1.addActionListener(choiceHandler);
		choice1.addActionListener(bHandler);
		choice1.addActionListener(goHandler);
		choice1.addActionListener(sHandler);
		choice1.setActionCommand("c1");
		choiceButtonPanel.add(choice1);
		
		choice2 = new JButton("Choice2");
		choice2.setBackground(Color.black);
		choice2.setForeground(Color.white);
		choice2.setFont(normalFont);
		choice2.setFocusPainted(false);
		choice2.addActionListener(choiceHandler);
		choice2.addActionListener(bHandler);
		choice2.addActionListener(goHandler);
		choice2.addActionListener(sHandler);
		choice2.setActionCommand("c2");
		choiceButtonPanel.add(choice2);
		
		choice3 = new JButton("Choice3");
		choice3.setBackground(Color.black);
		choice3.setForeground(Color.white);
		choice3.setFont(normalFont);
		choice3.setFocusPainted(false);
		choice3.addActionListener(choiceHandler);
		choice3.addActionListener(bHandler);
		choice3.addActionListener(goHandler);
		choice3.addActionListener(sHandler);
		choice3.setActionCommand("c3");
		choiceButtonPanel.add(choice3);
		
		choice4 = new JButton("Choice4");
		choice4.setBackground(Color.black);
		choice4.setForeground(Color.white);
		choice4.setFont(normalFont);
		choice4.setFocusPainted(false);
		choice4.addActionListener(choiceHandler);
		choice4.addActionListener(bHandler);
		choice4.addActionListener(goHandler);
		choice4.addActionListener(sHandler);
		choice4.setActionCommand("c4");
		choiceButtonPanel.add(choice4);
		
		specialattack = new JButton("Special Attack");
		specialattack.setBackground(Color.black);
		specialattack.setForeground(Color.white);
		specialattack.setFont(normalFont);
		if(position.equals("loadData") && m_player.specialUnlocked == true) {
			specialattack.setVisible(true);
			choiceButtonPanel.setLayout(new GridLayout(7,1));
			choiceButtonPanel.add(specialattack);
			specialattack.addActionListener(cHandler);
		}
		else specialattack.setVisible(false);
		specialattack.setFocusPainted(false);
		specialattack.addActionListener(choiceHandler);
		specialattack.addActionListener(bHandler);
		specialattack.addActionListener(goHandler);
		specialattack.addActionListener(sHandler);
		specialattack.setActionCommand("c5");
		//not added yet
		
		inGameOptionsButton = new JButton("Options");
		inGameOptionsButton.setBackground(Color.white);
		inGameOptionsButton.setForeground(Color.black);
		inGameOptionsButton.setFont(normalFont);
		inGameOptionsButton.setFocusPainted(false);
		inGameOptionsButton.addActionListener(oHandler);
		inGameOptionsButton.addActionListener(bHandler);
		inGameOptionsButton.setActionCommand("inGameOptions");
		choiceButtonPanel.add(inGameOptionsButton);

		
		inventoryButton = new JButton("[Inventory]");
		inventoryButton.setBackground(Color.white);
		inventoryButton.setForeground(Color.black);
		inventoryButton.setFont(normalFont);
		inventoryButton.setFocusPainted(false);
		inventoryButton.addActionListener(iHandler);
		inventoryButton.addActionListener(bHandler);
		inventoryButton.setActionCommand("inventoryButton");
		choiceButtonPanel.add(inventoryButton);
		
		
		inventory(cbp_x, cbp_w);
		
		
		//------------------------------------------------------------------
		
		optionsButtons(cbp_x, cbp_y);
		
		inGameOptionsPanel.setVisible(false);
		
		playerPanel = new JPanel();
		int pp_x = (int)Math.round(mtp_x + mtp_w);
		int pp_y = (int)Math.round(m_constants.currentScreenHeight * 0.2574157303370787);
		int pp_w = (int)Math.round(m_constants.currentScreenWidth * 0.3327102803738318);
		int pp_h = (int)Math.round(m_constants.currentScreenHeight * 0.3689325842696629);
		playerPanel.setBounds(pp_x, pp_y, pp_w, pp_h);
		//playerPanel.setBounds(600, 300, 356, 180);
		playerPanel.setBackground(Color.red);
		playerPanel.setLayout(new GridLayout(7,2));
		//playerNameLabel 
		playerNameLabel = new JLabel();
		playerNameLabel.setIcon(m_images.PlayerIcon);
		playerNameLabel.setFont(normalFont);
		playerNameLabel.setForeground(Color.white);
		playerPanel.add(playerNameLabel);
		//playerNameLabelString
		playerNameLabelString = new JLabel(""+m_player.playerName);
		playerNameLabelString.setFont(normalFont);
		playerNameLabelString.setForeground(Color.white);
		playerPanel.add(playerNameLabelString);
		//hpLabel
		hpLabel = new JLabel();
		hpLabel.setIcon(m_images.HealthIcon);
		hpLabel.setFont(normalFont);
		hpLabel.setForeground(Color.white);
		playerPanel.add(hpLabel);
		//hpLabelNumber
		hpLabelNumber = new JLabel();
		hpLabelNumber.setFont(normalFont);
		hpLabelNumber.setForeground(Color.white);
		playerPanel.add(hpLabelNumber);
		//weaponLabel
		weaponLabel = new JLabel();
		weaponLabel.setIcon(m_images.WeaponIcon);
		weaponLabel.setFont(normalFont);
		weaponLabel.setForeground(Color.white);
		playerPanel.add(weaponLabel);
		//weaponLabelNumber
		weaponLabelName = new JLabel();
		weaponLabelName.setFont(normalFont);
		weaponLabelName.setForeground(Color.white);
		playerPanel.add(weaponLabelName);
		//goldLabel
		goldLabel = new JLabel();
		goldLabel.setIcon(m_images.GoldIcon);
		goldLabel.setFont(normalFont);
		goldLabel.setForeground(Color.white);
		playerPanel.add(goldLabel);
		//goldLabelNumber
		goldLabelNumber = new JLabel();
		goldLabelNumber.setFont(normalFont);
		goldLabelNumber.setForeground(Color.white);
		playerPanel.add(goldLabelNumber);
		//xpLabel
		xpLabel = new JLabel();
		xpLabel.setIcon(m_images.XPIcon);
		xpLabel.setFont(normalFont);
		xpLabel.setForeground(Color.white);
		playerPanel.add(xpLabel);
		//goldLabelNumber
		xpLabelNumber = new JLabel();
		xpLabelNumber.setFont(normalFont);
		xpLabelNumber.setForeground(Color.white);
		playerPanel.add(xpLabelNumber);
		//attack stat label
		attackLabel = new JLabel();
		attackLabel.setIcon(m_images.AttackIcon);
		attackLabel.setFont(normalFont);
		attackLabel.setForeground(Color.white);
		playerPanel.add(attackLabel);
		//attack stat number
		attackLabelNumber = new JLabel();
		attackLabelNumber.setFont(normalFont);
		attackLabelNumber.setForeground(Color.white);
		playerPanel.add(attackLabelNumber);
		//defense stat label
		defenseLabel = new JLabel();
		defenseLabel.setIcon(m_images.DefenseIcon);
		defenseLabel.setFont(normalFont);
		defenseLabel.setForeground(Color.white);
		playerPanel.add(defenseLabel);
		//defense stat number
		defenseLabelNumber = new JLabel();
		defenseLabelNumber.setFont(normalFont);
		defenseLabelNumber.setForeground(Color.white);
		playerPanel.add(defenseLabelNumber);
		//defense stat label
		capsuleLabel = new JLabel();
		capsuleLabel.setIcon(m_images.CapsulesIcon);
		capsuleLabel.setFont(normalFont);
		capsuleLabel.setForeground(Color.white);
		//defense stat number
		capsuleLabelNumber = new JLabel();
		capsuleLabelNumber.setFont(normalFont);
		capsuleLabelNumber.setForeground(Color.white);
	
		if(m_constants.buttonBorderOn == true) {
			choice1.setBorder(m_constants.blackline);
			choice2.setBorder(m_constants.blackline);
			choice3.setBorder(m_constants.blackline);
			choice4.setBorder(m_constants.blackline);
			specialattack.setBorder(m_constants.blackline);
			//
			inGameOptionsButton.setBorder(m_constants.blackline);
			inGameOptionsButtons[1].setBorder(m_constants.blackline);
			inGameOptionsButtons[2].setBorder(m_constants.blackline);
			inGameOptionsButtons[3].setBorder(m_constants.blackline);
			inGameOptionsButtons[4].setBorder(m_constants.blackline);
			inGameOptionsButtons[5].setBorder(m_constants.blackline);
			//
			inventoryButton.setBorder(m_constants.blackline);
			//
			for(int i = 0; i < 5; i++) {
				inGameOptionsButtons[i].setBorder(m_constants.blackline);
			}
			//
			for(int i = 0; i < 15; i++) {
				backpackButtons[i].setBorder(m_constants.blackline);
			}
			inGameOptionsButtons[16].setBorder(m_constants.blackline);
		}
		else if(m_constants.buttonBorderOn == false) {
			choice1.setBorder(null);
			choice2.setBorder(null);
			choice3.setBorder(null);
			choice4.setBorder(null);
			specialattack.setBorder(null);
			//
			inGameOptionsButton.setBorder(null);
			inGameOptionsButtons[1].setBorder(null);
			inGameOptionsButtons[2].setBorder(null);
			inGameOptionsButtons[3].setBorder(null);
			inGameOptionsButtons[4].setBorder(null);
			inGameOptionsButtons[5].setBorder(null);
			//
			inventoryButton.setBorder(null);
			//
			for(int i = 0; i < 5; i++) {
				inGameOptionsButtons[i].setBorder(null);
			}
			//
			for(int i = 0; i < 15; i++) {
				backpackButtons[i].setBorder(null);
			}
			inGameOptionsButtons[16].setBorder(null);
		}
		
		if(position.equals("noLoad")) {
			m_story.gameover();
		}
		if(position.equals("newGame")) {
			m_story.playerSetup();
		}
		else if(position.equals("loadData")) {
			statschange();
			positionCheck();
		}	
		statschange();
		con.add(inGameOptionsPanel);
		con.add(choiceButtonPanel);
		con.add(inventoryPanel);
		con.add(playerPanel);
		
		window.setVisible(true);
	}
	
	public void createFont() {
		titleFont = new Font("Times New Roman", Font.PLAIN, Constants.titleFontSize);
		normalFont = new Font("Times New Roman", Font.PLAIN, Constants.normalFontSize);
		credits1Font = new Font("Times New Roman", Font.PLAIN, Constants.credits1FontSize);
		credits2Font = new Font("Times New Roman", Font.PLAIN, Constants.credits2FontSize);
		credits3Font = new Font("Times New Roman", Font.PLAIN, Constants.credits3FontSize);
		backpackFont = new Font("Times New Roman", Font.PLAIN, Constants.backpackFontSize);
	}

	public void setImage(URL ImageURL) {
		m_constants.currentImage = ImageURL;
		image = new ImageIcon(ImageURL);
		int image_w = (int)Math.round(m_constants.currentScreenWidth * 0.5555555555555556);
		int image_h = (int)Math.round(m_constants.currentScreenHeight * 0.5617977528089888);
		
		Image im = image.getImage().getScaledInstance(image_w, image_h, Image.SCALE_DEFAULT);
		image = new ImageIcon(im);
		imageLabel.setIcon(image);
	}

	public void backpack() {
		backpackPanel = new JPanel();
		int bp_y = 0;
		int bp_w = (int)Math.round(m_constants.currentScreenWidth * 0.5597014925373134);
		int bp_h = (int)Math.round(m_constants.currentScreenHeight * 0.4213483146067416);
		backpackPanel.setBounds(0, bp_y, bp_w, bp_h);
		backpackPanel.setBackground(Color.orange);
		backpackPanel.setLayout(new GridLayout(4, 4));
		con.add(backpackPanel);
		backpackPanel.setVisible(false);
		
		for (int i = 0; i < backpackButtons.length; i++) {
			backpackButtons[i] = new JButton();
			backpackButtons[i].setBackground(Color.black);
			backpackButtons[i].setForeground(Color.white);
			backpackButtons[i].setFont(normalFont);
			backpackButtons[i].setFocusPainted(false);
			backpackButtons[i].addActionListener(bHandler);
			backpackButtons[i].addActionListener(goHandler);
			backpackButtons[i].addActionListener(sHandler);
			backpackButtons[i].addActionListener(bpHandler);
			int buttonListener = i+1;
			backpackButtons[i].setActionCommand("backpackButton" + buttonListener);
			backpackPanel.add(backpackButtons[i]);
		}
		
		backpackTextAreaPanel = new JPanel();
		int btap_y = bp_y + bp_h;
		int btap_w = (int) Math.round(m_constants.currentScreenWidth * 0.555555556);
		int btap_h = (int) Math.round(m_constants.currentScreenHeight * 0.1404494382022472);
		backpackTextAreaPanel.setBounds(0, btap_y, btap_w, btap_h);
		backpackTextAreaPanel.setBackground(Color.blue);
		backpackTextAreaPanel.setVisible(false);
		
		backpackTextArea = new JTextArea("Press Switch to move an item to your inventory. \nIf you do not have any space, the item will be dropped");
		backpackTextArea.setBackground(Color.blue);
		backpackTextArea.setBounds(0, btap_y, btap_w, btap_h);
		backpackTextArea.setFont(normalFont);
		backpackTextArea.setLineWrap(true); //word wrap on
		backpackTextArea.setWrapStyleWord(true); //word wrap at end of word on
		backpackTextArea.setEditable(false);
		backpackTextArea.setForeground(Color.white);
		backpackTextAreaPanel.add(backpackTextArea);
		
		
		con.add(backpackTextAreaPanel);
	}
	
	public void optionsButtons(int cbp_x, int cbp_w) {
		inGameOptionsPanel = new JPanel();
		int igop_x = (int)Math.round(cbp_x + cbp_w);
		int igop_y = (int)Math.round(m_constants.currentScreenHeight * 0.6811797752808989);
		int igop_w = (int)Math.round(m_constants.currentScreenWidth * 0.1401869158878505);
		int igop_h = (int)Math.round(m_constants.currentScreenHeight * 0.2640449438202247);
		inGameOptionsPanel.setBounds(igop_x, igop_y, igop_w, igop_h);
		//inventoryPanel.setBounds(900, 485, 150, 188);
		inGameOptionsPanel.setBackground(Color.black);
		inGameOptionsPanel.setLayout(new GridLayout(5,1));

		
		for (int i = 0; i < inGameOptionsButtons.length-1; i++) {
			inGameOptionsButtons[i] = new JButton();
			inGameOptionsButtons[i].setBackground(Color.black);
			inGameOptionsButtons[i].setForeground(Color.white);
			inGameOptionsButtons[i].setFont(normalFont);
			inGameOptionsButtons[i].setFocusPainted(false);
			inGameOptionsButtons[i].addActionListener(bHandler);
			inGameOptionsButtons[i].addActionListener(oHandler);
			inGameOptionsButtons[i].addActionListener(bpHandler);
			int buttonListener = i+1;
			backpackButtons[i].setActionCommand("option" + buttonListener);
			backpackPanel.add(backpackButtons[i]);
		}
		
		inGameOptionsButtons[1].setText("FULLSCREEN");
		inGameOptionsButtons[2].setText("EXIT FULLSCREEN");
		inGameOptionsButtons[3].setText("EXIT GAME");

		inGameOptionsButtons[5] = new JButton();
		inGameOptionsButtons[5].setBackground(Color.black);
		inGameOptionsButtons[5].setForeground(Color.white);
		//itemButton5.setLayout(new GridLayout(5,1));
		inGameOptionsButtons[5].setFont(backpackFont);
		inGameOptionsButtons[5].setFocusPainted(false);
		inGameOptionsButtons[5].addActionListener(oHandler);
		inGameOptionsButtons[5].addActionListener(bHandler);
		inGameOptionsButtons[5].addActionListener(bpHandler);
		inGameOptionsButtons[5].setActionCommand("backpack");
		
		for(int j = 0; j < inGameOptionsButtons.length; j++) {
			inGameOptionsPanel.add(inGameOptionsButtons[j]);
		}
	}

	public void statschange() {
		hpLabelNumber.setText("" + m_player.playerHP);
		goldLabelNumber.setText(""+ m_player.gold);
		xpLabelNumber.setText(""+ m_player.xp);
		weaponLabelName.setText(""+ m_player.weapon.name);
		attackLabelNumber.setText(""+ m_player.weapon.attackStat);
		defenseLabelNumber.setText(""+ m_player.playerdefense);
		capsuleLabelNumber.setText(""+ m_player.capsules);
	}
	
	public void input() {
		position = "input";
		titleNamePanel.setVisible(false);
		startButtonPanel.setVisible(false);
		
		textPanel = new JPanel();
		int tp_x = (int)Math.round(m_constants.currentScreenHeight * 0.4);
		int tp_y = (int)Math.round(m_constants.currentScreenHeight * 0.4213483146067416);
		int tp_w = (int)Math.round(m_constants.currentScreenWidth * 0.50);
		int tp_h = (int)Math.round(m_constants.currentScreenHeight * 0.0842696629213483);
		textPanel.setBounds(tp_x, tp_y, tp_w, tp_h);
		//textPanel.setBounds(270, 300, 550, 100);
		textPanel.setBackground(Color.blue);
		textLabel = new JLabel("Please enter your name: ");
		textLabel.setForeground(Color.white);
		textLabel.setFont(normalFont);
		textPanel.add(textLabel, BorderLayout.CENTER);
		con.add(textPanel);
			
		
		inputPanel = new JPanel();
		int ip_x = (int)Math.round(m_constants.currentScreenHeight * 0.4);
		int ip_y = (int)Math.round(m_constants.currentScreenHeight * 0.5617977528089888);
		int ip_w = (int)Math.round(m_constants.currentScreenWidth * 0.50);
		int ip_h = (int)Math.round(m_constants.currentScreenHeight * 0.0842696629213483);
		inputPanel.setBounds(ip_x, ip_y, ip_w, ip_h);
		//inputPanel.setBounds(270, 400, 550, 60);
		inputPanel.setBackground(Color.black);
		inputPanel.setLayout(new GridLayout(1,2));
		
		jtf = new JTextField();
		jtf.setFont(normalFont);
		inputPanel.add(jtf);
		enterButton = new JButton("ENTER");
		int eb_y = ip_y + ip_h;
		enterButton.setBounds(ip_x, eb_y, ip_w, ip_h);
		enterButton.setBackground(Color.white);
		enterButton.setForeground(Color.black);
		enterButton.setFocusable(false);
		enterButton.setBorder(m_constants.blackline);
		enterButton.setFocusPainted(false);
		enterButton.setFont(normalFont);
		enterButton.addActionListener(inHandler);
		inputPanel.add(enterButton);
		con.add(inputPanel);
		
	}
}