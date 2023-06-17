package hust.soict.globalict.aims.media;

public class Disc extends Media{
	private int length;
	private String director;

	
	public Disc() {
		super();
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}
	@Override
    public void displayInfo() {
		System.out.println("Title: " + this.getTitle());
        System.out.println("Category: " + this.getCategory());
        System.out.println("Director: " + this.getDirector());
        System.out.println("Length: " + this.getLength());
        System.out.println("Cost: " + this.getCost());
        // Display other book-specific information
    }
}
