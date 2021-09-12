package package01;

public class Backpack {
	
	Constants m_constants = new Constants();
	UI m_ui = new UI();
	Inventory m_inventory = new Inventory();
	Player m_player = new Player();
	
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
}
