package Q2_VegetableShopping;

public class NoStockException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String getMessage() {
		return "Vegetable stock is insufficient";
	}

}
