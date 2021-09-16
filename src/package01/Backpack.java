package package01;

import package03.Apple;
import package03.ChocolateBar;
import package03.Empty;
import package03.Potion;
import package03.SuperItem;

public class Backpack {
	/*
	game m_game;
	UI m_ui;
	Constants m_constants;
	Inventory m_inventory;
	Player m_player = new Player(m_ui, m_constants);
	
	public Backpack(game g, Constants c, UI userInterface, Inventory i) {
		m_game = g;
		m_constants = c;
		m_ui = userInterface;
		m_inventory = i;
	}
	*/
	
	game m_game;
	
	public Backpack(game g) {
		m_game = g;
	}
	
	public void updateBackpack(int number) {
		m_game.m_inventory.updateInventory();
		if(number == 1) {
			if(m_game.m_constants.switchOn == true) m_game.m_ui.backpackTextArea.setText("Please select the item to move to your inventory.");
			else m_game.m_ui.backpackTextArea.setText("Press Switch to move an item to your inventory. \nIf you do not have any space, the item will be dropped");
			//
			for(int i = 0; i < m_game.m_ui.backpackButtons.length-1; i++) {
				m_game.m_ui.backpackButtons[i].setText(m_game.m_player.backpackItem[i].name);
			}
			//
		}
		
		if(number == 0) {
			m_game.m_ui.backpackTextArea.setText("Not a valid selection, please try again.");
			//
			for(int i = 0; i < m_game.m_ui.backpackButtons.length-1; i++) {
				m_game.m_ui.backpackButtons[i].setText(m_game.m_player.backpackItem[i].name);
			}
			//
		}	
		
	}

	public void backpackSwitch(int slotNumber) {
		updateBackpack(1);
		switch(m_game.m_player.backpackItem[slotNumber].name) {
			case "Potion":  m_game.m_player.backpackItem[slotNumber] = new Empty(); m_game.m_inventory.addInventoryItem(new Potion()); m_game.m_ui.backpackTextArea.setText("Press Switch to move an item to your inventory. If you do not have any space, the item will be dropped"); updateBackpack(1); break;
			case "C. Bar": m_game.m_player.backpackItem[slotNumber] = new Empty(); m_game.m_inventory.addInventoryItem(new ChocolateBar()); m_game.m_ui.backpackTextArea.setText("Press Switch to move an item to your inventory. If you do not have any space, the item will be dropped"); updateBackpack(1); break;
			case "Apple": m_game.m_player.backpackItem[slotNumber] = new Empty(); m_game.m_inventory.addInventoryItem(new Apple()); m_game.m_ui.backpackTextArea.setText("Press Switch to move an item to your inventory. If you do not have any space, the item will be dropped"); updateBackpack(1); break;
			case "[Empty]": updateBackpack(0); break;
		}
	}
	
	public void addBackpackItem(SuperItem item) {
		int slotNumber = 0;
		while(!m_game.m_player.backpackItem[slotNumber].name.equals("[Empty]") && slotNumber < 14) slotNumber++;
		if(slotNumber == 14 && m_game.m_player.backpackItem[14] != new Empty()) noEmptySlots(item);
		
		else {
			if(m_game.m_player.backpackItem[slotNumber].name.equals("[Empty]")) m_game.m_player.backpackItem[slotNumber] = item;
			else if (!m_game.m_player.backpackItem[slotNumber].name.equals("[Empty]")) noEmptySlots(item);
		}
	}
	
	public void noEmptySlots(SuperItem item) {
		/*
		int num = 0;
		while(num < 15) {
			switch(backpackItem[num].name) {
				case "Potion": backpackItem[num].name = item.name; num = 15; break;
				case "Apple": backpackItem[num].name = item.name; num = 15; break;
				case "C. Bar": backpackItem[num].name = item.name; num = 15; break;
			}
		}
		*/
		for(int i = 0; i < m_game.m_player.backpackItem.length; i++) {
			if(m_game.m_player.backpackItem[i].isDroppable() == true) {
				m_game.m_player.backpackItem[i] = item;
				i = m_game.m_player.backpackItem.length;
			}
		}
		m_game.m_ui.backpackTextArea.setText("You have no more space. An "+ item.name +" will be dropped.");
	}
}
