package Q2_VegetableShopping;

public class NoItemException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String getMessage() {
		return "Vegetable entered is not sold";
	}

}
