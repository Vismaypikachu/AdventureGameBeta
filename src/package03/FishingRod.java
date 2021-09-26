package package03;

public class FishingRod extends SuperItem{
	public FishingRod(int x) {
		name = "Fishing Rod";
		droppable = false;
		useable = false;
		chance = x;
	}
}
