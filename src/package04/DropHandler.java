package package04;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import package01.game;
import package03.Empty;

public class DropHandler implements ActionListener{
	
	game m_game;
	
	public DropHandler(game g) {
		m_game = g;
	}
	
	public void actionPerformed(ActionEvent event) {
		String yourChoice = event.getActionCommand();
		if(m_game.m_constants.DropStatus == true) {
			switch(yourChoice) {
				case "backpackButton1": dropItem(0); break;
				case "backpackButton2": dropItem(1); break;
				case "backpackButton3": dropItem(2); break;
				case "backpackButton4": dropItem(3); break;
				case "backpackButton5": dropItem(4); break;
				case "backpackButton6": dropItem(5); break;
				case "backpackButton7": dropItem(6); break;
				case "backpackButton8": dropItem(7); break;
				case "backpackButton9": dropItem(8); break;
				case "backpackButton10": dropItem(9); break;
				case "backpackButton11": dropItem(10); break;
				case "backpackButton12": dropItem(11); break;
				case "backpackButton13": dropItem(12); break;
				case "backpackButton14": dropItem(13); break;
				case "backpackButton15": dropItem(14); break;
				case "backpackSwitchButton": dropItem(15); break;
				case "drop": m_game.m_constants.DropStatus = false; m_game.m_ui.backpackButtons[15].addActionListener(m_game.m_bpHandler); m_game.m_ui.backpackDropButton.setText("Drop Item (OFF)"); break;
			}
		}
		else if(m_game.m_constants.DropStatus == false){
			switch(yourChoice) {
				case "drop": m_game.m_constants.DropStatus = true; m_game.m_ui.backpackButtons[15].removeActionListener(m_game.m_bpHandler); m_game.m_ui.backpackDropButton.setText("Drop Item (ON)"); m_game.m_player.backup = new Empty(); break;
			}
		}
	}	
	
	public void dropItem(int i) {
		if(i == 15) {
			String currentText = m_game.m_ui.backpackTextArea.getText();
			m_game.m_ui.backpackTextArea.setText(currentText + "\nYou cannot drop the switch button...");
			m_game.m_ui.backpackDropButton.setText("Drop Item (ON)");
			m_game.m_constants.switchOn = false;
		}
		else if(m_game.m_player.backpackItem[i].droppable == true) {
			m_game.m_ui.backpackTextArea.setText("You dropped " + m_game.m_player.backpackItem[i].name + " and added " + m_game.m_player.backup.name + ".");
			m_game.m_player.backpackItem[i] = m_game.m_player.backup;
			m_game.m_ui.backpackDropButton.setText("Drop Item (OFF)");
			m_game.m_constants.DropStatus = false;
			m_game.m_ui.backpackButtons[15].addActionListener(m_game.m_bpHandler);
			m_game.m_ui.choiceButtonPanel.setVisible(true);
			m_game.m_ui.sidePanel.setVisible(false);
			m_game.m_constants.InventoryStatus = "close";
			m_game.m_constants.OptionsStatus = "close";
			m_game.m_backpack.updateBackpack(1);
		}
		else if(m_game.m_player.backpackItem[i].droppable == false) {
			m_game.m_ui.backpackTextArea.setText("You cannot drop that item, please select a different item.");
		}
	}
}
