package solutions;

import java.util.ArrayList;

public class GemStones {

	private static String[] inputs = new String[] { "abcdde", "baccd", "eeabg" };

	public static void main(String[] args) {

		ArrayList<Character> gem = new ArrayList<>();
		ArrayList<Character> checked = new ArrayList<>();
		String firtStone = inputs[0];
		for (int i = 0; i < firtStone.length(); i++)
		{
			Character toCheck = firtStone.charAt(i);
			boolean isGem = true;
			if (!checked.contains(toCheck)) {
				checked.add(toCheck);
				for (int j = 1; j < inputs.length; j++) {
					if(!inputs[j].contains(toCheck.toString()))
					{
						isGem = false;
						break;
					}
				}
				if(isGem)
					gem.add(toCheck);
			}
		}
		System.out.println(gem.size());
	}

}
