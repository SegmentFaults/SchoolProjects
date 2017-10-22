#pragma once
#include <vector>
#include "Person.h"
class Person;
class Course;
class Administrator;
class Professor;
using namespace std;

class Student: public Person
{
public:
	Student(string name, string username, string password, string department);
	~Student();
	void addCourse(Course c);
	void removeCourse(Course c);
	vector<Course> getCourses();
	vector<Course> courses;
	static vector<Student> allStudents;
private:
	
};

