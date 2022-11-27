import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

// Class to contain a list of all the monsters, and retrieve them from the file
public class MonsterList {
    ArrayList<Dragon> dragons = new ArrayList<Dragon>();
    ArrayList<Exoskeleton> exoskeletons = new ArrayList<Exoskeleton>();
    ArrayList<Spirit> spirits = new ArrayList<Spirit>();

    MonsterList(){
        createMonsters("csvFiles/Monsters/Dragons.txt", "D");
        createMonsters("csvFiles/Monsters/Exoskeletons.txt", "E");
        createMonsters("csvFiles/Monsters/Spirits.txt", "S");
    }

    private void createMonsters(String fileName, String type){
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
                if(type == "D"){
                    Dragon dragon = new Dragon(attributes);
                    dragons.add(dragon);
                }
                if(type == "E"){
                    Exoskeleton exoskeleton = new Exoskeleton(attributes);
                    exoskeletons.add(exoskeleton);
                }
                if(type == "S"){
                    Spirit spirit = new Spirit(attributes);
                    spirits.add(spirit);
                }
                // read next line before looping
                // if end of file reached, line would be null
                line = br.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    // Get Random Monster
    public Monster getRandomMonster(){
        int monsterType = getRandomInteger(1, 30);
        // get dragon
        if(monsterType<10){
            int monsterIndex = getRandomInteger(0, dragons.size()-1);
            dragons.get(monsterIndex).hp = 1500;
            return dragons.get(monsterIndex);
        }
        // get exoskeleton
        else if(monsterType<20){
            int monsterIndex = getRandomInteger(0, exoskeletons.size()-1);
            exoskeletons.get(monsterIndex).hp = 1500;
            return exoskeletons.get(monsterIndex);
        }
        // get spirit
        int monsterIndex = getRandomInteger(0, spirits.size()-1);
        spirits.get(monsterIndex).hp = 1500;
        return spirits.get(monsterIndex);
    }

    // Local probability generator
    private int getRandomInteger(int minimum, int maximum){
        return ((int) (Math.random()*(maximum - minimum))) + minimum;
    }

    public void printMonsters() {
        for(Dragon d: dragons){
            System.out.println(d.toString());
        }
        for(Exoskeleton e: exoskeletons){
            System.out.println(e.toString());
        }
        for(Spirit s: spirits){
            System.out.println(s.toString());
        }
    }
}
