package design_patterns.state.vending_machine;


public class VendingMachineController {


    public static void main(String[] args) {
        System.out.println("=== 🏪 STARTING VENDING MACHINE TEST ===\n");

        // Initialize the machine with exactly 2 items
        VendingMachine machine = new VendingMachine(2);

        System.out.println("--- TEST 1: The Happy Path (Normal Purchase) ---");
        // State: NoCoin -> HasCoin -> Dispensing -> NoCoin
        machine.insertCoin();
        machine.pressButton();
        System.out.println("Current Inventory: " + machine.getInventory() + "\n");

        System.out.println("--- TEST 2: Changing Mind (Ejecting Coin) ---");
        // State: NoCoin -> HasCoin -> NoCoin
        machine.insertCoin();
        machine.ejectCoin();
        System.out.println("Current Inventory: " + machine.getInventory() + "\n");

        System.out.println("--- TEST 3: Invalid Actions in NoCoinState ---");
        // State: NoCoin (Should stay in NoCoin and show errors)
        machine.ejectCoin();
        machine.pressButton();
        machine.dispense(); // Should fail because we haven't paid
        System.out.println("\n");

        System.out.println("--- TEST 4: Invalid Actions in HasCoinState ---");
        // State: NoCoin -> HasCoin
        machine.insertCoin();
        // Try to insert a second coin (Should fail)
        machine.insertCoin();
        // Try to dispense before pressing the button (Should fail)
        machine.dispense();
        System.out.println("\n");

        System.out.println("--- TEST 5: Depleting the Inventory ---");
        // State: HasCoin (from Test 4) -> Dispensing -> OutOfStock
        System.out.println("Pressing button to buy the last item...");
        machine.pressButton();
        System.out.println("Current Inventory: " + machine.getInventory() + "\n");

        System.out.println("--- TEST 6: OutOfStock Behavior ---");
        // State: OutOfStock (Should reject all interactions)
        machine.insertCoin();
        machine.ejectCoin();
        machine.pressButton();

        System.out.println("\n=== ✅ TEST COMPLETE ===");
    }
}
