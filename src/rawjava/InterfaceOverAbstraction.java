package rawjava;

interface Payment{

    int amount = 100;

    void pay();

    default void payWithCash() {
        System.out.println("Cash Payment");
    }
}

class BkashPayment implements Payment{
    @Override
    public void pay() {
        System.out.println("Bkash Payment" + amount);
    }
}

class RocketPayment implements Payment{

    @Override
    public void pay() {
        System.out.println("Rocket Payment" + amount);
    }

    @Override
    public void payWithCash() {
        System.out.println("Cash Payment, Rocket is not available");
    }
}

public class InterfaceOverAbstraction {

    public static void main(String[] args) {
        Payment payment = new RocketPayment();
        payment.pay();
        payment.payWithCash();
    }
}
