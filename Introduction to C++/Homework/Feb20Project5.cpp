// Feb20Project5.cpp : Defines the entry point for the console application.
//Program 1 for homework 3
//Michael Gentile
//CSE 253 B
#include "stdafx.h"
#include <iostream>
using namespace std;
int* reversed(int array[],int newArray[]);
int main()
{
	int array[6], newArray[6];
	for (int x = 0; x < 6; x++) {
		cout << "Enter a number ";
		cin >> array[x];
	}
	reversed(array, newArray);
	for (int x = 0; x < 6; x++) {
		cout << newArray[x] << endl;
	}
	cout << endl;
	system("pause");
    return 0;
}

int* reversed(int array[], int newArray[])
{
	for (int x = 0; x < 6; x++) {
		newArray[x] = array[5 - x];
	}
	return newArray;
}
