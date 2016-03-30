/** @author Cassie Willis ccw5ft
 * Homework 1
 * Lab Section 104 */

/** Sources used :
 * http://stackoverflow.com/questions/2312756/in-java-how-to-read-from-a-file-a-specific-line-given-the-line-number
 * http://stackoverflow.com/questions/453018/number-of-lines-in-a-file-in-java
 */

/** All necessary imports for this program */
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class PlayList extends Song {
	
	private String name; /** contains the name of the play list */
	private ArrayList<Song> songList; /** ArrayList of songs that make up the play list */

	/**  Getters / Setters for name and songList */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Song> getSongList() {
		return songList;
	}

	public void setSongList(ArrayList<Song> songList) {
		this.songList = songList;
	}
	
	/** Returns the name of the play list and the list of songs in it */
	@Override
	public String toString() { 
		return "This Playlist is called " + name + ". Songs in the playlist include: " + songList;
	}
	
	/** Constructor for an empty and untitled play list */
	public PlayList() {
		super(null);
		this.name = "Untitled";
		this.songList = new ArrayList<Song>();
	}
	
	/** Constructor for the same play list as above but renamed */
	public PlayList(String newName) {
		super(null);
		this.name = newName;
	}

	/** Loads songs from a file given the file name 
	 * @throws IOException */
	@SuppressWarnings("resource")
	public boolean loadSongs(String fileName) throws IOException { 
		File songFile = new File(getName());
		Scanner scanfile = null;
		int songlinecount = 0;
		
		try {
			scanfile = new Scanner(songFile);
			FileInputStream fileinput = new FileInputStream(songFile);
			BufferedReader buffered = new BufferedReader(new InputStreamReader(fileinput));
			
			while (scanfile.hasNextLine()) {	
				
				if (songlinecount == 0) {
					this.title = buffered.readLine();
					scanfile.nextLine();
					songlinecount++;
				}
				
				else if (songlinecount == 1) {
					this.artist = buffered.readLine();
					scanfile.nextLine();
					songlinecount++;
				}
				
				else if (songlinecount == 2) {
					this.minutes = buffered.readLine().charAt(0) + buffered.readLine().charAt(1);
					this.seconds = buffered.readLine().charAt(3) + buffered.readLine().charAt(4);
					scanfile.nextLine();
					songlinecount++;
				}
				
				else if (songlinecount == 3) {
					scanfile.nextLine();
					songlinecount++;
				}
				
				else {
					songlinecount = songlinecount - 3;
				}
			}
			
			Song fromFile = new Song(this.title, this.artist, this.minutes, this.seconds);
			songList.add(fromFile);	
			
		} 
		
		catch (FileNotFoundException e) {
			System.out.println("File Not Found");
		}
		
		return true;
	}
	
	/** Removes all songs from the PlayList */
	public boolean clear() {
		songList.clear();
		return true;
	}
	
	/** Adds a song to the end of the play list */
	public boolean addSong(Song s) {
		Song songnew = new Song(getTitle(), getArtist(), getMinutes(), getSeconds());
		songList.add(songnew);
		return true;
	}
	
	/** Removes and returns the Song at a certain index in the play list */
	public Song removeSong(int index) {
		Song toBeRemoved = songList.get(index);
		songList.remove(index);
		return toBeRemoved;
	}
	
	/** Removes every occurrence of a Song from the play list and returns the Song */
	public Song removeSong(Song s) {
		Song s1 = new Song(s);
		
		while (songList.contains(s1)) {
				songList.remove(s1);
		}	
		
		return s1;
	}
	
	/** Returns the song at that index */
	public Song getSong(int index) {
		return songList.get(index);
	}

	/** Plays the entire play list, calling each Song in order and printing its information */
	public void play() {
		for (int i = 0; i <= songList.size(); i++) {
			this.play();
		}
	}
	
	/** Returns the number of songs in the play list */
	public int size() {
		return songList.size();
	}
	
	/** Main method for running */
	public static void main(String[] args) {
		
	}
}
