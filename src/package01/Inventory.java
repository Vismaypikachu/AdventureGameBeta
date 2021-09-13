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
	
	public void updateInventory() {
		for(int i = 0; i < 5; i++) {
			m_ui.inventoryButtons[i].setText(m_player.playerItem[i].name);
		}
	}
	
	public void inventory(int cbp_x, int cbp_w) {
		m_ui.inventoryPanel = new JPanel();
		int inp_x = (int)Math.round(cbp_x + cbp_w);
		int inp_y = (int)Math.round(m_constants.currentScreenHeight * 0.6811797752808989);
		int inp_w = (int)Math.round(m_constants.currentScreenWidth * 0.1401869158878505);
		int inp_h = (int)Math.round(m_constants.currentScreenHeight * 0.2640449438202247);
		m_ui.inventoryPanel.setBounds(inp_x, inp_y, inp_w, inp_h);
		//inventoryPanel.setBounds(900, 485, 150, 188);
		m_ui.inventoryPanel.setBackground(Color.black);
		m_ui.inventoryPanel.setLayout(new GridLayout(5,1));
		
		for (int i = 0; i < m_ui.inventoryButtons.length; i++) {
			m_ui.inventoryButtons[i] = new JButton();
			m_ui.inventoryButtons[i].setBackground(Color.black);
			m_ui.inventoryButtons[i].setForeground(Color.white);
			//itemButton1.setLayout(new GridLayout(5,1));
			m_ui.inventoryButtons[i].setFont(m_ui.normalFont);
			m_ui.inventoryButtons[i].setFocusPainted(false);
			m_ui.inventoryButtons[i].addActionListener(iHandler);
			m_ui.inventoryButtons[i].addActionListener(bHandler);
			m_ui.inventoryButtons[i].addActionListener(sHandler);
			int lol = i+1;
			m_ui.inventoryButtons[i].setActionCommand("item"+lol);
			
			m_ui.inventoryPanel.add(m_ui.inventoryButtons[i]);
		}
		m_ui.inventoryPanel.setVisible(false);
	}

	public void addInventoryItem(SuperItem item) {
		int slotNumber = 0;
		while(m_player.playerItem[slotNumber] != new Empty() && slotNumber < 4) slotNumber++;
		
		if(m_player.playerItem[slotNumber] == new Empty()) {
			m_player.playerItem[slotNumber] = item;
		}
		
		else {
			String currentText = m_ui.mainTextArea.getText();
			m_ui.mainTextArea.setText(currentText + "\nInventory is full, item sent to backpack.");
			m_backpack.addBackpackItem(item);
		}
	}
}
