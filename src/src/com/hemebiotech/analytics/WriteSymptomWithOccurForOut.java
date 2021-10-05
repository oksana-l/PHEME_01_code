package src.com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Map;

public class WriteSymptomWithOccurForOut implements ISymptomWriter{

	private String outputFilePath;

	public WriteSymptomWithOccurForOut(String outputFilePath) {
		this.outputFilePath = outputFilePath;
	}

	@Override
	public void SetSymptoms(Map<String, Long> map) {
		try {
			BufferedWriter fichier = new BufferedWriter(new FileWriter(outputFilePath, true));
			for (Map.Entry<String, Long> entry :
				map.entrySet()) {
				fichier.write(entry.getKey() + ":"
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
