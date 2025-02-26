package rawjava.multi_threading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorThreadPoolExample {
    public static void main(String[] args) {
        int corePoolSize = 2;
        int maximumPoolSize = 4;
        long keepAliveTime = 10;
        TimeUnit unit = TimeUnit.SECONDS;
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(2);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                corePoolSize, maximumPoolSize, keepAliveTime, unit, arrayBlockingQueue);

        for (int i = 0; i <= 6; i++) {
            threadPoolExecutor.execute(new Task(i));
        }
    }
}

class Task implements Runnable {

    private int taskId;

    public Task(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + ": " + taskId);
        } catch (InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
