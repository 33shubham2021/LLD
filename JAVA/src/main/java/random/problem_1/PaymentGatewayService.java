package random.problem_1;

public class PaymentGatewayService {

    private final Logger logger;
    private final NotificationService notificationService;

    public PaymentGatewayService(Logger logger, NotificationService notificationService) {
        this.logger = logger;
        this.notificationService = notificationService;
    }


    public void executeTransaction(String mode, double amount, String identifier) {
        try{
        PaymentMode paymentMode = PaymentFactory.getPaymentModeFromInput(mode);
        paymentMode.processPayment(identifier , amount);
        notificationService.notify("alerts@gateway.com", "Transaction successful for " + mode);
        } catch (Exception e) {
            logger.logError("Transaction failed: " + e.getMessage());
        }
    }

}
