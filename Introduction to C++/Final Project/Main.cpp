//Michael Gentile
//CSE 253B
//Ishmat Zerin
//This work is my own.
#include<iostream>
#include <string>
#include "Person.h"
#include "Course.h"
#include "Administrator.h"
#include "Student.h"
#include "Professor.h"
using namespace std;
int main() {
	int q = 0;
	//import everything
	Administrator::inputCourses();
	Administrator::inputProfessors();
	Administrator::inputStudents();
	//delcare a blank person to cast
	Person p("", "", "", "");
	do {
		cout << "Would you like to 1. login or 2. create an account" << endl;
		cin >> q;
		if (q == 2) {
			string name, username, password, department;
			cout << "What is your name?" << endl;
			cin >> name;
			cout << "What is your username?" << endl;
			cin >> username;
			cout << "What is your password?" << endl;
			cin >> password;
			cout << "What department?" << endl;
			cin >> department;
			Person p(name, username, password, department);
			p.outfile();
			q = 3;
		}
	} while (q!=1);
	string password, username;
	if (q == 1)
	{
		bool auth = false;
		while (!auth) {
		//authorize the account or repeat.
		cout << "What is your username?" << endl;
		cin >> username;
		cout << "What is your password? " << endl;
		cin >> password;
		p.setUsername(username);
		p.setPassword(password);
		auth = p.login(username, password);
	}

		if (auth) {
			int choice = 0;
			while (!(choice == 1 || choice == 2 || choice == 3))
			{
				cout << "Are you a" << endl <<
					"1. Student" << endl <<
					"2. Professor" << endl <<
					"3. Administrator" << endl;
				cin >> choice;
			}
			if (choice == 1) {
				Student s(p.getName(), p.getUsername(), p.getPassword(), p.getDepartment());
				Administrator::students.push_back(s);
				int select = 0;
				do {
					cout << "1. Add course";
					cout << "2. View courses";
					cout << "3. Exit";
					cin >> select;
				
				if (select == 1) {
					cin.ignore();
					string coursename;
					int capacity;
					int number;
					cout << "What is the name of the course you want to add? " << endl;
					getline(cin, coursename);
					cout << "What is the capacity of the class? " << endl;
					cin >> capacity;
					cout << "What is the number of the course? " << endl;
					cin >> number;
					Course c(coursename, number, capacity);
					s.courses.push_back(c);
					Administrator::courses.push_back(c);
				}
				if (select == 2) {
					for (int x = 0; x < s.getCourses().size(); x++) {
						cout << s.getCourses().at(x).getName()<<endl;
					}
				}
				} while (select != 3);
			}
			else if (choice == 2) {
				int select = 0;
				Professor prof(p.getName(), p.getUsername(), p.getPassword(), p.getDepartment());
				Administrator::professors.push_back(prof);
				do {
					cout << "1. Add course";
					cout << "2. View courses";
					cout << "3. Exit";
					cin >> select;
					if (select == 1) {
						cin.ignore();
						string name;
						int cap, num;
						cout << "Enter the name of the course. " << endl;
						getline(cin, name);
						cout << "Enter the capacity." << endl;
						cin >> cap;
						cout << "Enter the course number. " << endl;
						cin >> num;
						Course q(name, num, cap);
						prof.addCourse(q);
						Administrator::courses.push_back(q);
					}
					else if (select == 2) {
						for (int x = 0; x <	prof.getCourses().size(); x++) {
							cout << prof.getCourses().at(x).getName() << endl;
						}
					}
				} while (select != 3);
			}
			else if (choice == 3) {
				int select = 0;
				do {
					cout << "1. Create student"<<endl;
					cout << "2. Create course"<<endl;
					cout << "3. View courses" << endl;
					cout << "4. View students" << endl;
					cout << "5. Exit" << endl;
					cin >> select;
					if (select == 1) {
						cin.ignore();
						string sName, sUName, sPass, sDept;
						cout << "Enter the name. " << endl;
						getline(cin, sName);
						cout << "Enter their username" << endl;
						getline(cin, sUName);
						cout << "Enter their password" << endl;
						getline(cin, sPass);
						cout << "Enter the department" << endl;
						getline(cin,sDept);
						Student q(sName, sUName, sPass, sDept);
						Student::allStudents.push_back(q);
						Administrator::students.push_back(q);
						}
					else if (select == 2) {
						cin.ignore();
						string name;
						int cap, num;
						cout << "Enter the name of the course. " << endl;
						getline(cin, name);
						cout << "Enter the capacity." << endl;
						cin >> cap;
						cout << "Enter the course number. " << endl;
						cin >> num;
						Course q(name, num, cap);
						Course::allCourses.push_back(q);
						Administrator::courses.push_back(q);
					}
					else if (select == 3) {
						for (int x = 0; x < Administrator::courses.size(); x++) {
							cout << Administrator::courses.at(x).getName() << endl;
						}
					}
					else if (select == 4) {
						for (int x = 0; x < Administrator::students.size(); x++) {
							cout << Administrator::students.at(x).getName() << endl;
						}
					}
				} while (select != 5);
			}
			Administrator::outputStudents();
			Administrator::outputCourses();
			Administrator::outputProfessors();
			
			cout << "Thank you for using my program.";
		}
	}
	char z;
	cin >> z;
	return 0;
}