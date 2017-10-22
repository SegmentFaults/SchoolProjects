/**
 * 
 */

/**
 * @author gentilm5
 *
 */
public class Executive extends Manager {
	//place where the executive's office presides.
	private String officeLocation;
	/**
	 * 
	 * @param name of the executive
	 * @param salary the salary of the executive
	 * @param department the department of the executive
	 * @param officeLocation the office location of the executive
	 */
	Executive(String name, int salary, String department, String officeLocation) {
		super(name, salary, department);
		this.officeLocation=officeLocation;
	}
	/**
	 * 
	 * @return the location of the Executive's office. 
	 */
	public String getOfficeLocation(){
		return officeLocation;
	}
	/**
	 * 
	 * @param the new office location of the executive
	 */
	public void setOfficeLocation(String officeLocation){
		this.officeLocation=officeLocation;
	}
	/**
	 * @return the Executive name, salary, department and office location in that order.
	 */
	@Override
	public String toString(){
		return super.toString()+ " " + officeLocation;
	}

}
