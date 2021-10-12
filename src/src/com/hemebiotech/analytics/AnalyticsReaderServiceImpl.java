package src.com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Reads datas from a file and adds to List
 *
 * @see AnalyticsCounterApplication
 */
public class AnalyticsReaderServiceImpl implements AnalyticsReaderService {

    private final String filepath;

    /**
     *
     * @param filepath an absolute or relative path to file with data strings in it,
     *                 one per line
     */
    public AnalyticsReaderServiceImpl(final String filepath) {
        this.filepath = filepath;
    }

    @Override
    public List<String> readAnalytics() {
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
