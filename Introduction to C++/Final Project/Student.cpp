#include "Student.h"
#include "Person.h"
#include "Course.h"
#include "Administrator.h"
#include "Professor.h"
#include <vector>
#include <algorithm>
class Person;
using namespace std;
Student::Student(string name, string username, string password, string department) : Person(name,username,password,department)
{
}

vector<Student> Student::allStudents;
Student::~Student()
{
}

void Student::addCourse(Course c)
{
	this->courses.push_back(c);
}

void Student::removeCourse(Course c)
{
	this->courses.erase(remove(this->courses.begin(), this->courses.end(), c), this->courses.end());
}

vector<Course> Student::getCourses()
{
	return courses;
}
