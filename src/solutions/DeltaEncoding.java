package solutions;

public class DeltaEncoding {

	private static String[] inputs = new String[] { "25626", "25757", "24367", "24267", "16", "100", "2", "7277" };

	public static void main(String[] args) {

		System.out.print(inputs[0] + " ");
		for (int i = 1; i < inputs.length; i++) {
			int toPrit = Integer.valueOf(inputs[i]) - Integer.valueOf(inputs[i - 1]);
			if ((toPrit > 127) || (toPrit < -127))
				System.out.print("-128 ");
			System.out.print(toPrit + " ");
		}
	}

}
