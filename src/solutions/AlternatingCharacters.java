package solutions;

public class AlternatingCharacters {

	private static String[] inputs = new String[] { "AAAA", "BBBBB", "ABABABAB", "BABABA", "AAABBB" };

	// This solution works but gives you a "Terminated due to timeout" result
	private static void solution1() {
		for (String input : inputs) {
			int counter = 0;
			while (input.contains("AA")) {
				input = input.replaceFirst("AA", "A");
				counter++;
			}
			while (input.contains("BB")) {
				input = input.replaceFirst("BB", "B");
				counter++;
			}
			System.out.println(input + " : " + counter);
		}
	}

	public static void main(String[] args) {
		char[] charInput;
		int index;
		int counter;
		char lastChar;
		for (String input : inputs) {
			charInput = input.toCharArray();
			index = 1;
			counter = 0;
			lastChar = charInput[0];
			while (index < charInput.length) {
				if (charInput[index] != lastChar)
					lastChar = charInput[index];
				else
					counter++;
				index++;
			}
			System.out.println(input + " : " + counter);
		}
	}

}
