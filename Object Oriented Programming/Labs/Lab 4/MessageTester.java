	/**
	 * 
	 * @author Michael Gentile
	 * This is a main to test Message class.
	 */
public class MessageTester {
	public static void main(String[] args) {
		//Initalize the variables.
		Message m=new Message("Tim", "Bob");
		//add these lines to the end of the file.
		m.append("This is the first line of the message. \n");
		m.append("This is the second line of the message. \n");
		m.append("This is a third line,\nand this is a forth line\n");
		//print the content
		System.out.println(m);
		System.out.println("EXPECTED:\nFrom: Tim \nTo: Bob\nThis is the first line of the message.\nThis is the second line of the message. \nThis is a third line, \nand this is a forth line");
	}

}
