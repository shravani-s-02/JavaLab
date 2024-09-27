import java.util.Scanner;

public class Q_5_ProductLessThanDivision {

	public static void main(String[] args) {
		
		Double[] number = new Double[5];
		Scanner enter = new Scanner(System.in);
		//User is prompted to enter four numbers.
		for(int i = 0; i < 4; i++) {
			System.out.print("Enter a number ("+ (i+1) +" of 4):");
			number[i] = enter.nextDouble();
		}
		enter.close();
		
		//The arithmetic operations multiplication and division are performed.
		double product, quotient;
		product = number[0] * number[1];
		quotient = number[2] / number[3];
		
		//The value obtained from the multiplication and division are compared and the output is printed accordingly. 
		if ( product < quotient ) {
			System.out.print("The product of "+ number[0] +" and "+ number[1] +" is less than the division of "+ number[2] +" and "+ number[3]);
		}
		else {
			System.out.print("The product of "+ number[0] +" and "+ number[1] +" is not less than the division of "+ number[2] +" and "+ number[3]);
		}
	}

}
