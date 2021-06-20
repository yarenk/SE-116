package HeroOfTheDungeon;



public class Axes extends Weapons{

    private String axeType;

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


    public static Axes newWeakAxe() {
        return new Axes("Hand Axe",1,2,3,3,"Small Axe");
    }

    public static Axes newAxe() {
        return new Axes("Battle Axe",2,4,4,6,"Axe");
    }

    public static Axes newEpicAxe() {
        return new Axes("Great Axe",4,8,5,9,"Broad Axe");
    }
}
