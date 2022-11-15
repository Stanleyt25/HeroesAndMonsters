import java.util.ArrayList;
import java.util.Scanner;

// The driver class which handles the logic of Herose and Monsters
// A class that resolves user input to move the character, show inventory, handle buying/selling items, battle, etc.

public class Controller {
	static Scanner scan = new Scanner(System.in); // Scanner object to take in user input
	
	private static Board board = new Board(); // The board on which the user is playing
	private static Tuple pos = board.findStartingPosition(); // The current position of the party
	private static ArrayList<Hero> party = new ArrayList<Hero>(); // The party consisting of all the characters the user has chosen
	private static MonsterList monsters = new MonsterList(); // A list containing all of the possible monsters in the game
	
	// Display all of the possible characters and allow the user to select which ones to add to the party
	// The user is allowed to add up to three heroes to their party, and must have at least one hero in their party
	public static void selectCharacter() {
		HeroList heroes = new HeroList();
		
		System.out.println("Welcome to Party Creation. These are the heroes you may select to join your party.\n");
		System.out.println("Warriors");
		System.out.println("--------");
		System.out.println("Name/mana/strength/agility/dexterity/starting money/starting experience\r\n"
				+ "0 Gaerdal_Ironhand    100     700     500     600     1354    7\r\n"
				+ "1 Sehanine_Monnbow    600     700     800     500     2500    8\r\n"
				+ "2 Muamman_Duathall    300     900     500     750     2546    6\r\n"
				+ "3 Flandal_Steelskin   200     750     650     700     2500    7\r\n"
				+ "4 Undefeated_Yoj      400     800     400     700     2500    7\r\n"
				+ "5 Eunoia_Cyn          400     700     800     600     2500    6\r\n"
				+ "");
		System.out.println("");
		
		System.out.println("Paladins");
		System.out.println("--------");
		System.out.println("Name/mana/strength/agility/dexterity/starting money/starting experience\r\n"
				+ "6 Parzival             300     750     650     700     2500    7\r\n"
				+ "7 Sehanine_Moonbow     300     750     700     700     2500    7\r\n"
				+ "8 Skoraeus_Stonebones  250     650     600     350     2500    4\r\n"
				+ "9 Garl_Glittergold     100     600     500     400     2500    5\r\n"
				+ "10 Amaryllis_Astra      500     500     500     500     2500    5\r\n"
				+ "11 Caliber_Heist        400     400     400     400     2500    8");
		System.out.println("");
		
		System.out.println("Sorcerers");
		System.out.println("---------");
		System.out.println("Name/mana/strength/agility/dexterity/starting money/starting experience\r\n"
				+ "12 Rillifane_Rallathil     1300    750     450     500     2500    9\r\n"
				+ "13 Segojan_Earthcaller     900     800     500     650     2500    5\r\n"
				+ "14 Reign_Havoc             800     800     800     800     2500    8\r\n"
				+ "15 Reverie_Ashels          900     800     700     400     2500    7\r\n"
				+ "16 Kalabar                 800     850     400     600     2500    6\r\n"
				+ "17 Skye_Soar               1000    700     400     500     2500    5");
		System.out.println("");
		
		int numHeroesAdded = 0;
		
		while(numHeroesAdded < 3) {
			System.out.println("Which hero would you like to add to your party? Please enter the index next to their name.");
			int response = scan.nextInt();
			party.add(heroes.get(response));
			numHeroesAdded++;
			System.out.println(heroes.get(response).getName() + " has been added to the party.");
			
			if(numHeroesAdded < 3) {
				System.out.println("Would you like to add another hero to the party? (Y/N)");
				String s = scan.next();
				if(s.equals("N") || s.equals("n")) {
					break;
				}
			}
		}
		System.out.println("Your party is complete. It consists of:\r\n");
		for(int i = 0; i < party.size(); i++) {
			System.out.println(party.get(i) + "\n");
		}
	}
	
