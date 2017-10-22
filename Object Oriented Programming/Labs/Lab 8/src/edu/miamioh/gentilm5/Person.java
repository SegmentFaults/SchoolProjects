package edu.miamioh.gentilm5;
/**
 * Abstract person used to supplement the Student, AdminStaff and and Instructor
 * @author Michael
 *
 */
public abstract class Person {
	private int id;
	private String email;
	/**
	 * Constructs a new person
	 * @param id is the user id of the person
	 * @param email is the email of the person
	 */
	Person(int id, String email){
		this.id=id;
		this.email=email;
	}
	/**
	 * Gets the University ID of ther person
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * Sets the ID of the person
	 * @param id is the new id of the person
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Gets the email address of the person
	 * @return the email of the person
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * sets the ID of the email
	 * @param email is the new email of the person
	 */
	public void setEmail(String email) {
		this.email = email;
	}

}
