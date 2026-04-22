package oop;

class Animal {
    public Animal() {
        System.out.println("Animal constructor");
        makeSound();
    }

    public void makeSound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {
    private String name = "Buddy";

    public Dog() {
        System.out.println("Dog constructor");
        System.out.println("Name: " + name);
    }

    @Override
    public void makeSound() {
        System.out.println("Dog barks: " + name);
    }
}

public class OverloadExample {

    static void main() {
       new Dog();
    }
}
