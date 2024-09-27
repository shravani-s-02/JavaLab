import java.util.Scanner;

public class Q_7_Pin {

	public static void Verify(int pin) {
		int pin_entered = 0, count=0, temp=1;
		
		//User prompted to enter a four digit number
		System.out.print("Enter a four digit pin number:");
		Scanner enter = new Scanner(System.in);
		pin_entered = enter.nextInt();
		
		//The number of digits in the pin number are counted by counting the number of times the "temp" variable is multiplied by 10 until it's greater than the entered pin number. 
		while (temp <= pin_entered) {
		    count++;
		    temp*=10;
		}
		
		//If the count is equal to four then it can be decided whether the pin is correct or not.
		if(count == 4 && pin_entered > 0) {
			if(pin_entered == pin) System.out.print("Sucess");
			else System.out.print("Failure");
		}
		
		//If the count is less than or greater than four, negative number is entered, or any other invalid input is entered an appropriate error message is displayed and the user is prompted to renter the pin.
		else {
			if( pin_entered < 0 )  {
				System.out.print("Number entered is negetive\n");
				Verify(pin);
			}
			else if( count < 4 ) {
				System.out.print("Number entered contains less than four digits\n");
				Verify(pin);
			}
			else if( count > 4 ) {
				System.out.print("Number entered contains more than four digits\n");
				Verify(pin);
			}
			else {
				System.out.print("Number entered is invalid\n");
				Verify(pin);
			}
		}
		enter.close();
	}
	
	public static void main(String[] args) {
		int pin=5394;
		Verify(pin);
		
	}
}
