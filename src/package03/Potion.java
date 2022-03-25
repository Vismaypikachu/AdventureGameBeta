package package03;

public class Potion extends SuperItem {
	public Potion() {
		name = "Potion";
		droppable = true;
		useable = true;
		stat = 20;
		displayStat = "20";
		description = "At least it wasn't Neville's";
		itemType = "Food";
	}
}
