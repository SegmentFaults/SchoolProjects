import java.util.ArrayList;

	/**
	 * 
	 * @author Michael Gentile
	 */
public class Mailbox {
	//an ArrayList of messages so that multiple may be held concurrently and infinitely expandable. 
	private ArrayList<Message> messages;
	//signature which the user may specify within the constructor. This may not be changed.
	private final String SIGNATURE;
	/**
	 * Custom message that sends an error up a level that may be handled. 
	 * Worked with Dr. Stephan on this as extra error checking aspect. 
	 */
	public static Message failureMessage;
	
	/**
	 * 
	 * @param signature, the custom ending to a message that this mailbox holds.
	 * Signature will be added with a carraige return.
	 */
	Mailbox(String signature)
	{
		messages=new ArrayList<Message>();
		this.SIGNATURE=signature+"\n";
	}
	/**
	 * 
	 * @param m, the message that will be added to the ArrayList of messages.
	 * @see the custom signature will be added to this message so that it is owned, or being used, by this mailbox. 
	 */
	public void addMessage (Message m)
	{
		messages.add(m);
		m.append(SIGNATURE);
	}
	/**
	 * 
	 * @param i, the ArrayList index of the messages. 
	 * @return the message from the ArrayList which was specified by the parameter
	 * @see if the index is set errantly, a failure message will be returned. This will be a custom message that shows the user that a failure has occured 
	 */
	public Message getMessage(int i) {
		try
		{
			return messages.get(i);
		}
		catch (IndexOutOfBoundsException e){
			//worked on this with Dr. Stephan
			failureMessage = new Message ("System", "Failure, Please Retry");
			failureMessage.append(e.toString());
			return failureMessage;
		}
	
	}
	/**
	 * 
	 * @param i, the ArrayList Index that will be removed.
	 * @see this will remove the message from a mailbox at what index specified within the parapmater. 
	 * If the user enters a faulty value as the parameter (one that does not exist within the ArrayList, we will print a stacktrace
	 * I was told this would be the best way not to break encapsulation.
	 * 
	 */
	public void removeMessage(int i){
		try{
			messages.remove(i);
		}
		catch(IndexOutOfBoundsException e){
				e.printStackTrace();
		}
	}
	/**
	 * 
	 * @return the custom signature of the current mailbox
	 */
	public String getSignature(){
		return SIGNATURE;
	}

}
