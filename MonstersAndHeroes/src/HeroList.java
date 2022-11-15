import java.util.ArrayList;

// Creates a list of all of the possible heroes
// Hard-coded from the provided reference heroes in the Legends_Monsters_Heroes zip folder

public class HeroList {

	private ArrayList<Hero> heroes;
	
	public HeroList() {
		heroes = new ArrayList<Hero>(); // 6 warriors, 6 sorcerors, and 6 paladins
		
		// Warriors
		heroes.add(new Hero("Gaerdal Ironhand", 1, 100, "Warrior", 7, 100, 700, 600, 500, 1354));
		heroes.add(new Hero("Sehanine Monnbow", 1, 100, "Warrior", 8, 600, 700, 500, 800, 2500));
		heroes.add(new Hero("Muamman Duathall", 1, 100, "Warrior", 6, 300, 900, 750, 500, 2546));
		heroes.add(new Hero("Flandal Steelskin", 1, 100, "Warrior", 7, 200, 750, 700, 650, 2500));
		heroes.add(new Hero("Undefeated Yoj", 1, 100, "Warrior", 7, 400, 800, 700, 400, 2500));
		heroes.add(new Hero("Eunoia Cyn", 1, 100, "Warrior", 6, 400, 700, 600, 800, 2500));
		
		// Paladins
		heroes.add(new Hero("Parzival", 1, 100, "Paladin", 7, 300, 750, 700, 650, 2500));
		heroes.add(new Hero("Sehanine Moonbow", 1, 100, "Paladin", 7, 300, 750, 700, 700, 2500));
		heroes.add(new Hero("Skoraeus Stonebones", 1, 100, "Paladin", 4, 250, 650, 350, 600, 2500));
		heroes.add(new Hero("Garl Glittergold", 1, 100, "Paladin", 5, 100, 600, 400, 500, 2500));
		heroes.add(new Hero("Amaryllis Astra", 1, 100, "Paladin", 5, 500, 500, 500, 500, 2500));
		heroes.add(new Hero("Caliber Heist", 1, 100, "Paladin", 8, 400, 400, 400, 400, 2500));
		
		
		// Sorcerers
		heroes.add(new Hero("Rillifane Rallathil", 1, 100, "Sorcerer", 9, 1300, 750, 500, 450, 2500));
		heroes.add(new Hero("Segojan Earthcaller", 1, 100, "Sorcerer", 5, 900, 800, 650, 500, 2500));
		heroes.add(new Hero("Reign Havoc", 1, 100, "Sorcerer", 8, 800, 800, 800, 800, 2500));
		heroes.add(new Hero("Reverie Ashels", 1, 100, "Sorcerer", 7, 900, 800, 400, 700, 2500));
		heroes.add(new Hero("Kalabar", 1, 100, "Sorcerer", 6, 800, 850, 600, 400, 2500));
		heroes.add(new Hero("Skye Soar", 1, 100, "Sorcerer", 5, 1000, 700, 500, 400, 2500));
	}
	
	// Retrieves and returns the hero located at index x in the list
	public Hero get(int x) {
		return heroes.get(x);
	}
}
