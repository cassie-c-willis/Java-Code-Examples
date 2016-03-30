/** @author Cassie Willis ccw5ft
 * Homework 2
 * Lab Section 104 */

public class Song implements Comparable<Song>, Playable { /** song class implements the comparable and playable interfaces */
	
	protected String artist; /** the artist performing the song */
	protected String title; /** the title of the song */
	protected int minutes; /** number of minutes in length */
	protected int seconds; /** number of seconds of length of the song (always less than 60) */

	/** Getters and Setters for all fields */
	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public int getSeconds() {
		if (this.seconds < 60) {
			return seconds;
		}
		
		else {
			seconds = seconds - 60;
			return seconds;
		}
	}

	public void setSeconds(int seconds) {
		if (this.seconds < 60) {
			this.seconds = seconds;
		}
		else {
			this.seconds = seconds - 60;
		}
	}
	
	/** Constructor for the Song including the song artist and title */	
	public Song(String artist, String title) { 
		this.artist = artist;
		this.title = title;
		this.minutes = 0;
		this.seconds = 0;
	}

	/** Constructor for the Song including the song artist and title as well as the song length */
	public Song(String artist, String title, int minutes, int seconds) { 
		this.artist = artist;
		this.title = title;
		this.minutes = minutes;
		this.seconds = seconds;
	}
	
	/** Constructor for the Song basically duplicating a pre-existing song */
	public Song(Song s) {
		this.title = getTitle();
		this.artist = getArtist();
		this.minutes = getMinutes();
		this.seconds = getSeconds();
		s = new Song(this.title, this.artist, this.minutes, this.seconds);
	}

	/** Returns that two Songs are equal if all four fields of the Songs are equal */
	public boolean equals(Object o) { 
		if (o instanceof Song) {
			Song s2 = (Song) o;
			if (s2.getArtist().equals(this.getArtist()) && s2.getTitle().equals(this.getTitle()) && s2.getMinutes() == this.getMinutes() 
					&& s2.getSeconds() == this.getSeconds()) {
				return true;
			}
		}
		return false;
	}
	
	/** Returns the title, artist, and length of the song */
	public String toString() { 
	    return "{Song = Title: " + title + ", Artist: " + artist + ", Song length: " + minutes + ":" + seconds + "}";
	}

	/** Returns which song is currently "playing" */
	public void play() { 
	    System.out.printf("Playing Song: artist=%-20s title=%s\n", artist, title);
	}

	/** Compares the songs by artist and then by title, overrides the method instantiated in the Comparable interface */
	@Override
	public int compareTo(Song s1) {
		int comparenum = this.artist.compareTo(s1.artist);
		if (comparenum == 0) {
			comparenum = this.title.compareTo(s1.title);
		}
		return comparenum;
	}
	
	/** gets the name of the song, overrides the method instantiated in the Playable interface */
	@Override
	public String getName() {
		return this.title;
	}

	/** gets the length of the song, overrides the method instantiated in the Playable interface */
	@Override
	public int getPlayTimeSeconds() {
		return this.minutes * 60 + this.seconds;
	}


}

/** End Of Code */
