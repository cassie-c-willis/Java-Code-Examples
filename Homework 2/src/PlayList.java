/** @author Cassie Willis ccw5ft
 * Homework 2
 * Lab Section 104 */

/** All necessary imports for this program */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class PlayList extends Song implements Playable, Comparator<Playable> { /** Playlist class extends from the Song class 
																				and implements the Playable and Comparator interfaces */
	
	private String name; /** contains the name of the play list */
	protected ArrayList<Playable> playableList = new ArrayList<Playable>(); /** ArrayList of songs that make up the play list */

	/**  Getters and Setters for name and playableList */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Playable> getPlayableList() {
		return playableList;
	}

	public void setPlayableList(ArrayList<Playable> playableList) {
		this.playableList = playableList;
	}
	
	
	/** Returns the name of the play list and the list of songs in it */
	@Override
	public String toString() { 
		return "This Playlist is called " + name.toString() + ". Songs in the playlist include: " + playableList.toString();
	}
	
	/** Constructor for an empty and untitled play list */
	public PlayList() {
		super(null);
		this.name = "Untitled";
		this.playableList = new ArrayList<Playable>();
	}
	
	/** Constructor for the same play list as above but renamed */
	public PlayList(String newName) {
		super(null);
		this.name = newName;
	}

	/** Loads songs from a file given the file name */
	public boolean loadSongs(String fileName) { 
		File songFile = new File(fileName);
		Scanner scanfile;
		int songlinecount = 0;
		
		try {
			scanfile = new Scanner(songFile);
			FileInputStream fileinput = new FileInputStream(songFile);
			BufferedReader buffered = new BufferedReader(new InputStreamReader(fileinput));
			
			while (scanfile.hasNextLine()) {	
				
				if (songlinecount == 0) {
					String title = buffered.readLine();
					this.title = title.trim();
					scanfile.nextLine();
					System.out.println(this.title);
					songlinecount++;
				}
				
				else if (songlinecount == 1) {
					String artist = buffered.readLine();
					this.artist = artist.trim();
					scanfile.nextLine();
					System.out.println(this.artist);
					songlinecount++;
				}
				
				else if (songlinecount == 2) {
					String line = buffered.readLine().trim();
		
					if (line.length() == 5) {
						this.minutes = line.charAt(0) + line.charAt(1);
						this.seconds = line.charAt(3) + line.charAt(4);
					}
					
					else if (line.length() == 4) {
						this.minutes = line.charAt(0);
						this.seconds = line.charAt(2) + line.charAt(3);
					}
					
					else {
						this.minutes = 0;
						this.seconds = 0;
					}
					scanfile.nextLine();
					System.out.println(this.minutes + ":" + this.seconds);
					songlinecount++;
				}
				
				else if (songlinecount == 3) {
					scanfile.nextLine();
					songlinecount++;
				}
				
				else {
					songlinecount = songlinecount - 4;
				}
				
			}
			
			Song fromFile = new Song(this.title, this.artist, this.minutes, this.seconds);
			playableList.add(fromFile);	
			
			scanfile.close();
			buffered.close();
			
		} 
		
		catch (FileNotFoundException e) {
			System.out.println("File Not Found");
		}
		
		catch (IOException e) {
			System.out.println("File Cannot Be Opened");
		}
		
		return true;
	}
	
	/** sorts all of the objects (songs and playlists) in playableList by the name of the object */
	public void sortByName() {
		
		Collections.sort(playableList, new Comparator<Playable>() {
			@Override 	/** overrides the compare method in the Comparator interface */
			public int compare(Playable p1, Playable p2) {
				return (p1.getName().compareTo(p2.getName()));
				
			}	
		});
	}
	
	/** sorts all of the objects (songs and play lists) in the playableList by the length in seconds of the object */
	public void sortByTime() {
		Collections.sort(playableList, new Comparator<Playable>() { 
			@Override
			public int compare(Playable o1, Playable o2) { 
				return o1.getPlayTimeSeconds() - o2.getPlayTimeSeconds();
			}
		});
	}
	
	/** Removes all songs and playlists from the PlayList */
	public boolean clear() {
		playableList.clear();
		return true;
	}
	
	/** Adds a song to the end of the play list */
	public boolean addSong(Song s) {
		playableList.add(s);
		return true;
	}
	
	/** Equals method for the addPlayList method below - checks if the names of the playlists are the same */
	@Override
	public boolean equals(Object o) {
		if (o instanceof PlayList) {
			PlayList p1 = ((PlayList) o);
			if (p1.name.equals(this.name)) {
				return true;
			}
		}
		return false; 
	}
	
	/** Adds a playList to the end of the playableList */
	public boolean addPlayList(PlayList pl) {
		if (playableList.contains(pl)) {
			return false;
		}
		else {
			if (this.equals(pl)) {
				return false;
			}
			else {
				playableList.add(pl);
				return true;
			}
		}
	}
	
	/** Returns the total number of seconds that are in the playableList */
	public int getPlayTimeSeconds() {
		int counter = 0;
		for (Playable play : playableList) {
			if (play instanceof Song) {
				Song s1 = ((Song) play);
				int time = s1.getPlayTimeSeconds();
				counter += time;
			}
			else if (play instanceof PlayList) {
				PlayList p1 = ((PlayList) play);
				int time1 = p1.getPlayTimeSeconds();
				counter += time1;
			}
		}
		return counter;
	}
	
	/** Returns the song or playlist at a given index */
	public Playable getPlayable(int index) {
		if (index > -1 && index < playableList.size()) {
			return playableList.get(index);
		}
		else return null;
	}

	/** Plays the entire play list, calling each Song or playlist in order and printing its information */
	public void play() {
		for (int i = 0; i <= playableList.size(); i++) {
			this.play();
		}
	}
	
	
	/** Returns the number of items in the play list */
	public int size() {
		return playableList.size();
	}
	
	/** Main method for running */
	public static void main(String[] args) {
		PlayList test = new PlayList();
		test.loadSongs("songs.txt");
	}
	
	/** compares playable items by their name */
	@Override
	public int compare(Playable p1, Playable p2) {
		int retval = p1.getName().compareTo(p2.getName());
		return retval;
	}
}

/** End Of Code */
