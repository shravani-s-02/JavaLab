import java.util.Scanner;
import java.util.StringTokenizer;

public class Q6_DisplayStartingWithCaptital {
	
	static void displayCapital(String line) {
		String token;
		StringTokenizer st = new StringTokenizer(line);
		
		System.out.print("Words that begin with a capital letter:");
		while(st.hasMoreElements()) {
			token = st.nextToken();
			
			//If the string matches the regular expression, begins with an upper case letter, is displayed
			if(token.matches("^[A-Z].*$")) {
				System.out.print(token + ", ");
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner enter = new Scanner (System.in);
		
		String line;
		boolean cont = true;
		
		while(cont == true){
			cont = false;
			System.out.print ("\nEnter a line and find the words that start with capital letters or Exit(enter 1):");
			line = enter.nextLine();
			
			if(!line.equalsIgnoreCase("1")) {
				cont = true;
				displayCapital(line);
				System.out.print("\n");
			}
		}
		enter.close();
	}
}
