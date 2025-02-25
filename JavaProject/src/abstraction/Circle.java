package abstraction;

public class Circle implements Shape2D
{
	@Override
	public void area()
	{
		System.out.println("Circle Class 3.14*r*r");
	}

	@Override
	public void perimeter() {

		System.out.println("Circle Class 3.14*r");
		
	}
	
}
