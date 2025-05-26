package stream;

import java.util.Arrays;
import java.util.List;

class Test {
    Integer t;
    static int st;

    static {
        st = 10;
        System.out.println("Static " + st);
    }

    Test() {
        System.out.println("test class");
    }

    @Override
    public String toString() {
        return "Test {t=" + t + ", st=" + st + "}";
    }
}

public class StreamApiExample {

    public static void main(String[] args) {
        // stream laziness check
      //  checkLaziness();

        Test test = new Test();
        System.out.println(test.t + " " + test);

        int n = 5;
        boolean b = n % 2 == 0;

        String paymentType = b == true ? "Bank" : "Cash";

//        if (paymentType.equals("Bank")) {
//            paymentThroughBank();
//        } else if (paymentType.equals("CreditCard")) {
//            paymentThroughCard();
//        } else {
//            paymentThroughCash();
//        }


    }

    private static void checkLaziness() {
        int[] factor = new int[] {2};

        var numbers = List.of(1,2,3);

        var numberStream = numbers.stream()
                .map(number -> number * factor[0]);
        factor[0] = 0;

        numberStream.forEach(System.out::print);
    }
}
