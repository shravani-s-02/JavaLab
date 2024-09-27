import java.util.Scanner;

public class Q_3_MinMax {

	public static void main(String[] args) {
		
		Scanner enter = new Scanner(System.in);
		
		//User is prompted to enter five numbers
		Double[] number = new Double[5];
		for(int i = 0; i < 5; i++) {
			System.out.print("Enter a number ("+ (i+1) +" of 5):");
			number[i] = enter.nextDouble();
		}
		enter.close();
		
		//max and min are initialized to the first number entered since initializing it to 0 could interfere with the output.
		double max = number[0], min = number[0];
		
		//The array is iterated through and the numbers are compared to the max/min. 
		//If the number is bigger than the number stored in max the the value in max is replaced by the number it's being compared to. 
		for(int i = 0; i < 5; i++) {
			if(number[i] > max) {
				max = number[i];
			}
		}
		//If the the number is smaller than the number stored in min the the value in min is replaced by the number it's being compared to. 
		for(int i = 0; i < 5; i++) {
			if(number[i] < min) {
				min = number[i];
			}
		}
		
		System.out.print("The maximum number is " + max + " and the minimum number is " + min);

	}

}

