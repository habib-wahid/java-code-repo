import java.math.BigDecimal;

public class Main {
    static void main(String[] args) {
        System.out.println(testFinally());
    }


    public static int testFinally() {
        try {
            System.out.println("Try block");
            return 1;
        } catch (Exception e) {
            System.out.println("Catch block");
            return 2;
        } finally {
            System.out.println("Finally block executes before return!");
            return 3;
        }
    }

}