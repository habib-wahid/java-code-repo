package designpattern.factory;

import designpattern.interfaces.Product;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ProductFactory {
    public static final Map<String, Supplier<Product>> products = new HashMap<>();

    public static void registerProduct(String type, Supplier<Product> supplier) {
        products.put(type, supplier);
    }

    public static Product getProduct(String type) {
        return products.get(type).get();
    }
}
