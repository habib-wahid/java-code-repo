package rawjava;

@java.lang.FunctionalInterface
public interface FunctionalInterfaceExample {
    void canFly();
    default void breath() {
        System.out.println("Every living being can breath");
    }
}
