package package04;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import package01.Constants;
import package01.Inventory;
import package01.Player;
import package01.UI;
import package01.game;

public class InventoryHandler implements ActionListener{
	
	game m_game;
	
	public InventoryHandler(game g) {
		m_game = g;
	}

	public void actionPerformed(ActionEvent event) {
		String yourChoice = event.getActionCommand();

		switch(yourChoice) {
			case "inventoryButton": 
				if(m_game.m_constants.InventoryStatus.equals("close")) {
					m_game.m_ui.choice1.setVisible(false);
					m_game.m_ui.choice2.setVisible(false);
					m_game.m_ui.choice3.setVisible(false);
					m_game.m_ui.choice4.setVisible(false);
					m_game.m_ui.specialattack.setVisible(false);
					m_game.m_ui.inGameOptionsButton.setVisible(false);
				//	m_game.m_ui.window.add(m_game.m_ui.inventoryPanel);
					for(int i = 0; i < m_game.m_ui.inventoryButtons.length; i++) {
						m_game.m_ui.sidePanel.add(m_game.m_ui.inventoryButtons[i]);
					}
					m_game.m_ui.sidePanel.setLayout(new GridLayout(5,1));
					m_game.m_ui.sidePanel.setVisible(true);
					//
					m_game.m_inventory.updateInventory();
					//
					m_game.m_constants.InventoryStatus = "open";
				}
				else if(m_game.m_constants.InventoryStatus.equals("open")) {
					m_game.m_ui.choice1.setVisible(true);
					m_game.m_ui.choice2.setVisible(true);
					m_game.m_ui.choice3.setVisible(true);
					m_game.m_ui.choice4.setVisible(true);
					m_game.m_ui.specialattack.setVisible(true);
					if(m_game.m_constants.inBattle == false) m_game.m_ui.inGameOptionsButton.setVisible(true);
					else m_game.m_ui.inGameOptionsButton.setVisible(false);
					for(int i = 0; i < m_game.m_ui.inventoryButtons.length; i++) {
						m_game.m_ui.sidePanel.remove(m_game.m_ui.inventoryButtons[i]);
					}
					m_game.m_ui.sidePanel.setLayout(new GridLayout(5,1));
					m_game.m_ui.sidePanel.setVisible(false);
				//	m_game.m_ui.window.remove(m_game.m_ui.inventoryPanel);
					m_game.m_constants.InventoryStatus = "close";
				}
			break;
			case "item1": 
				m_game.m_ui.inventoryButtons[0].setText("[Empty]");
				m_game.m_player.itemUsed(0); 
				break;
			case "item2": 
				m_game.m_ui.inventoryButtons[1].setText("[Empty]");
				m_game.m_player.itemUsed(1); 
				break;
			case "item3": 
				m_game.m_ui.inventoryButtons[2].setText("[Empty]");
				m_game.m_player.itemUsed(2); 
				break;
			case "item4": 
				m_game.m_ui.inventoryButtons[3].setText("[Empty]");
				m_game.m_player.itemUsed(3); 
				break;
			case "item5": 
				m_game.m_ui.inventoryButtons[4].setText("[Empty]");
				m_game.m_player.itemUsed(4); 
				break;
		}
	}
}
