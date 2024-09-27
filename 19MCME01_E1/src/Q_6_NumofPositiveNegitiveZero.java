import java.util.Scanner;

public class Q_6_NumofPositiveNegitiveZero {
		
	public static void main(String[] args) {
		
		Double [] number = new Double[10];
		//User is prompted to enter ten numbers.
		Scanner enter = new Scanner(System.in);
		for(int i = 0; i < 10; i++) {
			System.out.print("Enter number ("+ (i+1) +" of 10):");
			number[i] = enter.nextDouble();
		}
		enter.close();
		
		//The array is iterated through and the numbers are compared to zero. 
		//Then depending on whether it's equal to, less than or greater than the zero the corresponding variable is incremented by one.
		int  positive = 0, negitive = 0, zero = 0;
		for(int i = 0; i < 10; i++) {
			if(number[i] > 0) positive++;
			else if(number[i] < 0) negitive++;
			else zero++;
		}
		
		System.out.print("\nNumber of positive numbers:" + positive + "\nNumber of negtive numbers:" + negitive + "\nNumber of zeros:" + zero );

	}

}
