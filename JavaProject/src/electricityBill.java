import java.util.Scanner;

public class electricityBill {

	public static void main(String[] args) {
		readingInput();
	}

	private static void rateSlab() {
		System.out.println(String.format("%-30s", "Below 100 Units") + "Rs." + String.format("%5.2f", 2.5));
		System.out.println(String.format("%-30s", "100-200 Units") + "Rs." + String.format("%5.2f", 3.5));
		System.out.println(String.format("%-30s", "200-300 Units") + "Rs." + String.format("%5.2f", 4.5));
		System.out.println(String.format("%-30s", "Above 300 Units") + "Rs." + String.format("%5.2f", 5.5));
		System.out.println(String.format("%-30s", "--------------------------") + String.format("%5s", "--------"));
	}

	private static void readingInput() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Electricity Bill Portal");
		System.out.println("Enter previous reading");
		int previousMeterReading = sc.nextInt();
		System.out.println("Enter current Reading");
		int currentReading = sc.nextInt();
		sc.close();
		processingInput(previousMeterReading, currentReading);
	}

	private static void processingInput(int previousMeterReading, int currentReading) {
		int billAmount = 0;
		int unitsConsumed = currentReading - previousMeterReading;
		while (unitsConsumed != 0) {
			if (unitsConsumed <= 100) {
				billAmount += 2.5 * unitsConsumed;
				unitsConsumed = 0;
			} else if (unitsConsumed > 100 && unitsConsumed <= 200) {
				billAmount += 3.5 * (unitsConsumed - 100);
				unitsConsumed = 100;
			} else if (unitsConsumed > 200 && unitsConsumed <= 300) {

				billAmount += 4.5 * (unitsConsumed - 200);
				unitsConsumed = 200;
			} else {

				billAmount += 5.5 * (unitsConsumed - 300);
				unitsConsumed = 300;
			}
		}
		billAmount += 100;
		printBill(previousMeterReading, currentReading, unitsConsumed, billAmount);

	}

	private static void printBill(int previousMeterReading, int currentReading, int unitsConsumed, double billAmount) {

		System.out.println(String.format("%s", "MSEDCL ELECTRICITY BILL"));
		rateSlab();
		unitsConsumed = currentReading - previousMeterReading;
		System.out.println(String.format("%-30s", "Fixed Meter Charges") + "Rs." + String.format("%5d", 100));
		System.out.println(
				String.format("%-30s", "Previous Reading") + "Rs." + String.format("%5d", previousMeterReading));
		System.out.println(
				String.format("%-30s", "Current Meter Reading") + "Rs." + String.format("%5d", currentReading));
		System.out.println(String.format("%-30s", "Units Consumed") + "Rs." + String.format("%5d", unitsConsumed));
		System.out.println(String.format("%-30s", "Total Payable") + "Rs." + String.format("%5.2f", billAmount));
		System.out.println(String.format("%-30s", "Due Date") + String.format("%5s", "31-01-2025"));
		System.out.println(String.format("%-30s", "Total Payable after due date") + "Rs."
				+ String.format("%5.2f", billAmount + 2.5));
	}

}
