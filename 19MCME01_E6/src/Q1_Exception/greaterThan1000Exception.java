package Q1_Exception;

public class greaterThan1000Exception extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String getMessage(){
		return "Number is greater than thousand";
	}
}
