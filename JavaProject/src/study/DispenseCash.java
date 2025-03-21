package study;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class DispenseCash {

	private static void dispenseAmount(int amount) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		pq.add(50);
		pq.add(20);
		pq.add(10);
		pq.add(5);
		pq.add(500);
		pq.add(200);
		pq.add(100);
		int totalCount = 0;
		while (!pq.isEmpty() && amount > 0) {

			int note = pq.remove();
			int count = amount / note;
			amount %= note;
			if (count > 0) {
				System.out.println("Rs." + note + " x " + count);
				totalCount += count;
			}
		}
		System.out.println("Total Notes " + totalCount);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter amount to dispense");
		int amount = sc.nextInt();
		dispenseAmount(amount);
		sc.close();

	}

}
