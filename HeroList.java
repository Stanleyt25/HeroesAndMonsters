import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

// Class to store a list of heroes from the file
public class HeroList {
    ArrayList<Warrior> warriors = new ArrayList<Warrior>();
    ArrayList<Paladin> paladins = new ArrayList<Paladin>();
    ArrayList<Sorcerer> sorcerers = new ArrayList<Sorcerer>();

    HeroList(){
        createHeroes("csvFiles/Heroes/Paladins.txt", "P");
        createHeroes("csvFiles/Heroes/Sorcerers.txt", "S");
        createHeroes("csvFiles/Heroes/Warriors.txt", "W");
//        printHeroes();
    }

    // Display hero types
    public void displayHeroTypes(){
        System.out.println("1. Warrior");
        System.out.println("2. Paladin");
        System.out.println("3. Sorcerer");
    }

    private void createHeroes(String fileName, String type){
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
                if(type == "P"){
                    Paladin paladin = new Paladin(attributes);
                    paladins.add(paladin);
                }
                if(type == "S"){
                    Sorcerer sorcerer = new Sorcerer(attributes);
                    sorcerers.add(sorcerer);
                }
                if(type == "W"){
                    Warrior warrior = new Warrior(attributes);
                    warriors.add(warrior);
                }
                // read next line before looping
                // if end of file reached, line would be null
                line = br.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public int displayPaladins(){
        int index = 1;
        for(Paladin p: paladins){
            System.out.println(index++ +" --(info)--> "+ p.toString());
        }
        return index-1;
    }

    public int displayWarriors(){
        int index = 1;
        for(Warrior w: warriors){
            System.out.println(index++ +" --(info)--> "+ w.toString());
        }
        return index-1;
    }

    public int displaySorcerers(){
        int index = 1;
        for(Sorcerer s: sorcerers){
            System.out.println(index++ +" --(info)--> "+ s.toString());
        }
        return index-1;
    }

    public void printHeroes() {
        for(Paladin p: paladins){
            System.out.println(p.toString());
        }
        for(Warrior w: warriors){
            System.out.println(w.toString());
        }
        for(Sorcerer s: sorcerers){
            System.out.println(s.toString());
        }
    }

    public Paladin getPaladin( int i ) {
        return paladins.get(i);
    }

    public Warrior getWarrior( int i ) {
        return warriors.get(i);
    }

    public Sorcerer getSorcerer( int i ) {
        return sorcerers.get(i);
    }
}
