package HeroOfTheDungeon;

public class Inventory {
    private Item[] items;
    private int curCapacity;

    public Inventory() {
        items = new Item[0];
        this.curCapacity = 0;
    }


    public int getMaxCapacity() {
        return 100;
    }

    public int getCurCapacity() {
        return curCapacity;
    }

    public void setCurCapacity(int curCapacity) {
        if (curCapacity > 100)
            throw new ArithmeticException("Capacity must be <= 100");
        this.curCapacity = curCapacity;
    }

    public int calculateItemsValue() {
        int value = 0;
        for (Item item : items) {
            value += item.getValue();
        }
        return value;
    }

    public void add(Item item) {
        try {
            if ((getCurCapacity() + item.getWeight()) <= getMaxCapacity()) {
                for (int i = 0; i < items.length; i++) {
                    if (items[i] == null) {
                        items[i] = item;
                        return;
                    }
                }
                int len = items.length;
                Item[] newItems = new Item[len + 1];
                System.arraycopy(items, 0, newItems, 0, len);
                newItems[len] = item;
                items = newItems;
            }
            setCurCapacity(item.getWeight() + getCurCapacity());
        } catch (ArithmeticException e) {
            printItems();
        }
    }


    public void printItems() {
        for (Item item : items) {
            if (item == null) {
                continue;
            }
            String itemName = item.getName();
            System.out.println(itemName);
        }
    }

    public boolean isEmpty() {
        for (Item item : items) {
            if (item != null) {
                return false;
            }
        }
        return true;
    }

    public void setItems(Item[] items) {
        this.items = items == null ? new Item[0] : items;
    }

    public Item[] getItems() {
        return items;
    }

    public static Inventory newInventory() {
        Inventory inventory = new Inventory();
        inventory.add(Weapons.newRandomWeapon());
        inventory.add(Clothings.newRandomClothing());
        inventory.add(Item.newRandomItem());
        return inventory;
    }


}