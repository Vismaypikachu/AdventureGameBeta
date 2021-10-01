package package01;

import java.awt.Color;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.Timer;
import javax.swing.border.Border;

import package02.None;
import package03.Empty;
import package03.Potion;
import package05.SuperEnemy;

public class Constants {
	
	game m_game;
	
	public Constants(game g) {
		m_game = g;
	}
	/*
	UI m_ui;
	Player m_player = new Player(m_ui, this);
	*/
	
	//UI
	public static int currentScreenWidth = 1070;
	public static int currentScreenHeight = 712;
	public static boolean buttonBorderOn = false;;
	//FONT
	public static int titleFontSize;
	public static int normalFontSize;
	public static int credits1FontSize;
	public static int credits2FontSize;
	public static int credits3FontSize;
	public static int backpackFontSize;
	public static Border blackline = BorderFactory.createLineBorder(Color.white);
	//SOUND
	public URL clickSoundURL = getClass().getResource("/ButtonPress.wav");
	public URL titleTrackURL = getClass().getResource("/titleTrack.wav");
	public URL innTrackURL = getClass().getResource("/innTrack.wav");
	public URL currentMusic;
	public static boolean musicOn = false;
	//IMAGES
	public URL testImageURL = getClass().getResource("/test.png");
	public URL currentImage;
	//STATUS
	public static String InventoryStatus;
	public static String OptionsStatus;
	public static String BackpackStatus;
	public static boolean fullScreenOn;
	//BUTTONS
	public static String text, b1text, b2text, b3text, b4text, b5text;
	//ENEMIES
	public static SuperEnemy currentEnemy;
	//MISC
	public static int inputcount, bisonCount, second, Ncount, Ecount, timesGiven;
	public static boolean inBattle, forkUsed, switchOn;
	public static String position, savedPosition, enemyPosition, fishingPosition;
	public static Timer timer;
	//BIOME
	public static boolean saltySea, shallows;
	
	/*
	public void initializeSounds() {
		//clickSoundURL = getClass().getResource("ButtonPress.wav");
		titleTrackURL = getClass().getResource("TitleTrack.wav");
		//innTrackURL = getClass().getResource("InnTrack.wav");
		//testImageURL = getClass().getResource("test.png");
	}
	
	
	public Constants(UI userInterface) {
		m_ui = userInterface;
	}
	*/
	public void reinitializeVars() {
		inputcount = 0;
		inBattle = false;
		timesGiven = 0;
		bisonCount = 0;
		Ecount = 0;
		forkUsed = false;
		switchOn = false;
		saltySea = false;
		shallows = false;
		
		m_game.m_player.playerHP = 100;
		m_game.m_player.weapon = new None();
		m_game.m_player.fishingRod = new Empty();
		m_game.m_player.playerHP = 100;
		m_game.m_player.gold = 20;
		m_game.m_player.xp = 0;
		m_game.m_player.playerdefense = 0;
		m_game.m_player.capsules = 0;
		InventoryStatus = "close";
		OptionsStatus = "close";
		BackpackStatus = "close";
		savedPosition = "";
		
		m_game.m_player.playerItem[0] = new Potion();
		for(int i = 1; i < m_game.m_player.playerItem.length; i++) m_game.m_player.playerItem[i] = new Empty();
		for(int i = 0; i < m_game.m_player.backpackItem.length; i++) m_game.m_player.backpackItem[i] = new Empty();
	}
}