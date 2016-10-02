package solutions.gametheory;

public class ChocolateInBox {

	private static String[] inputs = new String[] { "3", "4 4 4" };

	// nimSum return the XOR of all the elements in the array
	private static int nimSum(int[] boxes)
	{
		int ret = boxes[0];
		for (int i = 1; i < boxes.length; i++)
			ret = ret ^ boxes[i];
		return ret;
	}
	
	private static void print(int[] boxes) {
		System.out.print("Boxes = ");
		for (int i = 0; i < boxes.length; i++)
			System.out.print(boxes[i] + " ");
		System.out.println(" XOR = " + nimSum(boxes));
	}
	
	// This solution uses the NIM algorithm: https://en.wikipedia.org/wiki/Nim
	// Compute the nimSum() that is the XOR of all the elements in the array
	// If nimSum() == 0 there is not winning strategy
	// Else play in such a way nimSum() == 0 and keep playing like this until finish.
	// To play in such a way nimSum() == 0, I need to find a box that (nimSum() ^ boxes[i]) < boxes[i]
	public static void main(String[] args) {
		int n = Integer.valueOf(inputs[0]);
		String[] sBoxes = inputs[1].split(" ");
		int[] boxes = new int[n];
		for (int i = 0; i < sBoxes.length; i++)
			boxes[i] = Integer.valueOf(sBoxes[i]);

		print(boxes);

		int a = nimSum(boxes);
		
		int counter = 0;
		if (a == 0) // nimSum = 0 means that there is not solution
			System.out.println("There is no solution...");
		else {
			for (int i = 0; i < boxes.length; i++)
				if ((a ^ boxes[i]) < boxes[i]){
					counter++;
					int store = boxes[i];
					boxes[i] = boxes[i] ^ a;
					print(boxes); // This is the staring strategy
					boxes[i] = store;
				}
			System.out.println("There are " + counter + " solutions");
		}
	}

}
