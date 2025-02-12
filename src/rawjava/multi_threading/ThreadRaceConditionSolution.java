package rawjava.multi_threading;


class RaceConditionRunnable implements Runnable {
    private int sum = 0;
    @Override
    public void run() {

        synchronized (this) {
            for (int i = 0; i < 10000000; i++) {
                sum += 1;
            }

            System.out.println(Thread.currentThread().getName() + ": " + sum);
        }

    }


}
public class ThreadRaceConditionSolution {

    //Race condition:
    // When two threads try to access the shared variable, then if they are not synchronized properly there will be problems
    // related to accessing the data. This is known the race condition.

    public static void main(String[] args) {

        RaceConditionRunnable raceConditionRunnable = new RaceConditionRunnable();
        Thread thread1 = new Thread(raceConditionRunnable, "Thread-1");
        Thread thread2 = new Thread(raceConditionRunnable, "Thread-2");

        thread1.start(); thread2.start();

    }
}
