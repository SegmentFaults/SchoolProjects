	/**
	 * 
	 * @author Michael Gentile
	 */
public class MailboxTester {

	/**
	 * 
	 * @param args
	 * @see this is the tester method for the mailbox class. This implements the custom Message class (which relies on mailbox).
	 */
	public static void main(String[] args) {
		//Initalize our messages and mailboxes. 
		Message message1=new Message("Sender1","Recipient1");
		Message message2=new Message("Sender2", "Recipient2");
		Mailbox mailbox1=new Mailbox("This is the signature for mailbox1");
		Mailbox mailbox2=new Mailbox("This is the signature for mailbox2");
		
		
		mailbox1.addMessage(message1);
		//Mailbox 2 will hold two different messages.
		mailbox2.addMessage(message2);
		mailbox2.addMessage(message1);
		
		
		System.out.println(mailbox1.getSignature());
		System.out.println("Expected: \nThis is the signature for mailbox1");
		System.out.println();
		System.out.println(mailbox2.getSignature());
		System.out.println("Expected: \nThis is the signature for mailbox2");
		System.out.println("\n\n");
		
		//This section of testing assumes that the Message class has been tested. If message is working correctly, then we can test the mailboxes, since mailbox relies of Message.
		//this checks both the getMessage and addMessage method. 
		System.out.println(mailbox1.getMessage(0).toString());
		System.out.println("Expected: \n"+"From: Sender\nTo: Recipient1\nThis is the signature for mailbox1\nThis is the signature for mailbox2");	
		System.out.println("\n\n");
		System.out.println(mailbox2.getMessage(0).toString());
		System.out.println("Expected: \nFrom: Sender2\nTo: Recipient2\nThis is the signature for mailbox2");
		System.out.println("\n\n");
		
		
		
		//Now that we have proved that these messages exist, we can now test the removeMessage method. 
		mailbox1.removeMessage(0);
		mailbox2.removeMessage(0);
		//These messages are now removed, so they should both have empty array lists.
		
		//This should return my failure emails. 
		
		System.out.println(mailbox1.getMessage(0));
		System.out.println("Expected: \nFrom: System\nTo: Failure, Please Retry\njava.lang.IndexOutOfBoundsException: Index: 0, Size: 0");
		
		//This should have the same printed "Expected" failure message for the second mailbox as the first except for a different stack trace. 
		System.out.println(mailbox2.getMessage(1));
		System.out.println("Expected: \nFrom: System\nTo: Failure, Please Retry\njava.lang.IndexOutOfBoundsException: Index: 1, Size: 1");
		//all methods have been tested.
		System.out.println("All methods have been tested. ");
	}

}
