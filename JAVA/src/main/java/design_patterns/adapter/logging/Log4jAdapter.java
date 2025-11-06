package design_patterns.adapter.logging;

public class Log4jAdapter implements LoggerInterface{
    private Log4jSDK log = new Log4jSDK();

    @Override
    public void log(String message) {
        log.sendStream(message);
    }
}
