package designpattern.concrete_implementation;

import designpattern.interfaces.PaymentStrategy;

public class DebitCardStrategy implements PaymentStrategy {
    @Override
    public void pay() {
        System.out.println("Payment will be processed using DebitCard");
    }
}
