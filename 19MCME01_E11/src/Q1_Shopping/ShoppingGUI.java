package Q1_Shopping;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import BuyerAndShopExceptions.NoMoneyException;
import Shops.BookShop;
import Shops.FruitShop;
import Shops.Shop;
import Shops.VegetableShop;

public class ShoppingGUI extends Application {
	public static String errorMessage = " ";
	ComboBox<String> selectItemList = new ComboBox<String>();
	double amountPaid = 0;
	int itemQuantity = 0;
	String itemName, shopName;
	Shop currentShop;
	public static ArrayList<String> transactionList = new ArrayList<String>();
	
	public void start(Stage stage) throws Exception {
		//Initialize the shops and the buyer
		Buyer shopper = new Buyer(0);
		final VegetableShop vshop =  new VegetableShop();
		final FruitShop fshop = new FruitShop();
		final BookShop bshop = new BookShop();
		
		//Initialize the observable lists for the shops
		ObservableList<String> vegItemList = FXCollections.observableArrayList(), fruitItemList = FXCollections.observableArrayList(), bookItemList = FXCollections.observableArrayList();
		for(int i = 0; i < 9; i++) {
			vegItemList.add(vshop.listItem(i));
			fruitItemList.add(fshop.listItem(i));
			bookItemList.add(bshop.listItem(i));
		}
		
		//Initialize the menu items
		Menu shopMenu = new Menu("Shops");
		MenuItem vegShop = new MenuItem("Vegetable Shop");
		MenuItem fruitShop = new MenuItem("Fruit Shop");
		MenuItem bookShop = new MenuItem("Book Shop");

		//Initialize labels
		Label enterMoneyLabel = new Label("Enter money to add your wallet:"), enterQuantityLabel = new Label("Enter Quantity (in Kg):");
		Label displayMoney = new Label(), displayAmountPaid = new Label();
		Label enterItemLabel = new Label("Choose Vegetable To purchase:");
		
		//Initialize text field and button
		TextField enterMoney = new TextField(" "), enterQuantity = new TextField(" ");
		Button moneySubmit = new Button("Add money"), buy = new Button("Buy"),  transactionListButton= new Button("View Transaction History");
		
		//For image icon
		FileInputStream inputstream = new FileInputStream("src/ShoppingCart.jpg"); 
		Image applicationIcon = new Image(inputstream); 
		
		//Setting
		enterMoneyLabel.setStyle("font-weight: bolder;");
		currentShop = vshop;
		selectItemList.setItems(vegItemList);
		displayMoney.setText("Current amount in wallet:" + Double.toString(shopper.getMoney()));
		
		//Adding menu items to menu
		shopMenu.getItems().add(vegShop);
		shopMenu.getItems().add(fruitShop);
		shopMenu.getItems().add(bookShop);
		
		//Actions added to text field and button related to ading money
		enterMoney.setOnMouseClicked(e ->{
			enterMoney.setText("");
  		    enterMoney.setStyle("-fx-text-inner-color: black;");
		});
		moneySubmit.setOnAction(new EventHandler<ActionEvent>() {  
		      public void handle(ActionEvent event) {
		    	  if(enterMoney.getText().matches("[0-9]+(\\.[0-9][0-9]?)?")){
		    		  double amount = Double.valueOf(enterMoney.getText());
		    		  shopper.addMoney(amount);
		    		  displayMoney.setText("Current amount in wallet:" + Double.toString(shopper.getMoney()));
		    	  }
		    	  //If valid input is not entered error message is displayed 
		    	  else {
		    		  enterMoney.setText("Invalid input.");
		    		  enterMoney.setStyle("-fx-text-inner-color: red;");
		    	  }
	
		      }  
		});  
		
		//Actions added to enter quantity related text field 
		enterQuantity.setOnMouseClicked(e ->{
			enterQuantity.setText("");
			enterQuantity.setStyle("-fx-text-inner-color: black;");
		});
		enterQuantity.setOnMouseExited(e ->{
			//If positive integer number is not entered error message is displayed 
			if(!enterQuantity.getText().matches("^[0-9]*$")) {
				enterQuantity.setText("Invalid input.");
				enterQuantity.setStyle("-fx-text-inner-color: red;");
			}
		});
		
		//The buy button event common for all shops
		EventHandler<ActionEvent> BuyEvent = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent buyEvent) {
				displayAmountPaid.setText(" ");
				errorMessage = " ";
				
				//Quantity input is valid and an item is selected
				if(enterQuantity.getText().matches("^[0-9]*$") && selectItemList.getValue() != null) {
					itemName = selectItemList.getValue().substring(0, selectItemList.getValue().indexOf(','));
					itemQuantity = Integer.valueOf(enterQuantity.getText());
				
					try {
						shopper.buyItem(currentShop, itemName, Integer.valueOf(enterQuantity.getText()));
						displayAmountPaid.setText(errorMessage);
					} catch (NoMoneyException e) {
						System.out.print(e.getClass().getName() + "\n");
						displayAmountPaid.setText(e.getMessage());
						return;
					}
					
					//If there is no error then then amount paid is visible and the amount in the buyers wallet is updated
					if(displayAmountPaid.getText() == " ") {
						shopName = currentShop.getClass().toString();
						amountPaid = currentShop.getPrice(itemName) * itemQuantity;
						displayAmountPaid.setText("Amount paid:" + amountPaid);
						displayMoney.setText("Current amount in wallet:" + shopper.getMoney());
						transactionList.add(shopName.substring(shopName.indexOf('.') + 1, shopName.length()) + " :- Item : " + itemName + "; Quantity : " + itemQuantity + "; Amount Paid : " + amountPaid);
					}
				}
				//If quantity input is invalid and item is not selected then error message is displayed
				else{
					displayAmountPaid.setText("");
					displayAmountPaid.setText("Error. Select item to purchase and/or enter valid quantity input.");
					displayAmountPaid.setStyle("-fx-text-inner-color: red;");
				}
			}
		};
		
		//Shop, labels and item list change accordingly
		EventHandler<ActionEvent> vegShopEvent = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				displayAmountPaid.setText(" ");
				currentShop = vshop;
				selectItemList.setItems(vegItemList);
				enterItemLabel.setText("Choose Vegetable To Purchase:");
				enterQuantityLabel.setText("Enter Quantity (in Kg):");
				buy.setOnAction(BuyEvent);
			}
		};
		EventHandler<ActionEvent> fruitShopEvent = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				displayAmountPaid.setText(" ");
				currentShop = fshop;
				selectItemList.setItems(fruitItemList);
				enterItemLabel.setText("Choose Fruit To Purchase:");
				enterQuantityLabel.setText("Enter Quantity (in Kg):");
				buy.setOnAction(BuyEvent);
			}
		};
		EventHandler<ActionEvent> bookShopEvent = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				displayAmountPaid.setText(" ");
				currentShop = bshop;
				selectItemList.setItems(bookItemList);
				enterItemLabel.setText("Choose Book To Purchase:");
				enterQuantityLabel.setText("Enter Quantity (in Number of Copies):");
				buy.setOnAction(BuyEvent);
			}
		};
		
		//Set the events to the transaction history button the menu buttons
		transactionListButton.setOnAction(e-> {
			try {
				transactionPopUp.displayTransactionPopUp();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		});  
		buy.setOnAction(BuyEvent);
		vegShop.setOnAction(vegShopEvent);
		fruitShop.setOnAction(fruitShopEvent);
		bookShop.setOnAction(bookShopEvent);

		//Adding the menus to a menu bar
		MenuBar mb = new MenuBar();
		mb.getMenus().add(shopMenu);
		
		//Initializing the grid pane, VBox's and HBox's
		GridPane root = new GridPane();
		VBox menueBar = new VBox(mb), itemToBuyDetailsBox = new VBox(10), addMoneyBox = new VBox(10);
		HBox moneyBox = new HBox(10), itemLabelBox = new HBox(10), quantityLabelBox = new HBox(10), buttonBox = new HBox(10);
		
		//Adding the children to their required HBox
		moneyBox.getChildren().add(enterMoneyLabel);
		moneyBox.getChildren().add(enterMoney);
		moneyBox.getChildren().add(moneySubmit);
		itemLabelBox.getChildren().add(enterItemLabel);
		itemLabelBox.getChildren().add(selectItemList);
		quantityLabelBox.getChildren().add(enterQuantityLabel);
		quantityLabelBox.getChildren().add(enterQuantity);
		buttonBox.getChildren().add(buy);
		buttonBox.getChildren().add(transactionListButton);
		
		//Adding the children to their required VBox
		addMoneyBox.getChildren().add(moneyBox);
		addMoneyBox.getChildren().add(displayMoney);
		itemToBuyDetailsBox.getChildren().add(itemLabelBox);
		itemToBuyDetailsBox.getChildren().add(quantityLabelBox);
		itemToBuyDetailsBox.getChildren().add(buttonBox);
		
		//Adding HBox's and VBox's to the grid pane
		root.add(menueBar, 0, 0, 2, 1);
		root.add(addMoneyBox, 0, 1);
		root.add(itemToBuyDetailsBox, 1, 2);
		root.add(displayAmountPaid, 1, 3);
		
		//Setting vertical and horizontal gap between the grid panes objects
		root.setHgap(30);
		root.setVgap(30);
		
		//Initializing the scene, adding the grid pane to it and specifying it's style sheet
		Scene sc = new Scene(root, 1200, 500);
		sc.getStylesheets().add("application.css");
		
		//Setting the stage title, icon and scene
		stage.setTitle("Shopping");
		stage.getIcons().add(applicationIcon);
		stage.setScene(sc);
		stage.show();
	}
	
	public static void main(String args[]) {
		ShoppingGUI.launch(args);
	}
}