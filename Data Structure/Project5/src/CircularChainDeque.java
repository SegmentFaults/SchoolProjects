/**
 * 
 * @author gentilm5 Prof. Krumpe CSE 274 This is the double ended Queue. This is
 *         the class specified by the description online. All code produced by
 *         me utilizing the book.
 */
public class CircularChainDeque<T> implements DequeInterface<T> {

	/**
	 * What works properly: You can add things to the front of the queue and it
	 * would reference cirularly. This will also work to the back. Things can be
	 * removed from the front and it will reverse the actions of the addition.
	 * This works from the back as well. Removing throws an error only when the
	 * queue is empty. This has been tested so that when there is one item left
	 * it doesn't recurse through two items endlessly. Adding to the front and
	 * back of an empty queue works. Adding to the front and back of an already
	 * populate queue works.
	 * 
	 * The peeks work properly so that they do not modify data. They show only
	 * the data that is requested. They throw exceptions when the queue is
	 * empty. These things work for both the front and that back.
	 * 
	 * Clear works when populated as well as unpopulated. isEmpty works from a
	 * fresh queue as well as a freshly cleared, previously populated queue
	 */
	private Node firstNode;

	CircularChainDeque() {
		firstNode = null;// create a node and make it null
	}

	@Override
	public void addToFront(T newEntry) {
		if (isEmpty()) {
			firstNode = new Node(newEntry);// init the set.
			firstNode.next = firstNode;// make it circular
			firstNode.previous = firstNode;
		} else {
			Node temp = firstNode;
			firstNode = new Node(newEntry, firstNode, firstNode.previous);

			firstNode.next = temp;
			temp.previous = firstNode;
		}
	}

	@Override
	public void addToBack(T newEntry) {
		if (isEmpty()) {
			firstNode = new Node(newEntry);// init the list.
			firstNode.next = firstNode;
			firstNode.previous = firstNode;// make it circular
		} else {
			Node temp = firstNode.previous;
			Node newNode = new Node(newEntry, firstNode, firstNode.previous);
			temp.next = newNode;
			firstNode.previous = newNode;// establish the last node as the
											// previous last. so last.last
		}

	}

	@Override
	public T removeFront() {
		if (firstNode == null) {
			throw new EmptyQueueException("There is nothing in the front.");// if
																			// there
																			// is
																			// nothing
																			// there
																			// throw
																			// an
																			// exception
		} else if (firstNode.next == firstNode || firstNode.previous == firstNode) {
			Node temp = firstNode;
			firstNode = null;
			return temp.data;
		} else {
			Node temp = firstNode;// take the front and set it the next. then
									// return the old front.
			firstNode = temp.next;
			firstNode.previous = temp.previous;
			return (T) temp.data;
		}
	}

	@Override
	public T removeBack() {
		if (firstNode == null) {
			throw new EmptyQueueException("There is nothing in the back.");// if
																			// there
																			// is
																			// nothing
																			// there
																			// throw
																			// an
																			// error
		} else if (firstNode.previous == firstNode || firstNode.next == firstNode) {
			Node temp = firstNode.previous;
			firstNode = null;
			return temp.data;
			// throw new EmptyQueueException("There is nothing in the back.");
		} else {
			Node temp = firstNode.previous;// get one we want to get rid of
			firstNode.previous = firstNode.previous.previous;
			return (T) temp.data;
		}
	}

	@Override
	public T getFront() {
		if (firstNode == null) {
			throw new EmptyQueueException("Queue is empty.");
		} else
			return (T) firstNode.data;
	}

	@Override
	public T getBack() {
		if (firstNode == null) {
			throw new EmptyQueueException("Queue is empty.");
		} else
			return (T) firstNode.previous.data;
	}

	@Override
	public boolean isEmpty() {
		return firstNode == null;
	}

	@Override
	public void clear() {
		firstNode = null;

	}

	private class Node {
		private T data;
		private Node next;
		private Node previous;

		/**
		 * Creates a node with specified data and pointer to the next node
		 * 
		 * @param data
		 *            the data to be stored in this Node
		 * @param next
		 *            the reference to the next Node
		 */
		private Node(T data, Node next, Node previous) {
			this.data = data;
			this.next = next;
			this.previous = previous;
		}

		/**
		 * Creates a node with specified data but sets next to null, indicating
		 * that this node does not yet refer to a next node
		 * 
		 * @param data
		 *            the data to be stored in this Node
		 */
		private Node(T data) {
			this(data, null, null);
		}
	}
}
