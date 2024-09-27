package Q2_TextDetails;

import java.util.StringTokenizer;

public class FindTextDetails {
	String text = "";
	
	FindTextDetails(String text){
		this.text = text;
	}
	
	int findCharCount() {
		int count = 0, i = 0;
		
		for(i = 0; i < text.length(); i++) {
			if(text.charAt(i) != ' ' ) {
				count++;
			}
		}
		
		return count;
	}
	
	int findWordCount() {
		int count = 0;
		StringTokenizer st = new StringTokenizer(text);
		
		//Count is increased by 1 for each token
		while(st.hasMoreTokens()) {
			count++;
			st.nextToken();
		}
		
		return count;
	}
	
	String findLongestWord() {
		String compareTo, longestTokens, longestTokenYet;
		StringTokenizer st = new StringTokenizer(text);
		longestTokenYet = st.nextToken();
		longestTokens = longestTokenYet;
		
		//The all the tokens lengths are compared and the longest one is stored in the longestTokens string which is returned 
		while(st.hasMoreTokens()) {
			compareTo = st.nextToken();
			//If a token has the same length as the longest token found so far it is added on to the string storing the longest tokens  
			if(compareTo.length() == longestTokenYet.length()) {
				longestTokens = longestTokens + ", " + compareTo;
			}
			//If the token is longer than the longest token found it replaces the longestToken and longestTokenYet
			else if(compareTo.length() > longestTokenYet.length()) {
				longestTokens = compareTo;
				longestTokenYet = compareTo;
			}
		}
		
		return longestTokens;
	}
	
	String findShortestWord() {
		String compareTo;
		StringTokenizer st = new StringTokenizer(text);
		String shortestTokenYet = st.nextToken();
		String shortestTokens = shortestTokenYet;
		
		//The all the tokens lengths are compared and the shortest one is stored in the shortestTokens string which is returned 
		while(st.hasMoreTokens()) {
			compareTo = st.nextToken();
			//If a token has the same length as the shortest token found so far it is added on to the string storing the shortest tokens  
			if(compareTo.length() == shortestTokenYet.length()) {
				shortestTokens = shortestTokens + ", " + compareTo;
			}
			//If the token is smaller than the shortest token found it replaces the shortestToken and shortestTokenYet
			else if(compareTo.length() < shortestTokenYet.length()) {
				shortestTokens = compareTo;
				shortestTokenYet = compareTo;
			}
		}
		
		return shortestTokens;
	}
}

