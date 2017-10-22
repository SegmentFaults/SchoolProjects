package sample;

import java.util.Scanner;

public class teseter {

	public static void main(String[] args) {
		String x="3 + 5 + 7";
		Scanner scan=new Scanner(x);
		while(scan.hasNext()){
			try{
				System.out.println(Integer.parseInt(scan.next()));
			}
			catch(NumberFormatException e){
				
			}
		}

	}

}
