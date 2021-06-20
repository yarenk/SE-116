package HeroOfTheDungeon;

import java.io.*;
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
                    readFile();
                    status = true;
                    break;
                case "3":
                    IO.credits();
                    status = true;
                    break;
                case "4":
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
    public static void createFile(){
        File file = new File("HighScores.txt");
        try {
            if (file.createNewFile()){
                System.out.println("File created");
            }else{
                System.out.println("File already exists");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFile(){
        File file = new File("HighScores.txt");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                System.out.println(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void writeFile(){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("HighScores.txt",true));
            writer.newLine();
            writer.write(currHero.getHighScore());
            System.out.println("Saved");
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}