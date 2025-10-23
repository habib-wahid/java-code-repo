package designpattern.decorator;

interface Coffee {
    String getCoffee();
    double getCost();
}

class SimpleCoffee implements Coffee {
    @Override
    public String getCoffee() {
        return "Simple Coffee";
    }

    @Override
    public double getCost() {
        return 100;
    }
}

abstract class CoffeeDecorator implements Coffee {
    protected Coffee coffee;
    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String getCoffee() {
        return coffee.getCoffee();
    }

    @Override
    public double getCost() {
        return coffee.getCost();
    }
}

class Cappuccino extends CoffeeDecorator {
    public Cappuccino(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getCoffee() {
        return "Cappuccino";
    }

    @Override
    public double getCost() {
        return super.getCost() + 10;
    }
}
public class DecoratorMain {

    static void main() {
        SimpleCoffee coffee = new SimpleCoffee();
        System.out.println( coffee.getCoffee() + " costs " + coffee.getCost());

        Coffee cappuccino = new Cappuccino(coffee);
        System.out.println( cappuccino.getCoffee() + " costs " + cappuccino.getCost());
    }
}
