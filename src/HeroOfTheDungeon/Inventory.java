package HeroOfTheDungeon;

public class Inventory {
    private Item[] items;
    private final int maxCapacity = 100;
    private int curCapacity;

    public Inventory() {
        items = new Item[0];
        this.curCapacity = 0;
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


    public void remove(Item item) {
        for(int i = 0; i < items.length; i++) {
            if(item == items[i]) {
                items[i] = null;
                return;
            }
            setCurCapacity(getCurCapacity() - item.getWeight());
        }

    }

    public Item remove(String itemName) {
        // If they passed null, exit
        if(itemName == null) {
            return null;
        }

        // For each item in the room
        for(int i = 0; i < items.length; i++) {
            Item item = items[i];
            // If it's null, don't bother checking and
            // move on to the next item in the array
            if(item == null) {
                continue;
            }
            // If it's the same name, remove it
            if(itemName.equalsIgnoreCase(item.getName())) {
                items[i] = null;
                return item;
            }
        }

        return null;
    }

    public boolean contains(Item item) {
        if(item == null) {
            return false;
        }
        for(int i = 0; i < items.length; i++) {
            if(item == items[i]) {
                return true;
            }
        }
        return false;
    }

    public boolean contains(String itemName) {
        if(itemName == null) {
            return false;
        }

        for(int i = 0; i < items.length; i++) {
            Item item = items[i];
            if(item == null) {
                continue;
            }if(itemName.equalsIgnoreCase(item.getName())) {
                return true;
            }
        }

        return false;
    }


    public void printItems(String outputFormatString) {
        // For each item
        for(int i = 0; i < items.length; i++) {
            Item item = items[i];
            // If it's null, don't bother printing and
            // move onto the next item in the array
            if(item == null) {
                continue;
            }
            // Print the item
            String itemName = item.getName();
            System.out.printf(outputFormatString, itemName);
        }
    }

    public boolean isEmpty() {
        for(int i = 0; i < items.length; i++) {
            if(items[i] != null) {
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