package package01;

import package03.Apple;
import package03.ChocolateBar;
import package03.Empty;
import package03.Potion;
import package03.SuperItem;

public class Backpack {
	
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
	
	public void updateBackpack(int number) {
		m_inventory.updateInventory();
		if(number == 1) {
			if(m_constants.switchOn == true) m_ui.backpackTextArea.setText("Please select the item to move to your inventory.");
			else m_ui.backpackTextArea.setText("Press Switch to move an item to your inventory. \nIf you do not have any space, the item will be dropped");
			//
			for(int i = 0; i < m_ui.backpackButtons.length; i++) {
				m_ui.backpackButtons[i].setText(m_player.backpackItem[i].name);
			}
			//
		}
		
		if(number == 0) {
			m_ui.backpackTextArea.setText("Not a valid selection, please try again.");
			//
			for(int i = 0; i < m_ui.backpackButtons.length; i++) {
				m_ui.inGameOptionsButtons[i].setText(m_player.backpackItem[i].name);
			}
			//
		}
		
	}

	public void backpackSwitch(int slotNumber) {
		updateBackpack(1);
		switch(m_player.backpackItem[slotNumber].name) {
			case "Potion":  m_player.backpackItem[slotNumber] = new Empty(); m_inventory.addInventoryItem(new Potion()); m_ui.backpackTextArea.setText("Press Switch to move an item to your inventory. If you do not have any space, the item will be dropped"); updateBackpack(1); break;
			case "C. Bar": m_player.backpackItem[slotNumber] = new Empty(); m_inventory.addInventoryItem(new ChocolateBar()); m_ui.backpackTextArea.setText("Press Switch to move an item to your inventory. If you do not have any space, the item will be dropped"); updateBackpack(1); break;
			case "Apple": m_player.backpackItem[slotNumber] = new Empty(); m_inventory.addInventoryItem(new Apple()); m_ui.backpackTextArea.setText("Press Switch to move an item to your inventory. If you do not have any space, the item will be dropped"); updateBackpack(1); break;
			case "[Empty]": updateBackpack(0); break;
		}
	}
	
	public void addBackpackItem(SuperItem item) {
		int slotNumber = 0;
		while(m_player.backpackItem[slotNumber] != new Empty() && slotNumber < 14) slotNumber++;
		if(slotNumber == 14 && m_player.backpackItem[14] != new Empty()) noEmptySlots(item);
		
		else {
			if(m_player.backpackItem[slotNumber] == new Empty()) m_player.backpackItem[slotNumber] = item;
			else if (!m_player.backpackItem[slotNumber].name.equals("[Empty]")) noEmptySlots(item);
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
		for(int i = 0; i < m_player.backpackItem.length; i++) {
			if(m_player.backpackItem[i].isDroppable() == true) {
				m_player.backpackItem[i] = item;
				i = m_player.backpackItem.length;
			}
		}
		m_ui.backpackTextArea.setText("You have no more space. An "+ item.name +" will be dropped.");
	}
}
