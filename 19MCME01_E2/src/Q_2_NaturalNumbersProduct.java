import java.util.Scanner;

public class Q_2_NaturalNumbersProduct {
	
	static Scanner enter = new Scanner(System.in);

	public static long Enter() {
		long number = 1;
		int i = 0;
        
        do {
			i = 0;
			////User is prompted to enter the first n number of natural numbers to find the product of
			System.out.print("Enter the number of (first) natural numbers to find the product of:");
	        number = enter.nextLong();
	      //If the input is less than 1 a error message is displayed 
			if(number < 1) {
				System.out.print("Option entered is invalid, respond with a positive integer.\n\n");
				i++;
			}
		}while(i == 1);
        
        return number;
	}
	
	public static void main(String[] args) {
		
		Scanner enter = new Scanner(System.in);
		
		
        long n = Enter();
        enter.close();
        
        double product = 1, i;
        //The first n number of natural numbers are iterated through and multiplied by each other one by one
        for( i = 1; i < n+1; i++ ) {
        	 product *= i; 	
        }
        
        System.out.print("Product of first " + n +" natural numbers is " + product);
	}
}
