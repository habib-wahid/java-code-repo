package thread;

class MyThread implements Runnable {

    @Override
    public void run() {

    }
}

public class VolatileExample {

    private boolean running = true;

    public void start() {
       new Thread(() ->  {

           int count = 0;
           while(running) {
              count++;
           }
           System.out.println("Thread stopped. Count: " + count);
       }).start();
    }

    public void stop() {
        running = false;
    }

    static void main() throws InterruptedException {

        double a = 0.1;
        double b = 0.2;
      //  System.out.println(a + b);

        VolatileExample ve = new VolatileExample();
        ve.start();
        Thread.sleep(3000);

        ve.stop();
     //   new Thread(ve::stop).start();
    }
}
