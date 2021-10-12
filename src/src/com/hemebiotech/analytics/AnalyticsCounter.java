package src.com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * Sorts the received file and returns the result to the output file
 *
 * @see AnalyticsCounterApplication
 */
public final class AnalyticsCounter {

    private AnalyticsCounter() {
    }

    static void out(final String filepath) {
        // Reading datas from file
        final AnalyticsReaderServiceImpl datas = new AnalyticsReaderServiceImpl(filepath);
        final List<String> listOfDatas = datas.readAnalytics();

        final Map<String, Long> sortedList = analyticsCounter(listOfDatas);

        final String fileout = "results.out";
        final AnalyticsWriterServiceImpl results = new AnalyticsWriterServiceImpl(fileout);
        results.writeAnalytics(sortedList);
    }

    /**
     * Counting of occurrences and sorting in alphabetical order
     *
     * @param listOfDatas
     * @return Returns the sorted list
     */
    static Map<String, Long> analyticsCounter(final List<String> listOfDatas) {
        final Map<String, Long> countsOccurrences =
                listOfDatas.stream().collect(Collectors.groupingBy(datasSet -> datasSet, Collectors.counting()));
        return new TreeMap<>(countsOccurrences);
    }
}
