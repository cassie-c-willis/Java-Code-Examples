import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.*;

/**
 * Activities with Maps in 2110 Lab
 * 
 * @author Cassie Willis
 * @Partners Ali Ali, Amir Gurung
 */
public class Lab6 {
	public static final String CLASSIC = "I am Sam\n\n"
			+ "I am Sam \nSam I am\n\n"
			+ "That Sam-I-am \nThat Sam-I-am! \nI do not like \nthat Sam-I-am\n\n"
			+ "Do you like \ngreen eggs and ham?\n\n"
			+ "I do not like them, \nSam-I-am. \nI do not like \ngreen eggs and ham.\n\n"
			+ "Would you like them \nHere or there?\n\n"
			+ "I would not like them \nhere or there. \nI would not like them \nanywhere. \nI do not like \ngreen eggs and ham. \nI do not like them, \nSam-I-am.\n\n"
			+ "Would you like them \nin a house? \nWould you like them \nwith a mouse?\n\n"
			+ "I do not like them \nin a house. \nI do not like them \nwith a mouse. \nI do not like them \nhere or there. \nI do not like them \nanywhere. \nI do not like green eggs and ham. \nI do not like them, Sam-I-am.\n\n"
			+ "Would you eat them \nin a box? \nWould you eat them \nwith a fox?\n\n"
			+ "Not in a box. \nNot with a fox. \nNot in a house. \nNot with a mouse. \nI would not eat them here or there. \nI would not eat them anywhere. \nI would not eat green eggs and ham. \nI do not like them, Sam-I-am.\n\n"
			+ "Would you? Could you? \nin a car? \nEat them! Eat them! \nHere they are.\n\n"
			+ "I would not, \ncould not, \nin a car?\n\n"
			+ "You may like them. \nYou will see. \nYou may like them \nin a tree? \nNot in a tree. \nI would not, could not in a tree. \nNot in a car! You let me be.\n\n"
			+ "I do not like them in a box. \nI do not like them with a fox \nI do not like them in a house \nI do not like them with a mouse \nI do not like them here or there. \nI do not like them anywhere. \nI do not like green eggs and ham. \nI do not like them, Sam-I-am.\n\n"
			+ "A train! A train! \nA train! A train! \nCould you, would you \non a train?\n\n"
			+ "Not on a train! Not in a tree! \nNot in a car! Sam! Let me be! \nI would not, could not, in a box. \nI could not, would not, with a fox. \nI will not eat them with a mouse \nI will not eat them in a house. \nI will not eat them here or there. \nI will not eat them anywhere. \nI do not like them, Sam-I-am.\n\n"
			+ "Say! \nIn the dark? \nHere in the dark! \nWould you, could you, in the dark?\n\n"
			+ "I would not, could not, \nin the dark.\n\n"
			+ "Would you, could you, \nin the rain?\n\n"
			+ "I would not, could not, in the rain. \nNot in the dark. Not on a train, \nNot in a car, Not in a tree. \nI do not like them, Sam, you see. \nNot in a house. Not in a box. \nNot with a mouse. Not with a fox. \nI will not eat them here or there. \nI do not like them anywhere!\n\n"
			+ "You do not like \ngreen eggs and ham?\n\n"
			+ "I do not \nlike them, \nSam-I-am.\n\n"
			+ "Could you, would you, \nwith a goat?\n\n"
			+ "I would not, \ncould not, \nwith a goat!\n\n"
			+ "Would you, could you, \non a boat?\n\n"
			+ "I could not, would not, on a boat. \nI will not, will not, with a goat. \nI will not eat them in the rain. \nI will not eat them on a train. \nNot in the dark! Not in a tree! \nNot in a car! You let me be! \nI do not like them in a box. \nI do not like them with a fox. \nI will not eat them in a house. \nI do not like them with a mouse. \nI do not like them here or there. \nI do not like them ANYWHERE!\n\n"
			+ "I do not like \ngreen eggs \nand ham!\n\n"
			+ "I do not like them, \nSam-I-am.\n\n"
			+ "You do not like them. \nSo you say. \nTry them! Try them! \nAnd you may. \nTry them and you may I say.\n\n"
			+ "Sam! \nIf you will let me be, \nI will try them. \nYou will see.\n\n"
			+ "Say! \nI like green eggs and ham! \nI do! I like them, Sam-I-am! \nAnd I would eat them in a boat! \nAnd I would eat them with a goat... \nAnd I will eat them in the rain. \nAnd in the dark. And on a train. \nAnd in a car. And in a tree. \nThey are so good, so good, you see!\n\n"
			+ "So I will eat them in a box. \nAnd I will eat them with a fox. \nAnd I will eat them in a house. \nAnd I will eat them with a mouse. \nAnd I will eat them here and there. \nSay! I will eat them anywhere!\n\n"
			+ "I do so like \ngreen eggs and ham! \nThank you! \nThank you, \nSam-I-am";

