import java.util.Scanner;

public class Q_4_Table {

	public static void main(String[] args){
		
		Double[] number = new Double[10];
		Scanner enter = new Scanner(System.in);
		//User is prompted to enter ten numbers.
		for(int i = 0; i < 10; i++) {
			System.out.print("Enter a number to find square and cube of ("+ (i+1) +" of 10):");
			number[i] = enter.nextDouble();
		}
		enter.close();
		
		System.out.print("\nNumber\t\tSquare\t\tCube\n");
		
		//The array are iterated through, the number is printed and it's square and cube are calculated and printed.
		for(int i = 0; i < 10; i++) {
				System.out.print(number[i]+"\t\t"+ (number[i] * number[i]) +"\t\t"+ (number[i] * number[i] * number[i]) +"\n");
		}
	}
}


