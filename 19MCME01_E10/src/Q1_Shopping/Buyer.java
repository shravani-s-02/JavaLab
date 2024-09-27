package Q1_Shopping;

import BuyerAndShopExceptions.NoMoneyException;
import BuyerAndShopExceptions.NoStockException;
import InheritanceShops.Shop;

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
}

