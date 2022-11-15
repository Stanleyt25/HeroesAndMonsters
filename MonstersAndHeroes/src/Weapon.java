// Subclass of the Item class
// Represents the equippable weapons for heroes, they rpovide a damage stat that increases the hero's damage output during combat

public class Weapon extends Item {
	private int damage;
	private int numHandSlots;
	
	// Default constructor
	public Weapon() {
		super("Wooden Sword", 0, 1);
		damage = 100;
		numHandSlots = 2;
	}
	
	public Weapon(String n, int p, int l, int d, int h) {
		super(n, p, l);
		damage = d;
		numHandSlots = h;
	}
	
	// GET method for damage value
	public int getDamage() {
		return damage;
	}
	
	// SET method for damage value
	public void setDamage(int d) {
		damage = d;
	}
	
	// GET method for number of hand slots required to wield the weapon
	public int getNumHandSlots() {
		return numHandSlots;
	}
	
	// SET method for number of hand slots required to wield the weapon
	public void setNumHandSlots(int h) {
		numHandSlots = h;
	}
	
	// toString() method to provide a String representation of a weapon
	public String toString() {
		return "Name: " + this.getName() + " / Price: " + this.getPrice() + " / Required Level: " + this.getLevel() + " / Damage: " + damage + " / Number of Hands Required: " + numHandSlots;
	}
}
