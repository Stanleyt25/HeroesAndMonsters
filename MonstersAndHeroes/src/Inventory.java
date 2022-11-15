import java.util.ArrayList;

// A class representing the inventory of a hero.
// Each hero has their own inventory

public class Inventory {
	private ArrayList<Item> inventory;
	
	// Default constructor
	public Inventory() {
		inventory = new ArrayList<Item>();
	}
	
	// Prints the inventory in a displayable format into terminal
	public void printInventory() {
		if(inventory.size() == 0) {
			System.out.println("Your inventory is currently empty.");
		}
		else {
			for(int i = 0; i < inventory.size(); i++) {
				System.out.println(i + " " + inventory.get(i));
			}
		}
	}
	
	// Adds an item to the inventory
	public void add(Item i) {
		inventory.add(i);
	}
	
	// Retrives an item at index i in the inventory
	public Item get(int i) {
		return inventory.get(i);
	}
	
	// Removes an item at index i and returns it
	public Item remove(int i) {
		return inventory.remove(i);
	}
	
	// Returns true if the inventory is empty, false if it is not empty
	public boolean isEmpty() {
		return (inventory.size() == 0);
	}
}
