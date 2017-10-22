import java.util.Arrays;
import java.util.Random;

public class ResizableArraySet<T> implements Set<T> {
	private int counter;
	private T[] array;

	/**
	 * Base constructor with a default size of 10. Calls other constructor to
	 * initalize the rest of the system.
	 */
	ResizableArraySet() {
		this(10);
	}

	/**
	 * 
	 * @param startingSize
	 *            is the size of the unpopulated array.
	 */
	ResizableArraySet(int startingSize) {
		@SuppressWarnings("unchecked")
		T[] tempArray = (T[]) new Object[10];
		array = tempArray;
		counter = 0;
	}

	/**
	 * @return the size of the array
	 */
	@Override
	public int getSize() {
		return counter;
	}

	/**
	 * returns if the array is populated.
	 */
	@Override
	public boolean isEmpty() {
		if (counter == 0) {
			return true;
		}
		return false;
	}

	/**
	 * @param object
	 *            to add to the end of the
	 * @return whether the object was added correctly or not.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean add(Object newEntry) {
		int index = 0;
		while (index < this.counter) {
			if (array[index].equals(newEntry)) {
				return false;
			}

			index++;
		}
		ensureSize(true);
		array[counter] = (T) newEntry;
		counter++;
		return true;
	}

	/**
	 * @param object
	 *            to remove.
	 * @return if found, return true
	 */
	@Override
	public boolean remove(Object anEntry) {
		int index = 0;
		while (index < this.counter) {
			if (array[index].equals(anEntry)) {
				array[index] = array[counter - 1];
				array[counter - 1] = null;
				counter--;
				ensureSize(false);
				return true;
			}
			index++;
		}
		return false;
	}

	/**
	 * removes from the end of the system.
	 */
	@Override
	public T remove() {
		if (counter == 0) {
			return null;
		} else {
			T objectRet = array[counter - 1];
			array[array.length - 1] = null;
			counter--;
			ensureSize(false);
			return objectRet;
		}

	}

	/**
	 * remove the whole listing and set the last index to null so that it does
	 * not destroy the system.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		while (counter != 0) {
			remove();
			if (counter == 0) {
				array[0] = null;
			}
		}
	}

	/**
	 * @return if the system contains the selected entry
	 */
	@Override
	public boolean contains(Object anEntry) {
		for (int x = 0; x < counter; x++) {
			if (array[x].equals(anEntry)) {
				return true;
			}
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	/**
	 * @param another
	 *            set to be combined.
	 * @return a ResizeableSet that has all of the two sets combined within it.
	 */
	public Set union(Set anotherSet) {
		T[] unionArray = (T[]) anotherSet.toArray();
		ResizableArraySet<T> temp = new ResizableArraySet<T>();
		for (int x = 0; x <= unionArray.length; x++) {
			for (int y = 0; y <= counter; y++) {
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
	 * @param another
	 *            set to find where they match.
	 * @returns a new Resizeable set that contains only what matches.
	 */
	@Override
	public Set intersection(Set anotherSet) {
		T[] unionArray = (T[]) new Object[anotherSet.getSize()];
		unionArray = (T[]) anotherSet.toArray();
		ResizableArraySet retArray = null;
		if (unionArray.length > counter) {
			retArray = new ResizableArraySet(unionArray.length);
		} else {
			retArray = new ResizableArraySet(counter);
		}
		for (int x = 0; x < unionArray.length; x++) {
			for (int y = 0; y < counter; y++) {
				if (unionArray[x].equals(array[y])) {
					retArray.add(unionArray[x]);
				}
			}
		}
		return retArray;
	}

	@SuppressWarnings("unchecked")
	@Override
	/**
	 * @return an array of objects of the size of the size of the populated set.
	 */
	public T[] toArray() {
		T[] newAr = (T[]) new Object[counter];
		for (int x = 0; x < counter; x++) {
			newAr[x] = array[x];
		}
		return newAr;
	}

	/**
	 * 
	 * @param growing
	 *            whether or not the system is shrinking or growing.
	 */
	private void ensureSize(boolean growing) {
		if (array.length == counter) {
			T[] newArray = (T[]) new Object[array.length * 2];
			newArray = Arrays.copyOf(array, array.length * 2);
			this.array = newArray;
		} else if (counter * 2 < array.length && !growing) {
			T[] newArray = (T[]) new Object[counter / 2];
			newArray = Arrays.copyOf(array, array.length / 2);
			this.array = newArray;
		}
	}

}
