package package01;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

public class Images {
	
	ImageIcon PlayerIcon, HealthIcon, WeaponIcon, GoldIcon, XPIcon, AttackIcon, DefenseIcon, CapsulesIcon;
	
	UI m_ui;
	Constants m_constants = new Constants(m_ui);
	
	
	public Images(UI userInterface) {
		m_ui = userInterface;
	}
	
	public void initializeImages() {
		//icons
		int iconwidth = (int) Math.round(m_constants.currentScreenWidth * 0.03592592592592592592592592592593);
		int iconheight = (int) Math.round(m_constants.currentScreenWidth * 0.032932584269662921348314606741573);
		
		PlayerIcon = new ImageIcon(getClass().getClassLoader().getResource("PlayerIcon.png"));
		Image image = PlayerIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(iconwidth, iconheight,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		PlayerIcon = new ImageIcon(newimg);  // transform it back
		
		HealthIcon = new ImageIcon(getClass().getClassLoader().getResource("HealthIcon.png"));
		Image image2 = HealthIcon.getImage();
		Image newimg2 = image2.getScaledInstance(iconwidth, iconheight,  java.awt.Image.SCALE_SMOOTH);
		HealthIcon = new ImageIcon(newimg2);
		
		WeaponIcon = new ImageIcon(getClass().getClassLoader().getResource("SwordIcon.png"));
		Image image3 = WeaponIcon.getImage();
		Image newimg3 = image3.getScaledInstance(iconwidth, iconheight,  java.awt.Image.SCALE_SMOOTH);
		WeaponIcon = new ImageIcon(newimg3);
		
		GoldIcon = new ImageIcon(getClass().getClassLoader().getResource("GoldIcon.png"));
		Image image4 = GoldIcon.getImage();
		Image newimg4 = image4.getScaledInstance(iconwidth, iconheight,  java.awt.Image.SCALE_SMOOTH);
		GoldIcon = new ImageIcon(newimg4);

		XPIcon = new ImageIcon(getClass().getClassLoader().getResource("XPIcon.png"));
		Image image5 = XPIcon.getImage();
		Image newimg5 = image5.getScaledInstance(iconwidth, iconheight,  java.awt.Image.SCALE_SMOOTH);
		XPIcon = new ImageIcon(newimg5);
		
		AttackIcon = new ImageIcon(getClass().getClassLoader().getResource("AttackIcon.png"));
		Image image6 = AttackIcon.getImage();
		Image newimg6 = image6.getScaledInstance(iconwidth, iconheight,  java.awt.Image.SCALE_SMOOTH);
		AttackIcon = new ImageIcon(newimg6);
		
		DefenseIcon = new ImageIcon(getClass().getClassLoader().getResource("DefenseIcon.png"));
		Image image7 = DefenseIcon.getImage();
		Image newimg7 = image7.getScaledInstance(iconwidth, iconheight,  java.awt.Image.SCALE_SMOOTH);
		DefenseIcon = new ImageIcon(newimg7);
		
		CapsulesIcon = new ImageIcon(getClass().getClassLoader().getResource("CapsulesIcon.png"));
		Image image8 = CapsulesIcon.getImage();
		Image newimg8 = image8.getScaledInstance(iconwidth, iconheight,  java.awt.Image.SCALE_SMOOTH);
		CapsulesIcon = new ImageIcon(newimg8);
	}
}