import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MarketList {

    ArrayList<Weapon> weapons = new ArrayList<Weapon>();
    ArrayList<Armor> armors = new ArrayList<Armor>();
    ArrayList<Potion> potions = new ArrayList<Potion>();
    ArrayList<Spell> fireSpells = new ArrayList<Spell>();
    ArrayList<Spell> iceSpells = new ArrayList<Spell>();
    ArrayList<Spell> lightningSpells = new ArrayList<Spell>();

    MarketList(){
        stockWeapons("csvFiles/Market/Weaponry.txt");
        stockArmors("csvFiles/Market/Armory.txt");
        stockPotions("csvFiles/Market/Potions.txt");
        stockFireSpells("csvFiles/Market/FireSpells.txt");
        stockIceSpells("csvFiles/Market/IceSpells.txt");
        stockLightningSpells("csvFiles/Market/LightningSpells.txt");
    }

    private void stockWeapons(String fileName){
        Path pathToFile = Paths.get(fileName);
        // create an instance of BufferedReader
        // using try with resource, Java 7 feature to close resources
        try (BufferedReader br = Files.newBufferedReader(pathToFile,
                StandardCharsets.US_ASCII)) {
            // read the first line from the text file
            String line = br.readLine();
            // loop until all lines are read
            while (line != null) {
                // use string.split to load a string array with the values from
                // each line of
                // the file, using a comma as the delimiter
                String[] attributes = line.split(",");
                Weapon weapon = new Weapon(attributes[0], Double.parseDouble(attributes[1]), Integer.parseInt(attributes[2]),Integer.parseInt(attributes[3]));
                weapons.add(weapon);
                // read next line before looping
                // if end of file reached, line would be null
                line = br.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public int printWeapons() {
        int index = 1;
        for(Weapon w: weapons){
            System.out.println(index +" --(info)--> "+w.toString());
            index++;
        }
        return index-1;
    }

    private void stockArmors(String fileName){
        Path pathToFile = Paths.get(fileName);
        // create an instance of BufferedReader
        // using try with resource, Java 7 feature to close resources
        try (BufferedReader br = Files.newBufferedReader(pathToFile,
                StandardCharsets.US_ASCII)) {
            // read the first line from the text file
            String line = br.readLine();
            // loop until all lines are read
            while (line != null) {
                // use string.split to load a string array with the values from
                // each line of
                // the file, using a comma as the delimiter
                String[] attributes = line.split(",");
                Armor armor = new Armor(attributes[0], Double.parseDouble(attributes[1]), Integer.parseInt(attributes[2]),Integer.parseInt(attributes[3]));
                armors.add(armor);
                // read next line before looping
                // if end of file reached, line would be null
                line = br.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public int printArmors() {
        int index = 1;
        for(Armor a: armors){
            System.out.println(index +" --(info)--> "+a.toString());
            index++;
        }
        return index-1;

    }

    private void stockPotions(String fileName){
        Path pathToFile = Paths.get(fileName);
        // create an instance of BufferedReader
        // using try with resource, Java 7 feature to close resources
        try (BufferedReader br = Files.newBufferedReader(pathToFile,
                StandardCharsets.US_ASCII)) {
            // read the first line from the text file
            String line = br.readLine();
            // loop until all lines are read
            while (line != null) {
                // use string.split to load a string array with the values from
                // each line of
                // the file, using a comma as the delimiter
                String[] attributes = line.split(",");

                String[] attsAffected = attributes[4].split("/");
                Potion potion = new Potion(attributes[0], Double.parseDouble(attributes[1]), Integer.parseInt(attributes[2]),Integer.parseInt(attributes[3]), attsAffected);
                potions.add(potion);
                // read next line before looping
                // if end of file reached, line would be null
                line = br.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public int printPotions() {
        int index = 1;
        for(Potion p: potions){
            System.out.println(index +" --(info)--> " + p.toString());
            index++;
        }
        return index-1;
    }

    private void stockFireSpells(String fileName){
        Path pathToFile = Paths.get(fileName);
        // create an instance of BufferedReader
        // using try with resource, Java 7 feature to close resources
        try (BufferedReader br = Files.newBufferedReader(pathToFile,
                StandardCharsets.US_ASCII)) {
            // read the first line from the text file
            String line = br.readLine();
            // loop until all lines are read
            while (line != null) {
                // use string.split to load a string array with the values from
                // each line of
                // the file, using a comma as the delimiter
                String[] attributes = line.split(",");
                Spell spell = new Spell(attributes[0], Double.parseDouble(attributes[1]), Integer.parseInt(attributes[2]),Integer.parseInt(attributes[3]), Integer.parseInt(attributes[4]),"Fire");
                fireSpells.add(spell);
                // read next line before looping
                // if end of file reached, line would be null
                line = br.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public int printFireSpells() {
        int index = 1;
        for(Spell s: fireSpells){
            System.out.println(index +" --(info)--> "+s.toString());
            index++;
        }
        return index-1;
    }

    private void stockIceSpells(String fileName){
        Path pathToFile = Paths.get(fileName);
        // create an instance of BufferedReader
        // using try with resource, Java 7 feature to close resources
        try (BufferedReader br = Files.newBufferedReader(pathToFile,
                StandardCharsets.US_ASCII)) {
            // read the first line from the text file
            String line = br.readLine();
            // loop until all lines are read
            while (line != null) {
                // use string.split to load a string array with the values from
                // each line of
                // the file, using a comma as the delimiter
                String[] attributes = line.split(",");
                Spell spell = new Spell(attributes[0], Double.parseDouble(attributes[1]), Integer.parseInt(attributes[2]),Integer.parseInt(attributes[3]), Integer.parseInt(attributes[4]),"Ice");
                iceSpells.add(spell);
                // read next line before looping
                // if end of file reached, line would be null
                line = br.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public int printIceSpells() {
        int index = 1;
        for(Spell s: iceSpells){
            System.out.println(index +" --(info)--> "+ s.toString());
        }
        return index-1;
    }

    private void stockLightningSpells(String fileName){
        Path pathToFile = Paths.get(fileName);
        // create an instance of BufferedReader
        // using try with resource, Java 7 feature to close resources
        try (BufferedReader br = Files.newBufferedReader(pathToFile,
                StandardCharsets.US_ASCII)) {
            // read the first line from the text file
            String line = br.readLine();
            // loop until all lines are read
            while (line != null) {
                // use string.split to load a string array with the values from
                // each line of
                // the file, using a comma as the delimiter
                String[] attributes = line.split(",");
                Spell spell = new Spell(attributes[0], Double.parseDouble(attributes[1]), Integer.parseInt(attributes[2]),Integer.parseInt(attributes[3]), Integer.parseInt(attributes[4]),"Lightning");
                lightningSpells.add(spell);
                // read next line before looping
                // if end of file reached, line would be null
                line = br.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public int printLightningSpells() {
        int index = 1;
        for(Spell s: lightningSpells){
            System.out.println(index +" --(info)--> " + s.toString());
            index++;
        }
        return index-1;
    }

    
}
