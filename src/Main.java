import java.math.BigDecimal;
import java.util.function.Function;
import java.util.function.Supplier;

class TestFunction implements Function<Integer, BigDecimal> {
    @Override
    public BigDecimal apply(Integer t) {
        return BigDecimal.valueOf(t * 2);
    }
}




public class Main {
    static void main(String[] args) {
        Supplier<String> supplier = () -> "Hello";
        System.out.println(supplier.get());
    }


}