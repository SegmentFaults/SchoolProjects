#include "Person.h"
#include "Course.h"
#include "Administrator.h"
#include "Student.h"
#include "Professor.h"
#include <algorithm>


Professor::Professor(string name, string username, string password, string department):Person(name, username, password, department)
{
}


Professor::~Professor()
{
}

void Professor::addCourse(Course c)
{
	this->courses.push_back(c);
}

void Professor::removeCourse(Course c)
{
	courses.erase(remove(this->courses.begin(), this->courses.end(),c), courses.end());
}

vector<Course> Professor::getCourses()
{
	return this->courses;
}

