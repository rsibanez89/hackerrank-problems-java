package solutions;

public class Polygons {

	private static String[] inputs = new String[] { "36 30 36 30", "15 15 15 15", "46 96 90 100", "86 86 86 86",
			"100 200 100 200", "-100 200 -100 200" };

	public static void main(String[] args) {
		int[] polygon = new int[4];
		String[] sPolygon;
		int s = 0;
		int r = 0;
		int p = 0;
		boolean typeFounded;
		for (String input : inputs) {
			typeFounded = false;
			sPolygon = input.trim().split(" ");
			for (int i = 0; i < 4 && !typeFounded; i++) {
				polygon[i] = Integer.parseInt(sPolygon[i]);
				if (polygon[i] <= 0) {
					p++;
					typeFounded = true;
				}
			}
			if (!typeFounded) {
				if ((polygon[0] == polygon[1]) && (polygon[1] == polygon[2]) && (polygon[2] == polygon[3]))
					s++;
				else if ((polygon[0] == polygon[2]) && (polygon[1] == polygon[3]))
					r++;
				else
					p++;
			}
		}
		System.out.println(s + " " + r + " " + p);
	}
}
