package HeroOfTheDungeon;

import java.util.Random;

public class Axes extends Weapons{

    private String axeType;
    private static final Random rand = new Random();

    public Axes(String name, int weight, int value, int damage, int range, String axeType) {
        super(name, weight, value, damage, range);
        this.axeType = axeType;
    }

    public String getAxeType() {
        return axeType;
    }

    public void setAxeType(String axeType) {
        this.axeType = axeType;
    }

    @Override
    public int attack() {
        int random = rand.nextInt(5) + 1;
        return getDamage() * getRange() * random;
    }

    @Override
    public int defend(Hero hero, Monster monster) {
        int incomingAttack = monster.getDamage();
        hero.setHitPoints(hero.getHitPoints() * hero.getProtection() > incomingAttack ? hero.getHitPoints() - incomingAttack : 0);
        return hero.getHitPoints();
    }

    public static Axes newWeakAxe() {
        return new Axes("Hand Axe",1,2,1,2,"Small Axe");
    }

    public static Axes newAxe() {
        return new Axes("Battle Axe",2,4,2,4,"Axe");
    }

    public static Axes newEpicAxe() {
        return new Axes("Great Axe",4,8,4,8,"Broad Axe");
    }
}
