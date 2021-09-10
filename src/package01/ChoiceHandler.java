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
			case "start": m_game.vm.showGameScreen(); break; //m_game.story.townGate();
		//	case "c1": game.story.selectPosition(game.nextPosition1); break;
			//case "c2": game.story.selectPosition(game.nextPosition2); break;
		//	case "c3": game.story.selectPosition(game.nextPosition3); break;
		//	case "c4": game.story.selectPosition(game.nextPosition4); break;
		}
	}
}