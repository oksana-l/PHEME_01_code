package src.com.hemebiotech.analytics;

import java.util.Map;

public interface ISymptomWriter {
/**
 * @param map This is a list of "key: value" pairs sorted alphabetically
 * 
 * @return If the initial list is empty, return the empty file
 */
	void SetSymptoms(Map<String, Long> map);

}
