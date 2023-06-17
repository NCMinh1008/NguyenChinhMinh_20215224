package hust.soict.globalict.aims.media;
import java.util.ArrayList;
import java.util.Collections;


public class Test {

	public static void main(String[] args) {
		 ArrayList<Media> mediaList = new ArrayList<>();

	     CompactDisc cd = new CompactDisc("Album", "Artist", 12);
	     DigitalVideoDisc dvd = new DigitalVideoDisc("Movie", "Director", 120);
	     Book book = new Book("Title", 200);

	     mediaList.add(cd);
	     mediaList.add(dvd);
	     mediaList.add(book);


	     // Sort by title then cost
	     Collections.sort(mediaList, new MediaComparatorByTitleCost());

	     // Sort by cost then title
	     Collections.sort(mediaList, new MediaComparatorByCostTitle());
	     for (Media media : mediaList) {
	         System.out.println(media.toString());
	     }

	}

}
