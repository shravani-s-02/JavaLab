package Q1_Exception;

public class lessThanZeroException extends Exception{
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage(){
		return "Number is less than zero";
	}
}
