package collection;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Juicer {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter mango juices: ");
		int mangoJuices = sc.nextInt();

		System.out.print("Enter orange juices: ");
		int orangeJuices = sc.nextInt();

		System.out.print("Enter pineapple juices: ");
		int pineappleJuices = sc.nextInt();

		int seconds = calculateTimeRequired(mangoJuices, orangeJuices, pineappleJuices);
		System.out.print("Time required: " + seconds + " seconds");

		sc.close();
	}

	private static int calculateTimeRequired(int mango, int orange, int pineapple) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		// Add only non-zero values to the priority queue
		if (mango > 0)
			pq.add(mango);
		if (orange > 0)
			pq.add(orange);
		if (pineapple > 0)
			pq.add(pineapple);

		int seconds = 0;

		while (pq.size() > 1) {
			int first = pq.remove(); // Get the largest juice count
			int second = pq.remove(); // Get the second largest juice count

			seconds++; // One second to process two juices
			first--;
			second--;

			if (first > 0)
				pq.add(first); // Add back if there's juice left
			if (second > 0)
				pq.add(second);
		}

		// If any juice is left in the last container, add its remaining count
		if (!pq.isEmpty()) {
			seconds += pq.poll();
		}

		return seconds;
	}
}
