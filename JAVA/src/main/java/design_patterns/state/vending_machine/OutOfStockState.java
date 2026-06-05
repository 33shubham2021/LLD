package design_patterns.state.vending_machine;

public class OutOfStockState implements VendingMachineState {
    @Override
    public void handleInsertCoin(VendingMachine vendingMachine) {
        System.out.println("ERROR: Out of stock. Coin rejected and returned.");
    }

    @Override
    public void handleEjectCoin(VendingMachine vendingMachine) {
        System.out.println("ERROR: No coin to eject.");
    }

    @Override
    public void handlePressButton(VendingMachine vendingMachine) {
        System.out.println("ERROR: Out of stock.");
    }

    @Override
    public void handleDispense(VendingMachine vendingMachine) {
        System.out.println("ERROR: Out of stock.");
    }
}