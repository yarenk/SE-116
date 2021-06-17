package HeroOfTheDungeon;

import java.util.Random;

public class Monster {

    private final String name;
    private final int maxHitPoints;
    private int hitPoints;
    private int damage;
    private int protection;
    private Inventory inventory;
    private static final Random rand = new Random();

    public Monster(String name, int maxHitPoints, Weapons weapon, Clothings clothing ,Inventory inventory) {
        this.name = name;
        this.maxHitPoints = maxHitPoints;
        this.hitPoints = maxHitPoints;
        this.damage = weapon.getDamage();
        this.protection = clothing.getProtection();
        this.inventory = inventory;
    }

    public static Monster newRandomMonster() {
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
    }

    public static Monster newRaptor() {
        return new Monster("Raptor",(rand.nextInt(100) + 20),Weapons.newRandomWeapon(),Clothings.newRandomClothing(),Inventory.newInventory());
    }

    public static Monster newMiniKrug() {
        return new Monster("Mini Krug",(rand.nextInt(100) + 20),Weapons.newRandomWeapon(),Clothings.newRandomClothing(),Inventory.newInventory());
    }

    public static Monster newMurkWolf() {
        return new Monster("Murk Wolf",(rand.nextInt(100) + 20),Weapons.newRandomWeapon(),Clothings.newRandomClothing(),Inventory.newInventory());
    }

    public static Monster newGhoul() {
        return new Monster("Ghoul",(rand.nextInt(100) + 20),Weapons.newRandomWeapon(),Clothings.newRandomClothing(),Inventory.newInventory());
    }

    public static Monster newGromp() {
        return new Monster("Gromp",(rand.nextInt(100) + 20),Weapons.newRandomWeapon(),Clothings.newRandomClothing(),Inventory.newInventory());
    }

    public static Monster newRiftHerald() {
        return new Monster("Rift Herald",(rand.nextInt(100) + 20),Weapons.newRandomWeapon(),Clothings.newRandomClothing(), Inventory.newInventory());
    }

    public static Monster newInfernalDrake() {
        return new Monster("Infernal Drake",(rand.nextInt(100) + 20),Weapons.newRandomWeapon(),Clothings.newRandomClothing(),Inventory.newInventory());
    }

    public static Monster newBaronNashor() {
        return new Monster("Baron Nashor",(rand.nextInt(100) + 20),Weapons.newRandomWeapon(),Clothings.newRandomClothing(),Inventory.newInventory());
    }

    public static Monster newElderDragon() {
        return new Monster("Elder Dragon",(rand.nextInt(100) + 20),Weapons.newRandomWeapon(),Clothings.newRandomClothing(),Inventory.newInventory());
    }



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
