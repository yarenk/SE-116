package HeroOfTheDungeon;

public class Hero implements BattleMethods{

    private final String name;
    private final String description;
    private final int maxHitPoints;
    private int hitPoints;
    private Weapons weapon;
    private Clothings clothing;
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
        this.weapon = weapon;
        this.clothing = clothing;
        this.currX = 0;
        this.currY = 0;
        this.currRoom = currRoom;
        this.inventory = inventory;
        this.numberOfTownPeopleSaved = 0;
    }

    public static Hero newWarrior() {
        return new Hero("Warrior", "A tough, well-rounded fighter with"
                + " a balanced skillset.", 100, 100, Swords.newWeakSword(), Clothings.newLightArmor(), Rooms.newRoomInstance(),new Inventory());
    }

    public static Hero newDuelist() {
        return new Hero("Duelist", "A quick, nimble duelist with an"
                + " aptitude for landing critical attacks.", 100, 100, Axes.newWeakAxe(), Clothings.newLightArmor(), Rooms.newRoomInstance(),new Inventory());
    }

    @Override
    public int attack() {
        return weapon.getDamage() * weapon.getRange();
    }

    public int defend(Monster monster) {
        int incomingAttack = monster.attack();
        IO.playerHitPointsMessage(incomingAttack, monster);
        hitPoints = (hitPoints * clothing.getProtection() > incomingAttack) ? hitPoints - incomingAttack : 0;
        return hitPoints;
    }

    @Override
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

    public Weapons getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapons weapon) {
        this.weapon = weapon;
    }

    public Clothings getClothing() {
        return clothing;
    }

    public void setClothing(Clothings clothing) {
        this.clothing = clothing;
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
