package rawjava.multi_threading;

import java.util.concurrent.atomic.AtomicInteger;

class Counter implements Runnable {

    private AtomicInteger counter = new AtomicInteger(0);

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            counter.incrementAndGet();
        }

        System.out.println(Thread.currentThread().getName() + ": " + counter);
    }
}
public class AtomicExample {

    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread t1 = new Thread(counter, "Thread-1");
        Thread t2 = new Thread(counter, "Thread-2");
        t1.start(); t2.start();
    }
}
