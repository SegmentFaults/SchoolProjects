// VowelOrConsonant.cpp : Defines the entry point for the console application.
//Michael Gentile
//This states whether there is a vowel or consonant

#include "stdafx.h"
#include <iostream>
using namespace std;
int main()
{
	char vowels[] = { 'a','e','i','o','u','A','E','I','O','U' };
	char entry;
	cout << "Enter a vowel or consonant "<<endl;
	cin >> entry;
	cout << endl;
	int entryInt = (int)entry;
	cout << entryInt << endl;
	if (entryInt > 64 && entry < 91) {
	}
	else if (entryInt > 96 && entryInt < 123) {
	}
	else {
		cout << "This is invalid. ";
		cin.clear();
		cin.ignore();
		cin.get();
		
		return 0;
	}
	for (int x = 0; x < 10; x++) {
		if (entry == vowels[x]) {
			cout << "This is a vowel";
			break;
		}
		if (x == 9) {
			cout << "This is a consonant";
		}
	}
	cin.clear();
	cin.ignore();
	cin.get();
    return 0;
}

