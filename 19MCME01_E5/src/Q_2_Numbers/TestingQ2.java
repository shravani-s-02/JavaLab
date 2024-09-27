package Q_2_Numbers;

import java.util.Scanner;

class TestingQ2 {

	static Scanner enter = new Scanner(System.in);
	
	public static void main(String[] args) {
		int i = 0, option = 0, real = 0, imag = 0, inte = 0;
		
		do{
	        i = 0;
	        System.out.print("Do you wish to perform arthmetic operations and compare two integer(enter 1) or complex number(enter 2), \nor do you wish to add a integer and complex number(enter3)?\nEnter:");
	        option = enter.nextInt();
	        if(option < 1 || option > 3){
	           System.out.print("\nOption enterered is invalid, enter 1, 2 or 3\n");
	            i++;
	        }
	    }while( i == 1);
		
		if(option == 1) {
			int position = 0;
			System.out.print("\nEnter integer value:");
			inte = enter.nextInt();
			
			IMTechInteger integer = new IMTechInteger(inte);
			
			System.out.print("Enter value to perform arthmetic operations with and compare to:" );
			int intCompared = enter.nextInt();
			
			IMTechInteger integerCompare = new IMTechInteger(intCompared);
			
			do {
				i = 0;
				System.out.print("Enter positon to find digit at:");
				position = enter.nextInt();
				if( position < 0 ||  position > integer.getNumDigits()-3) {
					System.out.print("Enter a number between 0 and " + (integer.getNumDigits() - 3)+ "\n");
					i++;
				}
			}while(i == 1);
			
			
			System.out.print("\nNumber entered is equal to " + inte  + " : " + integer.equalsTo(integerCompare));
			 
			System.out.print("\nIs the number entered is less than(-1), equal to(0) or greater than(1) " + inte +" : " + integer.compareTo(integerCompare));
			
			IMTechInteger result = (IMTechInteger) integer.addTo(integerCompare);
			System.out.print("\nAddition of " + inte + " and "+ intCompared + " : " + result.getNum());
			
			result = (IMTechInteger) integer.subFrom(integerCompare);
			System.out.print("\nSubtraction of " + inte + " by "+ intCompared + " : " + result.getNum());
			
			result = (IMTechInteger) integer.multWith(integerCompare);
			System.out.print("\nMultiplication of " + inte + " with "+ intCompared + " : " + result.getNum());
			
			result = (IMTechInteger) integer.divideBy(integerCompare);
			System.out.print("\nDivision of " + inte + " by "+ intCompared + " : " + result.getNum());
			
			System.out.print("\nDigit at " + position + " in " + inte +" : " + integer.getDigit(position));
			System.out.print("\n" + inte + " is a prime number : " + integer.isPrime());
		}

		else if(option == 2) {
			System.out.print("\nEnter the real part of the complex number:");
			real = enter.nextInt();
			System.out.print("Enter the imaginary part of the complex number:");
			imag = enter.nextInt();
			
			IMTechComplex complex = new IMTechComplex(real, imag);
			
			System.out.print("Enter real part of the complex number to perform arthmetic operations with and compare to:");
			int realCompared = enter.nextInt();
			System.out.print("Enter imaginary part of the complex number to perform arthmetic operations with and compare to:");
			int imagCompared = enter.nextInt();
			
			IMTechComplex complexCompare = new IMTechComplex(realCompared, imagCompared);
			
			System.out.print("\nNumber entered is equal to " + real + "+" + imag + "i :" + complex.equalsTo(complexCompare));
			
			System.out.print("\nIs the number entered is less than(-1), equal to(0) or greater than(1) " + real + "+" + imag + "i : " + complex.compareTo(complexCompare));
			
			IMTechComplex result = (IMTechComplex) complex.addTo(complexCompare);
			System.out.print("\nAddition of " + real + "+" + imag + "i and "+ realCompared + "+" + imagCompared + "i : " + result.getReal() + " + " + result.getImag() + "i");
			
			result = (IMTechComplex) complex.subFrom(complexCompare);
			System.out.print("\nSubtraction of " + real + "+" + imag + "i by "+ realCompared + "+" + imagCompared + "i : " + result.getReal() + " + " + result.getImag() + "i");
			
			result = (IMTechComplex) complex.multWith(complexCompare);
			System.out.print("\nMultiplication of " + real + "+" + imag + "i with " + realCompared + "+" + imagCompared + "i : " + result.getReal() + " + " + result.getImag() + "i");
			
			result = (IMTechComplex) complex.divideBy(complexCompare);
			System.out.print("\nDivision of " + real + "+" + imag + "i by " + realCompared + "+" + imagCompared + "i : " + result.getReal() + " + " + result.getImag() + "i");			
			
			System.out.print("\nMagnitude of" + real + "+" + imag + "i : " + complex.getMag());
		}
		
		else {
			System.out.print("\nEnter integer value:");
			inte = enter.nextInt();
			
			IMTechInteger integer = new IMTechInteger(inte);
			
			System.out.print("Enter the real part of the complex number:");
			real = enter.nextInt();
			System.out.print("Enter the imaginary part of the complex number:");
			imag = enter.nextInt();
			
			IMTechComplex complex = new IMTechComplex(real, imag);
			
			IMTechComplex result = (IMTechComplex) complex.addTo(integer);
			System.out.print("Sum of " + inte +" and " + real + "+" + imag + "i :" + result.getReal() + "+" + result.getImag() + "i");
		}
	
	}
}
