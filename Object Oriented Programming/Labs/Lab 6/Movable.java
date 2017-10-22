/**
 * 
 * @author gentilm5
 *
 */

/**
 * 
 * @see an interface for all things movable.
 *
 */
public interface Movable {
	/**
	 * changes the y coordinates of an object in a positive manner
	 */
	void moveUp();
	/**
	 * changes the y coordinates of an object in a negative manner
	 */
	void moveDown();
	/**
	 * changes the x coordinate of an object in the negative manner
	 */
	void moveLeft();
	/**
	 * changes the x coordinate of an object in the positive manner
	 */
	void moveRight();
}
