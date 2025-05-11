package designpattern.observer;

import designpattern.observable.StockObservable;

public class MessageObserver implements Observer{

    private StockObservable stockObservable;
    public MessageObserver(StockObservable stockObservable) {
        this.stockObservable = stockObservable;
    }

    @Override
    public void update() {
        System.out.println("MessageObserver update " + stockObservable.getStock());
    }
}
