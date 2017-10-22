// DistanceFormula.cpp : Defines the entry point for the console application.
//This calculates the distance between two points.
//Michael Gentile

#include "stdafx.h"
#include <iostream>
#include "math.h"
using namespace std;
int main()
{
	double x1, x2, y1, y2;
	cout << "Input the first x "<<endl;
	cin >> x1;
	cout << "Input the first y "<<endl;
	cin >> y1;
	cout << "Input the second x "<<endl;
	cin >> x2;
	cout << "Input the second y "<<endl;
	cin >> y2;
	double distance = sqrt(pow((x1 - x2), 2) + (pow((y1 - y2), 2)));
	cout << distance;
	cin.clear();
	cin.ignore();
	cin.get();
    return 0;
}

