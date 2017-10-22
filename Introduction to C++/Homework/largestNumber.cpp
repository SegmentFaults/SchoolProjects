// largestNumber.cpp : Defines the entry point for the console application.
//Michael Gentile
//Had a problem doing this without classes and objects.
//This program makes the largest number out of a given series of digits. 

#include "stdafx.h"
#include <iostream>

using namespace std;
int main()
{
	int input, numDigits = 1, copy, result;
	cout << "Enter a number ";
	cin >> input;
	int ones = 0;
	int twos = 0;
	int threes = 0;
	int fours = 0;
	int fives = 0;
	int sixes = 0;
	int sevens = 0;
	int eights = 0;
	int nines = 0;
	int zeros = 0;
	int totalDigits;
	//find how many digits
	copy = input;
	do {
		switch (copy % 10) {
		case 0: ++zeros;
			break;
		case 1: ++ones;
			break;
		case 2: ++twos;
			break;
		case 3: ++threes;
			break;
		case 4: ++fours;
			break;
		case 5: ++fives;
			break;
		case 6: ++sixes;
			break;
		case 7: ++sevens;
			break;
		case 8: ++eights;
			break;
		case 9: ++nines;
			break;
		default:
			break;
		}
		copy /= 10;
		numDigits++;
	}while (copy != 0 && copy % 10 != 0);
	totalDigits = ones + twos + threes + fours + fives + sixes + sevens + eights + nines + zeros;
	while (totalDigits != 0) {
		if (nines != 0) {
			cout << 9;
			nines--;
		}
		else if (eights != 0) {
			cout << 8;
			eights--;
		}
		else if (sevens != 0) {
			cout << 7;
			sevens--;
		}
		else if (sixes != 0) {
			cout << 6;
			sixes--;
		}
		else if (fives != 0) {
			cout << 5;
			fives--;
		}
		else if (fours != 0) {
			cout << 4;
			fours--;
		}
		else if (threes != 0) {
			cout << 3;
			threes--;
		}
		else if (twos != 0) {
			cout << 2;
			twos--;
		}
		else if (ones != 0) {
			cout << 1;
			ones--;
		}
		else {
			cout << 0;
			zeros--;
		}
		totalDigits--;
	}
	cin.clear();
	cin.ignore();
	cin.get();
	return 0;
}

