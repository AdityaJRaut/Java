import java.util.Scanner;

public class switchMcD {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int mainChoice;
		do {
			System.out.println("Welcome to McDonalds");
			System.out.println("Please place your order through ChatBot");
			System.out.println("----------MENU--------");
			System.out.println("1.Burger");
			System.out.println("2.Fries");
			System.out.println("3.Cold Drinks");
			System.out.println("0.Exit");
			mainChoice = sc.nextInt();
			switch (mainChoice) {
			case 1:
				System.out.println("Please select category :");
				System.out.println("1.Veg");
				System.out.println("2.Non-Veg");
				System.out.println("Select 1 or 2");
				int catChoice = sc.nextInt();
				switch (catChoice) {
				case 1:
					System.out.println("Enter size of your meal");
					System.out.println("1.small");
					System.out.println("2.medium");
					System.out.println("3.big");
					System.out.println("please enter your choice");
					int sizeChoice = sc.nextInt();
					switch (sizeChoice) {
					case 1:
						System.out.println("You have ordered small Veg Burger.");
						break;

					case 2:
						System.out.println("You have ordered Medium Veg Burger.");
						break;

					case 3:
						System.out.println("You have ordered big Veg Burger.");
						break;

					default:
						System.out.println("You have entered wrong choice.");
						break;
					}
					break;

				case 2:
					System.out.println("Enter ingredients");
					System.out.println("1.small");
					System.out.println("2.medium");
					System.out.println("3.big");
					System.out.println("please enter your choice");
					sizeChoice = sc.nextInt();
					switch (sizeChoice) {
					case 1:
						System.out.println("You have ordered small NonVeg Burger.");
						break;

					case 2:
						System.out.println("You have ordered Medium NonVeg Burger.");
						break;

					case 3:
						System.out.println("You have ordered big NonVeg Burger.");
						break;

					default:
						System.out.println("You have entered wrong choice.");
						break;

					}
				}
				break;

			case 2:
				System.out.println("Please select category :");
				System.out.println("1.salted");
				System.out.println("2.peri peri");
				System.out.println("Select 1 or 2");
				catChoice = sc.nextInt();
				switch (catChoice) {
				case 1:
					System.out.println("Enter size of your meal");
					System.out.println("1.small");
					System.out.println("2.medium");
					System.out.println("3.big");
					System.out.println("please enter your choice");
					int sizeChoice = sc.nextInt();
					switch (sizeChoice) {
					case 1:
						System.out.println("You have ordered small salted fries.");
						break;

					case 2:
						System.out.println("You have ordered Medium salted fries.");
						break;

					case 3:
						System.out.println("You have ordered big salted fries.");
						break;

					default:
						System.out.println("You have entered wrong choice.");
						break;

					}
					break;
				case 2:
					System.out.println("Enter size of your meal");
					System.out.println("1.small");
					System.out.println("2.medium");
					System.out.println("3.big");
					System.out.println("please enter your choice");
					sizeChoice = sc.nextInt();
					switch (sizeChoice) {
					case 1:
						System.out.println("You have ordered small peri peri fries.");
						break;

					case 2:
						System.out.println("You have ordered Medium peri peri fries.");
						break;

					case 3:
						System.out.println("You have ordered big peri peri fries.");
						break;

					default:
						System.out.println("You have entered wrong choice.");
						break;

					}

					break;
				}
				break;
			case 3:
				System.out.println("Please select category :");
				System.out.println("1.Pepsi");
				System.out.println("2.ThumsUP");
				System.out.println("Select 1 or 2");
				catChoice = sc.nextInt();
				switch (catChoice) {
				case 1:
					System.out.println("Enter size of your meal");
					System.out.println("1.small");
					System.out.println("2.medium");
					System.out.println("3.big");
					System.out.println("please enter your choice");
					int sizeChoice = sc.nextInt();
					switch (sizeChoice) {
					case 1:
						System.out.println("You have ordered small Pepsi.");
						break;

					case 2:
						System.out.println("You have ordered Medium Pepsi.");
						break;

					case 3:
						System.out.println("You have ordered big Pepsi.");
						break;

					default:
						System.out.println("You have entered wrong choice.");
						break;

					}
					break;
				case 2:

					System.out.println("Enter size of your meal");
					System.out.println("1.small");
					System.out.println("2.medium");
					System.out.println("3.big");
					System.out.println("please enter your choice");
					sizeChoice = sc.nextInt();
					switch (sizeChoice) {
					case 1:
						System.out.println("You have ordered small ThumsUP.");
						break;

					case 2:
						System.out.println("You have ordered Medium ThumsUP.");
						break;

					case 3:
						System.out.println("You have ordered big ThumsUP.");
						break;

					default:
						System.out.println("You have entered wrong choice.");
						break;

					}

					break;

				default:
					System.out.println("Invalid Choice...");

				}
			case 0:
				System.exit(0);
			}

		} while (mainChoice != 0);

		sc.close();
	}

}
