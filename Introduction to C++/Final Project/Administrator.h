#pragma once
class Person;
class Course;
class Student;
class Professor;
#include <vector>
using namespace std;
class Administrator : public Person
{
public:
	static vector<Course> courses;
	static vector<Professor> professors;
	static vector<Student> students;
	Administrator(string name, string username, string password, string department);
	void createCourse(Course c);
	void addProfessor(Professor p);
	static void outputCourses();
	static void outputProfessors();
	static void outputStudents();
	static void inputCourses();
	static void inputProfessors();
	static void inputStudents();
	~Administrator();
};

