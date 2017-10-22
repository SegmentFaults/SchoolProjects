package edu.miamioh.gentilm5;

import java.util.ArrayList;
/**
 * This is a course that is taught at the University.
 * @author Michael
 *
 */
public class Course {
	private Instructor instructor;
	private LectureHall lectureHall;
	private ArrayList<Student> students;
	/**
	 * 
	 * @param i is the instructor for the couse
	 * @param l is the lecturehall where the course takes place
	 * @param students is the students that enrolled in the course.
	 */
	public Course(Instructor i, LectureHall l, ArrayList<Student> students) {
		super();
		this.instructor = i;
		this.lectureHall = l;
		this.students = students;
		if (students==null){
			students=new ArrayList<Student>();
		}
	}
	/**
	 * @return the instructor of the course
	 */	
	public Instructor getInstructor() {
		return instructor;
	}

	/**
	 * 
	 * @param i is the instructor that you want to set for the course.
	 */
	public void setInstructor(Instructor i) {
		this.instructor = i;
	}
	/**
	 * @return the lectureHall where the course takes place
	 */
	public LectureHall getLectureHall() {
		return lectureHall;
	}
	/**
	 * @param l is the lectureHall you want for the course
	 */
	public void setLectureHall(LectureHall l) {
		this.lectureHall = l;
	}
	/**
	 * @return the students enrolled in the course
	 */
	public ArrayList<Student> getStudents() {
		return students;
	}
	/**
	 * @param students the students to set in the course.
	 */
	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}
	
	/**
	 * @return the name of the course and the Instructor
	 */
	@Override
	public String toString(){
		return this.instructor.getId()+" "+this.getLectureHall().getName();
		
	}

}
