package design_patterns.adapter.logging;

public class Slog4jSDK {
    public void out(String s){
        System.out.println("Logged via Slog4jSDK");
        System.out.println(s);
    }
}
