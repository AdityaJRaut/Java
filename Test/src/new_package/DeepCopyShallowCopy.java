package new_package;

public class DeepCopyShallowCopy {

	public static void main(String[] args)
	{
		Employee emp1=new Employee(1, "Aditya");
		Employee emp2=emp1;
		Employee emp3=new Employee(emp1);
		emp1.setName("Nagesh");
		emp1.setId(2);
		System.out.println(emp2);
		System.out.println(emp1==emp2);
		System.out.println(emp1==emp3);
		System.out.println(emp1.equals(emp2));
		System.out.println(emp1.equals(emp3));
		System.out.println(emp3);
	}
}
