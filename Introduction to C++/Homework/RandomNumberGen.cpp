// RandomNumberGen.cpp : Defines the entry point for the console application.
//Michael Gentile
//This is chopsticks.

#include "stdafx.h"
#include <iostream>
#include <stdlib.h>     
#include <time.h>       
using namespace std;

int main()
{
	char exit;
	srand(time(NULL));
	do {
	int r = rand() % 1000 +1;
	int guess;
	do {
		cout<<"Guess a number (1 to 1000): "<<endl;
		cin >> guess;
		if (r < guess) {
			cout<<"The secret number is lower"<<endl;
		}
		else if(r > guess) {
			cout<<"The secret number is higher"<<endl;
		} 
	} while (r != guess);
	cout << "You have guessed correctly. ";
	cout << "If you would like to quit press n, otherwise hit anything ";
	cin >> exit;
	} while (exit != 'n');

	cin.clear();
	cin.ignore();
	cin.get();
    return 0;
}

