import java.util.Scanner;


public class Lab2FloatingPoint {
	/*
	 * Author Michael Gentile
	 * This method is designed to total numbers. When the user inputs two false (non numberic)
	 * symbols, the program will quit and the total will tabulated. 
	 */
	public static void main(String[] args) 
	{
		float total=0;
		int failure=0;
		Scanner input=new Scanner (System.in);
		do
		{
			try 
			{
				//Request user input. 
				System.out.println("Please enter a number ");
				Float temp = Float.parseFloat(input.next());
				//If the user enters an invalid character, then they will be sent to the catch
				//otherwise the incorrect character tabulation will be reset. 
				failure=0;
				total+=temp;
			}
			catch(NumberFormatException e)
			{
				if (failure==0)
				{
					System.out.println("You have entered a false character. Enter one more to exit the program.");
				}
				failure += 1;
			}
		} while(failure != 2);
		input.close();
		
		//finish by showing the total
		System.out.println("The total value is " + total);
	}	
}
