/** @author Cassie Willis ccw5ft
 * Homework 2
 * Lab Section 104 */

/** Java import statements */
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Mp3Player { /** Mp3Player class that starts songs from a given file */
	
	public PlayList main = new PlayList("Main Playlist"); /** instantiates an empty default PlayList */
	public ArrayList<PlayList> all = new ArrayList<PlayList>(); /** instantiates an ArrayList of PlayLists */

	/** main method that runs when user starts the program */
	public static void main(String[] args) throws IOException { 
		Mp3Player mp3 = new Mp3Player();
		mp3.start();
	}

	/** asks the user for a file and gets the song from that file and puts the song in the main playlist */
	private void start() throws IOException { 
		String file;
		System.out.println("What is the filename?");
		Scanner input = new Scanner(System.in);
		file = input.next();
		main.loadSongs(file);
		input.close();
	}
	
	/** returns the Main Playlist*/
	public PlayList getDefaultPlayList() { 
		return main;
	}
	
	/** returns an array of all the playlists */
	public ArrayList<PlayList> getPlayLists() { 
		return all;
	}
}

/** End Of Code */
