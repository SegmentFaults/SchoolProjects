import java.awt.HeadlessException;
import java.util.Arrays;

/**
 * A simple maxheap using ints
 * 
 * @author gentilm5 uses empty spot at 0 from chapter 26
 */
public class MaxHeap {
	private int[] heap;
	private int lastIndex;
	private static int DEFAULT_CAPACITY = 10;

	public MaxHeap() {
		heap = new int[DEFAULT_CAPACITY];
		lastIndex = 0;
	}

	/**
	 * Adds an element to the heap. Puts it in the enxt available spot in the
	 * array. Bubbles it up until it finds a parent who is bigger or it reaches
	 * the root.
	 * 
	 * @param n
	 */
	public void add(int n) {
		checkCapacity();
		lastIndex++;
		heap[lastIndex] = n;

		int childIndex = lastIndex;
		int parentIndex = childIndex / 2;
		while (parentIndex > 0 && heap[childIndex] > heap[parentIndex]) {
			int temp = heap[childIndex];
			heap[childIndex] = heap[parentIndex];
			heap[parentIndex] = temp;

			childIndex = parentIndex;
			parentIndex = childIndex / 2;
		}
	}

	/**
	 * Returns the largest value in the maxheap, which is always at the top of
	 * th heap. 1. Save the value form heap[1] so we can return it 2. Put the
	 * last node value into heap[1], and reduce lastIndex. 3. Rehpea by moving
	 * the root value down until its largest child is smaller.
	 * 
	 * @return
	 */
	public int removeMax() {
		int result = heap[1];
		heap[1]=heap[lastIndex];
		lastIndex--;
		int current=1;
		while (heap[current]<heap[current*2] || heap[current]<heap[current*2+1]){
			if (heap[current*2]>heap[current*2+1]){
				int temp=heap[current];
				heap[current]=heap[current*2];
				heap[current*2]=temp;
				current*=2;
			}
			else{
				int temp=heap[current];
				heap[current]=heap[current*2+1];
				heap[current*2+1]=temp;
				current=current*2+1;
			}
		}
		return result;
	}

	private void checkCapacity() {
		if (lastIndex + 1 == heap.length) {
			heap = Arrays.copyOf(heap, 2 * heap.length);
		}
	}

	/**
	 * 
	 * @return an array with only the elements in it.
	 */
	public int[] toArray() {
		return Arrays.copyOf(heap, lastIndex + 1);
	}

}
