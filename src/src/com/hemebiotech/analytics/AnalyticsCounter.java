package src.com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * This is the body of the application which calls on the other classes and
 * coordinates their execution.
 *
 * @see AnalyticsCounterApplication
 *
 */
public class AnalyticsCounter {

    private String filepath;

    public static void out(final String filepath) {
        // Reading symptoms from file
        final SymptomReaderServiceImpl symptoms = new SymptomReaderServiceImpl(filepath);
        final List<String> listOfSymptoms = symptoms.getSymptoms();

        // Counting of occurrences and sorting in alphabetical order
        final Map<String, Long> countsOccurrences = listOfSymptoms.stream()
                .collect(Collectors.groupingBy(symptomsSet -> symptomsSet, Collectors.counting()));
        final Map<String, Long> sortedList = new TreeMap<>(countsOccurrences);

        // Writing the result in the output file
        final SymptomWriterServiceImpl results = new SymptomWriterServiceImpl("results.out");
        results.setSymptoms(sortedList);
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(final String filepath) {
        this.filepath = filepath;
    }
}
