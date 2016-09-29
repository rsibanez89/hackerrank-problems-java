package solutions;

public class ArrayLeftRotation {

	// This solution works but gives you a "Terminated due to timeout" result
	private static void solution1() {
		int k = 4;
		int n = 5;
		int[] a = new int[] { 1, 2, 3, 4, 5 };

		int aux;
		for (int rotation = 0; rotation < k; rotation++) {
			aux = a[0];
			for (int i = 0; i < n-1; i++) {
				a[i] = a[i+1];
			}
			a[n-1] = aux;
		}
		for (int i = 0; i < n; i++)
			System.out.print(a[i] + " ");
	}
	
	// This solution works but we are using an temp structure of zise n
	private static void solution2() {
		int k = 4;
		int n = 5;
		int[] a = new int[] { 1, 2, 3, 4, 5 };

		int aux[] = new int[a.length];
		for (int i = 0; i < n; i++) {
			int position = ((i + k) % n);
			aux[i] = a[position];
		}
		System.out.println();
		for (int i = 0; i < n; i++)
			System.out.print(aux[i] + " ");
	}

	public static void main(String[] args) {
		int k = 4;
		int n = 5;
		int[] a = new int[] { 1, 2, 3, 4, 5 };

		// As we just need to print, we don't need to move or use temp structures
		for (int i = 0; i < n; i++)
			System.out.print(a[((i + k) % n)] + " ");
	}

}
