#pragma once
#include <vector>
#include <string>
class Person;
class Student;
class Administrator;
class Professor;
using namespace std;
class Course
{
public:
	static vector<Course> allCourses;
	Course(string name, int number, unsigned int capacity);
	~Course();
	string getName();
	int getNumber();
	unsigned int getCapacity();
	void changeName(string name);
	void changeNumber(int number);
	void changeCapacity(unsigned int capacity);
	void addStudent(Student s);
	bool operator==(const Course &other) const;
	void removeStudent(Student s);
	//void outputAllCourses();
	//void inputAllCourses();
private:
	string name;
	int number;
	unsigned int capacity;
	vector<Student> students;
};

