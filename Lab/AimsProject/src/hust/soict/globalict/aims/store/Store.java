package hust.soict.globalict.aims.store;
import hust.soict.globalict.aims.media.*;
import java.util.ArrayList;

public class Store {
	private ArrayList<Media> itemsInStore;
	public Store() {
        itemsInStore = new ArrayList<>();
    }

	public void addMedia(Media media) {
		itemsInStore.add(media);
        System.out.println("Added " + media.getTitle() + " to the cart.");
    }

    public void removeMedia(Media media) {
        if (itemsInStore.remove(media)) {
            System.out.println("Removed " + media.getTitle() + " from the cart.");
        } else {
            System.out.println(media.getTitle() + " is not found in the cart.");
        }
    }

    public Media findMediaByTitle(String title) {
        for (Media media : itemsInStore) {
            if (media.getTitle().equals(title)) {
                return media;
            }
        }
        return null;
    }

    public ArrayList<Media> displayStoreItems() {
        return itemsInStore;
    }


}
