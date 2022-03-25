package package04;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import package01.game;

public class MouseHandler implements MouseListener{
	
	game m_game;
	
	public MouseHandler(game g) {
		m_game = g;
	}
	
	@Override
	public void mouseClicked(MouseEvent event) {
		if(m_game.m_constants.position.equals("bison")) {
			m_game.m_constants.bisonCount++;
			if(m_game.m_constants.second <= 0 && m_game.m_constants.bisonCount < 20) {
				m_game.m_story.bisonLost();
			}
			if(m_game.m_constants.bisonCount >= 20 && m_game.m_constants.second >= 0) {
				m_game.m_constants.position = "bisonWon";
				m_game.m_ui.choiceButtonPanel.setVisible(true);
				m_game.m_ui.mainTextArea.setText("You won!");
				m_game.m_constants.timer.stop();
			}
		}
		else if(m_game.m_constants.position.equals("tunnelB")) {
			m_game.m_constants.bubbleCount++;
			if(m_game.m_constants.second <= 0 && m_game.m_constants.bubbleCount < 20) {
				m_game.m_story.bubblesLost();
			}
			if(m_game.m_constants.bubbleCount >= 20 && m_game.m_constants.second >= 0) {
				m_game.m_constants.position = "bubblesWon";
				m_game.m_ui.choiceButtonPanel.setVisible(true);
				m_game.m_ui.mainTextArea.setText("You made it out safely!\nI wonder what would happen if I had breathing equipment...");
				m_game.m_constants.timer.stop();
			}
		}
		
	}
	
	@Override
	public void mousePressed(MouseEvent event) {
		if(m_game.m_constants.second <= 0 && m_game.m_constants.bisonCount < 20 && m_game.m_constants.position.equals("bison")) {
			m_game.m_story.bisonLost();
		}
		else if(m_game.m_constants.second <= 0 && m_game.m_constants.bubbleCount < 20 && m_game.m_constants.position.equals("tunnelB")) {
			m_game.m_story.bubblesLost();
		}
	}
	@Override
	public void mouseReleased(MouseEvent event) {
		if(m_game.m_constants.second <= 0 && m_game.m_constants.bisonCount < 20 && m_game.m_constants.position.equals("bison")) {
			m_game.m_story.bisonLost();
		}
		else if(m_game.m_constants.second <= 0 && m_game.m_constants.bubbleCount < 20 && m_game.m_constants.position.equals("tunnelB")) {
			m_game.m_story.bubblesLost();
		}
	}
	
	@Override
	public void mouseEntered(MouseEvent event) {
		if(m_game.m_constants.second <= 0 && m_game.m_constants.bisonCount < 20 && m_game.m_constants.position.equals("bison")) {
			m_game.m_story.bisonLost();
		}
		else if(m_game.m_constants.second <= 0 && m_game.m_constants.bubbleCount < 20 && m_game.m_constants.position.equals("tunnelB")) {
			m_game.m_story.bubblesLost();
		}
	}

	@Override
	public void mouseExited(MouseEvent event) {
		if(m_game.m_constants.second <= 0 && m_game.m_constants.bisonCount < 20 && m_game.m_constants.position.equals("bison")) {
			m_game.m_story.bisonLost();
		}
		else if(m_game.m_constants.second <= 0 && m_game.m_constants.bubbleCount < 20 && m_game.m_constants.position.equals("tunnelB")) {
			m_game.m_story.bubblesLost();
		}
	}
}
