package src.com.hemebiotech.analytics;

import java.util.Map;

/**
 * This is used to write the sorted data to the output file.
 * 
 * @see WriteSymptomWithOccurForOut
 * @see AnalyticsCounter
 */
public interface ISymptomWriter {
/**
 * @param map This is a list of "key: value" pairs sorted alphabetically
 * 
 */
	void SetSymptoms(Map<String, Long> map);

}
