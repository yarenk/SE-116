package HeroOfTheDungeon;

public final class Dungeon {

    private static boolean nextCorridor = false;
    private static boolean previousCorridor = false;
    private static boolean nextRoom = false;
    private static boolean previousRoom = false;
    private static boolean nextLevel = false;
    private static boolean previousLevel = false;
    private static Rooms[][] dungeon = new Rooms[4][3];

    public static Rooms[][] newRandomDungeon(Hero hero) {
        dungeon[0][0] = Rooms.R1();
        dungeon[0][1] = Rooms.R2();
        dungeon[0][2] = Rooms.R3();
        dungeon[1][0] = Rooms.R4();
        dungeon[1][1] = Rooms.R5();
        dungeon[1][2] = Rooms.R6();
        dungeon[2][0] = Rooms.R7();
        dungeon[2][1] = Rooms.R8();
        dungeon[2][2] = Rooms.R9();
        dungeon[3][0] = Rooms.R10();
        dungeon[3][1] = Rooms.R11();
        dungeon[3][2] = Rooms.R12();


        hero.setCurrRoom(dungeon[0][0]);
        return dungeon;
    }

    public boolean levelExists(int i) {
        return i >= 1 && i <= 16;
    }


    public boolean roomExists(int x, int y) {
        return  (rowExists(x)) && (colExists(y));
    }

    public boolean rowExists(int x){
        return  (x >= 0) && (x < 4);
    }

    public boolean colExists(int y){
        return  (y >= 0) && (y < 3);
    }

    public void playerMovement(Hero hero) {
        nextRoom = roomExists(hero.getCurrX(), hero.getCurrY() + 1);
        previousRoom = roomExists(hero.getCurrX(), hero.getCurrY() - 1);
        nextCorridor = roomExists(hero.getCurrX() + 1, hero.getCurrY());
        previousCorridor = roomExists(hero.getCurrX() - 1, hero.getCurrY());
        nextLevel = levelExists(hero.getCurrLevel() + 1);
        previousLevel = levelExists(hero.getCurrLevel() - 1);
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

    public static boolean isNextRoom() {
        return nextRoom;
    }

    public static boolean isPreviousRoom() {
        return previousRoom;
    }

    public static boolean isNextLevel() {
        return nextLevel;
    }

    public static boolean isPreviousLevel() {
        return previousLevel;
    }

    public static Rooms[][] getDungeon() {
        return dungeon;
    }

    public static void setDungeon(Rooms[][] dungeon) {
        Dungeon.dungeon = dungeon;
    }
}