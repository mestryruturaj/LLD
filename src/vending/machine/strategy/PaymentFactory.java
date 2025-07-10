package vending.machine.strategy;

import vending.machine.exception.VendingMachineException;
import vending.machine.model.enums.PaymentType;

import java.util.HashMap;
import java.util.Map;

import static vending.machine.model.enums.PaymentType.OFFLINE;
import static vending.machine.model.enums.PaymentType.ONLINE;

public class PaymentFactory {
    Map<PaymentType, PaymentStrategy> paymentStrategyMap;

    public PaymentFactory() {
        this.paymentStrategyMap = new HashMap<>();
        this.paymentStrategyMap.put(ONLINE, new OnlinePaymentStrategy());
        this.paymentStrategyMap.put(OFFLINE, new OfflinePaymentStrategy());
    }

    public PaymentStrategy getPaymentStrategy(PaymentType paymentType) {
        if (paymentStrategyMap.containsKey(paymentType)) {
            return paymentStrategyMap.get(paymentType);
        }
        throw new VendingMachineException("PAYMENT_TYPE_UNAVAILABLE: The selected payment method is unavailable. Try other payment method.");
    }
}
