
public class Person {
	//name of the person
	private String name;
	//year that the person was born
	private int yearOfBirth;
	/**
	 * 
	 * @param name of the person.
	 * @param yearOfBirth the year in which the person was born
	 */
	Person(String name, int yearOfBirth)
	{
		this.name=name;
		this.yearOfBirth=yearOfBirth;
	}
	/**
	 * 
	 * @return the name of the person
	 */
	public String getName(){
		return name;
	}
	/**
	 * 
	 * @param name, the new name of the person
	 */
	public void setName(String name){
		this.name=name;
	}
	/**
	 * 
	 * @return the year that the person was born
	 */
	public int getYearBorn(){
		return yearOfBirth;
	}
	/**
	 * 
	 * @param yearOfBirth the new yearOfBirth of the person
	 */
	public void setYearBorn(int yearOfBirth){
		this.yearOfBirth=yearOfBirth;
	}
	/**
	 * returns the name and year of birth of the person.
	 */
	@Override
	public String toString(){
		return name+" "+yearOfBirth;
	}

}
