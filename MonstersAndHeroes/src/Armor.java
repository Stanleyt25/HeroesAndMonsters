// Subclass of the Item class
// Represents a piece of armor that is wearable by heroes

public class Armor extends Item {
	private int damageReduction; // Damage reduction value that reduces the damage taken by a percentage of the value
	
	public Armor() { // Default constructor
		super("Wooden Chestplate", 0, 1);
		damageReduction = 100;
	}
	
	public Armor(String n, int p, int l, int d) {
		super(n, p, l);
		damageReduction = d;
	}
	
	// GET method for the damage reduction value
	public int getDamageReduction() {
		return damageReduction;
	}
	
	// SET method for the damage reduction value
	public void setDamageReduction(int d) {
		damageReduction = d;
	}
	
	// toString method to allow for a String representation of an Armor piece
	public String toString() {
		return "Name: " + this.getName() + " / Price: " + this.getPrice() + " / Required Level: " + this.getLevel() + " / Damage Reduction: " + damageReduction;
	}
}
