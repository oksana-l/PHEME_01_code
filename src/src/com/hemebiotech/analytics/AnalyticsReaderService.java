package src.com.hemebiotech.analytics;

import java.util.List;

/**
 * Read data from a source and return value from the operation, which is a list
 * of strings, that may contain many duplications
 *
 * @see AnalyticsReaderServiceImpl
 * @see AnalyticsCounter
 */
public interface AnalyticsReaderService {
    /**
     * If no data is available, return an empty List
     *
     * @return a raw listing of all datas obtained from a data source, duplicates
     *         are possible/probable
     */
    List<String> readAnalytics();
}
