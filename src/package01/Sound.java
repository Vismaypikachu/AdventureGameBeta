package package01;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {
	
	Clip clip;
	//String clickSound, titleTrack, innTrack;
	UI m_ui;
	Constants m_constants = new Constants(m_ui);
	
	public Sound(UI userInterface) {
		m_ui = userInterface;
	}
	
	public void setMusic(URL fileName) {
		if(m_constants.musicOn == false){
			setURL(fileName);
			m_constants.currentMusic = fileName;
			play();
			loop();
		}
		else if(m_constants.musicOn == true && !fileName.equals(m_constants.currentMusic)){
			stop();
			m_constants.currentMusic = fileName;
			m_constants.musicOn = true;
			setURL(fileName);
			play();
			loop();
		}
		else {
			
		}
	}		
		
	public void setURL(URL soundFileName) {
		try {
			//File file = new File(soundFileName);
			AudioInputStream sound = AudioSystem.getAudioInputStream(soundFileName);
			clip = AudioSystem.getClip();
			clip.open(sound);
		}
		catch(Exception e) {
			
		}
	}
	
	public void play() {
		m_constants.musicOn = true;
		clip.setFramePosition(0);
		clip.start();
		
	}
	
	public void loop() {
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	public void stop() {
		m_constants.musicOn = false;
		clip.setFramePosition(0);
		clip.loop(-1);
		clip.stop();
		clip.close();
	}

}