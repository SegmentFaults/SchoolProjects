/**
 * 
 */
package edu.miamioh.gentilm5;

import java.util.ArrayList;

/**
 * This class in an instructor. They advise classes and have a salary and courses that they teach.
 * @author Michael
 * 
 */
public class Instructor extends Person {
	private int salary;
	private ArrayList<Course> coursesTaught=new ArrayList<Course>();
	/**
	 * Constructs an Instructor
	 * @param id, id of the instructor
	 * @param email, email of the instructor
	 * @param salary, salary of the instructor
	 */
	Instructor(int id, String email, int salary) {
		super(id, email);
		this.salary=salary;
	}
	/**	
	 * @return the salary
	 */
	public int getSalary() {
		return salary;
	}
	/** Sets the salary of the instructor
	 * @param salary the salary to set
	 */
	public void setSalary(int salary) {
		this.salary = salary;
	}
	/**
	 * Sets the GPA of a student
	 * @param gpa, gpa of the student
	 * @param s, student to which you attribute the GPA
	 */
	public void assignGPA(double gpa, Student s){
		s.setGpa(gpa);
	}
	/**
	 * Changes the GPA of a student
	 * @param gpa, gpa of the student
	 * @param s, student to which you attribute the GPA
	 */
	public void changeGPA(double gpa, Student s){
		s.setGpa(gpa);
	}
	/**
	 * Gets the courses that the instructor teaches
	 * @return a list of courses that the instructor teaches
	 */
	public ArrayList<Course> getListOfCourses(){
		return this.coursesTaught;
	}
	
	public String toString(){
		return super.getId()+"";
	}
}
