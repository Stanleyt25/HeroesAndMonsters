// Armor class that represents Armor i.e. an item
public class Armor extends Item{
    String name;
    double price;
    int level;
    int damageReduction;
    Armor(String name, double price, int level, int damageReduction){
        this.name = name;
        this.price = price;
        this.level = level;
        this.damageReduction = damageReduction;
    }

    @Override
    public String toString() {
        return "Armor{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", level=" + level +
                ", damageReduction=" + damageReduction +
                '}';
    }
}
