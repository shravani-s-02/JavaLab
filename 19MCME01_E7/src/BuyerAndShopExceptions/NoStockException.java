package BuyerAndShopExceptions;

public class NoStockException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String getMessage() {
		return "Item stock is insufficient";
	}

}
