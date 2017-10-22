/**
 * 
 */
package edu.miamioh.gentilm5;

import java.awt.Rectangle;
import java.util.ArrayList;

/**
 * @author Michael
 * Needs to be extended for the .contains() method.
 */
@SuppressWarnings("serial")
public class Block extends Rectangle {
	private int x, y, xListing, yListing;//x cord, y cord, xArray listing and yArray listing.
	private boolean filled=false, safe=true;//meaning safe from queens or filled with queens.
	private Queen q=new Queen(-5,-5);//setting the Queens to null creates a slight compile problem. So we set them to an arbitrary negative number.
	private static ArrayList<Block> blocks=new ArrayList<Block>();//all of the blocks that are created. 
	public enum BoardColor{RED, BLACK, YELLOW};//possible colors for the array.
	private BoardColor c;//color given to the board.
	private BoardColor oldCol;//if we have to mark the block as a specific, provisional color.
	/**
	 * 
	 * @param x coordinate
	 * @param y coordinate
	 * @param sizeX size in the x direction
	 * @param sizeY size in the y direction
	 * @param xListing x array listing
	 * @param yListing y array listing
	 * @param color color enum so that it has a specific color on the board.
	 */
	Block(int x, int y, int sizeX, int sizeY, int xListing, int yListing, BoardColor color){
		super(x,y,sizeX,sizeY);
		this.x=x;
		this.y=y;
		this.xListing=xListing;
		this.yListing=yListing;
		this.c=color;
		blocks.add(this);
	}
	/**
	 * 
	 * @param filled a boolean whether or not a queen is to occupy the block.
	 * This is where you check to make sure there is not more than 8 queens on the board.
	 */
	/**
	 * @param filled
	 */
	public void setFilled(boolean filled) {
		if(filled && Queen.getQueenCount()<8){
			this.filled=true;
			q=new Queen(xListing,yListing);
			Queen.setQueenCount(Queen.getQueenCount()+1);
			Queen.getQueens().add(q);
		}
		else if (!filled){
			this.filled=false;
			Queen.getQueens().remove(q);
			q=null;
			Queen.setQueenCount(Queen.getQueenCount()-1);
			
		}
	}
	/* (non-Javadoc)
	 * @see java.awt.Rectangle#getX()
	 */
	public double getX() {
		return x;
	}
	/**
	 * @param x is the x coordinate you want to set
	 */
	public void setX(int x) {
		this.x = x;
	}
	/* (non-Javadoc)
	 * @see java.awt.Rectangle#getY()
	 */
	public double getY() {
		return y;
	}
	/**
	 * @param y is the y coordinate for top left corner.
	 */
	public void setY(int y) {
		this.y = y;
	}
	/**
	 * @return the x array listing of the block
	 */
	public int getxListing() {
		return xListing;
	}

	/**
	 * @return the y arrayListing. 
	 */
	public int getyListing() {
		return yListing;
	}
	/**
	 * @return the color of the board. 
	 */
	public BoardColor getC() {
		return c;
	}
	/**
	 * @return weather or not the block is safe.
	 */
	public boolean isSafe() {
		return safe;
	}
	/**
	 * @param safe is whether or not the block is now safe.
	 */
	public void setSafe(boolean safe) {
		this.safe = safe;
	}
	/**
	 * 
	 * @return all of the blocks that are currently created. 
	 */
	public static ArrayList<Block> getBlocks() {
		return blocks;
	}
	/**
	 * @param c is the new enum of color you want to set. 
	 */
	public void setC(BoardColor c) {
		oldCol = this.c;
		this.c = c;
	}
	/**
	 * @return the boardcolor enum of the pervious color that we had after we used a provisional color. 
	 */
	public BoardColor getOldC() {
		return oldCol;
	}
	/**
	 * @return returns the queen that is on the board
	 */
	public Queen getQ() {
		return q;
	}
	/**
	 * @return whether there is a queen on the board. 
	 */
	public boolean isFilled() {
		return filled;
	}

}
