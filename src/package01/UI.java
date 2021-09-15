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

import package01.game.ChoiceHandler;
import package04.BackpackHandler;
import package04.ButtonHandler;
import package04.CapsulesHandler;
import package04.GameoverHandler;
import package04.InputHandler;
import package04.InventoryHandler;
import package04.OptionsHandler;
import package04.StatsHandler;

public class UI {
	
	public JFrame window;
	Container con;
	JPanel titleNamePanel, startButtonPanel, optionsPanel, optionsPanel2, optionsLabelPanel, backButtonPanel, creditsTextAreaPanel, creditsPanel, creditsPanel2;
	JPanel mainTextPanel, choiceButtonPanel;
	public JPanel sidePanel, playerPanel, counterPanel, imagePanel, backpackTextAreaPanel, backpackPanel;
	JLabel titleNameLabel, imageLabel;
	JButton startButton, loadButton, creditsButton, optionsButton;
	//Game screen
	public JTextArea mainTextArea;
	public JTextArea backpackTextArea, creditsTextArea;
	public JLabel counterLabel, playerNameLabel, playerNameLabelString, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName, goldLabel, goldLabelNumber, xpLabel, xpLabelNumber, attackLabel, attackLabelNumber, defenseLabel, defenseLabelNumber, capsuleLabel, capsuleLabelNumber, optionsPanelLabel, fullScreenLabel, fullScreenLabelString, buttonBorderLabel, buttonBorderLabelString, creditsPanelLabel, creditsPanelLabel2, creditsPanelLabel3, creditsPanelLabel4, creditsPanelLabel5;
	public JButton specialattack, inGameOptionsButton, inventoryButton, choice1, choice2, choice3, choice4, fullScreenButton, buttonBorderButton, backButton, creditsBackButton;
	
	//Input
	JPanel textPanel, inputPanel;
	public JLabel textLabel;
	public JButton enterButton;
	public JTextField jtf;
	
	
	Font titleFont, normalFont, credits1Font, credits2Font, credits3Font, backpackFont;
	/*
	game m_game;
	Random r = new Random();
	Enemy m_enemy = new Enemy();
	Constants m_constants = new Constants(this);
	Sound m_sound = new Sound(this);
	Images m_images = new Images(this);
	Player m_player = new Player(this, m_constants);
	VisibilityManager vm = new VisibilityManager(this);
	Inventory m_inventory = new Inventory(m_game, this);
	InventoryHandler iHandler = new InventoryHandler(this, m_game, m_constants, m_inventory);
	public Story m_story = new Story(m_game, this, vm, m_constants, m_inventory);
	BackpackHandler bpHandler = new BackpackHandler(m_game, this);
	CapsulesHandler cHandler = new CapsulesHandler(m_game, this);
	GameoverHandler goHandler = new GameoverHandler();
	InputHandler inHandler = new InputHandler(m_game, this);
	OptionsHandler oHandler = new OptionsHandler(m_game, this);
	StatsHandler sHandler = new StatsHandler(m_game, this);
	ButtonHandler bHandler = new ButtonHandler(m_game, this);
	ImageIcon image;
	
	*/
	game m_game;
	
	public UI(game g) {
		m_game = g;
	}	
	
	GraphicsDevice gDevice;
	
	//NEW
	Random r = new Random();
	ImageIcon image;
	
	
	JButton [] backpackButtons = new JButton[16];
	public JButton [] inGameOptionsButtons = new JButton[5];
	public JButton [] inventoryButtons = new JButton[5];
	
	//previously passed in choiceHandler
	public void createUI() {
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
		
		m_game.m_images.initializeImages();
		
		
		createFont();
		createUIComponent();
				
	}
	
	public void createUIComponent() {
		m_game.m_constants.position = "title";
		
		m_game.m_sound.setMusic(m_game.m_constants.titleTrackURL);
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
			window.remove(backpackPanel);
			window.remove(backpackTextAreaPanel);
			window.remove(sidePanel);
			window.remove(playerPanel);
			window.remove(imagePanel);
			window.remove(counterPanel);
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
		int tnp_x = (int)Math.round(m_game.m_constants.currentScreenWidth * 0.2196261682242991);
		int tnp_y = (int)Math.round(m_game.m_constants.currentScreenHeight * 0.1404494382022472);
		int tnp_w = (int)Math.round(m_game.m_constants.currentScreenWidth * 0.5607476635514019);
		int tnp_h = (int)Math.round(m_game.m_constants.currentScreenHeight * 0.2106741573033708);
		titleNamePanel.setBounds(tnp_x, tnp_y, tnp_w, tnp_h);
		//titleNamePanel.setBounds(100, 100, 600, 150);
		titleNamePanel.setBackground(Color.red);
		int chance = r.nextInt(999);
		if(chance == 444) titleNameLabel = new JLabel("AVDNERUTE MEAG");
		else titleNameLabel = new JLabel("ADVENTURE GAME");
		titleNameLabel.setForeground(Color.white);
		titleNameLabel.setFont(titleFont);
		
		
		startButtonPanel = new JPanel();
		int sbp_x = (int)Math.round(m_game.m_constants.currentScreenWidth * 0.4065420560747664);
		int sbp_y = (int)Math.round(m_game.m_constants.currentScreenHeight * 0.5617977528089888);
		int sbp_w = (int)Math.round(m_game.m_constants.currentScreenWidth * 0.1869158878504673);
		int sbp_h = (int)Math.round(1.5 * m_game.m_constants.currentScreenHeight * 0.1804494382022472);
		startButtonPanel.setBounds(sbp_x, sbp_y, sbp_w, sbp_h);
		//startButtonPanel.setBounds(300, 400, 200, 100);
		startButtonPanel.setBackground(Color.blue);
		startButtonPanel.setLayout(new GridLayout(4,1));
		
		startButton = new JButton("START");
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.white);
		startButton.setFont(normalFont);
		startButton.setFocusPainted(false); //gets rid of small text box
		startButton.addActionListener(m_game.m_choiceHandler);
		startButton.addActionListener(m_game.m_bHandler);
		startButton.setActionCommand("start");
		
		
		loadButton = new JButton("CONTINUE");
		loadButton.setBackground(Color.black);
		loadButton.setForeground(Color.white);
		loadButton.setFont(normalFont);
		loadButton.setFocusPainted(false); //gets rid of small text box
		loadButton.addActionListener(m_game.m_choiceHandler);
		loadButton.addActionListener(m_game.m_bHandler);
		loadButton.setActionCommand("load");
		
		creditsButton = new JButton("CREDITS");
		creditsButton.setBackground(Color.black);
		creditsButton.setForeground(Color.white);
		creditsButton.setFont(normalFont);
		creditsButton.setFocusPainted(false); //gets rid of small text box
		creditsButton.addActionListener(m_game.m_choiceHandler);
		creditsButton.addActionListener(m_game.m_bHandler);
		creditsButton.setActionCommand("credits");
		
		optionsButton = new JButton("OPTIONS");
		optionsButton.setBackground(Color.black);
		optionsButton.setForeground(Color.white);
		optionsButton.setFont(normalFont);
		optionsButton.setFocusPainted(false); //gets rid of small text box
		optionsButton.addActionListener(m_game.m_choiceHandler);
		optionsButton.addActionListener(m_game.m_bHandler);
		optionsButton.setActionCommand("options");
		
