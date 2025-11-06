package design_patterns.adapter.logging;

public class Slog4jAdapter implements LoggerInterface {
    private Slog4jSDK log = new Slog4jSDK();

    @Override
    public void log(String message) {
        log.out(message);
    }
}
