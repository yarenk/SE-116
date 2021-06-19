package HeroOfTheDungeon;

public final class Dungeon {

    private static boolean northDirection = false;
    private static boolean southDirection = false;
    private static boolean westDirection = false;
    private static boolean eastDirection = false;

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
        northDirection = roomExists(hero.getCurrX(), hero.getCurrY() + 1);
        southDirection = roomExists(hero.getCurrX(), hero.getCurrY() - 1);
        eastDirection = roomExists(hero.getCurrX() + 1, hero.getCurrY());
        westDirection = roomExists(hero.getCurrX() - 1, hero.getCurrY());
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

    public static boolean isNorthDirection() {
        return northDirection;
    }

    public static boolean isSouthDirection() {
        return southDirection;
    }

    public static boolean isWestDirection() {
        return westDirection;
    }

    public static boolean isEastDirection() {
        return eastDirection;
    }
}
