import java.util.*;

// abstract prototype
interface Monster extends Cloneable {
    void display();
    Monster clone(); // for returning the clone of the monster
}

// concrete prototype
class AirMonster implements Monster {
    private String color;

    // Constructor
    AirMonster(String color) {
        this.color = color;
    }

    public void display() {
        System.out.println("This is air monster. The color of air monster is " + this.color);
    }

    public Monster clone() {
        try {
            return (Monster) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Clone not supported", e);
        }
    }
}

class LandMonster implements Monster {
    private String color;

    // Constructor
    LandMonster(String color) {
        this.color = color;
    }

    public void display() {
        System.out.println("This is land monster. The color of land monster is " + this.color);
    }

    public Monster clone() {
        try {
            return (Monster) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Clone not supported", e);
        }
    }
}

class MonsterRegistry {
    private static HashMap<String, Monster> map = new HashMap<>();

    void registerMonster(String key, Monster m) {
        map.put(key, m);
    }

    Monster createMonster(String name) {
        Monster m = map.get(name);
        if (m != null) {
            return m.clone();
        } 
        /*
        if(name.contains("Air")){
            return map.get("AirMonster").clone();
        }
            else if(name.contains("Land")){
            return map.get("LandMonster").clone();
        }
        */
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        MonsterRegistry registry = new MonsterRegistry();
        Monster airMonsterOriginal = new AirMonster("blue");
        Monster landMonsterOriginal = new LandMonster("black");
        registry.registerMonster("AirMonster", airMonsterOriginal);
        registry.registerMonster("LandMonster", landMonsterOriginal);

        
        Monster landMonster = registry.createMonster("LandMonster");
        landMonster.display();
        
        Monster airMonster = registry.createMonster("AirMonster");
        airMonster.display();
        
        System.out.println("Hashcode for original air monster prototype is "+ airMonsterOriginal.hashCode());
        System.out.println("Hashcode for clone air monster prototype is " + airMonster.hashCode());
    }
}