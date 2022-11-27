import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Market class to stock all the items in the market from the files
public class Market {

    public int mainMenu(){
        System.out.println("What would you like to trade?");
        System.out.println("1. Weapons");
        System.out.println("2. Armor");
        System.out.println("3. Potions");
        System.out.println("4. Spells");
        return 4;
    }

    public int getSpellTypes(){
        System.out.println("What spell type would you like to trade?");
        System.out.println("1. Fire");
        System.out.println("2. Ice");
        System.out.println("3. Lightining");
        return 3;
    }
}
