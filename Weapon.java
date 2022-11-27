// Weapons class that is an item in the inventory
public class Weapon extends Item{
    String name;
    double price;
    int level;
    int damage;
    Weapon(String name, double price, int level, int damage){
        this.name = name;
        this.price = price;
        this.level = level;
        this.damage = damage;
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", level=" + level +
                ", damage=" + damage +
                '}';
    }
}
