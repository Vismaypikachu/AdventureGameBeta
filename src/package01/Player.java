package package01;

import package02.SuperWeapon;
import package03.Empty;
import package03.SuperItem;

public class Player {
	
	UI m_ui;
	Constants m_constants;
	
	public static String playerName;
	public static int playerHP;
	public static SuperWeapon weapon;
	public static int gold;
	public static int xp;
	public static int playerdefense;
	public static int capsules;
	public static boolean specialUnlocked;
	public static SuperItem [] playerItem = new SuperItem[5];
	public static SuperItem [] backpackItem = new SuperItem[15];
	
	public Player(UI userInterface, Constants c) {
		m_ui = userInterface;
		m_constants = c;
	}
	
	public void itemUsed(int slotNumber) {
		switch(playerItem[slotNumber].name) {
			case "Potion": 
				playerHP += 20; 
				m_ui.m_story.statschange();
				playerItem[slotNumber] = new Empty();
			break;
			case "Fork": 
				m_constants.forkUsed = true;
				playerHP -= 10; 
				m_ui.m_story.statschange();
				playerItem[slotNumber] = new Empty();
			break;
			case "C. Bar": 
				playerHP += 10; 
				m_ui.m_story.statschange();
				playerItem[slotNumber] = new Empty();
			break;
			case "Apple":
				playerHP += 15;
				m_ui.m_story.statschange();
				playerItem[slotNumber] = new Empty();
			break;
		}	
	}
}
