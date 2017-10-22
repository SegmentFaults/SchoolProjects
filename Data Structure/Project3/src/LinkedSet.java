/**
 * 
 */

/**
 * @author gentilm5
 * Prof. Krumpe
 * CSE 274 Wednesday at 8:30
 * This is the Linked Set described in the pdf. This usues a singly linked list with the
 * concept of set kept in mind.
 * This code is my own and used prior book and class examples. 
 */
public class LinkedSet<T> implements Set<T> {
	private Node firstNode;
	/**
	 * Inits with a null firstNode to set that there is actually no content to the Set
	 */
	public LinkedSet(){
		firstNode=null;
	}
	/**
	 * Simply returns the size
	 */
	@Override
	public int getSize() {
		return getLength();
	}

	/**
	 * Returns true if the set is empty
	 */
	@Override
	public boolean isEmpty() {
		if (firstNode==null){
			return true;
		}
		return false;
	}
	/**
	 * Adds an entry if there is nothing else in the set that is identical
	 */
	@Override
	public boolean add(T newEntry) {
		if (!contains(newEntry)){
			Node newNode = new Node(newEntry);
			newNode.next = firstNode;
			firstNode = newNode;
			return true;
		}
		return false;
	}
	/**
	 * Removes an entry from the set by allowing garbage collection to get it by making nothing point to it. 
	 */
	@Override
	public boolean remove(T anEntry) {
		Node n=firstNode;
		n=n.getReferenceTo(anEntry);
		if (n!=null){
			n.data=firstNode.data;
			firstNode=firstNode.next;
			return true;
		}
		return false;
	}
	/**
	 * Removes an entry from the set
	 */
	@Override
	public T remove() {
		int length=getLength();
		T result = null;
		if (length > 0) {
			result = firstNode.data;
			firstNode = firstNode.next;
		}
		return result;
	}
	/**
	 * Sets the first node to null ensuring that nothing can point to anything.
	 */
	@Override
	public void clear() {
		firstNode=null;
		
	}
	/**
	 * returns if something exists in the set.
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
	 * creates a set with all unique values.
	 */
	@Override
	public Set<T> union(Set<T> anotherSet) {
		T[] unionArray = (T[]) anotherSet.toArray();
		T[] array=(T[]) this.toArray();
		LinkedSet<T> temp = new LinkedSet<T>();
		int length=getLength();
		for (int x = 0; x <= unionArray.length; x++) {
			for (int y = 0; y <=length; y++) {
				if (y!=0){
					temp.add(array[y-1]);
				}
				if (x!=0){
					temp.add(unionArray[x-1]);
				}
				
			}
		}
		return temp;
	}
	/**
	 * Creates a set with all non-unique values.
	 */
	@Override
	public Set<T> intersection(Set<T> anotherSet) {
		T[] unionArray = (T[]) new Object[anotherSet.getSize()];
		unionArray = (T[]) anotherSet.toArray();
		T[] array=(T[]) this.toArray();
		int length=this.getLength();
		LinkedSet retArray = new LinkedSet();
		for (int x = 0; x < unionArray.length; x++) {
			for (int y = 0; y < length; y++) {
				if (unionArray[x].equals(array[y])) {
					retArray.add(unionArray[x]);
				}
			}
		}
		return retArray;
	}
	/**
	 * Returns an array representation of the system. 
	 */
	@Override
	public T[] toArray() {
		T[] result = (T[]) new Object[getLength()];

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
	 * 
	 * @return the length of the set. 
	 */
	private int getLength(){
		int length=0;
		Node n=firstNode;
		while(n!=null){
			length++;
			n=n.next;
		}
		return length;
	}
	private class Node {
		private T data;
		private Node next;

		/**
		 * Creates a node with specified data
		 * and pointer to the next node
		 * @param data the data to be stored in this Node
		 * @param next the reference to the next Node
		 */
		private Node(T data, Node next) {
			this.data = data;
			this.next = next;
		}

		/**
		 * Creates a node with specified data
		 * but sets next to null, indicating that
		 * this node does not yet refer to a next node
		 * @param data the data to be stored in this Node
		 */
		private Node(T data) {
			this(data, null);
		}
		private Node getReferenceTo(T anEntry){
			boolean found=false;
			Node currentNode=firstNode;
			while(!found && (currentNode!=null)){
				if (anEntry.equals(currentNode.data)){
					found=true;
				}
				else{
					currentNode=currentNode.next;
				}
				
			}
			return currentNode;
		}
	}
}
