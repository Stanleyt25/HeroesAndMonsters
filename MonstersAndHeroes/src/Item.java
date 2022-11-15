// Superclass that will be parent class to all items
// Superclass of the Weapon, Armor, Spell, and Potion class
// Contains all of the sharable traits between all items: name, price, and level

public class Item {
	private String name; // The name of the item
	private int price; // The price/cost of the item
	private int level; // The level of the item
	
	// Default constructor
	public Item() {
		name = "Piece of Dust";
		price = 0;
		level = 0;
	}
	
	public Item(String n, int p, int l) {
		name = n;
		price = p;
		level = l;
	}
	
	// GET method for name
	public String getName() {
		return name;
	}
	
	// SET method for name
	public void setName(String n) {
		name = n;
	}
	
	// GET method for price
	public int getPrice() {
		return price;
	}
	
	// SET method for price
	public void setPrice(int p) {
		price = p;
	}
	
	// GET method for level
	public int getLevel() {
		return level;
	}
	
	// SET method for level
	public void setLevel(int l) {
		level = l;
	}
	
	// toString() method to provide a String representation of any Item
	public String toString() {
		return "Name: " + name + " / Price: " + price + " / Level: " + level;
	}
}
