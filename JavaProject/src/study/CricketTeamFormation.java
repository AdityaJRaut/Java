package study;

public class CricketTeamFormation {

	public static void main(String[] args) {
		int[] teams = { 5, 3, 2, 7 };
		int teamSize = 2;
		int maxTeamsPossible = maxTeamsPossible(teams, teamSize);
		System.out.println("Max teams possible " + maxTeamsPossible);

	}

	private static int maxTeamsPossible(int[] teams, int teamSize) {
		int first = 1;
		int last = 10;
		while (first <= last) {
			int mid = (first + last) / 2;
			if (teamPossible(teams, mid, teamSize)) {
				if (teamPossible(teams, mid + 1, teamSize)) {
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

	private static boolean teamPossible(int[] teams, int mid, int teamSize) {
		int sum = 0;
		int playersRequired = mid * teamSize;
		for (int team : teams) {
			sum += Math.min(team, mid);
		}
		return sum >= playersRequired;
	}

}
