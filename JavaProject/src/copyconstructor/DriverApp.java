package copyconstructor;

public class DriverApp {

	public static void main(String[] args) {
		Employee employee = new Employee();
		employee.setId(1);
		employee.setName("Aditya");
//		Employee emp=employee;   //shallow copy create one copy and both objects point to same address
//		emp.setName("Bhushan");	
//		
//		System.out.println(employee.getName());

		Employee e1 = new Employee(employee); // copy constructor deep copy (new keyword) create separate copy and object points to
												// different addresses
		System.out.println(e1.getName());
		e1.setName("Alice");
		System.out.println(e1.getName());
		System.out.println(employee.getName());

	}

}
