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
		if (amount % 100 != 0) {
			System.out.println("Please enter amount multiples of 100");
			return;
		}
		while (!pq.isEmpty() && amount > 0) {

			int note = pq.remove();
			int count = amount / note;
			amount %= note;
			if (count > 0) {
				System.out.println("Rs." + note + " x " + count);
			}
		}
		if (amount > 0) {
			System.out.println("Unable to dispense entered amount");
		}

	}

}
