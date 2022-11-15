import java.util.ArrayList;
import java.util.Scanner;

// A subclass of the Creature class
// Represents

public class Hero extends Creature {
	private String job; // The hero's job/class: Warrior, Paladin, Sorcerer
	private int experience; // The hero's current amount of experience points
	private int mana; // The hero's current mana -- mana is required to cast spell scrolls during combat
	private int strength; // The hero's strength stat -- strength is used when calculating how much damage their attack does during combat
	private int dexterity; // The hero's dexterity stat -- dexterity is used when calculating how much damage a spell does during combat
	private int agility; // The hero's agility stat -- agility is used when calculating the hero's dodge chance upon getting attacked
	private int goldBalance; // The hero's balance in gold coins
	
	private static Inventory inventory = new Inventory();
	private static Equipment equipped = new Equipment();	
	public static Scanner scan = new Scanner(System.in);
	
	// Default constructor
	public Hero() {
		super();
	}
	
	public Hero(String n, int l, int h, String j, int x, int m, int s, int d, int a, int g) { // Use indexing to create the proper character
		super(n, l, h);
		job = j;
		experience = x;
		mana = m;
		strength = s;
		dexterity = d;
		agility = a;
		goldBalance = g;
	}
	
	// Checks whether the hero is able to level up and does so!
	public void updateLevel() {
		while(experience >= (10*this.getLevel())) { // While the hero is able to level up
			System.out.println(this.getName() + " levels up from Level " + this.getLevel() + " to Level " + (this.getLevel()+1) +"!\n");
			experience -= 10*this.getLevel(); // Subtract the hero's current experience
			this.setLevel(this.getLevel()+1); // Increment the hero's level
			mana *= 1.1; // Increment their mana
		}
		this.setHealth(this.getLevel() * 100); // Reset their HP
	}
	
	// Returns a hero's attack value
	public double attack() {
		return ((strength + equipped.getWeapon().getDamage()) * 0.5);
	}
	
	// Returns a hero's dodge chance
	public double dodge() {
		return (agility * 0.0005);
	}
	
	// Applies damage to hero (after mitigation from dodge chance and defense) and returns the amount of damage taken by the hero
	public double takeDamage(double d) {
		double roll = Math.random();
		if(roll < dodge()) {
			System.out.println("Attack dodged!");
			return 0.0;
		}
		else {
			double dmg = d - (0.5 * equipped.getArmor().getDamageReduction());
			this.setHealth(this.getHealth() - dmg);
			return dmg;
		}
	}
	
	// Consumes a spell scroll and returns the amount of damage the spell deals after factoring in hero dexterity
	public double cast(int i) {
		Spell s;
		if(inventory.get(i) instanceof Spell) {
			s = (Spell) inventory.remove(i);
		}
		else {
			System.out.println("You didn't select a spell.");
			return 0.0;
		}
		
		if(mana < s.getCost()) {
			System.out.println("You don't have enough mana. The spell fizzles, and the scroll is consumed.");
			return 0.0;
		}
		
		mana -= s.getCost();
		return s.getPotency() + ((dexterity/10000) * s.getPotency());
	}
	
	// A toString() method that allows us to print the Hero's statistics and traits in a readable format
	public String toString() {
		return this.getName() + "\r\n" + "Level " + this.getLevel() + "\r\n" + "EXP: " + experience + "/" + (this.getLevel()*10) + "\r\n" + 
				"HP: " + this.getHealth() + "\r\n" + "Mana: " + mana + "\r\n" + "Class: " + job + "\r\n" + "Strength: " + strength + "\r\n" + "Dexterity: " + dexterity
				+ "\r\n" + "Agility: " + agility + "\r\n" + "Gold: " + goldBalance;
	}
	
	// Displays the inventory in the terminal
	public void checkInventory() {
		inventory.printInventory();
	}
	
	// Takes in an index pointing to an item in the hero's inventory
	// Equips the item (weapon/armor) or consumes the potion
	// Does not allow you to "equip" a spell
	public void equip(int i) {
		Item obj = inventory.get(i);
		if(obj instanceof Weapon) {
			equip((Weapon) inventory.remove(i));
		}
		
		else if(obj instanceof Armor) {
			equip((Armor) inventory.remove(i));
		}
		
		else if(obj instanceof Potion) {
			equip((Potion) inventory.remove(i));
		}
		else {
			System.out.println("Spells can only be used in combat.");
		}
	}
	
	// Helper method for equipping a weapon
	public void equip(Weapon weapon) {
		inventory.add(equipped.getWeapon()); // Take off the current weapon
		equipped.setWeapon(weapon); // Equip the new weapon
		System.out.println(this.getName() + " equips a " + weapon.getName() + ". They gain " + weapon.getDamage() + " base attack damage.");
	}
	
	// Helper method for equipping a piece of armor
	public void equip(Armor armor) {
		inventory.add(equipped.getArmor()); // Take off the current armor
		equipped.setArmor(armor); // Equip the new armor
		System.out.println(this.getName() + " equips a " + armor.getName() + ". They gain " + armor.getDamageReduction() + " damage reduction.");
	}
	
