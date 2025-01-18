package designpattern;

import designpattern.concrete_implementation.ProductA;
import designpattern.concrete_implementation.ProductB;
import designpattern.factory.ProductFactory;
import designpattern.interfaces.Product;

public class FactoryClient {
    public static void main(String[] args) {
        ProductFactory.registerProduct("A", ProductA::new);
        ProductFactory.registerProduct("B", ProductB::new);

        Product productA = ProductFactory.getProduct("A");
        Product productB = ProductFactory.getProduct("B");

        productA.createProduct();
        productB.createProduct();
    }
}
