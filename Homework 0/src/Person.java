//Cassie Willis
//ccw5ft
//Homework 0
//1/28/15
//Sources: 
//	 docs.oracle.com 
//   http://stackoverflow.com/questions/16273310/check-if-java-arraylist-contains-object
//   http://stackoverflow.com/questions/8382460/how-can-i-use-the-return-statement-of-a-boolean-in-another-method

import java.util.ArrayList; 									//Import ArrayList

public class Person { 											//Person Class 

	private String name; 										//Initialize private field for Person's name
	private int id;												//Initialize private field for Person's ID
	private ArrayList<Book> read = new ArrayList<Book>();		//Initialize private ArrayList for list of books Person has read
	
	public static void main(String[] args) {					//Main function for running code

	}
	
	public Person(String name, int id){							//Constructor for the Person's name and id
		this.name = name;
		this.id = id;
	}
	
	public boolean addBook(Book b) {							//This function checks whether the Person has read a book and if 
		if (hasRead(b)) { 										//they have not it adds the book to the list of books they have read
			return false;										//Calling a function in an if statement found with help from stackoverflow (http above)
		}
		else {
			read.add(b);
			return true;
		}
	}
	
	public boolean hasRead(Book b) {							//This function checks whether Person has read a book
		if (b instanceof Book) {								//If they have read it return true
			return true;
		}
		else {													//Otherwise return false
			return false;
		}
	}
	
	public boolean forgetBook(Book b) {							//This function deletes a book from a Person's read list
		if (hasRead(b)) {										//But only if the book is initially in a Person's read list
			read.remove(b);
			return true;
		}
		return false;
	}
	
	public int numBooksRead(Book b) {							//This function counts how many books are in a Person's read list
		int bookcount = 0;										//by checking the size of the ArrayList of book read
		for (Book i : read) {
			bookcount += read.size();
		}
		return bookcount;										//Then returns that number
	}
	
	public boolean equals(Object o) {							//This function checks if two Persons are equal
		if (o instanceof Person) {  							//instanceof found on stackoverflow (full http listed in sources above) 
			Person p2 = (Person) o;
			if (((Person) o).getId() == p2.getId()) {
				return (this.name == p2.name);
			}
		}
		return false;
	}
	
	public static ArrayList<Book> commonBooks(Person a, Person b) {		//This function creates an ArrayList of the books that Person a  
		ArrayList<Book> bothread = new ArrayList<Book>();               //and Person b have both read
		if (a.getRead() == b.getRead()) {								//This if statement for if all the books both Persons have read are the same
			bothread.addAll(a.getRead()); 								//addAll() method found on docs.oracle.com
		}
		else {
			if (((CharSequence) a.getRead()).length() >= ((CharSequence) b.getRead()).length()) {	//If not all the books are the same and Person b
				for (int i=0; i <= ((CharSequence) b.getRead()).length(); i++) {					//has read fewer books then this adds similar books
					if (a.equals(b)) {																//for the length of Person b's list
						bothread.addAll(a.getRead());
					}
				}
			}
			else {
				for (int i=0; i <= ((CharSequence) a.getRead()).length(); i++) {					//If Person a has read fewer books this adds 
					if (a.equals(b)) {																//similar books for the length of Person a's list
						bothread.addAll(a.getRead());
					}
				}
			}
		}
		return bothread;																			//This function returns the list of books both Person's have read
	}
	
	public static double similarity(Person a, Person b) {											//This function determines the similarity between the books
		if (((CharSequence) b.read).length() == ((CharSequence) a.read).length()) { 				//Person a and Person b have read
			double similar = 1.0;
			return similar;
		}
		else {
			double similar = ((CharSequence) a.read).length() / ((CharSequence) b.read).length();
			return similar;																			//The function returns this similarity
		}
	}

	@Override
	public String toString() {																		//This function overrides the toString method and returns a 
		return "Book lover " + name + ", (ID number: " + id + ") has read " + read; 				//string with Person's name, id, and list of books read
	} 		

	public String getName() {					//getter for Person's name
		return name;
	}

	public void setName(String name) {			//setter for Person's name
		this.name = name;
	}

	public int getId() {						//getter for Person's id
		return id;
	}

	public ArrayList<Book> getRead() {			//getter for books Person has read
		return read;
	}

}

//End of Code
