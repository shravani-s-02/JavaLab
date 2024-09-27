import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Q_5_DescendingOrder {
	static Scanner enter = new Scanner(System.in);
	
	public static void main(String[] args) {
		int numElements = 0;
		float addToArray = 0;
		ArrayList<Float> array = new ArrayList<Float>();
		
		//User inputs numbers
		System.out.print("Enter number of elements to sort:");
		numElements = enter.nextInt();
		for(int i = 0; i < numElements; i++ ) {
			System.out.print("Enter number " + (i + 1) + " of " + numElements + ":");
			addToArray = enter.nextFloat();
			array.add(addToArray);
		}
		
		//Sorting the accounts in the list with the comparator Collections.reverseOrder() which sorts the list in descending order
		Collections.sort(array, Collections.reverseOrder());
		
		System.out.print("\nNumbers sorted in descending order:\n");
		for(Float printNum : array){
			System.out.print(printNum + "\n");
		}
	}

}