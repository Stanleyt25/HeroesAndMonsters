// An interface reflecting the behavior shared between all creatures, including heroes and monsters 

public interface CreatureBehavior {
	public abstract void setName(String s);
	public abstract String getName();
	public abstract void setLevel(int i);
	public abstract int getLevel();
	public abstract void setHealth(double d);
	public abstract double getHealth();
	
	public abstract double attack(); // Every creature must be able to attack
	public abstract double dodge(); // Every creature must be able to dodge an attack
	public abstract double takeDamage(double d); // Every creature must be able to take damage
}
