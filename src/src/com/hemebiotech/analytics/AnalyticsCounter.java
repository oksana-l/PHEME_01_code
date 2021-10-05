package src.com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * @author oleroy
 *
 */
public class AnalyticsCounter {

	public static void main(String[] args) {

		ReadSymptomDataFromFile symptoms = new ReadSymptomDataFromFile("symptoms.txt");
		List<String> listOfSymptoms = symptoms.GetSymptoms();

		Map<String, Long> counts =
				listOfSymptoms.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
		Map<String, Long> map = new TreeMap<>(counts);

		WriteSymptomWithOccurForOut results = 
				new WriteSymptomWithOccurForOut("results.out");
		results.SetSymptoms(map);
	}
}
