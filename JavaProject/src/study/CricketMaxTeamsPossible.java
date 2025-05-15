package study;

public class CricketMaxTeamsPossible {

	private static boolean checkTeamsPossible(int[] players, int NumberOfTeamsPossible, int sizeofTeam) {
		int sum = 0; // {5,4,3,7};
		int totalPlayersNeeded = NumberOfTeamsPossible * sizeofTeam; // 50
		for (int p : players) {
			sum += Math.min(p, NumberOfTeamsPossible); // sum=
		}
		if (sum >= totalPlayersNeeded)
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		int players[] = { 5, 4, 3, 7 };
		int n = 2;
		int not = numberOfTeams(players, n);
		System.out.println("Maximum Number of Teams possible is " + not);
	}

	private static int numberOfTeams(int[] players, int sizeofTeam) {
		int first = 1;
		int last = 10;
		while (first <= last) {
			int mid = (first + last) / 2; // mid=2

			if (checkTeamsPossible(players, mid, sizeofTeam)) {
				if (checkTeamsPossible(players, mid + 1, sizeofTeam)) {
					first = mid + 1;
				} else {
					return mid;
				}
			} else {
				last = mid - 1;
			}
		}
		return 0;
	}

}