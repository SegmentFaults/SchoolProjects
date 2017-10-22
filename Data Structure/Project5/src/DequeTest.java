import static org.junit.Assert.*;

import org.junit.Test;

/*
* @author gentilm5
* Prof. Krumpe
* CSE 274
* This is the double ended Queue tester. This is the class specified by the description online.
* All code produced by me utilizing the book.
*/
public class DequeTest {

	@Test
	public void testAddToFront() {
		CircularChainDeque<String> strings = new CircularChainDeque<>();
		strings.addToFront("a");// one in
		strings.addToFront("b");// two in
		strings.addToFront("c");// three in
		assertEquals(strings.getFront(), "c");
		strings.removeFront();// two in
		assertEquals(strings.getFront(), "b");
		strings.removeFront();// one in
		assertEquals(strings.getFront(), "a");
		strings.removeFront();// zero in
		strings.addToFront("d");// add to front of empty list. one in
		assertEquals(strings.removeFront(), "d");// one in
	}

	@Test(expected = EmptyQueueException.class)
	public void testAddToBack() {
		CircularChainDeque<String> strings = new CircularChainDeque<>();
		strings.addToBack("a");// one in q
		strings.addToBack("b");// two in q
		strings.addToBack("c");// three in q
		assertEquals(strings.getBack(), "c");// retrieve the last one
		strings.removeBack();// remove back. two in q
		assertEquals(strings.getBack(), "b");
		strings.removeBack();// one in q
		assertEquals(strings.getBack(), "a");
		strings.removeBack();// 0 in q now.
		strings.removeBack();// thows the exception.
	}

	@Test(expected = EmptyQueueException.class)
	public void testRemoveFront() {
		CircularChainDeque<Integer> ints = new CircularChainDeque<Integer>();
		ints.addToFront(new Integer(1));// one in q
		ints.addToFront(new Integer(2));// two in q
		ints.addToFront(new Integer(3));// three in q
		assertEquals(ints.removeFront(), new Integer(3));// two in q
		assertEquals(ints.removeFront(), new Integer(2));// one in q
		assertEquals(ints.removeFront(), new Integer(1));// 0 in q
		ints.removeFront();// throws the exception
	}

	@Test(expected = EmptyQueueException.class)
	public void testRemoveBack() {
		CircularChainDeque<String> strings = new CircularChainDeque<>();
		strings.addToBack("a");// one in
		strings.addToBack("b");// two in
		strings.addToBack("c");// three in
		assertEquals(strings.removeBack(), "c");// two in
		assertEquals(strings.removeBack(), "b");// one in
		assertEquals(strings.removeBack(), "a");// zero in
		strings.removeBack();// removes one too many from back.
	}

	@Test
	public void testIsEmpty() {
		CircularChainDeque<Integer> ints = new CircularChainDeque<Integer>();
		assertTrue(ints.isEmpty());// zero in
		ints.addToFront(new Integer(1));// one in
		assertFalse(ints.isEmpty());// one in
		ints.addToFront(new Integer(2));// two in
		ints.addToFront(new Integer(3));// three in
		assertFalse(ints.isEmpty());
	}

	@Test(expected = EmptyQueueException.class)
	public void testClear() {
		CircularChainDeque<Integer> ints = new CircularChainDeque<Integer>();
		ints.addToFront(new Integer(1));
		ints.addToFront(new Integer(2));
		ints.addToFront(new Integer(3));
		ints.clear();
		ints.getFront();// throws exception for being cleared.
	}

	@Test(expected = EmptyQueueException.class)
	public void testFrontPeek() {
		// this is to test for empty peek exceptions. If the queue is empty, the
		// peek should return an empty queue.
		CircularChainDeque<Integer> ints = new CircularChainDeque<Integer>();
		ints.getFront();

	}

	@Test(expected = EmptyQueueException.class)
	public void testBackPeek() {
		// this is to test for empty peek exceptions. If the queue is empty, the
		// peek should return an empty queue.
		// Peek was tested within the add methods. The exception was not.
		CircularChainDeque<Integer> ints = new CircularChainDeque<Integer>();
		ints.getBack();
	}

	@Test
	public void comboTester() {
		// this is to make sure the methods gel well together
		CircularChainDeque<String> strings = new CircularChainDeque<String>();

		// front and front
		strings.addToFront("Entry 1");
		strings.addToFront("Entry 2");
		strings.addToFront("Entry 3");
		strings.addToFront("Entry 4");
		// this should be entry 4, 3, 1, 2.
		assertEquals(strings.removeFront(), "Entry 4");
		assertEquals(strings.removeFront(), "Entry 3");
		assertEquals(strings.removeFront(), "Entry 2");
		assertEquals(strings.removeFront(), "Entry 1");

		// now let's recreate it and try it from the back.
		// front and back
		strings.addToFront("Entry 1");
		strings.addToFront("Entry 2");
		strings.addToFront("Entry 3");
		strings.addToFront("Entry 4");

		assertEquals(strings.removeBack(), "Entry 1");
		assertEquals(strings.removeBack(), "Entry 2");
		assertEquals(strings.removeBack(), "Entry 3");
		assertEquals(strings.removeBack(), "Entry 4");

		// let's recreate it and try adding from back and remving from front
		// back and front
		strings.addToBack("Entry 1");
		strings.addToBack("Entry 2");
		strings.addToBack("Entry 3");
		strings.addToBack("Entry 4");

		assertEquals(strings.removeFront(), "Entry 1");
		assertEquals(strings.removeFront(), "Entry 2");
		assertEquals(strings.removeFront(), "Entry 3");
		assertEquals(strings.removeFront(), "Entry 4");

		assertTrue(strings.isEmpty());
	}
}