	// The user is presented with the wares that are offered at the market they're currently on
	// Each hero in the party receieves the option to purchase or sell items with the vendor
	public static void openMarket() {
		Market market = board.get(pos.x, pos.y).getMarket();
		for(int i = 0; i < party.size(); i++) {
			boolean temp = true;
			
			while(temp) {
				market.printMarket();
				System.out.println("\n");
				System.out.println(party.get(i).getName() + ", you have " + party.get(i).getBalance() + " gold. Would you like to buy or sell items? Enter B/b for buy, S/s for sell, or X/x to exit.");
				String resp0 = scan.next();
				if(resp0.equals("S") || resp0.equals("s")) {
					// Print inventory and allow sale of items
					party.get(i).checkInventory();
					if(party.get(i).getInventory().isEmpty()) {
						break;
					}
					System.out.println(party.get(i).getName() + ", select which item you would like to sell, if any, by entering the index next to the item name. Enter X to exit.");
					String resp1 = scan.next();
					
					if(resp1.equals("X") || resp1.equals("x")) {
						break;
					}
					
					else {
						party.get(i).sell(Integer.parseInt(resp1));
					}
					
					System.out.println("Would you like to sell/purchase another item? (Y/N)");
					String resp2 = scan.next();
					if(resp2.equals("N") || resp2.equals("n")) {
						temp = false;
					}
					
				}
				
				else if(resp0.equals("B") || resp0.equals("b")) {
					System.out.println("Select which item you would like to purchase, if any, by entering the index next to the item name. Enter X to exit.");
					String resp1 = scan.next();
					
					if(resp1.equals("X") || resp1.equals("x")) {
						break;
					}
					
					else {
						party.get(i).purchase(market.get(Integer.parseInt(resp1)));
					}
					
					System.out.println("Would you like to sell/purchase another item? (Y/N)");
					String resp2 = scan.next();
					if(resp2.equals("N") || resp2.equals("n")) {
						temp = false;
					}
				}
				
				else {
					break;
				}
			}
		}
	}
	
	// Helper function to determine whether all of the heroes in the party are still alive (more than 0 health)
	public static boolean heroesStanding() {
		boolean temp = false;
		for(int i = 0; i < party.size(); i++) {
			if(party.get(i).getHealth() > 0) {
				temp = true;
			}
		}
		return temp;
	}
	
	// Helper function to determine whether all of the monsters in an enemy party are still alive (more than 0 health)
	public static boolean monstersStanding(ArrayList<Monster> mList) {
		boolean temp = false;
		for(int i = 0; i < mList.size(); i++) {
			if(mList.get(i).getHealth() > 0) {
				temp = true;
			}
		}
		return temp;
	}
	
	// Helper function to determine the total level of the monster group for purposes of awarding EXP and gold
	public static int totalMonsterLvl(ArrayList<Monster> mList) {
		int totalLevel = 0;
		for(int i = 0; i < mList.size(); i++) {
			totalLevel += mList.get(i).getLevel();
		}
		return totalLevel;
	}
	
	// Helper function to print the state of the battle
	public static void printBattleState(ArrayList<Monster> mList) {
		System.out.println("Your party:");
		System.out.println("-----------");
		for(int i = 0; i < party.size(); i++) {
			System.out.println(party.get(i).getName() + " | HP: " + party.get(i).getHealth() + " | MP: " + party.get(i).getMana());
		}
		System.out.println("");
		System.out.println("Enemy party:");
		System.out.println("------------");
		for(int j = 0; j < mList.size(); j++) {
			System.out.println(mList.get(j).getName() + " | HP: " + mList.get(j).getHealth());
		}
	}
	
	// Helper function for facilitating monsters intelligence during combat
	// In general, monsters will randomly choose between all living heroes as their target
	public static int monsterTargeting() {
		if(!heroesStanding()) {
			System.out.println("Game over.");
			System.exit(0);
		}
		
		int target = -1;
		while(target == -1) {
			int rand = (int) (Math.random()*(party.size()));
			if(party.get(rand).getHealth() > 0) {
				target = rand;
			}
		}
		return target;
	}
	
