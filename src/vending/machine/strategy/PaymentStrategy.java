package vending.machine.strategy;

import vending.machine.model.enums.PaymentStatus;

public interface PaymentStrategy {
    public PaymentStatus makePayment(double toPay, double paid);
}
