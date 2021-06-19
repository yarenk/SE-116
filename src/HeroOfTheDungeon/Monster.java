package HeroOfTheDungeon;

import java.util.Random;

public class Monster implements BattleMethods{

    private final String name;
    private final int maxHitPoints;
    private int hitPoints;
    private Weapons weapon;
    private Clothings clothing;
    private Inventory inventory;
    private static final Random rand = new Random();

    public Monster(String name, int maxHitPoints, Weapons weapon, Clothings clothing ,Inventory inventory) {
        this.name = name;
        this.maxHitPoints = maxHitPoints;
        this.hitPoints = maxHitPoints;
        this.weapon = weapon;
        this.clothing = clothing;
        this.inventory = inventory;
    }

    public static Monster newRandomEasyMonster() {
        int random = rand.nextInt(3) + 1;
        Monster monster = null;
        switch (random) {
            case 1:
                monster = newRaptor();
                break;
            case 2:
                monster = newMiniKrug();
                break;
            case 3:
                monster = newMurkWolf();
                break;
        }
        return monster;
    }

    public static Monster newRandomMediumMonster() {
        int random = rand.nextInt(3) + 1;
        Monster monster = null;
        switch (random) {
            case 1:
                monster = newGhoul();
                break;
            case 2:
                monster = newGromp();
                break;
            case 3:
                monster = newRiftHerald();
                break;
        }
        return monster;
    }

    public static Monster newRandomHardMonster() {
        int random = rand.nextInt(3) + 1;
        Monster monster = null;
        switch (random) {
            case 1:
                monster = newInfernalDrake();
                break;
            case 2:
                monster = newBaronNashor();
                break;
            case 3:
                monster = newElderDragon();
                break;
        }
        return monster;
    }



    /*public static Monster newRandomMonster() {
        int random = rand.nextInt(9) + 1;
        Monster monster = null;
        switch (random) {
            case 1:
                monster = newRaptor();
                break;
            case 2:
                monster = newMiniKrug();
                break;
            case 3:
                monster = newMurkWolf();
                break;
            case 4:
                monster = newGhoul();
                break;
            case 5:
                monster = newGromp();
                break;
            case 6:
                monster = newRiftHerald();
                break;
            case 7:
                monster = newInfernalDrake();
                break;
            case 8:
                monster = newBaronNashor();
                break;
            case 9:
                monster = newElderDragon();
                break;
        }

        return monster;
    }*/

    public static Monster newRaptor() {
        return new Monster("Raptor",20,Swords.newWeakSword(),Clothings.newLightArmor(),Inventory.newInventory());
    }

    public static Monster newMiniKrug() {
        return new Monster("Mini Krug",25,Axes.newWeakAxe(),Clothings.newLightArmor(),Inventory.newInventory());
    }

    public static Monster newMurkWolf() {
        return new Monster("Murk Wolf",30,Bows.newWeakBow(),Clothings.newLightArmor(),Inventory.newInventory());
    }

    public static Monster newGhoul() {
        return new Monster("Ghoul",35,Swords.newSword(),Clothings.newMediumArmor(),Inventory.newInventory());
    }

    public static Monster newGromp() {
        return new Monster("Gromp",40,Axes.newAxe(),Clothings.newMediumArmor(),Inventory.newInventory());
    }

    public static Monster newRiftHerald() {
        return new Monster("Rift Herald",45,Bows.newBow(),Clothings.newMediumArmor(), Inventory.newInventory());
    }

    public static Monster newInfernalDrake() {
        return new Monster("Infernal Drake",50,Swords.newEpicSword(),Clothings.newHeavyArmor(),Inventory.newInventory());
    }

    public static Monster newBaronNashor() {
        return new Monster("Baron Nashor",55,Axes.newEpicAxe(),Clothings.newHeavyArmor(),Inventory.newInventory());
    }

    public static Monster newElderDragon() {
        return new Monster("Elder Dragon",60,Bows.newEpicBow(),Clothings.newHeavyArmor(),Inventory.newInventory());
    }

    @Override
    public int attack() {
        return weapon.getDamage() * weapon.getRange();
    }

    public int defend(Hero hero) {
        int incomingAttack = hero.attack() - getClothing().getProtection();
        IO.monsterHitPointsMessage(incomingAttack,this);
            if (getHitPoints()> incomingAttack)
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

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public static Random getRand() {
        return rand;
    }
}
