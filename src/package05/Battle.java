package package05;

import java.util.Random;

import package01.game;

public class Battle {
	
	game m_game;
	Random r = new Random();
	
	public Battle(game g) {
		m_game = g;
	}
	
	public void enemyattack(){
		m_game.m_constants.position = "enemyattack";
		int enemydamage = 0;
		//magical player vs physical
		if(m_game.m_player.playerType.equals("Magical") && m_game.m_constants.currentEnemy.enemyAttackType.equals("Physical")) {
			enemydamage = (int)Math.round((r.nextInt(((m_game.m_constants.currentEnemy.enemyAttackStat-5) - 1) + 1) + 1) - m_game.m_player.playerdefense);
		}
		//physical player vs magical
		if(m_game.m_player.playerType.equals("Physical") && m_game.m_constants.currentEnemy.enemyAttackType.equals("Magical")) {
			enemydamage = (int)Math.round((r.nextInt(((m_game.m_constants.currentEnemy.enemyAttackStat+5) - 3) + 1) + 3) - m_game.m_player.playerdefense);
		}
		else {
			enemydamage = (int)Math.round((r.nextInt((m_game.m_constants.currentEnemy.enemyAttackStat - 3) + 1) + 3) - m_game.m_player.playerdefense);
		}
		
		m_game.m_ui.mainTextArea.setText(m_game.m_constants.currentEnemy.name + " attacked and dealt " + enemydamage + " damage.");
		m_game.m_player.playerHP -= enemydamage;
		m_game.m_story.statschange();
		m_game.m_story.setChoices("Attack", "", "", "");
		m_game.m_story.setNextPosition("playerattack", "", "", "");
		
		if(m_game.m_constants.currentEnemy.enemyHP <= 0) {
			battlewon();
		}
		
	}
	
	public void playerattack() {
		m_game.m_constants.position = "playerattack";
		int playerdamage = r.nextInt((m_game.m_constants.currentEnemy.enemyAttackStat + 5) + 1) + 3;
		m_game.m_constants.currentEnemy.enemyHP -= playerdamage;
		m_game.m_ui.mainTextArea.setText("You attacked " + m_game.m_constants.currentEnemy.name + " and dealt " + playerdamage + " damage.\n"+ m_game.m_constants.currentEnemy.name + " has " + m_game.m_constants.currentEnemy.enemyHP + " health left.");
		m_game.m_story.statschange();
		
		m_game.m_story.setChoices("Continue", "", "", "");
		m_game.m_story.setNextPosition("enemyattack", "", "", "");
		
		if(m_game.m_constants.currentEnemy.enemyHP <= 0) {
			battlewon();
		}
	}
	
	public void battlewon() {
		m_game.m_constants.position = "battlewon";
		int goldadd = r.nextInt((m_game.m_constants.currentEnemy.enemyAttackStat+5 - m_game.m_constants.currentEnemy.enemyAttackStat+1)+1) + m_game.m_constants.currentEnemy.enemyAttackStat+1;
		int xpadd = r.nextInt(m_game.m_constants.currentEnemy.enemyAttackStat+20);
		int healby;
		if(!m_game.m_constants.enemyPosition.equals("practice")) {
			healby = r.nextInt((m_game.m_constants.currentEnemy.enemyAttackStat*4 - m_game.m_constants.currentEnemy.enemyAttackStat*2)+1)+m_game.m_constants.currentEnemy.enemyAttackStat*2;
		}
		else {
			healby = 100-m_game.m_player.playerHP;
		}
		m_game.m_ui.mainTextArea.setText("You defeated the " + m_game.m_constants.currentEnemy.name + "\nYou gained " + goldadd + " gold and " + xpadd + " XP!\nYou were healed by " + healby + " health.");
		m_game.m_player.gold+= goldadd;
		m_game.m_player.xp += xpadd;
		m_game.m_player.playerHP += healby;
		m_game.m_story.statschange();
		m_game.m_story.setNextPosition("", "battlewon", "", "");
		m_game.m_story.setChoices("", "Continue", "", "");
		m_game.m_constants.currentEnemy = new EmptyAir();
		m_game.m_constants.inBattle = false;
		m_game.m_ui.inGameOptionsButton.setVisible(true);
	}
	
}
