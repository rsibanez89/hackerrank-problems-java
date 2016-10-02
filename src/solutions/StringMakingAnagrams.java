package solutions;

public class StringMakingAnagrams {

	private static String[] inputs = new String[] { "bacdc", "dcbac", "bacdc", "dcbad", "cde", "abc" };

	public static void main(String[] args) {
		int index = 0;
		String a;
		String b;
		int counter;
		while (index < inputs.length) {
			a = inputs[index++];
			b = inputs[index++];
			counter = 0;
			for (int i = 0; i < a.length(); i++) {
				Character ai = a.charAt(i);
				// if the character is in b, the character is in both strings. I remove it from b to don't count it again.
				if (b.contains(ai.toString()))
					b = b.replaceFirst(ai.toString(), "");
				else // if the character is not in b, I have to remove it from a. So I count one more.
					counter++;
			}
			counter += b.length(); // The remainder character that I have to remove from b that are not in a.
			System.out.println(counter);
		}

	}

}
