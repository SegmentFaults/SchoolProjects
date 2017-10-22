import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * 
 */

/**
 * @author Michael
 *
 */
public class Monthly extends Appointment {
	//simply calls the super constructor
	Monthly(String description, int day, int month, int year){
		super(description,day,month,year);
	}
	/* (non-Javadoc)
	 * @see Appointment#occursOn(int, int, int)
	 */
	@Override
	/**
	 * if the day of the month for the object is the same and it occurs on or after the date give, then it returns true.
	 */
	public boolean occursOn(int year, int month, int day) {
		GregorianCalendar temp=new GregorianCalendar(year,month,day);
		if (super.getDate().get(Calendar.DAY_OF_MONTH)==temp.get(Calendar.DAY_OF_MONTH) && (super.getDate().before(temp) || super.getDate().equals(temp)))
		{
			return true;
		}
		return false;
	}

}
