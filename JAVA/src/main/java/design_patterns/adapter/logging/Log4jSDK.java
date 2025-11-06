package design_patterns.adapter.logging;

public class Log4jSDK {
    public void sendStream(String s){
        System.out.println("Logged via Log4jSDK");
        System.out.println(s);
    }
}
