package package01;

import package02.SuperWeapon;
import package03.Empty;
import package03.SuperItem;

public class Player {
	
	public static String playerName;
	public static int playerHP;
	public static SuperWeapon weapon;
	public static SuperItem fishingRod;
	public static int gold;
	public static int xp;
	public static double playerdefense;
	public static int capsules;
	public static boolean specialUnlocked;
	public static SuperItem [] playerItem = new SuperItem[5];
	public static SuperItem [] backpackItem = new SuperItem[15];
	public static SuperItem backup;
	public static String playerType;
	
	game m_game;
	
	public Player(game g) {
		m_game = g;
	}
	
	public void itemUsed(int slotNumber) {
		if(playerItem[slotNumber].useable == true && playerItem[slotNumber].itemType.equals("Food")) {			
			playerHP += playerItem[slotNumber].stat;
			m_game.m_story.statschange();
			playerItem[slotNumber] = new Empty();
		}
		else {
			
		}
	}
}
