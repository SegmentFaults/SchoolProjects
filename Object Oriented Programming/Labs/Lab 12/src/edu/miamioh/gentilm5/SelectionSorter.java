/**
 * 
 */
package edu.miamioh.gentilm5;

/**
 * @author gentilm5
 *
 */
public class SelectionSorter {
	/**
	 * 
	 * @param array
	 */
	public static void sort(int[] array){
		for (int outerLoop=array.length; outerLoop>1; outerLoop--){
			int max =0;//max number value's index within loop iteration.
			for (int innerLoop=1; innerLoop<outerLoop; innerLoop++){
				if (array[innerLoop]<array[max]) 
					max=innerLoop;
				//if the number that is currently the biggest is no longer the biggest
				//get the new array listing and use that as a comparison.
			}
			ArrayUtil.swap(array, outerLoop-1, max);//swap the the current loop index with the new highest number.
			
		}
	}
}
