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
    private int highScore;
    private int currLevel;
    //private Dungeon currDungeon;

    public Hero(String name, String description, int maxHitPoints, int hitPoints, Weapons weapon, Clothings clothing, Inventory inventory) {
        this.name = name;
        this.description = description;
        this.maxHitPoints = maxHitPoints;
        this.hitPoints = hitPoints;
        this.weapon = weapon;
        this.clothing = clothing;
        this.currLevel = 1;
        this.currX = 0;
        this.currY = 0;
        //this.currRoom = new Rooms();
        this.inventory = inventory;
        this.numberOfTownPeopleSaved = 0;
    }

    public static Hero newWarrior() {
        return new Hero("Warrior", "You start with a weak weapon but with a high health value.", 150, 110, Swords.newWeakSword(), Clothings.newLightArmor(), Inventory.newInventory());
    }

    public static Hero newDuelist() {
        return new Hero("Duelist", "You start with a balanced weapon and health value.", 150, 100, Axes.newWeakAxe(), Clothings.newLightArmor(), Inventory.newInventory());
    }

    public static Hero newNinja() {
        return new Hero("Ninja","You start with a powerful weapon and low health to begin with.",150,90,Bows.newWeakBow(),Clothings.newLightArmor(), Inventory.newInventory());
    }

    public int calculateValue() {
        return weapon.getValue() + clothing.getValue();
    }

    @Override
    public int attack() {
        return weapon.getDamage() * weapon.getRange();
    }

    public int defend(Monster monster) {
        int incomingAttack = monster.attack() - getClothing().getProtection();
        IO.playerHitPointsMessage(incomingAttack, monster);

            if (getHitPoints() > incomingAttack)
                setHitPoints(getHitPoints() - incomingAttack);
            else
                setHitPoints(0);

        return getHitPoints();
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

    public int getHighScore() {
        return highScore;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }

    public int getCurrLevel() {
        return currLevel;
    }

    public void setCurrLevel(int currLevel) {
        this.currLevel = currLevel;
    }
}
