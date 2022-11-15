// A subclass of the Creature class
// Represents all the monsters in the world that the heroes engage in combat against

public class Monster extends Creature {
	private String type; // Type of monster: Dragon, Spirit, Exoskeleton
	private int baseDamage; // Their base damage value -- it is used to compute how much damage their attacks do
	private int defense; // Their base defense value -- it is used to compute how much damage is mitigated from attacks they receive
	private int dodge; // Dodge value -- it is used to calculate dodge chance each time a monster is attacked
	
	// Default constructor
	public Monster() {
		super();
		baseDamage = 0;
		defense = 0;
		dodge = 0;
	}
	
	public Monster(String n, int l, int h, String t, int b, int d, int o) {
		super(n, l, h);
		type = t;
		baseDamage = b;
		defense = d;
		dodge = o;
	}

	// Calculates and returns how much damage a monster does with an attack in-combat
	public double attack() {
		return (0.5*baseDamage);
	}
	
	// Calculates and returns the percent chance a monster has of dodging an attack
	public double dodge() {
		return (dodge * 0.005);
	}
	
	// Applies and returns the amount of damage a monster takes from an attack after mitigation from defense and dodge chance
	public double takeDamage(double d) {
		double roll = Math.random();
		if(roll < dodge()) {
			System.out.print("Attack dodged! ");
			return 0.0;
		}
		else {
			double dmg = d - (0.25*defense);
			this.setHealth(this.getHealth() - dmg);
			return dmg;
		}
	}
	
	// a toString() method providing a String representation of a Monster
	public String toString() {
		return this.getName() + "\r\n" + "Level " + this.getLevel() + "\r\n" +  "HP: " + this.getHealth() + "\r\n" + "Base Damage: " + baseDamage + "\r\n" +
				"Defense: " + defense + "\r\n" + "Dodge Chance: " + dodge + "\r\n";
	}
	
	// GET method for type
	public String getType() {
		return type;
	}
	
	// SET method for type
	public void setType(String t) {
		type = t;
	}
	
	// GET method for base damage amount
	public int getDamage() {
		return baseDamage;
	}
	
	// SET method for base damage amount
	public void setDamage(int i) {
		baseDamage = i;
	}
	
	// GET method for defense
	public int getDefense() {
		return defense;
	}
	
	// SET method for defense
	public void setDefense(int d) {
		defense = d;
	}
	
	// GET method for dodge chance
	public int getDodge() {
		return dodge;
	}
	
	// SET method for dodge chance
	public void setDodge(int o) {
		dodge = o;
	}
}
