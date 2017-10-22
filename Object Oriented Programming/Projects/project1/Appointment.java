import java.util.Calendar;
import java.util.GregorianCalendar;
/**
 * 
 * @author Michael
 *
 */
public abstract class Appointment {
	
	//declare all instance variables
	private String description;
	private GregorianCalendar date;
	Appointment(String description, int day, int month, int year){
		date=new GregorianCalendar(year,month,day);
	}
	/**
	 * 
	 * @param year year of the date to check
	 * @param month month of the date to check
	 * @param day day of the date to check
	 * @return true of false. if true then that appointment occurs on that day.
	 */
	public abstract boolean occursOn(int year, int month, int day);
	/**
	 * 
	 * @return description of the activity
	 */
	public String getDescription(){
		return description;
	}
	/**
	 * 
	 * @return the date object for the calendar so that you can retrieve the day month and year.
	 */
	public GregorianCalendar getDate(){
		return date;
	}
	@Override
	public String toString(){
		return description+" "+this.getClass()+" day: "+this.getDate().get(Calendar.DAY_OF_MONTH)+" month: "+ this.getDate().get(Calendar.MONTH)+" year: "+this.getDate().get(Calendar.YEAR);
		
	}
}
