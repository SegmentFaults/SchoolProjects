import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Lab2InputOutput {
	/*	Author Michael Gentile
	 *
	 * 
	 * This method is meant to take an argument via CLI.
	 * This then will read in the file contents and add line numbers.
	 * @param args
	 * @throws FileNotFoundException if the filename does not match the argument given from the command line
	 * @param fileScanner reads in the given file to convert it to a string
	 */
	public static void main(String[] args) throws FileNotFoundException 
	{
		int lineNumber=1;
		//Below is the argument taken from CLI.
		String fileName=args[0];
		String fileContents="";
		Scanner fileScanner=new Scanner(new File(fileName));
		/*
		 * While the file which are reading from has content, we will take the content and add
		 * it to the String. We then format the String so that it meets specifications. 
		 */
		while (fileScanner.hasNext())
		{
			fileContents+="/*  " + lineNumber + "  */  " + fileScanner.nextLine() +" \r";
			lineNumber++;
		}
		//Close the Scanner and then print out our formatted file contents. 
		fileScanner.close();
		System.out.println(fileContents);

	}

}
