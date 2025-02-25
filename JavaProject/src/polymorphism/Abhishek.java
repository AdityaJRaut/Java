package polymorphism;

public class Abhishek extends Amitabh
{
	@Override
	void car()
	{
		System.out.println("Abhishek Audi");
	}
	
	void car(int n)
	{
		System.out.println("Abhishek Bentley");
	}
	
	@Override
	void home()
	{
		System.out.println("Abhishek New Jalsa");
	}
	void office()
	{
		System.out.println("Abhishek Bandra Office");
	}
}
