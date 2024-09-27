package Q2_VegetableShopping;

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
	
	public void buyItem (VegetableShop vshop, String buy_item, int quant) throws NoMoneyException {
		double price = vshop.getPrice(buy_item);
		if (price < 0) {
			System.out.println("Vegetable " + buy_item + " is not sold");
			return;
		}

		if(price*quant > getMoney()) {
			throw new NoMoneyException();
		}
		
		try {
			vshop.buyItem(buy_item, quant);
		}catch(NoStockException e){
			System.out.print(e.getClass().getName() + "\n");
			System.out.println(e.getMessage());
			return;
		}
		
		addMoney(-price*quant);
	}
}

