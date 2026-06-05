package design_patterns.state.vending_machine;

public class NoCoinState implements VendingMachineState {
    @Override
    public void handleInsertCoin(VendingMachine vendingMachine) {
        System.out.println("handling insert coin in NoCoinState");
        vendingMachine.setCoin(true);
        vendingMachine.setState(new HasCoinState());
    }

    @Override
    public void handleEjectCoin(VendingMachine vendingMachine) {
        System.out.println("ERROR : Do not have any coin to eject");
    }

    @Override
    public void handlePressButton(VendingMachine vendingMachine) {
        System.out.println("ERROR :No coins to process");
    }

    @Override
    public void handleDispense(VendingMachine vendingMachine) {
        System.out.println("ERROR : No Coins to process");
    }
}
