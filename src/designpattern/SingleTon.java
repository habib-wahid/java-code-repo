package designpattern;

class SingleTonEager {
    private static SingleTonEager singleTonEager = new SingleTonEager();
    private SingleTonEager() {}

    public static SingleTonEager getInstance() {
        System.out.println("Eargerly Initialized");
        return singleTonEager;
    }

    // SO the problem here is that object gets initialized even though it's not beign called.
}

class SingleTonLazy {
    private static SingleTonLazy singleTonLazy;
    private SingleTonLazy() {}
    public static SingleTonLazy getInstance() {
        System.out.println("Lazy Initialized");
        if (singleTonLazy == null) {
            singleTonLazy = new SingleTonLazy();
            return singleTonLazy;
        }

        return singleTonLazy;
    }
    //So here the problem is if multiple threads try to access the method it may create multiple instance
}

class SingleTonSynchronized {
    private static SingleTonSynchronized singleTonSynchronized;
    private SingleTonSynchronized() {}
    synchronized public static SingleTonSynchronized getInstance() {
        System.out.println("Synchronized Initialized");
        if (singleTonSynchronized == null) {
            singleTonSynchronized = new SingleTonSynchronized();
            return singleTonSynchronized;
        }
        return singleTonSynchronized;
    }

    //Here the problem is synchronized block. It would be extremely slow in multithreaded environment
}

class SingleTonDoubleCheckLock {
    private static volatile SingleTonDoubleCheckLock singleTonDoubleCheckLock;
    private SingleTonDoubleCheckLock() {}
    public static SingleTonDoubleCheckLock getInstance() {
        if (singleTonDoubleCheckLock == null) {
            synchronized (SingleTonDoubleCheckLock.class) {
                singleTonDoubleCheckLock = new SingleTonDoubleCheckLock();
            }
        }
        return singleTonDoubleCheckLock;
    }
}

class SingleTonBillPugh {
    private SingleTonBillPugh() {}
    private static class SingleTonHelper {
        private static final SingleTonBillPugh SINGLE_TON = new SingleTonBillPugh();
    }

    public static SingleTonBillPugh getInstance() {
        System.out.println("Bill Pugh Initialized");
        return SingleTonHelper.SINGLE_TON;
    }
}
public class SingleTon {
    public static void main(String[] args) {
        SingleTonEager singleTonEager = SingleTonEager.getInstance();
        SingleTonLazy singleTonLazy = SingleTonLazy.getInstance();
        SingleTonSynchronized singleTonSynchronized = SingleTonSynchronized.getInstance();
        SingleTonBillPugh singleTonBillPugh = SingleTonBillPugh.getInstance();
    }
}
