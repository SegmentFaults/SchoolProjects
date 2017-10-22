
public class TowerOfHanoi {
	public static void main(String[] args) {
		hanoi(10,1,3);
	}
	public static void hanoi(int n, int start, int end) {
		//Base case. 1 Disk problem is easy.
		if(n==1)
		{
			System.out.println("from " + start + " to "+end);
		}
		else{
			int tempPost=6-start-end;
			hanoi(n-1, start, tempPost);
			hanoi(n-1,tempPost,end);
		}
	}
}
