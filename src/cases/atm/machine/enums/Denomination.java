package cases.atm.machine.enums;

public enum Denomination {
    ONE_HUNDRED(100),
    TWO_HUNDRED(200),
    FIVE_HUNDRED(500),
    TWO_THOUSAND(2000);

    private final int value;

    public int getValue() {
        return this.value;
    }

    Denomination(int value) {
        this.value = value;
    }
}
