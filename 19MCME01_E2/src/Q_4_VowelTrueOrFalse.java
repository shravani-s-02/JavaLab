import java.util.Scanner;

public class Q_4_VowelTrueOrFalse {

	static Scanner enter = new Scanner(System.in);
	
	public static void isVowel(char ch) {
		//If the character is a vowel then true is printed, if not false is printed
		if( ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
			System.out.print("True\n");
		}
		else {
			System.out.print("False\n");
		}
		
	}
	public static void main(String[] args) {
		Scanner enter = new Scanner(System.in);
		//User is prompted to enter a sentence
		System.out.print("Enter a sentance:");
		String string = enter.nextLine();
		enter.close();
		
		//The string entered is converted to lower case in order to simplify the if condition, i.e, reducing the amount of possible criteria 
		string = string.toLowerCase();
		
		int count = 0, i = 0;
		
		for( i = 0; i < string.length(); i++ ) {
			//If the character in the string is a vowel the count is incremented by 1 
			if( string.charAt(i) == 'a' || string.charAt(i) == 'e' || string.charAt(i) == 'i' || string.charAt(i) == 'o' || string.charAt(i) == 'u') {
				count++;
			} 
			System.out.print(string.charAt(i) + " : " ); 
			isVowel(string.charAt(i));
		}
		
		System.out.print("\n-------------------------\nNumber of vowels in the sentance : " + count + "\n-------------------------");
		enter.close();
	}

}
