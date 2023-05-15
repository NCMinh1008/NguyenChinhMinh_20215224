package hust.soict.globalict.aims.store;
import hust.soict.globalict.aims.disc.DigitalVideoDisc;

public class Store {
	private DigitalVideoDisc itemsInStore[];
	private int itemCount=0;

    public Store(int capacity) {
        itemsInStore = new DigitalVideoDisc[capacity];
        itemCount = 0;
    }

    public void addDVD(DigitalVideoDisc dvd) {
        if (itemCount >= itemsInStore.length) {
            System.out.println("The store is full. Cannot add more DVDs.");
            return;
        }

        itemsInStore[itemCount] = dvd;
        itemCount++;
        System.out.println("DVD added to the store.");
    }

    public void removeDVD(DigitalVideoDisc dvd) {
        int index = findDVDIndex(dvd);
        if (index == -1) {
            System.out.println("DVD not found in the store.");
            return;
        }

        // Shift remaining DVDs to fill the gap
        for (int i = index; i < itemCount - 1; i++) {
            itemsInStore[i] = itemsInStore[i + 1];
        }

        itemsInStore[itemCount - 1] = null;
        itemCount--;
        System.out.println("DVD removed from the store.");
    }

    private int findDVDIndex(DigitalVideoDisc dvd) {
        for (int i = 0; i < itemCount; i++) {
            if (itemsInStore[i].equals(dvd)) {
                return i;
            }
        }
        return -1;
    }
}
