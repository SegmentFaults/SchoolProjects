
package edu.miamioh.gentilm5;

import java.util.ArrayList;

/**
 * Is an administrator for the administrative staff. 
 * @author Michael
 * 
 */
public class AdminStaff extends Person {
	private int salary;
	/**
	 * Constructs a new Administrator
	 * @param id is the ID number of the AdminStaff
	 * @param email is the email address for the admin
	 * @param salary is the salary of the admin
	 */
	AdminStaff(int id, String email, int salary) {
		super(id, email);
		this.salary=salary;
	}
	/**
	 * gets the salary of the admin
	 * @return the salary of the admin
	 */
	public int getSalary() {
		return salary;
	}
	/**
	 * set the salary of the Admin
	 * @param salary is the new salary of the admininstrator
	 */
	public void setSalary(int salary) {
		this.salary = salary;
	}
	/**
	 * This method will enroll a student in a course.
	 * @param s is the student that you're enrolling
	 * @param c is the course that you're enrolling them in
	 * 
	 */
	public void enrollStudentInCourse(Student s, Course c){
		s.getCourses().add(c);
		ArrayList<Student> newS=c.getStudents();
		newS.add(s);
		c.setStudents(newS);
	}
	/**
	 * This method assigns a lecture hall a specific course.
	 * @param c is the course you're going to assign.
	 * @param l is the lectureHall that you want the course assigned to
	 */
	public void assignLectureHall(Course c, LectureHall l){
		c.setLectureHall(l);
	}
	/**
	 * This method assigns an instructor to the course. 
	 * @param c is the course you want to assign an instructor to
	 * @param i is the instructor you want to assign to the course
	 */
	public void assignInstructor(Course c, Instructor i){
		c.setInstructor(i);
	}
}
