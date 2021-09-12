package package01;

import package02.SuperWeapon;
import package03.SuperItem;

public class Player {
	
	public String playerName;
	public int playerHP;
	public SuperWeapon weapon;
	public int gold;
	public int xp;
	public int playerdefense;
	public int capsules;
	public boolean specialUnlocked;
	SuperItem [] playerItem = new SuperItem[5];
	SuperItem [] backpackItem = new SuperItem[15];
}
