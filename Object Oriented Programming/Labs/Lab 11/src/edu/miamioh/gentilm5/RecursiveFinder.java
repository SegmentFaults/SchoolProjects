package edu.miamioh.gentilm5;

import java.util.Arrays;


public class RecursiveFinder {

	public static void main(String[] args) {
		//these are the test variables of arrays that need sorted.
		int[] trial= new int[]{1,2, 1,6 ,9,3, 5};//order of elements
		int[] trial1= new int[]{15,79,81,64,69,3,4,-1};//negative elements
		int[] trial2= new int[]{3333,44,5555,9898,745};//large elements
		System.out.println("EXPECTED: 9");
		System.out.println(largestElement(trial));
		System.out.println("EXPECTED: 81");
		System.out.println(largestElement(trial1));
		System.out.println("EXPECTED: 9898");
		System.out.println(largestElement(trial2));

	}
	/**
	 * 
	 * @param starter the array that is started with to sort, then it is narrowed and you are starting with a new one.
	 * @return the greatest value of a selected array of integers.
	 */
	static int largestElement(int starter[]){
		if (starter.length>1){//continues calling until the array is sized down to 1.
			return Math.max(starter[starter.length-1], largestElement(Arrays.copyOf(starter, starter.length-1)));
		}
		else{
			//base case
			return starter[0];
		}
	}
}
