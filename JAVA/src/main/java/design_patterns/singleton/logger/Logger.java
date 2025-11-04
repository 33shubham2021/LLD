package design_patterns.singleton.logger;

public class Logger {

    public static Logger l;

    //private constructor
    private Logger(){};

    //method to get instance of Logger
    public static Logger getInstance(){
        if (l == null){
            return new Logger();
        }
        return l;
    }

    public void log(String s){
        System.out.println(s);
    }
}
