import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Q_2_SetOperations {
	static Scanner enter = new Scanner(System.in);
	
	//A intersection of set 1 and set 2 is elements found in both set 1 and set2
	public static Set<Float> Intersection(Set<Float> set1, Set<Float> set2) {
		Set<Float> intersectionSet = new HashSet<Float>();
		
		//Iterates through set 1
		for(Float set1Compare : set1) {
			//Iterates through set 2
			for(Float set2Compare : set2) {
				//If a element in set 1 to a element in set2 it is added to the intersection set
				if(set1Compare.equals(set2Compare)) {
					intersectionSet.add(set1Compare);
					break;
				}
			}
		}
		
		return intersectionSet;
	}
	
	//A union of set 1 and set 2 is all elements found in set 1 and set2
	public static Set<Float> Union(Set<Float> set1, Set<Float> set2){
		Set<Float>unionSet = new HashSet<Float>();
		Boolean found = false;
		
		//Iterates through set 1
		for(Float set1Compare : set1) {
			//Iterates through set 2
			for(Float set2Compare : set2) {
				//If a element in set 1 to a element in set2 found is set to true
				if(set1Compare.equals(set2Compare)) {
					found = true;
					break;
				}
			}
			
			//If element in set 1 is not found in set 2 it is added to the union set
			if(found == false) {
				unionSet.add(set1Compare);
			}
			
			found = false;
		}
		
		//All elements in set 2 are added to the union set
		for(Float set2Compare : set2) {
			unionSet.add(set2Compare);
		}
		
		return unionSet;
	}

	//A difference between set 1 and set 2 is elements of set 1 that are not found in set 2 
	public static Set<Float> Difference(Set<Float> set1, Set<Float> set2){
		Set<Float> differenceSet = new HashSet<Float>();
		Boolean found = false;
		
		//Iterates through set 1
		for(Float set1Compare : set1) {
			//Iterates through set 2
			for(Float set2Compare : set2) {
				//If a element in set 1 to a element in set2 found is set to true
				if(set1Compare.equals(set2Compare)) {
					found = true;
					break;
				}
			}
			
			//If element in set 1 is not found in set 2 it is added to the difference set
			if(found == false) {
				differenceSet.add(set1Compare);
			}
			found = false;
		}
		
		return differenceSet;
	}
	 
	public static void main(String[] args) {
		int option = 0, numElements = 0;
		float addToSet = 0;
		Set<Float> set1 = new HashSet<Float>(), set2 = new HashSet<Float>(), returnedSet = null;
		
		//Entering elements in set 1
		System.out.print("Enter the number of elements in set 1:");
		numElements = enter.nextInt();
		if(numElements != 0) {
			System.out.print("Enter elements of set 1:-\n");
			for(int i = 0; i < numElements; i++) {
				System.out.print("Element " + (i + 1) + " of " + numElements + ":");
				addToSet = enter.nextFloat();
				set1.add(addToSet);
			}
		}
		
		//Entering elements in set 2
		System.out.print("\nEnter the number of elements in set 2:");
		numElements = enter.nextInt();
		if(numElements != 0) {
			System.out.print("Enter elements of set 2:-\n");
			for(int i = 0; i < numElements; i++) {
				System.out.print("Element " + (i + 1) + " of " + numElements + ":");
				addToSet = enter.nextFloat();
				set2.add(addToSet);
			}
		}
		
		while(option != 4 ) {
			System.out.print("\nDo you wish to\nDisplay intersection of the sets(enter 1)\nDisplay union of sets(enter 2)\nDisplay difference of the sets(set 1 - set 2)(enter 3)\nExit(enter 4)\nEnter:");
			option = enter.nextInt();
			
			if(option == 1) {
				returnedSet = Intersection(set1, set2);
				
				System.out.print("Intersection set:");
				for(Float returnedElement : returnedSet) {
					System.out.print(returnedElement + ",");
				}
				System.out.print("\n");
			}
			else if(option == 2) {
				returnedSet = Union(set1, set2);
				
				System.out.print("Union set:");
				for(Float returnedElement : returnedSet) {
					System.out.print(returnedElement + ",");
				}
				System.out.print("\n");
			}
			else if(option == 3) {
				returnedSet = Difference(set1, set2);

				System.out.print("Difference set:");
				for(Float returnedElement : returnedSet) {
					System.out.print(returnedElement + ",");
				}
				System.out.print("\n");
			}
			else if(option == 4) {
				break;
			}
			else {
				System.out.print("Option nor valid, enter 1, 2, 3 or 4\n");
			}
		}
	}

}