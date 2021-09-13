package package04;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import package01.Constants;
import package01.Inventory;
import package01.Player;
import package01.Story;
import package01.UI;
import package01.VisibilityManager;
import package01.game;

public class CapsulesHandler implements ActionListener{
	game m_game;
	UI m_ui;
	Constants m_constants = new Constants(m_ui);
	Player m_player = new Player(m_ui, m_constants);
	Random r = new Random();
	VisibilityManager vm = new VisibilityManager(m_ui);
	Inventory m_inventory = new Inventory(m_game, m_ui);
	Story m_story = new Story(m_game, m_ui, vm, m_constants, m_inventory);
	
	public CapsulesHandler(game g, UI userInterface) {
		m_game = g;
		m_ui = userInterface;
	}
	
	public void actionPerformed(ActionEvent event) {
		m_ui.statschange();
		if(m_player.capsules == 0 && m_player.playerHP > 20) {
			int attack = r.nextInt((m_player.weapon.attackStat*5)-10+1);
			m_constants.currentEnemy.enemyHP -= attack;
			m_player.playerHP /= 2;
			specialattack(attack);
		}
		else if(m_player.capsules == 0 && m_player.playerHP <= 20) {
			m_player.playerHP = 0;
			m_story.gameover();
		}
		else {
			int attack = r.nextInt((m_player.weapon.attackStat*5)-10+1);
			m_constants.currentEnemy.enemyHP -= attack;
			m_player.capsules -= 1;
			specialattack(attack);
		}
	}
	
	public void specialattack(int damage) {
		m_ui.mainTextArea.setText("You attacked " + m_constants.currentEnemy.name + " with Special Attack\nYou dealt " + damage + " damage.\n"+ m_constants.currentEnemy.name + " has " + m_constants.currentEnemy.enemyHP + " health left.");
		m_constants.currentEnemy.enemyHP -= damage;
		m_ui.statschange();
		m_ui.choice1.setText("Continue");
		m_ui.choice2.setText("------");
		m_ui.choice3.setText("------");
		m_ui.choice4.setText("------");
	}
}
