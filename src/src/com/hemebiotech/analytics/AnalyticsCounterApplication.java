package src.com.hemebiotech.analytics;

/**
 * This is the main class that triggers the application according to the
 * received file
 *
 * @see ReadSymptomDataFromFile
 * @see SymptomReaderImpl
 * @see WriteSymptomWithOccurForOut
 * @see SymptomWriterImpl
 *
 */
public class AnalyticsCounterApplication {

    public static void main(final String[] args) {
        final String filepath = "symptoms.txt";
        AnalyticsCounter.out(filepath);
    }
}
