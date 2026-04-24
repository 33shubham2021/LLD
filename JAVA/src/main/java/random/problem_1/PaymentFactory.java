package random.problem_1;

public class PaymentFactory {
    static PaymentMode getPaymentModeFromInput(String mode) {
        if (mode.equalsIgnoreCase("UPI")) {
            return new UpiPaymentMode();
        } else if (mode.equalsIgnoreCase("CARD")) {
            return new CardPaymentMode();
        } else if (mode.equalsIgnoreCase("NET_BANKING")) {
            return new NetBankingPaymentMode();
        } else {
            throw new IllegalArgumentException("Unknown payment mode: " + mode);
        }
    }
}
