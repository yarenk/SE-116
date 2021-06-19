package HeroOfTheDungeon;

public final class IO {

    public static void Welcome() {
        System.out.println("Welcome traveler.......");
        System.out.println("To the hero of the Dungeon! ");
        System.out.println("-----------------------");
        System.out.println("       MAIN MENU       ");
        System.out.println("_______________________");
        System.out.println();
        System.out.println(" 1.      Start Game        ");
        System.out.println();
        System.out.println(" 2.       Credits        ");
        System.out.println();
        System.out.println(" 3.     Exit Game        ");
        System.out.println();
        System.out.print(" Make a Selection: ");
        System.out.println();
        System.out.println();
    }

    public static void newGameIntroduction() {
        System.out.println("------------------");
        System.out.println("CHOOSE A CHARACTER");
        System.out.println("------------------");
        System.out.println();
        System.out.println("1. WARRIOR");
        System.out.println("----------");
        System.out.println("You start with a weak weapon but with a high health value.");
        System.out.println();
        System.out.println("2. DUELIST");
        System.out.println("----------");
        System.out.println("You start with a balanced weapon and health value.");
        System.out.println();
        System.out.println("3. NINJA");
        System.out.println("----------");
        System.out.println("You start with a powerful weapon and low health to begin with.");
        System.out.println();
        System.out.println("________________________");
        System.out.print("Choose Either Character: ");
        System.out.println();
        System.out.println();
    }

    public static boolean displayPlayerStats(Hero hero){
        System.out.println(hero.getName());
        System.out.println("-------");
        System.out.println(hero.getDescription());
        System.out.println();
        System.out.println("MAX HP: " + hero.getMaxHitPoints());
        System.out.println();
        System.out.println("HP: " + hero.getHitPoints());
        System.out.println();
        hero.getWeapon().display();
        System.out.println();
        hero.getClothing().display();
        System.out.println();
        if (hero.getInventory().isEmpty())
            hero.getInventory().printItems();
        System.out.println();
        System.out.println("Total people saved: " + hero.getNumberOfTownPeopleSaved());
        System.out.println();
        System.out.println("Value of collected items: " + hero.calculateValue());
        System.out.println();
        System.out.println("ARE YOU SURE YOU WANT TO PLAY AS A "
                + hero.getName().toUpperCase() + "? "
                + "(y/n)");
        System.out.println();
        System.out.println();
        return Game.USERINPUT.nextLine().equals("y");
    }

    public static void credits() {
        System.out.println("This game was created by Arda Şenyüz, Emre Evcin, Yaren Karabacak.");
        System.out.println("Would you like to return to the main menu? (y/n)");
        if (Game.USERINPUT.nextLine().equals("y")) {
            Game.mainMenu();
        }
    }

    public static void movePlayer(Hero hero) {

        if (Dungeon.isNorthDirection()) {
            System.out.println("North (n)\n");
        }
        if (Dungeon.isSouthDirection()) {
            System.out.println("South (s)\n");
        }
        if (Dungeon.isEastDirection()) {
            System.out.println("East (e)\n");
        }
        if (Dungeon.isWestDirection()) {
            System.out.println("West (w)\n");
        }

        System.out.print("Where would you like to travel?: ");
        String selection = Game.USERINPUT.nextLine();
        if (selection.equals("n") && Dungeon.isNorthDirection()) {
            hero.setCurrY(hero.getCurrY() + 1);
        } else if (selection.equals("s") && Dungeon.isSouthDirection()) {
            hero.setCurrY(hero.getCurrY() - 1);
        } else if (selection.equals("e") && Dungeon.isEastDirection()) {
            hero.setCurrX(hero.getCurrX() + 1);
        } else if (selection.equals("w") && Dungeon.isWestDirection()) {
            hero.setCurrX(hero.getCurrX() - 1);
        }

    }

    public static void battleIntro(Hero hero, Rooms room) {
        System.out.println("You arrive at Room [" + hero.getCurrX() + "]["
                + hero.getCurrY() + "]");
        System.out.println("You enter the room and look around and see...");
        System.out.println(room.getDescription() + "\n\n");
        System.out.println("Number of monsters: " + room.getNumberOfMonsters());
        System.out.println("Number of town people: " + room.getNumberOfTownPeople());
        System.out.println("Your fight with " + room.getMonster().getName()
                + " begins.\n");
    }

    public static void battle(Hero hero, Monster monster) {
        while (hero.isAlive() && monster.isAlive()) {
            System.out.println("\nMonster HP: " + monster.getHitPoints()
                    + "    " + "Player HP: " + hero.getHitPoints());
            System.out.println("----------------------------------");
            System.out.print("\nAttack (a)");
            String action = Game.USERINPUT.nextLine();
            if (action.equals("a")) {
                monster.defend(hero);
                if (monster.isAlive()) {
                    hero.defend(monster);
                }
            }
        }
        if (!hero.isAlive()) {
            System.out.println("Your lifeless body hits the floor.  GAME OVER");
        } else if (!monster.isAlive()) {
            System.out.println("The monster has been defeated!");
            System.out.println("--------------------------------\n");
            hero.setNumberOfTownPeopleSaved(hero.getNumberOfTownPeopleSaved()+hero.getCurrRoom().getNumberOfTownPeople());
            System.out.println(hero.getName() + " saved " + hero.getCurrRoom().getNumberOfTownPeople() + " people.");
            System.out.println("Total people saved: " + hero.getNumberOfTownPeopleSaved());
        }
// LOOT AŞAMALARI YAPILACAK ENVANTER DEĞİŞİMİ VS.
        // İHTİMAL DAHİLİNDE YA TOWN PEOPLELAR ÖLECEK YA DA HEROYU İYİLEŞTİRECEK
        // KAHRAMANIN KURTARDIĞI TOWN PEOPLE SAYISI DEĞİŞECEK
    }

    public static void playerHitPointsMessage(int damage, Monster monster) {
        System.out.println("The " + monster.getName() + " hit you for "
                + damage + " damage.");
    }

    public static void monsterHitPointsMessage(int damage, Monster monster) {
        System.out.println("You hit the " + monster.getName()
                + " for " + damage + " damage.");
    }


}
