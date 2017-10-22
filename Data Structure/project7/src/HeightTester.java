
/**
 * 
 */

import java.util.Random;

import TreePackage.*;

/**
 * @author Michael Gentile
 * CSE 274
 * Prof Norm Krumpe
 * This is a tester for the height of a binary search tree.
 * This code is strictly my own.
 *
 */
public class HeightTester {

	/**
	 * 
	 * This is a class to hold the data for my results section.
	 *
	 */
	public static class DataStruct {
		public int minHeight, maxHeight, thMinHeight, thMaxHeight, n;
		public double average;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final int numberOfExp=19;
		final int numberOfTests=50;
		final int rangeOfInts=1000000;
		Random r = new Random();
		//all of my results
		DataStruct data[] = new DataStruct[19];
		for (int x = 2; x < numberOfExp+2; x++) {// amount of data sets
			//amount of random integers to be generated. The "n"
			int randomInts = (int) Math.pow(2, x) - 1;
			DataStruct d = new DataStruct();
			d.thMinHeight=x;
			d.thMaxHeight=randomInts;
			d.n = randomInts;
			// set th min and max
			int heights[] = new int[50];

			for (int z = 0; z < numberOfTests; z++) {// amount of trials
				BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
				for (int y = 0; y < randomInts; y++) {// amount of ints tested
					bst.add(r.nextInt(rangeOfInts));//in lab he said we could chage it.
				}

				heights[z] = bst.getHeight();

			}
			//store the data
			d.average = computeAverage(heights);
			d.maxHeight = computeMax(heights);
			d.minHeight = computeMin(heights);
			data[x - 2] = d;
		}
		display(data);

	}

	private static double computeAverage(int[] array) {
		double sum = 0;
		for (int x = 0; x < array.length; x++) {
			sum += array[x];
		}
		return sum / 50.0;

	}
	//just returns the min of the function given an array of integers
	public static int computeMin(int[] array) {
		int min = array[0];
		for (int x = 1; x < array.length; x++) {
			if (min > array[x]) {
				min = array[x];
			}
		}

		return min;
	}
	//returns the min from an array of integers
	public static int computeMax(int[] array) {
		int max = array[0];
		for (int x = 0; x < array.length; x++) {
			if (max < array[x]) {
				max = array[x];
			}

		}
		return max;
	}
	//this simply displays data
	public static void display(DataStruct[] data) {
		System.out.println("N       exp     exp      exp      the     the");
		System.out.println("        min     max      avg      min     max");
		for (int x = 0; x < data.length; x++) {
			if (x < 2) {// two digit
				System.out.println(data[x].n + "        " + data[x].minHeight + "       " + data[x].maxHeight
						+ "       " + String.format( "%.2f", data[x].average)+"       "+data[x].thMinHeight+"      "+data[x].thMaxHeight);
			}
			else if (x==2){
				System.out.println(data[x].n + "       " + data[x].minHeight + "       " + data[x].maxHeight + "      "
						+ String.format( "%.2f", data[x].average)+"       "+data[x].thMinHeight+"      "+data[x].thMaxHeight);
			}
			else if (x == 3) {
				System.out.println(data[x].n + "       " + data[x].minHeight + "       " + data[x].maxHeight + "      "
						+ String.format( "%.2f", data[x].average)+"       "+data[x].thMinHeight+"      "+data[x].thMaxHeight);
			} else if (x < 5) {
				System.out.println(data[x].n + "       " + data[x].minHeight + "       " + data[x].maxHeight + "      "
						+ String.format( "%.2f", data[x].average)+"      "+data[x].thMinHeight+"      "+data[x].thMaxHeight);
			} else if (x < 8) {
				System.out.println(data[x].n + "      " + data[x].minHeight + "      " + data[x].maxHeight + "      "
						+ String.format( "%.2f", data[x].average)+"      "+data[x].thMinHeight+"      "+data[x].thMaxHeight);
			} else if (x < 12) {
				System.out.println(data[x].n + "     " + data[x].minHeight + "      " + data[x].maxHeight + "      "
						+ String.format( "%.2f", data[x].average)+"      "+data[x].thMinHeight+"     "+data[x].thMaxHeight);
			} else if (x < 15) {
				System.out.println(data[x].n + "    " + data[x].minHeight + "      " + data[x].maxHeight + "      "
						+ String.format( "%.2f", data[x].average)+"      "+data[x].thMinHeight+"     "+data[x].thMaxHeight);
			} else if (x < 18) {
				System.out.println(data[x].n + "   " + data[x].minHeight + "      " + data[x].maxHeight + "      "
						+ String.format( "%.2f", data[x].average)+"      "+data[x].thMinHeight+"     "+data[x].thMaxHeight);
			} else {
				System.out.println(data[x].n + "  " + data[x].minHeight + "      " + data[x].maxHeight + "      "
						+ String.format( "%.2f", data[x].average)+"      "+data[x].thMinHeight+"     "+data[x].thMaxHeight);
			}

		}
	}

}
