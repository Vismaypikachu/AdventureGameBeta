package package01;

import package02.SuperWeapon;
import package03.Empty;
import package03.SuperItem;

public class Player {
	
	UI m_ui;
	Constants m_constants;
	
	public String playerName;
	public int playerHP;
	public SuperWeapon weapon;
	public int gold;
	public int xp;
	public int playerdefense;
	public int capsules;
	public boolean specialUnlocked;
	public SuperItem [] playerItem = new SuperItem[5];
	public SuperItem [] backpackItem = new SuperItem[15];
	
	public Player(UI userInterface, Constants c) {
		m_ui = userInterface;
		m_constants = c;
	}
	
	public void itemUsed(int slotNumber) {
		switch(playerItem[slotNumber].name) {
			case "Potion": 
				playerHP += 20; 
				m_ui.statschange();
				playerItem[slotNumber] = new Empty();
			break;
			case "Fork": 
				m_constants.forkUsed = true;
				playerHP -= 10; 
				m_ui.statschange();
				playerItem[slotNumber] = new Empty();
			break;
			case "C. Bar": 
				playerHP += 10; 
				m_ui.statschange();
				playerItem[slotNumber] = new Empty();
			break;
			case "Apple":
				playerHP += 15;
				m_ui.statschange();
				playerItem[slotNumber] = new Empty();
			break;
		}	
	}
}
