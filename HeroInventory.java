
import java.util.ArrayList;
// A class to store the hero's inventory
public class HeroInventory {
    ArrayList<Weapon> weapons = new ArrayList<Weapon>();
    ArrayList<Armor> armors = new ArrayList<Armor>();
    ArrayList<Potion> potions = new ArrayList<Potion>();
    ArrayList<Spell> fireSpells = new ArrayList<Spell>();
    ArrayList<Spell> iceSpells = new ArrayList<Spell>();
    ArrayList<Spell> lightningSpells = new ArrayList<Spell>();

    HeroInventory(){

    }

    public int showWeapons(){
        int index = 1;
        for(Weapon weapon: weapons){
            System.out.println(index+". "+weapon.toString());
            index++;
        }
        return index;
    }
    public int showArmors(){
        int index = 1;
        for(Armor armor: armors){
            System.out.println(index+". "+armor.toString());
            index++;
        }
        return index-1;
    }
    public int showPotions(){
        int index = 1;
        for(Potion potion: potions){
            System.out.println(index+". "+potion.toString());
            index++;
        }
        return index-1;
    }
    public int showfireSpells(){
        int index = 1;
        for(Spell fireSpell: fireSpells){
            System.out.println(index+". "+fireSpell.toString());
            index++;
        }
        return index-1;
    }
    public int showIceSpells(){
        int index = 1;
        for(Spell iceSpell: iceSpells){
            System.out.println(index+". "+iceSpell.toString());
            index++;
        }
        return index-1;
    }
    public int showLightningSpell(){
        int index = 1;
        for(Spell lightningSpell: lightningSpells){
            System.out.println(index+". "+lightningSpell.toString());
            index++;
        }
        return index-1;
    }
}
