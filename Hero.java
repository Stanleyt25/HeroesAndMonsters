// The parent class to all kinds of heroes
public class Hero{
    // Declare variables
    String name;
    int mana;
    int strength;
    int agility;
    int dexterity;
    int money;
    int xp;
    HeroInventory inventory;
    int hp;
    int x;
    int y;
    Armor equippedArmor;
    Weapon equippedWeapon;

    // Initialize the variables
    Hero(String[] attributes){
        this.name = attributes[0];
        this.mana = Integer.parseInt(attributes[1]);
        this.strength = Integer.parseInt(attributes[2]);
        this.agility = Integer.parseInt(attributes[3]);
        this.dexterity = Integer.parseInt(attributes[4]);
        this.money = Integer.parseInt(attributes[5]);
        this.xp = Integer.parseInt(attributes[6]);
        this.inventory = new HeroInventory();
    }

    // Get the string format of object
    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", mana=" + mana +
                ", strength=" + strength +
                ", agility=" + agility +
                ", dexterity=" + dexterity +
                ", money=" + money +
                ", xp=" + xp +
                ", inventory=" + inventory +
                ", hp=" + hp +
                '}';
    }
}
