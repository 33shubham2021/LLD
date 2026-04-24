package random.problem_1;

public class FileLogger implements Logger {

    @Override
    public void logError(String errorMsg) {
        System.out.println("Writing to error.log: " + errorMsg);
    }
}
