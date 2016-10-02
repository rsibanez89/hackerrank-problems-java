package generalpractice.algorithms.backtracking;

public class BacktrackingGameOfStones {

	// This code solves the problems/gametheory/game-of-stones.pdf by using backtracking
	// This is not the best solution and it can also be refatored, 
	// but I think is the best way to understand how to use backtracking when you have to generate the best solution for each of the player involved. 
	
	private static boolean endOfGame(int stones) {
		if (stones <= 5)
			return true;
		return false;
	}

	private static boolean getWinner(int stones) {
		if (stones == 1) // I can't take any stone, I lose
			return false;
		if (stones == 2) // I take 2, I win
			return true;
		if (stones == 3) // I take 3, I win
			return true;
		if (stones == 4) // I take 3, leave 1, then I win
			return true;
		if (stones == 5) // I take 5, I win
			return true;
		return false;
	}

	private static boolean back(int stones, boolean player) {
		if (endOfGame(stones)) {
			if( getWinner(stones) == player)
				return true; // means that player1 wins
			return false; // means that player2 wins
		} else {
			boolean winner = !player;
			// Generate all the possible movements
			winner = back(stones - 5, !player);
			if (winner == player) // means that I win
				return winner;
			winner = back(stones - 3, !player);
			if (winner == player) // means that I win
				return winner;
			winner = back(stones - 2, !player);
			if (winner == player) // means that I win
				return winner;
			return winner;
		}
	}

	public static void main(String[] args) {
		for (int i = 1; i < 101; i++) {
			boolean winner = back(i, true);
			if (winner)
				System.out.printf("Stones[%d] - Player1\n", i);
			else
				System.out.printf("Stones[%d] - Player2\n", i);
		}
	}

}
