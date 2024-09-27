import java.util.Scanner;

public class Q_3_MathClassTest {

	public class MathTest{
		public void testMax(double number1, double number2) {
			System.out.print("\nThe greater of the two numbers:" + mathClass.Math_19MCME01.max(number1, number2));
		}
		
		public void testMin(double number1, double number2) {
			System.out.print("\nThe smaller of the two numbers:" + mathClass.Math_19MCME01.min(number1, number2));
		}
		
		public void testPow(double number, int power) {
			System.out.print("\nValue of " + number +" to the power " + power +":" + mathClass.Math_19MCME01.pow(number,power));
		}
		
		public void testToDegrees(double radian) {
			System.out.print("\n" + radian + " degrees in radian : " + mathClass.Math_19MCME01.toDegrees(radian));
		}
		
		public void testToRadians(double degree) {
			System.out.print("\n" + degree + " degrees in radian : " + mathClass.Math_19MCME01.toRadians(degree) );
		}
	}
	
	
	public static void main(String[] args) {
		Scanner enter = new Scanner(System.in);
		int option = 0, i = 1;
		double number1 = 0, number2 = 0; 
		
		Q_3_MathClassTest Q3M = new Q_3_MathClassTest();
		MathTest test1;
		test1 = Q3M.new MathTest();
		
		do {
			i = 0;
			System.out.print("Do you wish to,\n Find the min of two number(enter 1) \nFind the max of two number(enter 2) "
					+ "\nFind the value of a number raised to a power(enter 3) \nConvert degrees to radian(enter 4) \nConvert radian to degrees(enter 5) \nEnter your option of choice:");
			option = enter.nextInt();
			
			if(option == 1) {
				System.out.print("\nEnter the first number:");
				number1 = enter.nextDouble();
				System.out.print("Enter the second number:");
				number2 = enter.nextDouble();
				
				test1.testMax(number1, number2);
			}
			
			else if(option == 2) {
				System.out.print("\nEnter the first number:");
				number1 = enter.nextDouble();
				System.out.print("Enter the second number:");
				number2 = enter.nextDouble();
				
				test1.testMin(number1, number2);
			}
			
			else if(option == 3 ) {
				System.out.print("\nEnter the number to find the power of:");
				number1 = enter.nextDouble();
				int power = 1;
				i++;
				
				while(i == 1) {
					i = 0;
					System.out.print("Enter the power:");
					power = enter.nextInt();
					if(power < 1) {
						System.out.print("Number entered is invalid, enter a positive integer value");
						i++;
					}
				}
				
				test1.testPow(number1, power);
			}
			
			else if(option == 4) {
				System.out.print("\nEnter the radian value to convert to degree:");
				double radian = enter.nextDouble();
				
				test1.testToDegrees(radian);
			}
			
			else if(option == 5) {
				System.out.print("\nEnter the degree value to convert to radian:");
				double degree = enter.nextDouble();
				
				test1.testToRadians(degree);
			}  
			else {
				System.out.print("Option entered is invalid; enter 1, 2, 3, 4, 5 or 6");
				i++;
			}
		}while(i == 1 );
		enter.close();
	}

}
