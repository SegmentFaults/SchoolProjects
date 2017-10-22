import javax.swing.event.AncestorEvent;

/**
 * A linked implementation of Bag. This uses a private inner class to represent
 * the Node. Why? Because this Node class is only needed in order to support the
 * implementation of the LinkedBag class. Since no other programmers would want
 * to use our Node class, we can make it an inner class.
 * 
 * Note that even though the Node class is private, with private data, the outer
 * class has full access to it. This makes it easier to work with (lets us skip
 * writing getters and setters). HOWEVER... it is always a good idea to write
 * getters and setters. That can be done later.
 */
public class LinkedBag<T> implements BagInterface<T> {

	// Points to the first node in the list, or is
	// null if there are no nodes.
	private Node firstNode;
	// We could get away without this variable, but
	// then we would need to iterate through the bag
	// every time we want to know how many elements
	// are in it. So, this variable makes things easier.
	private int numberOfEntries;

	/**
	 * Creates an empty bag (no nodes)
	 */
	public LinkedBag() {
		firstNode = null;
		numberOfEntries = 0;
	}

	/**
	 * Gets an array containing all the items in the bag, including
	 * duplicates. @ return the array of items in the bag
	 */
	public T[] toArray() {

		// The cast is safe because the new array contains null entries.
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Object[numberOfEntries];

		int index = 0;
		Node current = firstNode;
		while (current != null) {
			result[index] = current.data;
			current = current.next;
			index++;
		}

		return result;
	}

	/**
	 * Adds the specified data to this bag.
	 * 
	 * @param newEntry
	 *            The data to be added
	 * @return true if the item was successfully added and false otherwise.
	 *         Running out of memory should be the only reason this fails.
	 */
	public boolean add(T newEntry) {
		Node newNode = new Node(newEntry);
		newNode.next = firstNode;
		firstNode = newNode;
		numberOfEntries++;
		return true;
	}

	/**
	 * Gets the number of items in the bag
	 * 
	 * @return the number of items in the bag
	 */
	@Override
	public int getCurrentSize() {
		return numberOfEntries;
	}

	/**
	 * Gets whether the bag is empty (zero elements)
	 * 
	 * @return true if the bag is empty and false otherwise
	 */
	@Override
	public boolean isEmpty() {
		return numberOfEntries == 0;
	}

	/**
	 * Removes an item from the bag, if one exists
	 * 
	 * @return some item from the bag, or null if the bag contains no items
	 */
	@Override
	public T remove() {
		T result = null;
		if (numberOfEntries > 0) {
			result = firstNode.data;
			firstNode = firstNode.next;
			numberOfEntries--;
		}
		return result;
	}

	/**
	 * Removes an occurrence of a specific item from the bag, if one exists
	 * 
	 * @param anEntry
	 *            the item to be removed from the bag
	 * @return true if an occurrence of the item is removed, and false otherwise
	 *         (which happens if the item is not in the list)
	 */
	@Override
	public boolean remove(T anEntry) {
		Node current = firstNode;
		while (current != null) {
			if (current.data.equals(anEntry)) {
				current.data = firstNode.data;
				firstNode = firstNode.next;
				numberOfEntries--;
				return true;
			} else {
				current = current.next;
			}
		}

		return false;
	}

	/**
	 * Removes all items from the list.
	 */
	@Override
	public void clear() {
		firstNode = null;
		numberOfEntries = 0;
	}

	/**
	 * Counts the number of times a given item appears in the bag
	 * 
	 * @param anEntry
	 *            the item to be counted
	 * @return the number of times anEntry appears in the bag
	 */
	@Override
	public int getFrequencyOf(T anEntry) {
		int count = 0;
		Node current = firstNode;
		for (int x = 0; x < numberOfEntries; x++) {
			if (current.data.equals(anEntry)) {
				count++;
			}
			current = current.next;
		}
		return count;
	}

	/**
	 * Determines whether a given item occurs in the bag
	 * 
	 * @param anEntry
	 *            The item sought
	 * @return true if the item is found and false otherwise
	 */
	@Override
	public boolean contains(T anEntry) {
		Node current = firstNode;
		while (current != null) {
			if (current.data.equals(anEntry)) {
				return true;
			} else {
				current = current.next;
			}
		}
		return false;
	}

	/**
	 * The private inner class that directly supports our LinkedBag
	 * implementation of Bag
	 * 
	 * @author Norm Krumpe
	 *
	 */
	private class Node {
		private T data;
		private Node next;

		/**
		 * Creates a node with specified data and pointer to the next node
		 * 
		 * @param data
		 *            the data to be stored in this Node
		 * @param next
		 *            the reference to the next Node
		 */
		private Node(T data, Node next) {
			this.data = data;
			this.next = next;
		}

		/**
		 * Creates a node with specified data but sets next to null, indicating
		 * that this node does not yet refer to a next node
		 * 
		 * @param data
		 *            the data to be stored in this Node
		 */
		private Node(T data) {
			this(data, null);
		}
	}
}
