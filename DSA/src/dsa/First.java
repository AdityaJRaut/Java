package dsa;

public class First {

	public static void main(String[] args)
	{
		int[] a= {2,6,9,5,3};
		int min=a[0];
		for(int m:a)
		{
			if(m<min)
			{
				min=m;
			}
		}
		System.out.println("Min Value is "+min);
		
	}
}
