import java.util.Scanner;
import java.util.StringTokenizer;

public class Q4_Reverse {

	static String reverse(String line) {
		String lineReverse = "";
		StringTokenizer st = new StringTokenizer(line);
		
		//The tokens are reversed by adding on the next token at the beginning of the string returned
		while(st.hasMoreTokens()) {
			lineReverse = st.nextToken() + " " + lineReverse;
		}
		
		return lineReverse;
	}
	
	public static void main (String args[]) {
		Scanner enter = new Scanner (System.in);
		
		String line;
		boolean cont = true;
		
		while(cont == true){
			cont = false;
			System.out.print ("\nEnter a line to reverse or Exit(enter 1):");
			line = enter.nextLine();
			
			if(!line.equalsIgnoreCase("1")) {
				cont = true;

				System.out.print("Reversed Line:" + reverse(line) + "\n");
			}
		}
		enter.close();
	}
}
