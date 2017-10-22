// Feb20Problem1.cpp : Defines the entry point for the console application.
//Program 1 for homework 3
//Michael Gentile
//CSE 253 B

#include "stdafx.h"
#include <iostream>
using namespace std;
int main()
{
	int sum = 0;
	for (int x = 1; x < 16; x += 2) {
		sum +=x;
	}
	cout << sum<<endl;
	system("pause");
    return 0;
}

