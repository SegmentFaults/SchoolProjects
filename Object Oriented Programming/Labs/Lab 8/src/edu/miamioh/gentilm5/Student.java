/**
 * 
 */
package edu.miamioh.gentilm5;

import java.util.ArrayList;

/**
 * This is a student that attends the university.
 * @author Michael
 * 
 */
public class Student extends Person {
	private String major;
	private ArrayList<Course> courses;
	private double gpa;
	/**
	 * Constructs a new student
	 * @param id id of the student
	 * @param email, email of the student
	 * @param major, major of the student
	 * @param courses, courses in an ArrayList the student has taken
	 * @param gpa, gpa of the student
	 */
	Student(int id, String email, String major, ArrayList<Course> courses, double gpa) {
		super(id, email);
		this.major=major;
		this.courses=courses;
		this.gpa=gpa;
	}
	/**
	 * Returns the major of the student
	 * @return the major of the student
	 */
	public String getMajor() {
		return major;
	}
	/**
	 * Sets the major of the student
	 * @param the major to change to.
	 */
	public void setMajor(String major) {
		this.major = major;
	}
	/**
	 * Gets the current courses the student is taking
	 * @return the courses the student is taking in the form of an ArrayList
	 */
	public ArrayList<Course> getCourses() {
		return courses;
	}
	/**
	 * sets the courses that the student is taking
	 * @param courses, the courses (in the form of an ArrayList
	 */
	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}
	/**
	 * gets the GPA of the student
	 * @return the gpa of the student
	 */
	public double getGpa() {
		return gpa;
	}
	/**
	 * Sets the GPA of the student
	 * @param gpa is the new gpa of the student. 
	 */
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	/**
	 * Returns the id of the student and their major
	 */
	public String toString(){
		return this.getId()+" "+this.getMajor();
	}
}
