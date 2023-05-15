package hust.soict.globalict.aims.disc;

public class DigitalVideoDisc {

	private String title;
      private String category;
      private String director;
      private int length;
      private float cost;
      private static int nbDigitalVideoDiscs = 0;
      private int id = 0;

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public DigitalVideoDisc(String title) {
		super();
		this.title = title;
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
		nbDigitalVideoDiscs++;
		setId(nbDigitalVideoDiscs);
	}
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
		nbDigitalVideoDiscs++;
		setId(nbDigitalVideoDiscs);
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
		nbDigitalVideoDiscs++;
		setId(nbDigitalVideoDiscs);
	}
	public String toString(){//overriding the toString() method  
		  return "DVD - "+title+" - "+category+" - "+director+ " - "+length+" - "+cost+"$";  
	}
	public boolean isMatch(String title) {
        return this.title.equalsIgnoreCase(title);
    }
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}