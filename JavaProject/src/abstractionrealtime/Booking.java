package abstractionrealtime;

import java.util.Scanner;

public class Booking {

	private String customerName;
	private String eventDate;
	private String eventTime;
	private int hours;
	Scanner sc = new Scanner(System.in);

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getEventDate() {
		return eventDate;
	}

	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}

	public String getEventTime() {
		return eventTime;
	}

	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public void AcceptBooking() {

		System.out.println("Enter Customer Name");
		this.customerName = sc.next();
		System.out.println("Enter Booking Date");
		this.eventDate = sc.next();
		System.out.println("Enter Booking Time");
		this.eventTime = sc.next();
		System.out.println("Enter no. of hours");
		this.hours = sc.nextInt();
	}

	public void displayBooking(Turf turf) {
		System.out.println("*******BILL********");
		System.out.println("Name: " + this.getCustomerName());
		System.out.println("Booking Date: " + this.eventDate);
		System.out.println("Booking Time: " + this.eventTime);
		System.out.println("Hours: " + this.hours);
		System.out.println("Turf Type: " + turf.getTurfType());
		System.out.println("Turf hourly rate: " + turf.getHourlyRate());
		System.out.println("Total payable: " + turf.getHourlyRate() * this.hours);
	}

}
