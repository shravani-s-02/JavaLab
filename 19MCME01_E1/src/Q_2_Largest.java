import java.util.Scanner;

public class Q_2_Largest {

	public static void main(String[] args) {
		
		Scanner num = new Scanner(System.in);
		
		//User prompted to enter two numbers
		System.out.print("Enter the first number:");
		double number1 = num.nextDouble();
		System.out.print("Enter the second number:");
		double number2 = num.nextDouble();
		num.close();
				
		//The two numbers are compared and the output is printed accordingly. 
		if( number1 > number2 ) {
			System.out.println(number1 + " is greater than " + number2);
		}
		else if( number1 < number2 ) {
			System.out.println(number2 + " is greater than " + number1);
		}
		else {
			System.out.println(number1 + " is equal to " + number2);
		}

	}

}
