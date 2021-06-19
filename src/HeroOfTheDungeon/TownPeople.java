package HeroOfTheDungeon;

public class TownPeople {

    public static void heal(Hero hero) {
        hero.setHitPoints(hero.getHitPoints() + 10);
        System.out.println("You have been 10 HP healed by the Town People");
    }
}
