package JavaDay1;

public class MainApp {

	public static void main(String[] args) {

		Student obj1 = new Student();
		obj1.Register();
		obj1.Login();
		obj1.PayFees();
		obj1.setRno(123);
		System.out.println(obj1.getRno());
	}

}
