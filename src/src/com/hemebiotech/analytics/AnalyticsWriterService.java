package src.com.hemebiotech.analytics;

import java.util.Map;

/**
 * Write the sorted datas to the output file.
 *
 * @see AnalyticsWriterServiceImpl
 * @see AnalyticsCounterApplication
 */
public interface AnalyticsWriterService {
    /**
     * @param sortedList List of "key=value" pairs sorted alphabetically
     *
     */
    void writeAnalytics(Map<String, Long> sortedList);

}
