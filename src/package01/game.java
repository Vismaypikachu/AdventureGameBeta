package package01;

public class game {
	
	ChoiceHandler choiceHandler = new ChoiceHandler(this);
	UI ui = new UI();
	VisibilityManager vm = new VisibilityManager(ui);
	
	public static void main(String[] args) {
		new game();
	}
	
	public game() {
		ui.createUI(choiceHandler);
		vm.showTitleScreen();
	}
}