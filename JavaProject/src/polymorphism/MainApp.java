package polymorphism;

public class MainApp {

	public static void main(String[] args) 
	{
		//P p = new P();
		
		Amitabh a1;		
		a1=new Amitabh();		
		a1.car();
		a1.home();
		
		//P p=new C();
		//Parent inherits all the methods which overrides from parent class.
		Amitabh a2;
		a2=new Abhishek();
		a2.car();
		a2.home();
		
		//C c =new C();
		//Parent cannot inherit childs own class methods
		Abhishek a3=new Abhishek();
		a3.car(1);
		a3.office();
	}

}