	// Helper method for consuming a potion
	public void equip(Potion potion) {
		if(potion.getName().equals("Healing Potion")) {
			System.out.println(this.getName() + " gains " + potion.getPotency() + " health. "
					+ "Their base health has increased from " + this.getHealth() + " to " + (this.getHealth() + potion.getPotency()));
			
			this.setHealth(this.getHealth() + potion.getPotency());
		}
		else if(potion.getName().equals("Strength Potion")) {
			System.out.println(this.getName() + " gains " + potion.getPotency() + " strength. "
					+ "Their base strength has increased from " + strength + " to " + (strength + potion.getPotency()));
			
			this.setStrength(this.getStrength() + potion.getPotency());
		}
		else if(potion.getName().equals("Magic Potion")) {
			System.out.println(this.getName() + " gains " + potion.getPotency() + " mana. "
					+ "Their base mana has increased from " + mana + " to " + (mana + potion.getPotency()));
			
			this.setMana(this.getMana() + potion.getPotency());
		}
		else if(potion.getName().equals("Luck Elixir")) {
			System.out.println(this.getName() + " gains " + potion.getPotency() + " agility. "
					+ "Their base agility has increased from " + agility + " to " + (agility + potion.getPotency()));
			
			this.setAgility(this.getAgility() + potion.getPotency());
		}
		else if(potion.getName().equals("Mermaid Tears")) {
			System.out.println(this.getName() + " gains " + potion.getPotency() + " health, mana, strength, and agility. "
					+ "Their base health has increased from " + this.getHealth() + " to " + (this.getHealth() + potion.getPotency())
					+ "Their base mana has increased from " + mana + " to " + (mana + potion.getPotency())
					+ "Their base strength has increased from " + strength + " to " + (strength + potion.getPotency())
					+ "Their base agility has increased from " + agility + " to " + (agility + potion.getPotency()));
			
			this.setHealth(this.getHealth() + potion.getPotency());
			this.setMana(this.getMana() + potion.getPotency());
			this.setStrength(this.getStrength() + potion.getPotency());
			this.setAgility(this.getAgility() + potion.getPotency());
		}
		else if(potion.getName().equals("Ambrosia")) {
			System.out.println(this.getName() + " gains " + potion.getPotency() + " health, mana, strength, and agility. "
					+ "Their base health has increased from " + this.getHealth() + " to " + (this.getHealth() + potion.getPotency())
					+ "Their base mana has increased from " + mana + " to " + (mana + potion.getPotency())
					+ "Their base strength has increased from " + strength + " to " + (strength + potion.getPotency())
					+ "Their base dexterity has increased from " + dexterity + " to " + (dexterity + potion.getPotency())
					+ "Their base agility has increased from " + agility + " to " + (agility + potion.getPotency()));
			
			this.setHealth(this.getHealth() + potion.getPotency());
			this.setMana(this.getMana() + potion.getPotency());
			this.setStrength(this.getStrength() + potion.getPotency());
			this.setDexterity(this.getDexterity() + potion.getPotency());
			this.setAgility(this.getAgility() + potion.getPotency());
		}
	}
	
	// Facilitates the purchase of an item
	// Deducts the cost from the hero's gold balance and adds the item to their inventory
	public void purchase(Item i) {
		if(goldBalance < i.getPrice()) {
			System.out.println("Insufficient funds.");
		}
		else if(this.getLevel() < i.getLevel()) {
			System.out.println("You're not high level enough to purchase a " + i.getName() + ".");
		}
		else {
			goldBalance -= i.getPrice();
			inventory.add(i);
			System.out.println(this.getName() + " purchases a " + i.getName() + " for " + i.getPrice() + " gold.");
		}
	}
	
	// Facilitates the sale of an item
	// Adds the value (which is half of the item's initial value) to the hero's gold balance and removes the item from their inventory
	public void sell(int i) {
		System.out.println(this.getName() + " sells a " + inventory.get(i).getName() + " for " + (0.5 * inventory.get(i).getPrice()) + " gold. Your balance is now " + goldBalance + ".");
		goldBalance += (0.5 * inventory.remove(i).getPrice());
	}
	
	// GET method for the hero's class/job
	public String getJob() {
		return job;
	}
	
	// GET method for the hero's current EXP
	public int getEXP() {
		return experience;
	}
	
	// SET method for the hero's current EXP
	public void setEXP(int x) {
		experience = x;
	}
	
	// GET method for the hero's current mana
	public int getMana() {
		return mana;
	}
	
	// SET method for the hero's current mana
	public void setMana(int m) {
		mana = m;
	}
	
	// GET method for the hero's strength
	public int getStrength() {
		return strength;
	}
	
	// SET method for the hero's strength
	public void setStrength(int s) {
		strength = s;
	}
	
	// GET method for the hero's dexterity
	public int getDexterity() {
		return dexterity;
	}
	
	// SET method for the hero's dexterity
	public void setDexterity(int d) {
		dexterity = d;
	}
	
	// GET method for the hero's agility
	public int getAgility() {
		return agility;
	}
	
	// SET method for the hero's agility
	public void setAgility(int a) {
		agility = a;
	}
	
	// GET method for the hero's gold balance
	public int getBalance() {
		return goldBalance;
	}
	
	// SET method for the hero's gold balance
	public void setBalance(int g) {
		goldBalance = g;
	}
	
	// GET method for the hero's inventory
	public Inventory getInventory() {
		return inventory;
	}
	
	// GET method for the hero's equipped loadout
	public Equipment getEquipment() { 
		return equipped;
	}
}
