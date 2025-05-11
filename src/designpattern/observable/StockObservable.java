package designpattern.observable;

import designpattern.observer.Observer;

public interface StockObservable {
    void add(Observer observer);
    void remove(Observer observer);
    void notifyObservers();
    void setStock(int stock);
    int getStock();
}
