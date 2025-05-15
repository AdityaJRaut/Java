import markerInterface.Marker;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@FunctionalInterface
interface A
{
    void show();
   // int add(int a, int b);
    String toString();

}

class B implements A
{
    private String name;
    @Override
    public void show() {
        System.out.println("B");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "B{" +
                "name='" + name + '\'' +
                '}';
    }
}

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String... args) throws IOException, ClassNotFoundException {

        B a = new B();
        //a.show();
        B a1 = new B();
        a.setName("Aditya");
        a1.setName("Adi");
        System.out.println(a);
        System.out.println(a1);
        System.out.println(a.equals(a1));
        System.out.println(a.hashCode());
        System.out.println(a1.hashCode());
//        //serialization
//        Marker m = new Marker();
//      //  m.setId(1);
//      //  m.setName("Aditya Raut");
//        FileOutputStream fileOutputStream = new FileOutputStream("aditya.txt");
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
//        objectOutputStream.writeObject(m);
//        objectOutputStream.close();
//        fileOutputStream.close();
//        System.out.println("Serialized");
//
//        //deserialization
//        Marker m2;
//        FileInputStream fileInputStream = new FileInputStream("aditya.txt");
//        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
//        m2= (Marker) objectInputStream.readObject();
//        objectInputStream.close();
//        fileInputStream.close();
//        System.out.println("Deserialized");
//        System.out.println(m2);
//
//
//        List<Integer> nums= new ArrayList<>(Arrays.asList(2, 5, 1, 3, 9, 8, 10, 4));
//        Optional<Integer> n=nums.stream().map(num -> num * num)
//                .filter(num -> num % 2 == 0)
//                .max(Integer::compareTo);
//        System.out.println(n);
//        Optional<String> name = Optional.ofNullable(m2.getName());
//        name.ifPresent(System.out::println);
//        String[] words=new String[4];
//        Optional<String> name2 = Optional.ofNullable(words[3]);
//        name2.ifPresent(System.out::println);
//
//        Marker.test();
//        int sum1=Marker.sum();
//        int sum2=Marker.sum(1,2,3,4,56,6);
//        int sum3=Marker.sum(4,3,5,3,2,4,5);
//        int sum4=Marker.sum(1);
//
//        System.out.println(sum1);
//        System.out.println(sum2);
//        System.out.println(sum3);
//        System.out.println(sum4);
//
//
Marker marker = new Marker();
int res=marker.sum(1,2,3,4,5,6,7,8,9);
System.out.println(res);
try {
    System.out.println("Hello World");
  //
    // int d=5/0;
   System.exit(0);
}
catch (ArithmeticException e) {
    System.out.println("Exception occurred");
}
finally {
    System.out.println("Finally");
}
    }
}