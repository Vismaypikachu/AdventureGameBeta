package package01;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import package03.Empty;
import package03.SuperItem;
import package04.ButtonHandler;
import package04.InventoryHandler;
import package04.StatsHandler;

public class Inventory {
	/*
	game m_game;
	UI m_ui;
	Constants m_constants = new Constants(m_ui);
	Player m_player = new Player(m_ui, m_constants);
	Backpack m_backpack = new Backpack(m_game, m_constants, m_ui, this);
	ButtonHandler bHandler = new ButtonHandler(m_game, m_ui);
	InventoryHandler iHandler = new InventoryHandler(m_ui, m_game, m_constants, this);
	StatsHandler sHandler = new StatsHandler(m_game, m_ui);
	
	public Inventory(game g, UI userInterface) {
		m_game = g;
		m_ui = userInterface;
	}
	*/
	
	game m_game;
	
	public Inventory(game g) {
		m_game = g;
	}
	
	public void updateInventory() {
		for(int i = 0; i < 5; i++) {
			m_game.m_ui.inventoryButtons[i].setText(m_game.m_player.playerItem[i].name);
		}
	}
	
	public void addInventoryItem(SuperItem item) {
		int slotNumber = 0;
		while(m_game.m_player.playerItem[slotNumber] != new Empty() && slotNumber < 4) slotNumber++;
		
		if(m_game.m_player.playerItem[slotNumber] == new Empty()) {
			m_game.m_player.playerItem[slotNumber] = item;
		}
		
		else {
			String currentText = m_game.m_ui.mainTextArea.getText();
			m_game.m_ui.mainTextArea.setText(currentText + "\nInventory is full, item sent to backpack.");
			m_game.m_backpack.addBackpackItem(item);
		}
	}
}
