package Q1_Shopping;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Date;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class transactionPopUp{

	public static void displayTransactionPopUp() throws FileNotFoundException{
		//Initializing the stage, labels and current date & time
		Label TransactionDisplay = new Label(""), dateAndTimeLabel = new Label("");
		Stage popUpWindow = new Stage();
		Date date = java.util.Calendar.getInstance().getTime();
		
		int i = 0;
		String transactionItems = "";
		
		FileInputStream inputstream = new FileInputStream("src/receipts.jpg"); 
		Image applicationIcon = new Image(inputstream); 
		
		//The contents of items bought 
		for(i = 0; i < ShoppingGUI.transactionList.size(); i++) {
			if(i == 0) {
				transactionItems = "";
			}
			transactionItems = transactionItems + ShoppingGUI.transactionList.get(i) + "\n";
		}
		
		if(i == 0) {
			transactionItems = "No transactions have occured.";
		}
		
		//Setting the labels text
		dateAndTimeLabel.setText("As of " + date.toLocaleString().toString());
		TransactionDisplay.setText(transactionItems);
		
		//Initializing the VBox and adding the labels to it
		VBox layout = new VBox();
		layout.getChildren().add(dateAndTimeLabel);
		layout.getChildren().add(TransactionDisplay);
		
		//Initializing the scene, adding the VBox to it and setting the style sheet
		Scene sc = new Scene(layout, 700, 600);
		sc.getStylesheets().add("application.css");
		
		//Setting the stage title, icon and scene
		popUpWindow.setTitle("Transaction History");
		popUpWindow.getIcons().add(applicationIcon);
		popUpWindow.setScene(sc);
		popUpWindow.show();
	}
}