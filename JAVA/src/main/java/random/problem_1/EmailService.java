package random.problem_1;

public class EmailService implements NotificationService {

    @Override
    public void notify(String emailAddress, String message ) {
        System.out.println("Sending email to " + emailAddress + ": " + message);
    }
}
