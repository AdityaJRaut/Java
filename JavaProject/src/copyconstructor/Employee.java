package copyconstructor;

public class Employee {

	private int id;
	private String name;
	public Employee() {}
	public Employee(Employee e)
	{
		this.name=e.name;
		this.id=e.id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}
	
	
}
