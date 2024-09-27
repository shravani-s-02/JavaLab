package Q8_ThreeFromFive;

public class MoreThan5CharactersException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String getMessage() {
		return "There are more than five characters in the word entered";
	}
}
