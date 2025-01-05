package designpattern.concrete_implementation;

import designpattern.interfaces.PaymentStrategy;

public class PayPalStrategy implements PaymentStrategy {
    @Override
    public void pay() {
        System.out.println("Payment will be processed using PayPal");
    }
}
