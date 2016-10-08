package solutions;

public class DFSConectedCellInAGrid {

	private static String[] inputs = new String[] { "4", "4", " 1 1 0 0", "0 1 1 0", "0 0 1 0", "1 0 0 0" };

	private static void print(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++)
				System.out.print(matrix[i][j] + " ");
			System.out.println();
		}
	}

	private static int DFS(int[][] matrix, int i, int j) {

		matrix[i][j] = 0;
		int largestRegion = 1;
		int n = matrix.length;
		int m = matrix[0].length;

		// can move up
		if (i - 1 >= 0) {
			int iUp = i - 1;

			// left up
			if ((j - 1 >= 0) && matrix[iUp][j - 1] == 1)
				largestRegion += DFS(matrix, iUp, j - 1);

			// up
			if (matrix[iUp][j] == 1)
				largestRegion += DFS(matrix, iUp, j);

			// right up
			if ((j + 1 < m) && matrix[iUp][j + 1] == 1)
				largestRegion += DFS(matrix, iUp, j + 1);
		}

		// left
		if ((j - 1 >= 0) && matrix[i][j - 1] == 1)
			largestRegion += DFS(matrix, i, j - 1);

		// right
		if ((j + 1 < m) && matrix[i][j + 1] == 1)
			largestRegion += DFS(matrix, i, j + 1);

		// can move down
		if (i + 1 < n) {
			int idown = i + 1;

			// left down
			if ((j - 1 >= 0) && matrix[idown][j - 1] == 1)
				largestRegion += DFS(matrix, idown, j - 1);

			// down
			if (matrix[idown][j] == 1)
				largestRegion += DFS(matrix, idown, j);

			// right down
			if ((j + 1 < m) && matrix[idown][j + 1] == 1)
				largestRegion += DFS(matrix, idown, j + 1);
		}

		return largestRegion;
	}

	public static void main(String[] args) {

		int n = Integer.valueOf(inputs[0]);
		int m = Integer.valueOf(inputs[1]);
		int matrix[][] = new int[n][m];
		for (int i = 0; i < n; i++) {
			String[] row = inputs[i + 2].trim().split(" ");
			for (int j = 0; j < m; j++)
				matrix[i][j] = Integer.valueOf(row[j]);
		}
		print(matrix);

		int largestRegion = 0;

		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				if (matrix[i][j] == 1) {
					int lr = DFS(matrix, i, j);
					if (lr > largestRegion)
						largestRegion = lr;
				}

		System.out.println(largestRegion);

	}

}
