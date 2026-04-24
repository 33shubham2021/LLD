package random.problem_1;

import java.util.HashMap;
import java.util.Map;

public class MainProblem1 {
    public static void main(String[] args) {
        System.out.println("--- Bootstrapping Application ---");

        Logger logger = new FileLogger();
        NotificationService emailService = new EmailService();

        //Inject the dependencies into our main service (Dependency Inversion)
        PaymentGatewayService gateway = new PaymentGatewayService(logger, emailService);

        System.out.println("\n--- Processing Transactions ---");

        // Test 1: Successful UPI Payment
        System.out.println("\n[Test 1: UPI]");
        gateway.executeTransaction("UPI", 250.50, "john@okhdfcbank");

        // Test 2: Successful Card Payment
        System.out.println("\n[Test 2: CARD]");
        gateway.executeTransaction("CARD", 1500.00, "4532-1234-5678-9012");

        // Test 3: Successful Net Banking Payment
        System.out.println("\n[Test 3: NET_BANKING]");
        gateway.executeTransaction("NET_BANKING", 8900.75, "ACC-0987654321");

        // Test 4: Unsupported Payment Mode (Should gracefully fail and log)
        System.out.println("\n[Test 4: CRYPTO - Unsupported]");
        gateway.executeTransaction("CRYPTO", 50.00, "wallet-address-123");
    }
}
