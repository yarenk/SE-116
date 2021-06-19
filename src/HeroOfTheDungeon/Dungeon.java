package HeroOfTheDungeon;

public final class Dungeon {

    private static boolean nextLevel = false;
    private static boolean previousLevel = false;
    private static boolean previousRoom = false;
    private static boolean nextRoom = false;

    public static Rooms[][] newRandomDungeon(Hero hero) {
        Rooms[][] dungeon = new Rooms[16][4];
        for (int i = 0; i < dungeon.length; i++) {
            for (int j = 0; j < dungeon[i].length; j++) {
                dungeon[i][j] = Rooms.newRoomInstance();
            }
        }
        hero.setCurrRoom(dungeon[0][0]);
        return dungeon;
    }

    public boolean roomExists(int x, int y) {
        return  (rowExists(x)) && (colExists(y));
    }

    public boolean rowExists(int x){
        return  (x >= 0) && (x <= 3);
    }

    public boolean colExists(int y){
        return  (y >= 0) && (y <= 15);
    }

    public void playerMovement(Hero hero) {
        nextLevel = roomExists(hero.getCurrX(), hero.getCurrY() + 1);
        previousLevel = roomExists(hero.getCurrX(), hero.getCurrY() - 1);
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

    public static boolean isNextLevel() {
        return nextLevel;
    }

    public static boolean isPreviousLevel() {
        return previousLevel;
    }

    public static boolean isPreviousRoom() {
        return previousRoom;
    }

    public static boolean isNextRoom() {
        return nextRoom;
    }
}
