package study;

public class CricketMaxTeamsPossible {

	public static void main(String[] args) {
		int teamPlayers[] = {30,45,17,24};
		int teamSize = 4;
		int max = maximumTeamsPossible(teamPlayers, teamSize);
		System.out.println("Maximum Teams Possible " + max);

	}

	private static int maximumTeamsPossible(int[] teamPlayers, int teamSize) {
		int first = 1;
		int last = 100;
		
		while (first <= last) {
			int mid = (first + last) / 2;
			if (teamPossible(teamPlayers, mid, teamSize)) {
				if (teamPossible(teamPlayers, mid + 1, teamSize)) {
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

	private static boolean teamPossible(int[] teamPlayers, int possibleTeam, int teamSize) {
		int sum = 0;
		int totalPlayersNeeded = possibleTeam * teamSize;
		for (int eachCountryPlayer : teamPlayers) {
			sum += Math.min(eachCountryPlayer, possibleTeam);
		}
		if (sum >= totalPlayersNeeded) {
			return true;
		} else {
			return false;
		}
	}

}
