// Feb20Project4.cpp : Defines the entry point for the console application.
//Program 1 for homework 3
//Michael Gentile
//CSE 253 B

#include "stdafx.h"
#include <string>
#include <iostream>
using namespace std;
int main()
{
	bool palin = true;
	string check;
	cout << "Input a string ";
	cin >> check;
	for (int x = 0; x < check.length(); x++) {
			if (check.at(x) != check.at(check.length()-x-1)) {
				palin = false;
		}
	}
	if (palin)
		cout << endl << "true"<<endl;
	else {
		cout << endl << "false"<<endl;
	}
	system("pause");
    return 0;

}

