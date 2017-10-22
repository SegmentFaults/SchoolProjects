
public class Lab_01_ArrayUtilities {
	
	
	public static int [] builtIntArray(int length, int fromNum, int toNum)
	{
		if (fromNum>toNum)
		{
			System.out.println("Error, your beginning number is larger than your ending number. The values will be reversed");
			int temp=fromNum;
			fromNum=toNum;
			toNum=temp;
		}
		int [] x=new int[length];
		for (int g=0; g<x.length; g++)
		{
			int random=(int)((Math.random()*(toNum-fromNum))+fromNum+.5);
			x[g]=random;
		}
		return x;
	}
	public static int [] swap (int[] nums, int i, int j)
	{
		int temp= nums[i];
		nums[i]=nums[j];
		nums[j]=temp;
		return nums;
	}

}
