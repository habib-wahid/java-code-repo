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
           while(running) {
               System.out.println("Running");
           }
       }).start();
    }

    public void stop() {
        running = false;
    }

    static void main() {

        double a = 0.1;
        double b = 0.2;
        System.out.println(a + b);

//        VolatileExample ve = new VolatileExample();
//        ve.start();
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        ve.stop();
    }
}
