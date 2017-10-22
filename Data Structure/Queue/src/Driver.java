import java.awt.Point;

public class Driver {
	public static void main(String[] args) {
		QueueInterface<Point> q=new LinkedQueue<>();
		q.enqueue(new Point(1,2));//first in
		q.enqueue(new Point(3,4));
		q.enqueue(new Point());
		System.out.println(q.getFront() + " 1, 2???");
		
		System.out.println("Print all the points");
		while(!q.isEmpty()){
			System.out.println(q.dequeue());
		}
	}
}
