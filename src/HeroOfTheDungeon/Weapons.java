package HeroOfTheDungeon;

import java.util.Random;

public abstract class Weapons extends Item{

    private int damage;
    private int range;

    public Weapons(String name, int weight, int value, int damage, int range) {
        super(name, weight, value);
        this.damage = damage;
        this.range = range;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public static Weapons newRandomWeapon() {
        Random rand = new Random();
        int random = rand.nextInt(17) + 1;
        Weapons weapon = null;
        if (random <= 10) {
            random = rand.nextInt(3) +1;
            if (random == 1)
                weapon = Swords.newWeakSword();
            if (random == 2)
                weapon = Axes.newWeakAxe();
            if (random == 3)
                weapon = Bows.newWeakBow();
        }
        if (random > 10 & random <= 16) {
            random = rand.nextInt(3) + 1;
            if (random == 1)
                weapon = Swords.newSword();
            if (random == 2)
                weapon = Axes.newAxe();
            if (random == 3)
                weapon = Bows.newBow();
        }
        else {
            random = rand.nextInt(3) + 1;
            if (random == 1)
                weapon = Swords.newEpicSword();
            if (random == 2)
                weapon = Axes.newEpicAxe();
            if (random == 3)
                weapon = Bows.newEpicBow();
        }
        return weapon;
    }
}
