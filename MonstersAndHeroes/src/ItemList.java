import java.util.ArrayList;

// A class storing all of the possible items in the game 
// Hard-coded to included all of the items referenced in the provided Legends_Monsters_Heroes zip file

public class ItemList {
	private ArrayList<Item> items;
	
	public ItemList() {
		items = new ArrayList<Item>();
		
		// Weapons
		items.add(new Weapon("Sword", 500, 1, 800, 1));
		items.add(new Weapon("Bow", 300, 2, 500, 2));
		items.add(new Weapon("Scythe", 1000, 6, 1100, 2));
		items.add(new Weapon("Axe", 550, 5, 850, 1));
		items.add(new Weapon("Twin Swords", 1400, 8, 1600, 2));
		items.add(new Weapon("Dagger", 200, 1, 250, 1));
		
		// Armor
		items.add(new Armor("Platinum Shield", 150, 1, 200));
		items.add(new Armor("Breastplate", 350, 3, 600));
		items.add(new Armor("Full Body Armor", 1000, 8, 1100));
		items.add(new Armor("Wizard Shield", 1200, 10, 1500));
		items.add(new Armor("Guardian Angel", 1000, 10, 1000));
		
		// Potions
		items.add(new Potion("Healing Potion", 250, 1, 100, "Health"));
		items.add(new Potion("Strength Potion", 200, 1, 75, "Strength"));
		items.add(new Potion("Magic Potion", 350, 2, 100, "Mana"));
		items.add(new Potion("Luck Elixir", 500, 4, 65, "Agility"));
		items.add(new Potion("Mermaid Tears", 850, 5, 100, "All"));
		items.add(new Potion("Ambrosia", 1000, 8, 150, "All"));
		
		// Spells
		// Fire
		items.add(new Spell("Flame Tornado", 700, 4, 850, 300, "Fire"));
		items.add(new Spell("Breath of Fire", 350, 1, 450, 100, "Fire"));
		items.add(new Spell("Heat Wave", 450, 2, 600, 150, "Fire"));
		items.add(new Spell("Lava Comet", 800, 7, 1000, 550, "Fire"));
		items.add(new Spell("Hell Storm", 600, 3, 950, 600, "Fire"));
		
		// Ice
		items.add(new Spell("Snow Cannon", 500, 2, 650, 250, "Ice"));
		items.add(new Spell("Ice Blade", 250, 1, 450, 100, "Ice"));
		items.add(new Spell("Frost Blizzard", 750, 5, 850, 350, "Ice"));
		items.add(new Spell("Arctic Storm", 700, 6, 800, 300, "Ice"));
		
		// Lightning
		items.add(new Spell("Lightning Dagger", 400, 1, 500, 150, "Lightning"));
		items.add(new Spell("Thunder Blast", 750, 4, 950, 400, "Lightning"));
		items.add(new Spell("Electric Arrows", 550, 5, 650, 200, "Lightning"));
		items.add(new Spell("Spark Needles", 500, 2, 600, 200, "Lightning"));
	}
	
	// Returns the entire list of items
	public ArrayList<Item> getItems() {
		return items;
	}
	
	// Returns the item at index i in the list
	public Item get(int i) {
		return items.get(i);
	}
}
