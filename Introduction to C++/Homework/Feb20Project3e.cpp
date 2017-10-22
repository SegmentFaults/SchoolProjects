// Feb20Project3e.cpp : Defines the entry point for the console application.
//Program 3 for homework 3
//Michael Gentile
//CSE 253 B

#include "stdafx.h"
#include <iostream>
#include <string>
using namespace std;
int main()
{
	string test;
	string secondTest;
	cout << "Input a first string"<<endl;
	getline(cin,test);
	cout << "Input a second string" << endl;
	getline(cin, secondTest);

	int location=0;
	bool found = false;
	for (int x = 0; x < test.length() && !found; x++) {
			if (test.at(x) == secondTest.at(0) && x+secondTest.length()<=test.length()) {
				found = true;
				for (int z = 0; z < secondTest.length(); z++) {
					if (test.at(x + z) != secondTest.at(z)) {
						found = false;
					}
				}
				if (found) {
					location = x;
				}
				
				break;
			}
	}
	if (found)
		cout << location+1 << endl;
	else
		cout << "No substring" << endl;
	system("pause");
    return 0;
}

