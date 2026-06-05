package design_patterns.state.vending_machine;

public interface VendingMachineState {
    void handleInsertCoin(VendingMachine vendingMachine);

    void handleEjectCoin(VendingMachine vendingMachine);

    void handlePressButton(VendingMachine vendingMachine);

    void handleDispense(VendingMachine vendingMachine);
}
