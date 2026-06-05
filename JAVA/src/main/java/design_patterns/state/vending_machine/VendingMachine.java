package design_patterns.state.vending_machine;

public class VendingMachine {

    private VendingMachineState state;
    private boolean coin;
    private int inventory; // Added to track stock

    public VendingMachine(int inventory) {
        this.inventory = inventory;
        this.coin = false;

        // Initial state depends on inventory
        if (this.inventory > 0) {
            this.state = new NoCoinState();
        } else {
            this.state = new OutOfStockState();
        }
    }

    public void insertCoin() {
        state.handleInsertCoin(this);
    }

    public void ejectCoin() {
        state.handleEjectCoin(this); // Added delegation
    }

    public void pressButton() {
        state.handlePressButton(this); // Added delegation
    }

    public void dispense() {
        state.handleDispense(this); // Added delegation
    }

    // Helper method to physically release the item and reduce inventory
    public void releaseItem() {
        System.out.println("📦 A product comes rolling out the slot...");
        if (inventory > 0) {
            inventory--;
        }
    }

    public void setState(VendingMachineState state) {
        this.state = state;
    }

    public void setCoin(boolean coin) {
        this.coin = coin;
    }

    public int getInventory() {
        return inventory;
    }
}
