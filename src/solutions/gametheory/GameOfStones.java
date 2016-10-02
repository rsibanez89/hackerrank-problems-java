package solutions.gametheory;

public class GameOfStones {

	// Game theory is all about how we model the problem.
	// For this example that doesn't matter the steps but just to know who is the winner.
	// We are going to have an array representing who wins for each number of stones available.
	// boolean winner[], true if the winner is player 1, false if the winner is player two.

	private static boolean canIWin(boolean winner[], int stones) {
		// Generate all my possible movements
		boolean move1 = winner[stones - 2];
		boolean move2 = winner[stones - 3];
		boolean move3 = winner[stones - 5];

		// If all my movements are true means that I jump to a winning movement for me.
		// So, I'm leaving the other player to win.
		return !(move1 && move2 && move3);
	}

	private static void whoWins(boolean winner[], int stones) {
		if (stones < winner.length) {
			winner[stones] = canIWin(winner, stones);
			whoWins(winner, stones + 1);
		}
	}

	public static void main(String[] args) {
		boolean[] winner = new boolean[101];
		winner[1] = false; // Player2 wins
		winner[2] = true; // Player1 wins
		winner[3] = true; // Player1 wins
		winner[4] = true; // Player1 wins
		winner[5] = true; // Player1 wins
		whoWins(winner,6); // always start completing the array from 6 to winner.length
		for (int i = 1; i < winner.length; i++)
			if (winner[i])
				System.out.printf("Stones[%d] - Player1\n", i);
			else
				System.out.printf("Stones[%d] - Player2\n", i);
	}

}
