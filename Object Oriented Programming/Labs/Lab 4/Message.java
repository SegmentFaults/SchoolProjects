	/**
	 * This class is a Message that will be stored within a mailbox.
	 * @author Michael Gentile
	 */
public class Message {
	/**
	 * Every message will have a sender (the person who sent the message), a recipient (the person's who's mailbox it goes to) and content
	 */
	private String sender;
	private String recipient;
	private String content;
	private static final String from="From: ";
	private static final String to="\nTo: ";
	/**
	 * 
	 * @param sender, person to which the message will be sent or was sent
	 * @param recipient person to which it was sent. 
	 * Initalizes all values that will be needed.
	 */
	Message(String sender, String recipient){
		this.sender=sender;
		this.recipient=recipient;
		content="";
	}
	/**
	 * 
	 * @param addedMessage message to be appended.
	 * The parameter passed will be added to the end of the message. No carraige return will be given. 
	 */
	public void append(String addedMessage)
	{
		content+=addedMessage;
	}
	/**
	 * toString to show the values.  
	 */
	@Override
	public String toString()
	{
		return from + sender
				+ to +recipient + "\n"
				+ content + "\n";
	}

}
