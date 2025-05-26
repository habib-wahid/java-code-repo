package rawjava;


class Students {
    String name;
    Integer age;
    String dept;

    protected Students() {
    }
    //Copy constructor

    //Constructor

  //  1. Parameterized constructor
//    public Students(String name, int age, String dept) {
//        this.name = name;
//        this.age = age;
//        this.dept = dept;
//    }

   // 2. Non parameterized constructor
//    public Students() {
//        name = "Rahim";
//    }

    //Method
//    public Students(Students s) {
//        this.name = s.name;
//        this.age = s.age;
//        this.dept = s.dept;
//    }

    void read () {
        System.out.println(name + "is reading");
    }
}

public class ClassExample {


    public static void main(String[] args) {
        System.out.println("Hello World");

        Students s = new Students();

//        Students s1 = new Students(s);
//        s1.name = "Rahim";
//
//
//        System.out.println(s.name);
//        System.out.println(s1.name);


        //s object -> memory
      ///  s1 = s;

    }
}
