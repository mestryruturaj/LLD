package cases.vending.machine.exception;

public class VendingMachineException extends RuntimeException {
    public VendingMachineException(String message) {
        super(message);
    }

    public VendingMachineException() {
        super();
    }
}
