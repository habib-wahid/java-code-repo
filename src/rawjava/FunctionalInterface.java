package rawjava;

import java.util.function.Consumer;

public class FunctionalInterface{
    public static void main(String[] args) {
        FunctionalInterfaceExample obj =
                () -> System.out.println("This object can fly");

        obj.canFly();

        Consumer<Integer> consumer = (Integer t) -> {
            if (t % 2 == 0) {
                System.out.println("Even number");
            } else {
                System.out.println("Odd number");
            }
        };

        consumer.accept(6);
    }

}
