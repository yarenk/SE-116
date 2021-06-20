package HeroOfTheDungeon;


public class Rooms {

    private final String description;
    private final int numberOfMonsters = 1;
    private final int numberOfTownPeople;
    private final boolean isBridge;
    private final boolean isStair;
    private Inventory inventory;
    private Monster monster;

    public Rooms(String description, int numberOfTownPeople, boolean isBridge, boolean isStair, Inventory inventory, Monster monster) {
        this.description = description;
        this.numberOfTownPeople = numberOfTownPeople;
        this.isBridge = isBridge;
        this.isStair = isStair;
        this.inventory = inventory;
        this.monster = monster;
    }

    public static Rooms R1() {
        return new Rooms("Thick cobwebs fill the corners of the room, and wisps of webbing hang from the ceiling and waver in a wind you can barely feel.",2,false,false,Inventory.newInventory(),Monster.newRandomEasyMonster());
}
    public static Rooms R2() {
        return new Rooms("A flurry of bats suddenly flaps through the doorway, their screeching barely audible as they careen past your heads. They flap past you into the rooms and halls beyond.",1,true,false,Inventory.newInventory(),Monster.newRandomEasyMonster());
    }
    public static Rooms R3() {
        return new Rooms("Rats inside the room shriek when they hear the door open, then they run in all directions from a putrid corpse lying in the center of the floor. As these creatures crowd around the edges of the room, seeking to crawl through a hole in one corner, they fight one another",2,false,false,Inventory.newInventory(),Monster.newRandomEasyMonster());
    }
    public static Rooms R4() {
        return new Rooms("The strong, sour-sweet scent of vinegar assaults your nose as you enter this room. Sundered casks and broken bottle glass line the walls of this room. Clearly this was someone's wine cellar for a time.",3,true,false,Inventory.newInventory(),Monster.newRandomMediumMonster());
    }
    public static Rooms R5() {
        return new Rooms("This room is walled and floored with black marble veined with white. The ceiling is similarly marbled, but the thick pillars that hold it up are white. A blood-like brown stain drips down one side of a nearby pillar.",2,false,true,Inventory.newInventory(),Monster.newRandomMediumMonster());
    }
    public static Rooms R6() {
        return new Rooms("A pungent, earthy odor greets you as you pull open the door and peer into this room. Mushrooms grow in clusters of hundreds all over the floor. Looking into the room is like looking down on a forest.",1,false,false,Inventory.newInventory(),Monster.newRandomMediumMonster());
    }
    public static Rooms R7() {
        return new Rooms("You gaze into the room and hundreds of skulls gaze coldly back at you. They're set in niches in the walls in a checkerboard pattern, each skull bearing a half-melted candle on its head. The grinning bones stare vacantly into the room, which otherwise seems empty.",3,false,false,Inventory.newInventory(),Monster.newRandomMediumMonster());
    }
    public static Rooms R8() {
        return new Rooms("Huge rusted metal blades jut out of cracks in the walls, and rusting spikes project down from the ceiling almost to the floor. This room may have once been trapped heavily, but someone triggered them, apparently without getting killed. The traps were never reset and now seem rusted in place.",2,true,false,Inventory.newInventory(),Monster.newRandomHardMonster());
    }
    public static Rooms R9() {
        return new Rooms("In the center of this large room lies a 30-foot-wide round pit, its edges lined with rusting iron spikes. About 5 feet away from the pit's edge stand several stone semicircular benches. The scent of sweat and blood lingers, which makes the pit's resemblance to a fighting pit or gladiatorial arena even stronger.",2,false,false,Inventory.newInventory(),Monster.newRandomMediumMonster());
    }
    public static Rooms R10() {
        return new Rooms("A strange ceiling is the focal point of the room before you. It's honeycombed with hundreds of holes about as wide as your head. They seem to penetrate the ceiling to some height beyond a couple feet, but you can't be sure from your vantage point.",1,false,false,Inventory.newInventory(),Monster.newRandomHardMonster());
    }
    public static Rooms R11() {
        return new Rooms("You find this chamber lit dimly by guttering candles that squat in small hills of melted wax. The smell of their smoke hits your nose along with an odor that is reminiscent of the sea. Someone has taken a large amount of salt and drawn a broad circular symbol on the floor with the candles situated equidistantly around it. Atop the salt, someone traced the symbol with a black powder that glints a dull silver in the candlelight.",3,false,false,Inventory.newInventory(),Monster.newRandomHardMonster());
    }
    public static Rooms R12() {
        return new Rooms("You've opened the door to a torture chamber. Several devices of degradation, pain, and death stand about the room, all of them showing signs of regular use. The wood of the rack is worn smooth by struggling bodies, and the iron maiden appears to be occupied by a corpse.",2,true,false,Inventory.newInventory(),Monster.newRandomHardMonster());
    }


    @Override
    public String toString() {
        return description;
    }

    public String getDescription() {
        return description;
    }

    public int getNumberOfMonsters() {
        return numberOfMonsters;
    }

    public int getNumberOfTownPeople() {
        return numberOfTownPeople;
    }

    public boolean isBridge() {
        return isBridge;
    }

    public boolean isStair() {
        return isStair;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

}
