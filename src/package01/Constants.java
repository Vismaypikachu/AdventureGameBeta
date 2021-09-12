package package01;

import java.awt.Color;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

import package02.None;
import package03.Potion;

public class Constants {
	Player m_player = new Player();
	
	//UI
	public static int currentScreenWidth = 1070;
	public static int currentScreenHeight = 712;
	public static boolean buttonBorderOn = false;
	//FONT
	public static int titleFontSize = (int)Math.round(currentScreenWidth * 0.0607476635514019);
	public static int normalFontSize = (int)Math.round(currentScreenWidth * 0.0261682242990654);
	public static int credits1FontSize = (int)Math.round(currentScreenWidth * 0.0407476635514019);
	public static int credits2FontSize = (int)Math.round(currentScreenWidth * 0.0307476635514019);
	public static int credits3FontSize = (int)Math.round(currentScreenWidth * 0.0157476635514019);
	public static int backpackFontSize = (int)Math.round(currentScreenWidth * 0.020);
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
	//MISC
	public static int inputcount, bisonCount, Ecount, timesGiven;
	public static boolean inBattle, forkUsed, switchOn;
	/*
	public void initializeSounds() {
		//clickSoundURL = getClass().getResource("ButtonPress.wav");
		titleTrackURL = getClass().getResource("TitleTrack.wav");
		//innTrackURL = getClass().getResource("InnTrack.wav");
		//testImageURL = getClass().getResource("test.png");
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
		
		m_player.playerHP = 100;
		m_player.weapon = new None();
		m_player.playerHP = 100;
		m_player.gold = 0;
		m_player.xp = 0;
		InventoryStatus = "close";
		OptionsStatus = "close";
		BackpackStatus = "close";
		m_player.playerdefense = 0;
		m_player.capsules = 0;
		savedPosition = "";
		
		m_player.backpackItem [0] = new Potion();
	}
}