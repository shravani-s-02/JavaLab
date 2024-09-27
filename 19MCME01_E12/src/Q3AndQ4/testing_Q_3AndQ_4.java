package Q3AndQ4;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

public class testing_Q_3AndQ_4 {

	public static void main(String[] args) {
		String file = "src/TextFileForQ_3.txt";
		
		HashMap<String, Integer> fileFrequencyHashMap = new HashMap<String, Integer>();
		
		try {
			fileFrequencyHashMap = Q_3_Frequency.getFrequency(file);
		} catch (IOException e) {
			System.out.print(e.getClass().getName() + "\n");
			System.out.print(e.getMessage() + "\n");
		};
		
		System.out.print("\nUnsorted:-\n(Word, Frequency)\n");
		for(Entry<String, Integer> entry :  fileFrequencyHashMap.entrySet()) {
			System.out.print("(" + entry.getKey() + ", " + entry.getValue() + ")\n");		
		}
		
		Q_4_SortedFrequency.printSortedHashMap(fileFrequencyHashMap);
	}

}
