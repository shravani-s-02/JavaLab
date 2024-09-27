import java.util.Scanner;

public class Q_9_Array {

	public static void main(String[] args) {
		//Let the given array be {1,13,24,6}
		double [] num = new double[10], array = {1,13,24,6};
		//User is prompted to enter ten numbers
		Scanner enter = new Scanner(System.in);
		for(int i = 0; i < 10; i++) {
			System.out.print("Enter a number ("+ (i+1) +" of 10):");
			num[i] = enter.nextDouble();
		}
		enter.close();
		
		//The array size is taken as the sum of the length of the given array and number of the entered numbers(10) to fit all the elements. 
		double array_new[] = new double[array.length + 10];
		
		//If the position of the number to be to put into the concatenated(third) array is:
		//1) less than the number of elements in the given array then the elements from the given array are inputed into third array.
		//2) greater than the number of elements in the given array then the 10 numbers entered are inputed into the array.  
		for( int i=0; i < array.length + 10; i++) {
			if( i < array.length ) array_new[i] = array[i];
			else array_new[i] = num[i-array.length];
		}
		
		//The addition operation is performed on the fourth element and sixth element of the concatenated array.
		double sum = array_new[3] + array_new[5];
		
		System.out.print("\nSecond element of the array:" + array_new[1] + "\nEigth element of the array:"+ array_new[7]  + "\nSum of fourth and sixith elements of the array:" + sum);
	}

}
