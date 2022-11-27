// Parent class to all kinds of monsters
public class Monster {
    String name;
    int level;
    int baseDamage;
    int defense;
    int dodge;
    int hp;

    Monster(String[] attributes){
        this.name = attributes[0];
        this.level = Integer.parseInt(attributes[1]);
        this.baseDamage = Integer.parseInt(attributes[2]);
        this.defense = Integer.parseInt(attributes[3]);
        this.dodge = Integer.parseInt(attributes[4]);
    }

    @Override
    public String toString() {
        return "Monster{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", baseDamage=" + baseDamage +
                ", defense=" + defense +
                ", dodge=" + dodge +
                '}';
    }
}
