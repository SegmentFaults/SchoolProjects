package edu.miamioh.gentilm5;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Tester {

	public static void main(String[] args) {
		//construct everything
		LectureHall hall1=new LectureHall(50, "Room1");
		LectureHall hall2=new LectureHall(50, "Room2");
		ArrayList<LectureHall> lectureHalls=new ArrayList<>();
		lectureHalls.add(hall1);
		lectureHalls.add(hall2);
		Instructor instructor1=new Instructor(333, "emailAddress1", 50000);
		Instructor instructor2=new Instructor(334, "emailAddress2", 51000);
		ArrayList<Instructor> instructorList=new ArrayList<Instructor>();
		instructorList.add(instructor1);
		instructorList.add(instructor2);
		ArrayList<Course> courses=new ArrayList<Course>();
		Course c1=new Course(instructor1, hall2, null);
		Course c2=new Course(instructor2, hall1, null);
		Course c3=new Course(instructor1, hall1, null);
		Course c4=new Course(instructor2, hall2, null);
		courses.add(c1);
		courses.add(c2);
		courses.add(c3);
		courses.add(c4);
		ArrayList<Course> coursesForStudent1=new ArrayList<Course>();
		ArrayList<Course> coursesForStudent2=new ArrayList<Course>();
		coursesForStudent1.add(c1);
		coursesForStudent1.add(c2);
		coursesForStudent1.add(c4);
		coursesForStudent2.add(c3);
		coursesForStudent2.add(c2);
		coursesForStudent2.add(c4);
		Student student1=new Student(335, "emailAddress3", "Econ", coursesForStudent1, 3.0);
		Student student2=new Student(336, "emailAddress4", "Business", coursesForStudent2, 3.5);
		AdminStaff staff1=new AdminStaff(337, "emailAddress5", 52000);
		AdminStaff staff2=new AdminStaff(338, "emailAddress6", 53000);
		ArrayList<Student> students=new ArrayList<Student>();
		students.add(student1);
		students.add(student2);
		
		//Test Lecture Hall methods
		System.out.println("EXPECTED: 50");
		System.out.println(hall1.getCapacity());
		System.out.println("EXPECTED: Room1");
		System.out.println(hall1.getName());
		System.out.println();
		System.out.println();
		
		
		//Test the Instructor methods
		System.out.println("EXPECTED: 50000");
		System.out.println(instructor1.getSalary());
		
		instructor1.assignGPA(3.6, student1);
		System.out.println("EXPECTED: 3.6");
		System.out.println(student1.getGpa());
		
		instructor1.changeGPA(3.7, student1);
		System.out.println("EXPECTED: 3.7");
		System.out.println(student1.getGpa());
		
		//test course methods
		System.out.println();
		System.out.println();
		
		c1.setStudents(students);
		System.out.println("EXPECTED:335 Econ");
		System.out.println("EXPECTED:336 Business");
		System.out.println(c1.getStudents().get(0));
		System.out.println(c1.getStudents().get(1));
		//Simple getters and setters do not need tested. 
		
		//test adminStaff
		staff1.assignInstructor(c1, instructor2);//previous instructor was ins1
		System.out.println("EXPECTED: 334");
		System.out.println(c1.getInstructor());
		staff1.assignLectureHall(c1,hall1);//was previously hall2
		System.out.println("EXPECTED: Room1");
		System.out.println(c1.getLectureHall());
		staff1.enrollStudentInCourse(student1, c1);
		System.out.println("EXPECTED: 335 Econ");
		System.out.println(c1.getStudents().get(0));
		
		JFrame frame=new JFrame();
		JPanel panel=new JPanel();
		JButton button=new JButton("Add Student to Course");
		JButton button1=new JButton("Add Insructor to Course");
		JButton button2=new JButton("Assign Course to Lecture Hall");
		JComboBox instructorsBox=new JComboBox<>(instructorList.toArray());
		JComboBox studentsBox=new JComboBox<>(students.toArray());
		JComboBox lectureHallBox=new JComboBox<>(lectureHalls.toArray());
		JComboBox coursesBox=new JComboBox<>(courses.toArray());
		panel.setSize(800,600);
		frame.setSize(800, 600);
		button.setSize(100,100);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		button.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(panel);
		panel.add(button);
		panel.add(button1);
		panel.add(button2);
		panel.add(instructorsBox);
		panel.add(studentsBox);
		panel.add(lectureHallBox);
		panel.add(coursesBox);
		panel.setVisible(true);
		button.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	staff1.enrollStudentInCourse((Student)studentsBox.getSelectedItem(), (Course)coursesBox.getSelectedItem());
		      }
		    });
		button1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	staff1.assignInstructor((Course)coursesBox.getSelectedItem(),(Instructor) instructorsBox.getSelectedItem());
		      }
		    });
		button2.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	staff1.assignLectureHall((Course)coursesBox.getSelectedItem(), (LectureHall)lectureHallBox.getSelectedItem());
		      }
		    });
	}


	}		

