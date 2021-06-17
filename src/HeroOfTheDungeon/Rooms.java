package HeroOfTheDungeon;

import java.util.Random;

public class Rooms {

    private final String description;
    private Monster monster;
    private final int numberOfMonsters;
    private final int numberOfTownPeople;
    private final boolean isStairsRoom;
    private Item item;

    public Rooms(String description, Monster monster, int numberOfMonsters, int numberOfTownPeople, boolean isStairsRoom, Item item){
        this.description = description;
        this.monster = monster;
        this.numberOfMonsters = numberOfMonsters;
        this.numberOfTownPeople = numberOfTownPeople;
        this.isStairsRoom = isStairsRoom;
        this.item = item;
    }

    public Rooms(String description, Monster monster1, Monster monster2, int numberOfMonsters, int numberOfTownPeople, boolean isStairsRoom, Item item){
        this.description = description;
        this.monster = monster1;
        this.monster = monster2;
        this.numberOfMonsters = numberOfMonsters;
        this.numberOfTownPeople = numberOfTownPeople;
        this.isStairsRoom = isStairsRoom;
        this.item = item;
    }

    public static Rooms newRoomInstance() {
        Random rand = new Random();
        String description = null;
        int numberOfMonsters = 0;
        int numberOfTownPeople = 0;
        boolean isStairsRoom = false;
        int random = rand.nextInt(4) + 1;
        switch (random) {
            case 1:
                description = "A dark corridor with creeping, animated vines.";
                numberOfMonsters = 1;
                numberOfTownPeople = 5;
                isStairsRoom = true;
                break;
            case 2:
                description = "A single lantern lays on the floor, illuminating"
                        + " a skeleton of a past explorer. Two pairs of eyes "
                        + "can be seen.";
                numberOfMonsters = 1;
                numberOfTownPeople = 10;
                break;
            case 3:
                description = "A green, floral room full of massive plants.";
                numberOfMonsters = 2;
                numberOfTownPeople = 8;
                isStairsRoom = true;
                break;
            case 4:
                    description = "a giant dragon";
                    numberOfMonsters = 2;
                    numberOfTownPeople = 20;
                    break;
                /*case 5:
                    description = "";
                    numOfMonsters = 1;
                    break;
                case 6:
                    description = "";
                    numOfMonsters = 1;
                    break;
                case 7:
                    description = "";
                    numOfMonsters = 1;
                    break;
                case 8:
                    description = "";
                    numOfMonsters = 1;
                    break;
                case 9:
                    description = "";
                    numOfMonsters = 1;
                    break;
                case 10:
                    description = "";
                    numOfMonsters = 1;
                    break;*/
        }
        if (numberOfMonsters == 1)
            return new Rooms(description,Monster.newRandomMonster(),numberOfMonsters,numberOfTownPeople,isStairsRoom,Item.newRandomItem());
        else
            return new Rooms(description,Monster.newRandomMonster(),Monster.newRandomMonster(),numberOfMonsters,numberOfTownPeople,isStairsRoom,Item.newRandomItem());

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

    public boolean isStairsRoom() {
        return isStairsRoom;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }
}
