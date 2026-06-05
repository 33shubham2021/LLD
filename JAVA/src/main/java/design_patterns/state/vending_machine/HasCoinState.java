package design_patterns.state.vending_machine;

public class HasCoinState implements VendingMachineState {
    @Override
    public void handleInsertCoin(VendingMachine vendingMachine) {
        System.out.println("ERROR: Already has coin");
    }

    @Override
    public void handleEjectCoin(VendingMachine vendingMachine) {
        System.out.println("Handling eject coin... Coin returned.");
        vendingMachine.setCoin(false);
        vendingMachine.setState(new NoCoinState());
    }

    @Override
    public void handlePressButton(VendingMachine vendingMachine) {
        System.out.println("Button pressed. Processing...");
        vendingMachine.setState(new DispensingState());

        // Automatically trigger dispense now that state has changed
        vendingMachine.dispense();
    }

    @Override
    public void handleDispense(VendingMachine vendingMachine) {
        System.out.println("ERROR: Press button first to dispense.");
    }
}