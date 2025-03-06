package study;

public class Armstrong {

	public static void main(String[] args) {
		int num=374;
		if(isArmstrong(num))
		{
			System.out.println("Armstrong Number");
		}
		else
		{
			System.out.println("Not a armstrong number");
		}

	}

	public static boolean isArmstrong(int num) {
		int sum=0;
		int org=num;
		int lastDigit=0;
		int power=Integer.toString(num).length();

		while(num>0)
		{
			lastDigit=num%10;
			sum+=Math.pow(lastDigit, power);
			num=num/10;
		}
		return sum==org;
		
	}

}
