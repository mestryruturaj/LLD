package vending.machine.strategy;

import vending.machine.model.enums.PaymentStatus;

public class OfflinePaymentStrategy implements PaymentStrategy{
        @Override
        public PaymentStatus makePayment(double toPay, double paid) {
            System.out.println("Paid amount Rs." + toPay + ".");
            System.out.println("Returning change of Rs." + (paid-toPay) + ".");
            return PaymentStatus.SUCCESS;
        }
}
