package src.com.hemebiotech.analytics;

/**
 * This is the main class that triggers the application according to the
 * received file
 *
 * @see SymptomReaderServiceImpl
 * @see SymptomReaderService
 * @see SymptomWriterServiceImpl
 * @see SymptomWriterService
 *
 */
public class AnalyticsCounterApplication {

    public static void main(final String[] args) {
        final String filepath = "symptoms.txt";
        AnalyticsCounter.out(filepath);
    }
}
