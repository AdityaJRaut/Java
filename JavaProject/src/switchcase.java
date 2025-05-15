import java.util.Scanner;

public class switchcase {
	public static void main(String[] args) {
		int choice;
		Scanner sc = new Scanner(System.in);

		do {

			System.out.println("--------MENU-----");
			System.out.println("1.English");
			System.out.println("2.Arabic");
			System.out.println("3.Marathi");
			System.out.println("0.Exit");
			System.out.println("Enter your choice language");
			choice = sc.nextInt();
			switch (choice) {
			case 1: {
				System.out.println("Thank you for your input.\n You have selected english");
				System.out.println("Which Accent you want :");
				System.out.println("1.English UK");
				System.out.println("2.English US");
				System.out.println("3.English AUS");
				int englishch = sc.nextInt();
				switch (englishch) {
				case 1: {
					System.out.println("You are redirected to London");
					break;
				}
				case 2: {
					System.out.println("You are redirected to New york");
					break;
				}
				case 3: {
					System.out.println("You are redirected to Australia");
					break;
				}
				case 0: {
					System.out.println("Exit...");
					System.exit(0);
				}
				default: {
					System.out.println("Invalid choice");
				}
				}
				break;
			}
			case 2: {
				System.out.println("Thank you for your input.\n You have selected arabic");
				System.out.println("Which Accent you want :");
				System.out.println("1.Qatar");
				System.out.println("2.Dubai");
				System.out.println("3.Oman");
				int englishch = sc.nextInt();
				switch (englishch) {
				case 1: {
					System.out.println("You are redirected to Doha");
					break;
				}
				case 2: {
					System.out.println("You are redirected to Abu dhabi");
					break;
				}
				case 3: {
					System.out.println("You are redirected to Muscat");
					break;
				}
				case 0: {
					System.out.println("Exit...");
					System.exit(0);
				}
				default: {
					System.out.println("Invalid choice");
				}
				}
				break;
			}
			case 3: {
				System.out.println("Thank you for your input.\n You are routing to Kolhapur office executive");
				break;
			}
			case 0: {
				System.out.println("Exit....");
				System.exit(0);
				break;
			}

			default:
				System.out.println("Invalid Choice...!");
			}
		} while (choice != 0);
		sc.close();
	}

}
