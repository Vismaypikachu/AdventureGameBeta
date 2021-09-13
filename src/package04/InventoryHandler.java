package package04;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import package01.Constants;
import package01.Inventory;
import package01.Player;
import package01.UI;
import package01.game;

public class InventoryHandler implements ActionListener{
	
	game m_game;
	UI m_ui;
	Constants m_constants;
	Player m_player = new Player(m_ui, m_constants);
	Inventory m_inventory;
	
	public InventoryHandler(UI userInterface, game g, Constants c, Inventory i) {
		m_ui = userInterface;
		m_game = g;
		m_constants = c;
		m_inventory = i;
	}
	
	public void actionPerformed(ActionEvent event) {
		String yourChoice = event.getActionCommand();

		switch(yourChoice) {
			case "inventoryButton": 
				if(m_constants.InventoryStatus.equals("close")) {
					m_ui.choice1.setVisible(false);
					m_ui.choice2.setVisible(false);
					m_ui.choice3.setVisible(false);
					m_ui.choice4.setVisible(false);
					m_ui.specialattack.setVisible(false);
					m_ui.inGameOptionsButton.setVisible(false);
					m_ui.inventoryPanel.setVisible(true);
					//
					m_inventory.updateInventory();
					//
					m_constants.InventoryStatus = "open";
				}
				else if(m_constants.InventoryStatus.equals("open")) {
					m_ui.choice1.setVisible(true);
					m_ui.choice2.setVisible(true);
					m_ui.choice3.setVisible(true);
					m_ui.choice4.setVisible(true);
					m_ui.specialattack.setVisible(true);
					if(m_constants.inBattle == false) m_ui.inGameOptionsButton.setVisible(true);
					else m_ui.inGameOptionsButton.setVisible(false);
					m_ui.inventoryPanel.setVisible(false);
					m_constants.InventoryStatus = "close";
				}
			break;
			case "item1": 
				m_ui.inventoryButtons[0].setText("[Empty]");
				m_player.itemUsed(0); 
				break;
			case "item2": 
				m_ui.inventoryButtons[1].setText("[Empty]");
				m_player.itemUsed(1); 
				break;
			case "item3": 
				m_ui.inventoryButtons[2].setText("[Empty]");
				m_player.itemUsed(2); 
				break;
			case "item4": 
				m_ui.inventoryButtons[3].setText("[Empty]");
				m_player.itemUsed(3); 
				break;
			case "item5": 
				m_ui.inventoryButtons[4].setText("[Empty]");
				m_player.itemUsed(4); 
				break;
		}
	}
}
