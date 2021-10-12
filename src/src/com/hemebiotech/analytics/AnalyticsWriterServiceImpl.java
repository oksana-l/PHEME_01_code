package src.com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Writes datas and their occurrences, one per line to the output file
 *
 * @see AnalyticsCounterApplication
 */
public class AnalyticsWriterServiceImpl implements AnalyticsWriterService {

    final String outputFilePath;

    /**
     *
     * @param fileout
     * @param outputFilePath a absolute or relative path to the output file
     */
    public AnalyticsWriterServiceImpl(final String outputFilePath) {
        this.outputFilePath = outputFilePath;
    }

    @Override
    public void writeAnalytics(final Map<String, Long> sortedList) {
        try (final BufferedWriter file = new BufferedWriter(new FileWriter(outputFilePath, false))) {

            for (final Map.Entry<String, Long> entry : sortedList.entrySet()) {
                file.write(entry.getKey() + "=" + entry.getValue());
                file.newLine();
            }
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }
}
