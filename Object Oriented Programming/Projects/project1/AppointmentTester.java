import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class AppointmentTester {

	public static void main(String[] args) throws FileNotFoundException {
		AppointmentBook apptBook=new AppointmentBook();
		@SuppressWarnings("resource")
		Scanner scanner=new Scanner(System.in);
		//Initalize all the dates we will be working with.
		Daily d1=new Daily("Go to work",10,11,2010);
		Monthly m1=new Monthly("Get a haircut", 12,4,2002);
		OneTime o1=new OneTime("Tour a college", 6,6,2016);
		Daily d2=new Daily("Brush my teeth",10,11,1997);
		Monthly m2=new Monthly("Go to the dentist", 15,4,2000);
		OneTime o2=new OneTime("Register for the draft", 5,10,2014);
		Daily d3=new Daily("Sleep",10,11,1997);
		Monthly m3=new Monthly("Weigh myself", 15,9,2000);
		OneTime o3=new OneTime("Go to Florida", 3,5,2002);
		Daily d4=new Daily("Eat food",10,11,1997);
		Monthly m4=new Monthly("Check my grades", 15,11,2000);
		OneTime o4=new OneTime("First day at Miami!", 28,8,2016);
		Daily d5=new Daily("Get out of bed",10,11,1997);
		Monthly m5=new Monthly("Take an exam", 9,4,2016);
		OneTime o5=new OneTime("First time going to school!", 28,8,2001);
		
		//add them all to the appointmentbook so that they can work together
		apptBook.addAppointment(d1);
		apptBook.addAppointment(m1);
		apptBook.addAppointment(o1);
		apptBook.addAppointment(d2);
		apptBook.addAppointment(m2);
		apptBook.addAppointment(o2);
		apptBook.addAppointment(d3);
		apptBook.addAppointment(m3);
		apptBook.addAppointment(o3);
		apptBook.addAppointment(d4);
		apptBook.addAppointment(m4);
		apptBook.addAppointment(o4);
		apptBook.addAppointment(d5);
		apptBook.addAppointment(m5);
		apptBook.addAppointment(o5);
		
		//take the user input for which day, month and year they want to check.
		//don't allow errored input
		int day=1, month=1, year=1600;
		do{
		System.out.println("Enter a day");
		day=scanner.nextInt();
		System.out.println("Enter a month");
		month=scanner.nextInt();
		System.out.println("Enter a year");
		year=scanner.nextInt();
		} while(day>31 && month>12 && year <1600);
		
		//find all the appointments that occur on that day and print out their description, telling the user what appointments they have that day. 
		for (Appointment x:apptBook.getAppointments())
		{
			if (x.occursOn(year, month, day))
			{
				System.out.println(x.getDescription());
			}
		}
		

	}

}
