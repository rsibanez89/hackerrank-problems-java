package generalpractice;

public class UsingFormatting {

	public void Run() {
		simpleFormatting();
		specifyingWidthAndAligning();
		simpleTable();
	}

	private void simpleFormatting() {
		// % indicates that there is a special replacement
		// %\n for new line

		// %c for character
		System.out.printf("I'm %c years old\n", 'n');

		// %d for decimal
		System.out.printf("I'm %d years old\n", 27);

		// %f for float
		System.out.printf("I'm %f years old\n", 27f);

		// %s for string
		System.out.printf("I'm %s years old\n", "27");
	}

	private void specifyingWidthAndAligning() {
		// %7 specify a minimum width of 7 characters
		System.out.printf("***%7s***\n", "Hi");
		System.out.printf("***%7s***\n", "5");

		// %-7 specify a minimum width of 7 characters aligning left
		System.out.printf("***%-7s***\n", "Hi");
		System.out.printf("***%-7s***\n", "5");

		// %09 specify a minimum width of 9 and fill the space with 0, its just for numbers
		System.out.printf("***%09d***\n", 5);
		System.out.printf("***%09f***\n", 5f);

		// %.2f print just 2 numbers after the point
		System.out.printf("%.2f\n", 5f);

		//%,.3f indicates to insert "," usually used for currency.
		System.out.printf("$%,.3f\n", 5673123.251d);
		
		// Consider the error in precision and rounding of float numbers.
		// For example when printing the same number using float
		System.out.printf("$%,.3f\n", 5673123.251f);

	}

	private void simpleTable() {
		String[] names = new String[] { "Rodrigo", "Federico", "Juana" };
		int[] ages = new int[] { 27, 25, 12 };

		System.out.println("================================");
		for (int i = 0; i < names.length; i++) {
			String name = names[i];
			int age = ages[i];
			System.out.printf("%-15s%03d%n", name, age);
		}
		System.out.println("================================");
	}

	public static void main(String[] args) {
		new UsingFormatting().Run();
	}
}
