package Q2_VegetableShopping;
//Modification of "VegMain" code given 
import java.util.Scanner;

public class testingQ2 {
	public static void main (String args[]) {
	 	Scanner enter = new Scanner (System.in);
			 
	 	System.out.print("Enter the amount in your wallet:");
	 	double amount = enter.nextDouble(); 
		
	 	Buyer shopper = new Buyer(amount);
		VegetableShop vshop = new VegetableShop();
		
		vshop.setVegetables(0, "Onion", 24);
		vshop.setVegetables(1, "Tomato", 26);
		vshop.setVegetables(2, "Cucumber", 12);
		vshop.setVegetables(3, "Potato", 3);
		vshop.setVegetables(4, "Carrot", 17);
		
		vshop.setPrice("Onion", 25);
		vshop.setPrice("Tomato", 16);
		vshop.setPrice("Cucumber", 27);
		vshop.setPrice("Potato", 21);
		vshop.setPrice("Carrot", 50);
		
		String to_buy, option;
		double addAmount = 0;
		int qty = 0, i = 1;
		boolean eoi = false;

		vshop.listVeg();
		System.out.print("\n");
		
		do {
			do {
				i = 0;
				System.out.print ("\nDo you wish to buy a vegetable(Buy), add money to your wallet(Add) or Exit(Done):");
				option = enter.next ();
				if(!(option.equalsIgnoreCase("Buy") | option.equalsIgnoreCase("Add") | option.equalsIgnoreCase("Done"))) {
					System.out.print("Option entered is invalid");
					i++;
				}
			}while(i == 1);
			
			if (!option.equals("Done")) {
				if(option.equalsIgnoreCase("Buy")) {
					eoi = false;
					System.out.print ("\nEnter Vegetable to Buy:");
					to_buy = enter.next ();
					System.out.print ("Enter Quantity (in Kg):");
					qty = enter.nextInt();
					
					try {
						shopper.buyItem (vshop, to_buy, qty);
					}catch(NoMoneyException e) {
						System.out.print(e.getClass().getName() + "\n");
						System.out.print(e.getMessage() + "\n");
					}
				}
				else if(option.equalsIgnoreCase("Add")) {
					eoi = false;
					System.out.print ("\nEnter amount to add to wallet:");
					addAmount = enter.nextInt();
					shopper.addMoney(addAmount);
				}
				System.out.println("Cash in Wallet:" + shopper.getMoney());
			}else
				eoi = true;
		} while (!eoi);
			
		
		enter.close();
 }
}
