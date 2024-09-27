import java.util.Scanner;

public class Q_6_Car {
	
	static Scanner enter = new Scanner(System.in);

	class Car{
		int year;
		String make;
		double maxSpeed;
		
		public Car(int year, String make, double maxSpeed) {
			this.year = year;
			this.make = make;
			this.maxSpeed = maxSpeed;
		}
		
		public int getYear(){
			 return year;
		}
		
		public String getMake(){
			 return make;
		}
		
		public double getSpeed(){
			return maxSpeed;
		}
	}
	
	public static String View() {
		String string;
		int i = 0;
		do {
			i = 0;
			//User is prompted to enter what attribute they wish to view
			System.out.print("\nDo you wish to view the car's year of manufactuer, the manufacter, max speed or all?(year/maker/speed/all):");
			string = enter.next();
			
			//If the input is not year, maker, speed or all a error is displayed
			if(!(string.equalsIgnoreCase("year") || string.equalsIgnoreCase("maker") || string.equalsIgnoreCase("speed") || string.equalsIgnoreCase("all")) ){
				System.out.print("Option entered is invalid; respond with year, maker, speed or all.\n");
				i++;
			}	
		}while(i == 1);
		return string;
	}
	
	public static void main(String[] args) {
		Q_6_Car Q6C = new Q_6_Car();
		Car car; 
		
		System.out.print("Enter the car's year of manufacture:");
		int year = enter.nextInt();
		System.out.print("Enter the car's manufacturer:");
		String make = enter.next();
		System.out.print("Enter the car's maximum speed:");
		double maxSpeed = enter.nextDouble();
		
		car = Q6C.new Car(year, make, maxSpeed);
		
		String option = View();
		
		//Based on the input of the user, their prompt of choice is displayed
		if( option.equalsIgnoreCase("year") ) {
			System.out.print("\nThe year of manufacture of the car is " + car.getYear());
		}
		else if( option.equalsIgnoreCase("maker") ) {
			System.out.print("\nThe manufacturer of the car is " + car.getMake());
		}
		else if( option.equalsIgnoreCase("speed") ) {
			System.out.print("\nThe maximum speed of car is " + car.getSpeed());
		}
		else {
			System.out.print("\nThe details of the car are,\nYear of manufacture:" + car.getYear() + "\nManufacturer of Car:" + car.getMake() + "\nMaximum speed of Car:" + car.getSpeed());
		}
			
	}
}
