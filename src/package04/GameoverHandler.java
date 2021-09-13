package package04;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import package01.Constants;
import package01.Inventory;
import package01.Player;
import package01.Story;
import package01.UI;
import package01.VisibilityManager;
import package01.game;

public class GameoverHandler implements ActionListener{
	public void actionPerformed(ActionEvent event) {
		
		game m_game = new game();
		UI m_ui = new UI(m_game);
		Constants m_constants = new Constants(m_ui);
		Player m_player = new Player(m_ui, m_constants);
		VisibilityManager vm = new VisibilityManager(m_ui);
		Inventory m_inventory = new Inventory(m_game, m_ui);
		Story m_story = new Story(m_game, m_ui, vm, m_constants, m_inventory);
		
		if(m_player.playerHP <= 0) {
			m_story.gameover();
		}
	}
}
