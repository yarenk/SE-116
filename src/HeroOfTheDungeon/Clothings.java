package HeroOfTheDungeon;

import java.util.Random;

public class Clothings extends Item{

    private int protection;
    private String type;

    public Clothings(String name, int weight, int value, int protection, String type) {
        super(name, weight, value);
        this.protection = protection;
        this.type = type;
    }

    public int getProtection() {
        return protection;
    }

    public void setProtection(int protection) {
        this.protection = protection;
    }

    public String getType() {
        return type;
    }

    public static Clothings newRandomClothing() {
        Random rand = new Random();
        int random = rand.nextInt(10) + 1;
        Clothings clothings = null;
        if (random < 6) {
            clothings = newLightArmor();
        }
        else if (random >= 6 & random <= 9) {
            clothings = newMediumArmor();
        }
        else {
           clothings = newHeavyArmor();
        }
        return clothings;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static Clothings newLightArmor() {
        return new Clothings("Padded",8,5,2,"Light Armor");
    }

    public static Clothings newMediumArmor() {
        return new Clothings("Studded Leather",10,20,4,"Leather Armor");
    }

    public static Clothings newHeavyArmor() {
        return new Clothings("Chain Mail",15,75,6,"Chain Armor");
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Protection: " + getProtection());
    }
}
