package edu.miamioh.gentilm5;

import java.util.ArrayList;
/**
 * 
 * @author Michael
 * This queen class was modified from the one used in lecture. 
 */
public class Queen {
	private int column;
	private boolean safeQueen=true;
	private int row;
	private static int queenCount=0;
	private static ArrayList<Queen> queens=new ArrayList<Queen>();
	/**
	 * 
	 * @param row, the row where the queen is
	 * @param column the column where the queen is
	 */
	Queen(int row, int column){
		this.row=row;
		this.column=column;
	}
	/**
	 * 
	 * @param other the other queen that is going to be attacked or not attacked
	 * @return whether or not the queen would be attacked
	 */
	public boolean attacks (Queen other){ 
		if(this.equals(other)){
			return false;
		}
	else if (row == other.row
			|| column == other.column || 
			Math.abs(row-other.row) == Math.abs(column-other.column) && other.row!=-5){
		return true;
		}
		return false;
	}
	/**
	 * 
	 * @param other the other block that is going to be attacked or not attacked
	 * @return whether or not the queen would be attacked
	 */
	public boolean attacksBlock (Block other){
		if (row == other.getxListing()
			|| column == other.getyListing() || 
			Math.abs(row-other.getxListing()) == Math.abs(column-other.getyListing())){
			return true;
		}
		return false;
	}
	/**
	 * 
	 * @return if the queen is safe from other queens.
	 */
	public boolean isSafe() {
		return safeQueen;
	}
	/**
	 * @param whether the queen is safe or not
	 */
	public void setSafe(boolean safe) {
		this.safeQueen = safe;
	}
	/**
	 * 
	 * @return the column of the queen
	 */
	public int getColumn() {
		return column;
	}
	/**
	 * 
	 * @return the row of the queen
	 */
	public int getRow() {
		return row;
	}
	/**
	 * Textual representation of where the queen is on the board.
	 */
	public String toString(){
		return "["+row + " ,"+ column+ "] ";
	}
	/**
	 * 
	 * @return all of the queens.
	 */
	public static ArrayList<Queen> getQueens() {
		return queens;
	}
	/**
	 * 
	 * @return the amount of queens.
	 * This is used enough to warrant a seperate method rather than using the arraylist method.
	 */
	public static int getQueenCount() {
		return queenCount;
	}
	/**
	 * 
	 * @param queenCount new amount of queens.
	 */
	public static void setQueenCount(int queenCount) {
		Queen.queenCount = queenCount;
	}

}
