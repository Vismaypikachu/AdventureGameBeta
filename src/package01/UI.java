package package01;

import java.util.*;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class UI {
	
	JFrame window;
	Container con;
	JPanel titleNamePanel, startButtonPanel, optionsPanel, optionsPanel2, optionsLabelPanel, backButtonPanel, creditsTextAreaPanel, creditsPanel, creditsPanel2;
	JPanel mainTextPanel, choiceButtonPanel, inventoryPanel, playerPanel, imagePanel, counterPanel, inGameOptionsPanel;
	JLabel titleNameLabel;
	JButton startButton, loadButton, creditsButton, optionsButton;
	
	Font titleFont, normalFont, credits1Font, credits2Font, credits3Font, backpackFont;
	
	Random r = new Random();
	
	Enemy m_enemy = new Enemy();
	Constants m_constants = new Constants();
	Sound m_sound = new Sound();
	Images m_images = new Images(this);
	
	
	GraphicsDevice gDevice;
	
	ChoiceHandler m_choiceHandler;
	ButtonHandler bHandler = new ButtonHandler();
	
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
	
	public void createFont() {
		titleFont = new Font("Times New Roman", Font.PLAIN, Constants.titleFontSize);
		normalFont = new Font("Times New Roman", Font.PLAIN, Constants.normalFontSize);
		credits1Font = new Font("Times New Roman", Font.PLAIN, Constants.credits1FontSize);
		credits2Font = new Font("Times New Roman", Font.PLAIN, Constants.credits2FontSize);
		credits3Font = new Font("Times New Roman", Font.PLAIN, Constants.credits3FontSize);
		backpackFont = new Font("Times New Roman", Font.PLAIN, Constants.backpackFontSize);
	}

}