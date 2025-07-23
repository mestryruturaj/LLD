package cases.atm.machine.model;

import java.time.LocalDate;

public class Card {
    private final String cardNumber;
    private final String userName;
    private final LocalDate validFrom;
    private final LocalDate validTo;
    private final int cvv;

    public Card(String cardNumber, String userName, int cvv) {
        this.cardNumber = cardNumber;
        this.userName = userName;
        this.cvv = cvv;
        this.validFrom = LocalDate.now();
        this.validTo = LocalDate.now().plusYears(5);
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getUserName() {
        return userName;
    }

    public LocalDate getValidFrom() {
        return validFrom;
    }

    public LocalDate getValidTo() {
        return validTo;
    }

    public int getCvv() {
        return cvv;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardNumber='" + cardNumber + '\'' +
                ", userName='" + userName + '\'' +
                ", validFrom=" + validFrom +
                ", validTo=" + validTo +
                '}';
    }
}
