package study;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class DispenseCash {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter amount to dispense");
		int amount = sc.nextInt();
		dispenseAmount(amount);
		sc.close();

	}

	private static void dispenseAmount(int amount) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		pq.add(500);
		pq.add(200);
		pq.add(100);
		pq.add(50);
		pq.add(20);
		pq.add(10);
		pq.add(5);
		while (!pq.isEmpty() && amount > 0) {

			int note = pq.remove();
			int count = amount / note;
			amount %= note;
			if (count > 0) {
				System.out.println("Rs." + note + " x " + count);
			}
		}

	}

}
