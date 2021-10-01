package package04;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import package01.game;

public class CapsulesHandler implements ActionListener{
	
	Random r = new Random();
	game m_game;
	
	public CapsulesHandler(game g) {
		m_game = g;
	}

	public void actionPerformed(ActionEvent event) {
		m_game.m_story.statschange();
		if(m_game.m_player.capsules == 0 && m_game.m_player.playerHP > 20) {
			int attack = r.nextInt((m_game.m_player.weapon.attackStat*5-10)+1)+10;
			m_game.m_player.playerHP /= 2;
			specialattack(attack);
		}
		else if(m_game.m_player.capsules == 0 && m_game.m_player.playerHP <= 20) {
			m_game.m_player.playerHP = 0;
			m_game.m_story.statschange();
			m_game.m_story.gameover();
		}
		else {
			int attack = r.nextInt((m_game.m_player.weapon.attackStat*5-10)+1)+10;
			m_game.m_player.capsules -= 1;
			specialattack(attack);
		}
	}
	
	public void specialattack(int damage) {
		m_game.m_ui.mainTextArea.setText("You attacked " + m_game.m_constants.currentEnemy.name + " with Special Attack\nYou dealt " + damage + " damage.\n"+ m_game.m_constants.currentEnemy.name + " has " + m_game.m_constants.currentEnemy.enemyHP + " health left.");
		m_game.m_constants.currentEnemy.enemyHP -= damage;
		m_game.m_story.statschange();
		m_game.m_ui.choice1.setText("Continue");
		m_game.m_ui.choice2.setText("------");
		m_game.m_ui.choice3.setText("------");
		m_game.m_ui.choice4.setText("------");
	}
}
