// A superclass for the Hero and Monster class
// It will capture the shared traits and commonalities between creatures and heroes
// For instance, all creatures have health, a level, and a name.

public abstract class Creature implements CreatureBehavior {
	private String name; 
	private int level;
	private double health;
	
	// Default constructor
	public Creature() {
		name = "Mister No Name";
		level = 1;
		health = 100.0;
	}
	
	public Creature(String n, int l, int h) {
		name = n;
		level = l;
		health = (double) h;
	}
	
	// SET method for name
	public void setName(String s) {
		name = s;
	}

	// GET method for name
	public String getName() {
		return name;
	}

	// SET method for level
	public void setLevel(int i) {
		level = i;
	}

	// GET method for level
	public int getLevel() {
		return level;
	}

	// SET method for health
	public void setHealth(double d) {
		health = d;
		
	}

	// GET method for health
	public double getHealth() {
		return health;
	}
}
