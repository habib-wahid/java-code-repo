package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {
    static void main() {
        int coreCount = Runtime.getRuntime().availableProcessors();
        System.out.println("Core Count: " + coreCount);
        ExecutorService executorService = Executors.newFixedThreadPool(coreCount);

        for (int i = 0; i < 100; i++) {
            executorService.execute(new MyRunnable());
        }
    }

    static class MyRunnable implements Runnable {
        @Override
        public void run() {
//            try {
//                Thread.sleep(20);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }

            System.out.println("Thread Name: " + Thread.currentThread().getName() + "");
        }
    }
}
