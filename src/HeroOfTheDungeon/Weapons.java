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

    public abstract int attack();
    public abstract int defend(Hero hero, Monster monster);
    // saldırını metodunu Character saldıran, Character saldırılana uyarla
    public static Weapons newRandomWeapon() {
        Random rand = new Random();
        int random = rand.nextInt(17) + 1;
        Weapons weapon = null;
        if (random >= 1 && random <= 10) {
            random = rand.nextInt(3) + 1;
            if (random == 1)
                weapon = Swords.newWeakSword();
            else if (random == 2)
                weapon = Swords.newSword();
            else if (random == 3)
                weapon = Swords.newEpicSword();
        }
        else if (random >= 11 & random <= 16) {
            random = rand.nextInt(3) + 1;
            if (random == 1)
                weapon = Axes.newWeakAxe();
            else if (random == 2)
                weapon = Axes.newAxe();
            else if (random == 3)
                weapon = Axes.newEpicAxe();
        }
        else {
            random = rand.nextInt(3) + 1;
            if (random == 1)
                weapon = Bows.newWeakBow();
            else if (random == 2)
                weapon = Bows.newBow();
            else if (random == 3)
                weapon = Bows.newEpicBow();
        }
        return weapon;
    }
}
