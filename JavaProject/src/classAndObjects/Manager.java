package classAndObjects;

public class Manager extends Person implements AssignTask {

	public Manager(String name, int age) {
		super(name, age);
	}

	@Override
	public void setAssignedTask(Employee employee, String assignedTask) {
		System.out.println("Assign Task to Employee");
		assignedTask=sc.next();
		employee.setAssignedTask(assignedTask);
		
	}

	@Override
	void getDetails() {
		System.out.println("Enter Manager Name");
		this.setName(sc.next());
		System.out.println("Enter Age");
		this.setAge(sc.nextInt());		
	}

	@Override
	void displayDetails() {
		System.out.println("Manager Name " + this.name);
		System.out.println("Age " + this.age);
		
		
	}

}
