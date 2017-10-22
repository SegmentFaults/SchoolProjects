import java.util.Arrays;

public class Tester {

	public static void main(String[] args) {
		MaxHeap mh = new MaxHeap();

		for (int i = 0; i <= 10; i++) {
			int val = (int) (200 * Math.random()+1);
			mh.add(val);
		}
		System.out.println(Arrays.toString(mh.toArray()));
		mh.removeMax();
		System.out.println(Arrays.toString(mh.toArray()));
	}
}
