package mathClass;

public class Math_19MCME01 {
	public static final double pi = 3.141592653589793238;
	 
	public static double max(double number1, double number2){
		if( number1 < number2 ) {
			return number2;
		}
		return number1;
	}
	
	public static double min(double number1, double number2){
		if( number1 > number2 ) {
			return number2;
		}
		return number1;
	}
	
	public static double pow(double number, int power) {
		int i = 0;
		double product = 1;
		
		while( i < power ) {
			product *= number;
			i++;
		}
		return product;
		
	}
	
	public static double toDegrees(double radian) {
		return 180*radian/pi;
	}
	
	public static double toRadians(double degree) {
		return pi*degree/180 ;
	}
}