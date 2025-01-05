package rawjava.multi_threading;

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        System.out.println("MyRunnable is running.");
    }
}

class MyThread extends Thread {
    public void run() {
        System.out.println("Thread extending " + Thread.currentThread().getName());
    }
}

public class ThreadCreationExample {
    public static void main(String[] args) {
        System.out.println("Thread is starting " + Thread.currentThread().getName());
        Thread thread = new Thread(new MyRunnable());
        thread.start();

        MyThread myThread = new MyThread();
        myThread.start();
    }
}
