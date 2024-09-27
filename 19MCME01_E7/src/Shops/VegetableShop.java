package Shops;

import java.io.*;

import BuyerAndShopExceptions.NoItemException;
import BuyerAndShopExceptions.NoStockException;

public class VegetableShop {
	String[] veg_list = new String[9];
	double[] veg_costs = new double[9];
	int[] veg_quants = new int[9];
 	String file = "src/veg_prices.txt";
 	
 	public VegetableShop() throws NumberFormatException, IOException{
		int i = 0, index = 0;
		String line;
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
		
        while ((line = bufferedReader.readLine()) != null){
        	index = line.indexOf(',');
        	veg_list[i] = line.substring(0, index);
        	setPrice(veg_list[i], Double.valueOf(line.substring(index + 1, line.length()))); 
        	i++;
        }
        
        bufferedReader.close();
        
        addVeg("Potatoes", 50);
		addVeg("Onions", 45);
		addVeg("Tomatoes", 36);
		addVeg("Capsicum", 43);
		addVeg("Lauki", 23);
		addVeg("Arbi", 5);
		addVeg("Brinjal", 20);
		addVeg("Beans", 40);
		addVeg("Carrots", 32);
	}
	
	private void checkVeg (String veg) throws NoItemException{
		for(int i = 0; i < veg_list.length; i++) {
			if(veg_list[i].equalsIgnoreCase(veg)) {
				return;
			}
		}
		
		throw new NoItemException();
	}
	
	public void listVeg () {
		for(int i = 0; i < veg_list.length; i++) {
			System.out.print("\nVegetable " + (i+1) +" - name:" + veg_list[i] + ", price:" + veg_costs[i] );
		}
	}
	public void addVeg (String veg, int qty) {
		for(int i = 0; i < veg_list.length; i++) {
			if(veg_list[i].equalsIgnoreCase(veg)) {
				veg_quants[i] += qty;
				break;
			}
		}
	}
	
	public void setPrice (String veg, double price) {
		for(int i = 0; i < veg_list.length; i++) {
			if(veg_list[i].equalsIgnoreCase(veg)) {
				veg_costs[i] = price;
				break;
			}
		}
	}
	
	public double getPrice (String veg) {
		try {
			checkVeg(veg);
		}catch(NoItemException e) {
			System.out.print(e.getClass().getName() + "\n");
			return -1;
		}
		
		int itemNum = 0;
		for(int i = 0; i < veg_list.length; i++) {
			if(veg_list[i].equalsIgnoreCase(veg)) {
				itemNum = i;
				break;
			}
		}
		
		return veg_costs[itemNum];
	}
	
	public double buyVeg (String veg, int qty) throws NoStockException{
		int itemNum = 0;
		
		for(int i = 0; i < veg_list.length; i++) {
			if(veg_list[i].equalsIgnoreCase(veg)) {
				itemNum = i;
				break;
			}
		}
		
		if(veg_quants[itemNum] < qty ) {
			throw new NoStockException();
		}
		
		addVeg(veg, -qty);
		double price = getPrice(veg)*qty;
		System.out.print("\nCost of purchase:" + price +"\n");
		return price;
	}
}
