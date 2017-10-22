// Feb20Problem2.cpp : Defines the entry point for the console application.
//Program 1 for homework 3
//Michael Gentile
//CSE 253 B

#include "stdafx.h"
#include <iostream>
#include <string>
using namespace std;
int main()
{
	string s="This should have four spaces.";
	const char space = ' ';
	int spaceCount = 0;
	for (int x = 0; x < s.length(); x++) {
		char g = s.at((int)x);
		if (g==space) {
			spaceCount++;
		}
		
	}
	cout << spaceCount<<endl;
	system("pause");
    return 0;
}

