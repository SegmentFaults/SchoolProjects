import java.util.GregorianCalendar;

public class OneTime extends Appointment {
	//simply calls the super
	OneTime(String description, int day, int month, int year){
		super(description,day,month,year);
	}
	@Override
	//if the date is the same as the day of the appointment, then it returns true
	public boolean occursOn(int year, int month, int day) {
		GregorianCalendar temp=new GregorianCalendar(year,month,day);
		if(super.getDate().equals(temp))
		{
			return true;
		}
		return false;
	}

}
