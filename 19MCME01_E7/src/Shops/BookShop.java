package Shops;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import BuyerAndShopExceptions.NoItemException;
import BuyerAndShopExceptions.NoStockException;

public class BookShop {
	String[] book_list = new String[9];
	double[] book_costs = new double[9];
	int[] book_quants = new int[9];
 	String file = "src/book_prices.txt";
 	
 	public BookShop() throws NumberFormatException, IOException{
		int i = 0, index = 0;
		String line;
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
		
        while ((line = bufferedReader.readLine()) != null){
        	index = line.indexOf(',');
        	book_list[i] = line.substring(0, index);
        	setPrice(book_list[i], Double.valueOf(line.substring(index + 1, line.length()))); 
        	i++;
        }
        
        bufferedReader.close();
        
		addBook("The C Programming Language", 23);
		addBook("C++ Unplugged", 50);
		addBook("Object Oriented Design with Java", 0);
		addBook("Advanced Operating Systems Concepts", 50);
		addBook("Fundamentals of Algorithmics", 50);
		addBook("Digital Image Processing", 50);
		addBook("Graph Theory", 14);
		addBook("Numerical Recipes in C", 29);
		addBook("Data and File Structures", 50);
	}
	
	private void checkBook (String book) throws NoItemException{
		for(int i = 0; i < book_list.length; i++) {
			if(book_list[i].equalsIgnoreCase(book)) {
				return;
			}
		}
		
		throw new NoItemException();
	}
	
	public void listBook () {
		for(int i = 0; i < book_list.length; i++) {
			System.out.print("\nBook " + (i+1) +" - name:" + book_list[i] + ", price:" + book_costs[i] );
		}
	}
	public void addBook (String book, int qty) {
		for(int i = 0; i < book_list.length; i++) {
			if(book_list[i].equalsIgnoreCase(book)) {
				book_quants[i] += qty;
				break;
			}
		}
	}
	
	public void setPrice (String book, double price) {
		for(int i = 0; i < book_list.length; i++) {
			if(book_list[i].equalsIgnoreCase(book)) {
				book_costs[i] = price;
				break;
			}
		}
	}
	
	public double getPrice (String book) {
		try {
			checkBook(book);
		}catch(NoItemException e) {
			System.out.print(e.getClass().getName() + "\n");
			return -1;
		}
		
		int itemNum = 0;
		for(int i = 0; i < book_list.length; i++) {
			if(book_list[i].equalsIgnoreCase(book)) {
				itemNum = i;
				break;
			}
		}
		
		return book_costs[itemNum];
	}
	
	public double buyBook (String book, int qty) throws NoStockException{
		int itemNum = 0;
		
		for(int i = 0; i < book_list.length; i++) {
			if(book_list[i].equalsIgnoreCase(book)) {
				itemNum = i;
				break;
			}
		}
		
		if(book_quants[itemNum] < qty ) {
			throw new NoStockException();
		}
		
		addBook(book, -qty);
		double price = getPrice(book)*qty;
		System.out.print("\nCost of purchase:" + price +"\n");
		return price;
	}
}
