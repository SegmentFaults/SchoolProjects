/**
 * 
 */

/**
 * @author gentilm5
 *
 */
public class Student extends Person{
	//major in which the student is enrolled
	private String major;
	/**
	 * 
	 * @param name, name of the student given from the superclass
	 * @param yearOfBirth, year the student was born, given from the superclass
	 * @param major, major in which the student is enrolled.
	 */
	Student(String name, int yearOfBirth, String major) {
		super(name, yearOfBirth);
		this.major=major;
	}
	/**
	 * 
	 * @return the major of the student
	 */
	public String getMajor(){
		return major;
	}
	/**
	 * 
	 * @param major, the new major in which the student is enrolled
	 */
	public void setMajor(String major){
		this.major=major;
	}
	/**
	 * returns the name, year of birth and the major of the student in that order
	 */
	@Override
	public String toString()
	{
		return super.toString()+ " " +major;
	}
	

}
