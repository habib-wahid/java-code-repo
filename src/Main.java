import javax.swing.tree.TreeNode;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
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

        UUID uuid = UUID.fromString("abc-def-ghi-jkl");
        System.out.println(uuid);
        String s = "i am   habib";
        String rep = s.replace(" ", "");
        System.out.println(Integer.MIN_VALUE);
        System.out.println(s.toUpperCase());


        int[] arr = new int[20];
        System.out.println(arr[0]);


    }

}