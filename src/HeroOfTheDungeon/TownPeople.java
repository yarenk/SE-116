package HeroOfTheDungeon;

public class TownPeople {

    public void heal(Hero hero) {
        hero.setHitPoints(hero.getHitPoints() + 20);
        IO.heal(hero.getHitPoints());
    }
}
