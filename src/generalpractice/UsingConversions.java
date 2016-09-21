package generalpractice;

public class UsingConversions {

	public void Run() {
		simpleConversions();
	}

	private void simpleConversions() {
		// String to int
		int numberI = Integer.parseInt("1234");
		System.out.println("int: " + numberI);

		// String to float
		float numberF = Float.parseFloat("1234.123");
		System.out.println("float: " + numberF);

		// String to double
		double numberD = Double.parseDouble("1234567.1234567");
		System.out.println("double: " + numberD);

		// String to char array
		char[] charArray = ("this is a text").toCharArray();
		System.out.println("charArray[0]: " + charArray[0]);

		// String to String[]
		String[] stringArray = ("this,is,a,comma,separated,text").split(",");
		System.out.println("stringArray[0]: " + stringArray[0]);
	}

	public static void main(String[] args) {
		new UsingConversions().Run();
	}

}
