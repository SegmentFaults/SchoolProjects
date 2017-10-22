import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
/**
 * 
 * @author Michael
 *
 */
public class AppointmentBook {
	private ArrayList<Appointment> appointments=new ArrayList<Appointment>();

	private enum AppointmentTypes{OneTime,Daily,Monthly};

	//no constructor really needed to declare anything
	AppointmentBook(){}
	/**
	 * 
	 * @param g, the calander used to create an appointment
	 * @param apptType, the type of appointment using the enum
	 * @param description, description of the appointment
	 */
	public void createAppointment(GregorianCalendar g, AppointmentTypes apptType, String description){
		Appointment appt;
		if (apptType==AppointmentTypes.Daily){
			appt=new Daily(description,g.get(Calendar.DAY_OF_MONTH), g.get(Calendar.MONTH), g.get(Calendar.YEAR));
		}
		else if(apptType==AppointmentTypes.Monthly){
			appt=new Monthly(description,g.get(Calendar.DAY_OF_MONTH), g.get(Calendar.MONTH), g.get(Calendar.YEAR));
		}
		else{
			appt=new OneTime(description,g.get(Calendar.DAY_OF_MONTH), g.get(Calendar.MONTH), g.get(Calendar.YEAR));
		}
		appointments.add(appt);
	}
	/**
	 * 
	 * @param a, the appointment that needs added to the appointment book
	 * @see, this just adds the appointment to the book so that you can work with the arraylist.
	 */
	public void addAppointment(Appointment a)
	{
		appointments.add(a);
	}
	/**
	 * 
	 * @param appt, the appointment you want saved
	 * @param file, file you want the appointment printed to
	 * @throws FileNotFoundException, if it can't find the file needed it will throw an exception
	 */
	public void saveAppointment(Appointment appt, File file) throws FileNotFoundException{
		String fileContents="";
		PrintWriter pw=new PrintWriter(file);
		if (appt instanceof Daily)
		{
			fileContents+="D&";//these D& are to specify what type of appt it is
		}
		else if(appt instanceof Monthly)
		{
			fileContents+="M&";
		}
		else{
			fileContents+="O&";
		}
		//splitting our variables with the &
		fileContents+=""+appt.getDescription()+"&"+appt.getDate().get(Calendar.DAY_OF_MONTH)+"&"+appt.getDate().get(Calendar.MONTH)+"&"+appt.getDate().get(Calendar.YEAR);
		pw.write(fileContents);
		pw.close();
	}
	/**
	 * 
	 * @param file, file you want to load from
	 * @throws FileNotFoundException, throws if it cant find the file wanted. 
	 */
	public void loadAppointment(File file) throws FileNotFoundException{
		Scanner sc = new Scanner(file);
		String[] tokens;
		Appointment appointment;
		//get the information from the file
		do {
			tokens = sc.nextLine().split("&");
		} while(sc.hasNextLine());
		sc.close();
		//now based on the apponitment type allocate the parameters.
		if (tokens[0].equals("D"))
		{
			appointment=new Daily(tokens[1],Integer.parseInt(tokens[2]),Integer.parseInt(tokens[3]),Integer.parseInt(tokens[4]));
		}
		else if (tokens[0].equals("M"))
		{
			appointment=new Monthly(tokens[1],Integer.parseInt(tokens[2]),Integer.parseInt(tokens[3]),Integer.parseInt(tokens[4]));
		}
		else{
			appointment=new OneTime(tokens[1],Integer.parseInt(tokens[2]),Integer.parseInt(tokens[3]),Integer.parseInt(tokens[4]));
		}
		this.addAppointment(appointment);
	}	
	/**
	 * @return the appointments
	 */
	public ArrayList<Appointment> getAppointments() {
		return appointments;
	}
}
