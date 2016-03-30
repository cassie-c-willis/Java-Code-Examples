//Cassie Willis
//ccw5ft
//Homework 0
//1/28/15
//Sources: 
//	 docs.oracle.com 
//   http://stackoverflow.com/questions/16273310/check-if-java-arraylist-contains-object
//   http://stackoverflow.com/questions/8382460/how-can-i-use-the-return-statement-of-a-boolean-in-another-method

public class Book { 											//Book Class
	
	private String book;										//Initializes private field for Book title
	private String author;										//Initializes private field for Book author

	public static void main(String[] args) {					//Main function for running code
	}
	
	public Book(String book, String author){					//Constructor for Book's title and author
		this.book = book;
		this.author = author;
	}
	
	public String getBook() {									//getter for Book title
		return book;	
	}
	
	public String getAuthor() {									//getter for Book author
		return author;
	}
	
	public boolean equals(Object o) {							//This function checks if Book 1 and Book 2 are the same book
		if (o instanceof Book) { 
			Book second = (Book) o;
			return (this.book == second.book && this.author == second.author);
		}
		else {
			return false;
		}
	}
	
	public String toString() {									  //This function overrides the toString method and returns the 
		return "This book is titled " + book + " by " + author;   //title and author of the Book
	}
}

//End Code