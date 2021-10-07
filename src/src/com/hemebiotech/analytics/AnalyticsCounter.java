package src.com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * This is the main class which appeals to other classes and methods and
 * coordinates their actions
 *
 * @see ReadSymptomDataFromFile
 * @see ISymptomReader
 * @see WriteSymptomWithOccurForOut
 * @see ISymptomWriter
 *
 */
public class AnalyticsCounter {

    public static void main(final String[] args) {

        // Reading symptoms from file
        final ReadSymptomDataFromFile symptoms = new ReadSymptomDataFromFile("symptoms.txt");
        final List<String> listOfSymptoms = symptoms.getSymptoms();

        // Counting of occurrences and sorting in alphabetical order
        final Map<String, Long> countsOccurrences = listOfSymptoms.stream()
                .collect(Collectors.groupingBy(symptomsSet -> symptomsSet, Collectors.counting()));
        final Map<String, Long> sortedList = new TreeMap<>(countsOccurrences);

        // Writing the result in the output file
        final WriteSymptomWithOccurForOut results = new WriteSymptomWithOccurForOut("results.out");
        results.setSymptoms(sortedList);
    }
}
