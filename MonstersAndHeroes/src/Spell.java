// Subclass of the Item class
// Represents a consumable, spell scroll that heroes can use in combat against monsters

public class Spell extends Item {
	private int potency; // The amount of damage the spell does
	private int manaCost; // The mana cost of the spell
	private String spellType; // The element of the spell: Fire, Ice, Lightning
	
	// Default constructor
	public Spell() {
		super();
		potency = 0;
		manaCost = 0;
		spellType = "";
	}
	
	public Spell(String n, int p, int l, int o, int m, String s) {
		super(n, p, l);
		potency = o;
		manaCost = m;
		spellType = s;
	}
	
	// GET method for potency
	public int getPotency() {
		return potency;
	}
	
	// SET method for potency
	public void setPotency(int p) {
		potency = p;
	}
	
	// GET method for mana cost
	public int getCost() {
		return manaCost;
	}
	
	// SET method for mana cost
	public void setCost(int c) {
		manaCost = c;
	}
	
	// GET method for type/element of spell
	public String getType() {
		return spellType;
	}
	
	// SET method for type/element of spell
	public void setType(String t) {
		spellType = t;
	}
	
	// toString() method that provides a String representation of the spell
	public String toString() {
		return "Name: " + this.getName() + " / Price: " + this.getPrice() + " / Required Level: " + this.getLevel() + " / Potency: " + potency + " / Mana Cost: " + manaCost + " / Spell Type: " + spellType;
	}
}
