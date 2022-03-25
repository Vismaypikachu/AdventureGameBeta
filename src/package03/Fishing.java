package package03;

import java.util.Random;

import package01.game;

public class Fishing {
	
	game m_game;
	Random r = new Random();
	
	public Fishing(game g) {
		m_game = g;
	}
	
	
	public void cast() {
		m_game.m_ui.mainTextArea.setText("You cast your fishing rod...\nYou slowly start to reel it in.\nLets see what we got!");
		
		m_game.m_story.setChoices("Continue", "", "", "");
		m_game.m_story.setNextPosition("reel", "", "", "");
	}
	
	public void reel() {
		int x = r.nextInt((20-10)+1)+7;
		
		if(m_game.m_player.fishingRod.stat >= x) {
			m_game.m_ui.mainTextArea.setText("You caught a fish!\n(Fish added to Inventory)");
			m_game.m_inventory.addInventoryItem(new Fish());
		}
		else {
			m_game.m_ui.mainTextArea.setText("You caught... absolutely nothing.");
		}
		m_game.m_story.setChoices("", "Continue", "", "");
		m_game.m_story.setNextPosition("", "fishingdone", "", "");
	}
}
