package package04;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import package01.game;

public class BackpackHandler implements ActionListener {
	
	game m_game;
	
	public BackpackHandler(game g) {
		m_game = g;
	}
	
	public void actionPerformed(ActionEvent event) {
		String yourChoice = event.getActionCommand();
		if(m_game.m_constants.switchOn == true) {
			switch(yourChoice) {
				case "backpack":
					if(m_game.m_constants.BackpackStatus.equals("close")) {
						m_game.m_ui.imagePanel.setVisible(false);
						m_game.m_ui.inGameOptionsButtons[0].setVisible(false);
						m_game.m_ui.inGameOptionsButtons[1].setVisible(false);
						m_game.m_ui.inGameOptionsButton.setVisible(false);
						m_game.m_ui.backpackPanel.setVisible(true);
						m_game.m_ui.backpackTextAreaPanel.setVisible(true);
						//
						m_game.m_backpack.updateBackpack(1);
						//
						m_game.m_constants.BackpackStatus = "open";
					}
					else if(m_game.m_constants.BackpackStatus.equals("open")) {
						//
						m_game.m_backpack.updateBackpack(1);
						//
						m_game.m_ui.backpackStatsTextArea.setText("");
						m_game.m_ui.sidePanel.setVisible(true);
						m_game.m_ui.inGameOptionsButtons[0].setVisible(true);
						m_game.m_ui.inGameOptionsButtons[1].setVisible(true);
						m_game.m_ui.backpackPanel.setVisible(false);
						m_game.m_ui.backpackTextAreaPanel.setVisible(false);
						m_game.m_ui.imagePanel.setVisible(true);
						m_game.m_ui.inGameOptionsButton.setVisible(true);
						m_game.m_constants.BackpackStatus = "close";
						m_game.m_constants.switchOn = false;
					}
				break;
				case "backpackButton1": m_game.m_backpack.backpackSwitch(0); m_game.m_constants.switchOn = false; m_game.m_ui.backpackTextArea.setText("Press Switch to move an item to your inventory. \nIf you do not have any space, the item will be dropped"); break;
				case "backpackButton2": m_game.m_backpack.backpackSwitch(1); m_game.m_constants.switchOn = false; m_game.m_ui.backpackTextArea.setText("Press Switch to move an item to your inventory. \nIf you do not have any space, the item will be dropped"); break;
				case "backpackButton3": m_game.m_backpack.backpackSwitch(2); m_game.m_constants.switchOn = false; m_game.m_ui.backpackTextArea.setText("Press Switch to move an item to your inventory. \nIf you do not have any space, the item will be dropped"); break;
				case "backpackButton4": m_game.m_backpack.backpackSwitch(3); m_game.m_constants.switchOn = false; m_game.m_ui.backpackTextArea.setText("Press Switch to move an item to your inventory. \nIf you do not have any space, the item will be dropped"); break;
				case "backpackButton5": m_game.m_backpack.backpackSwitch(4); m_game.m_constants.switchOn = false; m_game.m_ui.backpackTextArea.setText("Press Switch to move an item to your inventory. \nIf you do not have any space, the item will be dropped"); break;
				case "backpackButton6": m_game.m_backpack.backpackSwitch(5); m_game.m_constants.switchOn = false; m_game.m_ui.backpackTextArea.setText("Press Switch to move an item to your inventory. \nIf you do not have any space, the item will be dropped"); break;
				case "backpackButton7": m_game.m_backpack.backpackSwitch(6); m_game.m_constants.switchOn = false; m_game.m_ui.backpackTextArea.setText("Press Switch to move an item to your inventory. \nIf you do not have any space, the item will be dropped"); break;
				case "backpackButton8": m_game.m_backpack.backpackSwitch(7); m_game.m_constants.switchOn = false; m_game.m_ui.backpackTextArea.setText("Press Switch to move an item to your inventory. \nIf you do not have any space, the item will be dropped"); break;
				case "backpackButton9": m_game.m_backpack.backpackSwitch(8); m_game.m_constants.switchOn = false; m_game.m_ui.backpackTextArea.setText("Press Switch to move an item to your inventory. \nIf you do not have any space, the item will be dropped"); break;
				case "backpackButton10": m_game.m_backpack.backpackSwitch(9); m_game.m_constants.switchOn = false; m_game.m_ui.backpackTextArea.setText("Press Switch to move an item to your inventory. \nIf you do not have any space, the item will be dropped"); break;
				case "backpackButton11": m_game.m_backpack.backpackSwitch(10); m_game.m_constants.switchOn = false; m_game.m_ui.backpackTextArea.setText("Press Switch to move an item to your inventory. \nIf you do not have any space, the item will be dropped"); break;
				case "backpackButton12": m_game.m_backpack.backpackSwitch(11); m_game.m_constants.switchOn = false; m_game.m_ui.backpackTextArea.setText("Press Switch to move an item to your inventory. \nIf you do not have any space, the item will be dropped"); break;
				case "backpackButton13": m_game.m_backpack.backpackSwitch(12); m_game.m_constants.switchOn = false; m_game.m_ui.backpackTextArea.setText("Press Switch to move an item to your inventory. \nIf you do not have any space, the item will be dropped"); break;
				case "backpackButton14": m_game.m_backpack.backpackSwitch(13); m_game.m_constants.switchOn = false; m_game.m_ui.backpackTextArea.setText("Press Switch to move an item to your inventory. \nIf you do not have any space, the item will be dropped"); break;
				case "backpackButton15": m_game.m_backpack.backpackSwitch(14); m_game.m_constants.switchOn = false; m_game.m_ui.backpackTextArea.setText("Press Switch to move an item to your inventory. \nIf you do not have any space, the item will be dropped"); break;
				case "backpackSwitchButton": m_game.m_constants.switchOn = false; m_game.m_ui.backpackTextArea.setText("Press Switch to move an item to your inventory. \nIf you do not have any space, the item will be dropped"); break;
			}
		}
		
		else if(m_game.m_constants.switchOn == false) {
			switch(yourChoice) {
				case "backpack":
					if(m_game.m_constants.BackpackStatus.equals("close")) {
						m_game.m_ui.imagePanel.setVisible(false);
						m_game.m_ui.inGameOptionsButtons[0].setVisible(false);
						m_game.m_ui.inGameOptionsButtons[1].setVisible(false);
						m_game.m_ui.backpackPanel.setVisible(true);
						m_game.m_ui.backpackTextAreaPanel.setVisible(true);
						//
						m_game.m_backpack.updateBackpack(1);
						//
						m_game.m_constants.BackpackStatus = "open";
					}
					else if(m_game.m_constants.BackpackStatus.equals("open")) {
						//
						m_game.m_backpack.updateBackpack(1);
						//
						m_game.m_ui.backpackStatsTextArea.setText("");
						m_game.m_ui.inGameOptionsButtons[0].setVisible(true);
						m_game.m_ui.inGameOptionsButtons[1].setVisible(true);
						m_game.m_ui.backpackPanel.setVisible(false);
						m_game.m_ui.backpackTextAreaPanel.setVisible(false);
						m_game.m_ui.imagePanel.setVisible(true);
						m_game.m_constants.BackpackStatus = "close";
					}
				break;
				case "backpackButton1": m_game.m_backpack.displayStats(0); break;
				case "backpackButton2": m_game.m_backpack.displayStats(1); break;
				case "backpackButton3": m_game.m_backpack.displayStats(2); break;
				case "backpackButton4": m_game.m_backpack.displayStats(3); break;
				case "backpackButton5": m_game.m_backpack.displayStats(4); break;
				case "backpackButton6": m_game.m_backpack.displayStats(5); break;
				case "backpackButton7": m_game.m_backpack.displayStats(6); break;
				case "backpackButton8": m_game.m_backpack.displayStats(7); break;
				case "backpackButton9": m_game.m_backpack.displayStats(8); break;
				case "backpackButton10": m_game.m_backpack.displayStats(9); break;
				case "backpackButton11": m_game.m_backpack.displayStats(10); break;
				case "backpackButton12": m_game.m_backpack.displayStats(11); break;
				case "backpackButton13": m_game.m_backpack.displayStats(12); break;
				case "backpackButton14": m_game.m_backpack.displayStats(13); break;
				case "backpackButton15": m_game.m_backpack.displayStats(14); break;
				case "backpackSwitchButton": m_game.m_constants.switchOn = true; m_game.m_ui.backpackTextArea.setText("Please select the item to move to your inventory."); break;
			}
		}
	}
}
