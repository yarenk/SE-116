package HeroOfTheDungeon;

public class Rooms {

    private final String description;
    private Monster monster;
    private final int numberOfMonsters;
    private final int numberOfTownPeople;
    private final boolean isLane;
    private Inventory inventory;


    public Rooms(String description, Monster monster, Inventory inventory) {
        this.description = description;
        this.monster = monster;
        this.numberOfMonsters = 1;
        this.numberOfTownPeople = 1;
        this.isLane = false;
        this.inventory = inventory;
    }

    public Rooms(String description, Monster monster1, Monster monster2, Inventory inventory) {
        this.description = description;
        this.monster = monster1;
        this.monster = monster2;
        this.numberOfMonsters = 2;
        this.numberOfTownPeople = 2;
        this.isLane = false;
        this.inventory = inventory;
    }

    public Rooms(String description, Monster monster1, Monster monster2, Monster monster3, Inventory inventory) {
        this.description = description;
        this.monster = monster1;
        this.monster = monster2;
        this.monster = monster3;
        this.numberOfMonsters = 3;
        this.numberOfTownPeople = 3;
        this.isLane = true;
        this.inventory = inventory;
    }

    public static Rooms newRaptor() {
        return new Rooms();
    }

    public static Rooms newMiniKrug() {
        return new Rooms();
    }

    public static Rooms newMurkWolf() {
        return new Rooms();
    }

    public static Rooms newGhoul() {
        return new Rooms();
    }

    public static Rooms newRoomInstance() {

    }


    @Override
    public String toString() {
        return description;
    }

    public String getDescription() {
        return description;
    }

    public int getNumberOfMonsters() {
        return numberOfMonsters;
    }

    public int getNumberOfTownPeople() {
        return numberOfTownPeople;
    }

    public boolean isLane() {
        return isLane;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }
}
