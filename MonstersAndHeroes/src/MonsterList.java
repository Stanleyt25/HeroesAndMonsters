import java.util.ArrayList;

// A class containing all the possible monsters in the game
// The Monster units in the list are all hard-coded and adapted from the Legends_Monsters_Heroes zip file provided with the assignment guidelines

public class MonsterList {
	
	private ArrayList<ArrayList<Monster>> monsters = new ArrayList<ArrayList<Monster>>();
	
	public MonsterList() {
		for(int i = 1; i <= 10; i++) {
			monsters.add(new ArrayList<Monster>());
		}
		
		//Dragons
		monsters.get(0).add(new Monster("Natsunomeryu", 1, 100, "Dragon", 100, 200, 10));
		monsters.get(1).add(new Monster("Chrysophylax", 2, 200, "Dragon", 200, 500, 20));
		monsters.get(2).add(new Monster("Desghidorrah", 3, 300, "Dragon", 300, 400, 35));
		monsters.get(3).add(new Monster("Bunsen Burner", 4, 400, "Dragon", 400, 500, 45));
		monsters.get(4).add(new Monster("Kas-Ethelinh", 5, 500, "Dragon", 600, 500, 60));
		monsters.get(5).add(new Monster("Phaarthurnax", 6, 600, "Dragon", 600, 700, 60));
		monsters.get(5).add(new Monster("Igneel", 6, 600, "Dragon", 600, 400, 60));
		monsters.get(6).add(new Monster("The Scaleless", 7, 700, "Dragon", 700, 600, 75));
		monsters.get(7).add(new Monster("The Weatherbe", 8, 800, "Dragon", 800, 900, 80));
		monsters.get(8).add(new Monster("D-Maleficent", 9, 900, "Dragon", 900, 950, 85));
		monsters.get(8).add(new Monster("Blue Eyes White", 9, 900, "Dragon", 900, 600, 75));
		monsters.get(9).add(new Monster("Alexstraszan", 10, 1000, "Dragon", 1000, 9000, 55));
		
		//Exoskeletons
		monsters.get(0).add(new Monster("Big Bad-Wolf", 1, 100, "Exosekelton", 150, 250, 15));
		monsters.get(1).add(new Monster("WickedWitch", 2, 200, "Exosekelton", 250, 350, 25));
		monsters.get(2).add(new Monster("Brandobaris", 3, 300, "Exosekelton", 350, 450, 30));
		monsters.get(3).add(new Monster("Aasterinian", 4, 400, "Exosekelton", 400, 500, 45));
		monsters.get(4).add(new Monster("St-Shargaas", 5, 500, "Exosekelton", 550, 650, 55));
		monsters.get(5).add(new Monster("Chronepsish", 6, 600, "Exosekelton", 650, 750, 60));
		monsters.get(5).add(new Monster("Doc Ock", 6, 600, "Exosekelton", 600, 600, 55));
		monsters.get(6).add(new Monster("Cyrrollalee ", 7, 700, "Exosekelton", 700, 800, 75));
		monsters.get(7).add(new Monster("Kiaransalee  ", 8, 800, "Exosekelton", 850, 950, 85));
		monsters.get(8).add(new Monster("St-Yeenoghu", 9, 900, "Exosekelton", 950, 850, 90));
		monsters.get(9).add(new Monster("Merrshaullk", 10, 1000, "Exosekelton", 1000, 900, 55));
		monsters.get(9).add(new Monster("Exodia", 10, 1000, "Exosekelton", 1000, 1000, 50));
		
		//Spirits
		monsters.get(0).add(new Monster("Blinky", 1, 100, "Spirit", 450, 350, 35));
		monsters.get(0).add(new Monster("Casper", 1, 100, "Spirit", 100, 100, 50));
		monsters.get(1).add(new Monster("Andrealphus", 2, 200, "Spirit", 600, 500, 40));
		monsters.get(2).add(new Monster("Andromalius", 3, 300, "Spirit", 550, 450, 25));
		monsters.get(3).add(new Monster("Chiang-shih", 4, 400, "Spirit", 700, 600, 40));
		monsters.get(4).add(new Monster("Fallen Angel", 5, 500, "Spirit", 800, 700, 50));
		monsters.get(5).add(new Monster("Ereshkigall", 6, 600, "Spirit", 950, 450, 35));
		monsters.get(6).add(new Monster("Melchiresas", 7, 700, "Spirit", 350, 150, 75));
		monsters.get(7).add(new Monster("Jormunngand", 8, 800, "Spirit", 600, 900, 20));
		monsters.get(8).add(new Monster("Rakkshasass", 9, 900, "Spirit", 550, 600, 35));
		monsters.get(8).add(new Monster("Taltecuhtli", 9, 900, "Spirit", 300, 200, 50));
	}
	
	// A helper method that takes in the desired LEVEL and randomly summons a monster of that level
	public Monster summonLevel(int i) {
		int rand = (int)(Math.random() * (monsters.get(i).size() + 1));
		Monster copy = monsters.get(i-1).get(rand);
		return (new Monster(copy.getName(), copy.getLevel(), (int) copy.getHealth(), copy.getType(), copy.getDamage(), copy.getDefense(), copy.getDodge()));
	}

}
