package design_patterns.adapter.logging;

public class LoggerAdapter implements LoggerInterface {
    private LoggerSDK log = new LoggerSDK();

    @Override
    public void log(String message) {
        log.printLog(message);
    }
}
