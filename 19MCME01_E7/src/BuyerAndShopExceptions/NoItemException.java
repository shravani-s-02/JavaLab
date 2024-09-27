package BuyerAndShopExceptions;

public class NoItemException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String getMessage() {
		return "Item entered is not sold";
	}

}
