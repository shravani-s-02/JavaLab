package Q8_ThreeFromFive;
import java.util.Scanner;

public class Q8_ThreeFromFive {

	static void checkWordLength(String word) throws LessThan5CharactersException, MoreThan5CharactersException{
		//If the word length is less than 5 LessThan5CharactersException is thrown
		if(word.length() < 5) {
			throw new LessThan5CharactersException();
		}
		//If the word length is greater than 5 MoreThan5CharactersException is thrown
		else if(word.length() > 5) {
			throw new MoreThan5CharactersException();
		}
	}
	
	static void checkWordCharacters(String word) throws NotAnAlphabetException {
		//If the word word does not match the regular expression, contains only letters, NotAnAlphabetException is thrown   
		if(!word.matches("^[a-zA-Z]+$")) {
			throw new NotAnAlphabetException();
		}
	}
	
	static void threeLetterWords(String word) {
		int count = 0, uniqueCount = 0;
		boolean unique = true;
		String[] wordsCreated = new String[61];
		
		try {
			checkWordLength(word);
		} catch (LessThan5CharactersException | MoreThan5CharactersException e) {
			System.out.print(e.getClass().getName() + "\n");
			System.out.print(e.getMessage() + "\n");
			return;
		}
		
		try {
			checkWordCharacters(word);
		} catch (NotAnAlphabetException e) {
			System.out.print(e.getClass().getName() + "\n");
			System.out.print(e.getMessage() + "\n");
			return;
		}
		
		System.out.print("All three letter words produced from " + word + ":");
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				//When the same position is encountered is continues to the next loop
				if(i == j) {
					continue;
				}
				for(int k = 0; k < 5; k++) {
					//When the same position is encountered is continues to the next loop
					if(i == k || j == k) {
						continue;
					}
					
					//Word created is stored in the array
					wordsCreated[count] = "" + word.charAt(i) + word.charAt(j) + word.charAt(k);
					
					//Checks if the word produced is unique
					for(int p = 0; p <= count; p++) {
						if(p == count) {
							continue;
						}
						else if(wordsCreated[count].equals(wordsCreated[p])) {
							unique = false;
						}
					}
					
					//If the word is unique it is printed out
					if(unique == true) {
						System.out.print("\n" + wordsCreated[count]);
						uniqueCount++;
					}
					
					unique = true;
					count++;
				}
			}
		}
		
		System.out.print("\nNumber of unique words produced:" + uniqueCount );
	}
	
	public static void main(String[] args) {
		Scanner enter = new Scanner(System.in);
		
		String word; 
		boolean cont = true;
		
		while(cont == true) {
			cont = false;
	
			System.out.print ("\nEnter a 5 letter word to produce 3 letter words from or Exit(Done):");
			word = enter.nextLine();
			
			if(!word.equalsIgnoreCase("done")) {
				cont = true;
				threeLetterWords(word);
				System.out.print("\n");
			}
		}
		
		enter.close();
	}
}
