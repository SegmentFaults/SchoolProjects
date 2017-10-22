import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

public class Scannertest {

	public static void main(String[] args) {
		Person p=new Person();
		System.out.println(p.getName());
	}
	public static String addSpaces(String infix){
		ArrayList<Object> ar=new ArrayList<Object>();
		for(int x=0; x<infix.length(); x++){
			if (infix.charAt(x)=='+' ||
				infix.charAt(x)=='-' ||
				infix.charAt(x)=='*' ||
				infix.charAt(x)=='/'){
				ar.add(infix.charAt(x));				
			}
			
		}
		return infix;
	}

}
