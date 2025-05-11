package designpattern;

import designpattern.observable.IPhoneStockObservable;
import designpattern.observable.StockObservable;
import designpattern.observer.EmailObserver;
import designpattern.observer.MessageObserver;
import designpattern.observer.Observer;

public class ObserverPatternImpl {
    public static void main(String[] args) {
        StockObservable stockObservable = new IPhoneStockObservable();
        Observer messageObserver = new MessageObserver(stockObservable);
        Observer emailObserver = new EmailObserver(stockObservable);


        stockObservable.add(messageObserver);
        stockObservable.add(emailObserver);

        stockObservable.setStock(10);

    }
}
