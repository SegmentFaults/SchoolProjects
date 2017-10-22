#pragma once
#include<vector>
class Person;
class Course;
class Administrator;
//class Professor;
class Student;
class Professor : public Person
{
public:
	Professor(string name, string username, string password, string department);
	~Professor();
	void addCourse(Course c);
	void removeCourse(Course c);
	vector<Course> getCourses();
	vector<Course> courses;
private:
	
};

