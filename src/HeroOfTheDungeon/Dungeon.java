package HeroOfTheDungeon;

import java.security.SecureRandom;

public final class Dungeon {
    static SecureRandom random = new SecureRandom();

    private static boolean nextCorridor = false;
    private static boolean previousCorridor = false;
    private static boolean previousRoom = false;
    private static boolean nextRoom = false;
    private static boolean nextLevel = false;
    private static boolean previousLevel = false;
    private final static int m = random.nextInt(3) + 1;
    private final static int n = random.nextInt(5) + 1;


    public static Rooms[][] newRandomDungeon(Hero hero) {
        Rooms[][] dungeon = new Rooms[m][n];
        for (int i = 0; i < dungeon.length; i++) {
            for (int j = 0; j < dungeon[i].length; j++) {
                dungeon[i][j] = Rooms.newRoomInstance();
            }
        }
        hero.setCurrRoom(dungeon[0][0]);
        int i = 1;
        while (i <= 15) {
            newRandomDungeon(hero);
            i++;
        }
        return dungeon;
    }



    public boolean levelExists(int x, int y) {
        return (rowExists(x)) && (colExists(y));
    }

    public boolean roomExists(int x, int y) {
        return  (rowExists(x)) && (colExists(y));
    }

    public boolean rowExists(int x){
        return  (x >= 0) && (x <= m);
    }

    public boolean colExists(int y){
        return  (y >= 0) && (y <= n);
    }

    public void playerMovement(Hero hero) {
        nextCorridor = roomExists(hero.getCurrX(), hero.getCurrY() + 1);
        previousCorridor = roomExists(hero.getCurrX(), hero.getCurrY() - 1);
        nextRoom = roomExists(hero.getCurrX() + 1, hero.getCurrY());
        previousRoom = roomExists(hero.getCurrX() - 1, hero.getCurrY());
        IO.movePlayer(hero);

    }

    public void battle(Hero hero, Monster monster, Rooms[][] dungeon) {
        IO.battleIntro(hero, dungeon[hero.getCurrX()][hero.getCurrY()]);
        IO.battle(hero, monster);
    }

    public void dungeonLogic(Hero hero, Rooms[][] dungeon) {
        while (hero.isAlive()) {
            if (hero.isAlive() && dungeon[hero.getCurrX()][hero.getCurrY()].getMonster().isAlive()) {
                battle(hero, dungeon[hero.getCurrX()][hero.getCurrY()].getMonster(), Game.currDungeon);
            } else if (hero.isAlive()) {
                playerMovement(hero);
            }
        }
    }

    public static boolean isNextCorridor() {
        return nextCorridor;
    }

    public static boolean isPreviousCorridor() {
        return previousCorridor;
    }

    public static boolean isPreviousRoom() {
        return previousRoom;
    }

    public static boolean isNextRoom() {
        return nextRoom;
    }

    public static boolean isNextLevel() {
        return nextLevel;
    }

    public static boolean isPreviousLevel() {
        return previousLevel;
    }

    public static int getM() {
        return m;
    }

    public static int getN() {
        return n;
    }
}
