package InheritanceShops;

import java.io.IOException;

public class BookShop extends Shop {
	String file = "src/book_prices.txt";
	
	//The the values are set when the book shop is initialized. 
	public BookShop() throws IOException {
		readFile(file);
		addItem("The C Programming Language", 23);
		addItem("C++ Unplugged", 50);
		addItem("Object Oriented Design with Java", 0);
		addItem("Advanced Operating Systems Concepts", 50);
		addItem("Fundamentals of Algorithmics", 50);
		addItem("Digital Image Processing", 50);
		addItem("Graph Theory", 14);
		addItem("Numerical Recipes in C", 49);
		addItem("Data and File Structures", 50);
		
	}
	
	
	
}