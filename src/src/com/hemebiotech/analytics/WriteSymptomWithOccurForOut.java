package src.com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * This is a class that writes symptoms and their occurrences, one per line to
 * the output file
 *
 * @see AnalyticsCounter
 */
public class WriteSymptomWithOccurForOut implements ISymptomWriter {

    private final String outputFilePath;

    /**
     *
     * @param outputFilePath a full or partial path to the output file
     */
    public WriteSymptomWithOccurForOut(final String outputFilePath) {
        this.outputFilePath = outputFilePath;
    }

    @Override
    public void setSymptoms(final Map<String, Long> sortedList) {
        try (final BufferedWriter fichier = new BufferedWriter(new FileWriter(outputFilePath, true))) {

            for (final Map.Entry<String, Long> entry : sortedList.entrySet()) {
                fichier.write(entry.getKey() + "=" + entry.getValue());
                fichier.newLine();
            }
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }
}
