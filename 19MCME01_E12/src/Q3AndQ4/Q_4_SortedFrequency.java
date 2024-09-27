package Q3AndQ4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

class sortedFrequencyComparator implements Comparator<Entry<String, Integer>>{
	//Compares the frequency's  
	public int compare(Entry<String, Integer> word1, Entry<String, Integer> word2) { 
		return word1.getValue().compareTo(word2.getValue()); 
	}
}

public class Q_4_SortedFrequency {
	
	public static void printSortedHashMap(HashMap<String, Integer> frequencyHashMap) {
		//HashMap is stored in List so the Collections method sort can be used
		List<Entry<String, Integer>> sortedFrequencyHashMap = new ArrayList<Entry<String, Integer>>(frequencyHashMap.entrySet());
		
		//The list is sorted in descending order with a comparator 
		Collections.sort(sortedFrequencyHashMap, new sortedFrequencyComparator().reversed());
	
		System.out.print("\nSorted By Frequency:-\n(Word, Frequency)\n");
		for(Entry<String, Integer> entry : sortedFrequencyHashMap) {
			System.out.print("(" + entry.getKey() + ", " + entry.getValue() + ")\n");		
		}
	}

}