package cases.coffee.vending.machine.model;

public enum Coin {
    ONE(1),
    TWO(2),
    FIVE(5),
    TEN(10),
    TWENTY(20);

    private final Integer value;

    Coin(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
