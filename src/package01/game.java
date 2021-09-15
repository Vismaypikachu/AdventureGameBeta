package package01;	

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import package04.*;

public class game {
	
	//packge01
	public Backpack m_backpack = new Backpack(this);
	public Constants m_constants = new Constants(this);
	Enemy m_enemy = new Enemy();
	Images m_images = new Images(this);
	public Inventory m_inventory = new Inventory(this);
	public Player m_player = new Player(this);
	Sound m_sound = new Sound(this);
	public SoundEffect m_se = new SoundEffect();
	public Story m_story = new Story(this);
	public UI m_ui = new UI(this);
	public VisibilityManager m_vm = new VisibilityManager(this);
	
	//package04
	BackpackHandler m_bpHandler = new BackpackHandler(this);
	ButtonHandler m_bHandler = new ButtonHandler(this);
	CapsulesHandler m_cHandler = new CapsulesHandler(this);
	GameoverHandler m_goHandler = new GameoverHandler(this);
	InputHandler m_inHandler = new InputHandler(this);
	InventoryHandler m_iHandler = new InventoryHandler(this);
	OptionsHandler m_oHandler = new OptionsHandler(this);
	StatsHandler m_sHandler = new StatsHandler(this);
	ChoiceHandler m_choiceHandler = new ChoiceHandler();
	/*
	UI ui = new UI(this);
	
	public VisibilityManager vm = new VisibilityManager(ui);
	Inventory m_inventory = new Inventory(this, ui);
	public Story story = new Story(this, ui, vm, m_constants, m_inventory);
	ChoiceHandler choiceHandler = new ChoiceHandler();
	*/
	public String nextPosition1;
	public String nextPosition2;
	public String nextPosition3;
	public String nextPosition4;
	
	
	
	public static void main(String[] args) {
		new game();
	}
	
	public game() {
		m_ui.createUI();
		//story.playerSetup();
		m_vm.showTitleScreen();
	}
	
	public class ChoiceHandler implements ActionListener {
		//VisibilityManager vm = new VisibilityManager(m_ui);

		public void actionPerformed(ActionEvent event){
			String yourChoice = event.getActionCommand();
			switch(yourChoice){
				case "start": m_vm.hideTitleScreen(); m_sound.stop(); m_story.input(); break;
				case "load": break;
				case "credits": m_ui.credits(); break;
				case "fullScreen": 
					if(m_constants.fullScreenOn == false) {
						m_ui.setFullScreen(); break;
					}
					else {
						m_ui.endFullScreen(); break;
					}
				case "buttonBorder": 
					if(m_constants.buttonBorderOn == false) {
						m_constants.buttonBorderOn = true; m_ui.createUIComponent(); break;
					}
					else {
						m_constants.buttonBorderOn = false; m_ui.createUIComponent(); break;
					}
				case "backTitle":
					if(m_constants.fullScreenOn == false) {
						m_ui.createUIComponent(); break;
					}
					else {
						m_ui.createUIComponent(); m_ui.setFullScreen(); break;
					}
				case "options": m_ui.options(); break;
				case "c1": m_story.selectPosition(nextPosition1); break;
				case "c2": m_story.selectPosition(nextPosition2); break;
				case "c3": m_story.selectPosition(nextPosition3); break;
				case "c4": m_story.selectPosition(nextPosition4); break;
			}
		}
	}
}