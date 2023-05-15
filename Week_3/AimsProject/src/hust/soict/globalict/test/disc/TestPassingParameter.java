package hust.soict.globalict.test.disc;
import hust.soict.globalict.aims.disc.DigitalVideoDisc;

public class TestPassingParameter {
      public static void main(String[] args) {
    	  DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
    	  DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
    	  
    	  
    	  Object swapped[] = swap(jungleDVD, cinderellaDVD);
    	  jungleDVD = (DigitalVideoDisc)swapped[0];
    	  cinderellaDVD = (DigitalVideoDisc)swapped[1];
    	  System.out.println("jungle dvd title: " + jungleDVD.getTitle());
    	  System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());
    	  
    	  changeTitle(jungleDVD, cinderellaDVD.getTitle());
    	  System.out.println("jungle dvd title: " + jungleDVD.getTitle());
    	  
      }
      //public static Object[] swap(Object o1, Object o2) {
      public static Object[] swap(Object o1, Object o2) {
    	  Object tmp = o1;
    	  o1 = o2;
    	  o2 = tmp;
    	  return new Object[] {o1,o2};
      }
      
      public static void changeTitle(DigitalVideoDisc dvd, String title) {
    	  String oldTitle = dvd.getTitle();
    	  dvd.setTitle(title);
    	  dvd = new DigitalVideoDisc(oldTitle);
      }
}
