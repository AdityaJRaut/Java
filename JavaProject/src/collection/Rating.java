package collection;

import java.util.Scanner;

public class Rating {
	Scanner sc = new Scanner(System.in);
	public double rate;
	public int count;

	public Rating() {
	}

	public Rating(double rate, int count) {
		this.rate = rate;
		this.count = count;
	}

	public int getCount() {
		return count;
	}

	public double getRate() {
		return rate;
	}

	public void getRating() {
		System.out.println("Enter rating");
		this.rate = sc.nextDouble();
		System.out.println("Enter count");
		this.count = sc.nextInt();
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	@Override
	public String toString() {
		return "Rating [rate=" + rate + ", count=" + count + "]";
	}

}
