package vending.machine.strategy;

import vending.machine.model.enums.PaymentStatus;

public class OnlinePaymentStrategy implements PaymentStrategy{
    @Override
    public PaymentStatus makePayment(double toPay, double paid) {
        System.out.println("Paid amount Rs." + (toPay) + ".");
        System.out.println("Returning Rs." + (paid-toPay) + "to source account");
        return PaymentStatus.SUCCESS;
    }
}
