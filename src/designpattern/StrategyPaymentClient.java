package designpattern;


import designpattern.concrete_implementation.CreditCardStrategy;
import designpattern.concrete_implementation.DebitCardStrategy;
import designpattern.concrete_implementation.PayPalStrategy;
import designpattern.context.PaymentContext;

public class StrategyPaymentClient {
    public static void main(String[] args) {
        PaymentContext payPalPaymentContext = new PaymentContext(new PayPalStrategy());
        payPalPaymentContext.processPayment();

        PaymentContext debitCardPaymentContext = new PaymentContext(new DebitCardStrategy());
        debitCardPaymentContext.processPayment();

        PaymentContext creditCardPaymentContext = new PaymentContext(new CreditCardStrategy());
        creditCardPaymentContext.processPayment();
    }
}
