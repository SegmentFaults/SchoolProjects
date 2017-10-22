package edu.miamioh.gentilm5;
/**
 * This is a place where courses may be taught. They have a name and capacity.
 * @author Michael
 *
 */
public class LectureHall {
	private int capacity;
	private String name;
	/**
	 * Constructs a new instance of LectureHall
	 * @param capacity is the capacity (in people) of the lectureHall
	 * @param name is the name of the Hall
	 */
	public LectureHall(int capacity, String name) {
		super();
		this.capacity = capacity;
		this.name = name;
	}
	/**
	 * gets the capacity of the Hall
	 * @return the capacity of the lectureHall
	 */
	public int getCapacity() {
		return capacity;
	}
	/**
	 * Changes the capacity of the hall
	 * @param capacity is the new capacity of the lectureHall
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	/**
	 * @return the name of the lectureHall
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name is the new name of the lectureHall
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the name of the hall
	 */
	public String toString(){
		return name;
		
	}
	
}
