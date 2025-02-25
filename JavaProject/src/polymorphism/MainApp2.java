package polymorphism;

public class MainApp2 {

	public static void main(String[] args) 
	{
		Student s1;
		
		s1=new Student(8,"Aditya",78.5,true);
		System.out.println(s1.getSname());
		s1=new Student(12,"Bhushan",88.5,false);
		System.out.println(s1.getSname());
		
		
	}

}
