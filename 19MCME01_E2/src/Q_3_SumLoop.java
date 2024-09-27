import java.util.Scanner;

public class Q_3_SumLoop {

	static Scanner enter = new Scanner(System.in);
	
	public static String Continue() {
		String string = "a";
		int i = 0;
		
		do {
			//If the input is less than 1 a error message is displayed and the user is prompted to re enter
			if(i > 0) {
				System.out.print("\nOption entered is invalid, respond with either yes or no.");
			}
			System.out.print("\nDo you wish to perform the operation again?(yes/no):");
			string = enter.next();
			i++;
		}while(!(string.equalsIgnoreCase("yes") || string.equalsIgnoreCase("no")));
		
		return string;
	}
	
	public static void main(String[] args) {
		String cont = "a";
		do{
			//User is prompted to enter the two numbers to be added
			System.out.print("Enter two numbers to find the sum of.");
			System.out.print("\nEnter the first number:");
	        double number1 = enter.nextDouble();
	        System.out.print("Enter the second number:");
	        double number2 = enter.nextDouble();
	       
	        System.out.print("\n-------------------------\nSum of " + number1 +" and " + number2 + " is " + (number1 + number2) + "\n-------------------------\n");
	        
	        cont = Continue();
	        //The do-while loop only goes on if the user's input is yes
		}while( cont.equalsIgnoreCase("yes") );
		
	}

}