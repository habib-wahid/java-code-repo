package rawjava;
interface HttpStatus {
    int OK = 200;
    int CREATED = 201;
    int NOT_FOUND = 404;
    int UNAUTHORIZED = 401;
    int UNAUTHENTICATED = 403;
}
interface Animal {
    void sound();

    default void breathe() {
        inhale(); exhale();
    }

    static void info() {
        System.out.println("Animal info");
    }

    private void inhale() {
        System.out.println("Animal inhale");
    }

    private void exhale() {
        System.out.println("Animal exhale");
    }
}
public class Dog implements Animal{
    public static void main(String[] args) {
        Animal.info();
        Dog dog = new Dog();
        dog.breathe();

        //printing interface declared values

        System.out.println(HttpStatus.UNAUTHENTICATED);
    }

    @Override
    public void sound() {
        System.out.println("Dog sound");
    }
}
