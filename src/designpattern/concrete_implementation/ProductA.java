package designpattern.concrete_implementation;

import designpattern.interfaces.Product;

public class ProductA implements Product {
    @Override
    public void createProduct() {
        System.out.println("Creating product A");
    }
}
