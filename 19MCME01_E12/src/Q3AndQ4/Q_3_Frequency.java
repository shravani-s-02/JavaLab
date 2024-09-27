package Q3AndQ4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Q_3_Frequency {

	static HashMap<String, Integer> getFrequency(String file) throws IOException {
		String fileLine, word;	
		HashMap<String, Integer> frequencyMap = new HashMap<String, Integer>();
		StringTokenizer st;
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
		
		//Iterates through each line
		while ((fileLine = bufferedReader.readLine()) != null){
			st = new StringTokenizer(fileLine);
	
			////Iterates through each word
        	while (st.hasMoreTokens()) {
        		word = st.nextToken().toLowerCase();
        		//If the word has a punctuation mark at the end then word is replaced by a substring excluding the last character. 
        		if(word.charAt(word.length() - 1) == '.' || word.charAt(word.length() - 1 ) == ',' || word.charAt(word.length() - 1) == ';' || word.charAt(word.length()- 1) == ':' ){
        			word = word.substring(0, word.length() - 1);
        		}
        		
        		//If the word is already in the hashmap the value(frequency) is increased by 1.
        		//Otherwise the word is added to the hashmap and the key's(word) value is set to 1.
        		if (frequencyMap.containsKey(word)) {
        			frequencyMap.put(word, frequencyMap.get(word) + 1);
        		}
        		else {
        			frequencyMap.put(word, 1);
        		}
            }
        }
		
		bufferedReader.close();
		return frequencyMap;
	}

}