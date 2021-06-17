package HeroOfTheDungeon;

import java.util.Scanner;

public class Game {

    public static final Scanner USERINPUT = new Scanner(System.in);
    public static Rooms[][] currDungeon;
    public static Hero currHero;

    public static void main(String[] args) {
        mainMenu();
    }

    public static void mainMenu() {
        boolean status = false;
        do {
            IO.Welcome();
            String selection = USERINPUT.nextLine();
            switch (selection) {
                case "1":
                    newGame();
                    status = true;
                    break;
                case "2":
                    IO.credits();
                    status = true;
                    break;
                case "3":
                    System.exit(0);
            }

        } while (status == false);

    }

    public static void newGame() {
        Dungeon dungeon = new Dungeon();
        boolean status = false;
        do {
            IO.newGameIntroduction();
            String selection = USERINPUT.nextLine();
            switch (selection) {
                case "1":
                    status = IO.displayPlayerStats("Warrior","A tough, well-rounded fighter with a balanced skillset.",100,Swords.newWeakSword(),Clothings.newLightArmor(), new Inventory());
                    currHero = Hero.newWarrior();

                    break;
                case "2":
                    status = IO.displayPlayerStats("Dueler", "A quick, nimble "
                            + "duelist with an aptitude for landing critical "
                            + "attacks.", 100, Axes.newWeakAxe(), Clothings.newLightArmor(), new Inventory());
                    currHero = Hero.newDuelist();

                    break;
            }
        } while (status == false);

        currDungeon = Dungeon.newRandomDungeon(currHero);
        dungeon.dungeonLogic(currHero, currDungeon);

    }

}