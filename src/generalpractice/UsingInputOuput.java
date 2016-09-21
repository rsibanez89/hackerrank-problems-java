package generalpractice;

import java.util.Scanner;

public class UsingInputOuput {

	public void Run() {
		simpleReadingWriting();
		loopReading();
	}

	private void simpleReadingWriting() {
		// Printing a text in standard output
		System.out.println("This is a simple text");

		Scanner scanner = new Scanner(System.in);

		// Reading a string
		System.out.println("Insert a string");
		String myString = scanner.next();

		// Reading an integer
		System.out.println("Insert an integer");
		int myInt = scanner.nextInt();

		// Reading a float
		System.out.println("Insert a float");
		float myFloat = scanner.nextFloat();

		scanner.close();

		// Printing in standard output
		System.out.println("myString is: " + myString);
		System.out.println("myInt is: " + myInt);
		System.out.println("myFloat is: " + myFloat);
	}
	
	private void loopReading() {
		Scanner scanner = new Scanner(System.in);

		String myString = "";
		
		System.out.println("Insert a text, to finish press CTRL Z");
		while (scanner.hasNext()) {
			// Reading a complete line
			myString = myString + " ** " + scanner.nextLine();
		}
		
		scanner.close();
		
		System.out.println(myString);
	}

	public static void main(String[] args) {
		new UsingInputOuput().Run();
	}
}
