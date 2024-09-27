package InheritanceShops;

import java.io.IOException;

public class FruitShop extends Shop{
	String file = "src/fruit_prices.txt";
	
	//The the values are set when the fruit shop is initialized. 
	public FruitShop() throws IOException {
		readFile(file);
		addItem("Bananas", 40);
		addItem("Apples", 20);
		addItem("Pears", 34);
		addItem("Kiwi", 50);
		addItem("Strawberry", 12);
		addItem("Papaya", 2);
		addItem("Anar", 42);
		addItem("Oranges", 31);
		addItem("Mango", 24);
	}
}
