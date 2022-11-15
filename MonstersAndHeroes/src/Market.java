import java.util.ArrayList;

// A Market class that each market tile possesses
// It facilitates the purchasing and selling of products.

public class Market {
	private ArrayList<Item> wares; // The wares that this specific Market offers
	
	// Default constructor
	public Market() {
		wares = new ArrayList<Item>();
	}
	
	// GET method for wares
	public Item get(int i) {
		return wares.get(i);
	}
	
	// Adds an item to the products offered at the market
	public void add(Item i) {
		wares.add(i);
	}
	
	// Removes an item that is offered at the market
	public Item remove(int i) {
		return wares.remove(i);
	}
	
	// Prints the market's offered products in the terminal
	public void printMarket() {
		System.out.println("Here are the products that this market offers: \n");
		for(int i = 0; i < wares.size(); i++) {
			System.out.println(i + " " + wares.get(i));
		}
	}
}
