package rawjava.multi_threading;

class MyRunnable implements Runnable {

    private int counter = 0;
    @Override
    public void run() {
        for (int i = 0; i < 1_000_000; i++) {
            counter++;
        }
        System.out.println(Thread.currentThread().getName() + ": " + counter);
    }
}

class MyThread extends Thread {
    public void run() {
        System.out.println("Thread extending " + Thread.currentThread().getName());
    }
}

public class ThreadCreationExample {
    public static void main(String[] args) {
        MyRunnable runnable = new MyRunnable();
        Thread thread1 = new Thread(runnable);
        thread1.start();

        Thread thread2 = new Thread(runnable);
        thread2.start();

    }
}
