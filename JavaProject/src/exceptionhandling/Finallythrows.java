package exceptionhandling;

public class Finallythrows {

	public static void main(String[] args) throws Exception {
		try
		{
		adityaTest();
		}
		catch(NullPointerException e1)
		{
			System.out.println("Ex handled");
		}
		
		System.out.println("continue");
	}

	private static void adityaTest() throws NullPointerException
	{
		int num=10;
		int den=0;
		try {
			int res=num/den;
			System.out.println(res);
			
		} 
		catch (Exception e) {
			System.out.println(e);
		}
		
		
	}

}
