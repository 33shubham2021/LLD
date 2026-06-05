package design_patterns.state.vending_machine;

public class DispensingState implements VendingMachineState {
    @Override
    public void handleInsertCoin(VendingMachine vendingMachine) {
        System.out.println("Wait: Currently dispensing.");
    }

    @Override
    public void handleEjectCoin(VendingMachine vendingMachine) {
        System.out.println("Wait: Currently dispensing. Cannot eject coin now.");
    }

    @Override
    public void handlePressButton(VendingMachine vendingMachine) {
        System.out.println("Wait: Already dispensing.");
    }

    @Override
    public void handleDispense(VendingMachine vendingMachine) {
        vendingMachine.releaseItem();
        vendingMachine.setCoin(false);

        // Check inventory to determine the next state
        if (vendingMachine.getInventory() > 0) {
            vendingMachine.setState(new NoCoinState());
        } else {
            System.out.println("Machine is now out of stock.");
            vendingMachine.setState(new OutOfStockState());
        }
    }
}