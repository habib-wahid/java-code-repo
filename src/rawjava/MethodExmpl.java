package rawjava;

class Man {
    String name;
    Integer age;

    Man(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    void canWalk() {
        System.out.println("Man can Walk");
    }

    int calculate(int x, int y) {
        int sum = x +y;
        return sum;
    }
}
public class MethodExmpl {
    public static void main(String[] args) {

    }
}
