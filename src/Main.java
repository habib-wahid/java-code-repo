import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        BigDecimal a = new BigDecimal("100");
        BigDecimal b = new BigDecimal("10");
        System.out.println(a.compareTo(b));

        Integer c = 150;
        Integer d = 150;
        System.out.println(c == d);
    }
}