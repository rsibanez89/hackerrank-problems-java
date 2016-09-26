package solutions;

public class FunnyString {

	private static String[] inputs = new String[] { "acxz", "bcxz", "ivvkxq", "ivvkx" };

	public static void main(String[] args) {

		for (String input : inputs) {
			boolean funny = true;
			for (int i = 1; i < input.length() && funny; i++) {
				char a = input.charAt(i - 1);
				char b = input.charAt(i);
				char y = input.charAt(input.length() - i - 1);
				char z = input.charAt(input.length() - i);

				if (Math.abs(b - a) != Math.abs(z - y))
					funny = false;
			}

			if (funny)
				System.out.println("Funny");
			else
				System.out.println("Not Funny");

		}

	}

}