	/**
	 * Reads all the words from a scanner and adds a lower-case version of each into a set.
	 * @param s the scanner to use
	 * @return A set of lower-case versions of the words from the scanner
	 */
	public static Set<String> findUniqueWords(Scanner s) {
		Set<String> unique = new TreeSet<String>();
		
		while (s.hasNext()) {
			String ss = s.next();
			unique.add(ss.toLowerCase());
		}		
		return unique;
	}

	/**
	 * Reads all the words from a scanner and find the frequency of each
	 * @param s the scanner to use
	 * @return A map of with words as keys and numbers of occurrences as values
	 */
	public static Map<String, Integer> countWords(Scanner s) {
		Map<String, Integer> maps = new TreeMap<String, Integer>();
		
		while (s.hasNext()) {
			String word = s.next();
			word = word.toLowerCase();
			Integer count = 0;
			if(maps.containsKey(word)) {
				count = maps.get(word);
				count = count + 1;
				maps.put(word, count);
			
			}
			else {
				maps.put(word, 1);
			}
		}
		return maps;
	}
	
	/**
	 * Creates a reverse map (e.g., keys become values and vice versa)
	 * @param m A map to reverse
	 * @return A reverse map, with sets for values to handle multiple keys mapping to a single value
	 */
	public static Map<Integer, Set<String>> reverseMap(Map<String, Integer> m) {
		Map<String, Integer> original = m;
		Map<String, Integer> reversed = new HashMap<String, Integer>();
		

		return null;
	}
	
	/**
	 * Prints a map, one entry per line, in format key: value
	 * @param m The map to print
	 */
	public static void printMap(Map<? extends Object, ? extends Object> m) {
		Map<? extends Object, ? extends Object> toPrint = m;
		
		String mapPrint = toPrint.toString();
		System.out.println(mapPrint);

	}
	
	/**
	 * Finds the differences between two texts, as represented by word count maps.
	 * @param t1 The result of calling countWords(firstText)
	 * @param t2 The result of calling countWords(secondText)
	 * @return the difference: 0.0 for identical texts, 2.0 for text with no shared words.
	 */
	public static double wordDifference(Map<String, Integer> t1, Map<String, Integer> t2) {
		return -1;
	}

	/**
	 * A main method for playing with the methods above. Uncomment sections as they are completed.
	 */
	public static void main(String[] args) throws IOException {
		Scanner seuss;
		
		// Step 0:
		seuss = new Scanner(CLASSIC).useDelimiter("[^A-Za-z]+");
		System.out.println(findUniqueWords(seuss).size()); // how many words did Dr Seuss use?
		seuss.close();

		// Step 1:
		seuss = new Scanner(CLASSIC).useDelimiter("[^A-Za-z]+");
		Map<String, Integer> counts = countWords(seuss);
		System.out.println(counts); // how often did he use each word?
		seuss.close();
	}
}
