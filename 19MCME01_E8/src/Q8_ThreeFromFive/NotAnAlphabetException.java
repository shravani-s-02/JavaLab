package Q8_ThreeFromFive;

public class NotAnAlphabetException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String getMessage() {
		return "There are characters in the string that are not alphbets";
	}
}
