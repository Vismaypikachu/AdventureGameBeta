package package01;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ChoiceHandler implements ActionListener{
	game m_game;
	public ChoiceHandler(game g) {
    // Constructor
		m_game = g;
	}
 
	public void actionPerformed(ActionEvent event){
		String yourChoice = event.getActionCommand();
		switch(yourChoice){
			case "start": m_game.vm.showGameScreen(); m_game.story.fork(); break;
			case "c1": m_game.story.selectPosition(m_game.nextPosition1); break;
			case "c2": m_game.story.selectPosition(m_game.nextPosition2); break;
			case "c3": m_game.story.selectPosition(m_game.nextPosition3); break;
			case "c4": m_game.story.selectPosition(m_game.nextPosition4); break;
		}
	}
}
