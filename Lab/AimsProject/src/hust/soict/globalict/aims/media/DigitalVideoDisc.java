package hust.soict.globalict.aims.media;

import hust.soict.globalict.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable{

    private static int nbDigitalVideoDiscs = 0;
    
	public DigitalVideoDisc(String title) {
		super();
		this.setTitle(title);
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		this.setTitle(title);
		this.setCategory(category);
		this.setDirector(director);
		this.setLength(length);
		this.setCost(cost);
		nbDigitalVideoDiscs++;
		setId(nbDigitalVideoDiscs);
	}
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super();
		this.setTitle(title);
		this.setCategory(category);
		this.setDirector(director);
		this.setCost(cost);
		nbDigitalVideoDiscs++;
		setId(nbDigitalVideoDiscs);
	}
	public DigitalVideoDisc(String title, String director, float cost) {
		super();
		this.setTitle(title);
		this.setDirector(director);
		this.setCost(cost);
		nbDigitalVideoDiscs++;
		setId(nbDigitalVideoDiscs);
	}
	
	@Override
    public String toString() {
        return "DVD: " + this.getTitle() + " directed by " + this.getDirector() + " worths " + this.getCost();
    }
	
	
	public boolean isMatch(String title) {
        return this.getTitle()==title;
    }
	
	public void play() throws PlayerException{ 
        if (this.getLength() > 0) {
		System.out.println("Playing DVD: " + this.getTitle()); 

		System.out.println("DVD length: " + this.getLength()); 
        }else {
        	throw new PlayerException("ERROR: DVD length is negative!");
        }
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