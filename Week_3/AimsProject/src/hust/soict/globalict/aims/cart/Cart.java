package hust.soict.globalict.aims.cart;
import java.util.ArrayList;
import java.util.List;

import hust.soict.globalict.aims.disc.DigitalVideoDisc;
public class Cart {
      public static final int MAX_NUMBERS_ORDERED = 20;
      private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
      private int qtyOrdered = 0;
      public void addDigitalVideoDisc(DigitalVideoDisc disc) {
    	  if(qtyOrdered + 1 > 20) {
    		  System.out.println("The cart is already full.\n");
    	  }
    	  else {
    		  itemsOrdered[qtyOrdered++] = disc;
              System.out.println("The disc has been added.\n");
    	  }
      }
      public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
          for (int i = 0; i < qtyOrdered; i++) {
              if (itemsOrdered[i] == disc) {
                  for (int j = i; j < qtyOrdered - 1; j++) {
                      itemsOrdered[j] = itemsOrdered[j + 1];
                  }
                  itemsOrdered[--qtyOrdered] = null;
                  break;
              }
          }
      }
      public void addDigitalVideoDisc(DigitalVideoDisc... dvdList) {
    	  if(qtyOrdered + dvdList.length > 20) {
    		  System.out.println("The cart is already full.\n");
    	  }
    	  else {
    		  for(int i=0; i<dvdList.length;i++) {
    		  itemsOrdered[qtyOrdered++] = dvdList[i];            
    		  }
    		  System.out.println("The list of discs has been added.\n");
    	  }
      }
      
      
      public void addDigitalVideoDisc(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2) {
    	  if(qtyOrdered + 2 > 20) {
    		  System.out.println("The cart is already full.\n");
    	  }
    	  else {
    		  itemsOrdered[qtyOrdered++] = dvd1;
    		  itemsOrdered[qtyOrdered++] = dvd2;
              System.out.println("Two disc has been added.\n");
    	  }
      }

      public float totalCost() {
          float totalCost = 0.0f;
          for (int i = 0; i < qtyOrdered; i++) {
              totalCost += itemsOrdered[i].getCost();
          }
          return totalCost;
      }
      public void printlist(){
    	  if (qtyOrdered==0) {
              System.out.println("The cart is empty.");
              return;
          }
    	  else {
          float tc=totalCost();
          System.out.println("***********************CART***********************");
          System.out.println("Ordered Items:");
          for (int i=0; i<qtyOrdered;i++) {
        	  System.out.println(itemsOrdered[i]);
          }
          System.out.println("Total cost: " + tc);
          System.out.println("***************************************************");
    	  }
      }
      
      public void searchById(int itemId) {
    	  int check=0;
          for (int i=0; i<qtyOrdered;i++) {
              if (itemsOrdered[i].getId()==itemId) {
            	  System.out.println("Search Results for the Id: " + itemId);
                  System.out.println(itemsOrdered[i]);
                  check=1;
              }
          }
          if(check==0) {
          System.out.println("No match is found");}
      }
      
      public void searchByTitle(String itemTitle) {
    	  int qty=0;
    	  DigitalVideoDisc searchResults[] = new DigitalVideoDisc[20];
          for (int i=0; i<qtyOrdered;i++) {
              if (itemsOrdered[i].isMatch(itemTitle)) {
            	  searchResults[qty++] = itemsOrdered[i];
              }
          }

          if (qty==0) {
              System.out.println("No matching DVDs found for the title: " + itemTitle);
          } else {
              System.out.println("Search Results for the title: " + itemTitle);
              for (int i=0; i<qty;i++) {
                  System.out.println(searchResults[i]);
              }
          }
      }
}