/**
 * 
 */

/**
 * @author gentilm5
 *
 */
public class Manager extends Employee {
	//The department of the manager
	private String department;
	/**
	 * 
	 * @param name the name of the manager
	 * @param salary the salary amount
	 * @param department the department in which the manager belongs.
	 */
	Manager(String name, int salary, String department) {
		super(name, salary);
		this.department=department;
	}
	/**
	 * 
	 * @return the department of the Manager
	 */
	public String getDepartment(){
		return department;
	}
	/**
	 * 
	 * @param department is the department that the manager now works. 
	 */
	public void setDepartment(String department){
		this.department=department;
	}
	/**
	 * @return the name, salary and department of the manager. 
	 */
	@Override
	public String toString(){
		return super.toString()+" "+ department;
	}
}
