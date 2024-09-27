package Q8_ThreeFromFive;

public class LessThan5CharactersException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String getMessage() {
		return "There are less than five characters in the word entered";
	}
}
