/**
 * 
 */

/**
 * @author gentilm5
 *
 */
public class Instructor extends Person {
	//the salary of the instructor
	private int salary;
	/**
	 * 
	 * @param name is the name of the instructor, inherited from the superclass
	 * @param yearOfBirth is the year of birth of the instructor, inherited from the superclass
	 * @param salary is the salary of the instructor
	 */
	Instructor(String name, int yearOfBirth, int salary) {
		super(name, yearOfBirth);
		this.salary=salary;
	}
	/**
	 * 
	 * @return the salary of the Instructor
	 */
	public int getSalary(){
		return salary;
	}
	/**
	 * 
	 * @param salary is the salary we want the Instructor's new salary to be.
	 */
	public void setSalary(int salary){
		this.salary=salary;
	}
	@Override
	/**
	 * returns the name, year of birth and the salary of the instructor.
	 */
	public String toString()
	{
		return super.toString()+ " " + salary;
	}
}
