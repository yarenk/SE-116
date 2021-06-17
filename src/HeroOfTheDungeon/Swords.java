package HeroOfTheDungeon;

import java.util.Random;

public class Swords extends Weapons{

    private String swordType;
    private static final Random rand = new Random();

    public Swords(String name, int weight, int value, int damage, int range, String swordType) {
        super(name, weight, value, damage, range);
        this.swordType = swordType;
    }

    public String getSwordType() {
        return swordType;
    }

    public void setSwordType(String swordType) {
        this.swordType = swordType;
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

    public static Swords newWeakSword() {
        return new Swords("Scissor Dagger",1,2,1,2,"Dagger");
    }

    public static Swords newSword() {
        return new Swords("Lion Sword",2,4,2,4,"Short Sword");
    }

    public static Swords newEpicSword() {
        return new Swords("Kiyanite Sword",4,8,4,8,"Long Sword");
    }
}
