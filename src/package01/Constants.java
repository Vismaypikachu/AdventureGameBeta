package package01;

import java.awt.Color;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class Constants {
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
	
	public URL clickSoundURL = getClass().getResource("ButtonPress.wav");
	public URL titleTrackURL = getClass().getResource("titleTrack.wav");
	public URL innTrackURL = getClass().getResource("innTrack.wav");
	public URL testImageURL = getClass().getResource("test.png");
	public URL currentMusic;
	public static boolean musicOn = false;
	/*
	public void initializeSounds() {
		//clickSoundURL = getClass().getResource("ButtonPress.wav");
		titleTrackURL = getClass().getResource("TitleTrack.wav");
		//innTrackURL = getClass().getResource("InnTrack.wav");
		//testImageURL = getClass().getResource("test.png");
	}*/
}