	// Helper function that rolls a die each time the party steps on a Common tile.
	// There is an 18% chance that the heroes face combat each time they step onto a Common tile.
	public static void checkForEnemies() {
		if(board.get(pos.x, pos.y).getType() == 'C') {
			double roll = Math.random();
			if(roll < 0.18) {
				engageBattle();
			}
		}
	}
	
	// Facilitates combat once an enemy has been encountered
	// Encapsulates enemy creation, turn-based combat between the heroes and the enemies, and the rewarding of gold and EXP should the heroes emerge victorious.
	public static void engageBattle() {
		// Generate party of monsters based on party size and highest level party member
		ArrayList<Monster> enemies = new ArrayList<Monster>();
		
		for(int i = 0; i < party.size(); i++) {
			enemies.add(monsters.summonLevel(party.get(i).getLevel())); // Add a monster for each party member that is equivalent to each party member's level
		}
		
		System.out.println("STAND GUARD! AN ENEMY HAS APPEARED!");
		System.out.println("-----------------------------------\n");
		
		// Simulate battle
		while(heroesStanding() && monstersStanding(enemies)) { // While someone is still standing, keep going
			printBattleState(enemies); // Print HP and Mana of all party members + monsters
			
			// All heroes with >0 health take an action!
			for(int i = 0; i < party.size(); i++) {
				if(party.get(i).getHealth() <= 0) {
					continue;
				}
				System.out.println(party.get(i).getName() + ", it's your turn. Which action would you like to take?");
				System.out.println("A/a: Attack || P/p: Access inventory to cast spell/equip item/use potion || I/i: View party information || X/x: pass turn");
				String resp = scan.next();
				
				if(resp.equals("A") || resp.equals("a")) {
					// Select target to attack
					System.out.println("Who would you like to attack? Select the index next to the name of the enemy you would like to attack.\n");
					System.out.println("Enemy party:");
					System.out.println("------------");
					for(int j = 0; j < enemies.size(); j++) {
						System.out.println(j + " " + enemies.get(j).getName() + " | HP:" + enemies.get(j).getHealth());
					}
					
					int atkTarget = scan.nextInt();
					
					// Deal damage
					System.out.println(party.get(i).getName() + " attacks " + enemies.get(atkTarget).getName() + " for " + enemies.get(atkTarget).takeDamage(party.get(i).attack()) + " damage!");

					if(enemies.get(atkTarget).getHealth() <= 0) {
						enemies.get(atkTarget).setHealth(0);
						System.out.println(enemies.get(atkTarget).getName() + " faints!");
					}
				}
				
				else if(resp.equals("P") || resp.equals("p")) {
					party.get(i).checkInventory();
					System.out.println("");
					
					if(party.get(i).getInventory().isEmpty()) {
						i--;
						continue;
					}
					
					System.out.println(party.get(i).getName() + ", select which item you would like to equip/use, if any, by entering the index next to the item name. Enter X to exit.");
					String resp3 = scan.next();
					
					if(resp3.equals("X") || resp3.equals("x")) {
						i--;
						continue;
					}
					
					else if(party.get(i).getInventory().get(Integer.parseInt(resp3)) instanceof Spell) {
						// Select target to attack
						System.out.println("Who would you like to cast your spell on? Select the index next to the name of the enemy you would like to target.\n");
						System.out.println("Enemy party:");
						System.out.println("------------");
						for(int j = 0; j < enemies.size(); j++) {
							System.out.println(j + " " + enemies.get(j).getName() + " | HP: " + enemies.get(j).getHealth() + "\n");
						}
						
						int atkTarget = scan.nextInt();
						Spell s = (Spell) party.get(i).getInventory().get(Integer.parseInt(resp3));
						
						
						// Deal damage
						System.out.println(party.get(i).getName() + " casts " + s.getName() + " and deals " + enemies.get(atkTarget).takeDamage(party.get(i).cast(Integer.parseInt(resp3))) 
								+ " damage to " + enemies.get(atkTarget).getName() + "!");
						
						if(enemies.get(atkTarget).getHealth() <= 0) {
							enemies.get(atkTarget).setHealth(0);
							System.out.println(enemies.get(atkTarget).getName() + " faints!");
						}
					}
					
					else{
						party.get(i).equip(Integer.parseInt(resp3)); // The item selected is a weapon/armor/potion and is handled normally
						System.out.println("\n");
					}
				}
				
				else if(resp.equals("I") || resp.equals("i")) {
					System.out.println("Here is your party information: ");
					for(int o = 0; o < party.size(); o++) {
						System.out.println(party.get(o) + "\n");
						party.get(o).getEquipment().printEquipment();
					}
					i--;
				}
				
				else if(resp.equals("X") || resp.equals("x")){
					continue;
				}
				
				else {
					System.out.println("Invalid input. Try again.");
					i--;
				}
			}
			
			// Now, it's the monster's turn!
			for(int i = 0; i < enemies.size(); i++) {
				if(enemies.get(i).getHealth() > 0) {
					int atkTarget = monsterTargeting(); // Pick a random standing hero
					System.out.println(enemies.get(i).getName() + " attacks " + party.get(atkTarget).getName() + " for " + party.get(atkTarget).takeDamage(enemies.get(i).attack()) + " damage!"); // Attack them
					if(party.get(atkTarget).getHealth() <= 0) {
						party.get(atkTarget).setHealth(0);
						System.out.println(party.get(atkTarget).getName() + " faints!");
					}
				}
			}
			
			// Regenerate health and mana at the end of each turn
			for(int i = 0; i < party.size(); i++) {
				if(party.get(i).getHealth() > 0) {
					party.get(i).setHealth((int) (party.get(i).getHealth() * 1.1));
					party.get(i).setMana((int) (party.get(i).getMana() * 1.1));
				}
			}
		}
		
		if(!heroesStanding()) {
			System.out.println("Game over. All of your heroes have perished.");
			System.exit(0); // End the program to terminate the game
		}
		
		// Resolve battle (Game Over / Gold Distribution / Level Distribution)
		else if(heroesStanding() && !monstersStanding(enemies)) {
			System.out.println("Victory!");
			for(int i = 0; i < party.size(); i++) {
				if(party.get(i).getHealth() > 0) { // If the hero hasn't fainted
					// Announce gained gold and EXP
					System.out.println(party.get(i).getName() + " gains " + totalMonsterLvl(enemies)*100 + " gold and " + totalMonsterLvl(enemies) + " EXP!\n");
					
					// Reward gold
					party.get(i).setBalance(party.get(i).getBalance() + (totalMonsterLvl(enemies)*100));
					
					// Reward experience and level up
					party.get(i).setEXP(party.get(i).getEXP() + totalMonsterLvl(enemies));
					party.get(i).updateLevel(); // Check their level and update accordingly
				}
				else { // if they fainted, simply resurrect them with half health and mana.
					party.get(i).setHealth(50 * party.get(i).getLevel());
					party.get(i).setMana((int) (0.5 * party.get(i).getMana()));
				}
			}
		}
	}
	
