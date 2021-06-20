package HeroOfTheDungeon;

import java.util.ArrayList;


public class Inventory {
    private ArrayList<Item> items;
    private final int maxCapacity = 100;
    private int curCapacity;

    public Inventory(ArrayList<Item> items) {
        this.items = items;
    }

    public Inventory() {
        items = new ArrayList<>();
        this.curCapacity = 0;
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

    public void add(Item item) {

        try {
            setCurCapacity(item.getWeight() + getCurCapacity());
            if ((getCurCapacity() + item.getWeight()) <= getMaxCapacity()) items.add(item);
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
        Inventory inventory = new Inventory();
        inventory.add(Weapons.newRandomWeapon());
        inventory.add(Clothings.newRandomClothing());
        inventory.add(Item.newRandomItem());
        return inventory;
    }
}