package HeroOfTheDungeon;

public class Rooms {

    private final String description;
    private Monster monster;
    private final int numberOfMonsters;
    private final int numberOfTownPeople;
    private final boolean isLane;
    private Inventory inventory;
    private Rooms door;
    private Rooms bridge;
    private Rooms stairs;


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


    /*public static Rooms R1() {
        return new Rooms();
    }

    public static Rooms R2() {
        return new Rooms();
    }

    public static Rooms R3() {
        return new Rooms();
    }

    public static Rooms R4() {
        return new Rooms();
    }

    public static Rooms R5() {
        return new Rooms();
    }

    public static Rooms R6() {
        return new Rooms();
    }

    public static Rooms R7() {
        return new Rooms();
    }

    public static Rooms R8() {
        return new Rooms();
    }

    public static Rooms R9() {
        return new Rooms();
    }

    public static Rooms R10() {
        return new Rooms();
    }

    public static Rooms R11() {
        return new Rooms();
    }

    public static Rooms R12() {
        return new Rooms();
    }

    public static Rooms R13() {
        return new Rooms();
    }

    public static Rooms R14() {
        return new Rooms();
    }

    public static Rooms R15() {
        return new Rooms();
    }*/

    static Rooms R1 = new Rooms();
    static Rooms R2 = new Rooms();
    static Rooms R3 = new Rooms();
    static Rooms R4 = new Rooms();
    static Rooms R5 = new Rooms();
    static Rooms R6 = new Rooms();
    static Rooms R7 = new Rooms();
    static Rooms R8 = new Rooms();
    static Rooms R9 = new Rooms();
    static Rooms R10 = new Rooms();
    static Rooms R11 = new Rooms();
    static Rooms R12 = new Rooms();
    static Rooms R13 = new Rooms();
    static Rooms R14 = new Rooms();
    static Rooms R15 = new Rooms();

    static Rooms[] rooms = {R1,R2,R3,R4,R5,R6,R7,R8,R9,R10,R11,R12,R13,R14,R15};


    public static Rooms newRoomInstance() {

        int roomNumber = Dungeon.getN();
        int corridorNumber = Dungeon.getM();

        Rooms[] corridor1 = new Rooms[roomNumber];

        for (int i = 0; i < corridor1.length; i++) {
            corridor1[i] = rooms[i];
        }


       for (int i = 0; i < corridor1.length; i++) {
           corridor1[i] = new Rooms();
       }

       return
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

    public Rooms getDoor() {
        return door;
    }

    public void setDoor(Rooms door) {
        this.door = door;
    }

    public Rooms getBridge() {
        return bridge;
    }

    public void setBridge(Rooms bridge) {
        this.bridge = bridge;
    }

    public Rooms getStairs() {
        return stairs;
    }

    public void setStairs(Rooms stairs) {
        this.stairs = stairs;
    }
}
