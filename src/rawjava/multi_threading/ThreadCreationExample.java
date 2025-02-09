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

    private static Thread threadJoin() {
        return new Thread(() -> {
            System.out.println("Started making sauce");

            try {
                System.out.println("waiting for the sauce to complete");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }


    private static void virtualThread() {
        for (int i = 0; i < 100000; i++) {
            int finalI = i;
            Thread.ofVirtual().start(() -> {
                int sum = 0;
                for (int j = 0; j < 10; j++) {
                    sum += j;
                }
                System.out.println("Thread " + Thread.currentThread().getName() + finalI +": " + sum);
            });
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyRunnable runnable = new MyRunnable();
        Thread thread1 = new Thread(runnable);
        //thread1.start();

        Thread thread2 = new Thread(runnable);
     //   thread2.start();

        System.out.println("Main thread ");
        Thread.sleep(2000);
       // System.out.println("Main thread ends");

        Thread sauceThread = threadJoin();
    //    sauceThread.start();

        //sauceThread.join();

        System.out.println("Main thread ends");

        // virtual thread


        virtualThread();

    }
}