		titleNamePanel.add(titleNameLabel);
		startButtonPanel.add(startButton);
		startButtonPanel.add(loadButton);
		startButtonPanel.add(creditsButton);
		startButtonPanel.add(optionsButton);
		
		
		if(m_game.m_constants.buttonBorderOn == true) {
			startButton.setBorder(m_game.m_constants.blackline);
			loadButton.setBorder(m_game.m_constants.blackline);
			creditsButton.setBorder(m_game.m_constants.blackline);
			optionsButton.setBorder(m_game.m_constants.blackline);
		}
		else if(m_game.m_constants.buttonBorderOn == false) {
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
		m_game.m_constants.position = "title";
		
		m_game.m_sound.setMusic(m_game.m_constants.titleTrackURL);
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
		int tnp_x = (int)Math.round(m_game.m_constants.currentScreenWidth * 0.2196261682242991);
		int tnp_y = (int)Math.round(m_game.m_constants.currentScreenHeight * 0.1404494382022472);
		int tnp_w = (int)Math.round(m_game.m_constants.currentScreenWidth * 0.5607476635514019);
		int tnp_h = (int)Math.round(m_game.m_constants.currentScreenHeight * 0.2106741573033708);
		titleNamePanel.setBounds(tnp_x, tnp_y, tnp_w, tnp_h);
		//titleNamePanel.setBounds(100, 100, 600, 150);
		titleNamePanel.setBackground(Color.red);
		int chance = r.nextInt(999);
		if(chance == 444) titleNameLabel = new JLabel("AVDNERUTE MEAG");
		else titleNameLabel = new JLabel("ADVENTURE GAME");
		titleNameLabel.setForeground(Color.white);
		titleNameLabel.setFont(titleFont);
		
		
		startButtonPanel = new JPanel();
		int sbp_x = (int)Math.round(m_game.m_constants.currentScreenWidth * 0.4065420560747664);
		int sbp_y = (int)Math.round(m_game.m_constants.currentScreenHeight * 0.5617977528089888);
		int sbp_w = (int)Math.round(m_game.m_constants.currentScreenWidth * 0.1869158878504673);
		int sbp_h = (int)Math.round(1.5 * m_game.m_constants.currentScreenHeight * 0.1804494382022472);
		startButtonPanel.setBounds(sbp_x, sbp_y, sbp_w, sbp_h);
		//startButtonPanel.setBounds(300, 400, 200, 100);
		startButtonPanel.setBackground(Color.blue);
		startButtonPanel.setLayout(new GridLayout(4,1));
		
		startButton = new JButton("START");
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.white);
		startButton.setFont(normalFont);
		startButton.setFocusPainted(false); //gets rid of small text box
		startButton.addActionListener(m_game.m_choiceHandler);
		startButton.addActionListener(m_game.m_bHandler);
		startButton.setActionCommand("start");
		
		
		loadButton = new JButton("CONTINUE");
		loadButton.setBackground(Color.black);
		loadButton.setForeground(Color.white);
		loadButton.setFont(normalFont);
		loadButton.setFocusPainted(false); //gets rid of small text box
		loadButton.addActionListener(m_game.m_choiceHandler);
		loadButton.addActionListener(m_game.m_bHandler);
		loadButton.setActionCommand("load");
		
		creditsButton = new JButton("CREDITS");
		creditsButton.setBackground(Color.black);
		creditsButton.setForeground(Color.white);
		creditsButton.setFont(normalFont);
		creditsButton.setFocusPainted(false); //gets rid of small text box
		creditsButton.addActionListener(m_game.m_choiceHandler);
		creditsButton.addActionListener(m_game.m_bHandler);
		creditsButton.setActionCommand("credits");
		
		optionsButton = new JButton("OPTIONS");
		optionsButton.setBackground(Color.black);
		optionsButton.setForeground(Color.white);
		optionsButton.setFont(normalFont);
		optionsButton.setFocusPainted(false); //gets rid of small text box
		optionsButton.addActionListener(m_game.m_choiceHandler);
		optionsButton.addActionListener(m_game.m_bHandler);
		optionsButton.setActionCommand("options");
		
		titleNamePanel.add(titleNameLabel);
		startButtonPanel.add(startButton);
		startButtonPanel.add(loadButton);
		startButtonPanel.add(creditsButton);
		startButtonPanel.add(optionsButton);
		
		
		if(m_game.m_constants.buttonBorderOn == true) {
			startButton.setBorder(m_game.m_constants.blackline);
			loadButton.setBorder(m_game.m_constants.blackline);
			creditsButton.setBorder(m_game.m_constants.blackline);
			optionsButton.setBorder(m_game.m_constants.blackline);
		}
		else if(m_game.m_constants.buttonBorderOn == false) {
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
		m_game.m_constants.position = "title";
		
		m_game.m_sound.setMusic(m_game.m_constants.titleTrackURL);
		try {
			window.remove(mainTextPanel);
			window.remove(choiceButtonPanel);
			window.remove(sidePanel);
			window.remove(imagePanel);
			window.remove(playerPanel);
			window.remove(counterPanel);
			window.dispose();
		}
		catch(Exception e) {
			
		}
		
		
		titleNamePanel = new JPanel();
		int tnp_x = (int)Math.round(m_game.m_constants.currentScreenWidth * 0.2196261682242991);
		int tnp_y = (int)Math.round(m_game.m_constants.currentScreenHeight * 0.1404494382022472);
		int tnp_w = (int)Math.round(m_game.m_constants.currentScreenWidth * 0.5607476635514019);
		int tnp_h = (int)Math.round(m_game.m_constants.currentScreenHeight * 0.2106741573033708);
		titleNamePanel.setBounds(tnp_x, tnp_y, tnp_w, tnp_h);
		//titleNamePanel.setBounds(100, 100, 600, 150);
		titleNamePanel.setBackground(Color.red);
		int chance = r.nextInt(999);
		if(chance == 444) titleNameLabel = new JLabel("AVDNERUTE MEAG");
		else titleNameLabel = new JLabel("ADVENTURE GAME");
		titleNameLabel.setForeground(Color.white);
		titleNameLabel.setFont(titleFont);
		
		
		startButtonPanel = new JPanel();
		int sbp_x = (int)Math.round(m_game.m_constants.currentScreenWidth * 0.4065420560747664);
		int sbp_y = (int)Math.round(m_game.m_constants.currentScreenHeight * 0.5617977528089888);
		int sbp_w = (int)Math.round(m_game.m_constants.currentScreenWidth * 0.1869158878504673);
		int sbp_h = (int)Math.round(1.5 * m_game.m_constants.currentScreenHeight * 0.1804494382022472);
		startButtonPanel.setBounds(sbp_x, sbp_y, sbp_w, sbp_h);
		//startButtonPanel.setBounds(300, 400, 200, 100);
		startButtonPanel.setBackground(Color.blue);
		startButtonPanel.setLayout(new GridLayout(4,1));
		
		startButton = new JButton("START");
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.white);
		startButton.setFont(normalFont);
		startButton.setFocusPainted(false); //gets rid of small text box
		startButton.addActionListener(m_game.m_choiceHandler);
		startButton.addActionListener(m_game.m_bHandler);
		startButton.setActionCommand("start");
		
		
		loadButton = new JButton("CONTINUE");
		loadButton.setBackground(Color.black);
		loadButton.setForeground(Color.white);
		loadButton.setFont(normalFont);
		loadButton.setFocusPainted(false); //gets rid of small text box
		loadButton.addActionListener(m_game.m_choiceHandler);
		loadButton.addActionListener(m_game.m_bHandler);
		loadButton.setActionCommand("load");
		
		creditsButton = new JButton("CREDITS");
		creditsButton.setBackground(Color.black);
		creditsButton.setForeground(Color.white);
		creditsButton.setFont(normalFont);
		creditsButton.setFocusPainted(false); //gets rid of small text box
		creditsButton.addActionListener(m_game.m_choiceHandler);
		creditsButton.addActionListener(m_game.m_bHandler);
		creditsButton.setActionCommand("credits");
		
