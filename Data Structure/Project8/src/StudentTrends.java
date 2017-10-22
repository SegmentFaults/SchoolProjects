import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Your implementation of the Trends interface. The only public methods in this
 * class should be the ones that implement the interface. You should write as
 * many other private methods as needed. Of course, you should also have a
 * public constructor.
 * 
 * @author Michael Gentile
 */

public class StudentTrends implements Trends {
	private TrendHashMap h;
	private Trend[] sortedTrendArray = new Trend[100000];
	private boolean firstTime = true;
	private int size = 0;
	private boolean sorted = false;

	public StudentTrends() {
		h = new TrendHashMap();
	}

	@Override
	public void increaseCount(String s, int amount) {
		Trend t = h.find(new Trend(s));
		if (t != null) {
			t.setCount(t.getCount() + amount);
			sorted = false;
			// System.out.println(sorted);
			// bubbleSort(sortedTrendArray);
		} else {
			Trend q = new Trend(amount, s);
			h.add(q);
			sortedTrendArray[size] = q;
			size++;
			sorted = false;
			// System.out.println(sorted);
			// bubbleSort(sortedTrendArray);
			// System.out.println("We running");
		}
	}

	@Override
	public int getCount(String s) {
		Trend t = h.find(new Trend(s));
		if (t != null)
			return t.getCount();
		else
			return 0;
	}

	@Override
	public String getNthMostPopular(int n) {
		if (firstTime) {
			Arrays.sort(sortedTrendArray, 0, size);
			firstTime = false;
			sorted = true;
			// System.out.println("ran super sort");
		}
		if (!sorted) {
			// long startTime = System.nanoTime();
			/// System.out.println();
			//Arrays.sort(sortedTrendArray, 0,size);
			// System.out.println("ran bubble sort.");
			insertionSort(sortedTrendArray);
			// long endTime = System.nanoTime();
			// double test4 = (endTime - startTime) / 1000000000.0;
			// System.out.println(test4+"fake");
			sorted = true;
			// System.out.println(sorted);
		}
		if (size < 2) {
			return h.findNthMostPopular(n).getString();
		} else {
			// bubbleSort(sortedTrendArray);
			// System.out.print(h.findNthMostPopular(n).getString()+" vs ");
			// System.out.println(sortedTrendArray[n].getString());
			return sortedTrendArray[n].getString();

		}

	}

	@Override
	public int numEntries() {
		return size;
		// return h.currentSize();
	}

	public void bubbleSort(Trend[] x) {
		boolean doMore = true;
		if (size > 2) {
			while (doMore) {
				doMore = false; // assume this is last pass over array
				for (int i = 0; i < size - 1; i++) {
					if (x[i].compareTo(x[i + 1]) < 0) {
						// exchange elements
						Trend temp = x[i];
						x[i] = x[i + 1];
						x[i + 1] = temp;
						doMore = true; // after an exchange, must look again
					}
				}
			}
		}

	}

	public void insertionSort(Trend[] arr) {
		for (int i = 1; i < size; i++) {
            Trend temp = arr[i];
            int j;
            for (j = i; j > 0 && arr[j - 1].compareTo(temp) > 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
        }
	}

	private class TrendHashMap {
		private int INIT_SIZE = 171476;// amount of words in the english
										// language
		Trend[] trends;
		Trend availabeT = new Trend(-1, "peanutButter");

		@SuppressWarnings("unused")
		TrendHashMap() {
			trends = new Trend[INIT_SIZE];
		}

		public void add(Trend t) {
			int hash = exists(t);
			if (hash == -1) {
				trends[Math.abs(t.getString().hashCode() % INIT_SIZE)] = t;
			} else {
				// do nothing
			}
		}

		public void remove(Trend t) {
			int hash = exists(t);
			if (hash == -1) {
				// do nothing
			} else {
				trends[hash] = availabeT;
			}
		}

		private Trend find(Trend t) {
			int x = Math.abs(t.getString().hashCode() % INIT_SIZE);
			while (trends[x] != null) {
				if (trends[x].getString().equals((t.getString()))) {
					return trends[x];
				}
				x++;
			}
			return null;
		}

		private int exists(Trend t) {
			// send this the moded hash
			int x = t.hashCode() % INIT_SIZE;
			while (trends[x] != null) {
				if (trends[x].equals(t)) {
					return x;
				}
				x++;
			}
			return -1;
		}

		public Trend findNthMostPopular(int n) {
			// this is iterating through so many empty elements.
			ArrayList<Trend> trendList = new ArrayList<Trend>();
			for (int x = 0; x < trends.length; x++) {
				if (trends[x] != null) {
					trendList.add(trends[x]);
				}

			}
			Collections.sort(trendList);
			return trendList.get(n);
		}

		public int currentSize() {
			int temp = 0;
			for (int x = 0; x < INIT_SIZE; x++) {
				if (trends[x] != null && trends[x] != availabeT) {
					temp++;
				}
			}
			return temp;
		}
	}
}
