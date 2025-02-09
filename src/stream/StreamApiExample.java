package stream;

import java.util.Arrays;
import java.util.List;

public class StreamApiExample {

    public static void main(String[] args) {
        // stream laziness check
        checkLaziness();
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
