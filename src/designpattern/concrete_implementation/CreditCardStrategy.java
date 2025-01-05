package designpattern.concrete_implementation;

import designpattern.interfaces.PaymentStrategy;

public class CreditCardStrategy implements PaymentStrategy {
    @Override
    public void pay() {
        System.out.println("Payment will be processed using CreditCard");
    }
}
