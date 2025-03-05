package collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainAppEmployee {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Employee emp;
		System.out.println("Enter no. of employees");
		int n = sc.nextInt();
		List<Employee> empList = new ArrayList<Employee>();
		for (int i = 0; i < n; i++) {
			emp = new Employee();
			emp.getDetails();
			empList.add(emp);
		}
		System.out.println("Enter department to calculate avg salary");
		String department=sc.next();
		double totalsal = 0;
		int count = 0;
		double maxsal=0;
		String maxSalaryEmployee="";
		for (Employee employee : empList) {
			if (employee.getDeptname().equalsIgnoreCase(department)) {
				totalsal += employee.getEmpsalary();
				count++;
				if(employee.getEmpsalary()>maxsal)
				{
					maxsal=employee.getEmpsalary();
					maxSalaryEmployee=employee.getEmpname();
				}
			}			
		}
		System.out.println(totalsal);
		System.out.println("Total Avg salary of "+department+" Employees is " + (totalsal / count));
		System.out.println("Max salary in "+department+" employee name is "+maxSalaryEmployee);
		sc.close();
	}

}
