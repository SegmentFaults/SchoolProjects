// fancyForLoop.cpp : Defines the entry point for the console application.
//Michael Gentile
//This creates a facny for loop.

#include "stdafx.h"
#include <iostream>
using namespace std;

int main()
{
	int spaces = 3;
	int constant = 1;
	//rows
	for (int x = 0; x < 7; x++) {
		//spaces
		for (int y = 0; y < spaces; y++) {
			cout << " ";
		}
		for (int y = 0; y < constant; y++) {
			cout << y + 1;
		}
		for (int y = constant - 1; y > 0; y--) {
			cout << y;
		}
		cout << endl;
		if (x >= 3) {
			constant--;
			spaces++;
		}
		if (x < 3) {
			if (constant != 4) {
				constant++;
			}
			if (spaces != 0) {
				spaces--;
			}
		}

	}
	cin.clear();
	cin.ignore();
	cin.get();
	return 0;
}

