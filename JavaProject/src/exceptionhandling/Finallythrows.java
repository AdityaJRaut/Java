package exceptionhandling;

public class Finallythrows {

	public static void main(String[] args) throws Exception {
		int num=10;
		int den=0;
		try {
			int res=num/den;
			System.out.println(res);
			
		} 
		finally {
			throw new NullPointerException();
		}

	}

}
