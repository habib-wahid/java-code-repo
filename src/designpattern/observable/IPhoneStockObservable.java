package designpattern.observable;

import designpattern.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class IPhoneStockObservable implements StockObservable {
    List<Observer> observers;
    public int stockCount;

    public IPhoneStockObservable() {
        observers = new ArrayList<>();
        stockCount = 0;
    }

    @Override
    public void add(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void remove(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    @Override
    public void setStock(int stock) {
        if (stockCount + stock > stockCount) {
            this.stockCount += stock;
            notifyObservers();
        }
    }

    @Override
    public int getStock() {
        return stockCount;
    }
}
