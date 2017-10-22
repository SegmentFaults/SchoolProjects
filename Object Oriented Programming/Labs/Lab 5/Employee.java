/**
 * 
 */

/**
 * @author gentilm5
 *
 */
public class Employee {
	//name of the employee
	private String name;
	//salary of the employee
	private int salary;
	
	/**
	 * 
	 * @param name, which is the name of the employee
	 * @param salary, which is the salary of the employee
	 */
	Employee(String name, int salary){
		this.name=name;
		this.salary=salary;
	}
	/**
	 * 
	 * @return the salary of the employee
	 */
	public int getSalary(){
		return salary;
	}
	/**
	 * 
	 * @param salary is the salary we want to change the Employee's salary to
	 */
	public void setSalary(int salary){
		this.salary=salary;
	}
	/**
	 * 
	 * @return the name of the employee
	 */
	public String getName(){
		return name;
	}
	/**
	 * 
	 * @param name the name that we want the employee to have. 
	 */
	public void setName(String name){
		this.name=name;
	}
	/**
	 * @return the name and salary of the employee in a String
	 */
	@Override
	public String toString(){
		return name+" "+ salary;
	}
}
