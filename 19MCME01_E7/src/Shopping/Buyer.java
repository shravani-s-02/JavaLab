package Shopping;

import BuyerAndShopExceptions.NoMoneyException;
import BuyerAndShopExceptions.NoStockException;
import InheritanceShops.Shop;
import Shops.VegetableShop;
import Shops.BookShop;
import Shops.FruitShop;

public class Buyer {
	double cash;
	
	Buyer(double cash){
		this.cash = cash;
	}
	
	public double addMoney (double money) {
		cash += money;
		return cash;
	}
	
	public double getMoney () {
		return cash;
	}
	
	public void buyItem (Shop shop, String buy_item, int quant) throws NoMoneyException {
		//Check item is done in getPrice
		double price = shop.getPrice(buy_item);
		//If the price value return is -1 it means that the item is not sold, so a exception message is printed.
		if (price == -1) {
			System.out.println("Item " + buy_item + " is not sold");
			return;
		}

		//If money is insufficient no money exception is thrown
		if(price*quant > getMoney()) {
			throw new NoMoneyException();
		}
				
		//Checking of if the item is in stock is done in buy item. If it's not in stock the name of the exception(NoItemException) and it's message are printed.  
		try {
			shop.buyItem(buy_item, quant);
		}catch(NoStockException e){
			System.out.print(e.getClass().getName() + "\n");
			System.out.println(e.getMessage());
			return;
		}
		
		//Cost of purchase is deducted from the wallet. 
		addMoney(-price*quant);
	}
	
	public void buyVeg (VegetableShop vshop, String buy_item, int quant) throws NoMoneyException {
		//Check item is done in getPrice
		double price = vshop.getPrice(buy_item);
		//If the price value return is -1 it means that the item is not sold, so a exception message is printed.
		if (price < 0) {
			System.out.println("Vegetable " + buy_item + " is not sold");
			return;
		}

		//If money is insufficient no money exception is thrown
		if(price*quant > getMoney()) {
			throw new NoMoneyException();
		}
				
		//Checking of if the item is in stock is done in buy item. If it's not in stock the name of the exception(NoItemException) and it's message are printed.
		try {
			vshop.buyVeg(buy_item, quant);
		}catch(NoStockException e){
			System.out.print(e.getClass().getName() + "\n");
			System.out.println(e.getMessage());
			return;
		}
		
		addMoney(-price*quant);
	}
	
	public void buyFruit (FruitShop fshop, String buy_item, int quant) throws NoMoneyException {
		//Check item is done in getPrice
		double price = fshop.getPrice(buy_item);
		//If the price value return is -1 it means that the item is not sold, so a exception message is printed.
		if (price < 0) {
			System.out.println("Fruit " + buy_item + " is not sold");
			return;
		}

		//If money is insufficient no money exception is thrown
		if(price*quant > getMoney()) {
			throw new NoMoneyException();
		}
				
		//Checking of if the item is in stock is done in buy item. If it's not in stock the name of the exception(NoItemException) and it's message are printed.
		try {
			fshop.buyFruit(buy_item, quant);
		}catch(NoStockException e){
			System.out.print(e.getClass().getName() + "\n");
			System.out.println(e.getMessage());
			return;
		}
		
		addMoney(-price*quant);
	}
	
	public void buyBook (BookShop bshop, String buy_item, int quant) throws NoMoneyException {
		//Check item is done in getPrice
		double price = bshop.getPrice(buy_item);
		//If the price value return is -1 it means that the item is not sold, so a exception message is printed.
		if (price < 0) {
			System.out.println("Book " + buy_item + " is not sold");
			return;
		}

		//If money is insufficient no money exception is thrown
		if(price*quant > getMoney()) {
			throw new NoMoneyException();
		}
				
		//Checking of if the item is in stock is done in buy item. If it's not in stock the name of the exception(NoItemException) and it's message are printed.
		try {
			bshop.buyBook(buy_item, quant);
		}catch(NoStockException e){
			System.out.print(e.getClass().getName() + "\n");
			System.out.println(e.getMessage());
			return;
		}
		
		addMoney(-price*quant);
	}
}

