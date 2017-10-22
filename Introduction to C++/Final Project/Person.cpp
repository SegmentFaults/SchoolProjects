
#include <string>
#include <fstream>
#include <vector>
#include <sstream>
#include <iostream>
#include "Person.h"
#include "Course.h"
using namespace std;
Person::Person(string name, string username, string password, string department) {
	setPassword(password);
	setUsername(username);
	setName(name);
	setDepartment(department);
}
void Person::setDepartment(string department) {
	this->department = department;
}
void Person::setName(string name) {
	this->name = name;
}
void Person::setUsername(string username) {
	this->username = username;
}
void Person::setPassword(string password) {
	this->password = password;
}
string Person::getPassword() {
	return this->password;
}
string Person::getName() {
	return this->name;
}
string Person::getUsername() {
	return this->username;
}
string Person::getDepartment() {
	return this->department;
}
void Person::outfile() {
	ofstream myfile;
	myfile.open(this->username + ".txt");
	myfile << this->password << "," << this->name << "," << this->department;
	myfile.close();
}
bool Person::login(string username, string password)
{
	string tempString;
	string tempPassword;
	string tempContent;
	ifstream myfile(this->username + ".txt");
	string line;
	if (myfile.is_open())
	{
		while (getline(myfile, line))
		{
			tempContent = line;
		}
		myfile.close();
	}
	else {
		return false;
	}
	vector<string> parts;
	int g = 0;
	string tempSt = "";
	while (g < tempContent.size()) {
		if (tempContent.at(g) != ',') {
			tempSt += tempContent.at(g);
			g++;
		}
		else {
			parts.push_back(tempSt);
			tempSt = "";
			g++;
		}
	}
	if (parts.at(0) == password) {
		return true;
	}
	else {
		return false;
	}
}
bool Person::operator==(const Person &other) const {
	if (other.username == this->username) {
		return true;
	}
	else
		return false;
}
