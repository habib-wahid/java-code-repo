package thread;

public class TestVolatile {
    private volatile int counter = 0;

    public void increment() {
        System.out.println("Thread " + Thread.currentThread().getName() + ": " + counter + "");
        counter++;
    }

    static void main() {

        TestVolatile testVolatile = new TestVolatile();
        Runnable runnable1 = () -> {
            for (int i = 0; i < 1000; i++) {
                testVolatile.increment();
            }
        };

        Runnable runnable2 = () -> {
            for (int i = 0; i < 1000; i++) {
                testVolatile.increment();
            }
        };

        Thread t1 = new Thread(runnable1);
        Thread t2 = new Thread(runnable2);

        t1.start(); t2.start();

    }
}
