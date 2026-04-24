package random.problem_1;

public class CardPaymentMode implements PaymentMode {
    @Override
    public void processPayment(String cardNumber, Double amount) {
        System.out.println("Processing Card Payment");
    }
}
