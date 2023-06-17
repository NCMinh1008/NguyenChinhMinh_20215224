package hust.soict.globalict.aims.cart;
import java.util.ArrayList;
import hust.soict.globalict.aims.media.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Collections;
import java.util.Iterator;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
public class Cart {
      private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
      public static final MediaComparatorByTitleCost COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
      public static final MediaComparatorByCostTitle COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
      

      private FloatProperty totalCost;

      public Cart() {
          totalCost = new SimpleFloatProperty(0.0f);
      }

      // Other methods in the Cart class...

      public FloatProperty getTotalCostProperty() {
          return totalCost;
      }

      // Method to calculate and update the total cost
      private void updateTotalCost() {
          float cost = 0.0f;
          // Calculate the total cost based on the items in the cart
          // Modify this logic according to your implementation

          totalCost.set(cost);
      }
      public ObservableList<Media> getItemsOrdered() {
		return itemsOrdered;
	}

	public void addMedia(Media media) {
          itemsOrdered.add(media);
          System.out.println("Added " + media.getTitle() + " to the cart.");
      }

      public void removeMedia(Media media) {
          if (itemsOrdered.remove(media)) {
              System.out.println("Removed " + media.getTitle() + " from the cart.");
          } else {
              System.out.println(media.getTitle() + " is not found in the cart.");
          }
      }
      public void addMediaByTitle(String title) {
          Media mediaToAdd = null;

          for (Media media : itemsOrdered) {
              if (media.getTitle().equalsIgnoreCase(title)) {
                  mediaToAdd = media;
                  break;
              }
          }

          if (mediaToAdd != null) {
              itemsOrdered.add(mediaToAdd);
              System.out.println("Media with the title '" + title + "' added to the cart.");
          } else {
              System.out.println("No media found with the title '" + title + "'.");
          }
      }
      public void removeMediaByTitle(String title) {
          Iterator<Media> iterator = itemsOrdered.iterator();
          boolean removed = false;

          while (iterator.hasNext()) {
              Media media = iterator.next();
              if (media.getTitle().equalsIgnoreCase(title)) {
                  iterator.remove();
                  removed = true;
              }
          }

          if (removed) {
              System.out.println("Media with the title '" + title + "' removed from the cart.");
          } else {
              System.out.println("No media found with the title '" + title + "' in the cart.");
          }
      }

      public double totalCost() {
          double total = 0.0;
          for (Media media : itemsOrdered) {
              total += media.getCost();
          }
          return total;
      }
      public void clear() {
    	  itemsOrdered.clear();
      }
      

      public int getDVDCount() {
          int count = 0;
          for (Media media : itemsOrdered) {
              if (media instanceof DigitalVideoDisc) {
                  count++;
              }
          }
          return count;
      }

      public void displayCart() {
          System.out.println("Cart Items:");
          for (Media media : itemsOrdered) {
              System.out.println(media);
          }
      }
      public void filterMediaByTitle(String title) {
          ArrayList<Media> filteredList = new ArrayList<>();
          for (Media media : itemsOrdered) {
              if (media.getTitle().equalsIgnoreCase(title)) {
                  filteredList.add(media);
              }
          }

          if (filteredList.isEmpty()) {
              System.out.println("No media found with the given title.");
          } else {
              System.out.println("Media(s) with the given title:");
              for (Media media : filteredList) {
                  media.displayInfo();
              }
          }
      }

      public void filterMediaByID(int id) {
          ArrayList<Media> filteredList = new ArrayList<>();
          for (Media media : itemsOrdered) {
              if (media.getId() == id) {
                  filteredList.add(media);
              }
          }

          if (filteredList.isEmpty()) {
              System.out.println("No media found with the given ID.");
          } else {
              System.out.println("Media(s) with the given ID:");
              for (Media media : filteredList) {
                  media.displayInfo();
              }
          }
      }
      public void sortMediaByTitle() {
          Collections.sort(itemsOrdered, new MediaComparatorByTitleCost());
          System.out.println("Media sorted by title:");
          displayCart();
      }

      public void sortMediaByCost() {
    	  Collections.sort(itemsOrdered, new MediaComparatorByCostTitle());
          System.out.println("Media sorted by cost:");
          displayCart();
      }
}