import java.util.ArrayList;
import java.util.Stack;

public class StackProblems {

	public static void main(String[] args) {
		int[] nums={4,7,2,5,8};
		Stack<Integer> stack=new Stack<>();
		for (int num: nums){
			stack.push(num);
		}
		System.out.println(sum(stack));
		for (int num:nums){
			stack.push(num);
		}
		System.out.println(sumSkipDuplicates(stack));
	}

	/*
	 * Computes the sum of all the numbers in the stack
	 */
	public static int sum(Stack<Integer> data) {
		int sum=0;
		while(!data.isEmpty()){
			sum+=data.pop();
		}

		return sum;
	}

	/*
	 * Computes the sum of all the numbers in the stack. However, if two or more
	 * numbers in a row are equal, only add one of them. So, for example, if the
	 * stack contained 4, 1, 2, 2, 7, 2, 8, 8, 8, 4, then the numbers that would
	 * be added would be 4 + 1 + 2 + 7 + 2 + 8 + 4 = 28
	 */
	public static int sumSkipDuplicates(Stack<Integer> data) {
		int sum=0;
		int last=0;
		while(!data.isEmpty()){
			int temp=data.pop();
			if (last!=temp)
				sum+=temp;
			last=temp;
		}
		return sum;
	}

	/*
	 * Puts all of the characters of a string into a stack, with the first
	 * character of the string at the bottom of the stack and the last character
	 * of the string at the top of the stack.
	 */
	public static Stack<Character> stringToStack(String s) {
		Stack<Character> stringStack=new Stack<Character>();
		while (!s.isEmpty()){
			stringStack.push(s.charAt(0));
			s=s.substring(1,s.length());
		}
		return stringStack;

	}

	/*
	 * Reverses a given stack, so that the top of the stack becomes the bottom
	 * and the bottom becomes the top.
	 */
	public static void reverseStack(Stack<Integer> s) {
		ArrayList<Integer> temp=new ArrayList<Integer>();
		while (!s.isEmpty()){
			temp.add(s.pop());
		}
		while(!temp.isEmpty()){
			s.push(temp.get(0));
			temp.remove(0);
		}
		
	}

	/*
	 * A palindrome reads the same forward and backward. Use a stack to
	 * determine if a given string is a palindrome. Challenge: try not to use
	 * any additional variables (except a counter for any loop). Just the given
	 * string and a stack of Characters.
	 */
	public static boolean isPalindrome(String s) {
		Stack<Character> tempStack=new Stack<Character>();
		int x=1;
		while (x<=s.length()-1){
			tempStack.push(s.charAt(s.length()-x));
			if (s.charAt(x-1)==tempStack.pop()){;
				x++;
			}
			else{
				return false;
			}
		}
		return true;
	}

}
