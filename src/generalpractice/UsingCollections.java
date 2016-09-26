package generalpractice;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class UsingCollections {

	/* "Copied form javadoc"
	 * Hashtable is synchronized. 
	 * If a thread-safe implementation is not needed, it is recommended to use HashMap in place of Hashtable. 
	 * If a thread-safe highly-concurrent implementation is desired, then it is recommended to use ConcurrentHashMap in place of Hashtable.
	 */
	private void Run() {
		workingWithList();
		workingWithSet();
		workingWithHashtable();
		workingWithMap();
	}

	public static void workingWithList() {
		System.out.println("--- Working with List ---");
		List<Integer> values = new ArrayList<>();

		values.add(1);
		values.add(2);
		values.add(3);
		values.add(4);
		values.add(5);
		values.add(5);
		values.add(3);
		values.add(4);
		values.add(2);
		values.add(2);

		// Getting all the elements in the List
		Iterator<Integer> i = values.iterator();
		while (i.hasNext())
			System.out.print(i.next() + " ");
		System.out.println();

		System.out.println(values.toString());

		// Sorting all the elements in the List, as the list is Integer it doesn't need a comparator
		values.sort(null);

		// Printing the List by using lambda Java 8
		System.out.println("--- Printing the List by using lambda ---");
		values.forEach(v -> System.out.print(v + " "));
		System.out.println();

		// Getting the elementAt
		System.out.println("values[0]: " + values.get(0));
		System.out.println("values[5]: " + values.toArray()[5]);

		// Removing an element
		values.remove((Object) 3);
		values.forEach(v -> System.out.print(v + " "));
		System.out.println();

		// Removing the elementAt
		values.remove(3);
		values.forEach(v -> System.out.print(v + " "));
		System.out.println();

	}

	public static void workingWithSet() {
		// A Set is collection that contains no duplicate elements
		// A TreeSet is sorted according to the natural ordering of its elements
		System.out.println("--- Working with Set ---");
		Set<Integer> values = new TreeSet<>();

		values.add(1);
		values.add(2);
		values.add(3);
		values.add(4);
		values.add(5);
		values.add(5);
		values.add(3);
		values.add(4);
		values.add(2);
		values.add(2);

		// Getting all the elements in the List
		Iterator<Integer> i = values.iterator();
		while (i.hasNext())
			System.out.print(i.next() + " ");
		System.out.println();

		System.out.println(values.toString());

		// Printing the Set by using lambda Java 8
		System.out.println("--- Printing the Set by using lambda ---");
		values.forEach(v -> System.out.print(v + " "));
		System.out.println();

		// Getting the elementAt (a set is not made for getting the elementAt)
		System.out.println("values[3]: " + values.toArray()[3]);

		// Removing an element
		values.remove((Object) 3);
		values.forEach(v -> System.out.print(v + " "));
		System.out.println();

		// Removing the elementAt (a set is not made for removing the elementAt)
		Object elementAt = values.toArray()[3];
		values.remove(elementAt);
		values.forEach(v -> System.out.print(v + " "));
		System.out.println();
	}
	
	public static void workingWithHashtable() {
		// A Hashtable maps keys to values
		System.out.println("--- Working with Hashtable ---");
		Hashtable<String, Integer> values = new Hashtable<>();

		values.put("One", 1);
		values.put("Two", 2);
		values.put("Three", 3);
		values.put("Four", 5);
		values.put("Five", 5);
		values.put("Six", 6);
		values.put("Seven", 7);

		// If the key is repeated it will replace it, and it will also return the previous value
		System.out.println(values.put("Four", 4));

		String key = "Specific Key";
		values.put(key, new Random().nextInt(100));

		// Getting the Specific Key value
		System.out.println(key + " -> " + values.get(key));

		// Getting all values stored in the Hashtable by using the keys
		for (String k : values.keySet()) {
			System.out.println(k + " -> " + values.get(k));
		}

		// Getting all the elements in the Hashtable
		Enumeration<Integer> e = values.elements();
		while (e.hasMoreElements())
			System.out.print(e.nextElement() + " ");
		System.out.println();

		// Printing the Hashtable by using lambda Java 8
		System.out.println("--- Printing the Hashtable by using lambda ---");
		values.forEach((k, v) -> System.out.println(k + " -> " + v));
	}

	private void workingWithMap() {
		// A HashMap maps keys to values, similar to Hashtable, but its not synchronized.
		// A HashMap should perform better for non-threaded applications.
		System.out.println("--- Working with HashMap ---");
		Map<String, Integer> values = new HashMap<>();

		values.put("One", 1);
		values.put("Two", 2);
		values.put("Three", 3);
		values.put("Four", 5);
		values.put("Five", 5);
		values.put("Six", 6);
		values.put("Seven", 7);

		// If the key is repeated it will replace it, and it will also return the previous value
		System.out.println(values.put("Four", 4));

		String key = "Specific Key";
		values.put(key, new Random().nextInt(100));

		// Getting the Specific Key value
		System.out.println(key + " -> " + values.get(key));

		// Getting all values stored in the HashMap by using the keys
		for (String k : values.keySet()) {
			System.out.println(k + " -> " + values.get(k));
		}

		// Getting all the elements in the HashMap
		for(Integer value : values.values())
			System.out.print(value + " ");
		System.out.println();

		// Printing the HashMap by using lambda Java 8
		System.out.println("--- Printing the HashMap by using lambda ---");
		values.forEach((k, v) -> System.out.println(k + " -> " + v));
	}

	public static void main(String[] args) {
		new UsingCollections().Run();
	}
}
