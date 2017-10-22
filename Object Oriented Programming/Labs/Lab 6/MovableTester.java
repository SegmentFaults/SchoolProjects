/**
 * 
 */

/**
 * @author gentilm5
 *
 */
public class MovableTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Movable[] movables=new Movable[2];//create an array for our chaChaSlide.
		Movable	m1	=	new	MovablePoint(5,	6,10,12);//	upcast
		System.out.println(m1);
		m1.moveLeft();
		System.out.println(m1);
		Movable	m2	=	new	MovableCircle(2,1,2,20,50);	//	upcast.	Constructor	takes	in	4	point	values	and	
		//radius	
		System.out.println(m2);
		m2.moveRight();
		System.out.println(m2);
		//now the chaChaSlide will be done.
		movables[0]=m1;
		movables[1]=m2;
		System.out.println("\n\n\n\n\n");
		chaChaSlide(movables);
		System.out.println(movables[0]);
		System.out.println(movables[1]);
		//now we will test our setters.
		int oldSpeed=((MovablePoint) m1).getySpeed();
		((MovablePoint)m1).setySpeed(150);
		System.out.println("EXPECTED: The old speed in the y was 12 and the new speed is 150");
		System.out.println("The old speed in the y was " + oldSpeed+ " and the new speed is 150");
		int oldSpeed2=((MovablePoint) m1).getxSpeed();
		((MovablePoint)m1).setxSpeed(150);
		System.out.println("EXPECTED: The old speed in the x was 10 and the new speed is 150");
		System.out.println("The old speed in the y was " + oldSpeed2+ " and the new speed is 150");//now getters and setters for Movable Point are tested.
		//now the getters and setters for MovableCircle will be tested
		int oldSpeed3=((MovableCircle) m2).getySpeed();
		((MovableCircle)m2).setySpeed(150);
		System.out.println("EXPECTED: The old speed in the y was 20 and the new speed is 150");
		System.out.println("The old speed in the y was " + oldSpeed3+ " and the new speed is 150");
		int oldSpeed4=((MovableCircle) m2).getxSpeed();
		((MovableCircle)m2).setxSpeed(150);
		System.out.println("EXPECTED: The old speed in the x was 2 and the new speed is 150");
		System.out.println("The old speed in the y was " + oldSpeed4+ " and the new speed is 150");//now getters and setters for Movable Point are tested.
		
	}
	public static void chaChaSlide(Movable[] movables){
		for (int x=0; x<movables.length; x++){
			movables[x].moveLeft();
			movables[x].moveRight();
			movables[x].moveDown();
			movables[x].moveUp();
			movables[x].moveLeft();
			movables[x].moveDown();
			movables[x].moveUp();
			movables[x].moveRight();
			movables[x].moveLeft();
			movables[x].moveDown();
			movables[x].moveUp();
			movables[x].moveUp();
		}
	}

}
