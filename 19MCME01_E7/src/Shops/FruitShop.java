package Shops;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import BuyerAndShopExceptions.NoItemException;
import BuyerAndShopExceptions.NoStockException;

public class FruitShop {
	String[] fruit_list = new String[9];
	double[] fruit_costs = new double[9];
	int[] fruit_quants = new int[9];
 	String file = "src/fruit_prices.txt";
 	
 	public FruitShop() throws NumberFormatException, IOException{
		int i = 0, index = 0;
		String line;
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
		
        while ((line = bufferedReader.readLine()) != null){
        	index = line.indexOf(',');
        	fruit_list[i] = line.substring(0, index);
        	setPrice(fruit_list[i], Double.valueOf(line.substring(index + 1, line.length()))); 
        	i++;
        }
        
        bufferedReader.close();
        
        addFruit("Bananas", 40);
        addFruit("Apples", 20);
        addFruit("Pears", 34);
        addFruit("Kiwi", 50);
        addFruit("Strawberry", 12);
        addFruit("Papaya", 2);
		addFruit("Anar", 42);
		addFruit("Oranges", 31);
		addFruit("Mango", 24);
	}
	
	private void checkFruit (String fruit) throws NoItemException{
		for(int i = 0; i < fruit_list.length; i++) {
			if(fruit_list[i].equalsIgnoreCase(fruit)) {
				return;
			}
		}
		
		throw new NoItemException();
	}
	
	public void listFruit () {
		for(int i = 0; i < fruit_list.length; i++) {
			System.out.print("\nFruit " + (i+1) +" - name:" + fruit_list[i] + ", price:" + fruit_costs[i] );
		}
	}
	public void addFruit (String fruit, int qty) {
		for(int i = 0; i < fruit_list.length; i++) {
			if(fruit_list[i].equalsIgnoreCase(fruit)) {
				fruit_quants[i] += qty;
				break;
			}
		}
	}
	
	public void setPrice (String fruit, double price) {
		for(int i = 0; i < fruit_list.length; i++) {
			if(fruit_list[i].equalsIgnoreCase(fruit)) {
				fruit_costs[i] = price;
				break;
			}
		}
	}
	
	public double getPrice (String fruit) {
		try {
			checkFruit(fruit);
		}catch(NoItemException e) {
			System.out.print(e.getClass().getName() + "\n");
			return -1;
		}
		
		int itemNum = 0;
		for(int i = 0; i < fruit_list.length; i++) {
			if(fruit_list[i].equalsIgnoreCase(fruit)) {
				itemNum = i;
				break;
			}
		}
		
		return fruit_costs[itemNum];
	}
	
	public double buyFruit (String fruit, int qty) throws NoStockException{
		int itemNum = 0;
		
		for(int i = 0; i < fruit_list.length; i++) {
			if(fruit_list[i].equalsIgnoreCase(fruit)) {
				itemNum = i;
				break;
			}
		}
		
		if(fruit_quants[itemNum] < qty ) {
			throw new NoStockException();
		}
		
		addFruit(fruit, -qty);
		double price = getPrice(fruit)*qty;
		System.out.print("\nCost of purchase:" + price +"\n");
		return price;
	}
}
