import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
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
        String start = "09:00";
        LocalTime time = LocalTime.parse(start);
        System.out.println(time); // Output: 09:00

        LocalDateTime dateTime = LocalDateTime.now().plusHours(5);
        System.out.println(dateTime.with(time));

        List<Integer> lst = new ArrayList<>();
        lst.add(1);
        lst.add(5);
        lst.add(3);

        System.out.println(lst);

        lst.sort((o1, o2) -> o1 - o2);

        System.out.println(lst);

    }

}