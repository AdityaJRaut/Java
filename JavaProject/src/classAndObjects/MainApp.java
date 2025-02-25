package classAndObjects;

public class MainApp {

	public static void main(String[] args) {
		Employee employee=new Employee(null, 0, 0, null, null,null);
		employee.getDetails();
		employee.displayDetails();
		
		Manager manager=new Manager(null, 0);
		manager.setAssignedTask(employee, null);
		
		employee.displayDetails();

	}

}
