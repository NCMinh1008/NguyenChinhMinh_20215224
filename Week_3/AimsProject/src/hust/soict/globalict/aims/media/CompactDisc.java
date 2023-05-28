package hust.soict.globalict.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable{
	
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<Track>();
    
    public CompactDisc() {
		super();
		// TODO Auto-generated constructor stub
	}
    public CompactDisc(String title, String artist, float cost) {
    	this.setTitle(title);
    	this.artist=artist;
    	this.setCost(cost);
    }
    
	public String getArtist() {
		return artist;
	}

	public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.out.println("The track '" + track.getTitle() + "' already exists in the CD.");
        } else {
            tracks.add(track);
            System.out.println("The track '" + track.getTitle() + "' has been added to the CD.");
        }
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("The track '" + track.getTitle() + "' has been removed from the CD.");
        } else {
            System.out.println("The track '" + track.getTitle() + "' does not exist in the CD.");
        }
    }
    
    public double getCDLength() {
        double totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }
    
    public void play() {
    	System.out.println("Playing DVD: " + this.getTitle()); 

    	System.out.println("DVD length: " + this.getLength()); 
    	for (Track track : tracks) {
            track.play();
        }
    }
    
    @Override
    public String toString() {
        return "CD by: " + artist + " (" + tracks.size() + " tracks)";
    }
    


}
