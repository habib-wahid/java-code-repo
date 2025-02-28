package rawjava.multi_threading;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class JavaLockImpl {

    public static void tryReentrantLock() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        LockCounter counter = new LockCounter();
        for (int i = 0; i < 1000000; i++) {
            executorService.execute(counter);
        }
    }

    public static void lockMethodsImpl() {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        TickedBookWithLock tickedBookWithLock = new TickedBookWithLock(3);
        for (int i = 1; i <= 3; i++) {
            String user = "user-" + i;
            if (i == 1) {
                executorService.execute(() -> tickedBookWithLock.ticketBookWithLock(user));
            } else if (i == 2) {
                executorService.execute(() -> tickedBookWithLock.tickedBookWithTryLock(user));
            } else {
                executorService.execute(() -> tickedBookWithLock.ticketBookWithTryLockTimeout(user));
            }
        }
    }

    public static void main(String[] args) {
       // tryReentrantLock();
        lockMethodsImpl();
    }
}


class LockCounter implements Runnable {
    ReentrantLock lock = new ReentrantLock();
    private int count = 0;

    @Override
    public void run() {
        try {
            lock.lock();
            count++;
            System.out.println(Thread.currentThread().getName() + ": " + count);
        } finally {
            lock.unlock();
        }
    }
}

class TickedBookWithLock {
    private ReentrantLock lock = new ReentrantLock();
    private int availableTickets;
    public TickedBookWithLock(int availableTickets) {
        this.availableTickets = availableTickets;
    }

    public void ticketBookWithLock(String user) {
        try {
            lock.lock();
            if (availableTickets > 0) {
                Thread.sleep(3000);
                availableTickets--;
                System.out.println(user + "got the ticket with available tickets: " + availableTickets);
            } else {
                System.out.println(user + "got no tickets");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public void tickedBookWithTryLock(String user) {
        if (lock.tryLock()) {
            try {
                if (availableTickets > 0) {
                    availableTickets--;
                    System.out.println(user + "got the ticket with available tickets: " + availableTickets);
                } else {
                    System.out.println(user + "got no tickets");
                }
            } finally {
                lock.unlock();
            }
        } else {
            System.out.println(user + "not agreed to queue in line");
        }
    }

    public void ticketBookWithTryLockTimeout(String user) {
        try {
            if (lock.tryLock(2, TimeUnit.SECONDS)) {
                try {
                    if (availableTickets > 0) {
                        availableTickets--;
                        System.out.println(user + "got the ticket with available tickets: " + availableTickets);
                    } else {
                        System.out.println(user + "got no tickets");
                    }
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println(user + "not able to stand in line more than 2 seconds");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}