package design_patterns.singleton.logger;

public class LoggerClient {
    public static void main(String[] args) {
        Logger l = Logger.getInstance();
        l.log("Hello world, how are you ");
    }
}
