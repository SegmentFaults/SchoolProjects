package edu.miamioh.gentilm5;
/**
 * 
 * @author Michael
 *
 */
public class Reverser {

	public static void main(String[] args) {
		
		//These are the test casese
		System.out.println("EXPECTED: !olleH");
		System.out.println(reverse("Hello!"));
		System.out.println("EXPECTED: .taen si sihT");
		System.out.println(reverse("This is neat."));
		System.out.println("EXPECTED: 172ESC");
		System.out.println(reverse("CSE271"));

	}
	/**
	 * This reverses the letters in a string so that the first letter is the last, the second
	 * letter is the second last and etc.
	 * @param text is the text that is to be manipulated
	 * @return a String with inverted order
	 */
	static String reverse(String text){
		String s="";
		if (text.length()>1){
			s=text.charAt(text.length()-1)+ reverse(text.substring(1, text.length()-1))+text.charAt(0);
			return s;
		}
		else{
			return text;
		}
	}

}
