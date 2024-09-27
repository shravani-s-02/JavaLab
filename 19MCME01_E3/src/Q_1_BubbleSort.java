import java.util.Scanner;

public class Q_1_BubbleSort {
	
	public static void descendingSort(double[] array, int array_size) {
		int i = 0;
		double temp = 0;
		
		//If the array size is one it means there are no other numbers to be compared to, so the process is ended.
		if(array_size == 1) {
			return ;
		}
		
		//The numbers of the array are iterated through and compared with each other and the smallest number is shifted to the to the end of the array.  
		for(i = 0; i < array_size-1; i++) {
			if(array[i+1] > array[i]) {
				temp = array[i];
				array[i] = array[i+1];
				array[i+1] = temp;
			}
		}
		
		//The smallest number from the array is found, therefore the size of the array must be reduced to compare the remaining elements to find the next smallest number
		descendingSort( array, array_size - 1);
	}
	
	public static void ascendingSort(double[] array, int array_size) {
		int i = 0;
		double temp = 0;
		
		//If the array size is one it means there are no other numbers to be compared to, so the process is ended.
		if(array_size == 1) {
			return ;
		}
		
		//The numbers of the array are iterated through and compared with each other and the largest number is shifted to the to the end of the array.  
		for(i = 0; i < array_size-1; i++) {
			if(array[i] > array[i+1]) {
				temp = array[i];
				array[i] = array[i+1];
				array[i+1] = temp;
			}
		}
		
		//The largest number from the array is found, therefore the size of the array must be reduced to compare the remaining elements to find the next largest number
		ascendingSort( array, array_size - 1);
	}
	
	public static void main(String[] args) {
		Scanner enter = new Scanner(System.in);
		System.out.print("Enter the number of elements to be entered into the array:");
		int array_size = enter.nextInt();
		double[] array = new double[array_size];
		for(int i = 0; i < array_size; i++) {
			System.out.print("Enter element " + (i+1) + " of " + array_size + ":");
			array[i] = enter.nextDouble();
		}
		enter.close();
		
		
		
		System.out.print("\n-----------------------------\n");
		
		//Sort function is called
		descendingSort(array, array_size);
		System.out.print("\nThe array sorted in descending order is,\n\t");
		//The array is iterated through and the descending sorted array is printed
		for(int i = 0; i < array_size; i++) {
			System.out.print(array[i] + ", ");
		}
		
		//Sort function is called
		ascendingSort(array, array_size);
		System.out.print("\n\nThe array sorted in ascending order is,\n\t");
		//The array is iterated through and the ascending sorted array is printed
		for(int i = 0; i < array_size; i++) {
			System.out.print(array[i] + ", ");
		}
		
	}

}
