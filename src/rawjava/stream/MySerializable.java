package rawjava.stream;

import java.io.*;

class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;
    transient int height;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }
}
public class MySerializable {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person person = new Person("John Doe", 30);
        FileOutputStream fileOutputStream = new FileOutputStream("serialization.txt");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
        outputStream.writeObject(person);
        outputStream.close();

        FileInputStream fileInputStream = new FileInputStream("serialization.txt");
        ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
        Person person1 = (Person) inputStream.readObject();
        System.out.println(person1.getAge() + " " + person1.getName());
    }
}
