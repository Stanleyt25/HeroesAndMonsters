// A class representing a tile in the game. By default, the game board will consist of an 8x8 grid of tiles.

public class Tile {
	private char type; // Type: market (can buy or sell items), common (can engage in battles), and inaccessible (cannot enter)
	private boolean occupied; // True if player is on it, False is the player is not on it
	private Market market = new Market(); // The market associated with the tile -- only Market tiles with have a Market
	
	// Default constructor: by default, a tile is a Common tile
	public Tile() {
		type = 'C';
		occupied = false;
	}
	
	public Tile(char c) {
		type = c;
		occupied = false;
	}
	
	// SET method for type
	public void setType(char c) {
		type = c;
	}
	
	// GET method for type
	public char getType() {
		return type;
	}
	
	// SET method for occupied
	public void setOccupied(boolean b) {
		occupied = b;
	}
	
	// GET method for occupied
	public boolean getOccupied() {
		return occupied;
	}
	
	// SET method for market
	public void setMarket(Market list) {
		market = list;
	}
	
	// GET method for market
	public Market getMarket() {
		return market;
	}
	
	// Retrieves the item at index i in the market
	public Item get(int i) {
		return market.get(i);
	}
	
	// Adds an item i to the market
	public void add(Item i) {
		market.add(i);
	}
}
