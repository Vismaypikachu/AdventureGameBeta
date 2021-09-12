package package01;

public class game {
	
	ChoiceHandler choiceHandler = new ChoiceHandler(this);
	UI ui = new UI();
	VisibilityManager vm = new VisibilityManager(ui);
	Story story = new Story(this, ui, vm);
	
	String nextPosition1, nextPosition2, nextPosition3, nextPosition4;
	
	public static void main(String[] args) {
		new game();
	}
	
	public game() {
		ui.createUI(choiceHandler);
		story.playerSetup();
		vm.showTitleScreen();
	}
}