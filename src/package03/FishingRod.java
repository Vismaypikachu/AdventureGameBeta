package package03;

public class FishingRod extends SuperItem{
	public FishingRod(int x) {
		name = "Fishing Rod";
		droppable = false;
		useable = false;
		stat = x;
		displayStat = ""+x;
		itemType = "Equipment";
		if(x == 10) description = "What luck... You got the worst Fishing Rod possible";
		else if(x == 20) description = "What luck! You got the best Fishing Rod possible";
		else description = "Some sort of old Fishing Rod";
	}
}
