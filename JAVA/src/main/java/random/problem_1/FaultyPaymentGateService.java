package random.problem_1;

public class FaultyPaymentGateService {
    // Interfaces
//    interface PaymentNode {
//        void processUpiPayment(String upiId, double amount);
//        void processCardPayment(String cardNumber, double amount);
//        void processNetBanking(String accountId, double amount);
//    }
//
//    // Concrete node implementations
//    class UpiSwitch implements PaymentNode {
//        public void processUpiPayment(String upiId, double amount) {
//            System.out.println("Routing UPI payment of " + amount + " for VPA: " + upiId);
//        }
//
//        public void processCardPayment(String cardNumber, double amount) {
//            throw new UnsupportedOperationException("UPI switch cannot process card payments.");
//        }
//
//        public void processNetBanking(String accountId, double amount) {
//            throw new UnsupportedOperationException("UPI switch cannot process net banking.");
//        }
//    }
//
//    class EmailService {
//        public void sendEmail(String emailAddress, String message) {
//            System.out.println("Sending email to " + emailAddress + ": " + message);
//        }
//    }
//
//    class FileLogger {
//        public void logError(String errorMsg) {
//            System.out.println("Writing to error.log: " + errorMsg);
//        }
//    }
//
//    // Main Service Class
//    public class PaymentGatewayService {
//
//        // Hardcoded dependencies
//        private FileLogger logger = new FileLogger();
//        private EmailService emailService = new EmailService();
//
//        public void executeTransaction(String mode, double amount, String identifier, PaymentNode node) {
//            try {
//                // Processing logic mixed with routing
//                if (mode.equalsIgnoreCase("UPI")) {
//                    node.processUpiPayment(identifier, amount);
//                } else if (mode.equalsIgnoreCase("CARD")) {
//                    node.processCardPayment(identifier, amount);
//                } else if (mode.equalsIgnoreCase("NET_BANKING")) {
//                    node.processNetBanking(identifier, amount);
//                } else {
//                    throw new IllegalArgumentException("Unknown payment mode: " + mode);
//                }
//
//                // Notification logic mixed in
//                emailService.sendEmail("alerts@gateway.com", "Transaction successful for " + mode);
//
//            } catch (Exception e) {
//                // Logging logic mixed in
//                logger.logError("Transaction failed: " + e.getMessage());
//            }
//        }
//    }

}
