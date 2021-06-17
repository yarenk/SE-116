package HeroOfTheDungeon;

import java.util.ArrayList;


public class Inventory {
    private static ArrayList<Item> items;
    private final int maxCapacity = 100;
    private int curCapacity;

    public Inventory(ArrayList<Item> items, int curCapacity) {
        this.items = items;
        this.curCapacity = curCapacity;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public int getCurCapacity() {
        return curCapacity;
    }

    public void setCurCapacity(int curCapacity) {
        if (curCapacity > 100)
            throw new ArithmeticException("Capacity must be <= 100");
        this.curCapacity = curCapacity;
    }

    public void add(Item item) {                                        // ex

        try {
            if ((getCurCapacity() + item.getWeight()) <= getMaxCapacity()) {
                items.add(item);
                setCurCapacity(item.getWeight() + getCurCapacity());
            }
        } catch (ArithmeticException e) {
            printItems();
        }
    }


    public void remove(Item item) {
        items.remove(item);
        setCurCapacity(getCurCapacity() - item.getWeight());
    }

    public void printItems() {
        for (Item item : items)
            item.display();
    }

    public boolean isEmpty() {
        if (items.size() == 0) {
            System.out.println("Inventory is empty.");
            return false;
        } else
            return true;
    }

    public static Inventory newInventory() {
        items.add(Weapons.newRandomWeapon());
        items.add(Clothings.newRandomClothing());
        items.add(Item.newRandomItem());
        return new Inventory(items,(items.get(0).getWeight() + items.get(1).getWeight() + items.get(2).getWeight()));
    }


}