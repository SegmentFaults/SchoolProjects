#include "Person.h"
#include "Course.h"
#include "Administrator.h"
#include "Student.h"
#include "Professor.h"
#include <vector>
#include <fstream>
#include <iostream>
using namespace std;
vector<Course> Administrator::courses;
vector<Professor> Administrator::professors;
vector<Student> Administrator::students;
Administrator::Administrator(string name, string username, string password, string department) : Person(name,username,password,department)
{
}

void Administrator::createCourse(Course c)
{
	courses.push_back(c);
}

void Administrator::addProfessor(Professor p)
{
	professors.push_back(p);
}

void Administrator::outputCourses()
{
	ofstream myfile;
	myfile.open("allCourses.txt");
	for (int x = 0; x < Administrator::courses.size(); x++) {
		myfile << Administrator::courses.at(x).getName() << "," << Administrator::courses.at(x).getCapacity() << "," << Administrator::courses.at(x).getNumber()<<endl;
	}
	myfile.close();
}


void Administrator::outputProfessors()
{
	ofstream myfile;
	myfile.open("allProfessors.txt");
	for (int x = 0; x < Administrator::professors.size(); x++) {
		myfile << Administrator::professors.at(x).getName() << "," << Administrator::professors.at(x).getUsername() << "," << Administrator::professors.at(x).getPassword()<<","<<Administrator::professors.at(x).getDepartment()<< endl;
	}
	myfile.close();
}

void Administrator::outputStudents()
{
	ofstream myfile;
	myfile.open("allStudents.txt");
	for (int x = 0; x < Administrator::students.size(); x++) {
		myfile << Administrator::students.at(x).getName() << "," << Administrator::students.at(x).getUsername() << "," << Administrator::students.at(x).getPassword() << "," << Administrator::students.at(x).getDepartment() << endl;
	}
	myfile.close();
}

void Administrator::inputCourses()
{
	ifstream myfile;
	myfile.open("allCourses.txt");
	string line;
	string temp = "";
	if (myfile.is_open())
	{
		while (getline(myfile, line))
		{
			int count = 0;
			Course c("", 0, 0);
			for (int q = 0; q < line.length(); q++) {
				bool corrupt = false;
				if (line.at(q) != ',') {
					temp += line.at(q);
				}
				else {
					count++;
					corrupt = true;
				}
				if (count == 1 && corrupt) {
					c.changeName(temp);
					temp = "";
					corrupt = false;
				}
				else if (count == 2 && corrupt) {
					int g = stoi(temp);
					c.changeCapacity(g);
					temp = "";
					corrupt = false;
				}
			}
			//cout << "ran this";
			int g = stoi(temp);
			c.changeNumber(g);
			temp = "";
			Administrator::courses.push_back(c);
		}
		myfile.close();
	}
}

void Administrator::inputProfessors()
{
	ifstream myfile;
	myfile.open("allProfessors.txt");
	string line;
	string temp = "";
	if (myfile.is_open())
	{
		while (getline(myfile, line))
		{
			int count = 0;
			Professor c("","","","");
			for (int q = 0; q < line.length(); q++) {
				bool corrupt = false;
				if (line.at(q) != ',' && line.at(q) != '\n') {
					temp += line.at(q);
				}
				else {
					count++;
					corrupt = true;
				}
				if (count == 1 && corrupt) {
					c.setName(temp);
					temp = "";
					corrupt = false;
				}
				else if (count == 2 && corrupt) {
					corrupt = false;
					c.setUsername(temp);
					temp = "";
				}
				else if (count == 3 && corrupt) {
					corrupt = false;
					c.setPassword(temp);
					temp = "";
				}

			}
			c.setDepartment(temp);
			temp = "";
			Administrator::professors.push_back(c);
		}
		myfile.close();
	}
}

void Administrator::inputStudents()
{
	ifstream myfile;
	myfile.open("allStudents.txt");
	string line;
	string temp = "";
	if (myfile.is_open())
	{
		while (getline(myfile, line))
		{
			int count = 0;
			Student c("", "", "", "");
			for (int q = 0; q < line.length(); q++) {
				bool corrupt = false;
				if (line.at(q) != ',' && line.at(q) != '\n') {
					temp += line.at(q);
				}
				else {
					count++;
					corrupt = true;
				}
				if (count == 1 && corrupt) {
					c.setName(temp);
					temp = "";
					corrupt = false;
				}
				else if (count == 2 && corrupt) {
					corrupt = false;
					c.setUsername(temp);
					temp = "";
				}
				else if (count == 3 && corrupt) {
					corrupt = false;
					c.setPassword(temp);
					temp = "";
				}
			}
			c.setDepartment(temp);
			temp = "";
			//cout << "pushing student";
			Administrator::students.push_back(c);
		}
		myfile.close();
	}
}

Administrator::~Administrator()
{
}
