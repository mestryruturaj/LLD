package cases.atm.machine.exception;

public class AtmException extends RuntimeException {
    public AtmException() {
    }

    public AtmException(String message) {
        super(message);
    }
}
