import java.util.Scanner;
import java.util.StringTokenizer;

public class Q5_DisplayLongest {

	static String findLongest(String line) {
		String compareTo, longestTokens, longestTokenYet;
		StringTokenizer st = new StringTokenizer(line);
		longestTokenYet = st.nextToken();
		longestTokens = longestTokenYet;
		
		//The all the tokens lengths are compared and the longest one is stored in the longestTokens string which is returned 
		while(st.hasMoreTokens()) {
			compareTo = st.nextToken();
			//If a token has the same length as the longest token found so far it is added on to the string storing the longest tokens  
			if(compareTo.length() == longestTokenYet.length()) {
				longestTokens = longestTokens + ", " + compareTo;
				longestTokenYet = compareTo;
			}
			else if(compareTo.length() > longestTokenYet.length()) {
				longestTokens = compareTo;
				longestTokenYet = compareTo;
			}
		}
		
		return longestTokens;
	}
	
	public static void main(String[] args) {
		Scanner enter = new Scanner (System.in);
		
		String line;
		boolean cont = true;
		
		while(cont == true){
			cont = false;
			System.out.print ("\nEnter line to find the longest word in or Exit(enter 1):");
			line = enter.nextLine();
			
			if(!line.equalsIgnoreCase("1")) {
				cont = true;
				
				System.out.print("Longest Token/s:" + findLongest(line) + "\n");
			}
		}
		enter.close();
	}
}
