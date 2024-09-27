import java.util.Scanner;

public class Q_5_Circle {
	
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
		
		public double getArea() {
			return (22/7)*radius*radius;
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
	
	public static String View() {
		String string = "a";
		int i = 0;
		
		do {
			i = 0;
			//User is prompted to enter what attribute they wish to view
			System.out.print("\nDo you wish to view the radius, area or both?(radius/area/both):");
			string = enter.next();
			
			//If the input is not area, radius or both a error messafe is displayed
			if(!(string.equalsIgnoreCase("Area") || string.equalsIgnoreCase("Radius") || string.equalsIgnoreCase("Both")) ){
				System.out.print("Option entered is invalid, respond with radius, area or both.\n");
				i++;
			}
			
		}while( i == 1);
		
		return string;
	}
	
	public static void main(String[] args) {
		Q_5_Circle Q5C = new Q_5_Circle();
		Circle circle; 
		
		String option = Enter();
		
		//If the user chooses to view the default circle, their prompt of choice is displayed for the default value, i.e, radius = 1
		if(option.equalsIgnoreCase("default")) {
			circle = Q5C.new Circle();
			String view = View();
			if( view.equalsIgnoreCase("Radius") ) {
				System.out.print("\nThe radius of the circle is " + circle.getRadius());
			}
			else if( view.equalsIgnoreCase("Area") ){
				System.out.print("\nThe area of the circle is " + circle.getArea());
				
			}
			else {
				System.out.print("\nThe radius of the circle is " + circle.getRadius() + " and the area of circle is " + circle.getArea());		
			}
		}
		
		//If the user chooses to enter a new radius, their prompt of choice is displayed for the new radius entered
		else {
			System.out.print("Enter the new radius:");
			double newRadius = enter.nextDouble();
			circle = Q5C.new Circle(newRadius);
			
			String view = View();
			if( view.equalsIgnoreCase("Radius") ) {
				System.out.print("\nThe radius of the circle is " + circle.getRadius());
			}
			else if( view.equalsIgnoreCase("Area") ){
				System.out.print("\nThe area of the circle is " + circle.getArea());
				
			}
			else {
				System.out.print("\nThe radius of the circle is " + circle.getRadius() + " and the area of circle is " + circle.getArea());
			}
		}
		
	}

}
