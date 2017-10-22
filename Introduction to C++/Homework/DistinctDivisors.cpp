// DistinctDivisors.cpp : Defines the entry point for the console application.
//prints the divisors of a number
//Michael Gentile

#include "stdafx.h"
#include <iostream>
using namespace std;
int main()
{
	int number = 0;
	cout << "Enter a number" << endl;
	cin >> number;
	for (int i = 1; i <= number; i++)
		if (number%i == 0) {
			cout << i<<endl;
		}
	cin.clear();
	cin.ignore();
	cin.get();
    return 0;
}

