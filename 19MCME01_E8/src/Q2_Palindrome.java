import java.util.Scanner;

public class Q2_Palindrome {

	static void checkIfPalindrome(String input) {
		StringBuilder sb = new StringBuilder(input.toLowerCase());
		
		//Input is compared to it's reverse, which is reversed using string builder method reverse which reverses the character sequence
		if(input.toLowerCase().equals(sb.reverse().toString())) {
			System.out.print(input + " is a palindrome.\n");
			return;
		}
		
		System.out.print(input + " is not a palindrome.\n");
	}
	
	public static void main (String args[]) {
		Scanner enter = new Scanner (System.in);
		
		boolean cont = true;
		String input;
		
		while(cont == true) {
			cont = false;
			System.out.print("\nEnter word to check if palindrome or Exit(enter 1):");
			input = enter.next();		
			
			if(!input.equalsIgnoreCase("1")){
				cont = true;
				checkIfPalindrome(input);
			}
		}
		enter.close();
	}	
}
