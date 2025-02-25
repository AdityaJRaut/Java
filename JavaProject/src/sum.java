import java.util.Scanner;

public class sum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int chocolates = 0;
		// int peonCollected=0;
		int students = 1;
		while (students <= 5) {
			System.out.println("Roll no " + students + " how many chocolates have you bought? ");
			chocolates += sc.nextInt();
			students++;
		}
		System.out.println("Peon Collected " + chocolates + " chocolates from " + (students - 1) + " students");
		sc.close();

	}

}
