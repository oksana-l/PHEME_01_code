package src.com.hemebiotech.analytics;

/**
 * Triggers the application according to the received file
 *
 * @see AnalyticsReaderServiceImpl
 * @see AnalyticsReaderService
 * @see AnalyticsWriterServiceImpl
 * @see AnalyticsWriterService
 *
 */
public class AnalyticsCounterApplication {

    public static void main(final String[] args) {
        final String filepath = "symptoms.txt";
        AnalyticsCounter.out(filepath);
    }
}
