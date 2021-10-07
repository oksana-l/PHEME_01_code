package src.com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This is a class which reads data from a file and adds it to ArrayList
 *
 * @see AnalyticsCounter
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

    private final String filepath;

    /**
     *
     * @param filepath a full or partial path to file with symptom strings in it,
     *                 one per line
     */
    public ReadSymptomDataFromFile(final String filepath) {
        this.filepath = filepath;
    }

    @Override
    public List<String> getSymptoms() {
        final List<String> result = new ArrayList<>();

        if (filepath != null) {
            try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {

                String line = reader.readLine();

                while (line != null) {
                    result.add(line);
                    line = reader.readLine();
                }
            } catch (final IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
