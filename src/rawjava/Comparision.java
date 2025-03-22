package rawjava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student implements Comparable<Student>{
    int id;
    String name;
    int age;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student [id = " + id + ", name = " + name + ", age = " + age + "]";
    }

    @Override
    public int compareTo(Student o) {
        return o.age - this.age;
    }
}
public class Comparision {

    public static void main(String[] args) {

        Comparator<Student> comparator = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.age - o2.age;
            }
        };

        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "John", 15));
        students.add(new Student(2, "Jane", 12));
        students.add(new Student(3, "Jack", 20));

        // Using comparable
       // Collections.sort(students);
        System.out.println(students);

        // Using comparator

        Collections.sort(students, Comparator.comparingInt(Student::getAge));
        System.out.println(students);
    }
}
