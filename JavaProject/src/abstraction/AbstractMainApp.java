package abstraction;

public class AbstractMainApp {

	public static void main(String[] args) 
	{
		Shape2D s1;
		s1=new Circle();
		s1.area();
		s1.perimeter();
		
		s1=new FootballField();
		s1.area();
		s1.perimeter();
		
	}
}
