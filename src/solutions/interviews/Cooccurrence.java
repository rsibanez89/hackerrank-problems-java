package solutions.interviews;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Cooccurrence {

	public static void main(String[] args) {
		try {
			String path = "res/cat-in-the-hat.txt";
			Integer k = 3;

			if (args.length == 2) {
				path = args[0];
				k = Integer.valueOf(args[1]);
			}

			List<String> text = new ArrayList<String>();
			Scanner sc = new Scanner(new File(path));
			Pattern regex = Pattern.compile("[^a-zA-Z]"); // everything which is not a text

			// Read the file
			// Time complexity O(3N) -> Read from file, remove characters, replace with lower-case
			while (sc.hasNext()) {
				String next = regex.matcher(sc.next()).replaceAll("").toLowerCase();
				if (!next.isEmpty())
					text.add(next);
			}

			// text.forEach(x -> System.out.println(x));

			// Process the file
			// Time complexity O(KN)
			ListIterator<String> i = text.listIterator();
			HashMap<String, Float> cooccurrence = new HashMap<>();
			HashMap<String, Float> occurrence = new HashMap<>();
			while (i.hasNext()) {
				String A = i.next();
				Float occurrenceA = occurrence.get(A);
				if (occurrenceA == null)
					occurrenceA = 0.0f;
				occurrence.put(A, occurrenceA + 1f);

				// Process all the elements in between i and i-k
				ListIterator<String> left = text.listIterator(i.previousIndex());
				HashSet<String> alreadyCounted = new HashSet<>(); // contains of a set perform better tan a List
				for (int j = 0; j < k && left.hasPrevious(); j++) {
					String B = left.previous();
					if (alreadyCounted.add(B)) {
						String AB = A + "-" + B;
						Float cooccurrenceAB = cooccurrence.get(AB);
						if (cooccurrenceAB == null)
							cooccurrenceAB = 0.0f;
						cooccurrence.put(AB, cooccurrenceAB + 1f);
					}
				}

				// Process all the elements in between i and i+k
				ListIterator<String> right = text.listIterator(i.nextIndex());
				for (int j = 0; j < k && right.hasNext(); j++) {
					String B = right.next();
					if (alreadyCounted.add(B)) {
						String AB = A + "-" + B;
						Float cooccurrenceAB = cooccurrence.get(AB);
						if (cooccurrenceAB == null)
							cooccurrenceAB = 0.0f;
						cooccurrence.put(AB, cooccurrenceAB + 1f);
					}
				}
			}

			// occurrence.forEach((x, y) -> System.out.println(x + " -> " + y));
			// cooccurrence.forEach((x, y) -> System.out.println(x + " -> " + y));

			Scanner stInput = new Scanner(System.in);
			String A = "hat";
			String B = "cat";
			
			// Process every input O(1)
			while (stInput.hasNext()) {
				A = stInput.next();
				B = stInput.next();

				Float occurrenceA = occurrence.get(A);
				Float cooccurrenceAB = cooccurrence.get(A + "-" + B);

				if (occurrenceA == null)
					occurrenceA = 0f;

				if (cooccurrenceAB == null)
					cooccurrenceAB = 0f;

				if (occurrenceA != 0)
					System.out.printf("%.2f\n", cooccurrenceAB / occurrenceA);
				else
					System.out.printf("%.2f\n", 0f);
			}

			sc.close();
			stInput.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// This solution doesn't meet the performance
	private static void firstSolution(String args[]) {
		try {
			String path = "res/cat-in-the-hat.txt";
			Integer k = 3;

			if (args.length == 2) {
				path = args[0];
				k = Integer.valueOf(args[1]);
			}

			List<String> text = new ArrayList<String>();
			Scanner sc = new Scanner(new File(path));

			// Read the file
			// Time complexity O(3N) -> Read from file, remove characters, replace with lower-case
			// I create N Pattern Object that are exactly the same.
			while (sc.hasNext()) {
				text.add(sc.next().replaceAll("[^a-zA-Z ]", "").toLowerCase());
			}

			Scanner stInput = new Scanner(System.in);

			String A = "hat";
			String B = "cat";

			// I'm processing when they put the input, it doesn't meet the performance O(1)
			while (stInput.hasNext()) {
				A = stInput.next();
				B = stInput.next();

				float occurrenceA = 0;
				float cooccurrence = 0;

				for (int i = 0; i < text.size(); i++)
					if (text.get(i).equals(A)) {
						occurrenceA++;

						boolean counted = false;

						// Look for the B in k position to the right
						for (int j = i + 1; j < text.size() && j <= i + k && !counted; j++)
							if (text.get(j).equals(B)) {
								cooccurrence++;
								counted = true;
							}

						// Look for the B in k position to the left
						for (int j = i - 1; j >= 0 && j >= i - k && !counted; j--)
							if (text.get(j).equals(B)) {
								cooccurrence++;
								counted = true;
							}
					}

				if (occurrenceA != 0)
					System.out.printf("%.2f\n", cooccurrence / occurrenceA);
				else
					System.out.printf("%.2f\n", 0f);
			}

			sc.close();
			stInput.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
