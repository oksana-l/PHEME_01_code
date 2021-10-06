package src.com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Map;

/**
 * This is a class that writes symptoms and their occurrences, one per line
 * to the output file
 */
public class WriteSymptomWithOccurForOut implements ISymptomWriter{

	private String outputFilePath;
	
	/**
	 * 
	 * @param outputFilePath a full or partial path to the output file 
	 */
	public WriteSymptomWithOccurForOut(String outputFilePath) {
		this.outputFilePath = outputFilePath;
	}

	@Override
	public void SetSymptoms(Map<String, Long> map) {
		try {
			BufferedWriter fichier = new BufferedWriter(new FileWriter(outputFilePath, true));
			for (Map.Entry<String, Long> entry :
				map.entrySet()) {
				fichier.write(entry.getKey() + "="
						+ entry.getValue());
				fichier.newLine();
			}
			fichier.flush();
			fichier.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
