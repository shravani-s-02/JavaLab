import java.util.Scanner;

public class Q3_VerifyPasswordValidity {

	static void verify(String password) { 
		//If the input matches the regular expression; begins with a letter, contains at least 1 capital letter, contains at least 1 number and has at least 8 characters and at most 15
		if(password.matches("^([a-z]||[A-Z])(?=.*[A-Z]+)(?=.*[0-9]+).{8,15}$")) {
			System.out.print("Password is valid.\n");
		}
		else {
			System.out.print("Password is not valid.\n");
		}
	}
	
	public static void main (String args[]) {
		Scanner enter = new Scanner (System.in);
		
		boolean cont = true;
		String input;
		
		while(cont == true) {
			cont = false;
			System.out.print("\nEnter password to check if valid or Exit(enter 1)\nEnter:");
			input = enter.next();
				
			if(!input.equalsIgnoreCase("1")){
				cont = true;
				verify(input);
			}
		}
		enter.close();
	}
}
