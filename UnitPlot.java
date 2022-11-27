// Represents a unit cell of the world
public class UnitPlot {
    String type;
    char character;
    boolean heroPresent = false;
    boolean battleHere;
    UnitPlot(String type) {
        this.type = type;
        if (type == "Inaccessible")
            character = 'x';
        if (type == "CommonSpace")
            character = ' ';
        if (type == "MarketSpace")
            character = 'm';
    }

    public char getDisplayableCharacter(){
        if(heroPresent) return 'h';
        return character;
    }
}
