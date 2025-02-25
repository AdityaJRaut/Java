package classAndObjects;

public class Employee extends Person{

	int empId;
	String dept;
	String desg;
	String assignedTask;

	public Employee(String name, int age, int empId, String dept, String desg,String assignedTask) {
		super(name, age);
		this.empId = empId;
		this.dept = dept;
		this.desg = desg;
		this.assignedTask=assignedTask;
	}

	public String getAssignedTask() {
		return assignedTask;
	}

	public void setAssignedTask(String assignedTask) {
		this.assignedTask = assignedTask;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getDesg() {
		return desg;
	}

	public void setDesg(String desg) {
		this.desg = desg;
	}

	@Override
	void getDetails() {
		System.out.println("Enter Employee Name");
		this.setName(sc.next());
		System.out.println("Enter Age");
		this.setAge(sc.nextInt());
		System.out.println("Enter ID");
		this.setEmpId(sc.nextInt());
		System.out.println("Enter Department");
		this.setDept(sc.next());
		System.out.println("Enter Designation");
		this.setDesg(sc.next());

	}

	@Override
	void displayDetails() {
		System.out.println("-------------------------------------------");
		System.out.println("Employee Name " + this.name);
		System.out.println("Age " + this.age);
		System.out.println("ID " + this.empId);
		System.out.println("Department " + this.dept);
		System.out.println("Designation " + this.desg);
		if(this.assignedTask==null) {this.assignedTask="Not Assigned";}
		System.out.println("Assigned Task "+this.assignedTask);
		System.out.println("-------------------------------------------");

	}

}
