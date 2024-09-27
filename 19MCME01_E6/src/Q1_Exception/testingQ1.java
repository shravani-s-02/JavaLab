package Q1_Exception;

public class testingQ1 {
	
	public void throwExceptions(int num) throws lessThanZeroException, greaterThan1000Exception, numIs13Exception {
		if(num < 0) {
			throw new lessThanZeroException();
		}
		else if(num > 1000) {
			throw new greaterThan1000Exception();
		}
		else if(num == 13) {
			throw new numIs13Exception();
		}
		System.out.print("\nNo exceptions");
	}
	
	public static void main(String[] args) {
		int array[] = {-1, 15000, 13, 150};
		testingQ1 TQ1 = new testingQ1();
		
		
		
		for(int i = 0; i < 4; i++) {
			System.out.print("\n\nNumber:" + array[i]);
			try {
				TQ1.throwExceptions(array[i]);
			} catch (lessThanZeroException | greaterThan1000Exception | numIs13Exception e) {
				System.out.print("\nException occurring: "+ e.getClass().getName());
				System.out.print("\nException message: "+ e.getMessage());
			}
		}
	}

}
