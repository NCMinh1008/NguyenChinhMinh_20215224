package hust.soict.globalict.aims.media;

import hust.soict.globalict.aims.exception.PlayerException;

public class Track implements Playable{
	private String title;
	private int length;

	public Track() {
		// TODO Auto-generated constructor stub
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
	
	public void play() throws PlayerException{ 
        if (this.getLength() > 0) {
		System.out.println("Playing media: " + this.getTitle()); 

		System.out.println("Media length: " + this.getLength()); 
        }else {
        	throw new PlayerException("ERROR: Media length is negative!");
        }
		} 
	
	@Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Track otherTrack = (Track) obj;
        return title.equals(otherTrack.title) && length == otherTrack.length;
    }

}
