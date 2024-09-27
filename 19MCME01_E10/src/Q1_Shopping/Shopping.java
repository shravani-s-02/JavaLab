package Q1_Shopping;

import java.io.IOException;
import java.util.Scanner;
import BuyerAndShopExceptions.NoMoneyException;
import InheritanceShops.BookShop;
import InheritanceShops.FruitShop;
import InheritanceShops.VegetableShop;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;
import java.time.LocalDate;

public class Shopping {
	
	public class ShoppingGUI extends Application{

		public void start(Stage S) throws Exception {
			Menu shopMenu = new Menu("Choose Shop");
			MenuItem vegShop = new MenuItem("Vegetable Shop");
	        MenuItem fruitShop = new MenuItem("Fruit Shop");
	        MenuItem bookShop = new MenuItem("Book Shop");
	        	
	        shopMenu.getItems().add(vegShop);
	        shopMenu.getItems().add(fruitShop);
	        shopMenu.getItems().add(bookShop);
	        
	        MenuBar mb = new MenuBar();
	        
	        mb.getMenus().add(shopMenu);
	  
	        VBox vb = new VBox(mb);
	  
	        Scene sc = new Scene(vb, 500, 300);
	  
	        S.setScene(sc);
	  
	        S.show();
	        
		}
		
	}
	
	 public static void main(String args[]){
		 
		 ShoppingGUI.launch(args);
	 }
	/*public static void main (String args[]) {
	 	Scanner enter = new Scanner (System.in);
			 
	 	String to_buy, option1, option2;
		double addAmount = 0, amount = 0;
		int qty = 0, i = 0;
		boolean cont = true;
		
	 	do {
			i = 0;
		 	System.out.print("Enter the amount in your wallet:");
		 	amount = enter.nextDouble(); 
			if(qty < 0) {
				System.out.print("Amount entered is invalid enter a positive number\n");
				i++;
			}
		}while(i == 1);
		
	 	Buyer shopper = new Buyer(amount);
	 	VegetableShop vshop = null;
	 	FruitShop fshop = null;
	 	BookShop bshop = null;
	 	
	 	try {
			vshop = new VegetableShop();
			fshop = new FruitShop();
			bshop = new BookShop();
	 	}catch(IOException | NumberFormatException e) {
	 		System.out.print(e.getClass().getName() + "\n");
			System.out.print(e.getMessage() + "\n");
			System.exit(0);
	 	}
		
		while(cont == true) {
			do {
				i = 0;
				System.out.print ("\nDo you wish to make a purchase(Buy), add money to your wallet(Add) or Exit(Done):");
				option1 = enter.next ();
				if(!(option1.equalsIgnoreCase("Buy") | option1.equalsIgnoreCase("Add") | option1.equalsIgnoreCase("Done"))) {
					System.out.print("Option entered is invalid");
					i++;
				}
			}while(i == 1);
			
			if(option1.equalsIgnoreCase("Buy")) {
				cont = true;
				do {
					i = 0;
					System.out.print ("\nDo you wish to buy from the \nVegetable Shop(enter veg) \nFruit Shop(enter fruit) \nBook Shop(enter book)\nEnter:");
					option2 = enter.next ();
					if(!(option2.equalsIgnoreCase("veg") | option2.equalsIgnoreCase("fruit") | option2.equalsIgnoreCase("book"))) {
						System.out.print("Option entered is invalid");
						i++;
					}
				}while(i == 1);
			
				if(option2.equalsIgnoreCase("veg")) {
					@SuppressWarnings("unused")
					String aString = enter.nextLine();
					vshop.listItem();
					System.out.print ("\nEnter Vegetable to Buy:");
					to_buy = enter.next ();
					do {
						i = 0;
						System.out.print ("Enter Quantity (in Kg):");
						qty = enter.nextInt();
						if(qty < 0) {
							System.out.print("Amount entered is invalid enter a positive number\n");
							i++;
						}
					}while(i == 1);
					
					try {
						shopper.buyItem (vshop, to_buy, qty);
					}catch(NoMoneyException e) {
						System.out.print(e.getClass().getName() + "\n");
						System.out.print(e.getMessage() + "\n");
					}
				}
				
				else if(option2.equalsIgnoreCase("fruit")) {
					@SuppressWarnings("unused")
					String aString = enter.nextLine();
					fshop.listItem();
					System.out.print ("\nEnter Fruit to Buy:");
					to_buy = enter.next ();
					do {
						i = 0;
						System.out.print ("Enter Quantity (in Kg):");
						qty = enter.nextInt();
						if(qty < 0) {
							System.out.print("Amount entered is invalid enter a positive number\n");
							i++;
						}
					}while(i == 1);
					
					try {
						shopper.buyItem (fshop, to_buy, qty);
					}catch(NoMoneyException e) {
						System.out.print(e.getClass().getName() + "\n");
						System.out.print(e.getMessage() + "\n");
					}
				}
				
				else {
					@SuppressWarnings("unused")
					String aString = enter.nextLine();
					bshop.listItem();
					System.out.print ("\nEnter Book to Buy:");
					to_buy = enter.nextLine();
					do {
						i = 0;
						System.out.print ("Enter Quantity (number of copies):");
						qty = enter.nextInt();
						if(qty < 0) {
							System.out.print("Amount entered is invalid enter a positive number\n");
							i++;
						}
					}while(i == 1);
					
					try {
						shopper.buyItem (bshop, to_buy, qty);
					}catch(NoMoneyException e) {
						System.out.print(e.getClass().getName() + "\n");
						System.out.print(e.getMessage() + "\n");
					}
				}
				
				System.out.println("Cash in Wallet:" + shopper.getMoney());
			}
			
			else if(option1.equalsIgnoreCase("Add")) {
				cont = true;
				System.out.print ("\nEnter amount to add to wallet:");
				addAmount = enter.nextInt();
				shopper.addMoney(addAmount);
				System.out.println("Cash in Wallet:" + shopper.getMoney());
			}
			
			else {
				cont = false;
			}
		}
		enter.close();
	}*/

	
}
