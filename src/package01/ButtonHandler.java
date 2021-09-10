package package01;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonHandler implements ActionListener {
	
	Constants m_constants = new Constants();
	SoundEffect m_se = new SoundEffect();
	
	public void actionPerformed(ActionEvent event) {
		m_se.setURL(m_constants.clickSoundURL);
		m_se.play();
	}
}