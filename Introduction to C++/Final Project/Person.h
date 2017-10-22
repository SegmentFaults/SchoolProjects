#pragma once
#include <string>
//class Person;
class Course;
class Administrator;
class Professor;
class Student;
using namespace std;
class Person
{

public:
	Person(string name, string username, string password, string department);
	void setDepartment(string department);
	void setName(string name);
	void setUsername(string username);
	void setPassword(string password);
	string getPassword();
	string getName();
	string getUsername();
	string getDepartment();
	void outfile();
	bool operator==(const Person &other) const;
	bool login(string username, string password);
//	static vector<Person> allPeople;
private:
	string name;
	string department;
	string password;
	string username;
};