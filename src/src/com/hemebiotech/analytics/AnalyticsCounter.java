package src.com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * This is the main class which appeals to other classes and methods and coordinates their actions
 * 
 * @see ReadSymptomDataFromFile
 * @see GetSymptoms
 * @see WriteSymptomWithOccurForOut
 * @see SetSymptoms
 *
 */
public class AnalyticsCounter {

	public static void main(String[] args) {
		
		// Reading symptoms from file
		ReadSymptomDataFromFile symptoms = new ReadSymptomDataFromFile("symptoms.txt");
		List<String> listOfSymptoms = symptoms.GetSymptoms();
		
		// Counting of occurrences and sorting in alphabetical order
		Map<String, Long> counts =
				listOfSymptoms.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
		Map<String, Long> map = new TreeMap<>(counts);
		
		// Writing the result in the output file
		WriteSymptomWithOccurForOut results = 
				new WriteSymptomWithOccurForOut("results.out");
		results.SetSymptoms(map);
	}
}
