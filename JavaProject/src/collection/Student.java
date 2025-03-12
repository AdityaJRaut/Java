package collection;

public  class Student implements Comparable<Student> {
    int rno;
    String name;
    float marks;


    public Student(int rno, String name, float marks) {
        this.rno = rno;
        this.name = name;
        this.marks = marks;
    }

    public int getRno() {
        return rno;
    }

    public void setRno(int rno) {
        this.rno = rno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getMarks() {
        return marks;
    }

    public void setMarks(float marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{rno: "+rno+", name: "+name+" marks: "+marks+"}";
    }
    
    @Override
	public int compareTo(Student that) {
		if(this.rno>that.rno)
		return 1;
		else
			return -1;
	}

	
}
