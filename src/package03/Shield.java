package package03;

public class Shield extends SuperItem{
	public Shield() {
		name = "Shield";
		droppable = false;
		useable = false;
		statDouble = 1.2;
		displayStat = "1.2";
		description = "A thingy that blocks other thingys.";
		itemType = "Equipment";
	}
}
