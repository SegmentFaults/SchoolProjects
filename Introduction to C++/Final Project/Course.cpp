#include "Person.h"
#include "Course.h"
#include "Administrator.h"
#include "Student.h"
#include "Professor.h"
#include <string>
#include <vector>
#include <algorithm>
#include <fstream>
Course::Course(string name, int number, unsigned int capacity)
{
	this->name = name;
	this->number = number;
	this->capacity = capacity;
	//this->allCourses.push_back(*this);
}
vector<Course> Course::allCourses;
unsigned int Course::getCapacity() {
	return this->capacity;
}

void Course::changeName(string name)
{
	this->name = name;
}

void Course::changeNumber(int number)
{
	this->number = number;
}

void Course::changeCapacity(unsigned int capacity)
{
	this->capacity = capacity;
}

void Course::addStudent(Student s)
{
	students.push_back(s);
}

Course::~Course()
{
}

string Course::getName()
{
	return this->name;
}

int Course::getNumber()
{
	return this->number;
}
bool Course::operator==(const Course &other) const {
	if (other.name == this->name) {
		return true;
	}
	else {
		return false;
	}
}

void Course::removeStudent(Student s)
{
	students.erase(remove(this->students.begin(), this->students.end(), s), students.end());
}

//void Course::outputAllCourses()
//{
//	ofstream myfile;
//	myfile.open("allCourses.txt");
//	for (int x = 0; x < this->allCourses.size(); x++) {
//		myfile << allCourses.at(x).getName() << "," << allCourses.at(x).getCapacity() << "," << allCourses.at(x).getNumber()<<endl;
//		//now output all the students in the course;
//		for (int y = 0; y < this->allCourses.at(x).students.size(); y++) {
//			myfile << allCourses.at(x).students.at(y).getUsername() << ",";
//		}
//	}
//	
//	myfile.close();
//}
//
//void Course::inputAllCourses()
//{
//	string tempContent = "";
//	ifstream myfile;
//	myfile.open("allCourses.txt");
//	string line;
//	int count = 1;
//	if (myfile.is_open())
//	{
//		while (getline(myfile, line))
//		{
//			tempContent = line;
//		}
//		myfile.close();
//	}
//	vector<string> parts;
//	int g = 0;
//	string tempSt = "";
//	while (g < tempContent.size()) {
//		if (tempContent.at(g) != ',') {
//			tempSt += tempContent.at(g);
//			g++;
//		}
//		else {
//			parts.push_back(tempSt);
//			tempSt = "";
//			g++;
//		}
//	}
//}
