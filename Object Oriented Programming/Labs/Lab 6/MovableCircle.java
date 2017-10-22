/**
 * 
 */

/**
 * @author gentilm5
 *
 */
public class MovableCircle implements Movable {
	private int radius;
	private MovablePoint movablePoint;
	/**
	 * 
	 * @param centerX, center of the circle in the X direction
	 * @param centerY, center of the circle in the Y direction
	 * @param xSpeed, speed of the circle in the X
	 * @param ySpeed, speed of the circle in the Y
	 * @param radius, radius of the circle
	 */
	MovableCircle(int centerX, int centerY, int xSpeed, int ySpeed, int radius){
		movablePoint=new MovablePoint(centerX,centerY,xSpeed,ySpeed);
		this.radius=radius;
	}
	/* (non-Javadoc)
	 * @see Movable#moveUp()
	 */
	
	/**
	 * increments the y by the ySpeed
	 */
	@Override
	public void moveUp() {
		movablePoint.moveUp();

	}

	/* (non-Javadoc)
	 * @see Movable#moveDown()
	 */
	
	/**
	 * Decreases the y by the ySpeed
	 */
	@Override
	public void moveDown() {
		movablePoint.moveDown();

	}

	/* (non-Javadoc)
	 * @see Movable#moveLeft()
	 */
	
	/**
	 * moves the center of the circle by the xSpeed to the left
	 */
	@Override
	public void moveLeft() {
		movablePoint.moveLeft();

	}

	/* (non-Javadoc)
	 * @see Movable#moveRight()
	 */
	
	/**
	 * increments the center point by the xSpeed
	 */
	@Override
	public void moveRight() {
		movablePoint.moveRight();

	}
	public int getxSpeed() {
		return movablePoint.getxSpeed();
	}
	/**
	 * @param xSpeed the xSpeed to set
	 */
	public void setxSpeed(int xSpeed) {
		movablePoint.setxSpeed(xSpeed);
	}
	/**
	 * @return the ySpeed
	 */
	public int getySpeed() {
		return movablePoint.getySpeed();
	}
	/**
	 * @param ySpeed the ySpeed to set
	 */
	public void setySpeed(int ySpeed) {
		movablePoint.setySpeed(ySpeed);
	}
	/**
	 * @return a custom String that involves the information of the method.
	 */
	@Override
	public String toString(){
		return "My radius is "+ radius+" and this is located at ("+movablePoint.getX()+","+movablePoint.getY()+")\nThis circle moves at a speed"
				+ " of "+movablePoint.getxSpeed()+ " in the x-direction and " + movablePoint.getySpeed()+ " in the y direction.";
	}
}
