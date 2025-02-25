import java.util.Scanner;

public class Reverse
{
    public static void main(String[] args)
    {
        int lastlastDigit,newValue=0;
        int arr[]=new int[5];
        int brr[]=new int[5];
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter elements in array :");
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=sc.nextInt();
        }
        for(int i=0;i<arr.length;i++)
        {
            newValue=0;
            while(arr[i]!=0)
            {
                int lastDigit = arr[i]%10;
                newValue=newValue*10+lastDigit;
                arr[i]=arr[i]/10;
                brr[i]=newValue;
            }
        }
        for(int i=0;i<arr.length;i++)
        {
            System.out.println(brr[i]);
        }
    }
}