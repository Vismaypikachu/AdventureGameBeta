package package01;

public class Enemy {
	int health;
	String name;
	int attackstat;
	String type;
	
	public void initializeEnemy() {
		Enemy bandit = new Enemy();
		
		bandit.health = 100;
		bandit.name = "Bandit";
		bandit.attackstat = 10;
		bandit.type = "Physical";
		
		Enemy Goblin = new Enemy();
		Goblin.health = 100;
		Goblin.name = "Goblin";
		Goblin.attackstat = 12;
		Goblin.type = "Magical";
	}
}