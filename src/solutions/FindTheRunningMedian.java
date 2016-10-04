package solutions;

import java.util.ArrayList;
import java.util.Collections;

public class FindTheRunningMedian {

	private static String[] inputs = new String[] { "12", "4", "5", "3", "8", "7" };

	// Return the index where I should insert the toInsert to keep the list in order 
	private static int getIndex(ArrayList<Integer> list, Integer toInsert){
		int index = 0;
		for (int i = 0; i < list.size(); i++)
			if (list.get(i) > toInsert){
				index = i;
				break;
			}
		return index;
	}
	
	// Return the index where I should insert the toInsert to keep the list in order 
	private static int getIndex2(ArrayList<Integer> list, Integer toInsert){
		if(list.isEmpty())
			return 0;
		int index = Collections.binarySearch(list, toInsert);
		if(index < 0)
			index = ~index;
		return index;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		for (String input : inputs) {
			Integer toInsert = Integer.valueOf(input);
			//int index = getIndex(list, toInsert);
			int index = getIndex2(list, toInsert);

			list.add(index,toInsert);
			float value = 0;
			int middle = list.size()/2;
			if(list.size() % 2 == 0)	
				value = (list.get(middle-1) + list.get(middle))/2f;
			else
				value = list.get(middle);
			System.out.printf("%.1f", value);
			
			System.out.println(list);
		}

	}

}
