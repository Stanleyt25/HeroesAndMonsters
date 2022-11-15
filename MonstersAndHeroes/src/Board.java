import java.util.Collections;

// A class representing the board on which the player will move around.
// By default, it will be an 8x8 grid of objects of the Tile class.

public class Board {
	private Tile[][] board; // 2D Tile array representation of the board
	private ItemList market = new ItemList(); // The global market contains all of the possible items in the game
	
	public Board() { // Default constructor
		board = new Tile[8][8]; // By default, the board is an 8x8 grid of tiles
		initializeBoard();
	}
	
	public Board(int x, int y) {
		board = new Tile[x][y]; // The user can specify different dimensions for the board
		initializeBoard();
	}
	
	// Initializes the tiles on the board with tile types: market, common, and inaccessible
	public void initializeBoard() {
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				double random = Math.random(); // Randomly decide the tile type for each tile
				if(random < 0.20) { // 20% of the tiles will be Inaccessible tiles.
					board[i][j] = new Tile('I'); 
				}
				else if(random < 0.50) { // 30% of the tiles will be Market tiles.
					board[i][j] = new Tile('M');
					Collections.shuffle(market.getItems());
					for(int k = 0; k < 8; k++) { 
						board[i][j].add(market.get(k));
					}
				}
				else { // 50% (half) of the tiles will be Common tiles.
					board[i][j] = new Tile('C');
				}
			}
		}
	}
	
	// Prints the board into terminal
	public void printBoard() {
		for(int i = board.length-1; i >= 0; i--) {
			System.out.print("+");
			for(int j = 0; j < board.length; j++) {
				System.out.print("---+");
			}
			System.out.println();
			System.out.print("| ");
			for(int k = 0; k < board.length; k++) {
				if(board[k][i].getOccupied()) {
					System.out.print("X | ");
				}
				else if(board[k][i].getType() == 'C') {
					System.out.print("  | ");
				}
				else {
					System.out.print(board[k][i].getType() + " | ");
				}
			}
			System.out.println();
		}
		System.out.print("+");
		for(int k = 0; k < board.length; k++) {
			System.out.print("---+"); 	
		}
		System.out.println("\n");
	}
	
	// Finds a valid starting position for the player (a non-inaccessible tile)
	// Returns an integer list of size 2: [x-coordinate of starting position, y-coordinate of starting position]
	public Tuple findStartingPosition() {
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				if(board[i][j].getType() == 'C') {
					board[i][j].setOccupied(true);
					return new Tuple(i, j);
				}
			}
		}
		return new Tuple(-1, -1);
	}
	
	// Determines whether a given coordinate point is within the bounds of the grid
	public boolean inBound(Tuple t) {
		return (t.x >= 0 && t.x < board.length && t.y >= 0 && t.y < board[0].length);
	}
	
	// GET Method for the board
	public Tile get(int x, int y) {
		return board[x][y];
	}
}
