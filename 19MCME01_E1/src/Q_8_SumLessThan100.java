import java.util.Scanner;

public class Q_8_SumLessThan100 {
	
	static Scanner enter;
	
	public static double Enter(int a) {
		//User is prompted to enter five numbers less than hundred
		System.out.print("Enter a number which is less than hundered(" + (a+1) + " of 5):");
		double number = enter.nextDouble();
		//If a number entered greater than 100 an error message is printed an the user is prompted to renter the number.  
		if(number > 99) {
			System.out.print("Number entered is greater than or equal to hundered\n\n");
			return Enter(a);
		}
		else{
			return number;
		}
	}
	
	public static void main(String[] args) {
		enter = new Scanner(System.in);
		
		Double[] number = new Double[5];
		double sum = 0;
		int i;
		
		for(i=0; i<5; i++) {
			  
			number[i] = Enter(i);
			sum += number[i];
			
			//Only if the sum is hundred or greater, or five numbers(less than hundred) have been entered the numbers entered, the numbers and the sum of the numbers are are displayed. \ 
			if(sum > 99 || i==4) {
				System.out.print("\nNumbers entered:");
				for(int j=0; j < i+1; j++) {
					System.out.print(number[j] + ", ");
				}
				System.out.print("\nSum of numbers entered:" + sum);
				System.exit(0);
			}
		}
		enter.close();
	}
}
