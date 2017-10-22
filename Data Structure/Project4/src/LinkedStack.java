import java.util.EmptyStackException;
/**
 * @author Michael Gentile
 * Instructor: Norm Krumpe
 * CSE 274
 * This is a stack that is integrated using nodes. 
 * Code was done by me using examples from the text.
 */

public class LinkedStack<T> implements StackInterface {
	//I did not comment this because the interface has all the appropriate comments. 
	private Node topNode;
	public LinkedStack(){
		topNode=null;
	}
	@Override
	public void push(Object newEntry) {
		Node newNode=new Node(newEntry,topNode);
		topNode=newNode;
	}

	@Override
	public Object pop() {
		T top=(T) peek();
		
		assert topNode!=null;
		topNode= (Node) topNode.getNextNode();
		return top;
	}

	@Override
	public Object peek() {
		if (isEmpty()){
			throw new EmptyStackException();
		}
		else{
			return topNode.getData();
		}
	}

	@Override
	public boolean isEmpty() {
		return topNode==null;
	}

	@Override
	public void clear() {
		topNode=null;
		
	}
	
}
class Node<T> {
	private T data;
	private Node next;

	/**
	 * Creates a node with specified data and pointer to the next node
	 * 
	 * @param data
	 *            the data to be stored in this Node
	 * @param next
	 *            the reference to the next Node
	 */
	public Node(T data, Node next) {
		this.data = data;
		this.next = next;
	}

	/**
	 * Creates a node with specified data but sets next to null, indicating
	 * that this node does not yet refer to a next node
	 * 
	 * @param data
	 *            the data to be stored in this Node
	 */
	private Node(T data) {
		this(data, null);
	}
	public T getData(){
		return data;
	}
	public void setData(T data){
		this.data=data;
	}
	public Node getNextNode(){
		return next;
	}
	public void setNextNode(Node next){
		this.next=next;
	}
}

