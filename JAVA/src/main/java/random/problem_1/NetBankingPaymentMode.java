package random.problem_1;

public class NetBankingPaymentMode implements PaymentMode{
    @Override
    public void processPayment(String accountId, Double amount) {
        System.out.println("Processing Net Banking Payment");
    }
}
