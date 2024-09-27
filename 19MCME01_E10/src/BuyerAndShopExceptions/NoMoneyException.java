package BuyerAndShopExceptions;

public class NoMoneyException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String getMessage() {
		return "Insufficent money to purchase";
	}
}
