import static org.junit.Assert.*;

import org.junit.Test;

public class AListTest {

	// Make sure an empty list works as expected, including: isEmpty should be
	// true, length should be 0, toArray should give back an empty array,
	// contains should give back false.
	@Test
	public void testAList() {
		ListInterface<String> emptyList = new AList<>();

		assertTrue(emptyList.isEmpty());
		assertEquals(0, emptyList.getLength());
		assertFalse(emptyList.contains("cat"));

		Object[] expected = {};
		Object[] result = emptyList.toArray();

		assertArrayEquals(expected, result);

	}

	@Test
	public void testIsEmpty() {
		ListInterface<String> list = new AList<>();
		assertTrue(list.isEmpty());
		list.add("cat");
		assertFalse(list.isEmpty());
	}

	// test adding to end of list
	@Test
	public void testAddToEnd() {
		ListInterface<String> list = new AList<>();
		list.add("a");

		assertTrue(list.contains("a"));
		assertEquals(1, list.getLength());
		assertEquals("a", list.getEntry(1));
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");

		String[] result = { "a", "b", "c", "d", "e" };
		assertArrayEquals(result, list.toArray());

	}

	// Test index out of bounds when accessing an invalid position
	@Test(expected = IndexOutOfBoundsException.class)
	public void testBadIndex() {
		ListInterface<String> list = new AList<>();
		list.getEntry(1);

	}

	/**
	 * Now I need to test clear and remove on my own.
	 */

	// This is testing the clear method.
	@Test
	public void testClear() {
		ListInterface<String> list = new AList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.clear();
		assertFalse(list.contains("a"));
		assertFalse(list.contains("b"));
		assertFalse(list.contains("c"));
		assertTrue(list.getLength() == 0);// here was the error. I corrected the
											// code.
	}

	// Test the remove method. Add 5 elements, remove the first, the last and
	// the middle. Ensure the size is appropraite. Ensure it handles incorrect
	// with an exception.
	@Test(expected = IndexOutOfBoundsException.class)
	public void testRemove() {

		ListInterface<String> list = new AList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");
		// System.out.println(Arrays.toString(list.toArray()));
		assertTrue(list.remove(5) == "e");// test the end
		assertTrue(list.remove(1) == "a");// test the beginning
		assertTrue(list.remove(2) == "c");// test the middle
		assertTrue(list.getLength() == 2);// make sure size is taken care of
		list.remove(3); // expect an error.

	}
}
