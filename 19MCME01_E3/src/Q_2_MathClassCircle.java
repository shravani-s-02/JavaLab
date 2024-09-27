import java.util.Scanner;

public class Q_2_MathClassCircle {

	static Scanner enter = new Scanner(System.in);
	
	public class Circle{
		double radius;
		
		public Circle(){
			radius =1;
		}
		
		public Circle(double radius) {
			this.radius = radius;
		}
		
		public double getRadius() {
			return radius;
		}
		
		//Math.rint rounds to two decimal places , the formula rounded is multiplied by 100 to round to the nearest value. 
		//Then it is divided by 100 to put the decimal point. If this is not done the value obtained from the formula is rounded with no decimal points.
		public double getArea() {
			return Math.rint( Math.PI*radius*radius * 100 ) / 100;
		}
		
		public double getPerimeter() {
			return Math.rint( 2*Math.PI*radius * 100 ) / 100;
		}
	}
	
	public static String Enter() {
		String string = "a";
		int i = 1 ;
		
		do {
			i = 0;
			//The user is prompted to choose the their prompt of choice
			System.out.print("Do you wish to view the default radius and area or enter a new circle ?(default/new):");
			string = enter.next();
			
			//If the input is not new or default a error message is shown
			if(!(string.equalsIgnoreCase("Default") || string.equalsIgnoreCase("New")) ){
				System.out.print("Option entered is invalid respond with either default or new.\n\n");
				i++;
			}
		}while( i == 1);
		
		return string;
	}
			
	public static void main(String[] args) {
		Q_2_MathClassCircle Q2M = new Q_2_MathClassCircle();
		Circle circle; 
		
		String option = Enter();
		
		//If the user chooses to view the default circle, their prompt of choice is displayed for the default value, i.e, radius = 1
		if(option.equalsIgnoreCase("default")) {
			circle = Q2M.new Circle();
			
			System.out.print("\nThe details of the circle are,\nRadius of the circle:" + circle.getRadius() + "\nArea of the circle:" + circle.getArea() 
					+ "\nPerimeter of the circle:" + circle.getPerimeter());	
		}
		
		//If the user chooses to enter a new radius, their prompt of choice is displayed for the new radius entered
		else {
			System.out.print("Enter the new radius:");
			double newRadius = enter.nextDouble();
			circle = Q2M.new Circle(newRadius);
			
			System.out.print("\nThe details of the circle are,\nRadius of the circle:" + circle.getRadius() + "\nArea of the circle:" + circle.getArea() 
					+ "\nPerimeter of the circle:" + circle.getPerimeter());
		}
	}

}
