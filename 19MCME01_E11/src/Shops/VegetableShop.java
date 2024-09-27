package Shops;

import java.io.IOException;

public class VegetableShop extends Shop{
	String file = "src/veg_prices.txt";
	
	//The stock set when the vegetable shop is initialized.
	public VegetableShop() throws IOException {
		readFile(file);
		addItem("Potatoes", 50);
		addItem("Onions", 45);
		addItem("Tomatoes", 36);
		addItem("Capsicum", 43);
		addItem("Lauki", 23);
		addItem("Arbi", 2);
		addItem("Brinjal", 20);
		addItem("Beans", 40);
		addItem("Carrots", 32);
	}
}
	