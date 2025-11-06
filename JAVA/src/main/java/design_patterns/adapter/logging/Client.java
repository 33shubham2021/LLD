package design_patterns.adapter.logging;

public class Client {
    public static void main(String[] args) {
        String message = "A successful payment has been done ";
        LoggerInterface l1 = new Slog4jAdapter();
        l1.log(message);


    }
}










//Many logging libraries
// Log4j => sendStream()
// Logger => printLog()
// Slog4j => out()
