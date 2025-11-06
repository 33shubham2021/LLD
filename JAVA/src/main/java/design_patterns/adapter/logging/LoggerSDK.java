package design_patterns.adapter.logging;

public class LoggerSDK {
    public void printLog(String log){
        System.out.println("Logged via LoggerSDK");
        System.out.println(log);
    }
}
