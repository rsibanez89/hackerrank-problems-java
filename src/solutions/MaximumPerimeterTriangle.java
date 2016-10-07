package solutions;

import java.util.ArrayList;
import java.util.Collections;

public class MaximumPerimeterTriangle {

	private static String[] inputs = new String[] { "1 1 1 3 3", "1 2 3", "10 5 5 4" };

	// A triangle is degenerate, if you can not build the triangle, 
	// Example: l0 = 10, l1 = 5, l2 = 5. you can't build that triangle, its has area 0
	// Example: l0 = 10, l1 = 5, l2 = 4. you can't build that triangle, you can't joint the vertices
	// I suppose the numbers are in descending order
	private static boolean isDegenerate(int l0, int l1, int l2) {
		if (l0 >= l1 + l2)
			return true;
		return false;
	}

	public static void main(String[] args) {
		ArrayList<Integer> sticks;
		int l0 = 0;
		int l1 = 0;
		int l2 = 0;
		boolean solution;

		for (String input : inputs) {
			sticks = new ArrayList<>();
			String[] ss = input.trim().split(" ");
			for (int i = 0; i < ss.length; i++)
				sticks.add(Integer.valueOf(ss[i]));
			sticks.sort(Collections.reverseOrder());

			solution = false;

			for (int i = 0; i < sticks.size() - 2 && !solution; i++) {
				l0 = sticks.get(i);
				l1 = sticks.get(i + 1);
				l2 = sticks.get(i + 2);

				// if is degenerated for l0=i, l1=i+1, l2=i+2. 
				// it will be degenerated for l0=i and any combination of l1 and l2, so we advance the iterator

				if (!isDegenerate(l0, l1, l2))
					solution = true;
			}
			if (solution)
				System.out.println(l2 + " " + l1 + " " + l0);
			else
				System.out.println("-1");
		}

	}

}
