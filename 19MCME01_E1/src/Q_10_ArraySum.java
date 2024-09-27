import java.util.Scanner;

public class Q_10_ArraySum {

	public static void main(String[] args) {
		
		Scanner enter = new Scanner(System.in);
		
		//User is prompted to enter the number of numbers in the first array and the numbers in said array
		System.out.print("Enter number of elements in array one:");
		int size1 = enter.nextInt();
		Double[] array1 = new Double[size1];
		for(int i=0; i<size1; i++) {
			System.out.print("Enter element "+ (i+1) +" of " + size1 + " in array one:");
			array1[i] = enter.nextDouble();
		}
		
		//User is prompted to enter the number of numbers in the second array and the numbers in said array
		System.out.print("Enter number of elements in array two:");
		int size2 = enter.nextInt();
		Double[] array2 = new Double[size2];
		for(int i = 0; i < size2; i++) {
			System.out.print("Enter element "+ (i+1) + " of " + size2 + " in array two:");
			array2[i] = enter.nextDouble();
		}
		enter.close();
		
		//The size of the array containing the sum of the two array's is taken as the size of the array with the most elements.
		//This so that there're no out of bound elements.
		int size;
		if(size1 > size2) {
			size = size1;
		}
		else{
			size = size2;
		}
		
		Double[] array_sum = new Double[size];
		System.out.print("\nArray of sum of array one and array two:{");
		//The elements of the two arrays are added.
		//If array1 has a greater number of elements than array2, the elements of array1 that are not added to an element in array2 are concatenated to the end of the array containing the sum of the two array's.
		//If array2 has a greater number of elements than array1, the elements of array2 that are not added to an element in array1 are concatenated to the end of the array containing the sum of the two array's.
		for(int i=0; i < size; i++) {
			if( i >= size2 ) array_sum[i] = array1[i];
			else if( i >= size1 ) array_sum[i] = array2[i];
			else array_sum[i] = array1[i] + array2[i];
			System.out.print(array_sum[i] + ", ");
		}
		System.out.print("}");
	}

}
