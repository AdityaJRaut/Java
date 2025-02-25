package abstractionrealtime;

import java.util.Scanner;

public class MainApp {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in); 
		Booking booking=new Booking();
		booking.AcceptBooking();
		System.out.println("Select Turf");
		System.out.println("1.Cricket Turf");
		System.out.println("2.Football Turf");
		System.out.println("3.Tennis Turf");
		System.out.println("0.Exit");
		System.out.println("enter your choice");
		int choice=sc.nextInt();
		Turf turf=null;
		switch (choice)
		{
		case 1: 
			turf=new CricketTurf();break;
		case 2: 
			turf=new FootballTurf();break;
		case 3: 
			turf=new TennisTurf();break;
		case 0: 
			System.exit(0);break;
		default:
			System.out.println("Invalid choice");
		}
		booking.displayBooking(turf);
		sc.close();
	}

}
