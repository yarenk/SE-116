package HeroOfTheDungeon;

public class Hero {

    private final String name;
    private final String description;
    private final int maxHitPoints;
    private int hitPoints;
    private int damage;
    private int protection;
    private int currX;
    private int currY;
    private Rooms currRoom;
    private Inventory inventory;
    private int numberOfTownPeopleSaved;

    public Hero(String name, String description, int maxHitPoints, int hitPoints, Weapons weapon, Clothings clothing, Rooms currRoom, Inventory inventory) {
        this.name = name;
        this.description = description;
        this.maxHitPoints = maxHitPoints;
        this.hitPoints = hitPoints;
        this.damage = weapon.getDamage();
        this.protection = clothing.getProtection();
        this.currX = 0;
        this.currY = 0;
        this.currRoom = currRoom;
        this.inventory = inventory;
        this.numberOfTownPeopleSaved = 0;
    }



    public boolean isAlive() {
        return hitPoints > 0;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getMaxHitPoints() {
        return maxHitPoints;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getProtection() {
        return protection;
    }

    public void setProtection(int protection) {
        this.protection = protection;
    }

    public int getCurrX() {
        return currX;
    }

    public void setCurrX(int currX) {
        this.currX = currX;
    }

    public int getCurrY() {
        return currY;
    }

    public void setCurrY(int currY) {
        this.currY = currY;
    }

    public Rooms getCurrRoom() {
        return currRoom;
    }

    public void setCurrRoom(Rooms currRoom) {
        this.currRoom = currRoom;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getNumberOfTownPeopleSaved() {
        return numberOfTownPeopleSaved;
    }

    public void setNumberOfTownPeopleSaved(int numberOfTownPeopleSaved) {
        this.numberOfTownPeopleSaved = numberOfTownPeopleSaved;
    }
}
