package generalpractice.algorithms.backtracking;

public class BacktrackingAllCombinations {

	// Generate all the possible binary numbers of length n
	public static void backAll(char[] s, int index) {
		if (index == s.length)
			System.out.println(s);
		else {
			s[index] = '0';
			backAll(s, index + 1);
			s[index] = '1';
			backAll(s, index + 1);
		}
	}

	public static void main(String[] args) {
		int n = 4;
		char solution[] = new char[n];
		backAll(solution, 0);
	}

}
