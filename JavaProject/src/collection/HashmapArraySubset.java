package collection;

import java.util.HashMap;
import java.util.Map;

public class HashmapArraySubset {

	public static void main(String[] args) {
		int a[]= {11,1,13,21,3,7};
		int b[]= {11,3,7,1};
		
		Map<Integer,Integer> arrSubset=new HashMap<>();
		for(int first:a)
		{
			arrSubset.put(first,1);
		}
		int flag=0;
		for(int second:b)
		{
			if(!arrSubset.containsKey(second))
			{
				flag=1;
				break;
			}			
		}
		if(flag==1)
		{
			System.out.println("No Subset");
		}
		else
		{
			System.out.println("Subset");
		}
		
	}

}
