package package01;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class game {
	
	UI ui = new UI(this);
	Constants m_constants = new Constants(ui);
	public VisibilityManager vm = new VisibilityManager(ui);
	Inventory m_inventory = new Inventory(this, ui);
	public Story story = new Story(this, ui, vm, m_constants, m_inventory);
	ChoiceHandler choiceHandler = new ChoiceHandler();
	
	public String nextPosition1;
	public String nextPosition2;
	public String nextPosition3;
	public String nextPosition4;
	
	
	
	public static void main(String[] args) {
		new game();
	}
	
	public game() {
		ui.createUI(choiceHandler);
		//story.playerSetup();
		vm.showTitleScreen();
	}
	
	public class ChoiceHandler implements ActionListener {
		//VisibilityManager vm = new VisibilityManager(m_ui);
	 
		public void actionPerformed(ActionEvent event){
			String yourChoice = event.getActionCommand();
			switch(yourChoice){
				case "start": vm.hideTitleScreen(); ui.m_sound.stop(); story.input(); break;
				case "c1": story.selectPosition(nextPosition1); break;
				case "c2": story.selectPosition(nextPosition2); break;
				case "c3": story.selectPosition(nextPosition3); break;
				case "c4": story.selectPosition(nextPosition4); break;
			}
		}
	}
}