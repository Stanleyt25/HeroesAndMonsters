import java.util.Arrays;
// Represents the inventory item - called Potion i.e. used by heroes
public class Potion extends Item{
    String name;
    double price;
    int level;
    int effectAmt;
    String[] attributeAffected;
    Potion(String name, double price, int level, int effectAmt, String[] attributeAffected){
        this.name = name;
        this.price = price;
        this.level = level;
        this.effectAmt = effectAmt;
        this.attributeAffected = attributeAffected;
    }

    @Override
    public String toString() {
        return "Potion{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", level=" + level +
                ", effectAmt=" + effectAmt +
                ", attributeAffected=" + Arrays.toString(attributeAffected) +
                '}';
    }
}
