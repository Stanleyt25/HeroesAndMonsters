// Subclass of the Item class
// Represents all of the consumable potions in the game

public class Potion extends Item {
	private int potency; // The potency/strength of the potion (value that you will benefit when consuming the potion)
	private String attributeBuffed; // The attribute that is buffed when you consume the potion
	
	// Default constructor
	public Potion() {
		super();
		potency = 0;
		attributeBuffed = "";
	}
	
	public Potion(String n, int p, int l, int o, String a) {
		super(n, p, l);
		potency = o;
		attributeBuffed = a;
	}
	
	// GET method for potency
	public int getPotency() {
		return potency;
	}
	
	// SET method for potency
	public void setPotency(int p) {
		potency = p;
	}
	
	// GET method for attributes buffed
	public String getAttribute() {
		return attributeBuffed;
	}
	
	// SET method for attributes buffed
	public void setAttribute(String a) {
		attributeBuffed = a;
	}
	
	// toString() method that provides a String representation of a Potion
	public String toString() {
		return "Name: " + this.getName() + " / Price: " + this.getPrice() + " / Required Level: " + this.getLevel() + " / Potency: " + potency + " / Attributes Buffed: " + attributeBuffed;
	}
}
