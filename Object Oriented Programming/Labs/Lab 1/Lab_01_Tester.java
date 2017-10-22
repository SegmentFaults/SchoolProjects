import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;


public class Lab_01_Tester {
/*
 * Author Michael Gentile
 */
	public static void main(String[] args) throws FileNotFoundException {
		//first build the array that will be utilized for switching by implementing the method within Lab_01_ArrayUtilities.java
		int[] integerArray=Lab_01_ArrayUtilities.builtIntArray(30, 1, 30);
		//These are the vowels that we will be using to sort between consonants and vowels
		char [] vowelArray= new char[]{'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'};
		int loopProgress=0, oddCount=0;
		int vowelCount=0, conCount=0, otherCount=0;
		boolean used=false;
		String wordsContent="";
		//Print to the console as well as the a file the contents of the array. 
		System.out.println(Arrays.toString(integerArray));
		PrintWriter pw=new PrintWriter(new File("Lab_01_nums.txt"));
		pw.write(Arrays.toString(integerArray));
		
		
		//Here we  implement a method of swithing the array around with the index after it.
		//This utilizes the array we made earlier.
		for (int g=0; g<integerArray.length/2; g++)
		{
			Lab_01_ArrayUtilities.swap(integerArray, loopProgress, loopProgress+1);
			loopProgress+=2;
		}
		
		
		//print to the console as well as to a file the integer array after it has been swapped
		System.out.println(Arrays.toString(integerArray));
		pw.write(Arrays.toString(integerArray));
		
		//Now we sorth array in numerical order from lowest to highest.
		Arrays.sort(integerArray);
		
		//Printing the array to the console as well to our file, as we did before.
		System.out.println(Arrays.toString(integerArray));
		pw.write(Arrays.toString(integerArray));
		pw.close();
		
		
		//Here the array is looped through, and if there is remainder isn't 0 (signifying that it is odd). Then we tally the amount of odd characters.
		for (int g=0; g<integerArray.length; g++)
		{
			if (integerArray[g]%2!=0)
			{
				oddCount++;
			}
		}
		
		//Here we simply give the correct grammar to the user regarding the amount of odd numbers in the array.
		if (oddCount>1)
		{
			System.out.println("There are "+ oddCount + " odd numbers in the array");
		}
		else if(oddCount==1)
		{
			System.out.println("There is 1 odd number in the array");
		}
		else
		{
			System.out.println("There are no odd numbers in the array");
		}
		
		
		
		//Here a scanner is created where we read in the file words.txt and turn it into a String so that we may manipulate it more easily.
		Scanner r=new Scanner((new FileInputStream("words.txt")));
		while (r.hasNext())
		{
			wordsContent+=r.nextLine();
		}
		r.close();
		
		
		/* 
		 * Here we tally the count of vowels, consonants and other.
		 * We loop through the entirety of our string, which was the file. We sort them all out using various methods.
		 * This does not account for carriage return due to the nature of the while loop
		 */
		for (int g=0; g<wordsContent.length(); g++)
		{
			
			//These portion gets the vowels by looping through the character array of vowels (which were predefined)
			for (int f=0; f<vowelArray.length; f++)
			{
				if(wordsContent.charAt(g)==vowelArray[f])
				{
					vowelCount++;
					used=true;
					//This "used" boolean is used like an else if statement, where one couldn't easily be applied due to the nested for-loops. 
				}
			}
			
			// This accounts for all consonants
			if(Character.isLetter(wordsContent.charAt(g)) && !used)
			{
				conCount++;
			}
			
			//this cleans up the remainder.
			else if(used==false)
			{
				otherCount++;
			}
			used=false;
		}
		System.out.printf("There are %s vowels, %s consonants and %s other characters", vowelCount, conCount, otherCount);
	}

}