		optionsButton = new JButton("OPTIONS");
		optionsButton.setBackground(Color.black);
		optionsButton.setForeground(Color.white);
		optionsButton.setFont(normalFont);
		optionsButton.setFocusPainted(false); //gets rid of small text box
		optionsButton.addActionListener(m_game.m_choiceHandler);
		optionsButton.addActionListener(m_game.m_bHandler);
		optionsButton.setActionCommand("options");
		
		titleNamePanel.add(titleNameLabel);
		startButtonPanel.add(startButton);
		startButtonPanel.add(loadButton);
		startButtonPanel.add(creditsButton);
		startButtonPanel.add(optionsButton);
		
		
		if(m_game.m_constants.buttonBorderOn == true) {
			startButton.setBorder(m_game.m_constants.blackline);
			loadButton.setBorder(m_game.m_constants.blackline);
			creditsButton.setBorder(m_game.m_constants.blackline);
			optionsButton.setBorder(m_game.m_constants.blackline);
		}
		else if(m_game.m_constants.buttonBorderOn == false) {
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
		m_game.m_constants.fullScreenOn = false;
		try {
			window.remove(titleNamePanel);
			window.remove(startButtonPanel);
			window.dispose();
		}
		catch(Exception e) {
			
		}
	
		gDevice.setFullScreenWindow(null);
		
		m_game.m_constants.currentScreenWidth = 1070;
		m_game.m_constants.currentScreenHeight = 712;
		
		createFont();
		createUIComponent();
	}
	
	public void endFullScreen2() {
		m_game.m_constants.fullScreenOn = false;
		try {
			window.remove(mainTextPanel);
			window.remove(choiceButtonPanel);
			window.remove(playerPanel);
			window.remove(backpackPanel);
			window.remove(sidePanel);
			window.remove(imagePanel);
			window.remove(backpackTextAreaPanel);
			window.dispose();
		}
		catch(Exception e) {
			
		}
	
		gDevice.setFullScreenWindow(null);
		
		m_game.m_constants.currentScreenWidth = 1070;
		m_game.m_constants.currentScreenHeight = 712;
		
		m_game.m_images.initializeImages();
		createFont();
		createGameScreen2();
	}
	
	public void setFullScreen() {
		m_game.m_constants.fullScreenOn = true;
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
		m_game.m_constants.currentScreenWidth = window.getWidth();
		m_game.m_constants.currentScreenHeight = window.getHeight();
		
		
		createFont();
		createUIComponent3();
	}

	public void setFullScreen2() {
		m_game.m_constants.fullScreenOn = true;
		//full screen from options menu
		try {
			window.remove(mainTextPanel);
			window.remove(playerPanel);
			window.remove(choiceButtonPanel);
			window.remove(imagePanel);
			window.remove(sidePanel);
			window.remove(sidePanel);
			window.remove(backpackTextAreaPanel);
			window.dispose();
		}
		catch(Exception e) {
			
		}
		gDevice.setFullScreenWindow(window);
		m_game.m_constants.currentScreenWidth = window.getWidth();
		m_game.m_constants.currentScreenHeight = window.getHeight();
		
		m_game.m_images.initializeImages();
		createFont();
		createGameScreen2();
	}
	
