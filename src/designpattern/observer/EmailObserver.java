package designpattern.observer;

import designpattern.observable.StockObservable;

public class EmailObserver implements Observer {

    private StockObservable stockObservable;
    public EmailObserver(StockObservable stockObservable) {
        this.stockObservable = stockObservable;
    }

    @Override
    public void update() {
        System.out.println("Stock updated to " + stockObservable.getStock());
    }
}
