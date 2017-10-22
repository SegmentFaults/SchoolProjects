/*
 * This tests some but not all of the methods of ArrayBag1.java
 */

import static org.junit.Assert.*;
import org.junit.Test;

public class TestBagLab {

	@Test
	public void testAdd() {
		ArrayBag1<String> bag = new ArrayBag1<>(5); // Max capacity 5
		boolean success;
		success = bag.add("A");
		
		// Add the first element
		assertTrue(success);
		assertTrue(bag.contains("A"));
		assertEquals(1, bag.getCurrentSize());
		
		// Add just enough elements to fill the bag
		success = bag.add("B");
		assertTrue(success);
		success = bag.add("C");
		assertTrue(success);
		success = bag.add("D");
		assertTrue(success);
		success = bag.add("E");
		assertTrue(success);
		assertEquals(5, bag.getCurrentSize());
		assertTrue(bag.contains("A"));
		assertTrue(bag.contains("B"));
		assertTrue(bag.contains("C"));
		assertTrue(bag.contains("D"));
		assertTrue(bag.contains("E"));
		
		// Test what happens when adding to a full bag
		success=bag.add("F");
		assertFalse(success);
		assertFalse(bag.contains("F"));
		assertEquals(5, bag.getCurrentSize());

	}
	
	
	@Test
	public void testRemove() {
		ArrayBag1<String> bag = new ArrayBag1<>();
		bag.add("A");
		bag.add("A");
		bag.remove();
		assertFalse(bag.isEmpty());
		assertEquals(1, bag.getCurrentSize());
		
		bag.remove();
		assertTrue(bag.isEmpty());
		assertEquals(0, bag.getCurrentSize());
	}
	
	@Test
	public void testRemoveFromEmptyBag() {
		ArrayBag1<String> bag = new ArrayBag1<>();
		bag.remove();
		bag.remove();
		assertTrue(bag.isEmpty());
	}


	@Test
	public void testRemoveT() {
		ArrayBag1<String> bag = new ArrayBag1<>();
		bag.add("A");
		bag.add("A");
		bag.add("B");
		bag.add("C");
		bag.add("B");
		boolean success;
		
		success = bag.remove("A");		
		assertTrue(success);
		assertEquals(4, bag.getCurrentSize());
		
		success = bag.remove("C");		
		assertTrue(success);
		assertEquals(3, bag.getCurrentSize());
		
		// Removing C when there is no C
		success = bag.remove("C");		
		assertFalse(success);
		assertEquals(3, bag.getCurrentSize());
		
		success = bag.remove("A");
		assertTrue(success);
		success = bag.remove("B");
		assertTrue(success);
		
		assertEquals(1, bag.getCurrentSize());
		assertTrue(bag.contains("B"));
		
		// Removing last item
		success = bag.remove("B");
		assertTrue(success);
		assertTrue(bag.isEmpty());
		
		// Removing from an empty bag
		success = bag.remove("B");
		assertFalse(success);
		assertEquals(0, bag.getCurrentSize());
	}

	@Test
	public void testClear() {
		ArrayBag1<String> bag = new ArrayBag1<>();
		bag.add("A");
		bag.add("B");
		bag.add("C");
		bag.add("B");
		
		bag.clear();
		assertEquals(0, bag.getCurrentSize());		
	}
	
	@Test
	public void testClearEmptyBag() {
		ArrayBag1<String> bag = new ArrayBag1<>();		
		bag.clear();
		
		assertEquals(0, bag.getCurrentSize());		
	}

	@Test
	public void testGetFrequencyOf() {
		ArrayBag1<String> bag = new ArrayBag1<>();
		assertEquals(0, bag.getFrequencyOf("A"));
		
		bag.add("A");
		assertEquals(1, bag.getFrequencyOf("A"));
		assertEquals(0, bag.getFrequencyOf("B"));
		
		bag.add("A");
		bag.add("B");
		assertEquals(2, bag.getFrequencyOf("A"));
		assertEquals(1, bag.getFrequencyOf("B"));
		assertEquals(0, bag.getFrequencyOf("C"));
	}
	@Test
	public void testFullBag(){
		ArrayBag1<Integer> bag=new ArrayBag1<>();
		for (int x=0; x<25; x++){
			bag.add(new Integer(x));
		}
		assertFalse(bag.add(26));
	}

}
