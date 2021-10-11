package src.com.hemebiotech.analytics;

import java.util.Map;

/**
 * This is used to write the sorted data to the output file.
 *
 * @see SymptomWriterServiceImpl
 * @see AnalyticsCounterApplication
 */
public interface SymptomWriterService {
    /**
     * @param sortedList This is a list of "key: value" pairs sorted alphabetically
     *
     */
    void setSymptoms(Map<String, Long> sortedList);

}
