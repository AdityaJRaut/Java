package jdbc;

import java.util.Scanner;

public class CRUD {

	int id;
	String name;
	double salary;
	Scanner sc=new Scanner(System.in);
	public CRUD() {
	};

	public CRUD(int id, String name, double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public void insertData()
	{
		System.out.println("Enter id");
		this.id=sc.nextInt();
		System.out.println("enter name");
		this.name=sc.next();
		System.out.println("Enter salary");
		this.salary=sc.nextDouble();
		
	}
	
	public void UpdateName()
	{
		System.out.println("Enter new id");
		this.id=sc.nextInt();
		System.out.println("enter new name");
		this.name=sc.next();		
	}
	public void UpdateSalary()
	{
		System.out.println("Enter new id");
		this.id=sc.nextInt();
		System.out.println("enter new name");
		this.name=sc.next();		
	}
	public void UpdateData()
	{
		System.out.println("Enter new id");
		this.id=sc.nextInt();
		System.out.println("enter new name");
		this.name=sc.next();
		System.out.println("enter new salary");
		this.salary=sc.nextDouble();
	}
	public void DeleteData()
	{
		System.out.println("Enter id to delete");
		this.id=sc.nextInt();
	}
}
