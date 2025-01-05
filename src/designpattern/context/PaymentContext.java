package designpattern.context;

import designpattern.interfaces.PaymentStrategy;

public class PaymentContext {
    private final PaymentStrategy paymentStrategy;
    public PaymentContext(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void processPayment() {
        if (paymentStrategy != null) {
            paymentStrategy.pay();
        } else {
            throw new RuntimeException("Payment strategy is null");
        }
    }
}
