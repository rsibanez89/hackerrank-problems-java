package solutions;

import java.util.ArrayList;

public class Pangrams {

	private static String[] inputs = new String[] { "We promptly judged antique ivory buckles for the next prize",
			"We promptly judged antique ivory buckles for the prize" };

	private static ArrayList<Character> getAlphabet() {
		char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		ArrayList<Character> ret = new ArrayList<Character>();
		for (char c : alphabet)
			ret.add(c);
		return ret;
	}

	public static void main(String[] args) {
		ArrayList<Character> alphabet = new ArrayList<>();

		for (String input : inputs) {
			alphabet = getAlphabet();
			for (int i = 0; i < input.length(); i++)
				alphabet.remove((Character) Character.toLowerCase(input.charAt(i)));
			System.out.println(alphabet);
			if (alphabet.isEmpty())
				System.out.println("pangram");
			else
				System.out.println("not pangram");

		}
	}

}
