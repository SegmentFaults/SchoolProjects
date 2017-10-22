
/*
 * Collects some data about bubble sorts and quick sorts by performing
 * experiments and writing the results into csv ("comma separated value")
 * files.  The csv files can be easily viewed in spreadsheet programs such as
 * Excel.  For example, this data in a text file will create 2 rows and
 * 3 columns:
 * size,bubble,quick
 * 10,3,5
 *
 * @author Norm Krumpe
 * CSE 274
 */

import java.io.*;
import java.util.Arrays;

public class SortingTest {

	private static PrintWriter writer;
	private static final int MAX = 1000;
	private static boolean takingTooLong = false;

	public static void main(String[] args) throws IOException {
		//collectBubbleSortData("gentilm5_bubbleData.csv");
		collectBubbleQuickData("gentilm5_bubbleQuickData.csv");
	}

	// Performs multiple bubble sorts on arrays of
	// various sizes, writing the results to a csv file for easy
	// viewing in Microsoft Excel
	public static void collectBubbleSortData(String filename) throws IOException {
		// csv files are easily read in Microsoft Excel
		writer = new PrintWriter(new File(filename));

		// Prints the column headers. As you collect different
		// kinds of data, add their headers as new columns
		writer.println("size,swaps,comparisons");
		for (int x=10; x<=200; x+=10){
			bubbleExperiment(x);
		}
		writer.close();
		System.out.println("DONE!");
	}

	// Performs a bubble sort and writes
	// data about the experiment to the file
	public static void bubbleExperiment(int size) {

		int[] data = randomArray(size, MAX);

		// The bubble-sort algorithm. This is about as smart
		// as bubble-sort gets: it does fewer comparisons on each
		// pass, and it stops as soon as it makes a pass where
		// no swaps are made
		boolean madeSwap = true;
		int pass = 0;
		int swapCount=0;
		int comparisonCount=0;
		while (madeSwap) {
			madeSwap = false;
			for (int i = 0; i < data.length - 1 - pass; i++) {
				comparisonCount++;
				if (data[i] > data[i + 1]) {
					int temp = data[i];
					data[i] = data[i + 1];
					data[i + 1] = temp;
					madeSwap = true;
					swapCount++;
				}
			}
			pass++;
		}
		writer.println(size+","+swapCount+ ", "+comparisonCount);

	}

	// Performs multiple comparisons of run time for bubble sort and
	// for quick sort (quick sort as implemented in Arrays.sort)
	public static void collectBubbleQuickData(String filename) throws IOException {
		// csv files are easily read in Microsoft Excel
		writer = new PrintWriter(new File(filename));

		// Prints the column headers. As you collect different
		// kinds of data, add their headers as new columns
		writer.println("size,bubble,quick");

		// Perform experiments until the program starts taking too long,
		// starting with an array of size 10 and then doubling the
		// size each time.
		int sizeOfAr=10;
		do
		{
			bubbleQuickExperiment(sizeOfAr);
			sizeOfAr*=2;
		} while(!takingTooLong);
		writer.close();
		System.out.println("DONE!");
	}

	// Sorts an array two ways: using bubble sort, and using
	// Arrays.sort() (which is based on a 2-pivot variation of quick sort)
	public static void bubbleQuickExperiment(int size) {

		int[] data = randomArray(size, MAX);

		// Makes an exact copy of data. This will be useful
		// when we want to compare how fast bubble sort works
		// compared to another sort
		int[] dataCopy = new int[size];
		for (int i = 0; i < data.length; i++) {
			dataCopy[i] = data[i];
		}

		// Start timer:
		long startBubble = System.nanoTime();

		// Bubble sort of data
		boolean madeSwap = true;
		int pass = 0;

		while (madeSwap) {
			madeSwap = false;
			for (int i = 0; i < data.length - 1 - pass; i++) {
				if (data[i] > data[i + 1]) {
					int temp = data[i];
					data[i] = data[i + 1];
					data[i + 1] = temp;
					madeSwap = true;
				}
			}
			pass++;
		} // End bubble sort

		// End timer: One billion nanoseconds = 1 second
		long endBubble = System.nanoTime();
		double bubbleTime = (endBubble - startBubble) / 1E9;
		if (bubbleTime>10){
			takingTooLong=true;
		}

		// Now, perform a quick sort of dataCopy
		// by using Arrays.sort()
		// Mark the start time just before sorting
		long startTime=System.nanoTime();
		Arrays.sort(dataCopy);
		long endTime=System.nanoTime();
		double totalTime=(endTime-startTime)/1E9;
		// Mark the end time just after sorting
		writer.println(size+","+bubbleTime+","+totalTime);
		
		// Now, print the results

	}

	// Returns an array of random integers in the range
	// [0, max-1]
	public static int[] randomArray(int size, int max) {
		int[] result = new int[size];

		for (int i = 0; i < size; i++) {
			result[i] = (int) (max * Math.random());
		}

		return result;
	}

}
