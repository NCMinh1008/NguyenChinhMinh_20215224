package hust.soict.globalict.aims.media;

import java.util.ArrayList;
public class Book extends Media{
	
	private ArrayList<String> authors = new ArrayList<String>();

	public Book() {
		// TODO Auto-generated constructor stub
		
	}
	
	public Book(String title, float cost) {
	    this.setTitle(title);
	    this.setCost(cost);
	}
	
	public Book(String title,String category) {
		super();
	    this.setTitle(title);
	    this.setCategory(category);

	}

	public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
            System.out.println(authorName + " has been added as an author of the book.");
        } else {
            System.out.println(authorName + " is already an author of the book.");
        }
    }

    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
            System.out.println(authorName + " has been removed as an author of the book.");
        } else {
            System.out.println(authorName + " is not an author of the book.");
        }
    }
    
    @Override
    public String toString() {
        return "Book: " + this.getTitle();
    }
    
    @Override
    public void displayInfo() {
        System.out.println("Title: " + this.getTitle());
        System.out.println("Authors: ");
        for (String author : authors)
	      { 		      
	           System.out.println(author); 		
	      }
        
        System.out.println("Cost: " + this.getCost());
        // Display other book-specific information
    }



}
