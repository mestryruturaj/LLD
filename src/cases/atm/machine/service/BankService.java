package cases.atm.machine.service;

import cases.atm.machine.exception.AtmException;
import cases.atm.machine.model.Card;

public class BankService {

    public void authenticate(Card card, String pin) {
        if (!validatePin(pin)) {
            throw new AtmException("INVALID_PIN");
        }

        if (!verifyAuthentication(card.getCardNumber(), pin)) {
            throw new AtmException("INCORRECT_CREDENTIALS");
        }
    }

    private boolean validatePin(String pin) {
        if (pin.length() != 4) {
            return false;
        }
        for (char ch : pin.toCharArray()) {
            if (!Character.isDigit(ch)) {
                return false;
            }
        }

        return true;
    }

    private boolean verifyAuthentication(String cardNumber, String pin) {
        return true;
    }

    public void withdrawCash(Card card, int amount) {
        System.out.println("Cash withdrawn from bank.");
    }

    public void depositCash(Card card, int amount) {
        System.out.println("Cash deposited in bank.");
    }
}