	public void createGameScreen() {
		if(!m_game.m_constants.position.equals("loadData") && !m_game.m_constants.position.equals("noLoad")) {
			try {
				m_game.m_constants.position = "newGame";
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
		int mtp_y = (int)Math.round(m_game.m_constants.currentScreenHeight * 0.5617977528089888);
		int mtp_w = (int)Math.round(m_game.m_constants.currentScreenWidth * 0.5597014925373134);
		int mtp_h = (int)Math.round(m_game.m_constants.currentScreenHeight * 0.3792134831460674);
		mainTextPanel.setBounds(0, mtp_y, mtp_w, mtp_h);
		//mainTextPanel.setBounds(0, 400, 600, 270);
		mainTextPanel.setBackground(Color.blue);
		mainTextPanel.setVisible(true);
		con.add(mainTextPanel);
		
		mainTextArea = new JTextArea();
		int mta_x = (int)Math.round(m_game.m_constants.currentScreenHeight * 0.0934579439252336);
		int mta_y = (int)Math.round(m_game.m_constants.currentScreenHeight * 0.1404494382022472);
		int mta_w = (int)Math.round(m_game.m_constants.currentScreenWidth * 0.5607476635514019);
		int mta_h = (int)Math.round(m_game.m_constants.currentScreenHeight * 0.351123595505618);
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
		int ip_w = (int)Math.round(m_game.m_constants.currentScreenWidth * 0.5597014925373134);
		int ip_h = (int)Math.round(m_game.m_constants.currentScreenHeight * 0.5555555555555556);
		imagePanel.setBounds(0, 0, ip_w, ip_h);
		imagePanel.setBackground(Color.green);
		con.add(imagePanel);
		
		imageLabel = new JLabel();
		imagePanel.add(imageLabel);
		
		backpack();
		
		//---------------------------------------------------------------
		//timer
		
		int cp_x = (int)Math.round(mtp_x + mtp_w);
		int cp_h = (int)Math.round(m_game.m_constants.currentScreenHeight * 0.1039325842696629);
		int cp_y = (int)Math.round(m_game.m_constants.currentScreenHeight * 0.2674157303370787 - cp_h);
		int cp_w = (int)Math.round(m_game.m_constants.currentScreenWidth * 0.3327102803738318);
		
		
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
		int cbp_y = (int)Math.round(m_game.m_constants.currentScreenHeight * 0.6283707865168539);
		int cbp_w = (int)Math.round(m_game.m_constants.currentScreenWidth * 0.2803738317757009);
		int cbp_h = (int)Math.round(m_game.m_constants.currentScreenHeight * 0.3168539325842697);
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
		choice1.addActionListener(m_game.m_choiceHandler);
		choice1.addActionListener(m_game.m_bHandler);
		choice1.addActionListener(m_game.m_goHandler);
		choice1.addActionListener(m_game.m_sHandler);
		choice1.setActionCommand("c1");
		choiceButtonPanel.add(choice1);
		
		choice2 = new JButton("Choice2");
		choice2.setBackground(Color.black);
		choice2.setForeground(Color.white);
		choice2.setFont(normalFont);
		choice2.setFocusPainted(false);
		choice2.addActionListener(m_game.m_choiceHandler);
		choice2.addActionListener(m_game.m_bHandler);
		choice2.addActionListener(m_game.m_goHandler);
		choice2.addActionListener(m_game.m_sHandler);
		choice2.setActionCommand("c2");
		choiceButtonPanel.add(choice2);
		
		choice3 = new JButton("Choice3");
		choice3.setBackground(Color.black);
		choice3.setForeground(Color.white);
		choice3.setFont(normalFont);
		choice3.setFocusPainted(false);
		choice3.addActionListener(m_game.m_choiceHandler);
		choice3.addActionListener(m_game.m_bHandler);
		choice3.addActionListener(m_game.m_goHandler);
		choice3.addActionListener(m_game.m_sHandler);
		choice3.setActionCommand("c3");
		choiceButtonPanel.add(choice3);
		
		choice4 = new JButton("Choice4");
		choice4.setBackground(Color.black);
		choice4.setForeground(Color.white);
		choice4.setFont(normalFont);
		choice4.setFocusPainted(false);
		choice4.addActionListener(m_game.m_choiceHandler);
		choice4.addActionListener(m_game.m_bHandler);
		choice4.addActionListener(m_game.m_goHandler);
		choice4.addActionListener(m_game.m_sHandler);
		choice4.setActionCommand("c4");
		choiceButtonPanel.add(choice4);
		
		specialattack = new JButton("Special Attack");
		specialattack.setBackground(Color.black);
		specialattack.setForeground(Color.white);
		specialattack.setFont(normalFont);
		if(m_game.m_constants.position.equals("loadData") && m_game.m_player.specialUnlocked == true) {
			specialattack.setVisible(true);
			choiceButtonPanel.setLayout(new GridLayout(7,1));
			choiceButtonPanel.add(specialattack);
			specialattack.addActionListener(m_game.m_cHandler);
		}
		else specialattack.setVisible(false);
		specialattack.setFocusPainted(false);
		specialattack.addActionListener(m_game.m_choiceHandler);
		specialattack.addActionListener(m_game.m_bHandler);
		specialattack.addActionListener(m_game.m_goHandler);
		specialattack.addActionListener(m_game.m_sHandler);
		specialattack.setActionCommand("c5");
		//not added yet
		
		inGameOptionsButton = new JButton("Options");
		inGameOptionsButton.setBackground(Color.white);
		inGameOptionsButton.setForeground(Color.black);
		inGameOptionsButton.setFont(normalFont);
		inGameOptionsButton.setFocusPainted(false);
		inGameOptionsButton.addActionListener(m_game.m_oHandler);
		inGameOptionsButton.addActionListener(m_game.m_bHandler);
		inGameOptionsButton.setActionCommand("inGameOptions");
		choiceButtonPanel.add(inGameOptionsButton);

		
		inventoryButton = new JButton("[Inventory]");
		inventoryButton.setBackground(Color.white);
		inventoryButton.setForeground(Color.black);
		inventoryButton.setFont(normalFont);
		inventoryButton.setFocusPainted(false);
		inventoryButton.addActionListener(m_game.m_iHandler);
		inventoryButton.addActionListener(m_game.m_bHandler);
		inventoryButton.setActionCommand("inventoryButton");
		choiceButtonPanel.add(inventoryButton);
		
		
		
		//------------------------------------------------------------------
		//Shared inGame panel
		sidePanel = new JPanel();
		int sp_x = (int)Math.round(cbp_x + cbp_w);
		int sp_y = (int)Math.round(m_game.m_constants.currentScreenHeight * 0.6811797752808989);
		int sp_w = (int)Math.round(m_game.m_constants.currentScreenWidth * 0.1401869158878505);
		int sp_h = (int)Math.round(m_game.m_constants.currentScreenHeight * 0.2640449438202247);
		sidePanel.setBounds(sp_x, sp_y, sp_w, sp_h);
		//sidePanel.setBounds(900, 485, 150, 188);
		sidePanel.setBackground(Color.black);
		sidePanel.setLayout(new GridLayout(5,1));
		
		con.add(sidePanel);
		
		sidePanel.setVisible(false);
		//------------------------------------------------------------------
		
		inventory(cbp_x, cbp_w);
		optionsButtons(cbp_x, cbp_y);
		
		
		playerPanel = new JPanel();
		int pp_x = (int)Math.round(mtp_x + mtp_w);
		int pp_y = (int)Math.round(m_game.m_constants.currentScreenHeight * 0.2574157303370787);
		int pp_w = (int)Math.round(m_game.m_constants.currentScreenWidth * 0.3327102803738318);
		int pp_h = (int)Math.round(m_game.m_constants.currentScreenHeight * 0.3689325842696629);
		playerPanel.setBounds(pp_x, pp_y, pp_w, pp_h);
		//playerPanel.setBounds(600, 300, 356, 180);
		playerPanel.setBackground(Color.red);
		playerPanel.setLayout(new GridLayout(7,2));
		//playerNameLabel 
		playerNameLabel = new JLabel();
		playerNameLabel.setIcon(m_game.m_images.PlayerIcon);
		playerNameLabel.setFont(normalFont);
		playerNameLabel.setForeground(Color.white);
		playerPanel.add(playerNameLabel);
		//playerNameLabelString
		playerNameLabelString = new JLabel(""+m_game.m_player.playerName);
		playerNameLabelString.setFont(normalFont);
		playerNameLabelString.setForeground(Color.white);
		playerPanel.add(playerNameLabelString);
		//hpLabel
		hpLabel = new JLabel();
		hpLabel.setIcon(m_game.m_images.HealthIcon);
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
		weaponLabel.setIcon(m_game.m_images.WeaponIcon);
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
		goldLabel.setIcon(m_game.m_images.GoldIcon);
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
		xpLabel.setIcon(m_game.m_images.XPIcon);
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
		attackLabel.setIcon(m_game.m_images.AttackIcon);
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
		defenseLabel.setIcon(m_game.m_images.DefenseIcon);
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
		capsuleLabel.setIcon(m_game.m_images.CapsulesIcon);
		capsuleLabel.setFont(normalFont);
		capsuleLabel.setForeground(Color.white);
		//defense stat number
		capsuleLabelNumber = new JLabel();
		capsuleLabelNumber.setFont(normalFont);
		capsuleLabelNumber.setForeground(Color.white);
	
		if(m_game.m_constants.buttonBorderOn == true) {
			choice1.setBorder(m_game.m_constants.blackline);
			choice2.setBorder(m_game.m_constants.blackline);
			choice3.setBorder(m_game.m_constants.blackline);
			choice4.setBorder(m_game.m_constants.blackline);
			specialattack.setBorder(m_game.m_constants.blackline);
			//
			inGameOptionsButtons[0].setBorder(m_game.m_constants.blackline);
			inGameOptionsButtons[1].setBorder(m_game.m_constants.blackline);
			inGameOptionsButtons[2].setBorder(m_game.m_constants.blackline);
			inGameOptionsButtons[3].setBorder(m_game.m_constants.blackline);
			inGameOptionsButtons[4].setBorder(m_game.m_constants.blackline);
			//
			inventoryButtons[0].setBorder(m_game.m_constants.blackline);
			inventoryButtons[1].setBorder(m_game.m_constants.blackline);
			inventoryButtons[2].setBorder(m_game.m_constants.blackline);
			inventoryButtons[3].setBorder(m_game.m_constants.blackline);
			inventoryButtons[4].setBorder(m_game.m_constants.blackline);
			//
			inventoryButton.setBorder(m_game.m_constants.blackline);
			//
			for(int i = 0; i < 5; i++) {
				inGameOptionsButtons[i].setBorder(m_game.m_constants.blackline);
			}
			//
			for(int i = 0; i < backpackButtons.length; i++) {
				backpackButtons[i].setBorder(m_game.m_constants.blackline);
			}
		}
		else if(m_game.m_constants.buttonBorderOn == false) {
			choice1.setBorder(null);
			choice2.setBorder(null);
			choice3.setBorder(null);
			choice4.setBorder(null);
			specialattack.setBorder(null);
			//
			inGameOptionsButton.setBorder(null);
			inGameOptionsButtons[0].setBorder(null);
			inGameOptionsButtons[1].setBorder(null);
			inGameOptionsButtons[2].setBorder(null);
			inGameOptionsButtons[3].setBorder(null);
			inGameOptionsButtons[4].setBorder(null);
			//
			inventoryButtons[0].setBorder(null);
			inventoryButtons[1].setBorder(null);
			inventoryButtons[2].setBorder(null);
			inventoryButtons[3].setBorder(null);
			inventoryButtons[4].setBorder(null);
			//
			inventoryButton.setBorder(null);
			//
			for(int i = 0; i < 5; i++) {
				inGameOptionsButtons[i].setBorder(null);
			}
			//
			for(int i = 0; i < backpackButtons.length; i++) {
				backpackButtons[i].setBorder(null);
			}
		}
		
		if(m_game.m_constants.position.equals("noLoad")) {
			m_game.m_story.gameover();
		}
		if(m_game.m_constants.position.equals("newGame")) {
			m_game.m_story.playerSetup();
		}
		else if(m_game.m_constants.position.equals("loadData")) {
			//statschange();
			m_game.m_story.positionCheck();
		}	
		//statschange();
		con.add(choiceButtonPanel);
		con.add(playerPanel);
		
		window.setVisible(true);
	}
	
	public void createGameScreen2() {
		m_game.m_images.initializeImages();
		mainTextPanel = new JPanel();
		int mtp_x = 0;
		int mtp_y = (int)Math.round(m_game.m_constants.currentScreenHeight * 0.5617977528089888);
		int mtp_w = (int)Math.round(m_game.m_constants.currentScreenWidth * 0.5597014925373134);
		int mtp_h = (int)Math.round(m_game.m_constants.currentScreenHeight * 0.3792134831460674);
		mainTextPanel.setBounds(0, mtp_y, mtp_w, mtp_h);
		//mainTextPanel.setBounds(0, 400, 600, 270);
		mainTextPanel.setBackground(Color.blue);
		mainTextPanel.setVisible(true);
		con.add(mainTextPanel);
	
		
		mainTextArea = new JTextArea(m_game.m_constants.text);
		int mta_x = (int)Math.round(m_game.m_constants.currentScreenHeight * 0.0934579439252336);
		int mta_y = (int)Math.round(m_game.m_constants.currentScreenHeight * 0.1404494382022472);
		int mta_w = (int)Math.round(m_game.m_constants.currentScreenWidth * 0.5607476635514019);
		int mta_h = (int)Math.round(m_game.m_constants.currentScreenHeight * 0.351123595505618);
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
		int ip_w = (int)Math.round(m_game.m_constants.currentScreenWidth * 0.5597014925373134);
		int ip_h = (int)Math.round(m_game.m_constants.currentScreenHeight * 0.5555555555555556);
		imagePanel.setBounds(0, 0, ip_w, ip_h);
		imagePanel.setBackground(Color.green);
		
		imageLabel = new JLabel();
		imagePanel.add(imageLabel);
		
		choiceButtonPanel = new JPanel();
		int cbp_x = (int)Math.round(mtp_x + mtp_w);
		int cbp_y = (int)Math.round(m_game.m_constants.currentScreenHeight * 0.6283707865168539);
		int cbp_w = (int)Math.round(m_game.m_constants.currentScreenWidth * 0.2803738317757009);
		int cbp_h = (int)Math.round(m_game.m_constants.currentScreenHeight * 0.3168539325842697);
		choiceButtonPanel.setBounds(cbp_x, cbp_y, cbp_w, cbp_h);
		//choiceButtonPanel.setBounds(600, 485, 300, 188);
		choiceButtonPanel.setBackground(Color.black);
		choiceButtonPanel.setLayout(new GridLayout(6,1)); //button layout stack, get rid of it to have it 2x2 grid, 4, 1 = 4 by 1 grid
		
		backpack();
		//----------------------------------------------------------------------------------------------------------------
		//timer
		
		int cp_x = (int)Math.round(mtp_x + mtp_w);
		int cp_h = (int)Math.round(m_game.m_constants.currentScreenHeight * 0.1039325842696629);
		int cp_y = (int)Math.round(m_game.m_constants.currentScreenHeight * 0.2674157303370787 - cp_h);
		int cp_w = (int)Math.round(m_game.m_constants.currentScreenWidth * 0.3327102803738318);
				
				
		counterPanel = new JPanel();
		counterPanel.setBounds(cp_x, cp_y, cp_w, cp_h);
		counterPanel.setBackground(Color.red);
		con.add(counterPanel);
				
		counterLabel = new JLabel("" + counterLabel.CENTER);
		counterLabel.setFont(normalFont);
		counterLabel.setForeground(Color.white);
		counterPanel.add(counterLabel);
		
		counterPanel.setVisible(false);
		//----------------------------------------------------------------------------------------------------------------------
		//create buttons
		
		choice1 = new JButton(m_game.m_constants.b1text);
		choice1.setBackground(Color.black);
		choice1.setForeground(Color.white);
		choice1.setFont(normalFont);
		choice1.setFocusPainted(false);
		choice1.addActionListener(m_game.m_choiceHandler);
		choice1.addActionListener(m_game.m_bHandler);
		choice1.addActionListener(m_game.m_goHandler);
		choice1.addActionListener(m_game.m_sHandler);
		choice1.setActionCommand("c1");
		choiceButtonPanel.add(choice1);
		
		choice2 = new JButton(m_game.m_constants.b2text);
		choice2.setBackground(Color.black);
		choice2.setForeground(Color.white);
		choice2.setFont(normalFont);
		choice2.setFocusPainted(false);
		choice2.addActionListener(m_game.m_choiceHandler);
		choice2.addActionListener(m_game.m_bHandler);
		choice2.addActionListener(m_game.m_goHandler);
		choice2.addActionListener(m_game.m_sHandler);
		choice2.setActionCommand("c2");
		choiceButtonPanel.add(choice2);
		
		choice3 = new JButton(m_game.m_constants.b3text);
		choice3.setBackground(Color.black);
		choice3.setForeground(Color.white);
		choice3.setFont(normalFont);
		choice3.setFocusPainted(false);
		choice3.addActionListener(m_game.m_choiceHandler);
		choice3.addActionListener(m_game.m_bHandler);
		choice3.addActionListener(m_game.m_goHandler);
		choice3.addActionListener(m_game.m_sHandler);
		choice3.setActionCommand("c3");
		choiceButtonPanel.add(choice3);
		
		choice4 = new JButton(m_game.m_constants.b4text);
		choice4.setBackground(Color.black);
		choice4.setForeground(Color.white);
		choice4.setFont(normalFont);
		choice4.setFocusPainted(false);
		choice4.addActionListener(m_game.m_choiceHandler);
		choice4.addActionListener(m_game.m_bHandler);
		choice4.addActionListener(m_game.m_goHandler);
		choice4.addActionListener(m_game.m_sHandler);
		choice4.setActionCommand("c4");
		choiceButtonPanel.add(choice4);
		
		specialattack = new JButton(m_game.m_constants.b5text);
		specialattack.setBackground(Color.black);
		specialattack.setForeground(Color.white);
		specialattack.setFont(normalFont);
		if(m_game.m_constants.position.equals("loadData") && m_game.m_player.specialUnlocked == true) {	
			specialattack.setVisible(true);	
			choiceButtonPanel.setLayout(new GridLayout(7,1));	
			choiceButtonPanel.add(specialattack);	
			specialattack.addActionListener(m_game.m_cHandler);	
		}	
		else specialattack.setVisible(false);
		specialattack.setFocusPainted(false);
		specialattack.addActionListener(m_game.m_choiceHandler);
		specialattack.addActionListener(m_game.m_bHandler);
		specialattack.addActionListener(m_game.m_goHandler);
		specialattack.addActionListener(m_game.m_sHandler);
		specialattack.setActionCommand("c5");
		//not added yet
		
		inGameOptionsButton = new JButton("Options");
		inGameOptionsButton.setBackground(Color.white);
		inGameOptionsButton.setForeground(Color.black);
		inGameOptionsButton.setFont(normalFont);
		inGameOptionsButton.setFocusPainted(false);
		inGameOptionsButton.addActionListener(m_game.m_oHandler);
		inGameOptionsButton.addActionListener(m_game.m_bHandler);
		inGameOptionsButton.addActionListener(m_game.m_goHandler);
		inGameOptionsButton.setActionCommand("inGameOptions");
		choiceButtonPanel.add(inGameOptionsButton);

		
		inventoryButton = new JButton("[Inventory]");
		inventoryButton.setBackground(Color.white);
		inventoryButton.setForeground(Color.black);
		inventoryButton.setFont(normalFont);
		inventoryButton.setFocusPainted(false);
		inventoryButton.addActionListener(m_game.m_iHandler);
		inventoryButton.addActionListener(m_game.m_bHandler);
		inventoryButton.addActionListener(m_game.m_goHandler);
		inventoryButton.setActionCommand("inventoryButton");
		choiceButtonPanel.add(inventoryButton);
		
	
		//------------------------------------------------------------------
		//Shared inGame panel
		sidePanel = new JPanel();
		int sp_x = (int)Math.round(cbp_x + cbp_w);
		int sp_y = (int)Math.round(m_game.m_constants.currentScreenHeight * 0.6811797752808989);
		int sp_w = (int)Math.round(m_game.m_constants.currentScreenWidth * 0.1401869158878505);
		int sp_h = (int)Math.round(m_game.m_constants.currentScreenHeight * 0.2640449438202247);
		sidePanel.setBounds(sp_x, sp_y, sp_w, sp_h);
		//sidePanel.setBounds(900, 485, 150, 188);
		sidePanel.setBackground(Color.black);
		sidePanel.setLayout(new GridLayout(5,1));
				
		con.add(sidePanel);
				
		sidePanel.setVisible(false);
		//------------------------------------------------------------------
				
		inventory(cbp_x, cbp_w);
		optionsButtons(cbp_x, cbp_y);
	
		
		playerPanel = new JPanel();
		int pp_x = (int)Math.round(mtp_x + mtp_w);
		int pp_y = (int)Math.round(m_game.m_constants.currentScreenHeight * 0.2574157303370787);
		int pp_w = (int)Math.round(m_game.m_constants.currentScreenWidth * 0.3327102803738318);
		int pp_h = (int)Math.round(m_game.m_constants.currentScreenHeight * 0.3689325842696629);
		playerPanel.setBounds(pp_x, pp_y, pp_w, pp_h);
		//playerPanel.setBounds(600, 300, 356, 180);
		playerPanel.setBackground(Color.red);
		playerPanel.setLayout(new GridLayout(7,2));
		//playerNameLabel 
		playerNameLabel = new JLabel();
		playerNameLabel.setIcon(m_game.m_images.PlayerIcon);
		playerNameLabel.setFont(normalFont);
		playerNameLabel.setForeground(Color.white);
		playerPanel.add(playerNameLabel);
		//playerNameLabelString
		playerNameLabelString = new JLabel(""+ m_game.m_player.playerName);
		playerNameLabelString.setFont(normalFont);
		playerNameLabelString.setForeground(Color.white);
		playerPanel.add(playerNameLabelString);
		//hpLabel
		hpLabel = new JLabel();
		hpLabel.setIcon(m_game.m_images.HealthIcon);
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
		weaponLabel.setIcon(m_game.m_images.WeaponIcon);
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
		goldLabel.setIcon(m_game.m_images.GoldIcon);
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
		xpLabel.setIcon(m_game.m_images.XPIcon);
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
		attackLabel.setIcon(m_game.m_images.AttackIcon);
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
		defenseLabel.setIcon(m_game.m_images.DefenseIcon);
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
		capsuleLabel.setIcon(m_game.m_images.CapsulesIcon);
		capsuleLabel.setFont(normalFont);
		capsuleLabel.setForeground(Color.white);
		//defense stat number
		capsuleLabelNumber = new JLabel();
		capsuleLabelNumber.setFont(normalFont);
		capsuleLabelNumber.setForeground(Color.white);
	
		if(m_game.m_constants.buttonBorderOn == true) {
			choice1.setBorder(m_game.m_constants.blackline);
			choice2.setBorder(m_game.m_constants.blackline);
			choice3.setBorder(m_game.m_constants.blackline);
			choice4.setBorder(m_game.m_constants.blackline);
			specialattack.setBorder(m_game.m_constants.blackline);
			//
			inGameOptionsButton.setBorder(m_game.m_constants.blackline);
			//
			inGameOptionsButtons[0].setBorder(m_game.m_constants.blackline);
			inGameOptionsButtons[1].setBorder(m_game.m_constants.blackline);
			inGameOptionsButtons[2].setBorder(m_game.m_constants.blackline);
			inGameOptionsButtons[3].setBorder(m_game.m_constants.blackline);
			inGameOptionsButtons[4].setBorder(m_game.m_constants.blackline);
			//
			inventoryButtons[0].setBorder(m_game.m_constants.blackline);	
			inventoryButtons[1].setBorder(m_game.m_constants.blackline);	
			inventoryButtons[2].setBorder(m_game.m_constants.blackline);	
			inventoryButtons[3].setBorder(m_game.m_constants.blackline);	
			inventoryButtons[4].setBorder(m_game.m_constants.blackline);	
			//
			inventoryButton.setBorder(m_game.m_constants.blackline);
			//
			for(int i = 0; i < 5; i++){
				inventoryButtons[i].setBorder(m_game.m_constants.blackline);
			}
			//
			for(int i = 0; i < backpackButtons.length; i++){
				backpackButtons[i].setBorder(m_game.m_constants.blackline);
			}
		}
		else if(m_game.m_constants.buttonBorderOn == false) {
			choice1.setBorder(null);
			choice2.setBorder(null);
			choice3.setBorder(null);
			choice4.setBorder(null);
			specialattack.setBorder(null);
			//
			inGameOptionsButton.setBorder(null);
			//
			inGameOptionsButtons[0].setBorder(null);
			inGameOptionsButtons[1].setBorder(null);
			inGameOptionsButtons[2].setBorder(null);
			inGameOptionsButtons[3].setBorder(null);
			inGameOptionsButtons[4].setBorder(null);
			//
			inventoryButtons[0].setBorder(null);	
			inventoryButtons[1].setBorder(null);	
			inventoryButtons[2].setBorder(null);	
			inventoryButtons[3].setBorder(null);	
			inventoryButtons[4].setBorder(null);	
			//
			inventoryButton.setBorder(null);
			//
			for(int i = 0; i < 5; i++){
				inventoryButtons[i].setBorder(null);
			}
			//
			for(int i = 0; i < backpackButtons.length; i++){
				backpackButtons[i].setBorder(null);
			}
		}
		
		if(m_game.m_constants.position.equals("noLoad")) {	
			m_game.m_story.gameover();	
		}	
		if(m_game.m_constants.position.equals("newGame")) {	
			m_game.m_story.playerSetup();	
		}	
		else if(m_game.m_constants.position.equals("loadData")) {	
			//statschange();	
			m_game.m_story.positionCheck();	
		}
		
		m_game.m_story.statschange();
		con.add(choiceButtonPanel);
		con.add(playerPanel);
		con.add(imagePanel);
		
		window.setVisible(true);
		
		setImage(m_game.m_constants.currentImage);
	}
	
	public void createFont() {
		m_game.m_constants.titleFontSize =  (int)Math.round(m_game.m_constants.currentScreenWidth * 0.0607476635514019);
		m_game.m_constants.normalFontSize  = (int)Math.round(m_game.m_constants.currentScreenWidth * 0.0261682242990654);
		m_game.m_constants.credits1FontSize = (int)Math.round(m_game.m_constants.currentScreenWidth * 0.0407476635514019);
		m_game.m_constants.credits2FontSize = (int)Math.round(m_game.m_constants.currentScreenWidth * 0.0307476635514019);
		m_game.m_constants.credits3FontSize = (int)Math.round(m_game.m_constants.currentScreenWidth * 0.0157476635514019);
		m_game.m_constants.backpackFontSize = (int)Math.round(m_game.m_constants.currentScreenWidth * 0.020);
		titleFont = new Font("Times New Roman", Font.PLAIN, Constants.titleFontSize);
		normalFont = new Font("Times New Roman", Font.PLAIN, Constants.normalFontSize);
		credits1Font = new Font("Times New Roman", Font.PLAIN, Constants.credits1FontSize);
		credits2Font = new Font("Times New Roman", Font.PLAIN, Constants.credits2FontSize);
		credits3Font = new Font("Times New Roman", Font.PLAIN, Constants.credits3FontSize);
		backpackFont = new Font("Times New Roman", Font.PLAIN, Constants.backpackFontSize);
	}

	public void setImage(URL ImageURL) {
		m_game.m_constants.currentImage = ImageURL;
		image = new ImageIcon(ImageURL);
		int image_w = (int)Math.round(m_game.m_constants.currentScreenWidth * 0.5555555555555556);
		int image_h = (int)Math.round(m_game.m_constants.currentScreenHeight * 0.5617977528089888);
		
		Image im = image.getImage().getScaledInstance(image_w, image_h, Image.SCALE_DEFAULT);
		image = new ImageIcon(im);
		imageLabel.setIcon(image);
	}

	public void backpack() {
		backpackPanel = new JPanel();
		int bp_y = 0;
		int bp_w = (int)Math.round(m_game.m_constants.currentScreenWidth * 0.5597014925373134);
		int bp_h = (int)Math.round(m_game.m_constants.currentScreenHeight * 0.4213483146067416);
		backpackPanel.setBounds(0, bp_y, bp_w, bp_h);
		backpackPanel.setBackground(Color.orange);
		backpackPanel.setLayout(new GridLayout(4, 4));
		con.add(backpackPanel);
		backpackPanel.setVisible(false);
		
		for (int i = 0; i < backpackButtons.length-1; i++) {
			backpackButtons[i] = new JButton();
			backpackButtons[i].setBackground(Color.black);
			backpackButtons[i].setForeground(Color.white);
			backpackButtons[i].setFont(normalFont);
			backpackButtons[i].setFocusPainted(false);
			backpackButtons[i].addActionListener(m_game.m_bHandler);
			backpackButtons[i].addActionListener(m_game.m_goHandler);
			backpackButtons[i].addActionListener(m_game.m_sHandler);
			backpackButtons[i].addActionListener(m_game.m_bpHandler);
			int buttonListener = i+1;
			backpackButtons[i].setActionCommand("backpackButton" + buttonListener);
			backpackPanel.add(backpackButtons[i]);
		}
		
		backpackButtons[15] = new JButton("SWITCH");
		backpackButtons[15].setBackground(Color.black);
		backpackButtons[15].setForeground(Color.white);
		backpackButtons[15].setFont(normalFont);
		backpackButtons[15].setFocusPainted(false);
		backpackButtons[15].addActionListener(m_game.m_bHandler);
		backpackButtons[15].addActionListener(m_game.m_goHandler);
		backpackButtons[15].addActionListener(m_game.m_sHandler);
		backpackButtons[15].addActionListener(m_game.m_bpHandler);
		backpackButtons[15].setActionCommand("backpackSwitchButton");
		backpackPanel.add(backpackButtons[15]);
		
		backpackTextAreaPanel = new JPanel();
		int btap_y = bp_y + bp_h;
		int btap_w = (int) Math.round(m_game.m_constants.currentScreenWidth * 0.555555556);
		int btap_h = (int) Math.round(m_game.m_constants.currentScreenHeight * 0.1404494382022472);
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
	
	public void inventory(int cbp_x, int cbp_w) {
		for (int i = 0; i < inventoryButtons.length; i++) {
			inventoryButtons[i] = new JButton();
			inventoryButtons[i].setBackground(Color.black);
			inventoryButtons[i].setForeground(Color.white);
			//itemButton1.setLayout(new GridLayout(5,1));
			inventoryButtons[i].setFont(m_game.m_ui.normalFont);
			inventoryButtons[i].setFocusPainted(false);
			inventoryButtons[i].addActionListener(m_game.m_iHandler);
			inventoryButtons[i].addActionListener(m_game.m_bHandler);
			inventoryButtons[i].addActionListener(m_game.m_sHandler);
			int lol = i+1;
			inventoryButtons[i].setActionCommand("item"+lol);
			
			sidePanel.add(inventoryButtons[i]);
		}
	}
	
	public void optionsButtons(int cbp_x, int cbp_w) {
		
		for (int i = 0; i < inGameOptionsButtons.length-1; i++) {
			inGameOptionsButtons[i] = new JButton();
			inGameOptionsButtons[i].setBackground(Color.black);
			inGameOptionsButtons[i].setForeground(Color.white);
			inGameOptionsButtons[i].setFont(normalFont);
			inGameOptionsButtons[i].setFocusPainted(false);
			inGameOptionsButtons[i].addActionListener(m_game.m_bHandler);
			inGameOptionsButtons[i].addActionListener(m_game.m_oHandler);
			inGameOptionsButtons[i].addActionListener(m_game.m_bpHandler);
			int buttonListener = i+1;
			inGameOptionsButtons[i].setActionCommand("option" + buttonListener);
		}
		
		inGameOptionsButtons[1].setText("FULLSCREEN");
		inGameOptionsButtons[2].setText("EXIT FULLSCREEN");
		inGameOptionsButtons[3].setText("EXIT GAME");

		inGameOptionsButtons[4] = new JButton("Show Backpack");
		inGameOptionsButtons[4].setBackground(Color.black);
		inGameOptionsButtons[4].setForeground(Color.white);
		//itemButton5.setLayout(new GridLayout(5,1));
		inGameOptionsButtons[4].setFont(backpackFont);
		inGameOptionsButtons[4].setFocusPainted(false);
		inGameOptionsButtons[4].addActionListener(m_game.m_oHandler);
		inGameOptionsButtons[4].addActionListener(m_game.m_bHandler);
		inGameOptionsButtons[4].addActionListener(m_game.m_bpHandler);
		inGameOptionsButtons[4].setActionCommand("backpack");
		
	}
	
	public void options() {
		m_game.m_constants.position = "options";
		titleNamePanel.setVisible(false);
		startButtonPanel.setVisible(false);
		try {
			inputPanel.setVisible(false);
			jtf.setVisible(false);	
			creditsPanel.setVisible(false);
			creditsTextAreaPanel.setVisible(false);
			creditsPanel2.setVisible(false);
		}
		catch(Exception e) {
			
		}
		
		optionsLabelPanel = new JPanel();
		optionsLabelPanel.setBackground(Color.blue);
		int olp_x = (int)Math.round(m_game.m_constants.currentScreenWidth * 0.2196261682242991);
		int olp_y = (int)Math.round(m_game.m_constants.currentScreenHeight * 0.1404494382022472);
		int olp_w = (int)Math.round(m_game.m_constants.currentScreenWidth * 0.5607476635514019);
		int olp_h = (int)Math.round(m_game.m_constants.currentScreenWidth * 0.0707476635514019);
		optionsLabelPanel.setBounds(olp_x, olp_y, olp_w, olp_h);
		//title
		optionsPanelLabel = new JLabel("OPTIONS");
		optionsPanelLabel.setForeground(Color.white);
		optionsPanelLabel.setFont(titleFont);
		optionsLabelPanel.add(optionsPanelLabel);
		
		//first panel
		optionsPanel = new JPanel();
		optionsPanel.setBackground(Color.red);
		int op_x = olp_x;
		int op_y = olp_y + olp_h + 20;
		int op_w = olp_w + 200;
		int op_h = (int)Math.round(m_game.m_constants.currentScreenWidth * 0.1007476635514019);
		optionsPanel.setBounds(op_x, op_y, op_w, op_h);
		optionsPanel.setLayout(new GridLayout(1,3));
		//full screen option
		fullScreenLabel = new JLabel("Full Screen is ");
		fullScreenLabel.setFont(normalFont);
		fullScreenLabel.setForeground(Color.white);
		optionsPanel.add(fullScreenLabel);
		//playerNameLabelString
		if(m_game.m_constants.fullScreenOn == true) {
			fullScreenLabelString = new JLabel("ON");
		}
		else if(m_game.m_constants.fullScreenOn == false) {
			fullScreenLabelString = new JLabel("OFF");
		}
		fullScreenLabelString.setFont(normalFont);
		fullScreenLabelString.setForeground(Color.white);
		optionsPanel.add(fullScreenLabelString);
		//hpLabel
		
		fullScreenButton = new JButton("Full Screen Toggle");
		fullScreenButton.setFont(normalFont);
		fullScreenButton.setForeground(Color.white);
		fullScreenButton.setBackground(Color.black);
		fullScreenButton.addActionListener(m_game.m_choiceHandler);
		fullScreenButton.addActionListener(m_game.m_bHandler);
		fullScreenButton.setFocusPainted(false);
		fullScreenButton.setActionCommand("fullScreen");
		optionsPanel.add(fullScreenButton);
		
		//second panel
		optionsPanel2 = new JPanel();
		optionsPanel2.setBackground(Color.red);
		int op2_x = op_x;
		int op2_y = op_y + op_h + 20;
		int op2_w = op_w;
		int op2_h = (int)Math.round(m_game.m_constants.currentScreenWidth * 0.1007476635514019);
		optionsPanel2.setBounds(op2_x, op2_y, op2_w, op2_h);
		optionsPanel2.setLayout(new GridLayout(1,3));
		
		buttonBorderLabel = new JLabel("Button borders are ");
		buttonBorderLabel.setFont(normalFont);
		buttonBorderLabel.setForeground(Color.white);
		optionsPanel2.add(buttonBorderLabel);
		
		if(m_game.m_constants.buttonBorderOn == true) {
			buttonBorderLabelString = new JLabel("ON");
		}
		else if(m_game.m_constants.buttonBorderOn == false) {
			buttonBorderLabelString = new JLabel("OFF");
		}
		buttonBorderLabelString.setFont(normalFont);
		buttonBorderLabelString.setForeground(Color.white);
		optionsPanel2.add(buttonBorderLabelString);
		
		buttonBorderButton = new JButton("Toggle Border");
		buttonBorderButton.setFont(normalFont);
		buttonBorderButton.setForeground(Color.white);
		buttonBorderButton.setBackground(Color.black);
		buttonBorderButton.addActionListener(m_game.m_bHandler);
		buttonBorderButton.setFocusPainted(false);
		buttonBorderButton.addActionListener(m_game.m_bHandler);
		buttonBorderButton.addActionListener(m_game.m_choiceHandler);
		buttonBorderButton.setActionCommand("buttonBorder");
		optionsPanel2.add(buttonBorderButton);
		
		backButtonPanel = new JPanel();
		int sbp_x = (int)Math.round(m_game.m_constants.currentScreenWidth * 0.4065420560747664);
		int sbp_y = (int)Math.round(m_game.m_constants.currentScreenHeight * 0.7017977528089888);
		int sbp_w = (int)Math.round(m_game.m_constants.currentScreenWidth * 0.1869158878504673);
		int sbp_h = (int)Math.round(1.5 * m_game.m_constants.currentScreenHeight * 0.1804494382022472);
		backButtonPanel.setBounds(sbp_x, sbp_y, sbp_w, sbp_h);
		//startButtonPanel.setBounds(300, 400, 200, 100);
		backButtonPanel.setBackground(Color.blue);
		
		backButton = new JButton("GO BACK");
		backButton.setFont(normalFont);
		backButton.setForeground(Color.white);
		backButton.setBackground(Color.black);
		backButton.setFocusPainted(false);
		backButton.addActionListener(m_game.m_bHandler);
		backButton.addActionListener(m_game.m_choiceHandler);
		backButton.setActionCommand("backTitle");
		backButtonPanel.add(backButton);
		
		con.add(optionsLabelPanel);
		con.add(optionsPanel);
		con.add(optionsPanel2);
		con.add(backButtonPanel);
	}

	public void credits() {
		m_game.m_constants.position = "credits";
		titleNamePanel.setVisible(false);
		startButtonPanel.setVisible(false);
		
		//credits panel title and label
		creditsPanel = new JPanel();
		creditsPanel.setBackground(Color.blue);
		int cp_x = (int)Math.round(m_game.m_constants.currentScreenWidth * 0.2196261682242991);
		int cp_y = (int)Math.round(m_game.m_constants.currentScreenHeight * 0.1404494382022472);
		int cp_w = (int)Math.round(m_game.m_constants.currentScreenWidth * 0.5607476635514019);
		int cp_h = (int)Math.round(m_game.m_constants.currentScreenWidth * 0.0707476635514019);
		//int cp_h = (int)Math.round(currentScreenHeight * 0.2106741573033708);
		creditsPanel.setBounds(cp_x, cp_y, cp_w, cp_h);
		//title
		creditsPanelLabel = new JLabel("CREDITS");
		creditsPanelLabel.setForeground(Color.white);
		creditsPanelLabel.setFont(titleFont);
		creditsPanel.add(creditsPanelLabel);
		
		//Vismay Name
		creditsTextAreaPanel = new JPanel();
		creditsTextAreaPanel.setBackground(Color.red);
		int ctap_x = cp_x;
		int ctap_y = cp_y + cp_h + (int)Math.round(m_game.m_constants.currentScreenWidth * 0.0280898876404494);
		int ctap_w = cp_w;
		int ctap_h = (int)Math.round(m_game.m_constants.currentScreenWidth * 0.1123595505617978);
		creditsTextAreaPanel.setBounds(ctap_x, ctap_y, ctap_w, ctap_h);
		con.add(creditsTextAreaPanel);
		
		creditsTextArea = new JTextArea("Creator: Vismay Patel");
		creditsTextArea.setForeground(Color.white);
		creditsTextArea.setBackground(Color.red);
		creditsTextArea.setFont(credits1Font);
		creditsTextArea.setEditable(false);
		creditsTextAreaPanel.add(creditsTextArea);
		
		//other peoples name
		creditsPanel2 = new JPanel();
		creditsPanel2.setBackground(Color.green);
		int ctap2_x = cp_x;
		int ctap2_y = ctap_y + ctap_h;
		int ctap2_w = cp_w;
		int ctap2_h = (int)Math.round(m_game.m_constants.currentScreenWidth * 0.4213483146067416);
		creditsPanel2.setBounds(ctap2_x, ctap2_y, ctap2_w, ctap2_h);
		
		creditsPanelLabel2 = new JLabel("Artist: [BLANK]");
		creditsPanelLabel2.setFont(credits2Font);
		creditsPanelLabel2.setForeground(Color.white);
		creditsPanel2.add(creditsPanelLabel2);
		
		creditsPanelLabel3 = new JLabel("Sound Creator: Shyam Arumugam");
		creditsPanelLabel3.setFont(credits2Font);
		creditsPanelLabel3.setForeground(Color.white);
		creditsPanel2.add(creditsPanelLabel3);
		
		creditsPanelLabel4 = new JLabel("Tester: [BLANK]");
		creditsPanelLabel4.setFont(credits2Font);
		creditsPanelLabel4.setForeground(Color.white);
		creditsPanel2.add(creditsPanelLabel4);
		
		creditsPanelLabel5 = new JLabel("Special Thanks to RyiSnow on YouTube for the videos that made this game possible!");
		creditsPanelLabel5.setFont(credits3Font);
		creditsPanelLabel5.setForeground(Color.white);
		creditsPanel2.add(creditsPanelLabel5);
		
		creditsBackButton = new JButton("BACK");
		creditsBackButton.setFont(normalFont);
		creditsBackButton.setBackground(Color.black);
		creditsBackButton.setForeground(Color.white);
		creditsBackButton.addActionListener(m_game.m_bHandler);
		creditsBackButton.addActionListener(m_game.m_choiceHandler);
		creditsBackButton.setFocusPainted(false);
		creditsBackButton.setBorderPainted(false);
		creditsBackButton.setActionCommand("backTitle");
		creditsPanel2.add(creditsBackButton);
		
		
		con.add(creditsPanel);	
		con.add(creditsPanel2);
		
	}

}