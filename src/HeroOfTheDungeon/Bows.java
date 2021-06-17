package HeroOfTheDungeon;



public class Bows extends Weapons{

    private String bowType;

    public Bows(String name, int weight, int value, int damage, int range, String bowType) {
        super(name, weight, value, damage, range);
        this.bowType = bowType;
    }

    public String getBowType() {
        return bowType;
    }

    public void setBowType(String bowType) {
        this.bowType = bowType;
    }


    public static Bows newWeakBow() {
        return new Bows("Crossbow",1,2,1,2,"Short Bow");
    }

    public static Bows newBow() {
        return new Bows("Phoenix Bow",2,4,2,4,"Long Bow");
    }

    public static Bows newEpicBow() {
        return new Bows("Zodiac Bow",4,8,4,8,"Composite Bow");
    }
}
