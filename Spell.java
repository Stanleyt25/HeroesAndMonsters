// Represents a type of inventory item called Spell i.e. used by Heroes.
// There are 3 types of spells.
public class Spell extends Item{
    String name;
    double price;
    int level;
    int damageVal;
    int manaCost;
    String type;
    Spell(String name, double price, int level, int damageVal, int manaCost, String type){
        this.name = name;
        this.price = price;
        this.level = level;
        this.damageVal = damageVal;
        this.manaCost = manaCost;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Spell{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", level=" + level +
                ", damageVal=" + damageVal +
                ", manaCost=" + manaCost +
                ", type='" + type + '\'' +
                '}';
    }
}
