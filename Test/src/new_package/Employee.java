package new_package;

public class Employee implements Cloneable {

	private int id;
	private String name;

	public Employee() {}
	public Employee(int id,String name)
	{
		this.id=id;
		this.name=name;
	}

	public Employee(Employee employee)
	{
		this.name=employee.name;
		this.id=employee.id;
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
