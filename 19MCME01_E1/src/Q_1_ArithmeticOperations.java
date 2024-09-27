import java.util.Scanner;

public class Q_1_ArithmeticOperations {

	public static void main(String[] args) {
		
		Scanner num = new Scanner(System.in);
		
		//User prompted to enter the two numbers
		System.out.print("Enter the first number:");
        double number1 = num.nextDouble();
        System.out.print("Enter the second number:");
        double number2 = num.nextDouble();
        num.close();

        double sum, product, difference, quotient;
        //The arithmetic operations addition, multiplication, subtraction and division are performed.
        sum = number1 + number2;
        product = number1 * number2;
        difference = number1 - number2;
        quotient =  number1 / number2;
        System.out.print("\nSum = " + sum +"\nProduct = " + product +"\nDifference = " + difference + "\nQuotient = " + quotient);        
	}
}
