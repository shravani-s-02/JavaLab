import java.util.Scanner;

public class Q7_OWNindexOfANDlastIndexOf {
	class searchMethods{
		String aString;
		
		searchMethods(String aString){
			this.aString = aString;
		}
		
		//Finds and returns the index of first instance  index of a character or subset in a string
		int indexOf(String findString) {
			int i = 0, j = 0;

			for(i = 0; i < aString.length(); i++) {
				for(j = i; j < aString.length(); j++) {
					//If i and j are the same it means that the string to find is being compared with one character and not a subset
					if(i == j) {
						if(aString.charAt(i) == findString.charAt(0)) {
							return i;
						}
					}
					if(aString.substring(i, j).equals(findString)) {
						return i;
					}
					
				}		
			}
			
			//Index of returns -1 if it is not found
			return -1;
		}
		
		//Finds and returns the index of the last instance of a character or subset in a string
		int lastIndexOf(String findString) {
			//Position is -1 since last index of returns -1 if it is not found
			int position = -1, i = 0, j = 0;
			
			for(i = 0; i < aString.length(); i++) {
				for(j = i; j < aString.length(); j++) {
					//If i and j are the same it means that the string to find is being compared with one character and not a subset
					if(i == j) {
						if(aString.charAt(i) == findString.charAt(0)) {
							position = i;
						}
					}
					else {
						if(aString.substring(i, j).equals(findString)) {
							position = i;
						}
					}
					
				}		
			}
			
			return position;
		}
			
	}
	
	public static void main(String[] args) {
		Scanner enter = new Scanner(System.in);
		
		Q7_OWNindexOfANDlastIndexOf Q7 = new Q7_OWNindexOfANDlastIndexOf();
		
		String enteredString, findString; 
		boolean cont = true;
		
		while(cont == true) {
			cont = false;
			System.out.print ("\nEnter line to search in or Exit(enter 1):");
			enteredString = enter.nextLine();
		
			if(!enteredString.equalsIgnoreCase("1")) {
				cont = true;
				
				searchMethods line = Q7.new searchMethods(enteredString);
				
				System.out.print("Enter string to find:");
				findString = enter.nextLine();
	
				System.out.print("First instance of " + findString +" is at:" + line.indexOf(findString) 
				+ "\nLast instance of " + findString +" is at:" + line.lastIndexOf(findString) + "\n");
			}
		}
		enter.close();
	}
	
}
