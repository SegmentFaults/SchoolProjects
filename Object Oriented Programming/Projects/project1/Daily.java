import java.util.GregorianCalendar;

public class Daily extends Appointment {
	//simply calls the constructor for the super class
	Daily(String description, int day, int month, int year){
		super(description,day,month,year);
	}
	@Override
	/**
	 * @see, if this appointment occurs after the date in question, then return that it occurs on that date.
	 * Therefore, it will return true. If it is before the appointment date's creation time then it will return false.
	 */
	public boolean occursOn(int year, int month, int day) {
		GregorianCalendar temp=new GregorianCalendar(year,month,day);
		if(super.getDate().after(temp))
		{
			return false;
		}
		return true;
	}

}
