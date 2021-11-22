package package01;

import package03.Apple;
import package03.ChocolateBar;
import package03.Empty;
import package03.Fish;
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
	
	public void updateBackpack() {
		//Update NAV Header
		switch(m_game.m_constants.currentBackpackFrame) {
			case 0: m_game.m_ui.backpackNavigationLabel.setText("Food Items"); break;
			case 1: m_game.m_ui.backpackNavigationLabel.setText("Equipment"); break;
			case 2: m_game.m_ui.backpackNavigationLabel.setText("Key Items"); break;
		}
		
		//Update Buttons
		for(int i = 0; i < m_game.m_ui.backpackButtons.length-1; i++) {
			m_game.m_ui.backpackButtons[i].setText(m_game.m_player.backpackItem[getFrame(i)].name);
		}	
	}

	
	public void displayTextResult(int number) {
		if(number == 0) {
			m_game.m_ui.backpackTextArea.setText("Not a valid selection, please try again.");
		}
		else if(number == 1) {
			if(m_game.m_constants.switchOn == true) m_game.m_ui.backpackTextArea.setText("Please select the item to move to your inventory.");
			else if(m_game.m_constants.switchOn == false) m_game.m_ui.backpackTextArea.setText("Press Switch to move an item to your inventory. \nIf you do not have any space, the item will be dropped");
		}
	}
	
	public void backpackSwitch(int slotNumber) {
		slotNumber = m_game.m_backpack.getFrame(slotNumber);
		if(m_game.m_player.backpackItem[slotNumber].droppable == false) {
			displayTextResult(0);
		}
		else if(m_game.m_player.backpackItem[slotNumber].droppable == true){
			switch(m_game.m_player.backpackItem[slotNumber].name) {
				case "Potion":  m_game.m_player.backpackItem[slotNumber] = new Empty(); m_game.m_inventory.addInventoryItem(new Potion()); displayTextResult(1); break;
				case "C. Bar": m_game.m_player.backpackItem[slotNumber] = new Empty(); m_game.m_inventory.addInventoryItem(new ChocolateBar());  displayTextResult(1); break;
				case "Apple": m_game.m_player.backpackItem[slotNumber] = new Empty(); m_game.m_inventory.addInventoryItem(new Apple()); displayTextResult(1); break;
				case "Fish": m_game.m_player.backpackItem[slotNumber] = new Empty(); m_game.m_inventory.addInventoryItem(new Fish()); displayTextResult(1); break;
				//case "[Empty]": m_game.m_player.backpackItem[slotNumber] = new Empty(); m_game.m_inventory.addInventoryItem(new Empty()); checkSwitch(0); break;
			}
		}
	}
	
	public void addBackpackItem(SuperItem item) {
		//add Food Type
		if(item.itemType.equals("Food")) {
			int slotNumber = 0;
			while(!m_game.m_player.backpackItem[slotNumber].name.equals("[Empty]") && slotNumber < 14) slotNumber++;
			if(slotNumber == 14 && !m_game.m_player.backpackItem[14].name.equals("[Empty]")) noEmptySlots(item);
			
			else {
				if(m_game.m_player.backpackItem[slotNumber].name.equals("[Empty]")) {
					m_game.m_player.backpackItem[slotNumber] = item;
					displayTextResult(1);
				}
				else if (!m_game.m_player.backpackItem[slotNumber].name.equals("[Empty]")) noEmptySlots(item);
			}
		}
		//add Equipment Type
		if(item.itemType.equals("Equipment")) {
			int slotNumber = 15;
			while(!m_game.m_player.backpackItem[slotNumber].name.equals("[Empty]") && slotNumber < 29) slotNumber++;
			if(slotNumber == 29 && !m_game.m_player.backpackItem[29].name.equals("[Empty]")) noEmptySlots(item);
			
			else {
				if(m_game.m_player.backpackItem[slotNumber].name.equals("[Empty]")) {
					m_game.m_player.backpackItem[slotNumber] = item;
					displayTextResult(1);
				}
				else if (!m_game.m_player.backpackItem[slotNumber].name.equals("[Empty]")) noEmptySlots(item);
			}
		}
		//add Key Item Type
		if(item.itemType.equals("Key")) {
			int slotNumber = 30;
			while(!m_game.m_player.backpackItem[slotNumber].name.equals("[Empty]") && slotNumber < 45) slotNumber++;
			if(slotNumber == 45 && !m_game.m_player.backpackItem[45].name.equals("[Empty]")) noEmptySlots(item);	
			else {
				if(m_game.m_player.backpackItem[slotNumber].name.equals("[Empty]")) {
					m_game.m_player.backpackItem[slotNumber] = item;
					displayTextResult(1);
				}
				else if (!m_game.m_player.backpackItem[slotNumber].name.equals("[Empty]")) noEmptySlots(item);
			}
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
		if(m_game.m_constants.BackpackStatus.equals("close")) {
			m_game.m_ui.backpackButton.doClick();
		}
		m_game.m_ui.backpackTextArea.setText("YOU HAVE NO MORE SPACE. An item will need to be dropped to add " + item.name + ".\nPlease click the item to drop!");
		m_game.m_player.backup = item;
		m_game.m_ui.backpackDropButton.setText("Drop Item (ON)");
		m_game.m_constants.switchOn = false;
		m_game.m_constants.DropStatus = true;
		m_game.m_ui.choiceButtonPanel.setVisible(false);
		m_game.m_ui.sidePanel.setVisible(false);
		m_game.m_constants.InventoryStatus = "close";
		m_game.m_constants.OptionsStatus = "close";
		
		/*
		for(int i = 0; i < m_game.m_player.backpackItem.length; i++) {
			if(m_game.m_player.backpackItem[i].droppable = true) {
				m_game.m_player.backpackItem[i] = item;
				i = m_game.m_player.backpackItem.length;
			}
		}
		*/
		
		
		
	}

	public void displayStats(int i) {
		String name = m_game.m_player.backpackItem[getFrame(i)].name;
		String stat = m_game.m_player.backpackItem[getFrame(i)].displayStat;
		String description = m_game.m_player.backpackItem[getFrame(i)].description;
		m_game.m_ui.backpackStatsTextArea.setText("Name: " + name + "\nStat: " + stat + "\nDescription: \n" + description);
	}

	public int getFrame(int x) {
		if(m_game.m_constants.currentBackpackFrame == 0) {
			return x;
		}
		else if(m_game.m_constants.currentBackpackFrame == 1) {
			return x+15;
		}
		else if(m_game.m_constants.currentBackpackFrame == 2) {
			return x+30;
		}
		else {
			return 0;
		}
	}

	public boolean contains(SuperItem item) {
		boolean contains = false;
		
		for(int i = 0; i < m_game.m_player.backpackItem.length; i++) {
			if(m_game.m_player.backpackItem[i].name.equals(item.name)) {
				contains = true;
			}
		}
		return contains;
	}
}
