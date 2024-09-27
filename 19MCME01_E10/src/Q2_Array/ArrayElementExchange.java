package Q2_Array;

public class ArrayElementExchange {

	public static <T> void genericExchangeElements(T[] array, int firstElementIndex, int secondElementIndex) {
		T temp = array[firstElementIndex];
		
		array[firstElementIndex] = array[secondElementIndex];
		array[secondElementIndex] = temp;
	}
	
	public static <T> void DisplayElements(T[] array) {
		System.out.print("\n");
		for(int i = 0; i < 4; i++) {
			System.out.println(array[i]);
		}
	}
	
	public static void main (String args[]) {
		Integer[] intArray = {1, 4, 3, 2};
		Double[] floatArray = {1.2, 1.4, 1.3, 1.5};
		String[] stringArray = {"sentance", "is", "a", "This"};
		
		System.out.print("Testing for Integer array:\n");
		System.out.print("Before exchanging:");
		DisplayElements(intArray);
		genericExchangeElements(intArray, 1, 3);
		System.out.print("After exchanging:");
		DisplayElements(intArray);
		System.out.print("\n");
		
		System.out.print("Testing for Double array:\n");
		System.out.print("Before exchanging:");
		DisplayElements(floatArray);
		genericExchangeElements(floatArray, 1, 2);
		System.out.print("After exchanging:");
		DisplayElements(floatArray);
		System.out.print("\n");
		
		System.out.print("Testing for String array:\n");
		System.out.print("Before exchanging:");
		DisplayElements(stringArray);
		System.out.print("After exchanging:");
		genericExchangeElements(stringArray, 0, 3);
		DisplayElements(stringArray);
	}
}
