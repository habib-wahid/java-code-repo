package rawjava.multi_threading;

class SharedResource {
    private int synchronizedMethodcounter = 0;
    public synchronized void synchronizedMethodIncrement() {
        synchronizedMethodcounter++;
        System.out.println(Thread.currentThread().getName() + " " + synchronizedMethodcounter);
    }

    private int synchronizedBlockCounter = 0;
    public void synchronizedBlockIncrement() {
        synchronized (this) {
            synchronizedBlockCounter++;
            System.out.println(Thread.currentThread().getName() + " " + synchronizedBlockCounter);
        }

    }

    private static int staticSynchronizedBlockCounter = 0;

    public static void staticSynchronizedBlockIncrement() {
        synchronized (SharedResource.class) {
            staticSynchronizedBlockCounter++;
        }
    }


}
public class SynchronizedExample {

    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
        Runnable runnable = () -> {
            for (int i = 0; i < 100000; i++) {
                sharedResource.synchronizedMethodIncrement();
            }
        };

        Thread t1 = new Thread(runnable, "thread-1");
        Thread t2 = new Thread(runnable, "thread-2");

        t2.start(); t1.start();

        Runnable runnable2 = () -> {
            for (int i = 0; i < 100000; i++) {
                sharedResource.synchronizedBlockIncrement();
            }
        };

        Thread t3 = new Thread(runnable2, "thread-3");
        Thread t4 = new Thread(runnable2, "thread-4");
       // t3.start(); t4.start();
    }
}
