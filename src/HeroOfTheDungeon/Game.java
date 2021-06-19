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

        } while (!status);

    }

    public static void newGame() {
        Dungeon dungeon = new Dungeon();
        boolean status = false;
        do {
            IO.newGameIntroduction();
            String selection = USERINPUT.nextLine();
            switch (selection) {
                case "1":
                    currHero = Hero.newWarrior();
                    status = IO.displayPlayerStats(currHero);
                    break;
                case "2":
                    currHero = Hero.newDuelist();
                    status = IO.displayPlayerStats(currHero);
                    break;
                case "3":
                    currHero = Hero.newNinja();
                    status = IO.displayPlayerStats(currHero);
            }
        } while (!status);

        currDungeon = Dungeon.newRandomDungeon(currHero);
        dungeon.dungeonLogic(currHero, currDungeon);
    }

}