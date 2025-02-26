package rawjava.multi_threading;

import java.util.concurrent.*;

public class ExecutorExample {

    public static void FixedThreadPool() {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            executorService.execute(new FixedTask(i));
        }

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
                System.out.println("here");
                executorService.shutdownNow();
            } else {
                System.out.println("tasks are running");
            }
        } catch (InterruptedException e) {
            System.out.println("Forcing shutdown");
            executorService.shutdownNow();
        }
    }

    public static void CachedThreadPool() {
        try {
            ExecutorService executorService = Executors.newCachedThreadPool();
            for (int i = 0; i < 1000; i++) {
                executorService.execute(new FixedTask(i));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void SingleThreadPool() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 1000; i++) {
            executorService.execute(new FixedTask(i));
        }
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FixedThreadPool();
        CachedThreadPool();
        SingleThreadPool();
    }
}

class FixedTask implements Runnable {

    private int taskId;
    public FixedTask(int taskId) {
        this.taskId = taskId;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
           // throw new RuntimeException(e);
            System.out.println("Interrupted task " + taskId);
        }
        System.out.println(Thread.currentThread().getName() + " " + "performing task"+ taskId);
    }
}

class CallableTask implements Callable<String> {
    private int taskId;
    public CallableTask(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(2000);
        return "Task " + taskId;
    }
}


