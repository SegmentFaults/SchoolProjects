// TrialError.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <iostream>
#include <math.h>
using namespace std;
int main()
{
	int sides;
	cout << "How many sides does your shape have? ";
	cin >> sides;
	if (sides == 3) {
		int height;
		int width;
		cout << "Enter the height ";
		cin >> height;
		cout << "Enter the width ";
		cin >> width;
		cout << "The area is " << .5*width*height<<endl;
	}
	else if (sides == 4) {
		int height;
		int width;
		cout << "Enter the height"<<endl;
		cin >> height;
		cout << "Enter the width"<<endl;
		cin >> width;
		if (width == height) {
			cout << "The area is " << pow(width,2)<<endl;
		}
		else {
			cout << "The area is " << width*height<<endl;
		}

	}
	else {
		cout << "Invalid input."<<endl;
	}
	system("pause");
	return 0;
}

