import java.util.ArrayList;
import java.util.Arrays;

public class SetTester {
	public static void main(String[] args) {
		// These strings are used to populate our array.
		ArrayList<String> strings = createStrings();
		// The expandable bag we will be testing.
		// shows off constructors
		ResizableArraySet<String> firstSet = new ResizableArraySet<String>();// default
																				// size
																				// 10
		// this second set will be used to union the array
		ResizableArraySet<String> secondSet = new ResizableArraySet<String>();
		// this will be used for intersects.
		ResizableArraySet<String> thirdSet = new ResizableArraySet<String>();
		// populate the area with a good amount of data listed below.

		for (int x = 0; x < strings.size(); x++) {
			// shows off add
			firstSet.add(strings.get(x));
			// populate to properly test union.
			if (x % 2 == 0) {
				secondSet.add(strings.get(x));
				thirdSet.add(strings.get(x));
			}
		}

		// this is where we see the full size of the set
		System.out.println("Expecting to see 30 for the size. ");
		System.out.println(firstSet.getSize());
		System.out.println("We will now remove the first entry. Expecting true.");
		// shows off remove.
		System.out.println(firstSet.remove(strings.get(0)));
		System.out.println("We removed the first thing in the set. Therefore, expecting 29");
		System.out.println(firstSet.getSize());
		System.out.println(
				"This now shows the second set, where only half of the array was initally added.\nExpecting 15");
		System.out.println(secondSet.getSize());

		// testing union
		System.out.println("The sets will now union. The array should be full size. Expecting 30");
		ResizableArraySet<String> unioned = (ResizableArraySet<String>) firstSet.union(secondSet);
		System.out.println(unioned.getSize());
		System.out.println("Clear will now be tested. Expecting 0");
		unioned.clear();
		System.out.println(unioned.getSize());
		System.out.println("Now we will try with an empty set. \n");
		System.out.println("This will populate will the nearly full firstSet");
		System.out.println("Expecting: 29");
		ResizableArraySet<String> unioned2 = (ResizableArraySet<String>) unioned.union(firstSet);
		System.out.println(unioned2.getSize());

		// testing intersection
		System.out.println("Intersecting unioned2 with firstSet. (Should be same) Expecting 29");
		ResizableArraySet<String> intersected = (ResizableArraySet<String>) unioned2.intersection(firstSet);
		System.out.println(intersected.getSize());
		System.out.println("Now intersecting with a sparse set. Expecting: 14");
		System.out.println("This is due to the fact that third set will have 15 characters.");
		System.out.println("And firstSet has 29, missing the a that third set posesses.");
		System.out.println("Expecting 14");
		ResizableArraySet<String> intersected2 = (ResizableArraySet<String>) thirdSet.intersection(firstSet);
		System.out.println(intersected2.getSize());
		secondSet.clear();
		// testing isEmpty
		// secondSet should be empty
		System.out.println("Expecting true");
		System.out.println(secondSet.isEmpty());
		// firstSet is still populated, as seen above.
		System.out.println("Expecting false");
		System.out.println(firstSet.isEmpty());

		// Now we will test the add and remove more in depth
		System.out.println("Expecting 29");
		System.out.println(firstSet.getSize());
		// adding a so the size will increase

		firstSet.add("a");
		System.out.println("Expecting 30");
		System.out.println(firstSet.getSize());
		System.out.println("Expecting true");
		System.out.println(firstSet.remove("a"));
		System.out.println(firstSet.getSize());
		System.out.println("Expecting 29");
		System.out.println("Now add something we know exists. Adding g");
		System.out.println("Expecting false");
		System.out.println(firstSet.add("g"));
		System.out.println("Now check size. Expecting 29");
		System.out.println(firstSet.getSize());
		// check removal without param.
		System.out.println("Now removing the piece on the end");
		System.out.println("Since dd was moved to the front of the set, expected cc");
		System.out.println(firstSet.remove());

		// check contains
		System.out.println("Since cc was just removed, check if contains");
		System.out.println("Expected false");
		System.out.println(firstSet.contains("cc"));
		System.out.println("Check for an intermediate value that has not been tampered with.");
		System.out.println("Expected true");
		System.out.println(firstSet.contains("j"));

		// toArray should be tested.
		System.out.println("Expeting 28 for the Array length because\nwe had just removed one from firstSet");
		Object[] firstAr = firstSet.toArray();
		System.out.println(firstAr.length);

		// now test union with contents.
		ResizableArraySet<Integer> intsUnion = new ResizableArraySet<Integer>();
		ResizableArraySet<Integer> intsUnion2 = new ResizableArraySet<Integer>();
		intsUnion.add(new Integer(1));
		intsUnion.add(new Integer(2));
		intsUnion.add(new Integer(3));
		intsUnion2.add(new Integer(2));
		intsUnion2.add(new Integer(4));
		System.out.println("Now union integers 1,2,3 with 2,4");
		System.out.println("Expected [1, 2, 3, 4]");
		System.out.println(Arrays.toString(intsUnion.union(intsUnion2).toArray()));

		// now check intersects
		System.out.println("Now intersect integers 1,2,3 with 2,4 Expected [2]");
		System.out.println(Arrays.toString(intsUnion.intersection(intsUnion2).toArray()));

		// now try to show the add and remove do the exact opposite.
		System.out.println("Now we will remove one from the set that consists of 1,2,3");
		System.out.println("Expected 3,2");
		
		// this occurs due to shuffling of the array
		intsUnion.remove(new Integer(1));
		System.out.println(Arrays.toString(intsUnion.toArray()));
		System.out.println("Now add the one back in ");
		System.out.println("Expected 3,2,1");
		intsUnion.add(new Integer(1));
		System.out.println(Arrays.toString(intsUnion.toArray()));
		System.out.println("The constructors have both been tested because one calls the other.");
		System.out.println("All methods have been tested.");

	}

	private static ArrayList<String> createStrings() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");
		list.add("f");
		list.add("g");
		list.add("h");
		list.add("i");
		list.add("j");
		list.add("k");
		list.add("l");
		list.add("m");
		list.add("n");
		list.add("o");
		list.add("p");
		list.add("q");
		list.add("r");
		list.add("s");
		list.add("t");
		list.add("u");
		list.add("v");
		list.add("w");
		list.add("x");
		list.add("y");
		list.add("z");
		list.add("aa");
		list.add("bb");
		list.add("cc");
		list.add("dd");
		return list;

	}
}
