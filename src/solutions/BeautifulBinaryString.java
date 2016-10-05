package solutions;

public class BeautifulBinaryString {

	private static String[] inputs = new String[] { "0101010", "01100", "0", "0100101010" };

	// Possibilities are
	// 0101 -> best replacement 0111
	// 0100 -> best replacement 0110
	public static void main(String[] args) {

		char[] s;
		int permutations;
		for (String input : inputs) {
			s = (input).toCharArray();
			permutations = 0;
			for (int i = 0; i < s.length - 2; i++)
				if ((s[i] == '0') && (s[i + 1] == '1') && (s[i + 2] == '0')) {
					permutations++; // I don't need to do the permutation
					i+=2; // I'll move 3, two here and 1 in i++.
				}
			System.out.println(permutations);
		}
	}

}
