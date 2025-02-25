package serialization;

import java.io.Serializable;

public class Student implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name;
    int age;
    int rno;

    public Student(String name, int age, int rno) {
        this.name = name;
        this.age = age;
        this.rno = rno;
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

    public int getRno() {
        return rno;
    }

    public void setRno(int rno) {
        this.rno = rno;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", rollno=" + rno +
                '}';
    }
}
