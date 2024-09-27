package Shops;

import java.io.*;

import BuyerAndShopExceptions.NoItemException;
import BuyerAndShopExceptions.NoStockException;

public class Shop {
	String[] items_list = new String[9];
	double[] items_costs = new double[9];
	int[] items_quants = new int[9];
 	
	protected void readFile(String file) throws NumberFormatException, IOException{
		int i = 0, index = 0;
		String line;
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
		
		//File is read line by line. After a line is read the string of character preceding the comma is stored in the item list.
		//The characters after a converted to double and stored in the item cost.
        while ((line = bufferedReader.readLine()) != null){
        	index = line.indexOf(',');
        	items_list[i] = line.substring(0, index);
        	setPrice(items_list[i], Double.valueOf(line.substring(index + 1, line.length()))); 
        	i++;
        }
        
        bufferedReader.close();
	}
	
	//Iterates through the Items, if it is not found then NoItemException is thrown.
	private void checkItem (String item) throws NoItemException{
		for(int i = 0; i < items_list.length; i++) {
			if(items_list[i].equalsIgnoreCase(item)) {
				return;
			}
		}
		
		throw new NoItemException();
	}
	
	public void checkQuantity (String item, int quantity) throws NoStockException {
		for(int i = 0; i < items_list.length; i++) {
			if(items_list[i].equalsIgnoreCase(item)) {
				if(items_quants[i] <= quantity) {
					return;
				}
				else {
					break;
				}
			}
		}
		
		throw new NoStockException();
	}
	
	public String listItem (int itemNum) {		
		return items_list[itemNum] + ", Rs." + getPrice(items_list[itemNum]);
		
	}
	
	//Iterates through the Items, when it is found then the quantity is added.
	public void addItem (String item, int qty){
		for(int i = 0; i < items_list.length; i++) {
			if(items_list[i].equalsIgnoreCase(item)) {
				items_quants[i] += qty;
				break;
			}
		}
	}
	
	//Iterates through the Items, when it is found then the price is set.
	public void setPrice (String item, double price) {
		for(int i = 0; i < items_list.length; i++) {
			if(items_list[i].equalsIgnoreCase(item)) {
				items_costs[i] = price;
				break;
			}
		}
	}
	
	//Checks if the item exist first, if it does then it returns it's price. Otherwise it prints the exception name(NoItemException) and returns -1
	public double getPrice (String item) {
		try {
			checkItem(item);
		}catch(NoItemException e) {
			System.out.print(e.getClass().getName() + "\n");
			Q1_Shopping.ShoppingGUI.errorMessage = "Item does not exist.";
			return -1;
		}
		
		int itemNum = 0;
		for(int i = 0; i < items_list.length; i++) {
			if(items_list[i].equalsIgnoreCase(item)) {
				itemNum = i;
				break;
			}
		}
		
		return items_costs[itemNum];
	}
	
	//First the position of the item is found, then if the quantity of entered is less than amount in stock then NoStockException is thrown. 
	//Then if the item is in stock, the items bought are deducted and the cost of purchase is returned. 
	public double buyItem (String item, int qty) throws NoStockException{
		int itemNum = 0;
		
		for(int i = 0; i < items_list.length; i++) {
			if(items_list[i].equalsIgnoreCase(item)) {
				itemNum = i;
				break;
			}
		}
		
		if(items_quants[itemNum] < qty ) {
			throw new NoStockException();
		}
		
		addItem(item, -qty);
		double price = getPrice(item)*qty;
		System.out.print("\nCost of purchase:" + price +"\n");
		return price;
	}
}
