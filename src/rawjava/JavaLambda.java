package rawjava;

import java.util.List;

public class JavaLambda {
    public static void main(String[] args) {
        // why did java lambda come ? what's the philosophy?
        // Main application was to use lambda instead of anonymous class for single method interfaces
        List<Integer> numbers  = List.of(1, 2, 3, 4, 5);

        //printing with method reference
     //   numbers.forEach(System.out::println);

        numbers.stream()
                .reduce(0, (target, element) -> target + element);


        numbers.stream().map(val -> {
            var sqrNum =  val * val;
            return sqrNum % 2 == 0;
        }).forEach(System.out::println);


        numbers.stream()
                .map(JavaLambda::checkEven)
                .forEach(System.out::println);

    }

    public static boolean checkEven(int number) {
        return number % 2 == 0;
    }
}
