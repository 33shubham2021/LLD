package random.problem_1;

public class UpiPaymentMode implements PaymentMode{
    @Override
    public void processPayment(String upiId, Double amount) {
        System.out.println("Processing UPI Payment");
    }
}
