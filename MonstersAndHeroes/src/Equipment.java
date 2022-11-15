// A class handling the equipment that a hero may have equipped: a weapon, armor, and potions
// Every HERO has Equipment

public class Equipment {
	private Weapon weapon; // The weapon that is equipped by the hero
	private Armor armor; // The armor that is equipped by the hero
	
	public Equipment() {
		weapon = new Weapon();
		armor = new Armor();
	}
	
	// Allows the printing of equipment in a displayable/readable format
	public void printEquipment() {
		System.out.println("Equipped weapon: " + weapon.getName() + " / Level: " + weapon.getLevel() + " / Damage: " + weapon.getDamage());
		System.out.println("Equipped armor: " + armor.getName() + " / Level: " + armor.getLevel() + " / Damage reduction: " + armor.getDamageReduction() + "\n");
	}
	
	// GET method for weapon
	public Weapon getWeapon() {
		return weapon;
	}
	
	// SET method for weapon
	public void setWeapon(Weapon w) {
		weapon = w;
	}
	
	// GET method for armor
	public Armor getArmor() {
		return armor;
	}
	
	// SET method for armor
	public void setArmor(Armor a) {
		armor = a;
	}
}
