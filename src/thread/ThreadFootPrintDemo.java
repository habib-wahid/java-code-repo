package thread;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadFootPrintDemo {

    public static void main(String[] args) {
        int taskCount = 10_000;

        Instant plInstant = Instant.now();

        try (ExecutorService platformExecutor = Executors.newFixedThreadPool(10000)) {
            for (int i = 0; i < taskCount; i++) {
                platformExecutor.submit(() -> {
                    simulateBlockingIO();
                });
            }

        }

        System.out.println(
                "Total Time taken by platform threads: " + Duration.between(plInstant, Instant.now()).toMillis());

        Instant vrInstant = Instant.now();

        try (ExecutorService virtuaExecutorService = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < taskCount; i++) {
                virtuaExecutorService.submit(() -> {
                    simulateBlockingIO();
                });

            }
        }

        System.out.println(
                "Total Time taken by virtual threads: " + Duration.between(vrInstant, Instant.now()).toMillis());

    }

    private static void simulateBlockingIO() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }

}