	public static void main(String args[]) {
		boolean keepPlaying = true; // A boolean handling whether the user wants to continue playing, True - keep playing, False - end game
		
		// Then, let's facilitate character creation!
		
		selectCharacter(); // Character selection for the party
		
		board.printBoard(); // Print the initial board -- you are located at X!
		
		while(keepPlaying) {
			String resp = scan.nextLine();
			System.out.println("W/w: Move up || A/a: Move left || S/s: Move down || D/d: Move right\r\n" + "Q/q: Quit game || I/i: Show information || M/m: Enter market || O/o: Show map || P/p: Show inventory\n");
			
			// W/w: Move up
			if((resp.equals("W") || resp.equals("w")) && board.inBound(new Tuple(pos.x, pos.y+1)) && board.get(pos.x, pos.y+1).getType() != 'I') {
				board.get(pos.x, pos.y).setOccupied(false);
				pos = new Tuple(pos.x, pos.y+1);
				board.get(pos.x, pos.y).setOccupied(true);
				checkForEnemies();
				board.printBoard();
			}
			
			// A/a: Move left
			else if((resp.equals("A") || resp.equals("a")) && board.inBound(new Tuple(pos.x-1, pos.y)) && board.get(pos.x-1, pos.y).getType() != 'I') {
				board.get(pos.x, pos.y).setOccupied(false);
				pos = new Tuple(pos.x-1, pos.y);
				board.get(pos.x, pos.y).setOccupied(true);
				checkForEnemies();
				board.printBoard();
			}
			
			// S/s: Move down
			else if((resp.equals("S") || resp.equals("s")) && board.inBound(new Tuple(pos.x, pos.y-1)) && board.get(pos.x, pos.y-1).getType() != 'I') {
				board.get(pos.x, pos.y).setOccupied(false);
				pos = new Tuple(pos.x, pos.y-1);
				board.get(pos.x, pos.y).setOccupied(true);
				checkForEnemies();
				board.printBoard();
			}
			
			// D/d: Move right
			else if((resp.equals("D") || resp.equals("d")) && board.inBound(new Tuple(pos.x+1, pos.y)) && board.get(pos.x+1, pos.y).getType() != 'I') {
				board.get(pos.x, pos.y).setOccupied(false);
				pos = new Tuple(pos.x+1, pos.y);
				board.get(pos.x, pos.y).setOccupied(true);
				checkForEnemies();
				board.printBoard();
			}
			
			// Q/q: Quit game
			else if((resp.equals("Q") || resp.equals("q"))) {
				System.out.println("Game over. Thanks for playing!");
				break;
			}
			
			// I/i: Show information
			else if((resp.equals("I") || resp.equals("i"))) {
				System.out.println("Here is your party information: ");
				for(int i = 0; i < party.size(); i++) {
					System.out.println(party.get(i) + "\n");
					party.get(i).getEquipment().printEquipment();
				}
			}
			
			// M/m: Show market
			else if((resp.equals("M") || resp.equals("m"))) {
				if(board.get(pos.x, pos.y).getType() != 'M') {
					System.out.println("You are currently not at a market tile. Please move to a market tile to purchase/sell with a vendor.");
				}
				else {
					System.out.println("Entering market: ");
					openMarket();
					
				}
			}
			
			// O/o: Show map
			else if((resp.equals("O") || resp.equals("o"))) {
				board.printBoard();
			}
			
			// P/p: Show inventory
			else if((resp.equals("P") || resp.equals("p"))) {
				
				System.out.println("Your party:\n" + "-----------");
				for(int i = 0; i < party.size(); i++) {
					System.out.println(i + " " + party.get(i).getName());
				}
				System.out.println("");
				
				System.out.println("Whose inventory would you like to view? Please enter the index next to their name.");
				int resp2 = scan.nextInt();
				
				if(resp2 >= party.size()) {
					System.out.println("Invalid index. Exiting inventory view now.");
				}
				
				else {
					party.get(resp2).checkInventory();
					System.out.println("");
					
					if(party.get(resp2).getInventory().isEmpty()) {
						continue;
					}
					
					System.out.println(party.get(resp2).getName() + ", select which item you would like to equip/use, if any, by entering the index next to the item name. Enter -1 to exit.");
					int resp3 = scan.nextInt();
					
					if(resp3 == -1) {
						continue;
					}
					else if(party.get(resp2).getInventory().get(resp3) instanceof Spell) {
						System.out.println("Invalid selection. Spells cannot be cast outside of combat.");
						continue;
					}
					else {
						party.get(resp2).equip(resp3);
						System.out.println("\n");
					}
				}
			}
		}
	}
}
