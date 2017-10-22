/**
 * 
 */

/**
 * @author gentilm5
 *
 */
public class MovablePoint implements Movable {
	private int x,y, xSpeed, ySpeed;
	/* (non-Javadoc)
	 * @see Movable#moveUp()
	 */
	
	/**
	 * 
	 * @param x, x cord of the point
	 * @param y, y cord of the point
	 * @param xSpeed, speed in x direction
	 * @param ySpeed, speed in y direction
	 */
	MovablePoint(int x, int y, int xSpeed, int ySpeed){
		this.x=x;
		this.y=y;
		this.xSpeed=xSpeed;
		this.ySpeed=ySpeed;
	}
	/**
	 * @see increments the y by the yspeed
	 */
	@Override
	public void moveUp() {
		y+=ySpeed;
	}

	/* (non-Javadoc)
	 * @see Movable#moveDown()
	 */
	
	/**
	 * decreases the Y by the yspeed
	 */
	@Override
	public void moveDown() {
		y-=xSpeed;

	}

	/* (non-Javadoc)
	 * @see Movable#moveLeft()
	 */
	
	/**
	 * decreases x by the xSpeed;
	 */
	@Override
	public void moveLeft() {
		x-=xSpeed;

	}

	/* (non-Javadoc)
	 * @see Movable#moveRight()
	 */
	
	/**
	 * increases x by xSpeed
	 */
	@Override
	public void moveRight() {
		x+=xSpeed;

	}
	/**
	 * @return the xSpeed
	 */
	public int getxSpeed() {
		return xSpeed;
	}
	/**
	 * @param xSpeed the xSpeed to set
	 */
	public void setxSpeed(int xSpeed) {
		this.xSpeed = xSpeed;
	}
	/**
	 * @return the ySpeed
	 */
	public int getySpeed() {
		return ySpeed;
	}
	/**
	 * @param ySpeed the ySpeed to set
	 */
	public void setySpeed(int ySpeed) {
		this.ySpeed = ySpeed;
	}
	/**
	 * @return the x coordinate
	 */
	public int getX(){
		return x;
	}
	/**
	 * @return the y coordinate
	 */
	public int getY(){
		return y;
	}
	/**
	 * returns a custom String describing the current object.
	 */
	@Override
	public String toString(){
		return "My point is moves at "+xSpeed+" in the X direction and moves at " +ySpeed+" in the y direction.\nThis is located at ("+x+","+y+")";
	}

}
