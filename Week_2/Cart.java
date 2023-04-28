import java.io.*;
import java.util.*;
public class Cart {
      public static final int MAX_NUMBERS_ORDERED = 20;
      private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
      private int qtyOrdered = 0;
      public void addDigitalVideoDisc(DigitalVideoDisc disc) {
    	  if(qtyOrdered + 1 > 20) {
    		  System.out.println("The cart is already full\n");
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

      public float totalCost() {
          float totalCost = 0.0f;
          for (int i = 0; i < qtyOrdered; i++) {
              totalCost += itemsOrdered[i].getCost();
          }
          return totalCost;
      }
}
